package org.onap.sdc.common.onaplog.Enums;

public enum StatusCode {
    ERROR("ERROR"),
    COMPLETE("COMPLETE");

    private String text;

    StatusCode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
