package de.dfki.cos.twinficient.digitaltwin.dataintegration.publish;

import java.time.Instant;
import java.util.logging.Logger;

import com.influxdb.client.write.Point;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;

public class LoggingDataPointPublisher implements DataPointPublisher {

	private static final Logger LOGGER = Logs.getLogger(LoggingDataPointPublisher.class);

	@Override
	public void publishDataPoint(Point point) {
		LOGGER.finer(Instant.ofEpochMilli(point.getTime().longValue() / 1000000) +  " - " + point.toLineProtocol());
	}

	@Override
	public void flush() {

	}

}
