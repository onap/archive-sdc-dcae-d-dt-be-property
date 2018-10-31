package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class LogTextActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(LogTextAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(LogTextAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(LogTextAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(LogTextAction.class, hasValidBeanHashCodeFor());
	}
}