package org.onap.sdc.dcae.composition.restmodels.health;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;


public class HealthResponseTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(HealthResponse.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(HealthResponse.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(HealthResponse.class, hasValidBeanHashCodeFor());
	}
}