package de.dfki.cos.twinficient.digitaltwin.initializer.builder;

import java.util.HashMap;
import java.util.Map;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public abstract class AbstractIdGenerator implements IdGenerator {


	@Override
	public String generateGlobalAssetId(BasyxIdentifier identifier) {
		String suffix = suffix(identifier);
		return "http://asset.twinficient.de/" + suffix;
	}

	@Override
	public String generateShellId(BasyxIdentifier identifier) {
		String suffix = suffix(identifier);
		return "http://aas.twinficient.de/" + suffix;
	}
	
	@Override
	public Map<SubmodelIdentifier, String> generateSubmodelIds(BasyxRecord record) {
		Map<SubmodelIdentifier, String> ids = new HashMap<>();
		for (SubmodelIdentifier eachIdentifier : getIdentifiersByRecord(record)) {
			ids.put(eachIdentifier, "http://sm.twinficient.de/" + eachIdentifier.description() + "/" + suffix(record.getIdentifier()));
		}
		return ids;
	}
	
	@Override
	public Map<SubmodelIdentifier, String> generateSubmodelIdShort(BasyxRecord record) {
		Map<SubmodelIdentifier, String> ids = new HashMap<>();
		for (SubmodelIdentifier eachIdentifier : getIdentifiersByRecord(record)) {
			ids.put(eachIdentifier, eachIdentifier.description() + "-" + suffix(record.getIdentifier()));
		}
		return ids;
	}
	

	protected abstract SubmodelIdentifier[] getIdentifiersByRecord(BasyxRecord record);

	protected abstract String suffix(BasyxIdentifier eachRecord);
	

}
