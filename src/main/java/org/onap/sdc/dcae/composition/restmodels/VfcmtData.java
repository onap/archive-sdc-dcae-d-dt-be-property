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
