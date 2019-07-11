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

package org.onap.sdc.dcae.composition.restmodels;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DcaeMinimizedServiceTest {

    private static final String UUID = "uuid";
    private static final String NAME = "name";
    private static final String LAST_UPDATER_USER_ID = "lastUpdaterUserId";
    private static final String LIFE_CYCLE_STATE = "lifeCycleState";
    private static final String VERSION = "1.1";
    private static final String INVARIANT_UUID = "invariantUUID";
    private DcaeMinimizedService classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new DcaeMinimizedService(UUID, NAME,
                LAST_UPDATER_USER_ID, LIFE_CYCLE_STATE,
                VERSION, INVARIANT_UUID);
    }

    @Test
    public void shouldHaveValidGetters() {
        assertEquals(UUID, classUnderTest.getUuid());
        assertEquals(NAME, classUnderTest.getName());
        assertEquals(LAST_UPDATER_USER_ID, classUnderTest.getLastUpdaterUserId());
        assertEquals(LIFE_CYCLE_STATE, classUnderTest.getLifeCycleState());
        assertEquals(VERSION, classUnderTest.getVersion());
        assertEquals(INVARIANT_UUID, classUnderTest.getInvariantUUID());

    }

    @Test
    public void shouldHaveValidGettersAndSetters() {

        classUnderTest.setUuid(UUID + "1");
        classUnderTest.setName(NAME + "1");
        classUnderTest.setLastUpdaterUserId(LAST_UPDATER_USER_ID + "1");
        classUnderTest.setLifeCycleState(LIFE_CYCLE_STATE + "1");
        classUnderTest.setVersion(VERSION + "1");
        classUnderTest.setInvariantUUID(INVARIANT_UUID + "1");

        assertEquals(UUID + "1", classUnderTest.getUuid());
        assertEquals(NAME + "1", classUnderTest.getName());
        assertEquals(LAST_UPDATER_USER_ID + "1", classUnderTest.getLastUpdaterUserId());
        assertEquals(LIFE_CYCLE_STATE + "1", classUnderTest.getLifeCycleState());
        assertEquals(VERSION + "1", classUnderTest.getVersion());
        assertEquals(INVARIANT_UUID + "1", classUnderTest.getInvariantUUID());
    }
}
