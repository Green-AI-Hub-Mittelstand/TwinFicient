package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import de.dfki.cos.twinficient.digitaltwin.initializer.HeaterRecord.HeaterIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class FactoryHallRecord implements BasyxRecord {
	
	private String company;
	private String building;
	
	private Set<HeaterIdentifier> heaters = new HashSet<>();
	
	public FactoryHallRecord withCompany(String company) {
		this.company = company;
		return this;
	}
	
	public FactoryHallRecord withBuilding(String building) {
		this.building = building;
		return this;
	}
	
	public FactoryHallRecord withHeater(HeaterIdentifier identifier) {
		this.heaters.add(identifier);
		return this;
	}
	
	public Set<HeaterIdentifier> getHeaters() {
		return new HashSet<>(heaters);
	}
	
	
	public String getCompany() {
		return company;
	}
	
	public String getBuilding() {
		return building;
	}

	@Override
	public int hashCode() {
		return Objects.hash(building, company);
	}
	
	@Override
	public FactoryHallIdentifier getIdentifier() {
		return new FactoryHallIdentifier(building, company);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FactoryHallRecord other = (FactoryHallRecord) obj;

		return Objects.equals(heaters, other.heaters) && Objects.equals(building, other.building) && Objects.equals(company, other.company);
	}

	@Override
	public String toString() {
		return "FactoryHallRecord [company=" + company + ", building=" + building + " " + heaters + "]";
	}
	
	public static class FactoryHallIdentifier implements BasyxIdentifier {

		private final String building;
		private final String company;
		
		public FactoryHallIdentifier(String building, String company) {
			this.building = building;
			this.company = company;
		}

		public String getBuilding() {
			return building;
		}

		public String getCompany() {
			return company;
		}

		@Override
		public int hashCode() {
			return Objects.hash(building, company);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FactoryHallIdentifier other = (FactoryHallIdentifier) obj;
			return Objects.equals(building, other.building) && Objects.equals(company, other.company);
		}

		@Override
		public String toString() {
			return "FactoryHallIdentifier [building=" + building + ", company=" + company + "]";
		}
	}
}