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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConditionDeserializerTest {

    private Gson gson = new GsonBuilder().registerTypeAdapter(BaseCondition.class, new ConditionDeserializer()).create();

    @Test
    public void deserializerTest(){
        Condition condition = new Condition();
        condition.setLeft("map");
        condition.setRight(new ArrayList<>());
        condition.setOperator("test");
        condition.setEmptyIsAssigned(true);
        String input = gson.toJson(condition);
        BaseCondition res = gson.fromJson(input, BaseCondition.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof Condition);
    }
}
