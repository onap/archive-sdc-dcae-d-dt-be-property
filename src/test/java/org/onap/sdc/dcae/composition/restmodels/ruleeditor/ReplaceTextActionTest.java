package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class ReplaceTextActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ReplaceTextAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(ReplaceTextAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(ReplaceTextAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(ReplaceTextAction.class, hasValidBeanHashCodeFor());
	}
}