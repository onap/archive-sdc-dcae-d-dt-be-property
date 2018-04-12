package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.Set;

import com.google.common.collect.ImmutableList;

public class EventTypesByVersionUI {
	
	public static final ImmutableList<String> DEFAULT_EVENTS = ImmutableList.of("commonEventHeader");
	
	private String version;
	private Set<String> eventTypes;
	
	public EventTypesByVersionUI(String version, Set<String> eventTypes) {
		super();
		this.version = version;
		this.eventTypes = eventTypes;
	}
	
	public String getVersion() {
		return version;
	}
	
	public Set<String> getEventTypes() {
		return eventTypes;
	}
	
}
