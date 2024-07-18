package de.dfki.cos.twinficient.digitaltwin.dataintegration.task;

import java.time.Instant;


public interface AggregationTask {


	public void aggregateFrom(Instant start, Instant stop);
	
}
