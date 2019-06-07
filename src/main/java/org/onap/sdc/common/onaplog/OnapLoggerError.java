package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.Enums.LogLevel;
import org.onap.sdc.common.onaplog.Enums.LogMarkers;
import org.onap.sdc.common.onaplog.Enums.OnapLoggerErrorCode;
import org.onap.sdc.common.onaplog.interfaces.IOnapMdcWrapper;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.slf4j.MDC;

import static org.onap.sdc.common.onaplog.OnapLogConfiguration.*;

public class OnapLoggerError extends OnapLoggerBase {
    private static OnapLoggerError instanceLoggerError = OnapLoggerFactory.getLogger(OnapLoggerError.class);

    OnapLoggerError(IOnapMdcWrapper onapMDCWrapper) {
        super(onapMDCWrapper, MarkerFactory.getMarker(LogMarkers.ERROR_MARKER.text()));
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public static OnapLoggerError getInstance() {
        return instanceLoggerError;
    }

    @Override
    public void initializeMandatoryFields() {
        onapMDCWrapper.setMandatoryField(MDC_BEGIN_TIMESTAMP);
        onapMDCWrapper.setMandatoryField(MDC_SERVICE_NAME);
        onapMDCWrapper.setMandatoryField(MDC_ERROR_CATEGORY);
        onapMDCWrapper.setMandatoryField(MDC_ERROR_CODE);
        onapMDCWrapper.setMandatoryField(MDC_ERROR_DESC);
        onapMDCWrapper.setOptionalField(MDC_TARGET_ENTITY);
        onapMDCWrapper.setOptionalField(MDC_TARGET_SERVICE_NAME);
    }
    
    @Override
    public void log(LogLevel errorLevel, String className, String message, Object... args) {
        MDC.put(MDC_ERROR_CATEGORY, "ERROR");
        this
            .startTimer()
            .setServiceName("DCAE")
            .setErrorCode(OnapLoggerErrorCode.UNKNOWN_ERROR)
            .setErrorDescription();
        super.log(errorLevel, className, message, args);
    }

    @Override
    public OnapLoggerError startTimer() {
        return (OnapLoggerError) super.startTimer();
    }

    @Override
    public OnapLoggerError setKeyRequestId(String keyRequestId) {
        return (OnapLoggerError) super.setKeyRequestId(keyRequestId);
    }

    public OnapLoggerError setServiceName(String serviceName) {
        onapMDCWrapper.setServiceName(serviceName);
        return this;
    }

    public OnapLoggerError setTargetEntity(String targetEntity) {
        onapMDCWrapper.setTargetEntity(targetEntity);
        return this;
    }

    private OnapLoggerError setErrorCode(OnapLoggerErrorCode errorCode) {
        onapMDCWrapper.setErrorCode(errorCode.getErrorCode());
        return this;
    }

    private OnapLoggerError setErrorDescription() {
        onapMDCWrapper.setErrorDescription("error");
        return this;
    }

    @Override
    public OnapLoggerError clear() {
        return (OnapLoggerError) super.clear();
    }

}
