package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

@FunctionalInterface
public interface RecordFactory {
	
	DigitalTwinRecord fromCsvEntry(String realm, String[] values);
	
}