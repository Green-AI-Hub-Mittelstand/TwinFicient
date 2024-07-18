package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.util.Map;

public class EnvironmentBasedAasProviderConfiguration implements AasProviderConfiguration {

	public static final String ENV_TWINFICIENT_DATAINTEGRATION_BASYX_AAS_REG_URL = "TF_DATAINTEGRATION_BASYX_AAS_REG_URL";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_BASYX_SM_REG_URL = "TF_DATAINTEGRATION_BASYX_SM_REG_URL";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_BASYX_HOST_MAPPING_PREFIX = "TF_DATAINTEGRATION_BASYX_HOSTMAPPING_";
	
	
	@Override
	public String getAasRegistryUrl() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_BASYX_AAS_REG_URL);
	}

	@Override
	public String getSmRegistryUrl() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_BASYX_SM_REG_URL);
	}

	@Override
	public Map<String, String> repoUrlMapping() {
		return EnvironmentVariables.getEnvMapping(ENV_TWINFICIENT_DATAINTEGRATION_BASYX_HOST_MAPPING_PREFIX);
	}


}
