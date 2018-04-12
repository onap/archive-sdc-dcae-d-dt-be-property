package org.onap.sdc.dcae.composition.restmodels;

public class ImportVFCMTRequest extends CreateVFCMTRequest {

	private boolean cloneVFCMT;

	private boolean updateFlowType;

	public boolean isCloneVFCMT() {
		return cloneVFCMT;
	}

	public void setCloneVFCMT(boolean cloneVFCMT) {
		this.cloneVFCMT = cloneVFCMT;
	}

	public boolean isUpdateFlowType() {
		return updateFlowType;
	}

	public void setUpdateFlowType(boolean updateFlowType) {
		this.updateFlowType = updateFlowType;
	}
}
