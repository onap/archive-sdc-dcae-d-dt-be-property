package org.onap.sdc.common.onaplog;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.junit.Assert.*;

public class OnapLoggerAuditTest {

	@Test
	public void shouldHaveValidGettersAndSetters() {
		assertThat(OnapLoggerAudit.class, hasValidGettersAndSetters());
	}

	@Test
	public void checkEquals() {
		assertThat(OnapLoggerAudit.class, hasValidBeanEquals());
	}

	@Test
	public void testHasValidConstructor() {
		assertThat(OnapLoggerAudit.class, hasValidBeanConstructor());
	}

	@Test
	public void checkHashCodeFor() {
		assertThat(OnapLoggerAudit.class, hasValidBeanHashCodeFor());
	}
}