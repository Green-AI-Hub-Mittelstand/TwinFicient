package de.dfki.cos.twinficient.digitaltwin.initializer.io.http;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;

import de.dfki.cos.twinficient.digitaltwin.initializer.builder.BasyxResourceBuilder;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.IdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class BasyxV3HttpServiceFacade implements DigitalTwinServiceFacade {

	private final BasyxV3Apis apis;
	private final BasyxResourceBuilder builder;
	private final IdGenerator idGenerator;

	private final Logger logger = Logger.getLogger(BasyxV3HttpServiceFacade.class.getName());

	public BasyxV3HttpServiceFacade(BasyxV3Apis apis, BasyxResourceBuilder builder, IdGenerator idGenerator) {
		this.apis = apis;
		this.builder = builder;
		this.idGenerator = idGenerator;
	}

	@Override
	public void update(Set<BasyxRecord> added, Set<BasyxRecord> removed) throws ApiException {
		deleteAll(removed);
		addAll(added);
	}

	@Override
	public Set<BasyxRecord> fetchAll() throws ApiException {
		int limit = 20;
		String cursor = null;
		Set<BasyxRecord> allRecords = new HashSet<>();
		do {
			GetAssetAdministrationShellsResult result = apis.aasRepoApi().getAllAssetAdministrationShells(null, null, limit, cursor);
			cursor = result.getPagingMetadata().getCursor();
			for (AssetAdministrationShell eachShell : result.getResult()) {
				Optional<BasyxRecord> basyxRecordOpt = builder.generateBasyxRecord(eachShell);
				if (basyxRecordOpt.isPresent()) {
					allRecords.add(basyxRecordOpt.get());
				}
			}
		} while (cursor != null);
		logger.info("Fetched " + allRecords.size() + " basyx records.");
		return allRecords;
	}

	private void deleteAll(Set<BasyxRecord> toRemove) throws ApiException {
		AssetAdministrationShellRepositoryApi repoApi = apis.aasRepoApi();
		SubmodelRepositoryApi smApi = apis.smRepoApi();

		for (BasyxRecord eachRecord : toRemove) {
			String id = idGenerator.generateShellId(eachRecord.getIdentifier());
			logger.info("Deleting shell " + id);
			try {
				repoApi.deleteAssetAdministrationShellById(id);
			} catch (ApiException ex) {
				logger.warning(ex.getMessage());
			}

			Collection<String> smIds = idGenerator.generateSubmodelIds(eachRecord).values();
			for (String eachSmId : smIds) {
				logger.info("Deleting submodel " + eachSmId);
				try {
					smApi.deleteSubmodelById(eachSmId);
				} catch (ApiException ex) {
					logger.warning(ex.getMessage());
				}
			}
		}
	}

	private void addAll(Set<BasyxRecord> toAdd) throws ApiException {
		AssetAdministrationShellRepositoryApi repoApi = apis.aasRepoApi();
		SubmodelRepositoryApi smApi = apis.smRepoApi();
		for (BasyxRecord eachRecord : toAdd) {
			AssetAdministrationShell shell = builder.generateShell(eachRecord);
			logger.info("Adding shell " + shell.getId());
			repoApi.postAssetAdministrationShell(shell);
			List<Submodel> submodels = builder.generateSubmodels(eachRecord);
			for (Submodel eachSubmodel : submodels) {
				logger.info("Adding submodel " + eachSubmodel.getId());
				smApi.postSubmodel(eachSubmodel);
			}
		}
	}

}
