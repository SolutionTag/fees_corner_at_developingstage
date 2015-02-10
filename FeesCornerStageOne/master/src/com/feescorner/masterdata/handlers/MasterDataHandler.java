/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 6, 2015                        TODO

 */
package com.feescorner.masterdata.handlers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.HibernateException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.UnexpectedRollbackException;

import com.feescorner.masterdata.services.TestVillageService;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.feescorner.serverstartup.serverstartupServlets.GsonExclusionStrategy;
import com.feescorner.serverstartup.serverstartupServlets.JQueryDataTableParamModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.solutiontag.entity.masterdata.SchoolAccountModifierHistory;
import com.solutiontag.entity.masterdata.SchoolClassSectionDefinition;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.entity.masterdata.SchoolFineDefinition;
import com.solutiontag.entity.masterdata.SchoolLeavesDefinition;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.entity.masterdata.SchoolPrepaidFeesDeducationDefinition;
import com.solutiontag.entity.masterdata.SchoolStafPayRollDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardWiseFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolSubsidiaryDefinition;
import com.solutiontag.entity.masterdata.SchoollCollections;
import com.solutiontag.repository.masterdata.SchoolAccountModifierHistoryRepository;
import com.solutiontag.repository.masterdata.SchoolClassSectionDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;
import com.solutiontag.repository.masterdata.SchoolFineDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolLeavesDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolPrepaidFeesDeducationDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStafPayRollDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardWiseFeesDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;
import com.solutiontag.repository.masterdata.SchoolSubjectsDefinitionAssignmentRepository;
import com.solutiontag.repository.masterdata.SchoolSubjectsDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolSubsidiaryDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoollCollectionsRepository;


/*@Transactional(value="getJpaTransactionManager2")
@Service*/

@Component
public class MasterDataHandler {
  private static final Logger log = Logger.getLogger(MasterDataHandler.class);
 
  @Autowired
  public SchoollCollectionsRepository schoolCollectionsRepository;
  @Autowired
  public SchoolCollectionRepository schoolCollectionRepository;
  @Autowired
  public SchoolMasterDataDefinitionRepository masterDataDefinitionRepository;
  @Autowired
  public SchoolAccountModifierHistoryRepository scooAccountModifierHistoryRepository;
  @Autowired
  public SchoolFineDefinitionRepository schoolFineDefinitionRepository;
  @Autowired
  public SchoolLeavesDefinitionRepository schoolLeavesDefinitionRepository;
  @Autowired
  public SchoolSubsidiaryDefinitionRepository schoolSubsidiaryDefinitionRepository;
  @Autowired
  public SchoolStafPayRollDefinitionRepository schoolStafPayRollDefinitionRepository;
  @Autowired
  public SchoolStandardWiseFeesDefinitionRepository definitionRepository;
  @Autowired
  public SchoolPrepaidFeesDeducationDefinitionRepository deducationDefinitionRepository;
  @Autowired
  public SchoolStandardsDefnitionRepository schoolStandardsDefnitionRepository;
  @Autowired
  public SchoolSubjectsDefinitionRepository schoolSubjectsDefinitionRepository;
  @Autowired
  public SchoolClassSectionDefinitionRepository classSectionRepository;
  @Autowired
  public SchoolSubjectsDefinitionAssignmentRepository definitionAssignmentRepository;
  @Autowired 
  public TestVillageService testvillageService;
  
  public MasterDataHandler(){
   
    
  }
 /* public boolean saveSchool(SchoolCollection schoolCreationObject) {
    try {
      if (schoolCreationObject != null) {


      }
    } catch (NullPointerException pointerException) {


    }

    return true;
  }*/

  public SchoolCollection getSchoolObject() {
    SchoolCollection schoolCollectionObject = new SchoolCollection();
   /*Master data childs object creation start*/
    SchoolStandardsDefnition schoolStandardsDefnition =new SchoolStandardsDefnition();
    SchoolSubjectsDefinition schoolSubjectsDefinition =new SchoolSubjectsDefinition();
    SchoolStandardWiseFeesDefinition schoolStandardWiseFeesDefinition=new SchoolStandardWiseFeesDefinition();
    SchoolFineDefinition schoolFineDefinition=new SchoolFineDefinition();
    SchoolPrepaidFeesDeducationDefinition schoolPrepaidFeesDeducationDefinition=new SchoolPrepaidFeesDeducationDefinition();
    SchoolSubsidiaryDefinition schoolSubsidiaryDefinition=new SchoolSubsidiaryDefinition();
    SchoolLeavesDefinition schoolLeavesDefinition =new SchoolLeavesDefinition();
    SchoolStafPayRollDefinition schoolStafPayRollDefinition=new SchoolStafPayRollDefinition();
    /*Master data childs object creation end*/
    /*School child data object creation*/
    SchoolAccountModifierHistory schoolAccountModifierHistory=new SchoolAccountModifierHistory();
    SchoolMasterDataDefinition schoolMasterDataDefnObject =new SchoolMasterDataDefinition();
    /*School child data object end*/
    /*Master Data child Set(util.set) objects*/    
    Set<SchoolStandardsDefnition> schoolStandardsDefnitionSet=new HashSet<SchoolStandardsDefnition>();
    Set<SchoolSubjectsDefinition> schoolSubjectsDefinitionSet=new HashSet<SchoolSubjectsDefinition>();
    Set<SchoolStandardWiseFeesDefinition> schoolStandardWiseFeesDefinitionSet=new HashSet<SchoolStandardWiseFeesDefinition>();
    Set<SchoolFineDefinition> schoolFineDefinitionSet=new HashSet<SchoolFineDefinition>();
    Set<SchoolPrepaidFeesDeducationDefinition> schoolPrepaidFeesDeducationDefinitionSet=new HashSet<SchoolPrepaidFeesDeducationDefinition>();
    Set<SchoolSubsidiaryDefinition> schoolSubsidiaryDefinitionSet=new HashSet<SchoolSubsidiaryDefinition>();
    Set<SchoolLeavesDefinition> schoolLeavesDefinitionSet=new HashSet<SchoolLeavesDefinition>();
    Set<SchoolStafPayRollDefinition> schoolStafPayRollDefinitionSet=new HashSet<SchoolStafPayRollDefinition>();
    schoolStandardsDefnitionSet.add(schoolStandardsDefnition);
    schoolSubjectsDefinitionSet.add(schoolSubjectsDefinition);
    schoolStandardWiseFeesDefinitionSet.add(schoolStandardWiseFeesDefinition);
    schoolFineDefinitionSet.add(schoolFineDefinition);
    schoolPrepaidFeesDeducationDefinitionSet.add(schoolPrepaidFeesDeducationDefinition);
    schoolSubsidiaryDefinitionSet.add(schoolSubsidiaryDefinition);
    schoolLeavesDefinitionSet.add(schoolLeavesDefinition);
    schoolStafPayRollDefinitionSet.add(schoolStafPayRollDefinition);
    /*Master Data child Set(util.set) and Add objects*/ 
    
   /*School Data child Set and add*/
    Set<SchoolAccountModifierHistory> schoolAccountModifierHistorySet=new HashSet<SchoolAccountModifierHistory>();
    schoolAccountModifierHistorySet.add(schoolAccountModifierHistory);
    /*School Data child Set and add*/
    /*setting of Master data object to childs*/
    schoolStandardsDefnition.setDefForStandard(schoolMasterDataDefnObject);
    schoolSubjectsDefinition.setDefForSubject(schoolMasterDataDefnObject);
   // schoolStandardWiseFeesDefinition.setDefForStdwiseFees(schoolMasterDataDefnObject);
    schoolFineDefinition.setDefForFine(schoolMasterDataDefnObject);
    schoolPrepaidFeesDeducationDefinition.setDefForPrepaidFees(schoolMasterDataDefnObject);
    schoolSubsidiaryDefinition.setDefForSubsidiary(schoolMasterDataDefnObject);
    schoolLeavesDefinition.setDefForLeave(schoolMasterDataDefnObject);
    schoolStafPayRollDefinition.setDefForStaffPays(schoolMasterDataDefnObject);
    /*setting of child  objects to Master data*/
    schoolMasterDataDefnObject.setSchoolFineDefinition(schoolFineDefinitionSet);
    schoolMasterDataDefnObject.setSchoolLeavesDefinition(schoolLeavesDefinitionSet);
    schoolMasterDataDefnObject.setSchoolSubsidiaryDefinition(schoolSubsidiaryDefinitionSet);
    schoolMasterDataDefnObject.setSchoolStafPayRollDefinition(schoolStafPayRollDefinitionSet);
   // schoolMasterDataDefnObject.setSchoolStandardWiseFeesDefinition(schoolStandardWiseFeesDefinitionSet);
    schoolMasterDataDefnObject.setSchoolPrepaidFeesDeducationDefinition(schoolPrepaidFeesDeducationDefinitionSet);
    schoolMasterDataDefnObject.setSchoolStandardsDefnition(schoolStandardsDefnitionSet);
    schoolMasterDataDefnObject.setSchoolSubjectsDefinition(schoolSubjectsDefinitionSet);
   
    /*setting of schoolcollection object to them dependencies*/
    schoolMasterDataDefnObject.setSchoolCollection(schoolCollectionObject);
    schoolAccountModifierHistory.setSchoolCollection(schoolCollectionObject);
    
    schoolCollectionObject.setSchoolMasterData(schoolMasterDataDefnObject);
    schoolCollectionObject.setSchoolAccountModifierHistory(schoolAccountModifierHistorySet);
    
    return schoolCollectionObject;
  }
  
  public boolean saveSchool(SchoolCollection schoolCollection)
  {
    try{
    ApplicationUtills.checkNotNull(schoolCollection);
    SchoollCollections schoolCollections=new SchoollCollections();
    SchoolMasterDataDefinition schoolMasterData=schoolCollection.getSchoolMasterData();
    masterDataDefinitionRepository.save(schoolMasterData);
    schoolCollection.setSchoolCollections(schoolCollections);
    schoolCollections.getSchoolCollectionSet().add(schoolCollection);
    schoolCollectionsRepository.save(schoolCollections);
   
    return true;
    }
    catch(UnexpectedRollbackException unexpectedRollbckException){
      if(unexpectedRollbckException.getMostSpecificCause() instanceof SQLIntegrityConstraintViolationException)
      {
        log.debug(unexpectedRollbckException,unexpectedRollbckException.fillInStackTrace());
      }      
      return false;
  }
    catch(HibernateException hibernateException){
      System.out.println("Does not saved school ,Exception occured.Please check log for futher..");
      log.debug(hibernateException,hibernateException.fillInStackTrace());
      return false;
    }
    catch(NullPointerException nullPointerException){
      log.debug(nullPointerException,nullPointerException.fillInStackTrace());
      System.out.println("Does not saved school ,Exception occured.Please check log for futher..");
      return false;
    }
  }
  public boolean saveStandardDefintion(SchoolMasterDataDefinition schoolMasterDataDefinitionformObject)throws Exception
  {
    Set<SchoolStandardsDefnition> stddbObject= new HashSet<SchoolStandardsDefnition>(schoolMasterDataDefinitionformObject.getSchoolStandardsDefnition()) ;
     Iterator< SchoolStandardsDefnition>  iterator=stddbObject.iterator();
     while(iterator.hasNext()){
       SchoolStandardsDefnition stdLocalObj= iterator.next();
       int standardId=stdLocalObj.getStandardId();
       SchoolStandardsDefnition stdDbObj  =schoolStandardsDefnitionRepository.findOne(standardId);
       stdDbObj.setStatusForChecked(stdLocalObj.isStatusForChecked());
      // schoolStandardsDefnitionRepository.save(stdDbObj);
       schoolStandardsDefnitionRepository.saveAndFlush(stdDbObj);
     }
   
    return true;
  }
  
  public SchoolCollection getSchoolCollectionObject(){
    SchoolCollection  schoolCollection=schoolCollectionRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY37623");
    return schoolCollection;
  }

  public SchoolSubjectsDefinition saveSubject(SchoolSubjectsDefinition schoolSubDef){
   // Set<SchoolSubjectsDefinition> subDefSet=new HashSet<SchoolSubjectsDefinition>();
    SchoolMasterDataDefinition  masterDataObj=masterDataDefinitionRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY21675");
    masterDataObj.getSchoolSubjectsDefinition().add(schoolSubDef);
    //masterDataObj.setSchoolSubjectsDefinition(subDefSet);
    schoolSubDef.setDefForSubject(masterDataObj);
    masterDataDefinitionRepository.saveAndFlush(masterDataObj);
    //schoolSubjectsDefinitionRepository.save(schoolSubDef);
    return schoolSubDef;
  }
  
  public boolean deleteSection(Integer standardIndexId,Integer sectionIndexId){
     SchoolStandardsDefnition standardDef= schoolStandardsDefnitionRepository.findOne(standardIndexId);
     Set<SchoolClassSectionDefinition> dbSectionSet=standardDef.getSectionSet();
     List<SchoolClassSectionDefinition> classSectionList= new ArrayList<SchoolClassSectionDefinition>(dbSectionSet);
     dbSectionSet.clear();
     SchoolClassSectionDefinition classSecObj=new SchoolClassSectionDefinition();
     classSecObj.setCompareId(sectionIndexId);
     int index=classSectionList.indexOf(classSecObj);
     classSectionList.remove(index);
     dbSectionSet=new HashSet<SchoolClassSectionDefinition>(classSectionList);
    standardDef.setSectionSet(dbSectionSet);
      schoolStandardsDefnitionRepository.saveAndFlush(standardDef);
     
  return true;
 
    
  }
 public boolean saveSection(String wrappedSectionData) throws JsonParseException, JsonMappingException, IOException{
   ApplicationUtills appUtills=new ApplicationUtills();
   ApplicationUtills.getSchoolCollectionObject();
   SchoolClassSectionDefinition schoolClsSectionDef=null;
   System.out.println(wrappedSectionData);
   JSONObject wrapperData=new JSONObject(wrappedSectionData);
   Iterator keys = wrapperData.keys();
  while(keys.hasNext()){
     String stringJsonHashId= (String) keys.next();
     Integer standardid=Integer.parseInt(stringJsonHashId);
     SchoolStandardsDefnition stdDefDbObj=schoolStandardsDefnitionRepository.findOne(standardid);
     if(stdDefDbObj!=null){
      JSONArray sectionArray= wrapperData.getJSONArray(standardid.toString());
      Set<SchoolClassSectionDefinition> localSectionSet=stdDefDbObj.getSectionSet();
      List<SchoolClassSectionDefinition> schoolSectionList=new ArrayList<SchoolClassSectionDefinition>(stdDefDbObj.getSectionSet());
      //Existing One
      if(sectionArray.length()!=0 && schoolSectionList.size()!=0){
        int arrayLength=sectionArray.length();
        for(int k=0;k<arrayLength ;k++){
          JSONObject object= (JSONObject) sectionArray.get(k);
          System.out.println(object);
        //  SchoolClassSectionDefinition schoolClsSectionDef=new SchoolClassSectionDefinition();
          schoolClsSectionDef=new SchoolClassSectionDefinition();
         if( object.has("indexId")){
           schoolClsSectionDef.setCompareId(object.getInt("indexId"));
           int index=schoolSectionList.indexOf(schoolClsSectionDef);
           if(index!=-1){
             schoolClsSectionDef=schoolSectionList.get(index);
             schoolClsSectionDef.setMaximumStudents(object.getInt("maximumStudents"));
             schoolClsSectionDef.setSectionName(object.getString("sectionName"));
          //   dbSection.add(index,schoolClsSectionDef);
          }
         }else{
           schoolClsSectionDef=(SchoolClassSectionDefinition) appUtills.getBeanFromJsonObject(object.toString(), SchoolClassSectionDefinition.class);
           schoolClsSectionDef.setSchoolStandardsDefnition(stdDefDbObj);
           schoolSectionList.add(schoolClsSectionDef);
         }
        }
        //stdDefDbObj.setSection(schoolSectionList);
        Set<SchoolClassSectionDefinition> sectionSet=new HashSet<SchoolClassSectionDefinition>(schoolSectionList);
        stdDefDbObj.setSectionSet(sectionSet);
        schoolStandardsDefnitionRepository.saveAndFlush(stdDefDbObj);
        //schoolSectionList=new ArrayList<SchoolClassSectionDefinition>(); 
        //schoolClsSectionDef=null;
      }
      //initially creating sections
      else{
        if(sectionArray.length()!=0){
      for(int k=0;k< sectionArray.length();k++){
        JSONObject object= (JSONObject) sectionArray.get(k);
        System.out.println(object);
         schoolClsSectionDef=(SchoolClassSectionDefinition) appUtills.getBeanFromJsonObject(object.toString(), SchoolClassSectionDefinition.class);
         schoolClsSectionDef.setSchoolStandardsDefnition(stdDefDbObj);
         localSectionSet.add(schoolClsSectionDef);
        // schoolClsSectionDef=null;
      }
     // stdDefDbObj.setSection(schoolSectionList);
     // Set<SchoolClassSectionDefinition> sectionSet=new HashSet<SchoolClassSectionDefinition>(localSectionArrayList);
      //stdDefDbObj.setSectionSet(localSectionSet);
      schoolStandardsDefnitionRepository.saveAndFlush(stdDefDbObj);
      //schoolSectionList=new ArrayList<SchoolClassSectionDefinition>(); 
      //stdDefDbObj=null;
        }
      
    }
     }
   }
   wrapperData.length();
   return true;
 }
 
 public JsonArray getSectionDataForTable(String masterDataId){
   JsonArray jsonArray = new JsonArray();
   //SchoolMasterDataDefinition masterData= masterDataDefinitionRepository.findOne(masterDataId);
   // System.out.println(masterData);
    Set<SchoolSubjectsDefinition> schoolSubjectDefSet=masterDataDefinitionRepository.findOne(masterDataId).getSchoolSubjectsDefinition();
    /*Gson gson = new Gson();
    JsonElement element = gson.toJsonTree(schoolSubjectDefSet, new TypeToken<Set<SchoolSubjectsDefinition>>() {}.getType());
    if (! element.isJsonArray()) {
       throw new IllegalAccessError();
   }
    JsonArray jsonArray = element.getAsJsonArray();
    StringBuffer jsonBuffer = new StringBuffer("{ \"rows\": [");*/
   // Set<SchoolSubjectsDefinition> schoolSubjectDefSet=masterDataDefinitionRepository.findOne(masterDataId).getSchoolSubjectsDefinition();
    // assume you have more elements in above arraylist
    StringBuffer jsonBuffer = new StringBuffer("{ \"rows\": [");
    boolean first = true;
    for (SchoolSubjectsDefinition subjectDefObj : schoolSubjectDefSet) {
           if (first)
          first = false;
        else
          jsonBuffer.append(",");
          jsonBuffer.append(getJsonFromMetric(subjectDefObj));
    }
    jsonBuffer.append("]}");
    
    
    
   return jsonArray;
 }
 private String getJsonFromMetric(SchoolSubjectsDefinition subjectDef) {
   GsonBuilder gsonBuilder = new GsonBuilder();
       gsonBuilder.serializeNulls();
       Gson gson = gsonBuilder.create();
       return gson.toJson(subjectDef);
   }
 
 public String getSectionTable(JQueryDataTableParamModel jqueryData,String masterDataId){
  JSONArray jsonArray=new JSONArray();
  Set<SchoolSubjectsDefinition> schoolSubjectDefSet=masterDataDefinitionRepository.findOne(masterDataId).getSchoolSubjectsDefinition();
 
  Iterator iterator=schoolSubjectDefSet.iterator();
 while(iterator.hasNext()){
   Gson gsonObj= ApplicationUtills.createGsonFromBuilder(new GsonExclusionStrategy(Date.class) );
   SchoolSubjectsDefinition schoolSubjectDef= (SchoolSubjectsDefinition) iterator.next();
   jsonArray.put(gsonObj.toJson(schoolSubjectDef));
   System.out.println();
 }
 jqueryData.setAoData(jsonArray.toString());
 new JSONArray(jsonArray.toString());
 Gson gsonObj2= ApplicationUtills.createGsonFromBuilder(new GsonExclusionStrategy(Date.class) );
 System.out.println(gsonObj2.toJson(jqueryData));
   return gsonObj2.toJson(jqueryData);
 
 }
public boolean subjectAssignmentHandler(Integer standardId,JSONObject sectionSubjectJson){
  Iterator iterator= sectionSubjectJson.keySet().iterator();
 // HashSet<SchoolSubjectsDefinitionAssignment> subjectDefSet=null;
     SchoolSubjectsDefinition freshSubjectDef=null;
     SchoolSubjectsDefinitionAssignment subjectAssignment=null;
     List<SchoolSubjectsDefinition> schoolsubjectDefList= schoolSubjectsDefinitionRepository.findAll();
   while(iterator.hasNext()){
      freshSubjectDef =new SchoolSubjectsDefinition();
     String key= (String) iterator.next();
     Integer sectionId=Integer.parseInt(key);
     SchoolClassSectionDefinition classSectionDef= classSectionRepository.findOne(sectionId);
     JSONArray subjectArray= (JSONArray) sectionSubjectJson.get(key);
    // subjectDefSet =new HashSet<SchoolSubjectsDefinitionAssignment>();
        for(int s=0;s<subjectArray.length();s++){
          subjectAssignment=new SchoolSubjectsDefinitionAssignment();
          System.out.println(subjectArray.get(s));
          Integer subjectId=(Integer) subjectArray.get(s);
          freshSubjectDef.setCompareId(subjectId);
           int index=schoolsubjectDefList.indexOf(freshSubjectDef);
           freshSubjectDef= schoolsubjectDefList.get(index);
           if(index!=-1){
             subjectAssignment.setSubjectName(freshSubjectDef.getSubjectName());
             subjectAssignment.setSubjectPreferreStd(freshSubjectDef.getSubjectPreferreStd());
             subjectAssignment.setStandardId(standardId);
             subjectAssignment.setBaseSubjectId(freshSubjectDef.getSubjectId());
             subjectAssignment.setSchoolClassSection(classSectionDef);
            SchoolSubjectsDefinitionAssignment duplicateSubjectAssignmentObj=definitionAssignmentRepository.findExist(standardId,freshSubjectDef.getSubjectId() ,classSectionDef.getSectionId());
             if(duplicateSubjectAssignmentObj==null){
              // subjectDefSet.add(subjectAssignment);
               classSectionDef.getSchoolSubjectAssignmentSet().add(subjectAssignment);
             }
            
           }
           freshSubjectDef=new SchoolSubjectsDefinition();
        }
      //  classSectionDef.setSchoolSubjectAssignmentSet(subjectDefSet);
        classSectionRepository.saveAndFlush(classSectionDef);
       System.out.println(sectionId);
  }
   return true;
 }

}
