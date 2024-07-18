package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class PollingFileEventProcessor implements FileEventProcessor {

	private final Path folderPath;
	private final FileChangedListener listener;

	private Map<Path, FileTime> fileTimes;

	private final long pollInterval;

	private final Logger logger = Logger.getLogger(FileEventProcessor.class.getName());

	public PollingFileEventProcessor(Path folderPath, FileChangedListener listener, long pollInterval) throws IOException {
		this.folderPath = folderPath;
		this.listener = listener;
		fileTimes = resolveFileTimes();
		logger.fine("Initial files: " + fileTimes.keySet());
		this.pollInterval = pollInterval;
	}

	private Map<Path, FileTime> resolveFileTimes() throws IOException {

		return Files.list(folderPath).filter(this::isCsvFile).collect(Collectors.toMap(Function.identity(), this::getLastModifiedTime));
	}

	private boolean isCsvFile(Path path) {
		return path.toString().endsWith(".csv");
	}

	private FileTime getLastModifiedTime(Path path) {
		try {
			return Files.getLastModifiedTime(path);
		} catch (IOException e) {
			logger.warning("Failed to read last modified time for " + path);
			return null;
		}
	}

	@Override
	public void processEvents() throws Exception {
		while (true) {
			Thread.sleep(pollInterval);
			logger.finer("Polling for file changes.");
			checkAndUpdateFileTimes();
		}
	}

	private void checkAndUpdateFileTimes() throws Exception {
		Map<Path, FileTime> times = resolveFileTimes();
		for (Entry<Path, FileTime> eachEntry : times.entrySet()) {
			Path path = eachEntry.getKey();
			FileTime current = eachEntry.getValue();
			FileTime previous = fileTimes.get(path);
			if (previous == null) {
				logger.finer("On file created:" + path);
				listener.onCreate(path);
			} else if (!Objects.equals(current, previous)) {
				logger.finer("On file updated:" + path);
				listener.onUpdate(path);
			}
		}
		for (Entry<Path, FileTime> eachEntry : fileTimes.entrySet()) {
			Path path = eachEntry.getKey();
			if (!times.containsKey(path)) {
				logger.finer("On file deleted:" + path);
				listener.onDelete(path);
			}
		}
		this.fileTimes = times;
	}
}