package org.onap.sdc.dcae.composition.restmodels.sdc;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;


public class DcaeComponentsTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(DcaeComponents.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(DcaeComponents.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(DcaeComponents.class, hasValidBeanHashCodeFor());
	}
}