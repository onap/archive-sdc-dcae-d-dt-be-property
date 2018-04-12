package org.onap.sdc.dcae.composition.restmodels.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Asset {
	
	private String uuid;
	private String invariantUUID;
	private String name;
	private String version;
	private String toscaModelURL;
	private String lastUpdaterUserId;
	private String category;
	private String lifecycleState;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getInvariantUUID() {
		return invariantUUID;
	}
	public void setInvariantUUID(String invariantUUID) {
		this.invariantUUID = invariantUUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getToscaModelURL() {
		return toscaModelURL;
	}
	public void setToscaModelURL(String toscaModelURL) {
		this.toscaModelURL = toscaModelURL;
	}
	public String getLastUpdaterUserId() {
		return lastUpdaterUserId;
	}
	public void setLastUpdaterUserId(String lastUpdaterUserId) {
		this.lastUpdaterUserId = lastUpdaterUserId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLifecycleState() {
		return lifecycleState;
	}
	public void setLifecycleState(String lifecycleState) {
		this.lifecycleState = lifecycleState;
	}


	public Float versionAsFloat() {
		return Float.parseFloat(version);
	}
	
}
