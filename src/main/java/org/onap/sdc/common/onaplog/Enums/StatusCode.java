package org.onap.sdc.common.onaplog.Enums;

public enum StatusCode {
    ERROR("ERROR"),
    COMPLETE("COMPLETE");

    String statusCode;

    StatusCode(String statusCode){this.statusCode = statusCode;}

    public String getStatusCodeEnum(){
        return statusCode;
    }
}
