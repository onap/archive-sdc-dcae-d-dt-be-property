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
import org.slf4j.MDC;
import uk.org.lidalia.slf4jtest.LoggingEvent;

public class OnapLoggerGenericTest {

    private static final String FIRST_ERROR_EXPECTED_MESSAGE =
        "call to stop without calling start first, " + "this is not compliant with EELF format";
    private static final String SECOND_ERROR_EXPECTED_MESSAGE = "failed to calculate elapsed time";
    private static final String ERROR = "ERROR";

    @Test
    public void stopWatchTest() {
        // given
        Stopwatch stopwatch = new Stopwatch();

        // when
        stopwatch.start();
        stopwatch.stop();

        // then
        assertNotNull(MDC.get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP));
        assertNotNull(MDC.get(OnapLogConfiguration.MDC_END_TIMESTAMP));
        assertNotNull(MDC.get(OnapLogConfiguration.MDC_ELAPSED_TIME));

        MDC.clear();
    }

    @Test
    public void stopWatchFailTest() {
        // given
        Stopwatch stopwatch = new Stopwatch();
        LoggerAdapter adapter = new LoggerAdapter(Stopwatch.class);

        // when
        stopwatch.stop();
        ImmutableList<LoggingEvent> logs = adapter.getLoggingEvents();

        // then
        LoggingEvent log = logs.get(0);
        assertEquals(ERROR, log.getLevel().name());
        assertEquals(FIRST_ERROR_EXPECTED_MESSAGE, log.getMessage());

        log = logs.get(1);
        assertEquals(ERROR, log.getLevel().name());
        assertEquals(SECOND_ERROR_EXPECTED_MESSAGE, log.getMessage());

        MDC.clear();
    }

    @Test
    public void onapLoggerFactoryTest() {

        OnapLoggerAudit audit = OnapLoggerFactory.getLogger(OnapLoggerAudit.class);
        OnapLoggerDebug debug = OnapLoggerFactory.getLogger(OnapLoggerDebug.class);
        OnapLoggerMetric metric = OnapLoggerFactory.getLogger(OnapLoggerMetric.class);
        OnapLoggerError error = OnapLoggerFactory.getLogger(OnapLoggerError.class);
        Stopwatch stopwatch = OnapLoggerFactory.getLogger(Stopwatch.class);

        assertNotNull(audit);
        assertNotNull(debug);
        assertNotNull(metric);
        assertNotNull(error);

        assertNull(stopwatch);
    }
}
