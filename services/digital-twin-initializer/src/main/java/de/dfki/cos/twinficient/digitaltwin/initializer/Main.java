package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.domain.WriteConsistency;

import de.dfki.cos.twinficient.digitaltwin.initializer.builder.BasyxResourceBuilder;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.IdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.control.storage.DigitalTwinInitializer;
import de.dfki.cos.twinficient.digitaltwin.initializer.influx.InvalidatingDigitalTwinServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.CsvFileRecordReader;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileEventProcessorFactory;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileNameRealmTokenGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileRecordReader;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.RealmTokenGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.BasyxV3Apis;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.BasyxV3HttpServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.DigitalTwinServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.storage.LocalStorage;
import okhttp3.OkHttpClient;

public class Main {

	private static final String ENV_TF_CONFIG_FOLDER = "TF_CONFIG_FOLDER";
	private static final String ENV_TF_AAS_REPO_ADDRESS = "TF_AAS_REPO_ADDRESS";
	private static final String ENV_TF_SM_REPO_ADDRESS = "TF_SM_REPO_ADDRESS";
	private static final String ENV_TF_POLLING_INTERVAL_MILLIS = "TF_POLLING_INTERVAL_MILLIS";
	private static final String ENV_TF_USE_FILE_POLLING = "TF_USE_FILE_POLLING";
	private static final String ENV_TF_LOG_LEVEL = "TF_LOG_LEVEL";
	private static final String ENV_INFLUX_BUCKET = "TF_INFLUX_BUCKET";
	private static final String ENV_INFLUX_ORG = "TF_INFLUX_ORG";
	private static final String ENV_INFLUX_TOKEN = "TF_INFLUX_TOKEN";
	private static final String ENV_INFLUX_URL = "TF_INFLUX_URL";

	static {
		String logLevel = System.getenv(ENV_TF_LOG_LEVEL);
		if (logLevel != null) {
			Level level = Level.parse(logLevel);
			LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(level);
		}
	}

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws Exception {

		java.util.logging.Logger.getLogger(Main.class.getName()).setLevel(java.util.logging.Level.INFO);
		Path folderPath = getFolderPathFromArgs(ENV_TF_CONFIG_FOLDER);
		String shellRepoServiceAddress = getServiceAddress(ENV_TF_AAS_REPO_ADDRESS);
		String submodelRepoServiceAddress = getServiceAddress(ENV_TF_SM_REPO_ADDRESS);
		String bucketName = System.getenv(ENV_INFLUX_BUCKET);
		String token = System.getenv(ENV_INFLUX_TOKEN);
		String org = System.getenv(ENV_INFLUX_ORG);

		LOGGER.info("Creating DigitalTwins from CSV files from folder: " + folderPath.toString());
		LOGGER.info("Shell repository: " + shellRepoServiceAddress);
		LOGGER.info("Submodel repository: " + submodelRepoServiceAddress);

		RealmTokenGenerator tokenGenerator = new FileNameRealmTokenGenerator();
		FileRecordReader reader = new CsvFileRecordReader(tokenGenerator, TwinficientRecord::fromCsvEntry);

		LocalStorage inMemoryStorage = new TwinficientInMemoryLocalStorage();

		DigitalTwinServiceFacade serviceFacade = createServiceFacade(shellRepoServiceAddress, submodelRepoServiceAddress);
		
		if (bucketName != null && org != null && token != null) {
			LOGGER.info("Using invalidating service facade for bucket " + bucketName);
			String url = getServiceAddress(ENV_INFLUX_URL);
			OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder()
				    .connectTimeout(30, TimeUnit.SECONDS)
				    .readTimeout(20, TimeUnit.SECONDS)
				    .writeTimeout(40, TimeUnit.SECONDS);
			InfluxDBClient client = InfluxDBClientFactory.create(InfluxDBClientOptions.builder().authenticateToken(token.toCharArray()).url(url).org(org).okHttpClient(okHttpClientBuilder).build());
			serviceFacade = new InvalidatingDigitalTwinServiceFacade(serviceFacade, client, bucketName, org);
		} else {
			LOGGER.info("Using default serviceFacade");
		}

		DigitalTwinInitializer initializer = new DigitalTwinInitializer(inMemoryStorage, serviceFacade, reader);

		FileEventProcessorFactory factory = new EnvBasedFileEventProcessorFactory(ENV_TF_USE_FILE_POLLING, ENV_TF_POLLING_INTERVAL_MILLIS);

		Set<String> requiredRealms = Files.list(folderPath).map(tokenGenerator::realmForPath).collect(Collectors.toSet());
		;

		initializer.initializeLocalStorage(requiredRealms);
		initializer.register(folderPath, factory);
	}

	private static String getEnv(String envName) {
		String env = System.getenv(envName);
		if (env == null) {
			throw new IllegalArgumentException("Environment variable '" + envName + "' not set.");
		}
		return env;
	}

	private static String getServiceAddress(String envName) {
		String url = getEnv(envName);
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("Not a valid server URL:" + url);
		}
		return url;
	}

	private static Path getFolderPathFromArgs(String envName) {
		String configFolder = getEnv(envName);
		Path path = Path.of(configFolder);
		if (Files.isDirectory(path)) {
			return path;
		} else {
			throw new IllegalArgumentException("The specified path '" + configFolder + "' is not a directory.");
		}
	}

	private static DigitalTwinServiceFacade createServiceFacade(String shellRepoAddress, String submodelRepoAddress) {
		IdGenerator idGenerator = new TwinficientIdGenerator();
		BasyxV3Apis apis = new BasyxV3Apis(shellRepoAddress, submodelRepoAddress);
		BasyxResourceBuilder builder = new TwinficientResourceBuilder(idGenerator);
		return new BasyxV3HttpServiceFacade(apis, builder, idGenerator);
	}
}
