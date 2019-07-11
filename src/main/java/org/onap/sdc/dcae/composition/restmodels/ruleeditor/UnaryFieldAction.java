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

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UnaryFieldAction extends BaseAction {

	private From from;

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public void setFrom(String from) {
		this.from = new From(from);
	}

	public void setFrom(List<String> from) {
		this.from = new From(from);
	}

	public void setFrom(String from, String regex) {
		this.from = new From(from, regex);
	}

	protected class From extends FromField {

		private String regex;
		// UI state of the regex field
		private String state;
		private List<FromField> values;

		public String getRegex() {
			return regex;
		}

		public void setRegex(String regex) {
			this.regex = regex;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public List<FromField> getValues() {
			return values;
		}

		public void setValues(List<FromField> values) {
			this.values = values;
		}

		protected From(String value, String regex){
			super(value);
			setRegex(regex);
		}

		protected From(List<String> valuesList) {
			List<FromField> allValues = valuesList.stream().map(FromField::new).collect(Collectors.toList());
			setValues(allValues);
		}

		protected From(String value){
			super(value);
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj) && Objects.equals(regex, ((From) obj).regex)
					&& Objects.equals(state, ((From) obj).state)
					&& Objects.equals(values, ((From) obj).values);
		}

		@Override
		public int hashCode(){
			return Objects.hash(this.regex,this.state,this.values);
		}

	}

	public List<String> fromValues() {
		return null == from || CollectionUtils.isEmpty(from.values) ? new ArrayList<>() : from.values.stream().map(FromField::getValue).collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(from, ((UnaryFieldAction)obj).from);
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.from);
	}


	public boolean referencesTarget(BaseAction other){
		return false;
	}

	public String strippedTarget(){return "";}

	public String regexState() {
		return from.state;
	}

	public void regexState(String state) {
		from.state = state;
	}
}

