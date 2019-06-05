/*-
 * ============LICENSE_START===============================================
 * ONAP SDC
 * ========================================================================
 * Modifications Copyright (c) 2019 Samsung
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=================================================
 */

package org.onap.sdc.common.onaplog;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.onap.sdc.common.onaplog.Enums.LogLevel;
import org.onap.sdc.common.onaplog.Enums.OnapLoggerErrorCode;
import org.onap.sdc.common.onaplog.Enums.Severity;
import org.onap.sdc.common.onaplog.interfaces.IOnapLogConfiguration;
import org.slf4j.MDC;

import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class OnapLoggerAuditTest {

    private static final String SERVER_FQDN = "onap.test.com";
    private static final String AUTO_SERVER_IP_ADDRESS = "127.0.0.2";
    private static final String INSTANCE_UUID = "testUUID";
	private static final String TEST_CLASS_NAME = OnapLoggerAudit.class.getName();
    private static final String PROCESS_KEY = "testKey";
    private static final String CUSTOM_FIELD1 = "testField1";
    private static final String CUSTOM_FIELD2 = "testField2";
    private static final String CUSTOM_FIELD3 = "testField3";
    private static final String CUSTOM_FIELD4 = "testField4";
    private static final String REMOTE_HOST = "testHost";
    private static final String SERVICE_NAME = "testName";
    private static final String PARENT_NAME = "testParentName";
    private static final String RESPONCE_DESC = "exampleDesc";
    private static final String SERVICE_INSTANCE_ID = "1234";
    private static final String LOG_MESSAGE = "Test Message";
    private static final String KEY_REQUEST_ID = "4321";

    private static final int ALERT_SEVERITY = 2;
    private static final int RESPONSE_CODE = 2;

    @Mock
    private OnapLoggerErrorCode loggerErrorCode;
    @Mock
    private Severity severity;

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

    @Test
    public void testLoggerAuditTestFullFlow() {

        // given
        OnapLoggerAudit audit = new OnapLoggerAudit(new OnapMDCWrapper(new Stopwatch()));
        LoggerAdapter adapter = new LoggerAdapter(OnapLoggerAudit.class);

        when(loggerErrorCode.getErrorCode()).thenReturn(RESPONSE_CODE);
        when(severity.getSeverityType()).thenReturn(ALERT_SEVERITY);

        audit.initializeMandatoryFields();
        setupMDC(audit);
        validateMDC();

        // when
        audit.startTimer();
        audit.log(LogLevel.ERROR, TEST_CLASS_NAME, LOG_MESSAGE);
        audit.log(LogLevel.WARN, TEST_CLASS_NAME, LOG_MESSAGE);
        audit.log(LogLevel.INFO, TEST_CLASS_NAME, LOG_MESSAGE);
        audit.log(LogLevel.DEBUG, TEST_CLASS_NAME, LOG_MESSAGE);

        // then
        ImmutableList<LoggingEvent> logs = adapter.getLoggingEvents();
        validateAuditLog(LogLevel.ERROR, logs.get(0));
        validateAuditLog(LogLevel.WARN, logs.get(1));
        validateAuditLog(LogLevel.INFO, logs.get(2));
        validateAuditLog(LogLevel.DEBUG, logs.get(3));
    }

    private void setupMDC(OnapLoggerAudit audit) {
        audit.setAutoServerFQDN(SERVER_FQDN)
                .setAutoServerIPAddress(AUTO_SERVER_IP_ADDRESS)
                .setInstanceUUID(INSTANCE_UUID)
                .setOptClassName(TEST_CLASS_NAME)
                .setOptProcessKey(PROCESS_KEY)
                .setOptAlertSeverity(severity)
                .setOptCustomField1(CUSTOM_FIELD1)
                .setOptCustomField2(CUSTOM_FIELD2)
                .setOptCustomField3(CUSTOM_FIELD3)
                .setOptCustomField4(CUSTOM_FIELD4)
                .setRemoteHost(REMOTE_HOST)
                .setServiceName(SERVICE_NAME)
                .setPartnerName(PARENT_NAME)
                .setResponseCode(loggerErrorCode)
                .setResponseDesc(RESPONCE_DESC)
                .setOptServiceInstanceId(SERVICE_INSTANCE_ID)
                .setKeyRequestId(KEY_REQUEST_ID);
    }

    private void validateMDC() {
        assertEquals(SERVER_FQDN, MDC.get(IOnapLogConfiguration.MDC_SERVER_FQDN));
        assertEquals(AUTO_SERVER_IP_ADDRESS, MDC.get(IOnapLogConfiguration.MDC_SERVER_IP_ADDRESS));
        assertEquals(INSTANCE_UUID, MDC.get(IOnapLogConfiguration.MDC_INSTANCE_UUID));
        assertEquals(TEST_CLASS_NAME, MDC.get(IOnapLogConfiguration.MDC_CLASS_NAME));
        assertEquals(PROCESS_KEY, MDC.get(IOnapLogConfiguration.MDC_PROCESS_KEY));
        assertEquals(String.valueOf(ALERT_SEVERITY), MDC.get(IOnapLogConfiguration.MDC_ALERT_SEVERITY));
        assertEquals(CUSTOM_FIELD1, MDC.get(IOnapLogConfiguration.MDC_OPT_FIELD1));
        assertEquals(CUSTOM_FIELD2, MDC.get(IOnapLogConfiguration.MDC_OPT_FIELD2));
        assertEquals(CUSTOM_FIELD3, MDC.get(IOnapLogConfiguration.MDC_OPT_FIELD3));
        assertEquals(CUSTOM_FIELD4, MDC.get(IOnapLogConfiguration.MDC_OPT_FIELD4));
        assertEquals(REMOTE_HOST, MDC.get(IOnapLogConfiguration.MDC_REMOTE_HOST));
        assertEquals(SERVICE_NAME, MDC.get(IOnapLogConfiguration.MDC_SERVICE_NAME));
        assertEquals(PARENT_NAME, MDC.get(IOnapLogConfiguration.MDC_PARTNER_NAME));
        assertEquals(String.valueOf(RESPONSE_CODE), MDC.get(IOnapLogConfiguration.MDC_RESPONSE_CODE));
        assertEquals(SERVICE_INSTANCE_ID, MDC.get(IOnapLogConfiguration.MDC_SERVICE_INSTANCE_ID));
        assertEquals(KEY_REQUEST_ID, MDC.get(IOnapLogConfiguration.MDC_KEY_REQUEST_ID));
    }

    private void validateAuditLog(LogLevel logLevel, LoggingEvent log) {
        assertEquals(logLevel.name(), log.getLevel().name());
        assertEquals(LOG_MESSAGE, log.getMessage());
        assertNotNull(log.getTimestamp());

        ImmutableMap<String, String> mdc = log.getMdc();
        assertNotEquals(SERVER_FQDN, mdc.get(IOnapLogConfiguration.MDC_SERVER_FQDN));
        assertNotEquals(AUTO_SERVER_IP_ADDRESS, mdc.get(IOnapLogConfiguration.MDC_SERVER_IP_ADDRESS));

        assertEquals(INSTANCE_UUID, mdc.get(IOnapLogConfiguration.MDC_INSTANCE_UUID));
        assertEquals(TEST_CLASS_NAME, mdc.get(IOnapLogConfiguration.MDC_CLASS_NAME));
        assertEquals(PROCESS_KEY, mdc.get(IOnapLogConfiguration.MDC_PROCESS_KEY));
        assertEquals(String.valueOf(ALERT_SEVERITY), mdc.get(IOnapLogConfiguration.MDC_ALERT_SEVERITY));
        assertEquals(CUSTOM_FIELD1, mdc.get(IOnapLogConfiguration.MDC_OPT_FIELD1));
        assertEquals(CUSTOM_FIELD2, mdc.get(IOnapLogConfiguration.MDC_OPT_FIELD2));
        assertEquals(CUSTOM_FIELD3, mdc.get(IOnapLogConfiguration.MDC_OPT_FIELD3));
        assertEquals(CUSTOM_FIELD4, mdc.get(IOnapLogConfiguration.MDC_OPT_FIELD4));
        assertEquals(REMOTE_HOST, mdc.get(IOnapLogConfiguration.MDC_REMOTE_HOST));
        assertEquals(SERVICE_NAME, mdc.get(IOnapLogConfiguration.MDC_SERVICE_NAME));
        assertEquals(PARENT_NAME, mdc.get(IOnapLogConfiguration.MDC_PARTNER_NAME));
        assertEquals(String.valueOf(RESPONSE_CODE), mdc.get(IOnapLogConfiguration.MDC_RESPONSE_CODE));
        assertEquals(SERVICE_INSTANCE_ID, mdc.get(IOnapLogConfiguration.MDC_SERVICE_INSTANCE_ID));
        assertEquals(KEY_REQUEST_ID, mdc.get(IOnapLogConfiguration.MDC_KEY_REQUEST_ID));

        assertNotNull(mdc.get(IOnapLogConfiguration.MDC_BEGIN_TIMESTAMP));
    }

    class LoggerAdapter {

        TestLogger logger;

        LoggerAdapter(Class clazz) {
            this.logger = TestLoggerFactory.getTestLogger(clazz);
        }

        private ImmutableList<LoggingEvent> getLoggingEvents() {
            return logger.getLoggingEvents();
        }
    }
}