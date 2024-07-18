package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

public class EnvironmentBasedTwinficientConfiguration implements TwinficientConfiguration{

	public static final String ENV_TWINFICIENT_DATAINTEGRATION_URL = "TF_DATAINTEGRATION_URL";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_TOKEN = "TF_DATAINTEGRATION_TOKEN";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_BUCKET = "TF_DATAINTEGRATION_BUCKET";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_ORG = "TF_DATAINTEGRATION_ORG";
	
	@Override
	public String getUrl() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_URL);
	}
	
	@Override
	public String getToken() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_TOKEN);
	}
	
	@Override
	public String getBucket() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_BUCKET);
	}

	@Override
	public String getOrg() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_ORG);
	}

}
