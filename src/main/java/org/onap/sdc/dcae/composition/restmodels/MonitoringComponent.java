package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.onap.sdc.dcae.composition.restmodels.sdc.ResourceDetailed;
import org.onap.sdc.dcae.composition.util.DcaeBeConstants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoringComponent {

	// VFCMT metadata
	private String uuid;
	private String name;
	private String version;
	private String lastUpdaterUserId;
	private String description;
	private String lifecycleState;

	// Blueprint submission status
	// 1806 US381853 according to lifecycleState
	private String status;

	// The name of the vfi monitored by the VFCMT
	private String vfiName;

	public MonitoringComponent(ResourceDetailed mc, String vfiName) {
		this.uuid = mc.getUuid();
		this.name = mc.getName();
		this.version = mc.getVersion();
		this.lastUpdaterUserId = mc.getLastUpdaterUserId();
		this.description = mc.getDescription();
		this.lifecycleState = mc.getLifecycleState();
		this.status = DcaeBeConstants.LifecycleStateEnum.CERTIFIED == DcaeBeConstants.LifecycleStateEnum.findState(lifecycleState) ? "Submitted" : "Not Submitted";
		this.vfiName = vfiName;
	}

	public MonitoringComponent(String uuid, String vfiName, String status) {
		this.uuid = uuid;
		this.vfiName = vfiName;
		this.status = status;
	}

	MonitoringComponent(){}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getLastUpdaterUserId() {
		return lastUpdaterUserId;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public String getVfiName() {
		return vfiName;
	}

	public String getLifecycleState() {
		return lifecycleState;
	}

	public void setVfiName(String vfiName) {
		this.vfiName = vfiName;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLifecycleState(String lifecycleState) {
		this.lifecycleState = lifecycleState;
	}

}
