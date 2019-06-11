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

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseCopyActionTest {

    private final static String FROM = "from";
    private final static String REGEX = ".example";
    private final static String TARGET = "${\"12345\"}";
    private BaseCopyAction baseCopyAction;
    private BaseCopyAction otherBaseCopyAction;

    @Before
    public void setup() {
        baseCopyAction = new BaseCopyAction();
        baseCopyAction.setFrom(FROM);
        otherBaseCopyAction = new BaseCopyAction();
        otherBaseCopyAction.setFrom(FROM);
    }


    @Test
    public void shouldHaveValidGettersAndSetters() {
        assertThat(BaseCopyAction.class, hasValidGettersAndSetters());
    }

    @Test
    public void checkEquals() {
        assertThat(BaseCopyAction.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidConstructor() {
        assertThat(BaseCopyAction.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(BaseCopyAction.class, hasValidBeanHashCodeFor());
    }

    @Test
    public void testFromValue() {
        //when
        String from = baseCopyAction.fromValue();

        //then
        assertEquals(FROM, from);
    }

    @Test
    public void testRegexValue() {
        //given
        baseCopyAction.getFrom().setRegex(REGEX);

        //when
        String regex = baseCopyAction.regexValue();

        //then
        assertEquals(REGEX, regex);
    }


    @Test
    public void referencesTargetShouldReturnTrue() {
        //given
        baseCopyAction.getFrom().setValue(TARGET);
        otherBaseCopyAction.setTarget(TARGET);

        //then
        assertTrue(baseCopyAction.referencesTarget(otherBaseCopyAction));
    }

    @Test
    public void referencesTargetShouldReturnFalse() {
        //given
        otherBaseCopyAction.setTarget("${\"otherMock\"}");

        //then
        assertFalse(baseCopyAction.referencesTarget(otherBaseCopyAction));
    }

    @Test
    public void testStrippedTarget() {
        //given
        baseCopyAction.setTarget(TARGET);

        //when
        String strippedTarget = baseCopyAction.strippedTarget();

        //then
        assertEquals("\"12345\"", strippedTarget);
    }
}