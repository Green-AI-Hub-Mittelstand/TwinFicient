package de.dfki.cos.twinficient.digitaltwin.initializer;

import java.util.Objects;

import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxIdentifier;
import de.dfki.cos.twinficient.digitaltwin.initializer.model.BasyxRecord;

public class HeaterDefinitionRecord implements BasyxRecord {
	
	private String devicePerformance;
	private String deviceType;


	public HeaterDefinitionRecord withDevicePerformance(String devicePerformance) {
		this.devicePerformance = devicePerformance;
		return this;
	}
	
	public HeaterDefinitionRecord withDeviceType(String deviceType) {
		this.deviceType = deviceType;
		return this;
	}
	
	public String getDevicePerformance() {
		return devicePerformance;
	}
	
	public String getDeviceType() {
		return deviceType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(devicePerformance, deviceType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeaterDefinitionRecord other = (HeaterDefinitionRecord) obj;
		return Objects.equals(devicePerformance, other.devicePerformance) && Objects.equals(deviceType, other.deviceType);
	}

	@Override
	public String toString() {
		return "HeaterDefinitionRecord [devicePerformance=" + devicePerformance + ", deviceType=" + deviceType + "]";
	}
	
	@Override
	public HeaterDefinitionIdentifier getIdentifier() {
		return new HeaterDefinitionIdentifier(deviceType);
	}

	public static class HeaterDefinitionIdentifier implements BasyxIdentifier {
		
		private final String deviceType;

		public HeaterDefinitionIdentifier(String deviceType) {
			this.deviceType = deviceType;
		}

		public String getDeviceType() {
			return deviceType;
		}

		@Override
		public int hashCode() {
			return Objects.hash(deviceType);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HeaterDefinitionIdentifier other = (HeaterDefinitionIdentifier) obj;
			return Objects.equals(deviceType, other.deviceType);
		}

		@Override
		public String toString() {
			return "HeaterDefinitionIdentifier [deviceType=" + deviceType + "]";
		}
	}
	
}
