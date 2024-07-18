package de.dfki.cos.twinficient.digitaltwin.dataintegration.aggregation;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Fields;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.Tags;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.building.VirtualBuilding;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.building.VirtualBuildingProvider;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.TemplateFileConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.publish.DataPointPublisher;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.query.QueryManager;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.query.QueryTemplate;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.AggregationTaskManager.TwinficientInfo;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.DaywiseAggregationTask;

public class DataAggregationTask implements DaywiseAggregationTask {

	private final String srcBucket;
	private final QueryTemplate template;
	private final QueryManager manager;
	private final DataPointPublisher rtErrPublisher;
	private final DataPointPublisher scorePublisher;
	private final VirtualBuildingProvider vbProvider;
	
	private final Logger LOGGER = Logs.getLogger(DataAggregationTask.class); 

	public DataAggregationTask(TwinficientInfo sInfo, DataPointPublisher rtErrPublisher, DataPointPublisher scorePublisher, VirtualBuildingProvider vbProvider, TemplateFileConfiguration conf) {
		this.rtErrPublisher = rtErrPublisher;
		this.scorePublisher = scorePublisher;
		this.srcBucket = sInfo.getBucket();
		this.vbProvider = vbProvider;
		template = QueryTemplate.fromFile(conf, "aggregations.flux");
		manager = new QueryManager(sInfo.getQueryApi(), sInfo.getOrg());
	}

	@Override
	public void aggregateDaywise(Instant startOfDay, Instant endOfDay, Instant nextDay) {
		Map<String, Object> params = Map.of("startOfDay", startOfDay.toString(), "endOfDay", endOfDay.toString(), "srcBucket", "\"" + srcBucket + "\"");
		String query = template.toQuery(params);
		
		manager.runAsyncBlocking(query, this::handleRecord);
		rtErrPublisher.flush();
		scorePublisher.flush();
	}

	private void handleRecord(FluxRecord record) {

		String company = (String) record.getValueByKey(Tags.COMPANY);
		String celNr = (String) record.getValueByKey(Tags.CEL_NR);
		String hzNr = (String) record.getValueByKey(Tags.HZ_NR);
		String hgNr = (String) record.getValueByKey(Tags.HG_NR);
		
		if (company == null || celNr == null || hzNr == null || hgNr == null) {
			return;
		}
		
		Optional<VirtualBuilding> buildingOpt = vbProvider.getVirtualBuilding(company, celNr);
		
		Double runtimePerDay = (Double) record.getValueByKey(Fields.RUNTIME_PER_DAY);
		Long errorCodesPerDay = (Long) record.getValueByKey(Fields.ERROR_CODES_PER_DAY);
		Double degreeDay = (Double) record.getValueByKey(Fields.DEGREE_DAY);
		
		// Due to historical decisions we store the datapoints in different buckets
		// -> because the digital twin (Building-Tag) entries could change, only one bucket could will be out-dated then and should be be refreshed
		// But, as we query all values in one step now, it will be possible in a future approach to store
		// everything in one bucket and adapt the dash-boards
		
		Point rtAndErrorPoint = new Point("aggregations")
				.time(record.getTime(), WritePrecision.NS)
				.addTag(Tags.COMPANY, company)
				.addTag(Tags.CEL_NR, celNr)
				.addTag(Tags.HZ_NR, hzNr)
				.addTag(Tags.HG_NR, hgNr)
				.addField(Fields.RUNTIME_PER_DAY, runtimePerDay)
				.addField(Fields.ERROR_CODES_PER_DAY, errorCodesPerDay);
		rtErrPublisher.publishDataPoint(rtAndErrorPoint);
		
		Point scorePoint = new Point("aggregations")
				.time(record.getTime(), WritePrecision.NS)
				.addTag(Tags.COMPANY, company)
				.addTag(Tags.CEL_NR, celNr)
				.addTag(Tags.HZ_NR, hgNr)
				.addTag(Tags.HG_NR, hgNr)
				.addField(Fields.DEGREE_DAYS_IN_INTERVAL, degreeDay)
				.addField(Fields.RT_IN_INTERVAL, runtimePerDay);
		if (buildingOpt.isPresent()) {
			scorePoint.addTag(Tags.BUILDING, buildingOpt.get().getName());
			scorePublisher.publishDataPoint(scorePoint);
		} else {
			LOGGER.finest("No building info found for " + company+"/"+ celNr);
		}
	}

}
