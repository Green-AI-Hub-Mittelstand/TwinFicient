package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.nio.file.Path;
import java.util.List;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public interface FileRecordReader {

	List<DigitalTwinRecord> readEntries(Path path) throws Exception;

}
