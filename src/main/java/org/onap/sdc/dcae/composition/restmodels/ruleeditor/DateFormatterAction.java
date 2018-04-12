package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import com.google.gson.annotations.SerializedName;

public class DateFormatterAction extends BaseAction {

	private DateFormatter dateFormatter = new DateFormatter();

	public DateFormatter getDateFormatter() {
		return dateFormatter;
	}

	public void setDateFormatter(DateFormatter dateFormatter) {
		this.dateFormatter = dateFormatter;
	}

	private class DateFormatter{
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
	}

	public String getFromFormat() {
		return dateFormatter.fromFormat;
	}

	public void setFromFormat(String fromFormat) {
		this.dateFormatter.fromFormat = fromFormat;
	}

	public String getToFormat() {
		return dateFormatter.toFormat;
	}

	public void setToFormat(String toFormat) {
		this.dateFormatter.toFormat = toFormat;
	}

	public String getFromTz() {
		return dateFormatter.fromTimezone;
	}

	public void setFromTz(String fromTz) {
		this.dateFormatter.fromTimezone = fromTz;
	}

	public String getToTz() {
		return dateFormatter.toTimezone;
	}

	public void setToTz(String toTz) {
		this.dateFormatter.toTimezone = toTz;
	}
}
