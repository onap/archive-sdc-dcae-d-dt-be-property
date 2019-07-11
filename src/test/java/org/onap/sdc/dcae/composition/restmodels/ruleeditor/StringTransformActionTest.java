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
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringTransformActionTest {

    private static final String FIRST_START_VALUE = "test1";
    private static final String START_VALUES = "${" + FIRST_START_VALUE + "}${test2}";
    private static final String TEST_TARGET = "testTarget";
    private static final String IS_TRIM = "true";

    @Mock
    private BaseAction baseAction;

    @Test
    public void shouldHaveValidGettersAndSetters() {
        assertThat(StringTransformAction.class, hasValidGettersAndSetters());
    }

    @Test
    public void checkEquals() {
        assertThat(StringTransformAction.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidConstructor() {
        assertThat(StringTransformAction.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(StringTransformAction.class, hasValidBeanHashCodeFor());
    }

    @Test
    public void stringTransformActionBaseFieldTest() {
        StringTransformAction stringTransformAction = buildBasestringTransformAction();

        assertEquals(START_VALUES, stringTransformAction.startValue());
        assertEquals(TEST_TARGET, stringTransformAction.targetCase());
        assertTrue(stringTransformAction.trim());

        Mockito.when(baseAction.strippedTarget()).thenReturn(FIRST_START_VALUE);
        assertTrue(stringTransformAction.referencesTarget(baseAction));
    }

    private StringTransformAction buildBasestringTransformAction() {
        String stringTransform = "{stringTransform: {startValue:\"" + START_VALUES + "\","
            + "targetCase:" + TEST_TARGET + "," + "isTrimString:" + IS_TRIM + "}}";

        return ActionBuilder.buildAction(stringTransform, StringTransformAction.class);
    }
}
