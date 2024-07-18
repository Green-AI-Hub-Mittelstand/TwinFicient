package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class CompanyRecord implements BasyxRecord {
	
	private final String company;
	private final Set<String> buildings = new HashSet<>();
	
	
	public CompanyRecord(String company) {
		this.company = company;
	}
	
	public CompanyRecord withBuilding(String building) {
		buildings.add(building);
		return this;
	}
	
	public String getCompany() {
		return company;
	}
	
	public Set<String> getBuildings() {
		return Collections.unmodifiableSet(buildings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(buildings, company);
	}
	
	@Override
	public CompanyIdentifier getIdentifier() {
		return new CompanyIdentifier(company);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyRecord other = (CompanyRecord) obj;

		return Objects.equals(buildings, other.buildings) && Objects.equals(company, other.company);
	}

	@Override
	public String toString() {
		return "CompanyRecord [company=" + company + ", buildings=" + buildings + "]";
	}
	
	public static class CompanyIdentifier implements BasyxIdentifier {
		
		private final String company;
		
		public CompanyIdentifier(String company) {
			this.company = company;
		}


		public String getCompany() {
			return company;
		}

		@Override
		public int hashCode() {
			return Objects.hash(company);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CompanyIdentifier other = (CompanyIdentifier) obj;
			return Objects.equals(company, other.company);
		}

		@Override
		public String toString() {
			return "CompanyIdentifier [company=" + company + "]";
		}
	}
}