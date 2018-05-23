package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

public class LogEventAction extends BaseAction {

	private LogEvent logEvent;

	private class LogEvent {
		private String title;
	}

	public String getTitle() {
		return logEvent.title;
	}

	public boolean referencesTarget(BaseAction other){
		return false;
	}

	public String strippedTarget(){return "";}
}
