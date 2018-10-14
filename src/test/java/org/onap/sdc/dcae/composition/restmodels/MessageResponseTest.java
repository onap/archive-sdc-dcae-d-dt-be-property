package org.onap.sdc.dcae.composition.restmodels;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class MessageResponseTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(MessageResponse.class, hasValidGettersAndSetters());
	}
}