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

import java.util.Arrays;

public enum ActionTypeEnum {
	COPY("copy"),
	MAP("map"),
	CONCAT("concat"),
	DATE_FORMATTER("dateFormatter"),
	LOG_EVENT("logEvent"),
	LOG_TEXT("logText"),
	CLEAR("clear"),
	REPLACE_TEXT("replaceText"),
	CLEAR_NSF("clearNSF"),
	HP_METRIC("hpMetric"),
	STRING_TRANSFORM("stringTransform"),
	TOPO_SEARCH("topologySearch");

	private String type;

	ActionTypeEnum(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public static ActionTypeEnum getTypeByName(String action) {
		return Arrays.stream(ActionTypeEnum.values()).filter(a -> action.replaceAll(" ", "").equalsIgnoreCase(a.type)).findAny().orElse(null);
	}
}
