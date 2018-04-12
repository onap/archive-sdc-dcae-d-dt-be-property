
package org.onap.sdc.dcae.composition.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Format {

    @SerializedName("equal")
    @Expose
    private String equal;

    public String getEqual() {
        return equal;
    }

    public void setEqual(String equal) {
        this.equal = equal;
    }

}
