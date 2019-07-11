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

package org.onap.sdc.dcae.composition.restmodels.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceDetailed extends Service {
	
	private String lastUpdaterFullName;
	private List<ResourceInstance> resources;
	private List<Artifact> artifacts;
	
	public String getLastUpdaterFullName() {
		return lastUpdaterFullName;
	}
	public void setLastUpdaterFullName(String lastUpdaterFullName) {
		this.lastUpdaterFullName = lastUpdaterFullName;
	}
	public List<ResourceInstance> getResources() {
		return resources;
	}
	public void setResources(List<ResourceInstance> resources) {
		this.resources = resources;
	}
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	
}
