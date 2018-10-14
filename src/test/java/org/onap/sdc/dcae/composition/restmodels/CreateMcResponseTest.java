package org.onap.sdc.dcae.composition.restmodels;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class CreateMcResponseTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(CreateMcResponse.class, hasValidGettersAndSetters());
	}
}