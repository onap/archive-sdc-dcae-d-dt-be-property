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

package org.onap.sdc.dcae.composition.services;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("resourceVersion")
    @Expose
    private String resourceVersion;
    @SerializedName("resoucreType")
    @Expose
    private String resoucreType;
    @SerializedName("resourceInvariantUUID")
    @Expose
    private String resourceInvariantUUID;
    @SerializedName("resourceName")
    @Expose
    private String resourceName;
    @SerializedName("resourceInstanceName")
    @Expose
    private String resourceInstanceName;
    @SerializedName("resourceUUID")
    @Expose
    private String resourceUUID;
    @SerializedName("artifacts")
    @Expose
    private List<Artifact> artifacts = null;
    @SerializedName("description")
    @Expose
    private String description;

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public String getResoucreType() {
        return resoucreType;
    }

    public void setResoucreType(String resoucreType) {
        this.resoucreType = resoucreType;
    }

    public String getResourceInvariantUUID() {
        return resourceInvariantUUID;
    }

    public void setResourceInvariantUUID(String resourceInvariantUUID) {
        this.resourceInvariantUUID = resourceInvariantUUID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceInstanceName() {
        return resourceInstanceName;
    }

    public void setResourceInstanceName(String resourceInstanceName) {
        this.resourceInstanceName = resourceInstanceName;
    }

    public String getResourceUUID() {
        return resourceUUID;
    }

    public void setResourceUUID(String resourceUUID) {
        this.resourceUUID = resourceUUID;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
