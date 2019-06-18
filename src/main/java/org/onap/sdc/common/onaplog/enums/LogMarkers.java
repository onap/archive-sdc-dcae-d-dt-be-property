package org.onap.sdc.common.onaplog.enums;

public enum LogMarkers {
    DEBUG_MARKER("DEBUG_MARKER"),
    ERROR_MARKER("ERROR_MARKER"),
    AUDIT_MARKER("AUDIT_MARKER"),
    METRIC_MARKER("METRICS");

    private String text;

    LogMarkers (String text){
        this.text = text;
    }

    public String text(){
        return text;
    }

}
