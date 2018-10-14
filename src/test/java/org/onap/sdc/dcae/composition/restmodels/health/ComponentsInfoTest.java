package org.onap.sdc.dcae.composition.restmodels.health;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class ComponentsInfoTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(ComponentsInfo.class, hasValidGettersAndSetters());
	}

}