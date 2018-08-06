package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import com.google.gson.*;
import java.lang.reflect.Type;

public class ActionDeserializer implements JsonDeserializer<BaseAction> {

	@Override
	public BaseAction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		String action;
		try {
			action = json.getAsJsonObject().get("actionType").getAsString();
		} catch (RuntimeException e) {
			throw new JsonParseException("Missing information : action type");
		}
		ActionTypeEnum actionTypeEnum = ActionTypeEnum.getTypeByName(action);
		if (null == actionTypeEnum) {
			throw new JsonParseException("Undefined action type: " + action);
		}
		Type clazz = getActionClassByActionTypeEnum(actionTypeEnum);
		return new Gson().fromJson(json, clazz);
	}

	private Type getActionClassByActionTypeEnum(ActionTypeEnum actionTypeEnum) {
		switch (actionTypeEnum) {
		case MAP:
			return MapAction.class;
		case DATE_FORMATTER:
			return DateFormatterAction.class;
		case LOG_EVENT:
			return LogEventAction.class;
		case LOG_TEXT:
			return LogTextAction.class;
		case CLEAR:
		case CLEAR_NSF:
			return UnaryFieldAction.class;
		case REPLACE_TEXT:
			return ReplaceTextAction.class;
		case HP_METRIC:
			return HpMetricAction.class;
		case STRING_TRANSFORM:
			return StringTransformAction.class;
		case TOPO_SEARCH:
			return TopoSearchAction.class;
		default:
			// suitable for copy/regex/concat
			return BaseCopyAction.class;
		}
	}

}
