
package org.onap.sdc.dcae.composition.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relationship {

    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
