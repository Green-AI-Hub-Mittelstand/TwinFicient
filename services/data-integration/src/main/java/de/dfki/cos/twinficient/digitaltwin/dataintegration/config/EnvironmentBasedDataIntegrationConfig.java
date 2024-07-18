package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.util.Optional;

public class EnvironmentBasedDataIntegrationConfig implements DataIntegrationConfig {

	@Override
	public Optional<LiveDataConfiguration> getLiveDataConfiguration() {
		if (System.getenv(EnvironmentBasedLiveDataConfiguration.ENV_TWINFICIENT_DATAINTEGRATION_LIVE_SOURCE_URL) == null) {
			return Optional.empty();
		}
		return Optional.of(new EnvironmentBasedLiveDataConfiguration());
	}
	
	@Override
	public AggregateConfiguration getAggregateConfiguration() {
		return new EnvironmentBasedAggregateConfiguration();
	}
	
	@Override
	public ProcessConfiguration getProcessConfiguration() {
		return new EnvironmentBasedProcessConfiguration();
	}
	
	@Override
	public TwinficientConfiguration getTwinficientConfiguration() {
		return new EnvironmentBasedTwinficientConfiguration();
	}
}
