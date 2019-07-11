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

import java.util.Objects;

public class ReplaceTextAction extends UnaryFieldAction {

	private ReplaceText replaceText;

	private class ReplaceText {
		private String find;
		private String replace;

		public String getFind() {
			return find;
		}

		public String getReplace() {
			return replace;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			ReplaceText other = (ReplaceText) obj;
			return Objects.equals(find, other.find) && Objects.equals(replace, other.replace);
		}

		@Override
		public int hashCode(){
			return Objects.hash(find, replace);
		}
	}

	public ReplaceText getReplaceText() {
		return replaceText;
	}

	public void setReplaceText(ReplaceText replaceText) {
		this.replaceText = replaceText;
	}

	public String find() {
		return replaceText.find;
	}

	public String replace() {
		return replaceText.replace;
	}

	public String fromValue() {
		return getFrom().getValue();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(replaceText, ((ReplaceTextAction)obj).replaceText);
	}

	@Override
	public int hashCode(){
		return Objects.hash(replaceText);
	}

}
