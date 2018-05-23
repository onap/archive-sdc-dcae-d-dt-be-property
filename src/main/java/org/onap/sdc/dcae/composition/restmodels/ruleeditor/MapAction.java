package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.annotations.SerializedName;

public class MapAction extends BaseCopyAction {

	private Transform map;

	public Transform getMap() {
		return map;
	}

	public void setMap(Transform map) {
		this.map = map;
	}

	public List<UIHashMap> getMapValues() {
		return null == map? null : map.values;
	}

	public boolean mapHasDefault() {
		return null != map && map.haveDefault;
	}

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

	}

	private class UIHashMap {
		private String key;
		private String value;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public Map<String, String> transformToMap() {
		return getMap().getValues().stream().collect(Collectors.toMap(UIHashMap::getKey, UIHashMap::getValue));
	}

}
