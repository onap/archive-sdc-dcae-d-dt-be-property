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

package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

public class RuleEditorRequest {

	private String vfcmtUuid;
	private String dcaeCompLabel;
	private String nid;
	private String configParam;

	public RuleEditorRequest(){}

	public RuleEditorRequest(String vfcmtUuid, String dcaeCompLabel, String nid, String configParam) {
		this.vfcmtUuid = vfcmtUuid;
		this.dcaeCompLabel = dcaeCompLabel;
		this.nid = nid;
		this.configParam = configParam;
	}

	public String getVfcmtUuid() {
		return vfcmtUuid;
	}

	public void setVfcmtUuid(String vfcmtUuid) {
		this.vfcmtUuid = vfcmtUuid;
	}

	public String getDcaeCompLabel() {
		return dcaeCompLabel;
	}

	public void setDcaeCompLabel(String dcaeCompLabel) {
		this.dcaeCompLabel = dcaeCompLabel;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getConfigParam() {
		return configParam;
	}

	public void setConfigParam(String configParam) {
		this.configParam = configParam;
	}

}
