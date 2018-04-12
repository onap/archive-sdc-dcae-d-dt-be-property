package org.onap.sdc.common.onaplog.interfaces;

import org.onap.sdc.common.onaplog.OnapMDCWrapper;
import org.onap.sdc.common.onaplog.Enums.Severity;

/**
 * Created by dd4296 on 12/25/2017.
 */
public interface IOnapMdcWrapper {
    OnapMDCWrapper startTimer();

    OnapMDCWrapper stopTimer();

    OnapMDCWrapper setClassName(String className);

    // automatic parameter this is optional
    OnapMDCWrapper setAutoServerFQDN(String serverFQDN);

    // automatic parameter this is optional
    OnapMDCWrapper setAutoServerIPAddress(String serverIPAddress);

    OnapMDCWrapper setInstanceUUID(String instanceUUID);

    OnapMDCWrapper setProcessKey(String processKey);

    OnapMDCWrapper setAlertSeverity(Severity alertSeverity);

    OnapMDCWrapper setOptCustomField1(String customField1);

    OnapMDCWrapper setOptCustomField2(String customField2);

    OnapMDCWrapper setOptCustomField3(String customField3);

    OnapMDCWrapper setOptCustomField4(String customField4);

    OnapMDCWrapper setKeyRequestId(String keyRequestId);

    OnapMDCWrapper setRemoteHost(String remoteHost);

    OnapMDCWrapper setServiceName(String serviceName);

    OnapMDCWrapper setStatusCode(String statusCode);

    OnapMDCWrapper setPartnerName(String partnerName);

    OnapMDCWrapper setResponseCode(int responseCode);

    OnapMDCWrapper setResponseDesc(String responseDesc);

    OnapMDCWrapper setServiceInstanceId(String serviceInstanceId);

    OnapMDCWrapper setTargetEntity(String targetEntity);

    OnapMDCWrapper setTargetServiceName(String targetServiceName);

    OnapMDCWrapper setTargetVirtualEntity(String targetVirtualEntity);

    OnapMDCWrapper setErrorCode(int errorCode);

    OnapMDCWrapper setErrorDescription(String errorDescription);

    OnapMDCWrapper clear();

    void validateMandatoryFields();

    void setMandatoryField(String mdcKeyRequestId);

    void setOptionalField(String mdcKeyRequestId);

    boolean isMDCParamEmpty(String mdcKeyName);

    String getFqdn();

    String getHostAddress();
}
