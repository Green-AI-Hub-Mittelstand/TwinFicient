package de.dfki.cos.twinficient.digitaltwin.initializer.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import de.dfki.cos.twinficient.digitaltwin.initializer.CompanyRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.CompanyRecord.CompanyIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord.FactoryHallIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterDefinitionRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterDefinitionRecord.HeaterDefinitionIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientIdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientRecords;
import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientResourceBuilder;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.BasyxResourceBuilder;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.IdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.CsvFileRecordReader;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileNameRealmTokenGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileRecordReader;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.RealmTokenGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.BasyxV3Apis;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.BasyxV3HttpServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public class EverythingDeployedAssertion {

	private static final String shellRepoUrl(String[] args) {
		if (args.length < 1) {
			return "http://127.0.0.1:8081";
		}
		return args[0];
	}

	private static final String submodelRepoUrl(String[] args) {
		if (args.length < 2) {
			return "http://127.0.0.1:8081";
		}
		return args[1];
	}
	
	private static final Path folderPath(String[] args) {
		 if (args.length < 3) {
			 return Path.of("./config/byCompany");
		 } 
		 return Path.of(args[2]);
	}

	public static void main(String[] args) throws Exception {
		IdGenerator idGenerator = new TwinficientIdGenerator();
		BasyxV3Apis apis = new BasyxV3Apis(EverythingDeployedAssertion.shellRepoUrl(args), EverythingDeployedAssertion.submodelRepoUrl(args));
		BasyxResourceBuilder builder = new TwinficientResourceBuilder(idGenerator);
		BasyxV3HttpServiceFacade facade = new BasyxV3HttpServiceFacade(apis, builder, idGenerator);
		Set<BasyxRecord> records = facade.fetchAll();

		Path folderPath = folderPath(args);
		if (!Files.isDirectory(folderPath)) {
			throw new RuntimeException();
		}
		List<Path> pathList = Files.list(folderPath).collect(Collectors.toList());

		RealmTokenGenerator tokenGenerator = new FileNameRealmTokenGenerator();
		FileRecordReader reader = new CsvFileRecordReader(tokenGenerator, TwinficientRecord::fromCsvEntry);

		assertNoDuplicates(pathList, reader);
		assertEveryThingDeployedOnServer(pathList, reader, records);
		System.out.println("                                ████          \r\n" + "                                ██  ██        \r\n" + "                              ▓▓    ██        \r\n"
				+ "                              ▓▓    ██        \r\n" + "                            ██    ██          \r\n" + "                            ██    ██          \r\n" + "                          ██      ██          \r\n"
				+ "                          ██    ██            \r\n" + "  ██████████            ██      ██            \r\n" + "██░░▒▒▒▒░░▒▒██    ██████        ██████████████\r\n" + "██░░░░░░░░▒▒██  ██                          ██\r\n"
				+ "██▒▒▒▒▒▒░░▒▒██  ██                          ██\r\n" + "██▓▓▓▓▓▓▓▓▓▓██  ██                ██████████  \r\n" + "██▓▓▓▓▒▒▓▓▓▓██  ██                        ██  \r\n" + "██▓▓▓▓▒▒▒▒▒▒██  ▓▓                ░░░░    ██  \r\n"
				+ "██▓▓▓▓▓▓▓▓▓▓██  ██                ████████    \r\n" + "██▓▓▓▓▓▓▓▓▓▓██  ██                      ██    \r\n" + "██▓▓▓▓▓▓▓▓▓▓██  ██                      ██    \r\n" + "██▓▓▓▓▓▓▓▓▓▓██  ██                ██████      \r\n"
				+ "██▓▓▓▓▓▓  ▓▓██  ██                    ██      \r\n" + "██▓▓▓▓▓▓▓▓▓▓██    ████████████████████        \r\n" + "  ██████████                                  \r\n" + "                                              \r\n"
				+ "                                              \r\n" + "                                              \r\n" + "                                              \r\n" + "            ░░░░░░░░░░░░░░░░░░░░              \r\n"
				+ "                                              \r\n" + "");
		System.out.println("███████╗██╗   ██╗███████╗██████╗ ██╗   ██╗████████╗██╗  ██╗██╗███╗   ██╗ ██████╗     ██████╗ ███████╗██████╗ ██╗      ██████╗ ██╗   ██╗███████╗██████╗     \r\n"
				+ "██╔════╝██║   ██║██╔════╝██╔══██╗╚██╗ ██╔╝╚══██╔══╝██║  ██║██║████╗  ██║██╔════╝     ██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗╚██╗ ██╔╝██╔════╝██╔══██╗    \r\n"
				+ "█████╗  ██║   ██║█████╗  ██████╔╝ ╚████╔╝    ██║   ███████║██║██╔██╗ ██║██║  ███╗    ██║  ██║█████╗  ██████╔╝██║     ██║   ██║ ╚████╔╝ █████╗  ██║  ██║    \r\n"
				+ "██╔══╝  ╚██╗ ██╔╝██╔══╝  ██╔══██╗  ╚██╔╝     ██║   ██╔══██║██║██║╚██╗██║██║   ██║    ██║  ██║██╔══╝  ██╔═══╝ ██║     ██║   ██║  ╚██╔╝  ██╔══╝  ██║  ██║    \r\n"
				+ "███████╗ ╚████╔╝ ███████╗██║  ██║   ██║      ██║   ██║  ██║██║██║ ╚████║╚██████╔╝    ██████╔╝███████╗██║     ███████╗╚██████╔╝   ██║   ███████╗██████╔╝");
	}

	private static void assertEveryThingDeployedOnServer(List<Path> pathList, FileRecordReader reader, Set<BasyxRecord> records) throws Exception {

		Set<BasyxRecord> toVisit = new HashSet<>(records);

		Map<HeaterIdentifier, HeaterRecord> visitedHeaters = new HashMap<>();
		for (Path eachPath : pathList) {
			List<DigitalTwinRecord> fileRecords = reader.readEntries(eachPath);
			for (DigitalTwinRecord eachRecord : fileRecords) {
				HeaterRecord heater = TwinficientRecords.createHeater(eachRecord);
				if (!records.contains(heater)) {
					throw new RuntimeException("Record " + heater + " not deployed on server");
				}
				toVisit.remove(heater);
				visitedHeaters.put(heater.getIdentifier(), heater);
			}
		}
		Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> hds = TwinficientRecords.collectHeaterDefinitions(visitedHeaters);
		for (HeaterDefinitionRecord eachHeaterDef : hds.values()) {
			if (!records.contains(eachHeaterDef)) {
				throw new RuntimeException("Record " + eachHeaterDef + " not deployed on server.");
			}
			toVisit.remove(eachHeaterDef);
		}
		
		Map<FactoryHallIdentifier, FactoryHallRecord> factories = TwinficientRecords.collectFactoryHalls(visitedHeaters);
		for (FactoryHallRecord eachFactory : factories.values()) {
			if (!records.contains(eachFactory)) {
				throw new RuntimeException("Record " + eachFactory + " not deployed on server.");
			}
			toVisit.remove(eachFactory);
		}
	
		Map<CompanyIdentifier, CompanyRecord> companies = TwinficientRecords.collectCompanies(factories);
		
		for (CompanyRecord eachCompany : companies.values()) {
			if (!records.contains(eachCompany)) {
				throw new RuntimeException("Record " + eachCompany + " not deployed on server.");
			}
			toVisit.remove(eachCompany);
		}
		if (!toVisit.isEmpty()) {
			throw new RuntimeException(records.toString());
		}

	}

	private static void assertNoDuplicates(List<Path> pathList, FileRecordReader reader) throws Exception {
		Map<HeaterIdentifier, HeaterRecord> duplicationCheck = new HashMap<>();
		Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> duplicationDefCheck = new HashMap<>();
		Map<FactoryHallIdentifier, FactoryHallRecord> duplicationFhCheck = new HashMap<>();
		for (Path eachPath : pathList) {
			List<DigitalTwinRecord> fileRecords = reader.readEntries(eachPath);
			for (DigitalTwinRecord eachRecord : fileRecords) {
				HeaterRecord heater = TwinficientRecords.createHeater(eachRecord);
				HeaterRecord previous = duplicationCheck.put(heater.getIdentifier(), heater);
				if (previous != null) {
					throw new RuntimeException("Heater provided twice " + heater + " " + previous);
				}
				HeaterDefinitionRecord hd = TwinficientRecords.createHeaterDefinition(heater);
				HeaterDefinitionRecord previousHd = duplicationDefCheck.put(hd.getIdentifier(), hd);
				if (previousHd != null && !hd.equals(previousHd)) {
					throw new RuntimeException("Heater def provided twice " + hd + " " + previousHd);
				}
				FactoryHallRecord fhr = TwinficientRecords.createFactoryHall(heater);
				FactoryHallRecord previousFhr = duplicationFhCheck.put(fhr.getIdentifier(), fhr);
				if (previousFhr != null && !fhr.equals(previousFhr)) {
					throw new RuntimeException("Hall provided twice " + fhr + " " + previousFhr);
				}
			}
		}

	}
}
