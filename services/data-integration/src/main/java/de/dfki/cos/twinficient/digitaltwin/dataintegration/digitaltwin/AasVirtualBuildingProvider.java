package de.dfki.cos.twinficient.digitaltwin.dataintegration.digitaltwin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Entity;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Key;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementChoice;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part1.SubmodelElementCollection;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.Endpoint;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ProtocolInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelDescriptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.Logs;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.building.DefaultVirtualBuilding;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.building.VirtualBuilding;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.building.VirtualBuildingProvider;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.AasProviderConfiguration;
import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.DefaultAasConfigProvider;

public class AasVirtualBuildingProvider implements VirtualBuildingProvider {

	private Logger log = Logs.getLogger(AasVirtualBuildingProvider.class);
	
	private final Map<String, Map<String, String>> companyToCelNrWithBuildingName = new HashMap<>();

	private Map<String, String> repoUrlMapping;
	private final AssetAdministrationShellRegistryApi aasRegApi;
	private final SubmodelRegistryApi smRegApi;
	private final ObjectMapper mapper;

	public AasVirtualBuildingProvider(AasProviderConfiguration conf) {
		this.mapper = new ObjectMapper();
		this.aasRegApi = new AssetAdministrationShellRegistryApi(mapper, conf.getAasRegistryUrl());
		this.smRegApi = new SubmodelRegistryApi(mapper, conf.getSmRegistryUrl());
		repoUrlMapping = conf.repoUrlMapping();
	}
	
	
	public Optional<VirtualBuilding> getVirtualBuilding(String company, String celNr) {
		Map<String, String> celNrWithBuildingName = companyToCelNrWithBuildingName.computeIfAbsent(company, this::findCompanyToCelNrWithBuildingName);
		return Optional.ofNullable(celNrWithBuildingName.get(celNr)).map(DefaultVirtualBuilding::new);
	}

	private Map<String, String> findCompanyToCelNrWithBuildingName(String company) {
		try {
			return doFindCompanyToCelNrWithBuildingName(company);
		} catch (ApiException ex) {
			log.finest("Failed to read company");
			log.finest(ex.getMessage());
			return Map.of(); // no building => no company
		}
	}

	private Map<String, String> doFindCompanyToCelNrWithBuildingName(String company) throws ApiException {
		String cId = "http://aas.twinficient.de/company/" + company;
		Submodel tpSm = resolveTopologySubmodelByShellId(cId);
		List<String> buildingIds = getBuildingIds(tpSm);
		return resolveCelNrToBuildingsMap(buildingIds);		
	}
	
	public Submodel resolveTopologySubmodelByShellId(String id) throws ApiException {
		AssetAdministrationShellDescriptor descriptor = aasRegApi.getAssetAdministrationShellDescriptorById(id);
		List<Endpoint> endpoints = descriptor.getEndpoints();
		ResourceUrl sUrl = ResourceUrl.fromShellEndpoints(endpoints, repoUrlMapping);
		if (sUrl == null) {
			return null;
		}
		AssetAdministrationShellRepositoryApi repoApi = new AssetAdministrationShellRepositoryApi(mapper, sUrl.host);
		AssetAdministrationShell shell = repoApi.getAssetAdministrationShellByIdWithHttpInfoNoUrlEncoding(sUrl.idEncoded).getData();
		List<Reference> refs = shell.getSubmodels();
		String smId = findTopologyId(refs);
		if (smId == null) {
			return null;
		}
		
		SubmodelDescriptor smDescriptor = smRegApi.getSubmodelDescriptorById(smId);
		List<Endpoint> smEps = smDescriptor.getEndpoints();
		ResourceUrl smUrl = ResourceUrl.fromSubmodelEndpoints(smEps, repoUrlMapping);
		if (smUrl == null) {
			return null;
		}
		SubmodelRepositoryApi smRepoApi = new SubmodelRepositoryApi(mapper, smUrl.host);
		return smRepoApi.getSubmodelByIdWithHttpInfoNoUrlEncoding(smUrl.idEncoded, null, null).getData();		
	}

	private Map<String, String> resolveCelNrToBuildingsMap(List<String> buildingIds) throws ApiException {
		Map<String, String> result = new HashMap<>();
		for (String eachBuildingId : buildingIds) {
			getCelNamesForBuildingId(eachBuildingId, result);
		}
		return result;
	}

	private void getCelNamesForBuildingId(String buildingId, Map<String, String> result) throws ApiException  {
		Submodel sm = resolveTopologySubmodelByShellId(buildingId);
		
		SubmodelElementChoice siteInfo = sm.getSubmodelElements().get(1); // always on 1
		String buildingName = siteInfo.getEntity().getStatements().get(0).getProperty().getValue();
		
		SubmodelElementChoice choiceCelestras = sm.getSubmodelElements().get(2); // always on 2
		for (SubmodelElementChoice eachItem : choiceCelestras.getSubmodelElementCollection().getValue()) {
			String celName = eachItem.getEntity().getStatements().get(0).getProperty().getValue(); // always on first pos
			result.put(celName, buildingName);
		}
	}

	private List<String> getBuildingIds(Submodel sm) {
		List<String> ids = new LinkedList<>();
		for (SubmodelElementChoice choice : sm.getSubmodelElements()) {
			Entity entity = choice.getEntity();
			SubmodelElementCollection coll = entity.getStatements().get(1).getSubmodelElementCollection();
			resolveBuildingReferences(coll.getValue(), ids);
		}
		return ids;
	}

	private void resolveBuildingReferences(List<SubmodelElementChoice> value, List<String> ids) {
		for (SubmodelElementChoice eachChoice : value) {
			String id = eachChoice.getRelationshipElement().getSecond().getKeys().get(0).getValue();
			ids.add(id);
		}
	}
	
	private String findTopologyId(List<Reference> refs) {
		for (Reference eachRef : refs) {
			String id = findTopologyId(eachRef);
			if (id != null) {
				return id;
			}
		}
		return null;
	}
	
	private String findTopologyId(Reference ref) {
		List<Key> keys = ref.getKeys();
		for (Key eachKey : keys) {
			String value = eachKey.getValue();
			if (value != null && value.startsWith("http://sm.twinficient.de/topology/")) {
				return value;
			}
		}
		return null;
	}


	private static final class ResourceUrl {

		private String idEncoded;
		private String host;

		public ResourceUrl(String host, String idEncoded) {
			this.host = host;
			this.idEncoded = idEncoded;
		}

		public static ResourceUrl fromSubmodelEndpoints(List<Endpoint> endpoints, Map<String, String> hostMapping) {
			for (Endpoint eachEndpoint : endpoints) {
				ResourceUrl url = ResourceUrl.fromEndpoint(eachEndpoint, "submodels", hostMapping);
				if (url != null) {
					return url;
				}
			}
			return null;
		}	

		public static ResourceUrl fromShellEndpoints(List<Endpoint> endpoints, Map<String, String> hostMapping) {
			for (Endpoint eachEndpoint : endpoints) {
				ResourceUrl url = ResourceUrl.fromEndpoint(eachEndpoint, "shells", hostMapping);
				if (url != null) {
					return url;
				}
			}
			return null;
		}



		public static ResourceUrl fromEndpoint(Endpoint ep, String type, Map<String, String> hostMapping) {
			ProtocolInformation info = ep.getProtocolInformation();
			if (info == null) {
				return null;
			}
			String href = info.getHref();
			return fromHref(href, type, hostMapping);
		}

		public static ResourceUrl fromHref(String href, String type, Map<String, String> hostMapping) {
			String host = href.substring(0, href.indexOf("/" + type + "/"));
			host = hostMapping.getOrDefault(host, host);
			String idEncoded = href.substring(href.lastIndexOf('/') + 1);
			return new ResourceUrl(host, idEncoded);
		}
	}
}