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
import org.onap.sdc.dcae.composition.model.Value;

public class ValueDeserializerTest {

    @Test
    public void testDeserialize() {
        //given
        ValueDeserializer valueDeserializer = new ValueDeserializer();
        String jsonString = "{ get_input: \"input\" }";
        JsonElement jsonElement = new JsonParser().parse(jsonString);

        //when
        Value value = valueDeserializer.deserialize(jsonElement, null, null);

        //then
        assertEquals(value.getGetProperty().get(0), "input");
    }
}
