package org.onap.sdc.dcae.composition.model;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class CapabilityTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Capability.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(Capability.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(Capability.class, hasValidBeanHashCodeFor());
	}
}