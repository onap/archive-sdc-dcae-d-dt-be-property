package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class ReplaceTextActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ReplaceTextAction.class, hasValidGettersAndSetters());
	}
}