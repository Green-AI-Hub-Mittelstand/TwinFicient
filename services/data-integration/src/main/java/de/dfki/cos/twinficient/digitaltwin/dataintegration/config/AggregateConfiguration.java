package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.time.Duration;

public interface AggregateConfiguration {

	String getScoreBucket();
	
	String getAggregationBucket();

	Duration getAggregationDelay();
}
