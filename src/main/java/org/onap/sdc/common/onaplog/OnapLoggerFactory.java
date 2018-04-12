package org.onap.sdc.common.onaplog;

/**
 * Created by dd4296 on 12/26/2017.
 * this factory helps decouple the classes for Stopwatch and OnapMDCWrapper from
 * the EcompLogger classes
 */
public class OnapLoggerFactory {

    private OnapLoggerFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T, V> V getLogger(Class<T> type) {

        if (type.equals(OnapLoggerAudit.class)) {
            return (V) new OnapLoggerAudit(new OnapMDCWrapper(new Stopwatch()));
        }

        if (type.equals(OnapLoggerDebug.class)) {
            return (V) new OnapLoggerDebug(new OnapMDCWrapper(new Stopwatch()));
        }

        if (type.equals(OnapLoggerMetric.class)) {
            return (V) new OnapLoggerMetric(new OnapMDCWrapper(new Stopwatch()));
        }

        if (type.equals(OnapLoggerError.class)) {
            return (V) new OnapLoggerError(new OnapMDCWrapper(new Stopwatch()));
        }

        return null;
    }
}
