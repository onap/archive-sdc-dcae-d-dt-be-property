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

package org.onap.sdc.dcae.composition.restmodels.health;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HealthResponse {

    @SerializedName("healthCheckComponent")
    @Expose
    private String healthCheckComponent;
    @SerializedName("healthCheckStatus")
    @Expose
    private String healthCheckStatus;
    @SerializedName("sdcVersion")
    @Expose
    private String sdcVersion;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("componentsInfo")
    @Expose
    private List<ComponentsInfo> componentsInfo = null;

    public String getHealthCheckComponent() {
        return healthCheckComponent;
    }

    public void setHealthCheckComponent(String healthCheckComponent) {
        this.healthCheckComponent = healthCheckComponent;
    }

    public String getHealthCheckStatus() {
        return healthCheckStatus;
    }

    public void setHealthCheckStatus(String healthCheckStatus) {
        this.healthCheckStatus = healthCheckStatus;
    }

    public String getSdcVersion() {
		return sdcVersion;
	}

	public void setSdcVersion(String sdcVersion) {
		this.sdcVersion = sdcVersion;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ComponentsInfo> getComponentsInfo() {
        return componentsInfo;
    }

    public void setComponentsInfo(List<ComponentsInfo> componentsInfo) {
        this.componentsInfo = componentsInfo;
    }

}
