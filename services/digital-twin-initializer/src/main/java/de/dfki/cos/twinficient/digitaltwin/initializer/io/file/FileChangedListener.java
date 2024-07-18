package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.nio.file.Path;

public interface FileChangedListener {

	void onCreate(Path path) throws Exception;

	void onUpdate(Path path) throws Exception;

	void onDelete(Path path) throws Exception;
}
