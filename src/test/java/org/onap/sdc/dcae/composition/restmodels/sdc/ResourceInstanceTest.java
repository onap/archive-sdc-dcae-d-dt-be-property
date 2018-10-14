package org.onap.sdc.dcae.composition.restmodels.sdc;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class ResourceInstanceTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ResourceInstance.class, hasValidGettersAndSetters());
	}
}