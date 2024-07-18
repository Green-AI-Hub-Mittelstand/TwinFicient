package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.io.Reader;
import java.util.List;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public interface RecordReader {

	List<DigitalTwinRecord> readEntries(String realm, Reader reader) throws Exception;

}
