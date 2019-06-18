package org.onap.sdc.common.onaplog.enums;

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
