
package org.onap.sdc.dcae.composition.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.Error;

public class ModelDcae {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("error")
    @Expose
    private java.lang.Error error;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public java.lang.Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}