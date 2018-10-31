package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;


public class ConditionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Condition.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(Condition.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(Condition.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(Condition.class, hasValidBeanHashCodeFor());
	}
}