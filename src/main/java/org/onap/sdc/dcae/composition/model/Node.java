
package org.onap.sdc.dcae.composition.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Node {

    @SerializedName("requirements")
    @Expose
    private List<Requirement> requirements = null;
    @SerializedName("capabilities")
    @Expose
    private List<Capability__> capabilities = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private List<Property_> properties = null;

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public List<Capability__> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability__> capabilities) {
        this.capabilities = capabilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Property_> getProperties() {
        return properties;
    }

    public void setProperties(List<Property_> properties) {
        this.properties = properties;
    }

}
