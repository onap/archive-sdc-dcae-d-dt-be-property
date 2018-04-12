package org.onap.sdc.dcae.composition.restmodels;

import org.onap.sdc.dcae.composition.restmodels.sdc.ResourceDetailed;

public class VfcmtData extends MonitoringComponent {

	private String flowType;
	private String serviceUuid;

	private String invariantUUID;

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

	public String getInvariantUUID() {
		return invariantUUID;
	}

	public void setInvariantUUID(String invariantUUID) {
		this.invariantUUID = invariantUUID;
	}


}
