package org.onap.sdc.dcae.composition.model;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class RelationshipTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Relationship.class, hasValidGettersAndSetters());
	}
}