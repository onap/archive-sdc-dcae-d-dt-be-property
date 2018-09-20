package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

public class RuleEditorRequest {

	private String vfcmtUuid;
	private String dcaeCompLabel;
	private String nid;
	private String configParam;

	public RuleEditorRequest(){}

	public RuleEditorRequest(String vfcmtUuid, String dcaeCompLabel, String nid, String configParam) {
		this.vfcmtUuid = vfcmtUuid;
		this.dcaeCompLabel = dcaeCompLabel;
		this.nid = nid;
		this.configParam = configParam;
	}

	public String getVfcmtUuid() {
		return vfcmtUuid;
	}

	public void setVfcmtUuid(String vfcmtUuid) {
		this.vfcmtUuid = vfcmtUuid;
	}

	public String getDcaeCompLabel() {
		return dcaeCompLabel;
	}

	public void setDcaeCompLabel(String dcaeCompLabel) {
		this.dcaeCompLabel = dcaeCompLabel;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getConfigParam() {
		return configParam;
	}

	public void setConfigParam(String configParam) {
		this.configParam = configParam;
	}

}
