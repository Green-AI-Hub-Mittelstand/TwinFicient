package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.util.Map;

public interface AasProviderConfiguration {

	String getAasRegistryUrl();
	
	String getSmRegistryUrl();
	
	Map<String, String> repoUrlMapping();
}
