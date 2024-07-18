package de.dfki.cos.twinficient.digitaltwin.dataintegration.building;

import java.util.Optional;

public interface VirtualBuildingProvider {

	public Optional<VirtualBuilding> getVirtualBuilding(String company, String celNr);
	
}
