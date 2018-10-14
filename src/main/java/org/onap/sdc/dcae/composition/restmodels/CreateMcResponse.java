package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class CreateMcResponse {

	private VfcmtData vfcmt;
	private Object cdump;

	public VfcmtData getVfcmt() {
		return vfcmt;
	}

	public void setVfcmt(VfcmtData vfcmt) {
		this.vfcmt = vfcmt;
	}

	public Object getCdump() {
		return cdump;
	}

	public void setCdump(Object cdump) {
		this.cdump = cdump;
	}

	public CreateMcResponse(VfcmtData vfcmt, Object cdump){
		this.vfcmt = vfcmt;
		this.cdump = cdump;
	}

	CreateMcResponse(){}
}
