package org.onap.sdc.dcae.composition.restmodels.sdc;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceDetailed extends Resource {

	private String lastUpdaterFullName;
	private String toscaResourceName;
	private List<ResourceInstance> resources;
	private List<Artifact> artifacts;
	private String description;
	
	public String getLastUpdaterFullName() {
		return lastUpdaterFullName;
	}
	public void setLastUpdaterFullName(String lastUpdaterFullName) {
		this.lastUpdaterFullName = lastUpdaterFullName;
	}
	public String getToscaResourceName() {
		return toscaResourceName;
	}
	public void setToscaResourceName(String toscaResourceName) {
		this.toscaResourceName = toscaResourceName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
