package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.Objects;

public abstract class BaseCondition {

	// UI evaluation fields
	private String level;
	private String name;
	private String id;

	public String getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract boolean referencesTarget(String target);

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (null == obj || getClass() != obj.getClass()) {
			return false;
		}
		BaseCondition other = (BaseCondition) obj;
		return Objects.equals(id, other.id) && Objects.equals(level, other.level) && Objects.equals(name, other.name);
	}

	@Override
	public abstract int hashCode();
}
