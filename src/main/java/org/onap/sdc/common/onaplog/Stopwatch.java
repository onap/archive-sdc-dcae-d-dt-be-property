package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.interfaces.IStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * this is local implementation of the stopwatch class from EELF standard with the same interface
 * can be replaced if needed with EELF lib
 */

public class Stopwatch implements IStopWatch {

    private static final Logger log = LoggerFactory.getLogger(Stopwatch.class.getName());

    Stopwatch() {
    }

    public void start() {
        if (MDC.get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP) == null || MDC.get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP).trim().length() == 0) {
            MDC.put(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP, generatedTimeNow());
        }
    }

    public void stop() {
        if (MDC.get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP) == null) {
            log.error("call to stop without calling start first, this is not compliant with EELF format");
        }
        MDC.put(OnapLogConfiguration.MDC_END_TIMESTAMP, generatedTimeNow());
        setElapsedTime();
    }

    private void setElapsedTime() {

        try {

            final LocalDateTime startTime = LocalDateTime.parse(MDC.get(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP));
            final LocalDateTime endTime = LocalDateTime.parse(MDC.get(OnapLogConfiguration.MDC_END_TIMESTAMP));

            final Duration timeDifference = Duration.between(startTime, endTime);

            MDC.put(OnapLogConfiguration.MDC_ELAPSED_TIME, String.valueOf(timeDifference.toMillis()));

        } catch(Exception ex) {
            log.error("failed to calculate elapsed time",ex);
        }
    }

    private String generatedTimeNow() {
        return String.valueOf(LocalDateTime.now(Clock.systemUTC()));
    }

}