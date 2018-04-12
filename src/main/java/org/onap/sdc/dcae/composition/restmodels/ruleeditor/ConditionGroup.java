package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.List;

public class ConditionGroup extends BaseCondition {

	private String type;
	private List<BaseCondition> children;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<BaseCondition> getChildren() {
		return children;
	}

	public void setChildren(List<BaseCondition> children) {
		this.children = children;
	}

	@Override
	public boolean referencesTarget(String target) {
		return children.stream().anyMatch(c -> c.referencesTarget(target));
	}

}
