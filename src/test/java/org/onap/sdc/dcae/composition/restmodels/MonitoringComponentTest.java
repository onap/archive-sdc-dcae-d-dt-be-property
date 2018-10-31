package org.onap.sdc.dcae.composition.restmodels;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class MonitoringComponentTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(MonitoringComponent.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(MonitoringComponent.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(MonitoringComponent.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(MonitoringComponent.class, hasValidBeanHashCodeFor());
	}
}