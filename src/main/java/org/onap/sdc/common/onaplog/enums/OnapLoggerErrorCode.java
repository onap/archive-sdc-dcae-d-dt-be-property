package org.onap.sdc.common.onaplog.enums;

public enum OnapLoggerErrorCode {
    SUCCESS(0),
    PERMISSION_ERROR(100),
    AVAILABILITY_TIMEOUTS_ERROR(200),
    DATA_ERROR(300),
    SCHEMA_ERROR(400),
    BUSINESS_PROCESS_ERROR(500),
    UNKNOWN_ERROR(900);

    int errorCode;

    OnapLoggerErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
