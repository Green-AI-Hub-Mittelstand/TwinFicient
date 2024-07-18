package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.Arrays;
import java.util.logging.Logger;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecordFieldIdentifier;

public class TwinficientRecord implements DigitalTwinRecord {

	public static final int COMPANY = 0;

	private final String realm;
	private final String[] csvRecord;
	

	private static final Logger LOGGER = Logger.getLogger(DeleteAll.class.getName());

	private TwinficientRecord(String realm, String[] csvEntry) {
		this.realm = realm;
		this.csvRecord = csvEntry;
	}

	@Override
	public String getRealm() {
		return realm;
	}

	public static TwinficientRecord fromCsvEntry(String realm, String[] csvEntry) {
		validateCsvEntry(csvEntry);
		return new TwinficientRecord(realm, csvEntry);
	}

	private static void validateCsvEntry(String[] csvEntry) {
		if (csvEntry.length != 8) {
			throw new RuntimeException("8 Csv entries expected per line, but was " + csvEntry.length);
		}
		for (String each : csvEntry) {
			if (each == null || each.isBlank()) {
				LOGGER.warning("Not all entries set: " + Arrays.toString(csvEntry));
			}
		}
	}

	@Override
	public int hashCode() {
		return uniqueId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwinficientRecord other = (TwinficientRecord) obj;
		return Arrays.equals(this.csvRecord, other.csvRecord);
	}

	@Override
	public String toString() {
		return "DigitalTwinRecord [" + Arrays.toString(csvRecord) + "]";
	}

	@Override
	public String uniqueId() {
		return String.format("%s/%s/%s/%s/%s", realm, get(TwinficientRecordFieldIdentifier.COMPANY), get(TwinficientRecordFieldIdentifier.CEL_NR), get(TwinficientRecordFieldIdentifier.HZ_NR), get(TwinficientRecordFieldIdentifier.HG_NR));
	}

	@Override
	public String get(DigitalTwinRecordFieldIdentifier key) {
		switch ((TwinficientRecordFieldIdentifier)key) {
		case COMPANY:
			return csvRecord[0];
		case CEL_NR:
			return csvRecord[1];
		case HZ_NR:
			return csvRecord[2];
		case HG_NR:
			return csvRecord[3];
		case BUILDING:
			return csvRecord[4];
		case VIRTUAL_BUILDING:
			return csvRecord[5];
		case PERFORMANCE:
			return csvRecord[6];
		case DEVICE_TYPE:
			return csvRecord[7];
		default:
			throw new IllegalArgumentException("" + key);
		}
	}
}
