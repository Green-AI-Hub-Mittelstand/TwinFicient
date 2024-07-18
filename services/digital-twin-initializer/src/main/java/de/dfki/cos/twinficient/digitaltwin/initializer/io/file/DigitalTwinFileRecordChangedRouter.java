package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientInMemoryLocalStorage.UpdateResult;
import de.dfki.cos.twinficient.digitaltwin.initializer.io.http.DigitalTwinServiceFacade;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.storage.LocalStorage;

public  class DigitalTwinFileRecordChangedRouter implements FileChangedListener {

	private final FileRecordReader reader;
	private final LocalStorage storage;
	private final DigitalTwinServiceFacade serviceFacade;
	private final RealmTokenGenerator realmTokenGenerator = new FileNameRealmTokenGenerator();

	public DigitalTwinFileRecordChangedRouter(FileRecordReader reader, LocalStorage storage, DigitalTwinServiceFacade serviceFacade) {
		this.reader = reader;
		this.storage = storage;
		this.serviceFacade = serviceFacade;
	}
	
	@Override
	public void onCreate(Path path) throws Exception {
		onUpdate(path);
	}

	@Override
	public void onUpdate(Path path) throws Exception {		
		List<DigitalTwinRecord> records = reader.readEntries(path);
		UpdateResult result = storage.update(records);
		serviceFacade.update(result.added(), result.removed());
	}

	@Override
	public void onDelete(Path path) throws Exception {
		String id = realmTokenGenerator.realmForPath(path);
		Set<BasyxRecord> recordsToDelete = storage.deleteAllByRealm(id);
		serviceFacade.update(Set.of(), recordsToDelete);
	}
}