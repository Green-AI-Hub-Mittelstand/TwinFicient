package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class EnvironmentVariables {

	private EnvironmentVariables() {
		
	}
	
	public static String getEnvOrThrow(String envName) {
		String envValue = System.getenv(envName);
		if (envValue == null) {
			throw new IllegalArgumentException("Environement variable '" + envName + "' not set.");
		}
		return envValue;
	}
	
	public static Map<String, String> getEnvMapping(String envNamePrefix) {
		Map<String, String> toReturn = new HashMap<>();
		for (Entry<String,String> eachEnv : System.getenv().entrySet()) {
			String key = eachEnv.getKey();
			if (!key.startsWith(envNamePrefix)) {
				continue;
			}
			String suffix = key.substring(envNamePrefix.length());
			toReturn.put(suffix, eachEnv.getValue());
		}
		return toReturn;
	}
	
}
