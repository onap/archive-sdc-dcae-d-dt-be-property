package org.onap.sdc.common.onaplog;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.junit.Assert.*;

public class OnapLoggerAuditTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(OnapLoggerAudit.class, hasValidGettersAndSetters());
	}
}