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

import java.util.List;
import java.util.stream.Collectors;

public class EventTypeDefinitionUI {
	
	private String name;
	private List<EventTypeDefinitionUI> children;
	private Boolean isRequired;
	private List<String> requiredChildren;
	private String id;
	
	
	public EventTypeDefinitionUI(String name, List<EventTypeDefinitionUI> children, Boolean isRequired, String id) {
		super();
		this.name = name;
		this.children = children;
		this.isRequired = isRequired;
		this.id = id;
		this.requiredChildren = (children == null) ? null : children.stream()
				.filter(c-> c.isRequired)
				.map(c-> c.name)
				.collect(Collectors.toList());
	}

	EventTypeDefinitionUI(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EventTypeDefinitionUI> getChildren() {
		return children;
	}

	public void setChildren(List<EventTypeDefinitionUI> children) {
		this.children = children;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public List<String> getRequiredChildren() {
		return requiredChildren;
	}

	public void setRequiredChildren(List<String> requiredChildren) {
		this.requiredChildren = requiredChildren;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
