
package org.onap.sdc.dcae.composition.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capability_ {

    @SerializedName("dcae.capabilities.stream.subscribe")
    @Expose
    private DcaeCapabilitiesStreamSubscribe dcaeCapabilitiesStreamSubscribe;

    public DcaeCapabilitiesStreamSubscribe getDcaeCapabilitiesStreamSubscribe() {
        return dcaeCapabilitiesStreamSubscribe;
    }

    public void setDcaeCapabilitiesStreamSubscribe(DcaeCapabilitiesStreamSubscribe dcaeCapabilitiesStreamSubscribe) {
        this.dcaeCapabilitiesStreamSubscribe = dcaeCapabilitiesStreamSubscribe;
    }

}
