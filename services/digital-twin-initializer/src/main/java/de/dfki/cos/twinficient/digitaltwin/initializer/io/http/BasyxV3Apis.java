package de.dfki.cos.twinficient.digitaltwin.initializer.io.http;

import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;

public class BasyxV3Apis {

	private final AssetAdministrationShellRepositoryApi aasRepoApi;
	private final SubmodelRepositoryApi smRepoApi;

	public BasyxV3Apis(String shellRepoAddress, String smRepoAddress) {
		this.aasRepoApi = new AssetAdministrationShellRepositoryApi(shellRepoAddress);
		this.smRepoApi = new SubmodelRepositoryApi(smRepoAddress);
	}
	
	public AssetAdministrationShellRepositoryApi aasRepoApi() {
		return aasRepoApi;
	}
	
	public SubmodelRepositoryApi smRepoApi() {
		return smRepoApi;
	}
}
