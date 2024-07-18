package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.util.Optional;

public interface DataIntegrationConfig {

	ProcessConfiguration getProcessConfiguration();
	
	Optional<LiveDataConfiguration> getLiveDataConfiguration();
	
	TwinficientConfiguration getTwinficientConfiguration();
	
	AggregateConfiguration getAggregateConfiguration();
	
}
