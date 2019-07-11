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

import java.util.Set;

import com.google.common.collect.ImmutableList;

public class EventTypesByVersionUI {
	
	public static final ImmutableList<String> DEFAULT_EVENTS = ImmutableList.of("commonEventHeader");
	
	private String version;
	private Set<String> eventTypes;

	EventTypesByVersionUI(){}

	public EventTypesByVersionUI(String version, Set<String> eventTypes) {
		super();
		this.version = version;
		this.eventTypes = eventTypes;
	}
	
	public String getVersion() {
		return version;
	}
	
	public Set<String> getEventTypes() {
		return eventTypes;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setEventTypes(Set<String> eventTypes) {
		this.eventTypes = eventTypes;
	}
	
}
