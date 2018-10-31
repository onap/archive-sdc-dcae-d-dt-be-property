package org.onap.sdc.dcae.composition.restmodels;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class CompositionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Composition.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(Composition.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(Composition.class, hasValidBeanHashCodeFor());
	}
}