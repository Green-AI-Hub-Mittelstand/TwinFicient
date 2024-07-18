package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.util.Map;

public class DefaultAasConfigProvider implements AasProviderConfiguration {

	private final String aasRegUrl;
	private final String smRegUrl;
	private final Map<String, String> hostMapping;

	public DefaultAasConfigProvider(String aasRegUrl, String smRegUrl, Map<String, String> hostMapping) {
		this.aasRegUrl = aasRegUrl;
		this.smRegUrl = smRegUrl;
		this.hostMapping = hostMapping;
	}

	@Override
	public String getAasRegistryUrl() {
		return aasRegUrl;
	}

	@Override
	public String getSmRegistryUrl() {
		return smRegUrl;
	}

	@Override
	public Map<String, String> repoUrlMapping() {
		return hostMapping;
	}

}
