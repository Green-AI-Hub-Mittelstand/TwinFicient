package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.opencsv.CSVReader;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public  class CsvRecordReader implements RecordReader {

	
	private final RecordFactory factory;
	private final Logger logger = Logger.getLogger(CsvRecordReader.class.getName());
	private final boolean skipHeader;

	public CsvRecordReader(RecordFactory factory) {
		this(factory, true);
	}
	
	public CsvRecordReader(RecordFactory factory, boolean skipHeader) {	
		this.factory = factory;
		this.skipHeader = skipHeader;
	}

	@Override
	public List<DigitalTwinRecord> readEntries(String realm, Reader reader) throws Exception {		
		List<DigitalTwinRecord> records = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(reader)) {
			skipHeader(csvReader);
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				DigitalTwinRecord record = factory.fromCsvEntry(realm, values);
				records.add(record);
			}
		}
		logger.info("Parsed " + records.size() + " entries for realm " + realm);
		return records;
	}

	private void skipHeader(CSVReader csvReader) throws IOException {
		if (skipHeader) {
			csvReader.skip(1);
		}		
	}	
}
