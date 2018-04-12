package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AttachVFCMTServiceRequest {
	@JsonProperty("serviceUuid")
	private String serviceUuid;
	@JsonProperty("instanceName")
	private String instanceName;
	public String getServiceUuid() {
		return serviceUuid;
	}
	public void setServiceUuid(String serviceUuid) {
		this.serviceUuid = serviceUuid;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
}
