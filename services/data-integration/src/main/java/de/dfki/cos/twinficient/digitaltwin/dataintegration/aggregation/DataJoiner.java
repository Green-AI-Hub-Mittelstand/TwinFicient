package de.dfki.cos.twinficient.digitaltwin.dataintegration.aggregation;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Fields;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.Tags;

public class DataJoiner {
	
	private static final List<String> VALUES_TO_IGNORE = List.of(Tags.COMPANY, Tags.CEL_NR, Tags.HZ_NR, Tags.HG_NR, "result",  "table", "_time");
	
	private Consumer<Point> recordConsumer;
	private final Map<RecordKey, Map<String, Object>> celValues = new HashMap<>();
	private final Map<RecordKey, Map<String, Object>> hzValues = new HashMap<>();
	
	public DataJoiner(List<FluxTable> celTables, List<FluxTable> hzTables, Consumer<Point> recordConsumer) {
		this.recordConsumer = recordConsumer;
		putRecords(celTables, celValues, CelestraId::fromRecord);
		putRecords(hzTables, hzValues, HeatingzoneId::fromRecord);
	}
	
	public void joinTables(List<FluxTable> hgTables)  {
		for (FluxTable eachTable : hgTables) {
			for (FluxRecord eachRecord : eachTable.getRecords()) {
				joinRecord(eachRecord);
			}
		}
	}
	

	public void joinRecord(FluxRecord record) {
		Point dp = createDataPoint(record, celValues, hzValues);
		if (dp != null) {
			recordConsumer.accept(dp);	
		}
		
	}	

	private void putRecords(List<FluxTable> celTables, Map<RecordKey, Map<String, Object>> celValues, Function<FluxRecord, RecordId> recordIdGenerator) {
		for (FluxTable eachTable : celTables) {
			for (FluxRecord eachRecord : eachTable.getRecords()) {
				putRecord(eachRecord, celValues, recordIdGenerator);
			}
		}
	}

	private void putRecord(FluxRecord eachRecord, Map<RecordKey, Map<String, Object>> celValues, Function<FluxRecord, RecordId> recordIdGenerator) {
		RecordId celId = recordIdGenerator.apply(eachRecord);
		RecordKey key = new RecordKey(eachRecord.getTime(), celId);
		celValues.put(key, eachRecord.getValues());
	}

	private Point createDataPoint(FluxRecord record, Map<RecordKey, Map<String, Object>> celMap, Map<RecordKey, Map<String, Object>> hzMap) {
		Point point = Point.measurement("celestra");
		Instant time = record.getTime();
		point.time(time, WritePrecision.NS);
		
		String company = (String) record.getValueByKey(Tags.COMPANY);
		String celNr = (String) record.getValueByKey(Tags.CEL_NR);
		String hzNr = (String) record.getValueByKey(Tags.HZ_NR);
		String hgNr = (String) record.getValueByKey(Tags.HG_NR);

		point.addTag(Tags.COMPANY, company);
		point.addTag(Tags.CEL_NR, celNr);
		point.addTag(Tags.HZ_NR, hzNr);
		point.addTag(Tags.HG_NR, hgNr);

		CelestraId celId = new CelestraId(company, celNr);
		Map<String, Object> celValues = celMap.get(new RecordKey(time, celId));
		HeatingzoneId hzId = new HeatingzoneId(celId, hzNr);
		Map<String, Object> hzValues  = hzMap.get(new RecordKey(time, hzId));
		
		if (celValues == null || hzValues == null) {
			return null;
		}
		addValues(point, celValues);
		addValues(point, hzValues);
		addValues(point, record.getValues());
		
		return point;
	}

	private void addValues(Point point, Map<String, Object> values) {
		if (values == null) {
			return;
		}
		Predicate<Entry<String, Object>> filter = e->e.getValue() != null && !VALUES_TO_IGNORE.contains(e.getKey());		
		Map<String, Object> value = values.entrySet().stream().filter(filter).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		
		point.addFields(value);
	}
	
	private static class RecordKey {
		
		private final Instant time;
		private final RecordId id;
		
		public RecordKey(Instant time, RecordId id) {
			this.time = time;
			this.id = id;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, time);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RecordKey other = (RecordKey) obj;
			return Objects.equals(id, other.id) && Objects.equals(time, other.time);
		}
	}
	
	private static interface RecordId {
	}
	
	private static final class CelestraId implements RecordId {
		
		private final String company;
		private final String celNr;

		private CelestraId(String company, String celNr) {
			this.company = company;
			this.celNr = celNr;
		}
		
		private static CelestraId fromRecord(FluxRecord record) {
			String company = (String) record.getValueByKey(Tags.COMPANY);
			String celNr = (String) record.getValueByKey(Tags.CEL_NR);
			return new CelestraId(company, celNr);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(celNr, company);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CelestraId other = (CelestraId) obj;
			return Objects.equals(celNr, other.celNr) && Objects.equals(company, other.company);
		}				
	}
	
	private static final class HeatingzoneId implements RecordId {
				
		private final CelestraId celId;
		private final String hzNr;
		
		public HeatingzoneId(CelestraId celId, String hzNr) {
			this.celId = celId;
			this.hzNr = hzNr;
		}
		
		private static HeatingzoneId fromRecord(FluxRecord record) {
			CelestraId id = CelestraId.fromRecord(record);
			String hzNr = (String) record.getValueByKey(Tags.HZ_NR);
			return new HeatingzoneId(id, hzNr);
		}

		@Override
		public int hashCode() {
			return Objects.hash(celId, hzNr);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HeatingzoneId other = (HeatingzoneId) obj;
			return Objects.equals(celId, other.celId) && Objects.equals(hzNr, other.hzNr);
		}
	}

}