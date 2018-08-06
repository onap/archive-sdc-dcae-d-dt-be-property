package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

public class MapAction extends BaseCopyAction {

	private Transform map;

	public Transform getMap() {
		return map;
	}

	public void setMap(Transform map) {
		this.map = map;
	}

	@JsonIgnore
	public List<UIHashMap> getMapValues() {
		return null == map? null : map.values;
	}

	public boolean mapHasDefault() {
		return null != map && map.haveDefault;
	}

	@JsonIgnore
	public String getMapDefaultValue() {
		return null == map? null : map.defaultValue;
	}


	private class Transform {
		@SerializedName("default")
		private String defaultValue;
		private boolean haveDefault;
		private List<UIHashMap> values;

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		public boolean isHaveDefault() {
			return haveDefault;
		}

		public void setHaveDefault(boolean haveDefault) {
			this.haveDefault = haveDefault;
		}

		public List<UIHashMap> getValues() {
			return values;
		}

		public void setValues(List<UIHashMap> values) {
			this.values = values;
		}


		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (null == obj || getClass() != obj.getClass()) {
				return false;
			}
			Transform other = (Transform) obj;
			return Objects.equals(defaultValue, other.defaultValue) && Objects.equals(haveDefault, other.haveDefault) && Objects.equals(values, other.values);
		}

		@Override
		public int hashCode(){
			return Objects.hash(defaultValue, haveDefault, values);
		}

	}

	public Map<String, String> transformToMap() {
		return getMap().getValues().stream().collect(Collectors.toMap(UIHashMap::getKey, UIHashMap::getValue));
	}


	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(map, ((MapAction) obj).map);
	}

	@Override
	public int hashCode(){
		return Objects.hash(map);
	}

}
