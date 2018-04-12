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

	public String getName() {
		return name;
	}


	public List<EventTypeDefinitionUI> getChildren() {
		return children;
	}


	public Boolean getIsRequired() {
		return isRequired;
	}


	public List<String> getRequiredChildren() {
		return requiredChildren;
	}


	public String getId() {
		return id;
	}
}
