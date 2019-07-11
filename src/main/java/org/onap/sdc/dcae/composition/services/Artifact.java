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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artifact {

    @SerializedName("artifactChecksum")
    @Expose
    private String artifactChecksum;
    @SerializedName("artifactType")
    @Expose
    private String artifactType;
    @SerializedName("artifactUUID")
    @Expose
    private String artifactUUID;
    @SerializedName("artifactVersion")
    @Expose
    private String artifactVersion;
    @SerializedName("artifactName")
    @Expose
    private String artifactName;
    @SerializedName("artifactGroupType")
    @Expose
    private String artifactGroupType;
    @SerializedName("artifactURL")
    @Expose
    private String artifactURL;
    @SerializedName("artifactDescription")
    @Expose
    private String artifactDescription;
    @SerializedName("artifactLabel")
    @Expose
    private String artifactLabel;
    @SerializedName("artifactTimeout")
    @Expose
    private Integer artifactTimeout;
    @SerializedName("generatedFromUUID")
    @Expose
    private String generatedFromUUID;

    public String getArtifactChecksum() {
        return artifactChecksum;
    }

    public void setArtifactChecksum(String artifactChecksum) {
        this.artifactChecksum = artifactChecksum;
    }

    public String getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(String artifactType) {
        this.artifactType = artifactType;
    }

    public String getArtifactUUID() {
        return artifactUUID;
    }

    public void setArtifactUUID(String artifactUUID) {
        this.artifactUUID = artifactUUID;
    }

    public String getArtifactVersion() {
        return artifactVersion;
    }

    public void setArtifactVersion(String artifactVersion) {
        this.artifactVersion = artifactVersion;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    public String getArtifactGroupType() {
        return artifactGroupType;
    }

    public void setArtifactGroupType(String artifactGroupType) {
        this.artifactGroupType = artifactGroupType;
    }

    public String getArtifactURL() {
        return artifactURL;
    }

    public void setArtifactURL(String artifactURL) {
        this.artifactURL = artifactURL;
    }

    public String getArtifactDescription() {
        return artifactDescription;
    }

    public void setArtifactDescription(String artifactDescription) {
        this.artifactDescription = artifactDescription;
    }

    public String getArtifactLabel() {
        return artifactLabel;
    }

    public void setArtifactLabel(String artifactLabel) {
        this.artifactLabel = artifactLabel;
    }

    public Integer getArtifactTimeout() {
        return artifactTimeout;
    }

    public void setArtifactTimeout(Integer artifactTimeout) {
        this.artifactTimeout = artifactTimeout;
    }

    public String getGeneratedFromUUID() {
        return generatedFromUUID;
    }

    public void setGeneratedFromUUID(String generatedFromUUID) {
        this.generatedFromUUID = generatedFromUUID;
    }

}
