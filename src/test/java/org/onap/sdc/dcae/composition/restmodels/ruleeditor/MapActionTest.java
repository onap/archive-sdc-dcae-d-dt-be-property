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
 * ============LICENSE_END===========================================
 * ===================================================================
 *
 */

package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class MapActionTest {

    private MapAction mapAction;

    private static Gson gson = new GsonBuilder().registerTypeAdapter(BaseAction.class, new ActionDeserializer())
                                       .registerTypeAdapter(BaseCondition.class, new ConditionDeserializer()).create();

    @Before
    public void setup() {
        String json =
                "{\"map\":{\"default\":\"defaultValue\",\"haveDefault\":true,\"values\":[{\"UIHashMap\":{\"key\":\"val\"}}]}}";
        mapAction = gson.fromJson(json, MapAction.class);
    }

    @Test
    public void checkEqualsTrueOther() {
        MapAction equalMapAction = new MapAction();
        assertTrue(equalMapAction.equals(new MapAction()));
    }

    @Test
    public void checkEqualsTrueSame() {
        assertTrue(mapAction.equals(mapAction));
    }

    @Test
    public void checkEqualsFalse() {
        assertFalse(mapAction.equals(null));
    }

    @Test
    public void testMapHasDefault() {
        assertTrue(mapAction.mapHasDefault());
    }

    @Test
    public void testGetMapDefaultValue() {
        String defaultValue = mapAction.getMapDefaultValue();
        assertEquals("defaultValue", defaultValue);
    }

    @Test
    public void testGetMapValues() {
        List<BaseAction.UIHashMap> list = mapAction.getMapValues();
        assertEquals(1, list.size());
    }

}
