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
