package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.onap.sdc.dcae.composition.restmodels.ruleeditor.ActionDeserializer;
import org.onap.sdc.dcae.composition.restmodels.ruleeditor.BaseAction;
import org.onap.sdc.dcae.composition.restmodels.ruleeditor.MapAction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ActionDeserializerTest {


	private Gson gson = new GsonBuilder().registerTypeAdapter(BaseAction.class, new ActionDeserializer()).create();

	@Test
	public void deserializerTest(){
		BaseAction action = new BaseAction();
		action.setActionType("map");
		String input = gson.toJson(action);
		BaseAction res = gson.fromJson(input, BaseAction.class);
		assertEquals(gson.toJson(res), input);
		assertTrue(res instanceof MapAction);
	}

}