package org.onap.sdc.dcae.composition.restmodels.ruleeditor;


public class TranslateRequest extends RuleEditorRequest {

	private String notifyId;
	//US420764 support phases configuration
	private String entryPhase;
	private String publishPhase;


	public TranslateRequest(String vfcmtUuid, String dcaeCompLabel, String nid, String configParam, String notifyId, String entryPhase, String publishPhase) {
	    super(vfcmtUuid, dcaeCompLabel, nid, configParam);
		this.notifyId = notifyId;
		this.entryPhase = entryPhase;
		this.publishPhase = publishPhase;
	}

	TranslateRequest(){}

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
