package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.onap.sdc.dcae.composition.restmodels.sdc.ResourceDetailed;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VfcmtData extends MonitoringComponent {

	private String flowType;
	private String serviceUuid;

	public VfcmtData(ResourceDetailed vfcmt) {
		setUuid(vfcmt.getUuid());
		setName(vfcmt.getName());
		setDescription(vfcmt.getDescription());
	}
	
	public VfcmtData(ResourceDetailed vfcmt, String vfiName, String flowType) {
		this(vfcmt);
		setVfiName(vfiName);
		setFlowType(flowType);
	}

	public VfcmtData(ResourceDetailed vfcmt, String vfiName, String flowType, String serviceUuid) {
		this(vfcmt, vfiName, flowType);
		setInvariantUUID(vfcmt.getInvariantUUID());
		setLifecycleState(vfcmt.getLifecycleState());
		setServiceUuid(serviceUuid);
	}

	VfcmtData(){}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getServiceUuid() {
		return serviceUuid;
	}

	public void setServiceUuid(String serviceUuid) {
		this.serviceUuid = serviceUuid;
	}

}
