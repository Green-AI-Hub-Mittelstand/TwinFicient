package de.dfki.cos.twinficient.digitaltwin.dataintegration.query;

import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import com.influxdb.Cancellable;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;

public class QueryManager {

	private final QueryApi qApi;
	private final String org;
	
	public QueryManager(QueryApi api, String org) {
		this.qApi = api;
		this.org = org;
	}
	
	public void runAsyncBlocking(String query, Consumer<FluxRecord> onNext) {
		RecordConsumer consumer = new RecordConsumer(onNext);
		qApi.query(query, org, consumer::consume, consumer::onError, consumer::onDone);
		consumer.await();
	}
	
	private static class RecordConsumer {

		private final CountDownLatch latch = new CountDownLatch(1);
		private volatile Throwable th;
		
		private Consumer<FluxRecord> frConsumer;

		public RecordConsumer(Consumer<FluxRecord> frConsumer) {
			this.frConsumer = frConsumer;
		}

		public void consume(Cancellable cancellable, FluxRecord record) {
			this.frConsumer.accept(record);
		}

		public void onError(Throwable th) {
			this.th = th;
			latch.countDown();
		}

		public void onDone() {
			latch.countDown();
		}

		public void await() {
			try {
				latch.await();
				if (th != null) {
					throw new RuntimeException(th);
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
