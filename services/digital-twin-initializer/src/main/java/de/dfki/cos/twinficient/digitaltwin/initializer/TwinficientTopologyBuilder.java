package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AnnotatedRelationshipElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.DataTypeDefXsd;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Entity;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.EntityType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Key;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.KeyTypes;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.LangStringTextType;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ModellingKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Property;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Qualifier;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.QualifierKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ReferenceTypes;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.RelationshipElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementChoice;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementCollection;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.IdGenerator;

public class TwinficientTopologyBuilder {

	private static final String CELESTRAS = "Celestras";
	private static final String HEATING_ZONES = "HeatingZones";
	private static final String ENTERPRISE = "Enterprise";
	private static final String CATEGORY_PARAMETER = "PARAMETER";

	private static final Qualifier CONCEPT_QUALIFIER_ONE = new Qualifier().kind(QualifierKind.CONCEPTQUALIFIER).type("Multiplicity").value("One").valueType(DataTypeDefXsd.STRING);
	private static final Qualifier CONCEPT_QUALIFIER_ZERO_TO_MANY = new Qualifier().kind(QualifierKind.CONCEPTQUALIFIER).type("Multiplicity").value("ZeroToMany").valueType(DataTypeDefXsd.STRING);
	private static final Qualifier CONCEPT_QUALIFIER_ONE_TO_MANY = new Qualifier().kind(QualifierKind.CONCEPTQUALIFIER).type("Multiplicity").value("OneToMany").valueType(DataTypeDefXsd.STRING);
	private static final Reference REFERENCE_AREA = new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(TwinficientTopologyBuilder.key(KeyTypes.GLOBALREFERENCE, "https://dfki.de/ids/cd/area"));
	private static final Reference SEMANTIC_ID_TOPOLOGY = new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(TwinficientTopologyBuilder.key(KeyTypes.GLOBALREFERENCE, "https://dfki.de/sm/Topology/1/0"));
	private static final Reference SEMANTIC_ID_SITE = new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(TwinficientTopologyBuilder.key(KeyTypes.GLOBALREFERENCE, "https://dfki.de/ids/cd/site"));

	private static final  LangStringTextType BELONGS_TO = new LangStringTextType().language("en-US").text("belongsTo");
	private static final  LangStringTextType CONTAINS = new LangStringTextType().language("en-US").text("contains");
	
	private final IdGenerator generator;

	public TwinficientTopologyBuilder(IdGenerator generator) {
		this.generator = generator;
	}
	
	public Submodel factoryHallTopology(FactoryHallRecord hall, String[] buildings) {
		String smId = generator.generateSubmodelIds(hall).get(FactoryHallSubmodelIdentifier.topology);
		String smIdShort = generator.generateSubmodelIdShort(hall).get(FactoryHallSubmodelIdentifier.topology);
		Submodel submodel = newSubmodelInstance(smId, smIdShort);
		submodel.addDescriptionItem(new LangStringTextType().language("de-DE").text("Teilmodell, das die hierarchische Struktur der virtuellen Fabrikhalle " + hall.getBuilding() + " des Unternehmens " + hall.getCompany() + " beschreibt."));
		submodel.addDescriptionItem(new LangStringTextType().language("en-US").text("Submodel for describing the hierachical structur for the virtual factory hall " + hall.getBuilding() + " of the company " + hall.getCompany() + "."));
		submodel.setSemanticId(SEMANTIC_ID_TOPOLOGY);

		withEntityEnterprise(submodel, hall);
		
		withEntityBuildings(submodel, hall);

		withElementCollectionCelestras(submodel, hall);

		withElementCollectionHeatingZones(submodel, hall);

		return submodel;

	}
	

	public Submodel heaterTopology(HeaterRecord heater) {
		String smId = generator.generateSubmodelIds(heater).get(HeaterSubmodelIdentifier.topology);
		String smIdShort = generator.generateSubmodelIdShort(heater).get(HeaterSubmodelIdentifier.topology);
		Submodel submodel = newSubmodelInstance(smId, smIdShort);
		submodel.addDescriptionItem(new LangStringTextType().language("de-DE").text("Teilmodell, das die hierarchische Struktur der Heizung zur virtuellen Fabrikhalle " + heater.getVirtualBuilding() + " des Unternehmens " + heater.getCompany() + " beschreibt."));
		submodel.addDescriptionItem(new LangStringTextType().language("en-US").text("Submodel for describing the hierachical structur for to the virtual building " + heater.getBuilding() + " of the company " + heater.getCompany() + "."));
		submodel.setSemanticId(SEMANTIC_ID_TOPOLOGY);
		
		withHeater(submodel, heater);
		
		return submodel;
	}


	public Submodel companyTopology(CompanyRecord cRecord) {
		String smId = generator.generateSubmodelIds(cRecord).get(CompanySubmodelIdentifier.topology);
		String smIdShort = generator.generateSubmodelIdShort(cRecord).get(CompanySubmodelIdentifier.topology);
		Submodel submodel = newSubmodelInstance(smId, smIdShort);
		submodel.addDescriptionItem(new LangStringTextType().language("de-DE").text("Teilmodell, das die hierarchische Struktur des Unternehmens " + cRecord.getCompany() + " zu seinen Fabrikhallen beschreibt."));
		submodel.addDescriptionItem(new LangStringTextType().language("en-US").text("Submodel for describing the hierachical structur of the company " + cRecord.getCompany() + " and its factory halls."));
		submodel.setSemanticId(SEMANTIC_ID_TOPOLOGY);

		withEntityEnterprise(submodel, cRecord);

		return submodel;
	}

	private String celestraToHeatingZoneCollectionIdShort(String celNr) {
		return "CelestraToHeatingZone" + celNr;
	}

	private String heatingZoneToHeatersCollectionIdShort(String celNr, String heatingZone) {
		return "HeatingZoneToHeaters" + celNr + "Hz" + heatingZone;
	}

	private Entity generateEnterprise(String submodelId, CompanyRecord company) {
		Entity entity = newEntity(ENTERPRISE);
		entity.setEntityType(EntityType.COMANAGEDENTITY);
		entity.setCategory(CATEGORY_PARAMETER);

		entity.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		entity.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.GLOBALREFERENCE).value("https://dfki.de/ids/cd/enterprise")));

		Property prop = newStringPropertyParameter(company.getCompany(), "EnterpriseName");

		entity.addStatementsItem(new SubmodelElementChoice(prop));

		entity.addStatementsItem(new SubmodelElementChoice(generateEnterpriseToBuildingRelationShip(submodelId, company)));
		return entity;
	}
	
	private Entity generateEnterprise(String submodelId, FactoryHallRecord factoryHall) {
		Entity entity = newEntity(ENTERPRISE);
		entity.setEntityType(EntityType.COMANAGEDENTITY);
		entity.setCategory(CATEGORY_PARAMETER);

		entity.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		entity.setSemanticId(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(new Key().type(KeyTypes.GLOBALREFERENCE).value("https://dfki.de/ids/cd/enterprise")));

		Property prop = newStringPropertyParameter(factoryHall.getCompany(), "EnterpriseName");

		entity.addStatementsItem(new SubmodelElementChoice(prop));
		return entity;
	}

	private Entity entityBuilding(Submodel submodel, FactoryHallRecord record) {
		Entity entity = newEntity("Site", SEMANTIC_ID_SITE);
		entity.setEntityType(EntityType.COMANAGEDENTITY);
		entity.setCategory(CATEGORY_PARAMETER);
		entity.addQualifiersItem(CONCEPT_QUALIFIER_ONE_TO_MANY);
		Property prop = newStringPropertyParameter(record.getBuilding(), "SiteName").addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		entity.addStatementsItem(new SubmodelElementChoice(prop));

		entity.addStatementsItem(new SubmodelElementChoice(topologyCollectionBuildingToCelestra(submodel.getId(), record)));
		return entity;
	}


	private SubmodelElementCollection generateEnterpriseToBuildingRelationShip(String submodelId, CompanyRecord record) {
		SubmodelElementCollection smEc = newSmCollection("EnterpriseToSite");
		smEc.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		smEc.setCategory(CATEGORY_PARAMETER);
		for (String eachBuilding : record.getBuildings()) {
			smEc.addValueItem(new SubmodelElementChoice(relationShipElementEnterpriseForCompanyToBuilding(submodelId, record.getCompany(), eachBuilding)));
		}
		return smEc;
	}


	private AnnotatedRelationshipElement relationShipElementEnterpriseForCompanyToBuilding(String submodelId, String company, String building) {
		AnnotatedRelationshipElement rsElement = newRelationshipElement("EnterpriseTo" + building, CONTAINS);
		rsElement.addQualifiersItem(CONCEPT_QUALIFIER_ZERO_TO_MANY);
		rsElement.setCategory(CATEGORY_PARAMETER);
		
		rsElement.setFirst(pathForEnterprise(submodelId));
		rsElement.setSecond(pathForBuildingShell(submodelId, company, building));
		return rsElement;
	}


	private AnnotatedRelationshipElement relationShipElementBuildingToCompany(String submodelId, String company, String building) {
		AnnotatedRelationshipElement rsElement = newRelationshipElement("SiteToCompany", BELONGS_TO);
		rsElement.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		rsElement.setCategory(CATEGORY_PARAMETER);
		rsElement.setFirst(pathForBuilding(submodelId, building));
		rsElement.setSecond(pathForCompany(submodelId, company));
		return rsElement;
	}
	
	private AnnotatedRelationshipElement relationShipElementBuildingToCelestra(String submodelId, String building, String celNr) {
		AnnotatedRelationshipElement rsElement = newRelationshipElement("SiteToCelestra" + celNr, CONTAINS);
		rsElement.addQualifiersItem(CONCEPT_QUALIFIER_ZERO_TO_MANY);
		rsElement.setCategory(CATEGORY_PARAMETER);
		rsElement.setFirst(pathForBuilding(submodelId, building));
		rsElement.setSecond(pathForCelestra(submodelId, celNr));
		return rsElement;
	}

	private AnnotatedRelationshipElement relationShipElementCelestraToHeatingZone(String submodelId, String celNr, String heatingZone) {
		AnnotatedRelationshipElement rsElement = newRelationshipElement("CelestraToHeatingZone" + "Hz" + heatingZone, CONTAINS);
		rsElement.addQualifiersItem(CONCEPT_QUALIFIER_ZERO_TO_MANY);
		rsElement.setCategory(CATEGORY_PARAMETER);
		rsElement.setFirst(pathForCelestra(submodelId, celNr));
				//new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.SUBMODEL, submodelId)).addKeysItem(key(KeyTypes.SUBMODELELEMENTCOLLECTION, CELESTRAS)).addKeysItem(key(KeyTypes.SUBMODELELEMENT, celNr)));
		rsElement.setSecond(pathForHeatingZone(submodelId, celNr, heatingZone));
		return rsElement;
	}

	private AnnotatedRelationshipElement relationShipElementHeatingZoneToHeaters(String submodelId, String celNr, String heatingZone, HeaterIdentifier heater) {
		AnnotatedRelationshipElement rsElement = newRelationshipElement("HeatingZoneToHeatersRelationShipElement" + celNr + heatingZone + "Heater" + heater.getHgNr(), CONTAINS);
		rsElement.addQualifiersItem(CONCEPT_QUALIFIER_ZERO_TO_MANY);
		rsElement.setCategory(CATEGORY_PARAMETER);
		rsElement.setFirst(pathForHeatingZone(submodelId, celNr, heatingZone));
		// model reference to other shell
		rsElement.setSecond(pathForHeater(heater));
		return rsElement;
	}

	private SubmodelElementCollection elementCollectionHeatingZones(String smId, FactoryHallRecord hall, String celNr) {
		SubmodelElementCollection collection = newSmCollection(isShortHeatingZone(celNr), REFERENCE_AREA);
		collection.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		collection.setCategory(CATEGORY_PARAMETER);
		for (String heatingZoneName : collectHeatingZones(celNr, hall.getHeaters())) {
			Entity entity = newEntity(idShortHeatingZone(celNr, heatingZoneName), REFERENCE_AREA);
			entity.setEntityType(EntityType.COMANAGEDENTITY);
			entity.setGlobalAssetId("http://aas.twinficient.de/celestra/" + hall.getCompany() + "/" + hall.getBuilding() + "/" + heatingZoneName);
			entity.addQualifiersItem(CONCEPT_QUALIFIER_ZERO_TO_MANY);
			Property heaterZoneName = newStringPropertyParameter(heatingZoneName, "HeaterZoneName").addQualifiersItem(CONCEPT_QUALIFIER_ONE);
			entity.addStatementsItem(new SubmodelElementChoice(heaterZoneName));
			SubmodelElementCollection relationship = topologyCollectionHeatingZoneToHeaters(smId, celNr, heatingZoneName, collectectHeatingZoneHeaters(celNr, heatingZoneName, hall.getHeaters()));
			entity.addStatementsItem(new SubmodelElementChoice(relationship));
			collection.addValueItem(new SubmodelElementChoice(entity));
		}
		return collection;
	}

	private SubmodelElementCollection topologyCollectionBuildingToCelestra(String submodelId, FactoryHallRecord record) {
		SubmodelElementCollection smEc = newSmCollection("SiteRelationShips");
		smEc.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		smEc.setCategory(CATEGORY_PARAMETER);
		smEc.addValueItem(new SubmodelElementChoice(relationShipElementBuildingToCompany(submodelId, record.getCompany(), record.getBuilding())));
		for (String celNr : collectCelestraIds(record.getHeaters())) {
			smEc.addValueItem(new SubmodelElementChoice(relationShipElementBuildingToCelestra(submodelId, record.getBuilding(), celNr)));
		}
		return smEc;
	}

	private SubmodelElementCollection topologyCollectionCelestraToHeatingZone(String id, String celNr, Set<String> heatingZones) {
		SubmodelElementCollection smEc = newSmCollection(celestraToHeatingZoneCollectionIdShort(celNr));
		smEc.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		smEc.setCategory(CATEGORY_PARAMETER);
		for (String eachHeationZone : heatingZones) {
			smEc.addValueItem(new SubmodelElementChoice(relationShipElementCelestraToHeatingZone(id, celNr, eachHeationZone)));
		}
		return smEc;
	}

	private SubmodelElementCollection topologyCollectionHeatingZoneToHeaters(String submodelId, String celNr, String heatingZone, Set<HeaterIdentifier> identifiers) {
		SubmodelElementCollection smEc = newSmCollection(heatingZoneToHeatersCollectionIdShort(celNr, heatingZone));
		smEc.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		smEc.setCategory(CATEGORY_PARAMETER);
		for (HeaterIdentifier eachIdentifier : identifiers) {
			smEc.addValueItem(new SubmodelElementChoice(relationShipElementHeatingZoneToHeaters(submodelId, celNr, heatingZone, eachIdentifier)));
		}
		return smEc;
	}

	private void withEntityEnterprise(Submodel submodel, FactoryHallRecord hall) {
		Entity enterprise = generateEnterprise(submodel.getId(), hall);

		submodel.addSubmodelElementsItem(new SubmodelElementChoice(enterprise));
	}

	private void withEntityEnterprise(Submodel submodel, CompanyRecord cRecord) {
		Entity enterprise = generateEnterprise(submodel.getId(), cRecord);

		submodel.addSubmodelElementsItem(new SubmodelElementChoice(enterprise));
	}

	private void withEntityBuildings(Submodel submodel, FactoryHallRecord hall) {
		Entity building = entityBuilding(submodel, hall);

		submodel.addSubmodelElementsItem(new SubmodelElementChoice(building));

		Property heaterCount = newStringPropertyParameter(""+hall.getHeaters().size(),"HeaterCount");
		SubmodelElementChoice heaterCountChoice = new SubmodelElementChoice(heaterCount);
		building.addStatementsItem(heaterCountChoice);
	}
	

	private void withElementCollectionHeatingZones(Submodel submodel, FactoryHallRecord hall) {
		SubmodelElementCollection heatingZones = newSmCollection(HEATING_ZONES);
		for (String eachCelestra : collectCelestraIds(hall.getHeaters())) {
			SubmodelElementCollection heatingZone = elementCollectionHeatingZones(submodel.getId(), hall, eachCelestra);
			heatingZones.addValueItem(new SubmodelElementChoice(heatingZone));
		}
		submodel.addSubmodelElementsItem(new SubmodelElementChoice(heatingZones));
	}

	private void withElementCollectionCelestras(Submodel submodel, FactoryHallRecord hall) {
		SubmodelElementCollection collection = newSmCollection(CELESTRAS);
		collection.addQualifiersItem(CONCEPT_QUALIFIER_ONE);
		collection.setCategory(CATEGORY_PARAMETER);
		for (String eachCelestra : collectCelestraIds(hall.getHeaters())) {
			Entity entity = newEntity(eachCelestra);
			entity.setEntityType(EntityType.SELFMANAGEDENTITY);
			entity.setGlobalAssetId("http://aas.twinficient.de/celestra/" + hall.getCompany() + "/" + hall.getBuilding() + "/" + eachCelestra);
			Property prop = newStringPropertyParameter(eachCelestra, "CelestraNr");
			entity.addStatementsItem(new SubmodelElementChoice(prop));
			SubmodelElementCollection relationship = topologyCollectionCelestraToHeatingZone(submodel.getId(), eachCelestra, collectHeatingZones(eachCelestra, hall.getHeaters()));
			entity.addStatementsItem(new SubmodelElementChoice(relationship));
			collection.addValueItem(new SubmodelElementChoice(entity));
		}
		submodel.addSubmodelElementsItem(new SubmodelElementChoice(collection));
	}

	
	private void withHeater(Submodel submodel, HeaterRecord heater) {
		
		String heaterId = generator.generateShellId(heater.getIdentifier());
		String factoryHallId = generator.generateShellId(new FactoryHallRecord().withBuilding(heater.getVirtualBuilding()).withCompany(heater.getCompany()).getIdentifier());
		
		AnnotatedRelationshipElement rsElement = newRelationshipElement("HeaterToFactory", BELONGS_TO);
		rsElement.addQualifiersItem(CONCEPT_QUALIFIER_ZERO_TO_MANY);
		rsElement.setCategory(CATEGORY_PARAMETER);
		
		rsElement.setFirst(
				new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(key(KeyTypes.ASSETADMINISTRATIONSHELL, heaterId)));
		rsElement.setSecond(new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(key(KeyTypes.ASSETADMINISTRATIONSHELL, factoryHallId)));
		
		submodel.addSubmodelElementsItem(new SubmodelElementChoice(rsElement));
	}


	private String isShortHeatingZone(String celNr) {
		return HEATING_ZONES + celNr;
	}

	private String idShortHeatingZone(String celNr, String heatingZoneName) {
		return "HeatingZone" + celNr + "Hz" + heatingZoneName;
	}

	private Reference pathForEnterprise(String submodelId) {
		return new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.SUBMODEL, submodelId)).addKeysItem(key(KeyTypes.ENTITY, ENTERPRISE));
	}

	private Reference pathForBuilding(String submodelId, String building) {
		return new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.SUBMODEL, submodelId)).addKeysItem(key(KeyTypes.ENTITY, "Site"));
	}
	
	private Reference pathForCompany(String submodelId, String company) {
		String companyId = generator.generateShellId(new CompanyRecord(company).getIdentifier());
		return new Reference().type(ReferenceTypes.EXTERNALREFERENCE).addKeysItem(key(KeyTypes.ASSETADMINISTRATIONSHELL, companyId));
	}

	private Reference pathForBuildingShell(String submodelId, String company, String building) {
		String shellId = generator.generateShellId(new FactoryHallRecord().withCompany(company).withBuilding(building).getIdentifier());
		return new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.ASSETADMINISTRATIONSHELL, shellId));
	}

	private Reference pathForCelestra(String submodelId, String celNr) {
		return new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.SUBMODEL, submodelId)).addKeysItem(key(KeyTypes.SUBMODELELEMENTCOLLECTION, CELESTRAS)).addKeysItem(key(KeyTypes.SUBMODELELEMENT, celNr));
	}

	private Reference pathForHeatingZone(String submodelId, String celNr, String heatingZone) {
		return new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.SUBMODEL, submodelId))
				.addKeysItem(key(KeyTypes.SUBMODELELEMENTCOLLECTION, HEATING_ZONES))
				.addKeysItem(key(KeyTypes.SUBMODELELEMENTCOLLECTION, isShortHeatingZone(celNr)))
				.addKeysItem(key(KeyTypes.SUBMODELELEMENT, idShortHeatingZone(celNr, heatingZone)));
	}

	private Reference pathForHeater(HeaterIdentifier heater) {
		String shellId = generator.generateShellId(heater);
		return new Reference().type(ReferenceTypes.MODELREFERENCE).addKeysItem(key(KeyTypes.ASSETADMINISTRATIONSHELL, shellId));
	}

	private Set<String> collectCelestraIds(Collection<HeaterIdentifier> identifiers) {
		Set<String> celestras = identifiers.stream().map(HeaterIdentifier::getCelNr).collect(Collectors.toCollection(TreeSet::new));
		return celestras;
	}

	private Set<String> collectHeatingZones(String celNr, Collection<HeaterIdentifier> identifiers) {
		return identifiers.stream().filter(h -> Objects.equals(celNr, h.getCelNr())).map(HeaterIdentifier::getHzNr).collect(Collectors.toCollection(TreeSet::new));
	}

	private Set<HeaterIdentifier> collectectHeatingZoneHeaters(String celNr, String heatingZoneName, Set<HeaterIdentifier> heaters) {
		Supplier<Set<HeaterIdentifier>> supplier = () -> new TreeSet<>(
				Comparator.comparing(HeaterIdentifier::getCompany).thenComparing(HeaterIdentifier::getCelNr).thenComparing(HeaterIdentifier::getHgNr).thenComparing(HeaterIdentifier::getHzNr));
		return heaters.stream().filter(h -> Objects.equals(celNr, h.getCelNr())).filter(h -> Objects.equals(heatingZoneName, h.getHzNr())).collect(Collectors.toCollection(supplier));
	}

	private Entity newEntity(String idShort, Reference semanticId) {
		return newEntity(idShort).semanticId(semanticId);
	}

	private SubmodelElementCollection newSmCollection(String idShort, Reference semanticId) {
		return newSmCollection(idShort).semanticId(semanticId);
	}

	private Entity newEntity(String idShort) {
		return new Entity().modelType(Entity.class.getSimpleName()).idShort(idShort);
	}

	private SubmodelElementCollection newSmCollection(String idShort) {
		return new SubmodelElementCollection().modelType(SubmodelElementCollection.class.getSimpleName()).idShort(idShort);
	}

	private AnnotatedRelationshipElement newRelationshipElement(String idShort, LangStringTextType descr) {
		return new AnnotatedRelationshipElement().modelType(RelationshipElement.class.getSimpleName()).idShort(idShort).addDescriptionItem(descr);
	}

	private Property newStringPropertyParameter(String value, String idShort) {
		return new Property().modelType(Property.class.getSimpleName()).value(value).valueType(DataTypeDefXsd.STRING).category(CATEGORY_PARAMETER).idShort(idShort);
	}

	private Submodel newSubmodelInstance(String id, String idShort) {
		return new Submodel().modelType(Submodel.class.getSimpleName()).kind(ModellingKind.INSTANCE).id(id).idShort(idShort);
	}

	private static Key key(KeyTypes type, String value) {
		return new Key().type(type).value(value);
	}

}
