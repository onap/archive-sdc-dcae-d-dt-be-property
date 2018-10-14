package org.onap.sdc.dcae.composition.services;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class ArtifactTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Artifact.class, hasValidGettersAndSetters());
	}
}