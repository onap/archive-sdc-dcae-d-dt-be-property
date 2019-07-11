/*-
 * ============LICENSE_START=======================================================
 * sdc-dcae-d-dt-be-property
 * ================================================================================
 * Copyright (C) 2017 - 2019 AT&T Intellectual Property. All rights reserved.
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

package org.onap.sdc.common.onaplog.interfaces;

import org.onap.sdc.common.onaplog.OnapMDCWrapper;
import org.onap.sdc.common.onaplog.enums.Severity;

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
