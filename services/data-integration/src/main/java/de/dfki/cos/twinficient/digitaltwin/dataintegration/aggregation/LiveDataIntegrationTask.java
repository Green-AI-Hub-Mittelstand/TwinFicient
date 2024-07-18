package de.dfki.cos.twinficient.digitaltwin.dataintegration.aggregation;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Logger;

import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.TemplateFileConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.publish.DataPointPublisher;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.query.QueryManager;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.query.QueryTemplate;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.AbstractAggregationTask;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.task.AggregationTaskManager.LiveDataInfo;


public class LiveDataIntegrationTask extends AbstractAggregationTask {

	private final DataPointPublisher publisher;
	
	private final QueryApi qApi;
	private final QueryTemplate templateCel;
	private final QueryTemplate templateHz;
	private final QueryTemplate templateHg;
	
	private final LiveDataInfo sInfo;
	
	private Logger logger = Logs.getLogger(LiveDataIntegrationTask.class);
	
	public LiveDataIntegrationTask(LiveDataInfo sInfo, DataPointPublisher publisher, Duration interval, TemplateFileConfiguration conf) {
		super(interval);
		this.sInfo = sInfo;
		this.publisher = publisher;
		this.qApi = sInfo.getQueryApi();
		this.templateCel = QueryTemplate.fromFile(conf, "remoteCel.flux");
		this.templateHz = QueryTemplate.fromFile(conf, "remoteHz.flux");
		this.templateHg = QueryTemplate.fromFile(conf, "remoteHg.flux");
	}

	@Override
	protected void aggregate(Instant current, Instant stop) {
		Map<String, Object> data = Map.of("start", current, "stop", stop, "srcBucket", "\""+sInfo.getBucket()+ "\"");
		
		logger.finest("Fetching from " + current + " to " + stop);
		
		String celQuery = templateCel.toQuery(data);
		String hzQuery = templateHz.toQuery(data);
		String hgQuery = templateHg.toQuery(data);
		
		List<FluxTable> celTables = qApi.query(celQuery);
		List<FluxTable> hzTables = qApi.query(hzQuery);
		
		QueryManager manager = new QueryManager(qApi, sInfo.getOrg());
		
		DataJoiner joiner = new DataJoiner(celTables, hzTables, publisher::publishDataPoint);
		Consumer<FluxRecord> onNext = (r->joiner.joinRecord(r));
		manager.runAsyncBlocking(hgQuery, onNext);		
		publisher.flush();
	}
}
