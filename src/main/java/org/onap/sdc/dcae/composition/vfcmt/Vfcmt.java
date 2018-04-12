package org.onap.sdc.dcae.composition.vfcmt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vfcmt {

	@SerializedName("lifecycleState")
	@Expose
	private String lifecycleState;
	@SerializedName("subCategory")
	@Expose
	private String subCategory;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("invariantUUID")
	@Expose
	private String invariantUUID;
	@SerializedName("category")
	@Expose
	private String category;
	@SerializedName("uuid")
	@Expose
	private String uuid;
	@SerializedName("version")
	@Expose
	private String version;
	@SerializedName("resourceType")
	@Expose
	private String resourceType;
	@SerializedName("toscaModelURL")
	@Expose
	private String toscaModelURL;
	@SerializedName("lastUpdaterUserId")
	@Expose
	private String lastUpdaterUserId;

	public String getLifecycleState() {
		return lifecycleState;
	}

	public void setLifecycleState(String lifecycleState) {
		this.lifecycleState = lifecycleState;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInvariantUUID() {
		return invariantUUID;
	}

	public void setInvariantUUID(String invariantUUID) {
		this.invariantUUID = invariantUUID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}