package de.dfki.cos.twinficient.digitaltwin.initializer.io.http;

import java.util.Set;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public interface DigitalTwinServiceFacade {


	Set<BasyxRecord> fetchAll() throws ApiException;

	void update(Set<BasyxRecord> added, Set<BasyxRecord> removed) throws ApiException;
	
}