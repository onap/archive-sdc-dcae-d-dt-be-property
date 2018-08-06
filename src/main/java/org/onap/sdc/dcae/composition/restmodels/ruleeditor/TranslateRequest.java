package org.onap.sdc.dcae.composition.restmodels.ruleeditor;


public class TranslateRequest {

	private String vfcmtUuid;
	private String dcaeCompLabel;
	private String nid;
	private String configParam;
	private String notifyId;
	//US420764 support phases configuration
	private String entryPhase;
	private String publishPhase;


	public TranslateRequest(String vfcmtUuid, String dcaeCompLabel, String nid, String configParam, String notifyId) {
		this.vfcmtUuid = vfcmtUuid;
		this.dcaeCompLabel = dcaeCompLabel;
		this.nid = nid;
		this.configParam = configParam;
		this.notifyId = notifyId;
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

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getEntryPhase() {
		return entryPhase;
	}

	public void setEntryPhase(String entryPhase) {
		this.entryPhase = entryPhase;
	}

	public String getPublishPhase() {
		return publishPhase;
	}

	public void setPublishPhase(String publishPhase) {
		this.publishPhase = publishPhase;
	}
}
