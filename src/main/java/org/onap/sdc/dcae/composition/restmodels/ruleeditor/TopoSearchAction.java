package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TopoSearchAction extends BaseAction {

	private TopoSearch search;

	private class TopoSearch {

		private String searchField;
		private String searchValue;
		private Condition searchFilter;
		private String radio;
		private Enrich enrich;
		private List<UIHashMap> updates;

		public String getSearchField() {
			return searchField;
		}

		public void setSearchField(String searchField) {
			this.searchField = searchField;
		}

		public String getSearchValue() {
			return searchValue;
		}

		public void setSearchValue(String searchValue) {
			this.searchValue = searchValue;
		}

		public Condition getSearchFilter() {
			return searchFilter;
		}

		public void setSearchFilter(Condition searchFilter) {
			this.searchFilter = searchFilter;
		}

		public String getRadio() {
			return radio;
		}

		public void setRadio(String radio) {
			this.radio = radio;
		}

		public Enrich getEnrich() {
			return enrich;
		}

		public void setEnrich(Enrich enrich) {
			this.enrich = enrich;
		}

		public List<UIHashMap> getUpdates() {
			return updates;
		}

		public void setUpdates(List<UIHashMap> updates) {
			this.updates = updates;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			TopoSearch other = (TopoSearch) obj;
			return searchEquals(other) && Objects.equals(searchFilter, other.searchFilter) && Objects.equals(enrich, other.enrich) && Objects.equals(updates, other.updates);
		}

		@Override
		public int hashCode() {
			return Objects.hash(searchField, searchValue, searchFilter, enrich, radio, updates);
		}

		private boolean searchEquals(TopoSearch other) {
			return Objects.equals(searchField, other.searchField) && Objects.equals(searchValue, other.searchValue) && Objects.equals(radio, other.radio);
		}
	}

	private class Enrich {

		private List<FromField> fields;
		private String prefix;

		public List<FromField> getFields() {
			return fields;
		}

		public void setFields(List<FromField> fields) {
			this.fields = fields;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			Enrich other = (Enrich) obj;
			return Objects.equals(fields, other.fields) && Objects.equals(prefix, other.prefix);
		}

		@Override
		public int hashCode() {
			return Objects.hash(fields, prefix);
		}
	}

	public String searchField() {
		return search.searchField;
	}

	public String searchValue() {
		return search.searchValue;
	}

	public Condition searchFilter() {
		return search.searchFilter;
	}

	public List<String> enrichFields() {
		return search.enrich.fields.stream().map(FromField::getValue).collect(Collectors.toList());
	}

	public String enrichPrefix() {
		return search.enrich.prefix;
	}

	public List<UIHashMap> updates() {
		return search.updates;
	}

	public boolean doEnrich() {
		return !"updates".equalsIgnoreCase(search.radio);
	}

	public boolean conditionalSearch(){
		return null != search.searchFilter;
	}

	public Map<String, String> updatesMap() {
		return updates().stream().collect(Collectors.toMap(UIHashMap::getKey, UIHashMap::getValue));
	}


	@Override
	public boolean referencesTarget(BaseAction other) {
		String strippedTarget = other.strippedTarget();
		String strippedReference = StringUtils.substringBetween(searchValue(), "${", "}");
		return null != strippedReference && strippedReference.equals(strippedTarget) || conditionalSearch() && searchFilter().referencesTarget(strippedTarget);
	}

	//TODO enhance to targets plural
	@Override
	public String strippedTarget() {
		return "";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(search, ((TopoSearchAction)obj).search);
	}

	@Override
	public int hashCode() {
		return Objects.hash(search);
	}
}
