package de.dfki.cos.twinficient.digitaltwin.dataintegration.task;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.logging.Logger;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;

public class DaywiseTimeAggregationTaskAdapter implements AggregationTask {

	private final Logger logger = Logs.getLogger(DaywiseTimeAggregationTaskAdapter.class);
	private final DaywiseAggregationTask task;
	private final Duration delay;

	public DaywiseTimeAggregationTaskAdapter(DaywiseAggregationTask task, Duration delay) {
		this.task = task;
		this.delay = delay;
	}

	@Override
	public void aggregateFrom(Instant start, Instant stop) {
		LocalDateTime startTime = LocalDateTime.ofInstant(start, ZoneId.systemDefault());
		LocalDateTime stopTime = LocalDateTime.ofInstant(stop, ZoneId.systemDefault());

		LocalDateTime startOfDay = startTime.with(LocalTime.MIN);
		LocalDateTime nextDay = startOfDay.plus(Duration.ofDays(1));
		LocalDateTime endOfDay = nextDay.minus(Duration.ofNanos(1));
		do {
			long tStart = System.currentTimeMillis();
			task.aggregateDaywise(toInstant(startOfDay), toInstant(endOfDay), toInstant(nextDay));
			long tEnd = System.currentTimeMillis();
			logger.fine("Moving " + startOfDay + " records tooked " + (tEnd - tStart) + " ms");
			startOfDay = nextDay;
			nextDay = startOfDay.plus(Duration.ofDays(1));
			endOfDay = nextDay.minus(Duration.ofNanos(1));

			sleep();

		} while (startOfDay.isBefore(stopTime) && !stop.isAfter(Instant.now()));
	}

	private void sleep() {
		long millis = delay.toMillis();
		if (millis > 0) {
			try {
				logger.fine("Sleeping " + millis + " ms between day aggregation");
				Thread.sleep(delay.toMillis());
			} catch (InterruptedException e) {
			}
		}

	}

	private Instant toInstant(LocalDateTime ldt) {
		return ldt.atZone(ZoneId.systemDefault()).toInstant();
	}
}
