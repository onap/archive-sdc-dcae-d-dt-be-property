package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.Enums.LogMarkers;
import org.onap.sdc.common.onaplog.Enums.Severity;
import org.onap.sdc.common.onaplog.interfaces.IOnapMdcWrapper;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;


public class OnapLoggerMetric extends OnapLoggerBase {
    private static OnapLoggerMetric instanceLoggerMetric = OnapLoggerFactory.getLogger(OnapLoggerMetric.class);

    OnapLoggerMetric(IOnapMdcWrapper onapMDCWrapper) {
        super(onapMDCWrapper, MarkerFactory.getMarker(LogMarkers.METRIC_MARKER.text()));
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public static OnapLoggerMetric getInstance() {
        return instanceLoggerMetric;
    }

    @Override
    public OnapLoggerMetric startTimer() {
        return (OnapLoggerMetric) super.startTimer();
    }

    @Override
    public OnapLoggerMetric setKeyRequestId(String keyRequestId) {
        return (OnapLoggerMetric) super.setKeyRequestId(keyRequestId);
    }

    public OnapLoggerMetric stopTimer() {
        onapMDCWrapper.stopTimer();
        return this;
    }

    // automatic parameter this is optional
    public OnapLoggerMetric setAutoServerFQDN(String serverFQDN) {
        onapMDCWrapper.setAutoServerFQDN(serverFQDN);
        return this;
    }

    // automatic parameter this is optional
    public OnapLoggerMetric setAutoServerIPAddress(String serverIPAddress) {
        onapMDCWrapper.setAutoServerIPAddress(serverIPAddress);
        return this;
    }

    public OnapLoggerMetric setInstanceUUID(String instanceUUID) {
        onapMDCWrapper.setInstanceUUID(instanceUUID);
        return this;
    }

    // onap optional parameter
    public OnapLoggerMetric setOptProcessKey(String processKey) {
        onapMDCWrapper.setProcessKey(processKey);
        return this;
    }

    // onap optional parameter
    public OnapLoggerMetric setOptAlertSeverity(Severity alertSeverity) {
        onapMDCWrapper.setAlertSeverity(alertSeverity);
        return this;
    }

    // onap optional parameter
    public OnapLoggerMetric setOptCustomField1(String customField1) {
        onapMDCWrapper.setOptCustomField1(customField1);
        return this;
    }

    // onap optional parameter
    public OnapLoggerMetric setOptCustomField2(String customField2) {
        onapMDCWrapper.setOptCustomField2(customField2);
        return this;
    }

    // onap optional parameter
    public OnapLoggerMetric setOptCustomField3(String customField3) {
        onapMDCWrapper.setOptCustomField3(customField3);
        return this;
    }

    // onap optional parameter
    public OnapLoggerMetric setOptCustomField4(String customField4) {
        onapMDCWrapper.setOptCustomField4(customField4);
        return this;
    }

    public OnapLoggerMetric setRemoteHost(String remoteHost) {
        onapMDCWrapper.setRemoteHost(remoteHost);
        return this;
    }

    public OnapLoggerMetric setServiceName(String serviceName) {
        onapMDCWrapper.setServiceName(serviceName);
        return this;
    }

    public OnapLoggerMetric setStatusCode(String statusCode) {
        onapMDCWrapper.setStatusCode(statusCode);
        return this;
    }

    public OnapLoggerMetric setPartnerName(String partnerName) {
        onapMDCWrapper.setPartnerName(partnerName);
        return this;
    }

    public OnapLoggerMetric setResponseCode(int responseCode) {
        onapMDCWrapper.setResponseCode(responseCode);
        return this;
    }

    public OnapLoggerMetric setResponseDesc(String responseDesc) {
        onapMDCWrapper.setResponseDesc(responseDesc);
        return this;
    }

    public OnapLoggerMetric setOptServiceInstanceId(String serviceInstanceId) {
        onapMDCWrapper.setServiceInstanceId(serviceInstanceId);
        return this;
    }

    public OnapLoggerMetric setOptClassName(String className) {
        onapMDCWrapper.setClassName(className);
        return this;
    }

    public OnapLoggerMetric setTargetEntity(String targetEntity) {
        onapMDCWrapper.setTargetEntity(targetEntity);
        return this;
    }

    public OnapLoggerMetric setTargetServiceName(String targetServiceName) {
        onapMDCWrapper.setTargetServiceName(targetServiceName);
        return this;
    }

    public OnapLoggerMetric setTargetVirtualEntity(String targetVirtualEntity) {
        onapMDCWrapper.setTargetVirtualEntity(targetVirtualEntity);
        return this;
    }

    @Override
    public OnapLoggerMetric clear () {
        return (OnapLoggerMetric) super.clear();
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
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_SERVICE_INSTANCE_ID);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_RESPONSE_DESC);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_ELAPSED_TIME);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_TARGET_ENTITY);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_TARGET_SERVICE_NAME);
        onapMDCWrapper.setMandatoryField(OnapLogConfiguration.MDC_TARGET_VIRTUAL_ENTITY);

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
