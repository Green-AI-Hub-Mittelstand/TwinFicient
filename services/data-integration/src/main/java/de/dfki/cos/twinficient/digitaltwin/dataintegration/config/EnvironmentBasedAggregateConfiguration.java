package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.time.Duration;

public class EnvironmentBasedAggregateConfiguration implements AggregateConfiguration {


	public static final String ENV_TWINFICIENT_DATAINTEGRATION_AGGREGATE_SCORE_BUCKET = "TF_DATAINTEGRATION_AGGREGATE_SCORE_BUCKET";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_AGGREGATE_DEFAULT_BUCKET = "TF_DATAINTEGRATION_AGGREGATE_DEFAULT_BUCKET";
	public static final String ENV_TWINFICIENT_DATAINTEGRATION_FETCH_DEPLAY = "TF_DATAINTEGRATION_AGGREGATE_FETCH_DELAY";
	
	@Override
	public Duration getAggregationDelay() {
		String durationAsString = System.getenv(ENV_TWINFICIENT_DATAINTEGRATION_FETCH_DEPLAY);
		if (durationAsString == null) {
			return Duration.ofSeconds(0);
		}
		return Duration.parse(durationAsString);
	}
	
	@Override
	public String getScoreBucket() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_AGGREGATE_SCORE_BUCKET);
	}

	@Override
	public String getAggregationBucket() {
		return EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_AGGREGATE_DEFAULT_BUCKET);
	}
	

}
