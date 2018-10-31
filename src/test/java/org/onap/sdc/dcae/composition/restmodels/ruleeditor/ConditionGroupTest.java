package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;


public class ConditionGroupTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ConditionGroup.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(ConditionGroup.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(ConditionGroup.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(ConditionGroup.class, hasValidBeanHashCodeFor());
	}
}