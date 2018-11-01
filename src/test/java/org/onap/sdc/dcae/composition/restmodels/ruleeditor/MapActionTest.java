package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapActionTest {
    private MapAction classUnderTest = new MapAction();

    @Test
    public void checkEqualsTrueOther() {
        MapAction equalMapAction = new MapAction();
        assertTrue(classUnderTest.equals(equalMapAction));
    }

    @Test
    public void checkEqualsTrueSame() {
        assertTrue(classUnderTest.equals(classUnderTest));
    }

    @Test
    public void checkEqualsFalse() {
        assertFalse(classUnderTest.equals(null));
    }

}
