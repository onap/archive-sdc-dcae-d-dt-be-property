package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class UnaryFieldActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(UnaryFieldAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(UnaryFieldAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(UnaryFieldAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(UnaryFieldAction.class, hasValidBeanHashCodeFor());
	}
}