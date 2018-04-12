package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Composition {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("composition")
	private Composition composition;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}
	
	

}
