package org.onap.sdc.dcae.composition.restmodels.sdc;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class ArtifactTest {
	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Artifact.class, hasValidGettersAndSetters());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(Artifact.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(Artifact.class, hasValidBeanHashCodeFor());
	}
}