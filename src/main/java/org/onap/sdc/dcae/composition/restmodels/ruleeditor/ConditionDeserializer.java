package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ConditionDeserializer implements JsonDeserializer<BaseCondition> {

	@Override
	public BaseCondition deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		Type clazz = Condition.class;
		JsonElement type = json.getAsJsonObject().get("type");
		if(null != type && !type.isJsonNull()) {
			clazz = ConditionGroup.class;
		}
		return context.deserialize(json, clazz);
	}
}
