package de.dfki.cos.twinficient.digitaltwin.initializer.builder;

import java.util.List;
import java.util.Optional;

import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public interface BasyxResourceBuilder {

	List<Submodel> generateSubmodels(BasyxRecord record);

	AssetAdministrationShell generateShell(BasyxRecord record);

	Optional<BasyxRecord> generateBasyxRecord(AssetAdministrationShell shell);
	
}
