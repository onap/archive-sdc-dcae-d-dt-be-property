package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

public abstract class BaseCondition {

	// UI evaluation fields
	private String level;
	private String name;
	private String id;

	public abstract boolean referencesTarget(String target);
}
