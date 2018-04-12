package org.onap.sdc.dcae.composition.restmodels.health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComponentsInfo {

    @SerializedName("healthCheckComponent")
    @Expose
    private String healthCheckComponent;
    @SerializedName("healthCheckStatus")
    @Expose
    private String healthCheckStatus;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("description")
    @Expose
    private String description;

    public String getHealthCheckComponent() {
        return healthCheckComponent;
    }

    public void setHealthCheckComponent(String healthCheckComponent) {
        this.healthCheckComponent = healthCheckComponent;
    }

    public String getHealthCheckStatus() {
        return healthCheckStatus;
    }

    public void setHealthCheckStatus(String healthCheckStatus) {
        this.healthCheckStatus = healthCheckStatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "ComponentsInfo [healthCheckComponent=" + healthCheckComponent + ", healthCheckStatus="
				+ healthCheckStatus + ", version=" + version + ", description=" + description + "]";
	}
    
}
