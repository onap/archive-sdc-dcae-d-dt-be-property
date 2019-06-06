/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2019 Samsung. All rights reserved.
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
 */

package org.onap.sdc.dcae.composition.model.deserializer;

import static org.junit.Assert.assertEquals;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.onap.sdc.dcae.composition.model.Requirement;

public class RequirementDeserializerTest {


    @Test
    public void testDeserialize() {
        //given
        RequirementDeserializer requirementDeserializer = new RequirementDeserializer();
        String jsonString = "{\n" + "  \"occurrences\": [\n    1,\n    2,\n    3\n  ],\n"
                                    + "  \"capability\": {\n   \"name\": \"name\",\n    \"id\": \"id\"\n"
                                    + "  },\n \"name\": \"name\",\n  \"relationship\": {\n"
                                    + "    \"type\": \"type\"\n  },  \"node\": \"nodeName\"\n}";
        JsonElement jsonElement = new JsonParser().parse(jsonString);

        //when
        Requirement requirement = requirementDeserializer.deserialize(jsonElement, null, null);

        //then
        assertEquals(requirement.getOccurrences().get(0), "1");
        assertEquals(requirement.getOccurrences().get(1), "2");
        assertEquals(requirement.getOccurrences().get(2), "3");
        assertEquals(requirement.getName(), "name");
        assertEquals(requirement.getCapability().getId(), "id");
        assertEquals(requirement.getCapability().getName(), "name");
        assertEquals(requirement.getRelationship().getType(), "type");
        assertEquals(requirement.getNodeFilter(), null);
        assertEquals(requirement.getNode(), "nodeName");
    }
}
