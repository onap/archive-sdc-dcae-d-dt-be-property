package org.onap.sdc.dcae.composition.vfcmt;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class VfcmtTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(Vfcmt.class, hasValidGettersAndSetters());
	}
}