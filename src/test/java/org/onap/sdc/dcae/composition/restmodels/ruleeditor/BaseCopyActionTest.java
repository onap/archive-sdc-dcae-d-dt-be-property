package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;


public class BaseCopyActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(BaseCopyAction.class, hasValidGettersAndSetters());
	}
}