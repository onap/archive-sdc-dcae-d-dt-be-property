package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;


public class ConditionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Condition.class, hasValidGettersAndSetters());
	}
}