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

/*-
 * ============LICENSE_START===============================================
 * ONAP SDC
 * ========================================================================
 * Modifications Copyright (c) 2019 Samsung
 * ========================================================================
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
 * ============LICENSE_END=================================================
 */

package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class UnaryFieldActionTest {

    private static final String REGEX = "testRegex";
    private static final String STATE = "DONE";
    private static final String VALUE_STRING_MAIN = "from";
    private static final String VALUE_STRING_INSIDE = "fromField";
    private static final String VALUE_ARRAY = "[{value:" + VALUE_STRING_INSIDE + "}]";

    @Test
    public void shouldHaveValidGettersAndSetters() {
        assertThat(UnaryFieldAction.class, hasValidGettersAndSetters());
    }

    @Test
    public void checkEquals() {
        assertThat(UnaryFieldAction.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidConstructor() {
        assertThat(UnaryFieldAction.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(UnaryFieldAction.class, hasValidBeanHashCodeFor());
    }

    @Test
    public void unaryFieldActionBaseFieldTest() {
        UnaryFieldAction unaryFieldAction = buildBaseUnaryFieldAction();
        unaryFieldAction.regexState(STATE);

        assertEquals(STATE, unaryFieldAction.regexState());
        assertNotNull(unaryFieldAction.getFrom());

        UnaryFieldAction.From from = unaryFieldAction.getFrom();
        assertEquals(REGEX, from.getRegex());
        assertEquals(VALUE_STRING_MAIN, from.getValue());
        assertNotNull(from.getValues());

        BaseAction.FromField field = from.getValues().get(0);
        assertEquals(VALUE_STRING_INSIDE, field.getValue());

        List<String> fromValues = unaryFieldAction.fromValues();
        assertTrue(fromValues.contains(VALUE_STRING_INSIDE));
    }

    private UnaryFieldAction buildBaseUnaryFieldAction() {
        String unaryField = "{from:{regex:" + REGEX + "," + "value:" + VALUE_STRING_MAIN + ","
            + "values:" + VALUE_ARRAY + "}}";
        return ActionBuilder.buildAction(unaryField, UnaryFieldAction.class);
    }
}
