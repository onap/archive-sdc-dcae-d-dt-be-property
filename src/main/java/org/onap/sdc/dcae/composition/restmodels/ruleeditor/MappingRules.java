package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.LinkedHashMap;
import java.util.Map;
import com.google.gson.Gson;

public class MappingRules {
	private String version;
	private String eventType;
	private Map<String, Rule> rules = new LinkedHashMap<>();

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


	public MappingRules(Rule rule) {
		version = rule.getVersion();
		eventType = rule.getEventType();
		addOrReplaceRule(rule);
	}

	public void addOrReplaceRule(Rule rule) {
		rule.generateUid();
		rules.put(rule.getUid(), rule);
	}

	public boolean ruleExists(Rule rule) {
		return rules.containsKey(rule.getUid());
	}


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

}
