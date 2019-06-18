package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.enums.LogMarkers;
import org.onap.sdc.common.onaplog.enums.OnapLoggerErrorCode;
import org.onap.sdc.common.onaplog.enums.Severity;
import org.onap.sdc.common.onaplog.enums.StatusCode;
import org.onap.sdc.common.onaplog.interfaces.IOnapMdcWrapper;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.MarkerFactory;

public class OnapLoggerAudit extends OnapLoggerBase {
    private static OnapLoggerAudit instanceLoggerAudit = OnapLoggerFactory.getLogger(OnapLoggerAudit.class);

    OnapLoggerAudit(IOnapMdcWrapper onapMDCWrapper) {
        super (onapMDCWrapper, MarkerFactory.getMarker(LogMarkers.AUDIT_MARKER.text()));
        logger = LoggerFactory.getLogger(this.getClass().getName());
   }

   OnapLoggerAudit(){}

    public static OnapLoggerAudit getInstance() {
        return instanceLoggerAudit;
    }

    @Override
    public OnapLoggerAudit startTimer() {
        return (OnapLoggerAudit) super.startTimer();
    }

    public OnapLoggerAudit stopTimer() {
        onapMDCWrapper.stopTimer();
        return this;
    }

    // automatic parameter this is optional
    public OnapLoggerAudit setAutoServerFQDN(String serverFQDN) {
        onapMDCWrapper.setAutoServerFQDN(serverFQDN);
        return this;
    }

    // automatic parameter this is optional
    public OnapLoggerAudit setAutoServerIPAddress(String serverIPAddress) {
        onapMDCWrapper.setAutoServerIPAddress(serverIPAddress);
        return this;
    }

    public OnapLoggerAudit setInstanceUUID(String instanceUUID) {
        onapMDCWrapper.setInstanceUUID(instanceUUID);
        return this;
    }

    public OnapLoggerAudit setOptClassName(String className) {
        MDC.put("ClassName", className);
        return this;
    }

    public OnapLoggerAudit setOptProcessKey(String processKey) {
        onapMDCWrapper.setProcessKey(processKey);
        return this;
    }

    public OnapLoggerAudit setOptAlertSeverity(Severity alertSeverity) {
        onapMDCWrapper.setAlertSeverity(alertSeverity);
        return this;
    }

    // onap optional parameter
    public OnapLoggerAudit setOptCustomField1(String customField1) {
        onapMDCWrapper.setOptCustomField1(customField1);
        return this;
    }

    // onap optional parameter
    public OnapLoggerAudit setOptCustomField2(String customField2) {
        onapMDCWrapper.setOptCustomField2(customField2);
        return this;
    }

    // onap optional parameter
    public OnapLoggerAudit setOptCustomField3(String customField3) {
        onapMDCWrapper.setOptCustomField3(customField3);
        return this;
    }

    public OnapLoggerAudit setOptCustomField4(String customField4) {
        onapMDCWrapper.setOptCustomField4(customField4);
        return this;
    }

    @Override
    public OnapLoggerAudit setKeyRequestId(String keyRequestId) {
        return (OnapLoggerAudit) super.setKeyRequestId(keyRequestId);
    }

    public OnapLoggerAudit setRemoteHost(String remoteHost) {
        onapMDCWrapper.setRemoteHost(remoteHost);
        return this;
    }

    public OnapLoggerAudit setServiceName(String serviceName) {
        onapMDCWrapper.setServiceName(serviceName);
        return this;
    }

    public OnapLoggerAudit setStatusCode(String statusCode) {
        // status code is either success (COMPLETE) or failure (ERROR) of the request.
        String respStatus = Integer.parseInt(statusCode) / 100 == 2 ?
                StatusCode.COMPLETE.getText() : StatusCode.ERROR.getText();
        onapMDCWrapper.setStatusCode(respStatus);
        return this;
    }

    public OnapLoggerAudit setPartnerName(String partnerName) {
        onapMDCWrapper.setPartnerName(partnerName);
        return this;
    }

    public OnapLoggerAudit setResponseCode(OnapLoggerErrorCode responseCode) {
        onapMDCWrapper.setResponseCode(responseCode.getErrorCode());
        return this;
    }

    public OnapLoggerAudit setResponseDesc(String responseDesc) {
        onapMDCWrapper.setResponseDesc(responseDesc);
        return this;
    }

    public OnapLoggerAudit setOptServiceInstanceId(String serviceInstanceId) {
        onapMDCWrapper.setServiceInstanceId(serviceInstanceId);
        return this;
    }

    @Override
    public OnapLoggerAudit clear() {
        return (OnapLoggerAudit) super.clear();
    }

    @Override
    public void initializeMandatoryFields() {

        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_BEGIN_TIMESTAMP);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_END_TIMESTAMP);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_KEY_REQUEST_ID);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_SERVICE_NAME);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_PARTNER_NAME);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_STATUS_CODE);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_RESPONSE_CODE);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_RESPONSE_DESC);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_ELAPSED_TIME);

        //Theoretically Optional, but practically Mandatory
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_SERVER_IP_ADDRESS);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_SERVER_FQDN);

        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_INSTANCE_UUID);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_ALERT_SEVERITY);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_REMOTE_HOST);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_CLASS_NAME);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_PROCESS_KEY);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_OPT_FIELD1);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_OPT_FIELD2);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_OPT_FIELD3);
        onapMDCWrapper.setOptionalField(OnapLogConfiguration.MDC_OPT_FIELD4);
    }
}
