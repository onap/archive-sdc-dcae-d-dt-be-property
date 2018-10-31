package org.onap.sdc.dcae.composition.vfcmt;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class VfcmtTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Vfcmt.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(Vfcmt.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(Vfcmt.class, hasValidBeanHashCodeFor());
	}
}