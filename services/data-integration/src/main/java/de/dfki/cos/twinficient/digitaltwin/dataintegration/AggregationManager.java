package de.dfki.cos.twinficient.digitaltwin.dataintegration;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.influxdb.client.BucketsApi;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.OrganizationsApi;
import com.influxdb.client.QueryApi;
import com.influxdb.client.TasksApi;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteOptions;
import com.influxdb.client.domain.Bucket;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.Task;
import com.influxdb.client.domain.TaskStatusType;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.aggregation.DataAggregationTask;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.aggregation.LiveDataIntegrationTask;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.building.VirtualBuildingProvider;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.AggregateConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.DataIntegrationConfig;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.EnvironmentBasedAasProviderConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.EnvironmentBasedDataIntegrationConfig;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.EnvironmentBasedTemplateFileConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.LiveDataConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.ProcessConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.TemplateFileConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.TwinficientConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.digitaltwin.AasVirtualBuildingProvider;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.publish.LoggingDataPointPublisher;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.publish.MultiTargetDataPointPublisher;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.publish.TargetDataPublisher;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.query.QueryTemplate;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.AggregationTask;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.AggregationTaskManager.LiveDataInfo;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.AggregationTaskManager.TwinficientInfo;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.DaywiseTimeAggregationTaskAdapter;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.time.TimeQuery;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.time.TimeQuery.RecordInterval;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;

public class AggregationManager {

	private Logger logger = Logs.getLogger(AggregationManager.class);
	
	private QueryTemplate timeTemplate = QueryTemplate.fromFile(new EnvironmentBasedTemplateFileConfiguration(), "recordInterval.flux");
	
	public static void main(String[] args) throws InterruptedException {
		AggregationManager manager = new AggregationManager();
		manager.startAggregation();
	}

	public void startAggregation() throws InterruptedException {
		
		DataIntegrationConfig config = new EnvironmentBasedDataIntegrationConfig();

		TwinficientConfiguration tfConf = config.getTwinficientConfiguration();
		InfluxDBClient twinficientClient = getTwinficientClient(tfConf);

		initializeTarget(config, twinficientClient);

		Optional<LiveDataInfo> liveDataInfoOpt = config.getLiveDataConfiguration().map(this::getLiveDataInfo);
		TwinficientInfo tfInfo = getTwinficientInfo(tfConf, twinficientClient);
		AggregateConfiguration aggrConf = config.getAggregateConfiguration();
		
		TwinficientInfo aggrInfo = new TwinficientInfo(tfInfo.getQueryApi(), tfInfo.getWriteApi(), aggrConf.getAggregationBucket(), tfInfo.getOrg());
		TwinficientInfo scoreInfo = new TwinficientInfo(tfInfo.getQueryApi(), tfInfo.getWriteApi(), aggrConf.getScoreBucket(), tfInfo.getOrg());
		
		ProcessConfiguration pConf = config.getProcessConfiguration();
		Duration fetchFrequency = pConf.getFetchFrequency();

		LoggingDataPointPublisher loggingDataPublisher = new LoggingDataPointPublisher();
		
		TargetDataPublisher twinficientPublisher = new TargetDataPublisher(tfInfo.getWriteApi(), tfInfo.getBucket(), tfInfo.getOrg()); 
		TargetDataPublisher aggregatesPublisher = new TargetDataPublisher(aggrInfo.getWriteApi(), aggrInfo.getBucket(), aggrInfo.getOrg());
		TargetDataPublisher scorePublisher = new TargetDataPublisher(scoreInfo.getWriteApi(), scoreInfo.getBucket(), scoreInfo.getOrg());
		
		TemplateFileConfiguration templateConf = new EnvironmentBasedTemplateFileConfiguration();
		
		AggregationTask liveDataTask;
		if (liveDataInfoOpt.isEmpty()) {
			logger.warning("No Live data mapping configured");
			liveDataTask = (s,e)->{};
		} else {
			LiveDataInfo liveDataInfo = liveDataInfoOpt.get();
			liveDataTask = new LiveDataIntegrationTask(liveDataInfo, new MultiTargetDataPointPublisher(loggingDataPublisher, twinficientPublisher), fetchFrequency, templateConf);
		}
		VirtualBuildingProvider vbProvider = new AasVirtualBuildingProvider(new EnvironmentBasedAasProviderConfiguration());
		
		DataAggregationTask dataAggrTask = new DataAggregationTask(tfInfo
				, new MultiTargetDataPointPublisher(loggingDataPublisher, aggregatesPublisher)
				, new MultiTargetDataPointPublisher(loggingDataPublisher, scorePublisher), vbProvider, templateConf);
				
		sleep(System.currentTimeMillis(), pConf.getStartUpDelay());
		

		Optional<RecordInterval> liveRecordIntervalOpt = liveDataInfoOpt.flatMap(this::getLiveRecordInterval);
		
		AggregationStepManager liveStepManager = new AggregationStepManager(liveDataTask);
		AggregationStepManager aggregationStepManager = new AggregationStepManager(new DaywiseTimeAggregationTaskAdapter(dataAggrTask, config.getAggregateConfiguration().getAggregationDelay()));
		
		while (true) {
			long start = System.currentTimeMillis();
		
			Optional<RecordInterval> twinficientRecordIntervalOpt = getTwinficientRecordInterval(tfInfo); // query again
			Optional<RecordInterval> aggregatesRecordIntervalOpt = getAggregateRecordInterval(scoreInfo);
			
			aggregationStepManager.process(twinficientRecordIntervalOpt, aggregatesRecordIntervalOpt);			
			twinficientRecordIntervalOpt = getTwinficientRecordInterval(tfInfo);
			
			liveStepManager.process(liveRecordIntervalOpt, twinficientRecordIntervalOpt);
			
			long stop = System.currentTimeMillis();
			long total = stop - start;
			logger.fine("Processing step tooked " + total / 1000 / 60 + "m" + total / 1000 % 60 + "s" + total % 1000 + "ms");
			
			sleep(start, fetchFrequency);
		}
	}

	private void sleep(long start, Duration interval) throws InterruptedException {
		long end = System.currentTimeMillis();
		long toSleep = interval.toMillis() - (end - start);
		if (toSleep > 0) {
			logger.fine("Sleep " + toSleep + " ms");
			Thread.sleep(toSleep);
		}
	}

	private void initializeTarget(DataIntegrationConfig config, InfluxDBClient toClient) {
		ProcessConfiguration pConf = config.getProcessConfiguration();
		if (pConf.isDisableTasks()) {
			disableTasks(toClient);
		}

		AggregateConfiguration aConf = config.getAggregateConfiguration();
		String aggregationBucket = aConf.getAggregationBucket();
		String scoreBucket = aConf.getScoreBucket();

		createBuckets(new String[] { aggregationBucket, scoreBucket }, config.getTwinficientConfiguration().getOrg(), toClient);
	}

	private void disableTasks(InfluxDBClient toClient) {
		TasksApi api = toClient.getTasksApi();
		for (Task eachTask : api.findTasks()) {
			logger.info("Disabling Task " + eachTask.getName());
			eachTask.setStatus(TaskStatusType.INACTIVE);
			api.updateTask(eachTask);
			logger.info("TASK disabled");
		}
	}

	private void createBuckets(String[] buckets, String org, InfluxDBClient client) {
		OrganizationsApi orgApi = client.getOrganizationsApi();
		String orgId = orgApi.findOrganizations().stream().filter(o -> org.equals(o.getName())).map(Organization::getId).findAny().orElseThrow(() -> new RuntimeException("Org could not be resolved:" + org));
		BucketsApi api = client.getBucketsApi();
		for (String eachName : buckets) {
			Bucket bucket = api.findBucketByName(eachName);
			if (bucket == null) {
				api.createBucket(eachName, orgId);
			}
		}
	}

	private LiveDataInfo getLiveDataInfo(LiveDataConfiguration config) {
		InfluxDBClient fromClient = getRemoteLiveClient(config);
		QueryApi fromApi = fromClient.getQueryApi();
		return new LiveDataInfo(fromApi, config.getBucket(), config.getOrg());
	}

	private TwinficientInfo getTwinficientInfo(TwinficientConfiguration config, InfluxDBClient client) {
		QueryApi queryApi = client.getQueryApi();
		WriteApi writeApi = client.makeWriteApi(WriteOptions.builder().batchSize(200).flushInterval(1000).maxRetries(20).writeScheduler(Schedulers.single()).build());
		return new TwinficientInfo(queryApi, writeApi, config.getBucket(), config.getOrg());
	}

	private InfluxDBClient getRemoteLiveClient(LiveDataConfiguration config) {
		return getClient(config.getOrg(), config.getToken(), config.getUrl());
	}

	private InfluxDBClient getTwinficientClient(TwinficientConfiguration config) {
		return getClient(config.getOrg(), config.getToken(), config.getUrl());
	}

	private InfluxDBClient getClient(String org, String token, String url) {
		logger.info("Creating client for " + org + " and URL " + url);
		OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(40, TimeUnit.SECONDS).writeTimeout(40, TimeUnit.SECONDS);
		return InfluxDBClientFactory.create(InfluxDBClientOptions.builder().authenticateToken(token.toCharArray()).url(url).org(org).okHttpClient(okHttpClientBuilder).build()).enableGzip();
	}

	protected Optional<RecordInterval> getTwinficientRecordInterval(TwinficientInfo info) {
		return new TimeQuery(info.getQueryApi(), timeTemplate).getRecordTimeInfo(info.getBucket(), Measurements.CELESTRA, "HgRT");
	}

	protected Optional<RecordInterval> getLiveRecordInterval(LiveDataInfo liveInfo) {
		return new TimeQuery(liveInfo.getQueryApi(), timeTemplate).getRecordTimeInfo(liveInfo.getBucket(), Measurements.CELESTRA, "OutTemp");
	}

	protected Optional<RecordInterval> getAggregateRecordInterval(TwinficientInfo tfInfo) {
		return new TimeQuery(tfInfo.getQueryApi(), timeTemplate).getRecordTimeInfo(tfInfo.getBucket(), Measurements.AGGREGATES, Fields.DEGREE_DAYS_IN_INTERVAL);
	}

	private static final class AggregationStepManager {

		private static final Logger LOGGER = Logs.getLogger(AggregationStepManager.class);

		private final AggregationTask task;

		private AggregationStepManager(AggregationTask task) {
			this.task = task;
		}

		public void process(Optional<RecordInterval> srcIntervalOpt, Optional<RecordInterval> targetIntervalOpt) {
			if (srcIntervalOpt.isEmpty()) {
				LOGGER.fine("No data until now");
			} else if (targetIntervalOpt.isEmpty()) {
				RecordInterval srcInterval = srcIntervalOpt.get();
				Instant from = srcInterval.getFrom();
				Instant to = srcInterval.getTo();
				LOGGER.fine("Move all data from " + from + " to " + to);
				task.aggregateFrom(from, to);
			} else {
				RecordInterval srcInterval = srcIntervalOpt.get();
				RecordInterval targetInterval = targetIntervalOpt.get();
				Instant srcStart = srcInterval.getFrom();
				Instant srcEnd = srcInterval.getTo();
				Instant targetEnd = targetInterval.getTo();
				Instant from;
				if (srcStart.isBefore(targetEnd)) {
					from = targetEnd;
				} else {
					from = srcStart;
				}
				LOGGER.fine("Move remaining data from " + from + " to " + srcEnd);
				task.aggregateFrom(from, srcEnd);
			}
		}
	}
}