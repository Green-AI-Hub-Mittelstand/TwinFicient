package de.dfki.cos.twinficient.digitaltwin.initializer.control.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientInMemoryLocalStorage.UpdateResult;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.DigitalTwinFileRecordChangedRouter;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileEventProcessor;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileEventProcessorFactory;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.file.FileRecordReader;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.DigitalTwinServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.storage.LocalStorage;

public class DigitalTwinInitializer {
	
	private final LocalStorage localStorage;
	private final DigitalTwinServiceFacade serviceFacade;
	private final FileRecordReader reader;

	public DigitalTwinInitializer(LocalStorage localStorage, DigitalTwinServiceFacade facade, FileRecordReader reader) {
		this.localStorage = localStorage;
		this.serviceFacade = facade;
		this.reader = reader;
	}
	
	public void register(Path folderPath, FileEventProcessorFactory fepFactory) throws Exception {
		applyFiles(folderPath);
		DigitalTwinFileRecordChangedRouter router = new DigitalTwinFileRecordChangedRouter(reader, localStorage, serviceFacade);
		FileEventProcessor fileEventProcess = fepFactory.createFor(folderPath, router);
		fileEventProcess.processEvents();
	}

	private void applyFiles(Path folderPath) throws IOException, ApiException, Exception {
		for (Path eachPath : Files.list(folderPath).collect(Collectors.toList())) {
			List<DigitalTwinRecord> records = reader.readEntries(eachPath);
			UpdateResult result = localStorage.update(records);
			serviceFacade.update(result.added(), result.removed());
		}
	}

	public void initializeLocalStorage(Collection<String> requiredRealms) throws ApiException {
		Set<BasyxRecord> allRecords = serviceFacade.fetchAll();
		UpdateResult result = localStorage.initialize(requiredRealms, allRecords);
		serviceFacade.update(result.added(), result.removed());
	}
}
