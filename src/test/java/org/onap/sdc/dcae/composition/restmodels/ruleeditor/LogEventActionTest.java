package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class LogEventActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(LogEventAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(LogEventAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(LogEventAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(LogEventAction.class, hasValidBeanHashCodeFor());
	}
}