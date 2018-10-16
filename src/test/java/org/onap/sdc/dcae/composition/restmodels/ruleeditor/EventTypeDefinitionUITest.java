package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class EventTypeDefinitionUITest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(EventTypeDefinitionUI.class, hasValidGettersAndSetters());
	}
}