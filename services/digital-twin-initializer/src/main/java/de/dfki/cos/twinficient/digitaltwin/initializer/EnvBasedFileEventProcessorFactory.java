package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileChangedListener;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileEventProcessor;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileEventProcessorFactory;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileWatchFileEventProcessor;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.PollingFileEventProcessor;

public class EnvBasedFileEventProcessorFactory implements FileEventProcessorFactory {

	private static final int DEFAULT_POLLING_INTERVAL = 5000;

	private final String usePollingEnvName;
	private final String pollingIntervalEnvName;

	private final Logger logger = Logger.getLogger(EnvBasedFileEventProcessorFactory.class.getName());
	
	public EnvBasedFileEventProcessorFactory(String usePollingEnvName, String pollingIntervalEnvName) {
		this.usePollingEnvName = usePollingEnvName;
		this.pollingIntervalEnvName = pollingIntervalEnvName;
	}
	
	@Override
	public FileEventProcessor createFor(Path folderPath, FileChangedListener listener) throws IOException {
		
		if (isUsePolling()) {
			long pollingInterval = getPollingIntervalMillis();
			logger.fine("Choosing polling-based reader with polling interval " + pollingInterval);
			return new PollingFileEventProcessor(folderPath, listener, pollingInterval);
		} 
		logger.fine("Choosing file-watch reader.");
		return new FileWatchFileEventProcessor(folderPath, listener);
	}

	private boolean isUsePolling() {
		String usePolling = System.getenv(usePollingEnvName);
		return usePolling != null && Boolean.parseBoolean(usePolling);
	}
	
	private long getPollingIntervalMillis() {
		String pollingMillis = System.getenv(pollingIntervalEnvName);
		if (pollingMillis == null ) {
			return DEFAULT_POLLING_INTERVAL;
		}
		return Long.parseLong(pollingMillis);
	}

}
