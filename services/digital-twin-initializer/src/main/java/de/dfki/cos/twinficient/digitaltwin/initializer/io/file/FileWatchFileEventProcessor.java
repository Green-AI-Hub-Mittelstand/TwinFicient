package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Logger;

public  final class FileWatchFileEventProcessor implements FileEventProcessor {

	private final Path folderPath;
	private final FileChangedListener listener;

	private final Logger logger = Logger.getLogger(FileEventProcessor.class.getName());
	
	public FileWatchFileEventProcessor(Path folderPath, FileChangedListener listener) {
		this.folderPath = folderPath;
		this.listener = listener;
	}

	@Override
	public void processEvents() throws Exception {
		logger.fine("Registering for file events.");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		WatchKey watchKey = folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		do {
			pollEvents(watchKey);
			watchKey.reset();
		} while (true);		
	}

	private void pollEvents(WatchKey watchKey) throws Exception {
		for (WatchEvent<?> event : watchKey.pollEvents()) {
			handleEvent(event);
		}
	}

	private void handleEvent(WatchEvent<?> event) throws Exception {
		Kind<?> kind = event.kind();
		Path subPath = (Path) event.context();
		
		Path filePath = folderPath.resolve(subPath);
		
		if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
			listener.onCreate(filePath);
		} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
			listener.onUpdate(filePath);
		} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
			listener.onDelete(filePath);
		}
	}
}