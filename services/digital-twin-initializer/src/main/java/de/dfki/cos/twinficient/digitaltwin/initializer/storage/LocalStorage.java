package de.dfki.cos.twinficient.digitaltwin.initializer.storage;

import java.util.Collection;
import java.util.Set;

import de.dfki.cos.twinficient.digitaltwin.initializer.TwinficientInMemoryLocalStorage.UpdateResult;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;

public interface LocalStorage {

	Set<BasyxRecord> deleteAllByRealm(String realm);

	UpdateResult update(Collection<? extends DigitalTwinRecord> records);

	UpdateResult initialize(Collection<String> requiredRealms, Collection<BasyxRecord> serverRecords);

}
