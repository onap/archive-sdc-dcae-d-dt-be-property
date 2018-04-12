package org.onap.sdc.dcae.composition.restmodels.sdc;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Service extends Asset {

    private String distributionStatus;

	public String getDistributionStatus() {
		return distributionStatus;
	}
	public void setDistributionStatus(String distributionStatus) {
		this.distributionStatus = distributionStatus;
	}

}
