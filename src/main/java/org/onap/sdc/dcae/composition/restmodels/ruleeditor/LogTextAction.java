package org.onap.sdc.dcae.composition.restmodels.ruleeditor;


public class LogTextAction extends BaseAction {

	private LogText logText;

	private class LogText {
		private String name;
		private String level;
		private String text;
	}

	public String getName() {
		return logText.name;
	}

	public String getLevel() {
		return logText.level;
	}

	public String getText() {
		return logText.text;
	}

	public void setLogText(String name, String level, String text) {
		LogText logTextInput = new LogText();
		logTextInput.name = name;
		logTextInput.level = level;
		logTextInput.text = text;
		this.logText = logTextInput;
	}

	//TODO the text field supports ${} notation - should we check if it references another action target?
	public boolean referencesTarget(BaseAction other){
		return false;
	}

	public String strippedTarget(){return "";}

}
