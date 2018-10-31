package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class StringTransformActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(StringTransformAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(StringTransformAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(StringTransformAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(StringTransformAction.class, hasValidBeanHashCodeFor());
	}
}