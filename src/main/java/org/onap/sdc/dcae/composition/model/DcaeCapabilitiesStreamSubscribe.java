
package org.onap.sdc.dcae.composition.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DcaeCapabilitiesStreamSubscribe {

    @SerializedName("properties")
    @Expose
    private List<Property> properties = null;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

}
