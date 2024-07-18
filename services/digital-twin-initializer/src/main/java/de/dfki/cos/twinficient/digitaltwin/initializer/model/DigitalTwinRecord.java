package de.dfki.cos.twinficient.digitaltwin.initializer.model;

public interface DigitalTwinRecord {

	String getRealm();
	
	String uniqueId();

	String get(DigitalTwinRecordFieldIdentifier key);

}
