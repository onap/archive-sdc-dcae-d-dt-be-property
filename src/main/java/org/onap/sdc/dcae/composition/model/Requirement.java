
package org.onap.sdc.dcae.composition.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Requirement {

    @SerializedName("capability")
    @Expose
    private Capability capability;
    @SerializedName("node_filter")
    @Expose
    private NodeFilter nodeFilter;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("relationship")
    @Expose
    private Relationship relationship;
    @SerializedName("occurrences")
    @Expose
    private List<String> occurrences = null;
    @SerializedName("node")
    @Expose
    private String node;

    public Capability getCapability() {
        return capability;
    }

    public void setCapability(Capability capability) {
        this.capability = capability;
    }

    public NodeFilter getNodeFilter() {
        return nodeFilter;
    }

    public void setNodeFilter(NodeFilter nodeFilter) {
        this.nodeFilter = nodeFilter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public List<String> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(List<String> occurrences) {
        this.occurrences = occurrences;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

}
