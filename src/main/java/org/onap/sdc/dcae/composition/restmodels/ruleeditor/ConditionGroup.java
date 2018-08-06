package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.List;
import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(type, ((ConditionGroup)obj).type) &&
				Objects.equals(children, ((ConditionGroup)obj).children);
	}

	@Override
	public int hashCode(){
		return Objects.hash(type, children);
	}

}
