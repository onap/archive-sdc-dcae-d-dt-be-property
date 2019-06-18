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

import org.junit.Test;

import org.onap.sdc.common.onaplog.enums.LogLevel;
import org.slf4j.MDC;

import uk.org.lidalia.slf4jtest.LoggingEvent;

public class OnapLoggerDebugTest {

    private static final String TEST_CLASS_NAME = OnapLoggerAudit.class.getName();
    private static final String LOG_MESSAGE = "Test Message";
    private static final String KEY_REQUEST_ID = "4321";

    @Test
    public void testLoggerDebugTestFullFlow() {

        // given
        OnapLoggerDebug debug = OnapLoggerFactory.getLogger(OnapLoggerDebug.class);
        assertNotNull(debug);
        LoggerAdapter adapter = new LoggerAdapter(OnapLoggerDebug.class);

        debug.setKeyRequestId(KEY_REQUEST_ID);
        assertEquals(KEY_REQUEST_ID, MDC.get(OnapLogConfiguration.MDC_KEY_REQUEST_ID));

        // when
        debug.startTimer();
        debug.log(LogLevel.ERROR, TEST_CLASS_NAME, LOG_MESSAGE);
        debug.log(LogLevel.WARN, TEST_CLASS_NAME, LOG_MESSAGE);
        debug.log(LogLevel.INFO, TEST_CLASS_NAME, LOG_MESSAGE);
        debug.log(LogLevel.DEBUG, TEST_CLASS_NAME, LOG_MESSAGE);

        // then
        ImmutableList<LoggingEvent> logs = adapter.getLoggingEvents();
        validateDebugLog(LogLevel.ERROR, logs.get(0));
        validateDebugLog(LogLevel.WARN, logs.get(1));
        validateDebugLog(LogLevel.INFO, logs.get(2));
        validateDebugLog(LogLevel.DEBUG, logs.get(3));

        MDC.clear();
    }

    @Test
    public void testCleanLogger() {
        // given
        OnapLoggerDebug debug = OnapLoggerFactory.getLogger(OnapLoggerDebug.class);
        assertNotNull(debug);

        debug.onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_KEY_REQUEST_ID);
        debug.setKeyRequestId(KEY_REQUEST_ID);

        // when
        debug.clear();

        // then
        assertNull(MDC.get(OnapLogConfiguration.MDC_KEY_REQUEST_ID));
    }

    private void validateDebugLog(LogLevel logLevel, LoggingEvent log) {
        assertEquals(logLevel.name(), log.getLevel().name());
        assertEquals(LOG_MESSAGE + "|^\\n", log.getMessage());
        assertNotNull(log.getTimestamp());

        assertNotNull(log.getMdc().get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP));
    }
}