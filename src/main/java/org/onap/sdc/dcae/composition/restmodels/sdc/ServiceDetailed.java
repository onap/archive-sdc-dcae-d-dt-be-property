package org.onap.sdc.dcae.composition.restmodels.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceDetailed extends Service {
	
	private String lastUpdaterFullName;
	private List<ResourceInstance> resources;
	private List<Artifact> artifacts;
	
	public String getLastUpdaterFullName() {
		return lastUpdaterFullName;
	}
	public void setLastUpdaterFullName(String lastUpdaterFullName) {
		this.lastUpdaterFullName = lastUpdaterFullName;
	}
	public List<ResourceInstance> getResources() {
		return resources;
	}
	public void setResources(List<ResourceInstance> resources) {
		this.resources = resources;
	}
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	
}
