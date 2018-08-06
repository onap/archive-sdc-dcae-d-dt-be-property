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
