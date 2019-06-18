/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2019 Samsung. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.onap.sdc.common.onaplog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import org.onap.sdc.common.onaplog.enums.LogLevel;
import org.onap.sdc.common.onaplog.enums.OnapLoggerErrorCode;
import org.slf4j.MDC;

import uk.org.lidalia.slf4jtest.LoggingEvent;

public class OnapLoggerErrorTest {

    private static final String TEST_CLASS_NAME = OnapLoggerAudit.class.getName();

    private static final String DUMMY_SERVICE_NAME = "testName";
    private static final String EXPECTED_SERVICE_NAME = "DCAE";

    private static final String LOG_MESSAGE = "Test Message";
    private static final String KEY_REQUEST_ID = "4321";
    private static final String TARGET_ENTITY = "testEntity";
    private static final String ERROR_DESC = "error";

    @Test
    public void testLoggerErrorFullFlow() {

        // given
        OnapLoggerError error = OnapLoggerFactory.getLogger(OnapLoggerError.class);
        assertNotNull(error);
        LoggerAdapter adapter = new LoggerAdapter(OnapLoggerError.class);

        setupMDC(error);
        validateMDC();

        // when
        error.startTimer();
        error.log(LogLevel.ERROR, TEST_CLASS_NAME, LOG_MESSAGE);
        error.log(LogLevel.WARN, TEST_CLASS_NAME, LOG_MESSAGE);
        error.log(LogLevel.INFO, TEST_CLASS_NAME, LOG_MESSAGE);
        error.log(LogLevel.DEBUG, TEST_CLASS_NAME, LOG_MESSAGE);

        // then
        ImmutableList<LoggingEvent> logs = adapter.getLoggingEvents();
        validateErrorLog(LogLevel.ERROR, logs.get(0));
        validateErrorLog(LogLevel.WARN, logs.get(1));
        validateErrorLog(LogLevel.INFO, logs.get(2));
        validateErrorLog(LogLevel.DEBUG, logs.get(3));

        MDC.clear();
    }

    @Test
    public void testCleanLoggerDebug() {
        // given
        OnapLoggerError error = OnapLoggerFactory.getLogger(OnapLoggerError.class);
        assertNotNull(error);

        error.onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_KEY_REQUEST_ID);
        error.onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_SERVICE_NAME);
        error.onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_TARGET_ENTITY);
        error.setKeyRequestId(KEY_REQUEST_ID);
        error.setServiceName(DUMMY_SERVICE_NAME);
        error.setTargetEntity(TARGET_ENTITY);

        // when
        error.clear();

        // then
        assertNull(MDC.get(OnapLogConfiguration.MDC_KEY_REQUEST_ID));
        assertNull(MDC.get(OnapLogConfiguration.MDC_SERVICE_NAME));
        assertNull(MDC.get(OnapLogConfiguration.MDC_TARGET_ENTITY));
    }

    private void setupMDC(OnapLoggerError error) {
        error.setKeyRequestId(KEY_REQUEST_ID)
                .setServiceName(DUMMY_SERVICE_NAME)
                .setTargetEntity(TARGET_ENTITY);
    }

    private void validateMDC() {
        assertEquals(KEY_REQUEST_ID, MDC.get(OnapLogConfiguration.MDC_KEY_REQUEST_ID));
        assertEquals(DUMMY_SERVICE_NAME, MDC.get(OnapLogConfiguration.MDC_SERVICE_NAME));
        assertEquals(TARGET_ENTITY, MDC.get(OnapLogConfiguration.MDC_TARGET_ENTITY));
    }

    private void validateErrorLog(LogLevel logLevel, LoggingEvent log) {
        assertEquals(logLevel.name(), log.getLevel().name());
        assertEquals(LOG_MESSAGE, log.getMessage());
        assertNotNull(log.getTimestamp());

        ImmutableMap<String, String> mdc = log.getMdc();

        assertEquals(TEST_CLASS_NAME, mdc.get(OnapLogConfiguration.MDC_CLASS_NAME));
        assertEquals(EXPECTED_SERVICE_NAME, mdc.get(OnapLogConfiguration.MDC_SERVICE_NAME));
        assertEquals(KEY_REQUEST_ID, mdc.get(OnapLogConfiguration.MDC_KEY_REQUEST_ID));

        assertEquals(Integer.toString(OnapLoggerErrorCode.UNKNOWN_ERROR.getErrorCode()),
                mdc.get(OnapLogConfiguration.MDC_ERROR_CODE));
        assertEquals(ERROR_DESC, mdc.get(OnapLogConfiguration.MDC_ERROR_DESC));

        assertNotNull(mdc.get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP));
    }
}