package org.onap.sdc.dcae.composition.restmodels.ruleeditor;


public class ApplyFilterRequest extends TranslateRequest {

	private String version;
	private String eventType;
	private BaseCondition filter;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public BaseCondition getFilter() {
		return filter;
	}

	public void setFilter(BaseCondition filter) {
		this.filter = filter;
	}

	public ApplyFilterRequest(String vfcmtUuid, String dcaeCompLabel, String nid, String configParam, String notifyId, String entryPhase, String publishPhase, BaseCondition filter) {
		super(vfcmtUuid, dcaeCompLabel, nid, configParam, notifyId, entryPhase, publishPhase);
		this.filter = filter;
	}
}
