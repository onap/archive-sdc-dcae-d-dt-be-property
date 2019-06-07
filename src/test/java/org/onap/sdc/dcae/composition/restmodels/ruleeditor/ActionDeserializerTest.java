/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Modifications Copyright (c) 2019 Samsung
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END============================================
 * ===================================================================
 *
 */

package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ActionDeserializerTest {


    private Gson gson = new GsonBuilder().registerTypeAdapter(BaseAction.class, new ActionDeserializer()).create();


    @Test
    public void deserializerTest() {
        BaseCopyAction action = new BaseCopyAction();
        action.setActionType("map");
        String input = gson.toJson(action);
        BaseAction res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof MapAction);

        action.setActionType("copy");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof BaseCopyAction);

        action.setActionType("topologySearch");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof TopoSearchAction);

        action.setActionType("stringTransform");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof StringTransformAction);

        action.setActionType("hpMetric");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof HpMetricAction);

        action.setActionType("clearNSF");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof UnaryFieldAction);

        action.setActionType("replaceText");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof ReplaceTextAction);

        action.setActionType("clear");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof UnaryFieldAction);

        action.setActionType("logText");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof LogTextAction);

        action.setActionType("logEvent");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof LogEventAction);

        action.setActionType("dateFormatter");
        input = gson.toJson(action);
        res = gson.fromJson(input, BaseAction.class);
        assertTrue(res instanceof DateFormatterAction);
    }

    @Test(expected = JsonParseException.class)
    public void shouldReturnJsonParseException() {
        //given
        ActionDeserializer actionDeserializer = new ActionDeserializer();
        JsonElement jsonElement = mock(JsonElement.class);
        when(jsonElement.getAsJsonObject()).thenThrow(RuntimeException.class);
        //when
        actionDeserializer.deserialize(jsonElement, null, null);
    }

}