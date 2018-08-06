package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class MappingRulesResponse extends MappingRules {

	private List<EventTypeDefinitionUI> schema;

	public List<EventTypeDefinitionUI> getSchema() {
		return schema;
	}

	public void setSchema(List<EventTypeDefinitionUI> schema) {
		this.schema = schema;
	}
}
