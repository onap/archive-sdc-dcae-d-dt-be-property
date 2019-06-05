/*-
 * ============LICENSE_START=======================================================
 * ONAP CLAMP
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
 *
 */

package org.onap.sdc.dcae.composition.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DcaeBeConstantsTest {

    @Test
    public void testNull() {
        // when
        final DcaeBeConstants.LifecycleStateEnum state = DcaeBeConstants.LifecycleStateEnum.findState(null);

        // then
        assertNull(state);
    }

    @Test
    public void testEmptyString() {
        // when
        final DcaeBeConstants.LifecycleStateEnum state = DcaeBeConstants.LifecycleStateEnum.findState("");

        // then
        assertNull(state);
    }

    @Test
    public void testAllValues() {
        for (DcaeBeConstants.LifecycleStateEnum givenState : DcaeBeConstants.LifecycleStateEnum.values()) {

            // when
            final DcaeBeConstants.LifecycleStateEnum state = DcaeBeConstants.LifecycleStateEnum.findState(givenState.name());

            // then
            assertEquals(givenState, state);
        }
    }
}
