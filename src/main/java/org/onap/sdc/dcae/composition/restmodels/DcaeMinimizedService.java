package org.onap.sdc.dcae.composition.restmodels;

public class DcaeMinimizedService {
	String uuid;
	String name;
	String lastUpdaterUserId;
	String lifeCycleState;
	String version;
	String invariantUUID;
	
	public String getInvariantUUID() {
		return invariantUUID;
	}
	public void setInvariantUUID(String invariantUUID) {
		this.invariantUUID = invariantUUID;
	}
	public DcaeMinimizedService(String uuid, String name, String lastUpdaterUserId, String lifeCycleState, String version, String invariantUUID) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.lastUpdaterUserId = lastUpdaterUserId;
		this.lifeCycleState = lifeCycleState;
		this.version = version;
		this.invariantUUID = invariantUUID;
	}
	public String getVersion() {
		return version;
	}
	public Float getVersionAsFloat() {
		return Float.parseFloat(version);
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastUpdaterUserId() {
		return lastUpdaterUserId;
	}
	public void setLastUpdaterUserId(String lastUpdaterUserId) {
		this.lastUpdaterUserId = lastUpdaterUserId;
	}
	public String getLifeCycleState() {
		return lifeCycleState;
	}
	public void setLifeCycleState(String lifeCycleState) {
		this.lifeCycleState = lifeCycleState;
	}
}
