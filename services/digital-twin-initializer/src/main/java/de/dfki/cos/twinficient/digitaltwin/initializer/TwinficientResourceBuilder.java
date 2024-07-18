package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataTypeDefXsd;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Extension;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Key;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.KeyTypes;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModellingKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Property;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.QualifierKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ReferenceTypes;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementChoice;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementCollection;

import de.dfki.cos.twinficient.digitaltwin.initializer.CompanyRecord.CompanyIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord.FactoryHallIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.BasyxResourceBuilder;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.IdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecordUnknownException;

public class TwinficientResourceBuilder implements BasyxResourceBuilder {

	private static final String ENTERPRISE = "Enterprise";
	private static final String CATEGORY_PARAMETER = "PARAMETER";
	private static final String SEPERATOR_FIELDS = ",";
	private static final String SEPERATOR_ITEMS = ";";
	private static final String TECHNICAL_DATA = "TechnicalData";
	private static final String TWINFICIENT_TOKEN = "twinficient";
	private static final String TYPE_COMPANY = "company";
	private static final String TYPE_FACTORY_HALL = "factory-hall";
	private static final String TYPE_HEATER_DEFINITION = "heater-definition";
	private static final String TYPE_HEATER = "heater";
	private static final String TYPE = "type";
	private static final String GENERATED = "generated";
	private static final String REALM = "realm";
	private static final String COMPANY = "company";
	private static final String HG_NR = "hgNr";
	private static final String HZ_NR = "hzNr";
	private static final String DEVICE_TYPE = "deviceType";
	private static final String DEVICE_PERFORMANCE = "devicePerformance";
	private static final String CEL_NR = "celNr";
	private static final String BUILDING = "building";
	private static final String BUILDINGS = "buildings";
	private static final String VIRTUAL_BUILDING = "virutalBuilding";
	private static final String HEATERS = "heaters";
	private static final Qualifier CONCEPT_QUALIFIER_ONE = new Qualifier().kind(QualifierKind.CONCEPTQUALIFIER).type("Multiplicity").value("One").valueType(DataTypeDefXsd.STRING);
	private static final Qualifier CONCEPT_QUALIFIER_ZERO_TO_MANY = new Qualifier().kind(QualifierKind.CONCEPTQUALIFIER).type("Multiplicity").value("ZeroToMany").valueType(DataTypeDefXsd.STRING);
	private static final Qualifier CONCEPT_QUALIFIER_ONE_TO_MANY = new Qualifier().kind(QualifierKind.CONCEPTQUALIFIER).type("Multiplicity").value("OneToMany").valueType(DataTypeDefXsd.STRING);
	private static final String CATEGORY_CONSTANT = "CONSTANT";

	private final IdGenerator generator;
	private final TwinficientTopologyBuilder topologyBuilder;

	public TwinficientResourceBuilder(IdGenerator generator) {
		this.generator = generator;
		this.topologyBuilder = new TwinficientTopologyBuilder(generator);
	}

	@Override
	public List<Submodel> generateSubmodels(BasyxRecord record) {
		if (record instanceof HeaterDefinitionRecord) {
			Submodel technicalDataSubmodel = generateTechnicalDataSubmodel((HeaterDefinitionRecord) record);
			return List.of(technicalDataSubmodel);
		} else if (record instanceof FactoryHallRecord) {
			FactoryHallRecord fhRecord = (FactoryHallRecord) record;
			Submodel topologySubmodel = topologyBuilder.factoryHallTopology(fhRecord, new String[] { fhRecord.getBuilding() }); 
			return List.of(topologySubmodel);
		} else if (record instanceof CompanyRecord) {
			CompanyRecord cRecord = (CompanyRecord) record;
			Submodel topologySubmodel = topologyBuilder.companyTopology(cRecord);
			return List.of(topologySubmodel);
		} else if (record instanceof HeaterRecord) {
			HeaterRecord heater = (HeaterRecord) record;
			Submodel topologySubmodel = topologyBuilder.heaterTopology(heater);
			return List.of(topologySubmodel);
		}
		return List.of();
	}


	private Submodel generateTechnicalDataSubmodel(HeaterDefinitionRecord record) {
		Submodel submodel = new Submodel();
		submodel.setId(generator.generateSubmodelIds(record).get(HeaterDefinitionSubmodelIdentifier.TechnicalData));
		submodel.setIdShort(generator.generateSubmodelIdShort(record).get(HeaterDefinitionSubmodelIdentifier.TechnicalData));
		submodel.setKind(ModellingKind.INSTANCE);
		submodel.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.SUBMODEL).value("http://admin-shell.io/sandbox/SG2/TechnicalData/Submodel/1/1")));
		submodel.setSubmodelElements(generateTechnicalDataSubmodelElements(record));
		
		return submodel;
	}

	private List<SubmodelElementChoice> generateTechnicalDataSubmodelElements(HeaterDefinitionRecord record) {
		SubmodelElementCollection collection = new SubmodelElementCollection();
		collection.modelType("SubmodelElementCollection");
		collection.setIdShort("TechnicalProperties");
		collection.setCategory("CONSTANT");
		collection.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.GLOBALREFERENCE).value("https://admin-shell.io/sandbox/SG2/TechnicalData/TechnicalProperties/1/1")));
		collection.addValueItem(new SubmodelElementChoice(createTechnicalDataInnerCollection(record)));
		return List.of(new SubmodelElementChoice(collection));
	}

	private SubmodelElementCollection createTechnicalDataInnerCollection(HeaterDefinitionRecord record) {
		SubmodelElementCollection inner = new SubmodelElementCollection();
		inner.modelType("SubmodelElementCollection");
		inner.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.GLOBALREFERENCE).value("https://admin-shell.io/sandbox/SG2/TechnicalData/MainSection/1/1")));
		inner.setIdShort("Technische Daten");
		inner.setCategory("CONSTANT");
		inner.addValueItem(new SubmodelElementChoice(createPerformanceCollection(record)));
		return inner;
	}

	private SubmodelElementCollection createPerformanceCollection(HeaterDefinitionRecord record) {
		SubmodelElementCollection inner = new SubmodelElementCollection();
		inner.modelType("SubmodelElementCollection");
		inner.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.GLOBALREFERENCE).value("https://admin-shell.io/sandbox/SG2/TechnicalData/SubSection/1/1")));
		inner.setIdShort("Leistung");
		inner.setCategory("CONSTANT");
		inner.addValueItem(new SubmodelElementChoice(createPerformanceItem(record)));
		// TODO add other items too
		return inner;
	}

	private Property createPerformanceItem(HeaterDefinitionRecord record) {
		Property performance = new Property();
		performance.modelType("Property");
		performance.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.GLOBALREFERENCE).value("https://admin-shell.io/SemanticIdNotAvailable/1/1")));
		performance.setIdShort("Performance");
		performance.setCategory("CONSTANT");
		performance.setValue(record.getDevicePerformance());
		performance.setValueType(DataTypeDefXsd.FLOAT);
		performance.addDescriptionItem(new LangStringTextType().language("de").text("Performance"));
		return performance;
	}

	@Override
	public AssetAdministrationShell generateShell(BasyxRecord record) {
		if (record instanceof HeaterRecord) {
			return generateHeaterShell((HeaterRecord) record);
		} else if (record instanceof HeaterDefinitionRecord) {
			return generateHeaterDefinitionShell((HeaterDefinitionRecord) record);
		} else if (record instanceof FactoryHallRecord) {
			return generateFactoryShell((FactoryHallRecord) record);
		} else if (record instanceof CompanyRecord) {
			return generateCompanyShell((CompanyRecord) record);
		}
		throw new BasyxRecordUnknownException(record.getIdentifier());
	}

	private AssetAdministrationShell generateHeaterShell(HeaterRecord record) {
		AssetAdministrationShell shell = new AssetAdministrationShell();
		shell.setId(generator.generateShellId(record.getIdentifier()));
		shell.setIdShort(generator.generateShellIdShort(record));
		shell.setAssetInformation(new AssetInformation().assetKind(AssetKind.INSTANCE).globalAssetId(generator.generateGlobalAssetId(record.getIdentifier())));
		HeaterDefinitionRecord defRecord = new HeaterDefinitionRecord().withDeviceType(record.getDeviceType()).withDevicePerformance(record.getDevicePerformance());
		shell.setDerivedFrom(new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(new Key().type(KeyTypes.ASSETADMINISTRATIONSHELL).value(generator.generateShellId(defRecord.getIdentifier()))));
		addTopologySubmodel(shell, record);
		// TODO do we need that addIdentificationSubmodel(shell);
		applyHeaterTags(shell, record);
		return shell;
	}

	private AssetAdministrationShell generateFactoryShell(FactoryHallRecord record) {
		AssetAdministrationShell shell = new AssetAdministrationShell();
		shell.setId(generator.generateShellId(record.getIdentifier()));
		shell.setIdShort(generator.generateShellIdShort(record));
		shell.setAssetInformation(new AssetInformation().assetKind(AssetKind.INSTANCE).globalAssetId(generator.generateGlobalAssetId(record.getIdentifier())));

		addTopologySubmodel(shell, record);
		applyFactoryHallTags(shell, record);
		return shell;
	}
	
	private AssetAdministrationShell generateCompanyShell(CompanyRecord record) {
		AssetAdministrationShell shell = new AssetAdministrationShell();
		shell.setId(generator.generateShellId(record.getIdentifier()));
		shell.setIdShort(generator.generateShellIdShort(record));
		shell.setAssetInformation(new AssetInformation().assetKind(AssetKind.INSTANCE).globalAssetId(generator.generateGlobalAssetId(record.getIdentifier())));
		addTopologySubmodel(shell, record);
		applyCompanyTags(shell, record);
		return shell;		
	}
	
	private void addTopologySubmodel(AssetAdministrationShell shell, CompanyRecord record) {
		shell.addSubmodelsItem(new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(new Key().type(KeyTypes.SUBMODEL).value(generator.generateSubmodelIds(record).get(CompanySubmodelIdentifier.topology))));
	}

	private void addTopologySubmodel(AssetAdministrationShell shell, FactoryHallRecord record) {
		shell.addSubmodelsItem(new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(new Key().type(KeyTypes.SUBMODEL).value(generator.generateSubmodelIds(record).get(FactoryHallSubmodelIdentifier.topology))));
	}
	
	private void addTopologySubmodel(AssetAdministrationShell shell, HeaterRecord record) {
		shell.addSubmodelsItem(new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(new Key().type(KeyTypes.SUBMODEL).value(generator.generateSubmodelIds(record).get(HeaterSubmodelIdentifier.topology))));
	}


	private AssetAdministrationShell generateHeaterDefinitionShell(HeaterDefinitionRecord record) {
		AssetAdministrationShell shell = new AssetAdministrationShell();
		shell.setId(generator.generateShellId(record.getIdentifier()));
		shell.setIdShort(generator.generateShellIdShort(record));
		shell.setAssetInformation(new AssetInformation().assetKind(AssetKind.INSTANCE).globalAssetId(generator.generateGlobalAssetId(record.getIdentifier())));
		applyHeaterDefinitionTags(shell, record);
		Reference ref = createSubmodelReference(generator.generateSubmodelIds(record).get(HeaterDefinitionSubmodelIdentifier.TechnicalData));
		shell.addSubmodelsItem(ref);
		return shell;
	}

	private void applyHeaterDefinitionTags(AssetAdministrationShell shell, HeaterDefinitionRecord record) {
		addExtensionItem(shell, TYPE, TYPE_HEATER_DEFINITION);
		addExtensionItem(shell, GENERATED, TWINFICIENT_TOKEN);
		addExtensionItem(shell, DEVICE_TYPE, record.getDeviceType());
		addExtensionItem(shell, DEVICE_PERFORMANCE, record.getDevicePerformance());
	}

	// private void applyHeaterDefinitionTags(Submodel sm, HeaterDefinitionRecord
	// record) {
	// addExtensionItem(sm, TYPE, TYPE_HEATER_DEFINITION);
	// addExtensionItem(sm, GENERATED, TWINFICIENT_TOKEN);
	// addExtensionItem(sm, DEVICE_TYPE, record.getDeviceType());
	// addExtensionItem(sm, DEVICE_PERFORMANCE, record.getDevicePerformance());
	// }

	private void applyHeaterTags(AssetAdministrationShell shell, HeaterRecord record) {
		addExtensionItem(shell, TYPE, TYPE_HEATER);
		addExtensionItem(shell, GENERATED, TWINFICIENT_TOKEN);
		addExtensionItem(shell, BUILDING, record.getBuilding());
		addExtensionItem(shell, VIRTUAL_BUILDING, record.getVirtualBuilding());
		addExtensionItem(shell, CEL_NR, record.getCelNr());
		addExtensionItem(shell, COMPANY, record.getCompany());
		addExtensionItem(shell, DEVICE_TYPE, record.getDeviceType());
		addExtensionItem(shell, HG_NR, record.getHgNr());
		addExtensionItem(shell, HZ_NR, record.getHzNr());
		addExtensionItem(shell, DEVICE_PERFORMANCE, record.getDevicePerformance());
		addExtensionItem(shell, REALM, record.getRealm());
	}

	private void applyFactoryHallTags(AssetAdministrationShell shell, FactoryHallRecord record) {
		addExtensionItem(shell, TYPE, TYPE_FACTORY_HALL);
		addExtensionItem(shell, GENERATED, TWINFICIENT_TOKEN);
		addExtensionItem(shell, COMPANY, record.getCompany());
		addExtensionItem(shell, BUILDING, record.getBuilding());
		addExtensionItem(shell, HEATERS, serializeHeaterIdentifiers(record.getHeaters()));
	}
	
	private void applyCompanyTags(AssetAdministrationShell shell, CompanyRecord record) {
		addExtensionItem(shell, TYPE, TYPE_COMPANY);
		addExtensionItem(shell, GENERATED, TWINFICIENT_TOKEN);
		addExtensionItem(shell, COMPANY, record.getCompany());
		addExtensionItem(shell, BUILDINGS, serializeBuildingIdentifiers(record.getBuildings()));
	}


	private String serializeBuildingIdentifiers(Set<String> buildings) {
		return buildings.stream().collect(Collectors.joining(SEPERATOR_ITEMS));
	}

	private String serializeHeaterIdentifiers(Set<HeaterIdentifier> heaters) {
		return heaters.stream().map(this::serializeHeaterIdentifier).collect(Collectors.joining(SEPERATOR_ITEMS));
	}

	private String serializeHeaterIdentifier(HeaterIdentifier heater) {
		return String.join(SEPERATOR_FIELDS, heater.getCelNr(), heater.getHzNr(), heater.getHgNr());
	}

	private void addExtensionItem(AssetAdministrationShell shell, String key, String value) {
		shell.addExtensionsItem(new Extension().name(key).value(value));
	}

	// private void addExtensionItem(Submodel sm, String key, String value) {
	// sm.addExtensionsItem(new Extension().name(key + ":" + value));
	// }

	private Reference createSubmodelReference(String ref) {
		return new Reference().addKeysItem(new Key().type(KeyTypes.SUBMODEL).value(ref)).type(ReferenceTypes.MODELREFERENCE);
	}

	@Override
	public Optional<BasyxRecord> generateBasyxRecord(AssetAdministrationShell shell) {
		if (shell == null) {
			return Optional.empty();
		}
		Map<String, String> tags = new HashMap<>();
		List<Extension> extensions = shell.getExtensions();
		tags = resolveTags(extensions);
		String type = tags.get(TYPE);
		String generated = tags.get(GENERATED);
		if (generated != null) {
			if (TYPE_HEATER.equals(type)) {
				return heaterRecordFromTags(tags);
			} else if (TYPE_HEATER_DEFINITION.equals(type)) {
				return heaterDefinitionRecordFromTags(tags);
			} else if (TYPE_FACTORY_HALL.equals(type)) {
				return factoryHallRecordFromTags(tags);
			} else if (TYPE_COMPANY.equals(type)) {
				return companyRecordFromTags(tags);
			}
			throw new BasyxRecordUnknownException(type);
		}
		return Optional.empty();
	}

	private Optional<BasyxRecord> companyRecordFromTags(Map<String, String> tags) {
		String company = tags.get(COMPANY);
		CompanyRecord cRecord = new CompanyRecord(company);
		String buildings = tags.get(BUILDINGS);
		applyBuildings(cRecord, buildings);
		return Optional.of(cRecord);
	}

	private void applyBuildings(CompanyRecord cRecord, String buildings) {
		String[] factoryHalls = buildings.split(SEPERATOR_ITEMS);
		for (String eachBuilding : factoryHalls) {
			cRecord.withBuilding(eachBuilding);
		}
	}

	private Optional<BasyxRecord> heaterRecordFromTags(Map<String, String> tags) {
		HeaterRecord record = HeaterRecord.forRealm(tags.get(REALM)).withBuilding(tags.get(BUILDING)).withVirtualBuilding(tags.get(VIRTUAL_BUILDING)).withCelNr(tags.get(CEL_NR)).withCompany(tags.get(COMPANY))
				.withDevicePerformance(tags.get(DEVICE_PERFORMANCE)).withDeviceType(tags.get(DEVICE_TYPE)).withHgNr(tags.get(HG_NR)).withHzNr(tags.get(HZ_NR));
		return Optional.of(record);
	}

	private Optional<BasyxRecord> heaterDefinitionRecordFromTags(Map<String, String> tags) {
		HeaterDefinitionRecord heaterDef = new HeaterDefinitionRecord().withDeviceType(tags.get(DEVICE_TYPE)).withDevicePerformance(tags.get(DEVICE_PERFORMANCE));
		return Optional.of(heaterDef);
	}

	private Optional<BasyxRecord> factoryHallRecordFromTags(Map<String, String> tags) {
		FactoryHallRecord record = new FactoryHallRecord().withBuilding(tags.get(BUILDING)).withCompany(tags.get(COMPANY));
		applyHeaters(record, record.getCompany(), tags.get(HEATERS));
		return Optional.of(record);
	}

	private void applyHeaters(FactoryHallRecord record, String company, String heatersToken) {
		String[] heaterFields = heatersToken.split(SEPERATOR_ITEMS);
		for (String eachHeaterField : heaterFields) {
			String[] fields = eachHeaterField.split(SEPERATOR_FIELDS);
			HeaterIdentifier identifier = new HeaterIdentifier(company, fields[0], fields[1], fields[2]);
			record.withHeater(identifier);
		}

	}

	private Map<String, String> resolveTags(List<Extension> extensions) {
		Map<String, String> tags = new HashMap<>();
		if (extensions != null) {
			for (Extension eachExtension : extensions) {
				String name = eachExtension.getName();
				String value = eachExtension.getValue();
				tags.put(name, value);
			}
		}
		return tags;
	}

	// TODO remove
	private void extractAddPut(String name, Map<String, String> toReturn) {

		int index = name.indexOf(":");
		if (index != -1) {
			String prefix = name.substring(0, index);
			String suffix = name.substring(index + 1);
			toReturn.put(prefix, suffix);
		}
	}
}
