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

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

public abstract class BaseAction {

	private String actionType;
	// UI generated id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public boolean hasDependencies(Collection<BaseAction> allActions) {
		return allActions.stream().anyMatch(this::referencesTarget);
	}

	public abstract boolean referencesTarget(BaseAction other);

	public abstract String strippedTarget();

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (null == obj || getClass() != obj.getClass()) {
			return false;
		}
		BaseAction other = (BaseAction) obj;
		return Objects.equals(id, other.id) && Objects.equals(actionType, other.actionType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, actionType);
	}

	class FromField {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		FromField(String value){
			setValue(value);
		}

		FromField(){}

		private boolean isReference(){
			return StringUtils.isNoneBlank(value) && value.startsWith("${") && value.endsWith("}");
		}

		private String strippedReference() {
			return value.substring(2, value.length()-1);
		}

		boolean referencesTarget(String target) {
			return isReference() && target.equals(strippedReference());
		}

		@Override
		public boolean equals(Object obj) {
			return obj == this || !(null == obj || getClass() != obj.getClass()) && Objects.equals(value, ((FromField)obj).value);
		}

		@Override
		public int hashCode(){
			return Objects.hash(this.value);
		}
	}

	class UIHashMap {
		private String key;
		private String value;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}


		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			UIHashMap other = (UIHashMap) obj;
			return Objects.equals(key, other.key) && Objects.equals(value, other.value);
		}

		@Override
		public int hashCode(){
			return Objects.hash(key, value);
		}

	}
}
