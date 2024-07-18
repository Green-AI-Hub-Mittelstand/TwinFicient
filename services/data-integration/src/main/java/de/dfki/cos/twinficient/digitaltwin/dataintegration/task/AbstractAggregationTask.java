package de.dfki.cos.twinficient.digitaltwin.dataintegration.task;

import java.time.Duration;
import java.time.Instant;


public abstract class AbstractAggregationTask implements AggregationTask {

	private final Duration duration;
	
	
	public AbstractAggregationTask(Duration duration) {
		this.duration = duration;
	}
	
	@Override
	public void aggregateFrom(Instant start, Instant stop) {		
		Instant stepStart = start;
		while (stepStart.isBefore(stop)) {
			Instant nextStart = stepStart.plus(duration);
			Instant stepStop = nextStart.minus(Duration.ofNanos(1));
			if (stepStop.isAfter(stop)) {
				aggregate(stepStart, stop);
				return;
			} else {
				aggregate(stepStart, stepStop);
				stepStart = nextStart;
			}
		}
	}

	protected abstract void aggregate(Instant current, Instant stop);

}
