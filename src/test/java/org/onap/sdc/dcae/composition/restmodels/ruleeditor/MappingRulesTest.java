package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Before;
import org.junit.Test;
import org.onap.sdc.dcae.composition.restmodels.DcaeMinimizedService;

import static org.junit.Assert.assertEquals;

public class MappingRulesTest {

    public static final String ENTRY_PHASE = "entryPhase";
    public static final String PUBLISH_PHASE = "publishPhase";
    public static final String VERSION = "1.1";
    public static final String EVENT_TYPE = "eventType";
    public static final String NOTIFY_ID = "notifyId";
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
}
