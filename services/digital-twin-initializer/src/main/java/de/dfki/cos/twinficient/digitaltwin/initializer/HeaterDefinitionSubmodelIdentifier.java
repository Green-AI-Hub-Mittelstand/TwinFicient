package de.dfki.cos.twinficient.digitaltwin.initializer;

import de.dfki.cos.twinficient.digitaltwin.initializer.builder.SubmodelIdentifier;

public enum HeaterDefinitionSubmodelIdentifier implements SubmodelIdentifier {

	TechnicalData;

	@Override
	public String description() {
		return name();
	}
}
