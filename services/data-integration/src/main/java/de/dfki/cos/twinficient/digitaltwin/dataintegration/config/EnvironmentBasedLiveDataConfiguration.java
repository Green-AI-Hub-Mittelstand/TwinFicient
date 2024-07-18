package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

public class EnvironmentBasedLiveDataConfiguration implements LiveDataConfiguration {
	
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_URL = "TF_DATAINTEGRATION_LIVE_SOURCE_URL";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_TOKEN = "TF_DATAINTEGRATION_LIVE_SOURCE_TOKEN";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_BUCKET = "TF_DATAINTEGRATION_LIVE_SOURCE_BUCKET";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_ORG = "TF_DATAINTEGRATION_LIVE_SOURCE_ORG";
	
	
	@Override
	public String getUrl() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_URL);
	}
	
	@Override
	public String getToken() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_TOKEN);
	}
	
	@Override
	public String getBucket() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_BUCKET);
	}

	@Override
	public String getOrg() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_ORG);
	}
	
}
