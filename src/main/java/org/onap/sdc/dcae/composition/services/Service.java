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

public class Service {

    @SerializedName("lifecycleState")
    @Expose
    private String lifecycleState;
    @SerializedName("toscaModelURL")
    @Expose
    private String toscaModelURL;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastUpdaterUserId")
    @Expose
    private String lastUpdaterUserId;
    @SerializedName("distributionStatus")
    @Expose
    private String distributionStatus;
    @SerializedName("resources")
    @Expose
    private List<Resource> resources = null;
    @SerializedName("invariantUUID")
    @Expose
    private String invariantUUID;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("lastUpdaterFullName")
    @Expose
    private String lastUpdaterFullName;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("models")
    @Expose
    private List<Model> models = null;

    public List<Model> getModels() {
    	return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}
    	
    public String getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(String lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    public String getToscaModelURL() {
        return toscaModelURL;
    }

    public void setToscaModelURL(String toscaModelURL) {
        this.toscaModelURL = toscaModelURL;
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

    public String getDistributionStatus() {
        return distributionStatus;
    }

    public void setDistributionStatus(String distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getInvariantUUID() {
        return invariantUUID;
    }

    public void setInvariantUUID(String invariantUUID) {
        this.invariantUUID = invariantUUID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLastUpdaterFullName() {
        return lastUpdaterFullName;
    }

    public void setLastUpdaterFullName(String lastUpdaterFullName) {
        this.lastUpdaterFullName = lastUpdaterFullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Service(){}

    public Service(String name, String uuid, String version) {
        this.name = name;
        this.uuid = uuid;
        this.version = version;
    }


}
