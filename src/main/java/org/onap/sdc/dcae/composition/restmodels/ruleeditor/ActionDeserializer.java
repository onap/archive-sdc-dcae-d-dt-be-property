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
