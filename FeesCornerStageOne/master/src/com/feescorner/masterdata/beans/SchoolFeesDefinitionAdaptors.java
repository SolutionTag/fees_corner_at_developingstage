/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Mar 12, 2015                        TODO

 */
package com.feescorner.masterdata.beans;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;

public class SchoolFeesDefinitionAdaptors implements JsonSerializer<SchoolFeesDefinitionAssignment> {
  
  


    @Override
    public JsonElement serialize(SchoolFeesDefinitionAssignment schoolFeesDefinitionAssignment, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("",     schoolFeesDefinitionAssignment.getBaseFeesId());
        jsonObject.addProperty("",      schoolFeesDefinitionAssignment.getCompareId());
        jsonObject.addProperty("",    schoolFeesDefinitionAssignment.getFeesName());
        jsonObject.addProperty("",     schoolFeesDefinitionAssignment.getFeesName());
        //jsonObject.addProperty("",     schoolFeesDefinitionAssignment.getSchoolClassSection());
        jsonObject.addProperty("",     schoolFeesDefinitionAssignment.getTermFrequencyId());
        jsonObject.addProperty("",    schoolFeesDefinitionAssignment.getTermtType());
        jsonObject.addProperty("",       schoolFeesDefinitionAssignment.getTermId());
        jsonObject.addProperty("",       schoolFeesDefinitionAssignment.getVocationalGroupId());
        jsonObject.addProperty("",       schoolFeesDefinitionAssignment.getVocationalGroupName());
        jsonObject.addProperty("",   schoolFeesDefinitionAssignment.getStandrdName());
        jsonObject.addProperty("",   schoolFeesDefinitionAssignment.getSectionName());
        jsonObject.addProperty("",   schoolFeesDefinitionAssignment.getSectionfeesId());
        
        return jsonObject;      
    }
    public String schoolFeesDefinitionToJson(Map<Integer,Map<Integer,Map<Integer, Map<Integer,Set<SchoolFeesDefinitionAssignment>>>>>  messages) {  
      GsonBuilder gsonBuilder = new GsonBuilder();
      Gson gson = gsonBuilder.registerTypeAdapter(SchoolFeesDefinitionAssignment.class, new SchoolFeesDefinitionAdaptors()).create();
      return gson.toJson(messages);
  }   

}
