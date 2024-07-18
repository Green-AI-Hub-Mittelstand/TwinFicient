package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.time.Duration;

public class EnvironmentBasedProcessConfiguration implements ProcessConfiguration {

	public static final String ENV_TWINFICIENT_DATAINTEGRATION_FETCH_FREQUENCY = "TF_DATAINTEGRATION_FETCH_FREQUENCY";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_DISABLE_TASKS = "TF_DATAINTEGRATION_DISABLE_TASKS";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_STARTUP_DEPLAY = "TF_DATAINTEGRATION_STARTUP_DELAY";

	
	@Override
	public Duration getStartUpDelay() {
		String durationAsString = System.getenv(ENV_TWINFICIENT_DATAINTEGRATION_STARTUP_DEPLAY);
		if (durationAsString == null) {
			return Duration.ofSeconds(0);
		}
		return Duration.parse(durationAsString);
	}
	
	@Override
	public boolean isDisableTasks() {
		String disableTasks = System.getenv(ENV_TWINFICIENT_DATAINTEGRATION_DISABLE_TASKS);
		return disableTasks != null && Boolean.parseBoolean(disableTasks);
	}
	
	@Override
	public Duration getFetchFrequency() {
		String durationAsString = EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_FETCH_FREQUENCY);
		return Duration.parse(durationAsString);
	}
}
