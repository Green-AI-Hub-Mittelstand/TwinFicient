package de.dfki.cos.twinficient.digitaltwin.dataintegration.task;

import java.time.Instant;
import java.util.Optional;
import java.util.logging.Logger;

import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApi;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;

public class AggregationTaskManager {

	private static final Logger LOGGER = Logs.getLogger(AggregationTaskManager.class);
	
	
	private AggregationTask task;

	public AggregationTaskManager(AggregationTask task) {
		this.task = task;
	}
	
		
	public void process(Optional<Instant> firstSourceRecordTimeOpt, Optional<Instant> lastSourceRecordTimeOpt, Optional<Instant> lastTargetRecordTimeOpt) {
		LOGGER.info("Start live data integration");
		
		if (lastTargetRecordTimeOpt.isPresent() && firstSourceRecordTimeOpt.isPresent()) {
			Instant lastTargetRecordTime = lastTargetRecordTimeOpt.get();
			Instant firstSourceRecordTime = firstSourceRecordTimeOpt.get();
			if (firstSourceRecordTime.isBefore(lastTargetRecordTime)) {
				LOGGER.info("Some data was already transfered. Copy from: " + lastTargetRecordTime.toString());
				if (lastTargetRecordTime.isAfter(lastSourceRecordTimeOpt.get())) {
					LOGGER.info("No newData.");		
				} else {
					task.aggregateFrom(lastTargetRecordTime, lastSourceRecordTimeOpt.get());
				}
			} else {
				LOGGER.info("Some data was already published by telegraf sqlite import. Copy from: " + firstSourceRecordTime.toString());
				task.aggregateFrom(firstSourceRecordTime, lastSourceRecordTimeOpt.get());
			}
		} else if (firstSourceRecordTimeOpt.isPresent()) {
			Instant sourceStart = firstSourceRecordTimeOpt.get();
			LOGGER.info("No data in target bucket. Copy from: " + sourceStart.toString());
			task.aggregateFrom(sourceStart, lastSourceRecordTimeOpt.get());
		} else {
			LOGGER.info("No data in source bucket.");
		}
	}

	public static abstract class DataInfo {
		
		private final String bucket;
		private final String org;
		private final QueryApi qApi;
		
		public DataInfo(QueryApi qApi, String bucket, String org) {
			this.bucket = bucket;
			this.org = org;
			this.qApi = qApi;
		}
		
		public QueryApi getQueryApi() {
			return qApi;
		}

		public String getBucket() {
			return bucket;
		}
		
		public String getOrg() {
			return org;
		}
	}
	
	public static final class LiveDataInfo extends DataInfo {

		public LiveDataInfo(QueryApi qApi, String bucket, String org) {
			super(qApi, bucket, org);
		}
	}

	public static final class TwinficientInfo extends DataInfo {

		private final WriteApi wApi;

		public TwinficientInfo(QueryApi qApi, WriteApi wApi, String bucket, String org) {
			super(qApi, bucket, org); 
			this.wApi = wApi;
		}

		public WriteApi getWriteApi() {
			return wApi;
		}
	}

}