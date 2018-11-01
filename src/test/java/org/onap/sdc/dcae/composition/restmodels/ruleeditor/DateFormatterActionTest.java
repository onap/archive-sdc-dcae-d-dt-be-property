package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateFormatterActionTest {
    private DateFormatterAction classUnderTest = new DateFormatterAction();

    @Test
    public void checkEqualsTrueOther() {
        DateFormatterAction dateFormatterAction = new DateFormatterAction();
        assertTrue(classUnderTest.equals(dateFormatterAction));
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
