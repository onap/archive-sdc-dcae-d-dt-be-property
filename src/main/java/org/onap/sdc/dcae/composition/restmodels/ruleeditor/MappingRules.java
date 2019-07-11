/*-
 * ============LICENSE_START=======================================================
 * sdc-dcae-d-dt-be-property
 * ================================================================================
 * Copyright (C) 2017 - 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

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
	//US441901 global filtering
	private BaseCondition filter;
	private Rules rules = new Rules();

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
		this.rules = new Rules(rules);
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

	public BaseCondition getFilter() {
		return filter;
	}

	public void setFilter(BaseCondition filter) {
		this.filter = filter;
	}


	public MappingRules(Rule rule) {
		version = rule.getVersion();
		eventType = rule.getEventType();
		addOrReplaceRule(rule);
	}

	public MappingRules(ApplyFilterRequest request) {
		version = request.getVersion();
		eventType = request.getEventType();
		filter = request.getFilter();
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
		return Objects.equals(notifyId, other.notifyId) && Objects.equals(entryPhase, other.entryPhase) && Objects.equals(publishPhase, other.publishPhase) && Objects.equals(filter, other.filter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(version, notifyId, eventType, rules, entryPhase, publishPhase, filter);
	}

	private static class Rules extends LinkedHashMap<String, Rule> {
		private Rules(){}
		private Rules(Map<String,Rule> rules) {
			this.putAll(rules);
		}
	}
}
