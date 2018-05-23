package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.Collection;

public abstract class BaseAction {

	private String actionType;
	// UI generated id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public boolean hasDependencies(Collection<BaseAction> allActions) {
		return allActions.stream().anyMatch(this::referencesTarget);
	}

	public abstract boolean referencesTarget(BaseAction other);

	public abstract String strippedTarget();
}
