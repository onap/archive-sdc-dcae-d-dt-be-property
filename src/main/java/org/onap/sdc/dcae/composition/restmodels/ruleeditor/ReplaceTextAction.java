package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

public class ReplaceTextAction extends UnaryFieldAction {

	private ReplaceText replaceText;

	private class ReplaceText {
		private String find;
		private String replace;
	}

	public String getFind() {
		return replaceText.find;
	}

	public String getReplace() {
		return replaceText.replace;
	}

	public String getFromValue() {
		return getFrom().getValue();
	}

}
