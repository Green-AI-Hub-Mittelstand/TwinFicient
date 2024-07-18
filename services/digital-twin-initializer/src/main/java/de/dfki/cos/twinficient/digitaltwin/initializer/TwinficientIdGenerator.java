package de.dfki.cos.twinficient.digitaltwin.initializer;

import de.dfki.cos.twinficient.digitaltwin.initializer.CompanyRecord.CompanyIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord.FactoryHallIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterDefinitionRecord.HeaterDefinitionIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.AbstractIdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.SubmodelIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecordUnknownException;

public class TwinficientIdGenerator extends AbstractIdGenerator {

	private static final String FACTORY_HALL = "virtual-factory-hall";
	private static final String COMPANY = "company";
	private static final String HEATER_DEFINITION = "heater-definition";
	private static final String HEATER = "heater";

	@Override
	protected String suffix(BasyxIdentifier identifier) {
		if (identifier instanceof HeaterIdentifier) {
			return getHeaterSuffix((HeaterIdentifier) identifier);
		} else if (identifier instanceof HeaterDefinitionIdentifier) {
			return getHeaterDefinitionSuffix((HeaterDefinitionIdentifier) identifier);
		} else if (identifier instanceof FactoryHallIdentifier) {
			return getFactoryHallSuffix((FactoryHallIdentifier) identifier);
		} else if (identifier instanceof CompanyIdentifier) {
			return getCompanySuffix((CompanyIdentifier) identifier);
		}
		throw new BasyxRecordUnknownException(identifier);
	}

	private String getCompanySuffix(CompanyIdentifier identifier) {
		return String.format("%s/%s", COMPANY, identifier.getCompany());
	}

	@Override
	protected SubmodelIdentifier[] getIdentifiersByRecord(BasyxRecord record) {
		if (record instanceof HeaterRecord) {
			return HeaterSubmodelIdentifier.values();
		} else if (record instanceof HeaterDefinitionRecord) {
			return HeaterDefinitionSubmodelIdentifier.values();
		} else if (record instanceof FactoryHallRecord) {
			return FactoryHallSubmodelIdentifier.values();
		} else if (record instanceof CompanyRecord) {
			return CompanySubmodelIdentifier.values();
		}
		return new SubmodelIdentifier[0];
	}

	@Override
	public String generateShellIdShort(BasyxRecord record) {
		if (record instanceof HeaterRecord) {
			return generateHeaterIdShort((HeaterRecord) record);
		} else if (record instanceof HeaterDefinitionRecord) {
			return generateHeaterDefinitionIdShort((HeaterDefinitionRecord) record);
		} else if (record instanceof FactoryHallRecord) {
			return generateFactoryHallIdShort((FactoryHallRecord) record);
		} else if (record instanceof CompanyRecord) {
			return generateCompanyRecordIdShort((CompanyRecord) record);
		}
		throw new BasyxRecordUnknownException(record.getIdentifier());
	}

	private String generateCompanyRecordIdShort(CompanyRecord record) {
		return "Company: " + record.getCompany();
	}

	private String generateFactoryHallIdShort(FactoryHallRecord record) {
		return String.format("Building: %s-%s", record.getCompany(), record.getBuilding());
	}

	private String generateHeaterDefinitionIdShort(HeaterDefinitionRecord definition) {
		return String.format("DeviceType: %s (%s)", definition.getDeviceType(), definition.getDevicePerformance());
	}

	private String generateHeaterIdShort(HeaterRecord heater) {
		return String.format("Heater: %s-%s-%s-%s-%s (%s)", heater.getCompany(), heater.getCelNr(), heater.getHzNr(), heater.getHgNr(), heater.getDeviceType(), heater.getBuilding());
	}

	private String getHeaterDefinitionSuffix(HeaterDefinitionIdentifier record) {
		return String.format("%s/%s", HEATER_DEFINITION, record.getDeviceType());
	}

	private String getFactoryHallSuffix(FactoryHallIdentifier record) {
		return String.format("%s/%s/%s", FACTORY_HALL, record.getCompany(), record.getBuilding());
	}

	private String getHeaterSuffix(HeaterIdentifier heaterId) {
		return String.format("%s/%s/%s/%s/%s", HEATER, heaterId.getCompany(), heaterId.getCelNr(), heaterId.getHzNr(), heaterId.getHgNr());
	}
}