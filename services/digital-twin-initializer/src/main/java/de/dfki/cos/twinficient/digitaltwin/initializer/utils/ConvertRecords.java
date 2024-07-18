package de.dfki.cos.twinficient.digitaltwin.initializer.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class ConvertRecords {
	
	private static final Logger LOGGER = Logger.getLogger(ConvertRecords.class.getName());
	
	public static void main(String[] args) throws IOException, CsvValidationException {
		Path folderPath = Path.of(args.length == 0 ? "./config/origin" : args[0]);
		Path outputFolderPath = Path.of(args.length == 0 ? "./config/byCompany" : args[0]);
		if (!Files.isDirectory(folderPath)) {
			throw new RuntimeException();
		}
		List<Path> pathList = Files.list(folderPath).collect(Collectors.toList());
		for (Path eachPath : pathList) {
			ConvertRecords.convertFiles(eachPath, outputFolderPath);
		}
		
	}

	private static void convertFiles(Path path, Path outputFolder) throws IOException, CsvValidationException {
		if (!path.toFile().getName().endsWith(".csv")) {
			return;
		}
		LOGGER.info("Converting files from " + path.toFile().getName());
		Path outputPath = outputFolder.resolve(path.getFileName().toString().toLowerCase());
		if (!Files.exists(outputPath)) {
			Files.createFile(outputPath);
		}
		try (BufferedReader bReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
				CSVReader csvReader = new CSVReader(bReader);
				BufferedWriter bWriter = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8);
				CSVWriter csvWriter = new CSVWriter(bWriter)

		) {
			// csvReader.skip(1); // skip header
			String[] in = null;
			String[] values = new String[8];
			boolean isFirst = true;
			while ((in = csvReader.readNext()) != null) {
				System.out.println(Arrays.toString(in));
				System.arraycopy(in, 1, values, 0, 8);
				if (!isFirst) {
					values[1] = "C"+values[1];
				}
				// writer.writeNext(values);
				csvWriter.writeNext(values, false);
				LOGGER.info(Arrays.toString(values));
				isFirst = false;
			}
		}
	}
}
