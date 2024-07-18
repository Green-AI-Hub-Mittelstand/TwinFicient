package de.dfki.cos.twinficient.digitaltwin.initializer.model;

public class BasyxRecordUnknownException extends RuntimeException {

	private static final String TEMPLATE = "Basyx record '%s' unknown.";
	private static final long serialVersionUID = 1L;

	
	public BasyxRecordUnknownException(BasyxIdentifier record) {
		super(String.format(TEMPLATE, recordName(record)));
	}


	public BasyxRecordUnknownException(String type) {
		super(String.format(TEMPLATE, type));
	}


	private static String recordName(BasyxIdentifier record) {
		if (record == null) {
			return null;
		}
		return record.getClass().getName();
	}
	
}
