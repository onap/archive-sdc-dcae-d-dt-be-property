package org.onap.sdc.dcae.composition.model.deserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.onap.sdc.dcae.composition.model.Capability;
import org.onap.sdc.dcae.composition.model.NodeFilter;
import org.onap.sdc.dcae.composition.model.Relationship;
import org.onap.sdc.dcae.composition.model.Requirement;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class RequirementDeserializer implements JsonDeserializer<Requirement>{

	public Requirement deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)throws JsonParseException{
    	Gson gson = new Gson();
    	
        JsonObject jo = je.getAsJsonObject();
        
        Requirement requirement = new Requirement();

        requirement.setCapability(jo.get("capability")!=null ? gson.fromJson(jo.get("capability"), Capability.class) : null);
        requirement.setName(jo.get("name")!=null ? jo.get("name").getAsString() : null);
        requirement.setRelationship(jo.get("relationship")!=null ? gson.fromJson(jo.get("relationship"), Relationship.class) : null);
        requirement.setNodeFilter(jo.get("node_filter")!=null ? gson.fromJson(jo.get("node_filter"), NodeFilter.class) : null);
        requirement.setNode(jo.get("node")!=null ? jo.get("node").getAsString() : null);
        
        JsonArray occurrences = jo.getAsJsonArray("occurrences");
        if(occurrences!=null){
	        Iterator<JsonElement> it = occurrences.iterator();
	        List<String> occurrencesList = new ArrayList<String>();
	        while(it.hasNext()){
	        	JsonElement curr = it.next();
	        	String occurance = curr.getAsString();
	        	occurrencesList.add(occurance);
	        }
	        requirement.setOccurrences(occurrencesList);
        }
        
        return requirement;
    }
}
