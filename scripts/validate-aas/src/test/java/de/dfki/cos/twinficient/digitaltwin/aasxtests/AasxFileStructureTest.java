package de.dfki.cos.twinficient.digitaltwin.aasxtests;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.aasx.AASXDeserializer;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.xml.XmlDeserializer;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class AasxFileStructureTest {

	private static final String DE_DFKI_COS_TWINFICIENT_AASX = "de.dfki.cos.twinficient.aasx";

	private static final Logger LOGGER = LoggerFactory.getLogger(AasxFileStructureTest.class);

	private final File file;
	private final String fileName;

	public AasxFileStructureTest(File file, String fileName) {
		this.file = file;
		this.fileName = fileName;
	}

	@Parameters(name = "{1}")
	public static List<Object[]> parameters() {
		String fileName = System.getProperty(DE_DFKI_COS_TWINFICIENT_AASX);
		Assert.assertNotNull("Property '" + DE_DFKI_COS_TWINFICIENT_AASX + "' is not set.", fileName);
		List<Object[]> params = new ArrayList<Object[]>();
		File file = new File(fileName);
		if (file.isDirectory()) {
			for (File eachAasxChild : file.listFiles()) {
				params.add(new Object[] { eachAasxChild, eachAasxChild.getName() });
			}
		} else {
			params.add(new Object[] { file, file.getName() });
		}
		return params;
	}

	@Test
	public void testWellFormed() throws FileNotFoundException, IOException, InvalidFormatException, org.eclipse.digitaltwin.aas4j.v3.dataformat.core.DeserializationException {
		LOGGER.info("Validating {}.", file.getName());

		if (fileName.endsWith(".aasx")) {
			assertAasxFileWellFormed();
		} else if (fileName.endsWith(".xml")) {
			assertXmlFileWellFormed();
		} else {
			Assert.fail("Not an .aasx or .xml file: " + fileName);
		}
	}

	private void assertAasxFileWellFormed() throws FileNotFoundException, IOException, InvalidFormatException, org.eclipse.digitaltwin.aas4j.v3.dataformat.core.DeserializationException {
		try (FileInputStream fIn = new FileInputStream(file); BufferedInputStream bIn = new BufferedInputStream(fIn)) {
			AASXDeserializer deserializer = new AASXDeserializer(bIn);

	        deserializer.getRelatedFiles();

			Environment environment = deserializer.read();
			logEnvironmentInfo(environment);
		}
	}

	private void assertXmlFileWellFormed() throws FileNotFoundException, IOException, org.eclipse.digitaltwin.aas4j.v3.dataformat.core.DeserializationException {
		try (FileInputStream fIn = new FileInputStream(file); BufferedInputStream bIn = new BufferedInputStream(fIn)) {
			XmlDeserializer deserializer = new XmlDeserializer();
			Environment environment = deserializer.read(bIn, StandardCharsets.UTF_8);
			logEnvironmentInfo(environment);
		}
	}


	private void logEnvironmentInfo(Environment environment) {
		int shellCount = environment.getAssetAdministrationShells().size();
		int cdCount = environment.getConceptDescriptions().size();
		int smCount = environment.getSubmodels().size();
		LOGGER.info("Reading file '{}' was successful: {} shells, {} sms, {} cds", file.getName(), shellCount, smCount, cdCount);
	}
}