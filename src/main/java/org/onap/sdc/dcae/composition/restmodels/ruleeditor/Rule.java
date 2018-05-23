package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Rule {
	private String version;
	private String eventType;
	private String description;
	private String uid;
	private String phase = "phase_1"; //placeholder
	private BaseCondition condition;
	private List<BaseAction> actions;

	private static Gson gson = new GsonBuilder().serializeNulls().create();

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

	public BaseCondition getCondition() {
		return condition;
	}

	public void setCondition(BaseCondition condition) {
		this.condition = condition;
	}

	public void generateUid() {
		if(StringUtils.isBlank(uid))
			uid = UUID.randomUUID().toString();
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
		return Objects.equals(version, other.version) &&
				Objects.equals(description, other.description) &&
				Objects.equals(eventType, other.eventType) &&
				Objects.equals(uid, other.uid) &&
				Objects.equals(phase, other.phase) &&
				Objects.equals(condition, other.condition) &&
				Objects.equals(actions, other.actions);
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.version,this.description,this.eventType,this.uid,this.phase,this.condition,this.actions);
	}

	public boolean referencesOtherRule(Rule other){
		return other != this && actions.stream().anyMatch(p -> p.hasDependencies(other.actions)) ||
				isConditionalRule() && other.actions.stream().map(BaseAction::strippedTarget).anyMatch(t -> condition.referencesTarget(t));
	}


	private List<BaseAction> findDependencies(Rule other) {
		return other.actions.stream()
						.filter(p -> actions.stream().anyMatch(a -> a.referencesTarget(p)) || isConditionalRule() && condition.referencesTarget(p.strippedTarget()))
						.collect(Collectors.toList());
	}

	public List<BaseAction> findDependencies(List<Rule> others) {
		return others.stream()
				.filter(r -> r != this)
				.map(this::findDependencies)
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}

	public boolean referencesOtherRules(Collection<Rule> allRules) {
		return allRules.stream().anyMatch(this::referencesOtherRule);
	}

	public boolean isConditionalRule() {
		return null != condition;
	}

}


