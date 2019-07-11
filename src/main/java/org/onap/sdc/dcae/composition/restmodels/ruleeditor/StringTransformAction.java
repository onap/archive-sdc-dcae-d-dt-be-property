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

import java.util.Arrays;
import java.util.Objects;

public class StringTransformAction extends BaseCopyAction {

	private StringTransform stringTransform;

	public StringTransform getStringTransform() {
		return stringTransform;
	}

	public void setStringTransform(StringTransform stringTransform) {
		this.stringTransform = stringTransform;
	}

	public String startValue() {
		return stringTransform.startValue;
	}

	public String targetCase() {
		return stringTransform.targetCase;
	}

	public boolean trim() {
		return stringTransform.isTrimString;
	}

	private class StringTransform {

		private String startValue;
		private String targetCase;
		private boolean isTrimString;

		public String getStartValue() {
			return startValue;
		}

		public void setStartValue(String startValue) {
			this.startValue = startValue;
		}

		public boolean hasIsTrimString() {
			return isTrimString;
		}

		public void setIsTrimString(boolean isTrimString) {
			this.isTrimString = isTrimString;
		}

		public String getTargetCase() {
			return targetCase;
		}

		public void setTargetCase(String targetCase) {
			this.targetCase = targetCase;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			StringTransform other = (StringTransform) obj;
			return Objects.equals(isTrimString, other.isTrimString) && Objects.equals(startValue, other.startValue) && Objects.equals(targetCase, other.targetCase);
		}

		@Override
		public int hashCode(){
			return Objects.hash(this.targetCase,this.startValue,this.isTrimString);
		}

	}

	@Override
	public boolean referencesTarget(BaseAction other) {
		// startValue is expected to look something like "${event.otherFields.otherSiteId}${event.otherFields.otherSiteInst}${event.commonEventHeader.sourceName}"
		String[] references = StringUtils.substringsBetween(startValue(), "${", "}");
		return null != references && Arrays.asList(references).contains(other.strippedTarget());
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(stringTransform, ((StringTransformAction)obj).stringTransform);
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.stringTransform);
	}
}
