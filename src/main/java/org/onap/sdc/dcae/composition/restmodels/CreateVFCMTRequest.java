package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CreateVFCMTRequest {

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;
	
	@JsonProperty("vendorName")
	private String vendorName;
	
	@JsonProperty("vendorRelease")
	private String vendorRelease;

	@JsonProperty("contactId")
	private String contactId;

	@JsonProperty("resourceType")
	private String resourceType;

	@JsonProperty("category")
	private String category;

	@JsonProperty("subcategory")
	private String subcategory;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("tags")
	private String[] tags;

	//1806 374280 new flow - create, clone and attach to Vfi in one API request
	private String serviceUuid;

	private String templateUuid;

	private String vfiName;

	private String contextType;

	private String flowType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorRelease() {
		return vendorRelease;
	}

	public void setVendorRelease(String vendorRelease) {
		this.vendorRelease = vendorRelease;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getServiceUuid() {
		return serviceUuid;
	}

	public void setServiceUuid(String serviceUuid) {
		this.serviceUuid = serviceUuid;
	}

	public String getTemplateUuid() {
		return templateUuid;
	}

	public void setTemplateUuid(String templateUuid) {
		this.templateUuid = templateUuid;
	}

	public String getVfiName() {
		return vfiName;
	}

	public void setVfiName(String vfiName) {
		this.vfiName = vfiName;
	}

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
}
