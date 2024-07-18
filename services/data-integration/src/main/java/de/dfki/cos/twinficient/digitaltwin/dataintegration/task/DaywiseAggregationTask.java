package de.dfki.cos.twinficient.digitaltwin.dataintegration.task;

import java.time.Instant;


public interface DaywiseAggregationTask {

	void aggregateDaywise(Instant instant, Instant instant2, Instant instant3);
	
}
