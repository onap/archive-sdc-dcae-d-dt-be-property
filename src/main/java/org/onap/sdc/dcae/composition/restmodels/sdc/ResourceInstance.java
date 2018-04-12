package org.onap.sdc.dcae.composition.restmodels.sdc;

import java.util.List;

public class ResourceInstance {
	
	private String resourceInstanceName;
    private String resourceName;
    private String resourceInvariantUUID;
    private String resourceVersion;
    private String resoucreType;
    private String resourceUUID;
    private List<Artifact> artifacts;
    
	public String getResourceInstanceName() {
		return resourceInstanceName;
	}
	public void setResourceInstanceName(String resourceInstanceName) {
		this.resourceInstanceName = resourceInstanceName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceInvariantUUID() {
		return resourceInvariantUUID;
	}
	public void setResourceInvariantUUID(String resourceInvariantUUID) {
		this.resourceInvariantUUID = resourceInvariantUUID;
	}
	public String getResourceVersion() {
		return resourceVersion;
	}
	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}
	public String getResoucreType() {
		return resoucreType;
	}
	public void setResoucreType(String resoucreType) {
		this.resoucreType = resoucreType;
	}
	public String getResourceUUID() {
		return resourceUUID;
	}
	public void setResourceUUID(String resourceUUID) {
		this.resourceUUID = resourceUUID;
	}
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

}
