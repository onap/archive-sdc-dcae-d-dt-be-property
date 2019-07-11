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

public class LogEventAction extends BaseAction {

	private LogEvent logEvent;

	private class LogEvent {
		private String title;

		public String getTitle() {
			return title;
		}

		@Override
		public boolean equals(Object obj) {
			return obj == this || !(null == obj || getClass() != obj.getClass()) && title.equals(((LogEvent)obj).title);
		}

		@Override
		public int hashCode(){
			return Objects.hash(title);
		}
	}

	public LogEvent getLogEvent() {
		return logEvent;
	}

	public void setLogEvent(LogEvent logEvent) {
		this.logEvent = logEvent;
	}

	public String logTitle() {
		return logEvent.title;
	}

	public boolean referencesTarget(BaseAction other){
		return false;
	}

	public String strippedTarget(){return "";}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(logEvent, ((LogEventAction)obj).logEvent);
	}

	@Override
	public int hashCode(){
		return Objects.hash(logEvent);
	}
}
