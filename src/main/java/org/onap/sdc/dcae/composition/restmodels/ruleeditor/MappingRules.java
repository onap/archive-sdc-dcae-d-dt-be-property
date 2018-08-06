package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

public class MappingRules {

	private String version;
	private String eventType;
	//US405978 set notifyOID
	private String notifyId;
	//US420764 support phases configuration
	private String entryPhase;
	private String publishPhase;
	private Map<String, Rule> rules = new LinkedHashMap<>();

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

	public Map<String, Rule> getRules() {
		return rules;
	}

	public void setRules(Map<String, Rule> rules) {
		this.rules = rules;
	}

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

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public MappingRules(Rule rule) {
		version = rule.getVersion();
		eventType = rule.getEventType();
		addOrReplaceRule(rule);
	}

	protected MappingRules(){}

	public void addOrReplaceRule(Rule rule) {
		rule.generateUid();
		rules.put(rule.getUid(), rule);
		//US405978 set notifyOID
		notifyId = rule.getNotifyId();
		//US420764 support phases configuration
		entryPhase = rule.getEntryPhase();
		publishPhase = rule.getPublishPhase();
	}

	public boolean ruleExists(Rule rule) {
		return rules.containsKey(rule.getUid());
	}

	@JsonIgnore
	public boolean isEmpty() {
		return rules.isEmpty();
	}

	public Rule removeRule(String ruleUid) {
		return rules.remove(ruleUid);
	}

	public String describe() {
		return "{version:"+version+",eventType:"+eventType+"}";
	}

	public byte[] convertToPayload() {
		return new Gson().toJson(this).getBytes();
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (null == obj || getClass() != obj.getClass()) {
			return false;
		}
		MappingRules other = (MappingRules) obj;
		return Objects.equals(version, other.version) && Objects.equals(eventType, other.eventType) && Objects.equals(rules, other.rules) && globalTranslationFieldsEqual(other);

	}

	private boolean globalTranslationFieldsEqual(MappingRules other) {
		return Objects.equals(notifyId, other.notifyId) && Objects.equals(entryPhase, other.entryPhase) && Objects.equals(publishPhase, other.publishPhase);
	}

	@Override
	public int hashCode() {
		return Objects.hash(version, notifyId, eventType, rules, entryPhase, publishPhase);
	}
}
