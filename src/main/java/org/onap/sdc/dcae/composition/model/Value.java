
package org.onap.sdc.dcae.composition.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("get_property")
    @Expose
    private List<String> getProperty = null;

    public List<String> getGetProperty() {
        return getProperty;
    }

    public void setGetProperty(List<String> getProperty) {
        this.getProperty = getProperty;
    }

}
