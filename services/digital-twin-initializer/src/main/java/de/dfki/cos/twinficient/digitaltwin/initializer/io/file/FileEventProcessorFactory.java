package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.io.IOException;
import java.nio.file.Path;

public interface FileEventProcessorFactory {

	FileEventProcessor createFor(Path folderPath, FileChangedListener router) throws IOException;
	
	
}
