package org.onap.sdc.dcae.composition.model.deserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.onap.sdc.dcae.composition.model.Value;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ValueDeserializer implements JsonDeserializer<Value>{

	public Value deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)throws JsonParseException{
    	
		List<String> getPropertyList = new ArrayList<String>();
		
		Value value = new Value();
		
		if(je instanceof JsonObject){
			JsonObject jo = je.getAsJsonObject();
			if(jo.get("get_input")!=null){
				getPropertyList.add(jo.get("get_input").getAsString());
			}
			else if(jo.get("get_property")!=null){
				if(jo.get("get_property") instanceof JsonObject){
					JsonArray jsonArray = jo.getAsJsonArray("get_property");
					Iterator<JsonElement> it = jsonArray.iterator();
					while(it.hasNext()){
						JsonElement item = it.next();
						getPropertyList.add(item.getAsString());
					}
				}
			}
			
		}
        value.setGetProperty(getPropertyList);
        
        return value;
    }
}
