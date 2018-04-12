
package org.onap.sdc.dcae.composition.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NodeFilter {

    @SerializedName("capabilities")
    @Expose
    private List<Capability_> capabilities = null;

    public List<Capability_> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability_> capabilities) {
        this.capabilities = capabilities;
    }

}
