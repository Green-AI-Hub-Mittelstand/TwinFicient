package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.HashMap;
import java.util.Map;

import de.dfki.cos.twinficient.digitaltwin.initializer.CompanyRecord.CompanyIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord.FactoryHallIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterDefinitionRecord.HeaterDefinitionIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public class TwinficientRecords {

	private TwinficientRecords() {

	}

	public static HeaterRecord createHeater(DigitalTwinRecord record) {
		return HeaterRecord.forRealm(record.getRealm()).withBuilding(record.get(TwinficientRecordFieldIdentifier.BUILDING)).withVirtualBuilding(record.get(TwinficientRecordFieldIdentifier.VIRTUAL_BUILDING))
				.withCelNr(record.get(TwinficientRecordFieldIdentifier.CEL_NR)).withCompany(record.get(TwinficientRecordFieldIdentifier.COMPANY)).withDevicePerformance(record.get(TwinficientRecordFieldIdentifier.PERFORMANCE))
				.withDeviceType(record.get(TwinficientRecordFieldIdentifier.DEVICE_TYPE)).withHgNr(record.get(TwinficientRecordFieldIdentifier.HG_NR)).withHzNr(record.get(TwinficientRecordFieldIdentifier.HZ_NR));
	}

	public static HeaterDefinitionRecord createHeaterDefinition(HeaterRecord record) {
		return new HeaterDefinitionRecord().withDeviceType(record.getDeviceType()).withDevicePerformance(record.getDevicePerformance());
	}

	public static FactoryHallRecord createFactoryHall(HeaterRecord record) {
		return new FactoryHallRecord().withBuilding(record.getBuilding()).withCompany(record.getCompany());
	}

	public static CompanyRecord createCompanyRecord(HeaterRecord heater) {
		return new CompanyRecord(heater.getCompany()).withBuilding(heater.getBuilding());
	}
	
	public static Map<FactoryHallIdentifier, FactoryHallRecord> collectFactoryHalls(Map<HeaterIdentifier, HeaterRecord> idToHeaters) {
		Map<FactoryHallIdentifier, FactoryHallRecord> requiredHalls = new HashMap<>();
		for (HeaterRecord eachHeater : idToHeaters.values()) {
			// for now we choose the virtual building
			FactoryHallRecord factoryHall = new FactoryHallRecord().withBuilding(eachHeater.getVirtualBuilding())
					.withCompany(eachHeater.getCompany());
			FactoryHallRecord previous = requiredHalls.get(factoryHall.getIdentifier());
			if (previous != null) {
				previous.withHeater(eachHeater.getIdentifier());
			} else {
				factoryHall.withHeater(eachHeater.getIdentifier());
				requiredHalls.put(factoryHall.getIdentifier(), factoryHall);
			}
		}
		return requiredHalls;
	}

	public static Map<CompanyIdentifier, CompanyRecord> collectCompanies(Map<FactoryHallIdentifier, FactoryHallRecord> factories) {
		Map<CompanyIdentifier, CompanyRecord> requiredCompanies = new HashMap<>();
		for (FactoryHallRecord eachFactoryHall : factories.values()) {
			CompanyRecord record = new CompanyRecord(eachFactoryHall.getCompany());
			CompanyRecord previous = requiredCompanies.get(record.getIdentifier());
			if (previous != null) {
				previous.withBuilding(eachFactoryHall.getBuilding());
			} else {
				record.withBuilding(eachFactoryHall.getBuilding());
				requiredCompanies.put(record.getIdentifier(), record);
			}
		}
		return requiredCompanies;
	}

	public static Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> collectHeaterDefinitions(Map<HeaterIdentifier, HeaterRecord> idToHeaters) {
		Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> requiredDependent = new HashMap<>();
		for (HeaterRecord eachHeater : idToHeaters.values()) {
			HeaterDefinitionRecord referencedResource = TwinficientRecords.createHeaterDefinition(eachHeater);
			requiredDependent.put(referencedResource.getIdentifier(), referencedResource);
		}
		return requiredDependent;
	}

}
