package org.onap.sdc.dcae.composition.model;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class Capability_Test {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Capability_.class, hasValidGettersAndSetters());
	}
}