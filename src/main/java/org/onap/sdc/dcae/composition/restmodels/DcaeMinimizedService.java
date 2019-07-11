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
