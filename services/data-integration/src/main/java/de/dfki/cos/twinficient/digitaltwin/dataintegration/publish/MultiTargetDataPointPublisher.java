package de.dfki.cos.twinficient.digitaltwin.dataintegration.publish;

import java.util.List;

import com.influxdb.client.write.Point;

public class MultiTargetDataPointPublisher implements DataPointPublisher {

	private final List<DataPointPublisher> publishers;
	
	public MultiTargetDataPointPublisher(DataPointPublisher... publishers) {
		this.publishers = List.of(publishers);
	}
	
	@Override
	public void publishDataPoint(Point point) {
		for (DataPointPublisher eachPublisher : publishers) {
			eachPublisher.publishDataPoint(point);
		}
	}

	@Override
	public void flush() {
		for (DataPointPublisher eachPublisher : publishers) {
			eachPublisher.flush();
		}
	}
}