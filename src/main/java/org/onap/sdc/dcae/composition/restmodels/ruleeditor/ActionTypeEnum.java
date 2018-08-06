package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.Arrays;

public enum ActionTypeEnum {
	COPY("copy"),
	MAP("map"),
	CONCAT("concat"),
	DATE_FORMATTER("dateFormatter"),
	LOG_EVENT("logEvent"),
	LOG_TEXT("logText"),
	CLEAR("clear"),
	REPLACE_TEXT("replaceText"),
	CLEAR_NSF("clearNSF"),
	HP_METRIC("hpMetric"),
	STRING_TRANSFORM("stringTransform"),
	TOPO_SEARCH("topologySearch");

	private String type;

	ActionTypeEnum(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public static ActionTypeEnum getTypeByName(String action) {
		return Arrays.stream(ActionTypeEnum.values()).filter(a -> action.replaceAll(" ", "").equalsIgnoreCase(a.type)).findAny().orElse(null);
	}
}
