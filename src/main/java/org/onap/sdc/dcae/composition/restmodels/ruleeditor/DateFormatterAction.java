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

public class DateFormatterAction extends BaseCopyAction {

	private DateFormatter dateFormatter = new DateFormatter();

	public DateFormatter getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(DateFormatter dateFormatter) {
		this.dateFormatter = dateFormatter;
	}

	private class DateFormatter {
		private String fromFormat;
		private String toFormat;
		private String fromTimezone;
		private String toTimezone;

		public String getFromFormat() {
			return fromFormat;
		}

		public void setFromFormat(String fromFormat) {
			this.fromFormat = fromFormat;
		}

		public String getToFormat() {
			return toFormat;
		}

		public void setToFormat(String toFormat) {
			this.toFormat = toFormat;
		}

		public String getFromTimezone() {
			return fromTimezone;
		}

		public void setFromTimezone(String fromTimezone) {
			this.fromTimezone = fromTimezone;
		}

		public String getToTimezone() {
			return toTimezone;
		}

		public void setToTimezone(String toTimezone) {
			this.toTimezone = toTimezone;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			DateFormatter other = (DateFormatter) obj;
			return Objects.equals(fromFormat, other.fromFormat) && Objects.equals(fromTimezone, other.fromTimezone) && Objects.equals(toFormat, other.toFormat) && Objects.equals(toTimezone, other.toTimezone);
		}

		@Override
		public int hashCode(){
			return Objects.hash(fromFormat, fromTimezone, toFormat, toTimezone);
		}
	}

	public String fromFormat() {
		return dateFormatter.fromFormat;
	}

	public void setFromFormat(String fromFormat) {
		this.dateFormatter.fromFormat = fromFormat;
	}

	public String toFormat() {
		return dateFormatter.toFormat;
	}

	public void setToFormat(String toFormat) {
		this.dateFormatter.toFormat = toFormat;
	}

	public String fromTz() {
		return dateFormatter.fromTimezone;
	}

	public void setFromTz(String fromTz) {
		this.dateFormatter.fromTimezone = fromTz;
	}

	public String toTz() {
		return dateFormatter.toTimezone;
	}

	public void setToTz(String toTz) {
		this.dateFormatter.toTimezone = toTz;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(dateFormatter, ((DateFormatterAction)obj).dateFormatter);
	}

	@Override
	public int hashCode(){
		return Objects.hash(dateFormatter);
	}
}
