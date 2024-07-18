package de.dfki.cos.twinficient.digitaltwin.dataintegration.publish;

import com.influxdb.client.write.Point;

public interface DataPointPublisher {

	void publishDataPoint(Point point);

	void flush();

}
