package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RuleTest {
    private Rule classUnderTest = new Rule();

    @Test
    public void checkEqualsTrueOther() {
        Rule equalRule = new Rule();
        assertTrue(classUnderTest.equals(equalRule));
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
        assertThat(Rule.class, hasValidBeanConstructor());
    }

    @Test
    public void checkHashCodeFor() {
        assertThat(Rule.class, hasValidBeanHashCodeFor());
    }
}
