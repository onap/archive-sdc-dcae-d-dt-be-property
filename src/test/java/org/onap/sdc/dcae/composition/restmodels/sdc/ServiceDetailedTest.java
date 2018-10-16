package org.onap.sdc.dcae.composition.restmodels.sdc;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class ServiceDetailedTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ServiceDetailed.class, hasValidGettersAndSetters());
	}
}