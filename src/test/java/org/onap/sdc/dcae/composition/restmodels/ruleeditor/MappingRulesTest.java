package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Before;
import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static org.junit.Assert.*;

public class MappingRulesTest {

    private static final String ENTRY_PHASE = "entryPhase";
    private static final String PUBLISH_PHASE = "publishPhase";
    private static final String VERSION = "1.1";
    private static final String EVENT_TYPE = "eventType";
    private static final String NOTIFY_ID = "notifyId";
    private MappingRules classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new MappingRules();
    }

    @Test
    public void shouldHaveValidGettersAndSetters() {
        classUnderTest.setEntryPhase(ENTRY_PHASE);
        classUnderTest.setPublishPhase(PUBLISH_PHASE);
        classUnderTest.setVersion(VERSION);
        classUnderTest.setEventType(EVENT_TYPE);
        classUnderTest.setNotifyId(NOTIFY_ID);

        assertEquals(ENTRY_PHASE, classUnderTest.getEntryPhase());
        assertEquals(PUBLISH_PHASE, classUnderTest.getPublishPhase());
        assertEquals(VERSION, classUnderTest.getVersion());
        assertEquals(EVENT_TYPE, classUnderTest.getEventType());
        assertEquals(NOTIFY_ID, classUnderTest.getNotifyId());
    }

    @Test
    public void getRulesTest() {
        classUnderTest.addOrReplaceRule(new Rule());
        assertEquals(1, classUnderTest.getRules().size());
    }

    @Test
    public void containsRulesTest() {
        Rule rule = new Rule();
        assertFalse(classUnderTest.ruleExists(rule));
        assertTrue(classUnderTest.isEmpty());
        classUnderTest.addOrReplaceRule(rule);
        assertTrue(classUnderTest.ruleExists(rule));
        assertFalse(classUnderTest.isEmpty());
    }

    @Test
    public void checkEqualsTrueOther() {
        MappingRules equalMappingRules = new MappingRules();
        assertTrue(classUnderTest.equals(equalMappingRules));
    }

    @Test
    public void checkEqualsTrueSame() {
        assertTrue(classUnderTest.equals(classUnderTest));
    }

    @Test
    public void checkEqualsFalse() {
        assertFalse(classUnderTest.equals(null));
    }

    @Test
    public void testHasValidConstructor() {
        assertThat(MappingRules.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(MappingRules.class, hasValidBeanHashCodeFor());
    }
}
