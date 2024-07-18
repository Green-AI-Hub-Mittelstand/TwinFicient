package de.dfki.cos.twinficient.digitaltwin.dataintegration.publish;

import java.util.logging.Logger;

import com.influxdb.client.WriteApi;
import com.influxdb.client.write.Point;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;


public class TargetDataPublisher implements DataPointPublisher {

	private static final Logger LOGGER = Logs.getLogger(TargetDataPublisher.class);
	
	private final WriteApi api;
	private final String bucket;
	private final String org;
	
	public TargetDataPublisher(WriteApi api, String bucket, String org) {
		this.api = api;
		this.bucket = bucket;
		this.org = org;
	}
	
	@Override
	public void publishDataPoint(Point point) {
		LOGGER.finest("Writing data to " + bucket + "/"+org +"/"+point.toLineProtocol());
		api.writePoint(bucket, org, point);
	}
	
	@Override
	public void flush() {
		api.flush();
	}
}