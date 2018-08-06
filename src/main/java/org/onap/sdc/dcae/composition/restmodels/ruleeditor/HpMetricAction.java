package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import java.util.Objects;

public class HpMetricAction extends BaseAction {

	private String selectedHpMetric;

	public String getSelectedHpMetric() {
		return selectedHpMetric;
	}

	public void setSelectedHpMetric(String selectedHpMetric) {
		this.selectedHpMetric = selectedHpMetric;
	}

	public boolean referencesTarget(BaseAction other){
		return false;
	}

	public String strippedTarget(){return "";}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && Objects.equals(selectedHpMetric, ((HpMetricAction)obj).selectedHpMetric);
	}

	@Override
	public int hashCode() {
		return Objects.hash(selectedHpMetric);
	}
}
