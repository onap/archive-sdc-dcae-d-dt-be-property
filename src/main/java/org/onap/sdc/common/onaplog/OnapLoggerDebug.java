package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.Enums.LogLevel;
import org.onap.sdc.common.onaplog.Enums.LogMarkers;
import org.onap.sdc.common.onaplog.interfaces.IOnapMdcWrapper;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class OnapLoggerDebug extends OnapLoggerBase {

    private static OnapLoggerDebug instanceLoggerDebug = OnapLoggerFactory.getLogger(OnapLoggerDebug.class);

    OnapLoggerDebug(IOnapMdcWrapper onapMdcWrapper) {
        super(onapMdcWrapper, MarkerFactory.getMarker(LogMarkers.DEBUG_MARKER.text()));
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public static OnapLoggerDebug getInstance() {
        return instanceLoggerDebug;
    }

    @Override
    public void log(LogLevel errorLevel, String className, String message, Object... args) {
        String endOfRecordDelimiter = "|^\\n";
        super.log(errorLevel, className, message + endOfRecordDelimiter, args);
    }

    @Override
    public void initializeMandatoryFields() {
        // nothing to do here
    }

    @Override
    public OnapLoggerDebug clear() {
        return (OnapLoggerDebug) super.clear();
    }

    @Override
    public OnapLoggerDebug startTimer() {
        return (OnapLoggerDebug) super.startTimer();
    }

    @Override
    public OnapLoggerDebug setKeyRequestId(String keyRequestId) {
        return (OnapLoggerDebug) super.setKeyRequestId(keyRequestId);
    }
}
