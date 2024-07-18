package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public  class CsvFileRecordReader extends CsvRecordReader implements FileRecordReader{

	private final RealmTokenGenerator realmGenerator;
	private final Logger logger = Logger.getLogger(CsvFileRecordReader.class.getName());

	public CsvFileRecordReader(RealmTokenGenerator generator, RecordFactory factory) {
		this(generator, factory, true);
	}
	
	public CsvFileRecordReader(RealmTokenGenerator generator, RecordFactory factory, boolean skipHeader) {
		super(factory, skipHeader);
		this.realmGenerator = generator;
	}

	
	@Override
	public List<DigitalTwinRecord> readEntries(Path path) throws Exception {
		logger.info("Reading csv file " + path);
		String realm = realmGenerator.realmForPath(path);
		try (BufferedReader bReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			return readEntries(realm, bReader);
		}
	}
	
	}
