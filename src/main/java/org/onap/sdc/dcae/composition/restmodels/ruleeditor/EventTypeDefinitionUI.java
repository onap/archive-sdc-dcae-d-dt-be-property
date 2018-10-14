package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.List;
import java.util.stream.Collectors;

public class EventTypeDefinitionUI {
	
	private String name;
	private List<EventTypeDefinitionUI> children;
	private Boolean isRequired;
	private List<String> requiredChildren;
	private String id;
	
	
	public EventTypeDefinitionUI(String name, List<EventTypeDefinitionUI> children, Boolean isRequired, String id) {
		super();
		this.name = name;
		this.children = children;
		this.isRequired = isRequired;
		this.id = id;
		this.requiredChildren = (children == null) ? null : children.stream()
				.filter(c-> c.isRequired)
				.map(c-> c.name)
				.collect(Collectors.toList());
	}

	EventTypeDefinitionUI(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EventTypeDefinitionUI> getChildren() {
		return children;
	}

	public void setChildren(List<EventTypeDefinitionUI> children) {
		this.children = children;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public List<String> getRequiredChildren() {
		return requiredChildren;
	}

	public void setRequiredChildren(List<String> requiredChildren) {
		this.requiredChildren = requiredChildren;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
