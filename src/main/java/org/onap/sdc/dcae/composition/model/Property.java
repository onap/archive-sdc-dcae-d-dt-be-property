
package org.onap.sdc.dcae.composition.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("format")
    @Expose
    private List<Format> format = null;
    @SerializedName("version")
    @Expose
    private List<Version> version = null;

    public List<Format> getFormat() {
        return format;
    }

    public void setFormat(List<Format> format) {
        this.format = format;
    }

    public List<Version> getVersion() {
        return version;
    }

    public void setVersion(List<Version> version) {
        this.version = version;
    }

}
