package de.dfki.cos.twinficient.digitaltwin.dataintegration.time;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.influxdb.client.QueryApi;
import com.influxdb.client.domain.Query;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.query.QueryTemplate;

public class TimeQuery {

	private final QueryApi api;
	private final QueryTemplate template;
	
	public TimeQuery(QueryApi api, QueryTemplate template) {
		this.api = api;	
		this.template = template;
	}
	
	public Optional<RecordInterval> getRecordTimeInfo(String bucket, String measurement, String field) {
		Map<String, Object> params = Map.of("bucket", "\"" + bucket + "\"", "measurement", "\"" + measurement + "\"", "field", "\"" + field + "\"");
		String sQuery = template.toQuery(params);
		List<FluxTable> result = api.query(sQuery);
		if (result.isEmpty()) {
			return Optional.empty();
		}
		FluxTable table =  result.get(0);
		List<FluxRecord> records = table.getRecords();
		if (records.isEmpty()) {
			return Optional.empty();
		}
		FluxRecord record = records.get(0);
		Instant first = (Instant) record.getValueByKey("first");
		Instant last = (Instant) record.getValueByKey("last");
		return Optional.of(new RecordInterval(first, last));
	}
	
	private Optional<Instant> recordTime(String bucket, String func, String... filters) {
		StringBuilder builder = new StringBuilder();
		builder.append("from(bucket: \"");
		builder.append(bucket);
		builder.append("\") ");
		builder.append("\n\t |> range(start: 0)  ");
		for (String eachFilter : filters) {
			builder.append("\n\t |> filter(fn: (r) => ");
			builder.append(eachFilter);
			builder.append(")");
		}
		builder.append("\n\t |> group(columns: []) |>");
		builder.append(func);
		builder.append("() \n\t |> keep(columns: [\"_time\"])  |> limit(n: 1) |> yield()");
		
		List<FluxTable> tables = api.query(new Query().query(builder.toString()));
		if (!tables.isEmpty()) {
			List<FluxRecord> records = tables.get(0).getRecords();
			if (!records.isEmpty()) {
				return Optional.of(records.get(0).getTime());
			}
		}
		return Optional.empty();
	}
	
	
	public static class RecordInterval {
		
		private Instant from;
		private Instant to;
		
		public RecordInterval(Instant from, Instant to) {
			this.from = from;
			this.to = to;
		}
		
		public boolean hasData() {
			return from != null && from != null;
		}
		
		public Instant getFrom() {
			return from;
		}
		
		public Instant getTo() {
			return to;
		}

		@Override
		public String toString() {
			return "RecordInterval [from=" + from + ", to=" + to + "]";
		}
	}
}
