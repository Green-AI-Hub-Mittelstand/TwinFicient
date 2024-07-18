package de.dfki.cos.twinficient.digitaltwin.initializer.influx;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

import com.influxdb.client.BucketsApi;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.OrganizationsApi;
import com.influxdb.client.TasksApi;
import com.influxdb.client.domain.Bucket;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.Run;
import com.influxdb.client.domain.Run.StatusEnum;
import com.influxdb.client.domain.RunManually;
import com.influxdb.client.domain.Task;
import com.influxdb.exceptions.InfluxException;

import de.dfki.cos.twinficient.digitaltwin.initializer.Main;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.DigitalTwinServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class InvalidatingDigitalTwinServiceFacade implements DigitalTwinServiceFacade {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	private final DigitalTwinServiceFacade decorated;
	private final InfluxDBClient client;
	private final String bucketName;
	private final String orgName;

	public InvalidatingDigitalTwinServiceFacade(DigitalTwinServiceFacade decorated, InfluxDBClient client, String bucketName, String orgName) {
		this.decorated = decorated;
		this.client = client;
		this.bucketName = bucketName;
		this.orgName = orgName;
		createBucket();
	}

	@Override
	public void update(Set<BasyxRecord> added, Set<BasyxRecord> removed) throws ApiException {
		decorated.update(added, removed);
		if (!added.isEmpty() || !removed.isEmpty()) {
			invalidateBucket();
		}
	}

	@Override
	public Set<BasyxRecord> fetchAll() throws ApiException {
		return decorated.fetchAll();
	}

	private void invalidateBucket() {
		LOGGER.info("Invalidating bucket " + bucketName);
		BucketsApi api = client.getBucketsApi();
		Bucket bucket = api.findBucketByName(bucketName);

		cancelTasks(api);

		if (bucket != null) {
			try {
				api.deleteBucket(bucket.getId());
				LOGGER.info("Bucket deleted");
			} catch (InfluxException ex) {
				LOGGER.log(Level.WARNING, "Exception during bucket deletion", ex);
			}
		}
		
		createBucket();
	}

	private void createBucket() {
		OrganizationsApi orgApi = client.getOrganizationsApi();
		Organization organization = orgApi.findOrganizations().stream().filter(org -> Objects.equals(org.getName(), orgName)).findAny().orElseThrow(() -> new RuntimeException("Organization " + orgName + " not found!"));
		try {
			BucketsApi api = client.getBucketsApi();
			api.createBucket(bucketName, organization);
			LOGGER.info("Bucket created");
		} catch (InfluxException ex) {
			LOGGER.log(Level.WARNING, "Exception during bucket creation", ex);
		}
	}

	private void cancelTasks(BucketsApi api) {
		TasksApi tApi = client.getTasksApi();
		Optional<Task> taskOpt = tApi.findTasks().stream().filter(t -> Objects.equals(t.getName(), "Aggregate Score")).findAny();
		if (taskOpt.isPresent()) {
			Task task = taskOpt.get();

			Set<String> ids = client.getTasksApi().getRuns(task).stream().filter(r -> r.getStatus() == StatusEnum.STARTED || r.getStatus() == StatusEnum.SCHEDULED).map(r -> r.getId()).collect(Collectors.toSet());
			for (String eachId : ids) {
				try {
					client.getTasksApi().cancelRun(task.getId(), eachId);
					LOGGER.info("Task run " + eachId + "canceled");
				} catch (InfluxException ex) {
					LOGGER.log(Level.WARNING, "Exception during canceling task", ex);
				}

			}
		}
	}

}
