package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class TopoSearchActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(TopoSearchAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(TopoSearchAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(TopoSearchAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(TopoSearchAction.class, hasValidBeanHashCodeFor());
	}


}