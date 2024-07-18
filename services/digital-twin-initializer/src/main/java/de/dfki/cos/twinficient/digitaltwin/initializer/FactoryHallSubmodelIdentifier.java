package de.dfki.cos.twinficient.digitaltwin.initializer;

import de.dfki.cos.twinficient.digitaltwin.initializer.builder.SubmodelIdentifier;

public enum FactoryHallSubmodelIdentifier implements SubmodelIdentifier {

	topology;

	@Override
	public String description() {
		return name();
	}
}
