package de.dfki.cos.twinficient.digitaltwin.dataintegration.building;

import java.util.Objects;

public class DefaultVirtualBuilding implements VirtualBuilding {

	private final String name;
	
	public DefaultVirtualBuilding(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultVirtualBuilding other = (DefaultVirtualBuilding) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Building: " + name;
	}
}