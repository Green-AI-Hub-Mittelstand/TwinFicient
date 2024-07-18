package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecordFieldIdentifier;

public interface DigitalTwinArrayRecord {

	String getRealm();
	
	String uniqueId();

	String get(DigitalTwinRecordFieldIdentifier key);

}
