package org.onap.sdc.dcae.composition.restmodels.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Artifact {
	
	private String artifactName;
    private String artifactType;
    private String artifactURL;
    private String artifactDescription;
    private Integer artifactTimeout;
    private String artifactChecksum;
    private String artifactUUID;
    private String artifactVersion;
    private String generatedFromUUID;
    private String artifactLabel;
    private String artifactGroupType;
	private String payloadData;
	private String description;
    
	public String getArtifactName() {
		return artifactName;
	}
	public void setArtifactName(String artifactName) {
		this.artifactName = artifactName;
	}
	public String getArtifactType() {
		return artifactType;
	}
	public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}
	public String getArtifactURL() {
		return artifactURL;
	}
	public void setArtifactURL(String artifactURL) {
		this.artifactURL = artifactURL;
	}
	public String getArtifactDescription() {
		return artifactDescription;
	}
	public void setArtifactDescription(String artifactDescription) {
		this.artifactDescription = artifactDescription;
	}
	public Integer getArtifactTimeout() {
		return artifactTimeout;
	}
	public void setArtifactTimeout(Integer artifactTimeout) {
		this.artifactTimeout = artifactTimeout;
	}
	public String getArtifactChecksum() {
		return artifactChecksum;
	}
	public void setArtifactChecksum(String artifactChecksum) {
		this.artifactChecksum = artifactChecksum;
	}
	public String getArtifactUUID() {
		return artifactUUID;
	}
	public void setArtifactUUID(String artifactUUID) {
		this.artifactUUID = artifactUUID;
	}
	public String getArtifactVersion() {
		return artifactVersion;
	}
	public void setArtifactVersion(String artifactVersion) {
		this.artifactVersion = artifactVersion;
	}
	public String getGeneratedFromUUID() {
		return generatedFromUUID;
	}
	public void setGeneratedFromUUID(String generatedFromUUID) {
		this.generatedFromUUID = generatedFromUUID;
	}
	public String getArtifactLabel() {
		return artifactLabel;
	}
	public void setArtifactLabel(String artifactLabel) {
		this.artifactLabel = artifactLabel;
	}
	public String getArtifactGroupType() {
		return artifactGroupType;
	}
	public void setArtifactGroupType(String artifactGroupType) {
		this.artifactGroupType = artifactGroupType;
	}
	public String getPayloadData() {
		return payloadData;
	}
	public void setPayloadData(String payloadData) {
		this.payloadData = payloadData;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
