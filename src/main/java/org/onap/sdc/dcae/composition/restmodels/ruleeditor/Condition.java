package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Condition extends BaseCondition {

	protected String left;
	protected String operator;
	protected List<String> right = new ArrayList<>();
	protected boolean emptyIsAssigned;

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<String> getRight() {
		return right;
	}

	public void setRight(List<String> right) {
		this.right = right;
	}

	public boolean isEmptyIsAssigned() {
		return emptyIsAssigned;
	}

	public void setEmptyIsAssigned(boolean emptyIsAssigned) {
		this.emptyIsAssigned = emptyIsAssigned;
	}


	@Override
	public boolean referencesTarget(String target) {
		return Stream.concat(Stream.of(left), right.stream())
				.filter(this::isReference)
				.map(this::strippedReference)
				.anyMatch(target::equals);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(left, ((Condition)obj).left) &&
				Objects.equals(operator, ((Condition)obj).operator) &&
				Objects.equals(right, ((Condition)obj).right) &&
				emptyIsAssigned == ((Condition)obj).emptyIsAssigned;
	}

	@Override
	public int hashCode(){
		return Objects.hash(left, operator, right, emptyIsAssigned);
	}

	private String strippedReference(String value) {
		return value.substring(2, value.length()-1);
	}

	private boolean isReference(String value) {
		return value.startsWith("${") && value.endsWith("}");
	}


}

