package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.Objects;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class HeaterRecord implements BasyxRecord {

	private String realm;
	private String company;
	private String celNr;
	private String hzNr;
	private String hgNr;
	private String deviceType;
	private String building;
	private String virtualBuilding;
	private String performance;

	private HeaterRecord(String realm) {
		this.realm = realm;
	}

	public static HeaterRecord forRealm(String realm) {
		return new HeaterRecord(realm);
	}

	public HeaterRecord withCompany(String company) {
		this.company = company;
		return this;
	}

	public HeaterRecord withCelNr(String celNr) {
		this.celNr = celNr;
		return this;
	}

	public HeaterRecord withDeviceType(String deviceType) {
		this.deviceType = deviceType;
		return this;
	}

	public HeaterRecord withHzNr(String hzNr) {
		this.hzNr = hzNr;
		return this;
	}

	public HeaterRecord withHgNr(String hgNr) {
		this.hgNr = hgNr;
		return this;
	}

	public HeaterRecord withBuilding(String building) {
		this.building = building;
		return this;
	}
	
	public HeaterRecord withVirtualBuilding(String virtualBuilding) {
		this.virtualBuilding = virtualBuilding;
		return this;
	}
	
	public HeaterRecord withDevicePerformance(String devicePerformance) {
		this.performance = devicePerformance;
		return this;
	}
	
	public String getVirtualBuilding() {
		return virtualBuilding;
	}

	public String getCompany() {
		return company;
	}

	public String getCelNr() {
		return celNr;
	}

	public String getHzNr() {
		return hzNr;
	}

	public String getHgNr() {
		return hgNr;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public String getBuilding() {
		return building;
	}

	public String getDevicePerformance() {
		return performance;
	}
	
	public String getRealm() {
		return realm;
	}



	@Override
	public int hashCode() {
		return Objects.hash(building, celNr, company, deviceType, hgNr, hzNr, performance, realm, virtualBuilding);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeaterRecord other = (HeaterRecord) obj;
		return Objects.equals(building, other.building) && Objects.equals(celNr, other.celNr) && Objects.equals(company, other.company) && Objects.equals(deviceType, other.deviceType) && Objects.equals(hgNr, other.hgNr)
				&& Objects.equals(hzNr, other.hzNr) && Objects.equals(performance, other.performance) && Objects.equals(realm, other.realm) && Objects.equals(virtualBuilding, other.virtualBuilding);
	}

	@Override
	public String toString() {
		return "HeaterRecord [realm=" + realm + ", company=" + company + ", celNr=" + celNr + ", hzNr=" + hzNr + ", hgNr=" + hgNr + ", deviceType=" + deviceType + ", building=" + building+ ", virtualbuilding=" + virtualBuilding + ", performance=" + performance + "]";
	}

	
	@Override
	public HeaterIdentifier getIdentifier() {
		return new HeaterIdentifier(company, celNr, hzNr, hgNr);
	}
	
	public static class HeaterIdentifier implements BasyxIdentifier {

		private final String company;
		private final String celNr;
		private final String hzNr;
		private final String hgNr;
		
		public HeaterIdentifier(String company, String celNr, String hzNr, String hgNr) {
			this.company = company;
			this.celNr = celNr;
			this.hzNr = hzNr;
			this.hgNr = hgNr;
		}

		public String getCompany() {
			return company;
		}

		public String getCelNr() {
			return celNr;
		}

		public String getHzNr() {
			return hzNr;
		}

		public String getHgNr() {
			return hgNr;
		}

		@Override
		public int hashCode() {
			return Objects.hash(celNr, company, hgNr, hzNr);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HeaterIdentifier other = (HeaterIdentifier) obj;
			return Objects.equals(celNr, other.celNr) && Objects.equals(company, other.company) && Objects.equals(hgNr, other.hgNr) && Objects.equals(hzNr, other.hzNr);
		}

		@Override
		public String toString() {
			return "HeaterIdentifier [company=" + company + ", celNr=" + celNr + ", hzNr=" + hzNr + ", hgNr=" + hgNr + "]";
		}
	}
}
