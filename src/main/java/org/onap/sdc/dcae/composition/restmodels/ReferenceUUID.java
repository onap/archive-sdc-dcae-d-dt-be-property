package org.onap.sdc.dcae.composition.restmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceUUID {

    @JsonProperty("referenceUUID")
    private String referenceUUID;

    public ReferenceUUID(String referenceUUID) {
        this.referenceUUID = referenceUUID;
    }

    ReferenceUUID(){}

    public String getReferenceUUID() {
        return referenceUUID;
    }

    public void setReferenceUUID(String referenceUUID) {
        this.referenceUUID = referenceUUID;
    }
}
