package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;


public class BaseCopyActionTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(BaseCopyAction.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(BaseCopyAction.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(BaseCopyAction.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(BaseCopyAction.class, hasValidBeanHashCodeFor());
	}
}