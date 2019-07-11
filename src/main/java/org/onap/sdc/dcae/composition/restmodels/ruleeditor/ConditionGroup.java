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
import java.util.Objects;

public class ConditionGroup extends BaseCondition {

	private String type;
	private List<BaseCondition> children;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<BaseCondition> getChildren() {
		return children;
	}

	public void setChildren(List<BaseCondition> children) {
		this.children = children;
	}

	@Override
	public boolean referencesTarget(String target) {
		return children.stream().anyMatch(c -> c.referencesTarget(target));
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(type, ((ConditionGroup)obj).type) &&
				Objects.equals(children, ((ConditionGroup)obj).children);
	}

	@Override
	public int hashCode(){
		return Objects.hash(type, children);
	}

}
