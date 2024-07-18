package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public class ValidatingFileRecordReader implements FileRecordReader {

	private final FileRecordReader reader;
	
	public ValidatingFileRecordReader(FileRecordReader reader) {
		this.reader = reader;
	}
	
	@Override
	public List<DigitalTwinRecord> readEntries(Path path) throws Exception {
		Set<String> testSet = new HashSet<>();
		List<DigitalTwinRecord> records = reader.readEntries(path);
		for (DigitalTwinRecord eachRecord : records) {
			String identifier = eachRecord.uniqueId();
			if (testSet.contains(identifier)) {
				throw new IllegalArgumentException(String.format("The provided resource '%s' contains a duplicate entry: %s", path.getFileName(), identifier));
			} else {
				testSet.add(identifier);
			}
		}
		return records;
	}

}
