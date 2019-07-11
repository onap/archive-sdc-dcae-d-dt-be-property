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

package org.onap.sdc.common.onaplog;

public class OnapLogConfiguration {
    public static String MDC_KEY_REQUEST_ID = "RequestId";
    public static String MDC_SERVICE_INSTANCE_ID = "ServiceInstanceId";
    public static String MDC_SERVICE_NAME = "ServiceName";
    public static String MDC_INSTANCE_UUID = "InstanceUUID";
    public static String MDC_SERVER_IP_ADDRESS = "ServerIPAddress";
    public static String MDC_SERVER_FQDN = "ServerFQDN";
    public static String MDC_REMOTE_HOST = "RemoteHost";
    public static String MDC_ALERT_SEVERITY = "AlertSeverity";
    public static String MDC_BEGIN_TIMESTAMP = "BeginTimestamp";
    public static String MDC_END_TIMESTAMP = "EndTimestamp";
    public static String MDC_PARTNER_NAME = "PartnerName";
    public static String MDC_STATUS_CODE = "StatusCode";
    public static String MDC_RESPONSE_CODE = "ResponseCode";
    public static String MDC_RESPONSE_DESC = "ResponseDescription";
    public static String MDC_ELAPSED_TIME = "ElapsedTime";
    public static String MDC_PROCESS_KEY = "ProcessKey";
    public static String MDC_TARGET_ENTITY = "TargetEntity";
    public static String MDC_TARGET_SERVICE_NAME = "TargetServiceName";
    public static String MDC_TARGET_VIRTUAL_ENTITY = "TargetVirtualEntity";
    public static String MDC_ERROR_CATEGORY = "ErrorCategory";
    public static String MDC_ERROR_CODE = "ErrorCode";
    public static String MDC_ERROR_DESC = "ErrorDescription";
    public static String MDC_CLASS_NAME = "ClassName";
    public static String MDC_OPT_FIELD1 = "CustomField1";
    public static String MDC_OPT_FIELD2 = "CustomField2";
    public static String MDC_OPT_FIELD3 = "CustomField3";
    public static String MDC_OPT_FIELD4 = "CustomField4";
}
