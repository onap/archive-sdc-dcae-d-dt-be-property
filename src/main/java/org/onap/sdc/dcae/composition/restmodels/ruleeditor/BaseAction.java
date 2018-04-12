package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

public class BaseAction {

	private String actionType;
	private From from;
	private String target;
	// UI generated id
	private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public void setFrom(String from) {
		this.from = new From(from);
	}

	public void setFrom(List<String> from) {
		this.from = new From(from);
	}

	public void setFrom(String from, String regex) {
		this.from = new From(from, regex);
	}

	protected class FromField {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		FromField(String value){
			setValue(value);
		}

		private FromField(){}

		private boolean isReference(){
			return StringUtils.isNoneBlank(value) && value.startsWith("${") && value.endsWith("}");
		}

		private String stripedReference() {
			return value.substring(2, value.length()-1);
		}

		boolean referencesTarget(String target) {
			return isReference() && target.equals(stripedReference());
		}

		@Override
		public boolean equals(Object obj) {
			return obj == this || !(null == obj || getClass() != obj.getClass()) && Objects.equals(value, ((FromField)obj).value);
		}

		@Override
		public int hashCode(){
			return Objects.hash(this.value);
		}
	}

	protected class From extends FromField {

		private String regex;
		// UI state of the regex field
		private String state;
		private List<FromField> values;

		public String getRegex() {
			return regex;
		}

		public void setRegex(String regex) {
			this.regex = regex;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public List<FromField> getValues() {
			return values;
		}

		public void setValues(List<FromField> values) {
			this.values = values;
		}

		protected From(String value, String regex){
			super(value);
			setRegex(regex);
		}

		protected From(List<String> valuesList) {
			List<FromField> allValues = valuesList.stream().map(FromField::new).collect(Collectors.toList());
			setValues(allValues);
		}

		protected From(String value){
			super(value);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (null == obj || getClass() != obj.getClass())
				return false;
			From other = (From) obj;
			return Objects.equals(regex, other.regex)
					&& Objects.equals(state, other.state)
					&& Objects.equals(values, other.values);
		}

		@Override
		public int hashCode(){
			return Objects.hash(this.regex,this.state,this.values);
		}

	}

	public boolean hasDependencies(Collection<BaseAction> allActions) {
		return allActions.stream().anyMatch(this::referencesTarget);
	}

	public String getFromValue() {
		return null == from ? null: StringUtils.isNoneBlank(from.getValue()) ? from.getValue() : StringUtils.join(getFromValues(), "");
	}

	public List<String> getFromValues() {
		return null == from || CollectionUtils.isEmpty(from.values) ? new ArrayList<>() : from.values.stream().map(FromField::getValue).collect(Collectors.toList());
	}

	public String getRegexValue() {
		return from.getRegex();
	}

	public boolean referencesTarget(BaseAction other) {
		return from.referencesTarget(other.strippedTarget()) ||
				other != this && !CollectionUtils.isEmpty(from.values) && from.values.stream().anyMatch(p -> p.referencesTarget(other.strippedTarget()));
	}

	String strippedTarget() {
		return target.startsWith("${") && target.endsWith("}") ? target.substring(2, target.length()-1) : target;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (null == obj || getClass() != obj.getClass())
			return false;
		BaseAction other = (BaseAction) obj;
		return Objects.equals(actionType, other.actionType)
				&& Objects.equals(target, other.target)
				&& Objects.equals(id, other.id)
				&& Objects.equals(from, other.from);
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.actionType,this.from,this.id,this.target);
	}

}
