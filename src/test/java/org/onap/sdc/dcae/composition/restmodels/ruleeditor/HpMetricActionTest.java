package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class HpMetricActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(HpMetricAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(HpMetricAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(HpMetricAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(HpMetricAction.class, hasValidBeanHashCodeFor());
	}
}