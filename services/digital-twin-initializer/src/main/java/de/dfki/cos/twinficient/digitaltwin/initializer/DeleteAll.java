package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.ConceptDescriptionRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.ConceptDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetConceptDescriptionsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;

import de.dfki.cos.twinficient.digitaltwin.initializer.builder.BasyxResourceBuilder;
import de.dfki.cos.twinficient.digitaltwin.initializer.builder.IdGenerator;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.BasyxV3Apis;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.BasyxV3HttpServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class DeleteAll {

	private static final String ENV_TF_AAS_REPO_ADDRESS = "TF_AAS_REPO_ADDRESS";
	private static final String ENV_TF_SM_REPO_ADDRESS = "TF_SM_REPO_ADDRESS";
	private static final String ENV_TF_CONCEPT_DESCR_REPO_ADDRESS = "TF_CONCEPT_DESCR_REPO_ADDRESS";

	private static final Logger LOGGER = Logger.getLogger(DeleteAll.class.getName());

	public static void main(String[] args) throws ApiException {
		String shellRepoServiceAddress = getServiceAddress(ENV_TF_AAS_REPO_ADDRESS);
		String submodelRepoServiceAddress = getServiceAddress(ENV_TF_SM_REPO_ADDRESS);
		String conceptDescriptionRepoServiceAddress = getServiceAddress(ENV_TF_CONCEPT_DESCR_REPO_ADDRESS);
		if (args.length > 0 && "all".equals(args[0])) {
			deleteAll(shellRepoServiceAddress, submodelRepoServiceAddress, conceptDescriptionRepoServiceAddress);
		} else {
			deleteTwinficientResources(shellRepoServiceAddress, submodelRepoServiceAddress);
		}
	}

	private static void deleteAll(String shellRepoServiceAddress, String submodelRepoServiceAddress, String conceptDescriptionRepoServiceAddress) throws ApiException {
		deleteShells(shellRepoServiceAddress);
		deleteSubmodels(submodelRepoServiceAddress);
		deleteConceptDescription(conceptDescriptionRepoServiceAddress);
	}

	private static void deleteTwinficientResources(String shellRepoAddress, String submodelRepoAddress) throws ApiException {
		IdGenerator idGenerator = new TwinficientIdGenerator();
		BasyxV3Apis apis = new BasyxV3Apis(shellRepoAddress, submodelRepoAddress);
		BasyxResourceBuilder builder = new TwinficientResourceBuilder(idGenerator);
		BasyxV3HttpServiceFacade facade = new BasyxV3HttpServiceFacade(apis, builder, idGenerator);
		Set<BasyxRecord> records = facade.fetchAll();
		facade.update(Set.of(), records);
	}

	private static void deleteSubmodels(String submodelRepoServiceAddress) throws ApiException {
		SubmodelRepositoryApi api = new SubmodelRepositoryApi(submodelRepoServiceAddress);
		String cursor = null;
		do {
			GetSubmodelsResult result = api.getAllSubmodels(null, null, 100, cursor, null, null);
			for (Submodel descr : result.getResult()) {
				LOGGER.info("Deleting submodel " + descr.getId());
				api.deleteSubmodelById(descr.getId());
			}
			cursor = result.getPagingMetadata().getCursor();
		} while (cursor != null);
	}

	private static void deleteShells(String shellRepoServiceAddress) throws ApiException {
		AssetAdministrationShellRepositoryApi api = new AssetAdministrationShellRepositoryApi(shellRepoServiceAddress);
		String cursor = null;
		do {
			GetAssetAdministrationShellsResult result = api.getAllAssetAdministrationShells(null, null, 100, cursor);
			for (AssetAdministrationShell descr : result.getResult()) {
				LOGGER.info("Deleting shell " + descr.getId());
				api.deleteAssetAdministrationShellById(descr.getId());
			}
			cursor = result.getPagingMetadata().getCursor();
		} while (cursor != null);

	}

	private static void deleteConceptDescription(String url) throws ApiException {

		ConceptDescriptionRepositoryApi cdApi = new ConceptDescriptionRepositoryApi(url);
		String cursor = null;
		do {
			GetConceptDescriptionsResult result = cdApi.getAllConceptDescriptions(null, null, null, 100, cursor);
			for (ConceptDescription descr : result.getResult()) {
				LOGGER.info("Deleting concept description " + descr.getId());
				cdApi.deleteConceptDescriptionById(descr.getId());
			}
			cursor = result.getPagingMetadata().getCursor();
		} while (cursor != null);

	}

	private static String getEnv(String envName) {
		String env = System.getenv(envName);
		if (env == null) {
			throw new IllegalArgumentException("Environment variable '" + envName + "' not set.");
		}
		return env;
	}

	private static String getServiceAddress(String envName) {
		String url = getEnv(envName);
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("Not a valid server URL:" + url);
		}
		return url;
	}
}