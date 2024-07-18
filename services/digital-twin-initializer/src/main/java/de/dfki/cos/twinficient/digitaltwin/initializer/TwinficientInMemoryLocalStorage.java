package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import de.dfki.cos.twinficient.digitaltwin.initializer.CompanyRecord.CompanyIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.FactoryHallRecord.FactoryHallIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterDefinitionRecord.HeaterDefinitionIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.DigitalTwinRecord;
import de.dfki.cos.twinficient.digitaltwin.initializer.storage.LocalStorage;

public class TwinficientInMemoryLocalStorage implements LocalStorage {

	private Map<HeaterIdentifier, HeaterRecord> idToHeaters = new HashMap<>();
	private Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> idToHeaterDefinitions = new HashMap<>();
	private Map<FactoryHallIdentifier, FactoryHallRecord> idToFactoryHalls = new HashMap<>();
	private Map<CompanyIdentifier, CompanyRecord> idToCompanies = new HashMap<>();

	private final Logger logger = Logger.getLogger(TwinficientInMemoryLocalStorage.class.getName());

	@Override
	public UpdateResult initialize(Collection<String> requiredRealms, Collection<BasyxRecord> serverRecords) {
		
		Set<BasyxRecord> toAdd = new HashSet<>();
		Set<BasyxRecord> toRemove = new HashSet<>();
		
		
		for (BasyxRecord eachRecord : serverRecords) {
			if (eachRecord instanceof HeaterRecord) {
				HeaterRecord heaterRecord = (HeaterRecord) eachRecord;
				if (requiredRealms.contains(heaterRecord.getRealm())) {
					idToHeaters.put(heaterRecord.getIdentifier(), heaterRecord);
				} else {
					toRemove.add(heaterRecord);
				}
			} else if (eachRecord instanceof HeaterDefinitionRecord) {
				HeaterDefinitionRecord heaterDefRecord = (HeaterDefinitionRecord) eachRecord;
				idToHeaterDefinitions.put(heaterDefRecord.getIdentifier(), heaterDefRecord);
			} else if (eachRecord instanceof FactoryHallRecord) {
				FactoryHallRecord factoryHallRecord = (FactoryHallRecord) eachRecord;
				idToFactoryHalls.put(factoryHallRecord.getIdentifier(), factoryHallRecord);
			} else if (eachRecord instanceof CompanyRecord) {
				CompanyRecord companyRecord = (CompanyRecord) eachRecord;
				idToCompanies.put(companyRecord.getIdentifier(), companyRecord);
			} else {
				throw new RuntimeException("Record '" + eachRecord.getClass().getName() + "' not supported.");
			}
		}
		
		updateDependent(toAdd, toRemove);
		
		return new UpdateResult(toAdd, toRemove);
	}

	private void updateDependent(Set<BasyxRecord> toAdd, Set<BasyxRecord> toRemove) {
		HeaterDefinitionUpdater heaterDefUpdater = new HeaterDefinitionUpdater(idToHeaterDefinitions, idToHeaters);
		heaterDefUpdater.update(toRemove, toAdd, idToHeaterDefinitions);
		
		FactoryHallUpdater factoryHallUpdater = new FactoryHallUpdater(idToFactoryHalls, idToHeaters);
		factoryHallUpdater.update(toRemove, toAdd, idToFactoryHalls);
		
		CompanyUpdater companyUpdater = new CompanyUpdater(idToCompanies, idToFactoryHalls, idToHeaters);
		companyUpdater.update(toRemove, toAdd, idToCompanies);
	}
	
	private static final class CompanyUpdater extends Updater<CompanyIdentifier, CompanyRecord> {
		
		private Map<FactoryHallIdentifier, FactoryHallRecord> alreadyUpdatedFactoryHalls;
		
		public CompanyUpdater(Map<CompanyIdentifier, CompanyRecord> current, Map<FactoryHallIdentifier, FactoryHallRecord> alreadyUpdatedFactoryHalls, Map<HeaterIdentifier, HeaterRecord> idToHeaters) {
			super(current, idToHeaters);
			this.alreadyUpdatedFactoryHalls = alreadyUpdatedFactoryHalls;
		}

		@Override
		protected Map<CompanyIdentifier, CompanyRecord> collectRequired() {
			return TwinficientRecords.collectCompanies(alreadyUpdatedFactoryHalls);
		}
	}
	
	private static final class FactoryHallUpdater extends Updater<FactoryHallIdentifier, FactoryHallRecord> {
		
		public FactoryHallUpdater(Map<FactoryHallIdentifier, FactoryHallRecord> current, Map<HeaterIdentifier, HeaterRecord> idToHeaters) {
			super(current, idToHeaters);
		}
		@Override
		protected Map<FactoryHallIdentifier, FactoryHallRecord> collectRequired() {
			return TwinficientRecords.collectFactoryHalls(idToHeaters);
		}
	}
	
	private static final class HeaterDefinitionUpdater extends Updater<HeaterDefinitionIdentifier, HeaterDefinitionRecord> {
		
		public HeaterDefinitionUpdater(Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> current, Map<HeaterIdentifier, HeaterRecord> idToHeaters) {
			super(current, idToHeaters);
		}
		
		protected Map<HeaterDefinitionIdentifier, HeaterDefinitionRecord> collectRequired() {
			return TwinficientRecords.collectHeaterDefinitions(idToHeaters);
		}
				
	}
	
	private abstract static class Updater<I extends BasyxIdentifier,T extends BasyxRecord> {
		private final Map<I, T> current;
		protected final Map<HeaterIdentifier, HeaterRecord> idToHeaters;
		
		private Updater(Map<I, T> current, Map<HeaterIdentifier, HeaterRecord> idToHeaters /* Function<HeaterRecord, T> factory, Function<T, I> idProvider*/) {
			this.current = new HashMap<>(current);
			this.idToHeaters = idToHeaters;
		}
		
		protected abstract Map<I,T> collectRequired();
		
		public void update(Set<BasyxRecord> toRemove, Set<BasyxRecord> toAdd, Map<I,T> target) {
			Map<I,T> requiredDependent = collectRequired();
			Map<I,T> removedMap = new HashMap<>();
			Iterator<Entry<I, T>> entryIter = current.entrySet().iterator();
			while (entryIter.hasNext()) {
				Entry<I,T> eachCurrentEntry = entryIter.next();
				I identifier = eachCurrentEntry.getKey();
				T current = eachCurrentEntry.getValue();
				T required = requiredDependent.get(identifier);
				if (required == null) {
					// not required anymore => remove
					entryIter.remove();
					removedMap.put(identifier, current);
				} else if (required.equals(current)) {
					// nothing to update do not add this
					requiredDependent.remove(identifier);
				} else {
					// changed
					entryIter.remove();
					removedMap.put(identifier, current);
					target.put(identifier, required); // will override the current too
					toAdd.add(required);
				}
			}

			target.putAll(requiredDependent);
			toAdd.addAll(requiredDependent.values());
			toRemove.addAll(removedMap.values());	
		}
				
	}


	@Override
	public Set<BasyxRecord> deleteAllByRealm(String realm) {
		logger.info("Delete all for realm " + realm);
		Set<HeaterRecord> toRemove = idToHeaters.values().stream().filter(r -> realm.equals(r.getRealm())).collect(Collectors.toSet());
		toRemove.stream().map(HeaterRecord::getIdentifier).forEach(idToHeaters::remove);

		Set<BasyxRecord> removedLocally = new HashSet<>();
		removedLocally.addAll(toRemove);
		idToHeaters.values().removeAll(toRemove);
		Set<BasyxRecord> addedLocally = new HashSet<>();
		UpdateResult result = new UpdateResult(addedLocally, removedLocally);
		updateDependent(addedLocally, removedLocally);
		// removedLocally.addAll(removeDanglingReferences()); // compute heatersdefs and
		// factory halls
		if (addedLocally.size() > 0) {
			logger.info(addedLocally.size() + " resources were added => this should never occur on file deletion!! ");	
		}
		logger.info("Got " + removedLocally.size() + " reources to remove on realm '" + realm + "' deletion.");
		return result.removed;
	}

	@Override
	public UpdateResult update(Collection<? extends DigitalTwinRecord> records) {
		Set<String> realms = records.stream().map(DigitalTwinRecord::getRealm).collect(Collectors.toSet());
		logger.info("Performing Update for realm: " + realms);
		Map<HeaterIdentifier, HeaterRecord> currentlyDeployedForRealms = currentlyDeployedForRealms(realms);
		Map<HeaterIdentifier, HeaterRecord> recordsToAddForRealms = createNewRecords(records);

		Set<BasyxRecord> removed = new HashSet<>();

		// remove all that are not available for realm anymore
		Map<HeaterIdentifier, HeaterRecord> notRepresentedAnymoreForRealms = new HashMap<>(currentlyDeployedForRealms);
		notRepresentedAnymoreForRealms.keySet().removeAll(recordsToAddForRealms.keySet());
		removed.addAll(notRepresentedAnymoreForRealms.values());
		this.idToHeaters.keySet().removeAll(notRepresentedAnymoreForRealms.keySet());
		currentlyDeployedForRealms.keySet().removeAll(notRepresentedAnymoreForRealms.keySet());

		// remove all to-add that are exactly the same => no need to update
		Iterator<Entry<HeaterIdentifier, HeaterRecord>> entryIter = recordsToAddForRealms.entrySet().iterator();
		while (entryIter.hasNext()) {
			Entry<HeaterIdentifier, HeaterRecord> eachEntry = entryIter.next();
			HeaterRecord currentRecord = currentlyDeployedForRealms.get(eachEntry.getKey());
			if (currentRecord != null) { // was previously deployed
				if (eachEntry.getValue().equals(currentRecord)) {
					entryIter.remove(); // was the same
				} else { // invalidated because not the same
					removed.add(currentRecord);
					this.idToHeaters.remove(eachEntry.getKey());
				}
			}
		}

		Set<BasyxRecord> added = new HashSet<>();
		this.idToHeaters.putAll(recordsToAddForRealms);
		added.addAll(recordsToAddForRealms.values());

		idToHeaters.keySet().removeAll(notRepresentedAnymoreForRealms.keySet());
		removed.addAll(notRepresentedAnymoreForRealms.values());


		updateDependent(added, removed);

		logger.info("Got " + added.size() + " records to add and " + removed.size() + " to remove.");
		return new UpdateResult(added, removed);
	}

	private Map<HeaterIdentifier, HeaterRecord> currentlyDeployedForRealms(Set<String> realms) {
		return idToHeaters.entrySet().stream().filter(e -> realms.contains(e.getValue().getRealm())).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}

	private Map<HeaterIdentifier, HeaterRecord> createNewRecords(Collection<? extends DigitalTwinRecord> records) {
		return records.stream().map(TwinficientRecords::createHeater).collect(Collectors.toMap(HeaterRecord::getIdentifier, Function.identity()));
	}

	public static class UpdateResult {

		private final Set<BasyxRecord> added;
		private final Set<BasyxRecord> removed;

		public UpdateResult(Set<BasyxRecord> added, Set<BasyxRecord> removed) {
			this.added = added;
			this.removed = removed;
		}

		public Set<BasyxRecord> removed() {
			return removed;
		}

		public Set<BasyxRecord> added() {
			return added;
		}
	}
}
