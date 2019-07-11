/*-
 * ============LICENSE_START=======================================================
 * sdc-dcae-d-dt-be-property
 * ================================================================================
 * Copyright (C) 2017 - 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.onap.sdc.dcae.composition.restmodels;

import org.onap.sdc.dcae.composition.restmodels.sdc.ResourceDetailed;
import org.onap.sdc.dcae.composition.util.DcaeBeConstants;

import java.util.Objects;

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

	// 1810 US436244 add invariantUuid, submittedUuid to MC data
	private String invariantUUID;
	private String submittedUuid;


	public MonitoringComponent(ResourceDetailed mc, String vfiName) {
		this.uuid = mc.getUuid();
		this.name = mc.getName();
		this.version = mc.getVersion();
		this.lastUpdaterUserId = mc.getLastUpdaterUserId();
		this.description = mc.getDescription();
		this.lifecycleState = mc.getLifecycleState();
		this.invariantUUID = mc.getInvariantUUID();
		this.status = "Not Submitted";
		if(DcaeBeConstants.LifecycleStateEnum.CERTIFIED == DcaeBeConstants.LifecycleStateEnum.findState(lifecycleState)) {
			this.submittedUuid = mc.getUuid();
			this.status = "Submitted";
		}
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

	public String getSubmittedUuid() { return submittedUuid; }

	public String getInvariantUUID() {
		return invariantUUID;
	}

	public void setInvariantUUID(String invariantUUID) {
		this.invariantUUID = invariantUUID;
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

	public void setSubmittedUuid(String submittedUuid) { this.submittedUuid = submittedUuid; }

	public void setStatus(String status) { this.status = status; }

	public void setLastUpdaterUserId(String lastUpdaterUserId) {
		this.lastUpdaterUserId = lastUpdaterUserId;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (null == obj || getClass() != obj.getClass()) {
			return false;
		}
		MonitoringComponent other = (MonitoringComponent) obj;
		return Objects.equals(status, other.status) && Objects.equals(vfiName, other.vfiName) && dataFieldsEqual(other);

	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, name, version, lastUpdaterUserId, lifecycleState, status, vfiName, invariantUUID, submittedUuid);
	}


	private boolean resourceFieldsEqual(MonitoringComponent other) {
		return Objects.equals(lastUpdaterUserId, other.lastUpdaterUserId) && Objects.equals(name, other.name) && Objects.equals(description, other.description);
	}

	private boolean lifecycleFieldsEqual(MonitoringComponent other) {
		return Objects.equals(uuid, other.uuid) && Objects.equals(version, other.version) && Objects.equals(lifecycleState, other.lifecycleState);
	}

	private boolean additionalUuidFieldsEqual(MonitoringComponent other) {
		return Objects.equals(invariantUUID, other.invariantUUID) && Objects.equals(submittedUuid, other.submittedUuid);
	}

	private boolean dataFieldsEqual(MonitoringComponent other) {
		return resourceFieldsEqual(other) && lifecycleFieldsEqual(other) && additionalUuidFieldsEqual(other);
	}
}
