package org.onap.sdc.dcae.composition.restmodels.ruleeditor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConditionDeserializerTest {

    private Gson gson = new GsonBuilder().registerTypeAdapter(BaseCondition.class, new ConditionDeserializer()).create();

    @Test
    public void deserializerTest(){
        Condition condition = new Condition();
        condition.setLeft("map");
        condition.setRight(new ArrayList<>());
        condition.setOperator("test");
        condition.setEmptyIsAssigned(true);
        String input = gson.toJson(condition);
        BaseCondition res = gson.fromJson(input, BaseCondition.class);
        assertEquals(gson.toJson(res), input);
        assertTrue(res instanceof Condition);
    }
}
