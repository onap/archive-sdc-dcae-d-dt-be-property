package org.onap.sdc.dcae.composition.restmodels.canvas;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class DcaeComponentCatalogTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(DcaeComponentCatalog.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(DcaeComponentCatalog.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(DcaeComponentCatalog.class, hasValidBeanHashCodeFor());
	}
}