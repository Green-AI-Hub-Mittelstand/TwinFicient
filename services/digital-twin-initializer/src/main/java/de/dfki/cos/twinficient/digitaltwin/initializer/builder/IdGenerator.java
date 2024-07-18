package de.dfki.cos.twinficient.digitaltwin.initializer.builder;

import java.util.Map;

import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public interface IdGenerator {

	String generateShellIdShort(BasyxRecord record);
	
	String generateGlobalAssetId(BasyxIdentifier record);

	String generateShellId(BasyxIdentifier record);

	Map<SubmodelIdentifier, String> generateSubmodelIds(BasyxRecord eachRecord);

	Map<SubmodelIdentifier, String> generateSubmodelIdShort(BasyxRecord record);

	
	
}
