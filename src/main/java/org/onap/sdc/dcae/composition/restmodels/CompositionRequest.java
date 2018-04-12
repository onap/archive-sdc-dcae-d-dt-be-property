package org.onap.sdc.dcae.composition.restmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompositionRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("cid")
	private String cid;
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
}
