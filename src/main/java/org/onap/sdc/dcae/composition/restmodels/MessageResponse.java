package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse {

	@JsonProperty("errorResponse")
	private String errorResponse;
	
	@JsonProperty("successResponse")
	private String successResponse;

	public String getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	public String getSuccessResponse() {
		return successResponse;
	}

	public void setSuccessResponse(String successResponse) {
		this.successResponse = successResponse;
	}
	
	
}
