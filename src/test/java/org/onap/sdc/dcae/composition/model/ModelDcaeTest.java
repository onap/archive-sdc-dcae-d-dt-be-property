package org.onap.sdc.dcae.composition.model;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class ModelDcaeTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ModelDcae.class, hasValidGettersAndSetters());
	}
}