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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Rule {

	private static Gson gson = new GsonBuilder().serializeNulls().create();

	private String version;
	private String eventType;
	// US405978 set notifyOID
	private String notifyId;
	private String description;
	private String uid;
	private String phase;
	private BaseCondition condition;
	private List<BaseAction> actions;
	// US420764 support phases configuration
	private String entryPhase; //global translation value
	private String publishPhase; //global translation value
	// US427299 phase grouping
	private String groupId; //rules can be grouped into phase units. the global entry phase calls runPhase on phase_1, phase_1 on phase_2, etc.

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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public List<BaseAction> getActions() {
		return actions;
	}

	public void setActions(List<BaseAction> actions) {
		this.actions = actions;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public BaseCondition getCondition() {
		return condition;
	}

	public void setCondition(BaseCondition condition) {
		this.condition = condition;
	}

	void generateUid() {
		if(StringUtils.isBlank(uid)) {
			uid = UUID.randomUUID().toString();
		}
	}

	public String toJson() {
		return gson.toJson(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (null == obj || getClass() != obj.getClass()) {
			return false;
		}
		Rule other = (Rule) obj;
		return globalFieldsEqual(other) && localFieldsEqual(other) &&
				Objects.equals(condition, other.condition) &&
				Objects.equals(actions, other.actions);
	}

	private boolean localFieldsEqual(Rule other) {
		return Objects.equals(description, other.description) && Objects.equals(uid, other.uid) && groupFieldsEqual(other);
	}

	private boolean globalFieldsEqual(Rule other) {
		return Objects.equals(version, other.version) && Objects.equals(eventType, other.eventType) && globalMutableFieldsEqual(other);
	}

	private boolean globalMutableFieldsEqual(Rule other) {
		return Objects.equals(notifyId, other.notifyId) && Objects.equals(entryPhase, other.entryPhase) && Objects.equals(publishPhase, other.publishPhase);
	}

	private boolean groupFieldsEqual(Rule other) {
		return Objects.equals(phase, other.phase) && Objects.equals(groupId, other.groupId);
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.version,this.description,this.notifyId,this.eventType,this.uid,this.phase,this.condition,this.actions,this.entryPhase,this.publishPhase,this.groupId);
	}


	public boolean referencesOtherRule(Rule other){
		return sameGroupId(other) && (actions.stream().anyMatch(p -> p.hasDependencies(other.actions)) ||
				isConditionalRule() && other.actions.stream().map(BaseAction::strippedTarget).anyMatch(t -> condition.referencesTarget(t)));
	}

	private boolean sameGroupId(Rule other) {
		return !equals(other) && Objects.equals(groupId, other.groupId);
	}


	private List<BaseAction> findDependencies(Rule other) {
		return other.actions.stream()
						.filter(p -> actions.stream().anyMatch(a -> a.referencesTarget(p)) || isConditionalRule() && condition.referencesTarget(p.strippedTarget()))
						.collect(Collectors.toList());
	}

	public List<BaseAction> findDependencies(List<Rule> others) {
		return others.stream()
				.filter(r -> !equals(r))
				.map(this::findDependencies)
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}

	public boolean referencesOtherRules(Collection<Rule> allRules) {
		return allRules.stream().anyMatch(this::referencesOtherRule);
	}

	@JsonIgnore
	public boolean isConditionalRule() {
		return null != condition;
	}

}


