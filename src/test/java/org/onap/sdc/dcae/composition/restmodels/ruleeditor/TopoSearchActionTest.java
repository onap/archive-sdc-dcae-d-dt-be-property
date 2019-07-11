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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TopoSearchActionTest {

    private static final String ACTION_TYPE = "Test Topology Search";
    private static final String ID = "123";
    private static final String SEARCH_FIELD = "sourceToSearch";
    private static final String SEARCH_STRING = "searchString";
    private static final String SEARCH_VALUE = "${" + SEARCH_STRING + "}";
    private static final String RADIO = "1234";
    private static final String SEARCH_FILTER_LEFT = "${event.commonEventHeader.eventId}";
    private static final String SEARCH_FILTER_RIGHT_ITEM = "testItem";
    private static final String SEARCH_FILTER_RIGHT_ARRAY = "[" + SEARCH_FILTER_RIGHT_ITEM + "]";
    private static final String SEARCH_FILTER_OPERATOR = "TestOperator";
    private static final String ENRICH_FIELD1 = "enrichFiled1";
    private static final String ENRICH_FIELD2 = "enrichField2";
    private static final String ENRICH_FIELDS_ARRAY =
        "[{value:" + ENRICH_FIELD1 + "},{value:" + ENRICH_FIELD2 + "}]";
    private static final String ENRICH_PREFIX = "enrichPrefix";

    private static final String UI_HASH_MAP_KEY1 = "testKey1";
    private static final String UI_HASH_MAP_KEY2 = "testKey2";
    private static final String UI_HASH_MAP_VALUE1 = "test1";
    private static final String UI_HASH_MAP_VALUE2 = "test2";

    private static final String BAD_STRIPPED_TARGET = "badTarget";

    @Mock
    BaseAction baseAction;
    @Mock
    BaseAction baseActionWithBadTarget;

    @Test
    public void shouldHaveValidGettersAndSetters() {
        assertThat(TopoSearchAction.class, hasValidGettersAndSetters());
    }

    @Test
    public void checkEquals() {
        assertThat(TopoSearchAction.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidConstructor() {
        assertThat(TopoSearchAction.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(TopoSearchAction.class, hasValidBeanHashCodeFor());
    }

    @Test
    public void topSearchActionBaseFieldTest() {
        TopoSearchAction topoSearchAction = buildBaseConditionalTopoSearchAction();

        assertEquals(SEARCH_FIELD, topoSearchAction.searchField());
        assertEquals(SEARCH_VALUE, topoSearchAction.searchValue());
        assertNotNull(topoSearchAction.searchFilter());

        Condition filter = topoSearchAction.searchFilter();
        assertEquals(SEARCH_FILTER_LEFT, filter.left);
        assertEquals(SEARCH_FILTER_RIGHT_ITEM, filter.right.get(0));
        assertEquals(SEARCH_FILTER_OPERATOR, filter.operator);

        assertEquals(ENRICH_PREFIX, topoSearchAction.enrichPrefix());
        assertNotNull(topoSearchAction.enrichFields());

        List<String> enrichFields = topoSearchAction.enrichFields();
        assertEquals(ENRICH_FIELD1, enrichFields.get(0));
        assertEquals(ENRICH_FIELD2, enrichFields.get(1));

        assertTrue(topoSearchAction.doEnrich());
    }

    @Test
    public void topSearchActionUpdatesTest() {
        TopoSearchAction topoSearchAction = buildConditionalTopoSearchActionWithUpdates();
        assertNotNull(topoSearchAction.updates());

        List<BaseAction.UIHashMap> uiHashMapList = topoSearchAction.updates();
        assertEquals(UI_HASH_MAP_VALUE1, uiHashMapList.get(0).getValue());
        assertEquals(UI_HASH_MAP_VALUE2, uiHashMapList.get(1).getValue());
        assertEquals(UI_HASH_MAP_KEY1, uiHashMapList.get(0).getKey());
        assertEquals(UI_HASH_MAP_KEY2, uiHashMapList.get(1).getKey());

        Map<String, String> updatesMap = topoSearchAction.updatesMap();
        assertEquals(UI_HASH_MAP_VALUE1, updatesMap.get(UI_HASH_MAP_KEY1));
        assertEquals(UI_HASH_MAP_VALUE2, updatesMap.get(UI_HASH_MAP_KEY2));
    }

    @Test
    public void checkReferencesTargetTest() {
        TopoSearchAction topoSearchAction = buildBaseConditionalTopoSearchAction();

        Mockito.when(baseAction.strippedTarget()).thenReturn(SEARCH_STRING);
        Mockito.when(baseActionWithBadTarget.strippedTarget()).thenReturn(BAD_STRIPPED_TARGET);

        assertTrue(topoSearchAction.referencesTarget(baseAction));
        assertFalse(topoSearchAction.referencesTarget(baseActionWithBadTarget));
    }

    private TopoSearchAction buildBaseConditionalTopoSearchAction() {
        String topoSearch ="{actionType:\"" + ACTION_TYPE + "\"," +
                "id:" + ID + "," +
                "search:{searchField:" + SEARCH_FIELD + "," +
                "searchValue:\"" + SEARCH_VALUE + "\"," +
                "radio:" + RADIO + "," +
                "searchFilter:{left:\"" + SEARCH_FILTER_LEFT + "\"," +
                "right:" + SEARCH_FILTER_RIGHT_ARRAY + "," +
                "operator:" + SEARCH_FILTER_OPERATOR + "}," +
                "enrich:{fields:" + ENRICH_FIELDS_ARRAY + "," +
                "prefix:" + ENRICH_PREFIX + "}}}";
        return ActionBuilder.buildAction(topoSearch, TopoSearchAction.class);
    }

    private TopoSearchAction buildConditionalTopoSearchActionWithUpdates() {
        String topoSearch = "{search:{updates: [{key:" + UI_HASH_MAP_KEY1 + ", value:" + UI_HASH_MAP_VALUE1 + "},"
                + "{key:" + UI_HASH_MAP_KEY2 + ", value:" + UI_HASH_MAP_VALUE2 + "}]}}";

        return ActionBuilder.buildAction(topoSearch, TopoSearchAction.class);
    }
}
