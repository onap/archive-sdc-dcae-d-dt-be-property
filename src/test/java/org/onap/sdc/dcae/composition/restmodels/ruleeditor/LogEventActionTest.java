package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class LogEventActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(LogEventAction.class, hasValidGettersAndSetters());
	}
}