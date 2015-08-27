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
import java.util.Collections;
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
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
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
import com.solutiontag.entity.masterdata.SchoolTermDefinition;
import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinition;
import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoollCollections;
import com.solutiontag.entity.masterdata.TermFrequency;
import com.solutiontag.repository.masterdata.SchoolAccountModifierHistoryRepository;
import com.solutiontag.repository.masterdata.SchoolClassSectionDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionAssignmentRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionRepository;
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
import com.solutiontag.repository.masterdata.SchoolTermDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolVocationalGroupDefinitionAssignmentRepository;
import com.solutiontag.repository.masterdata.SchoolVocationalGroupDefinitionRepository;
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
  @Autowired
  public SchoolFeesDefinitionRepository feesDefintionRepository;
  @Autowired
  public SchoolVocationalGroupDefinitionRepository schoolVocationalGroupRep;
  @Autowired
  public SchoolVocationalGroupDefinitionAssignmentRepository vocationalGroupAssignmentRepo;
  @Autowired
  public SchoolTermDefinitionRepository schoolTermDefRepo;
  @Autowired
  public SchoolFeesDefinitionAssignmentRepository feesDefinitionAssignmentRepository;
  
  
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
  public boolean saveStandardDefintion( List<SchoolStandardsDefnition> stddbObjectList,SchoolMasterDataDefinition masterDataObj )throws Exception
  {
    List<SchoolStandardsDefnition> stdDefList=new ArrayList<SchoolStandardsDefnition>( masterDataObj.getSchoolStandardsDefnition());
    Set<SchoolStandardsDefnition> stddbObjectSet= new HashSet<SchoolStandardsDefnition>(stddbObjectList) ;
    Iterator< SchoolStandardsDefnition>  iterator=stddbObjectSet.iterator();
    while(iterator.hasNext()){
      SchoolStandardsDefnition stdLocalObj= iterator.next();
      int index= stdDefList.indexOf(stdLocalObj);
      System.err.println("checked "+stdLocalObj.isStatusForChecked()+"standard name "+stdLocalObj.getStandardName());
       stdDefList.get(index).setStatusForChecked(stdLocalObj.isStatusForChecked());
    }
    masterDataDefinitionRepository.saveAndFlush(masterDataObj);
    /*Set<SchoolStandardsDefnition> stddbObjectSet= new HashSet<SchoolStandardsDefnition>(stddbObjectList) ;
     Iterator< SchoolStandardsDefnition>  iterator=stddbObjectSet.iterator();
     while(iterator.hasNext()){
       SchoolStandardsDefnition stdLocalObj= iterator.next();
       int standardId=stdLocalObj.getStandardId();
       SchoolStandardsDefnition stdDbObj  =schoolStandardsDefnitionRepository.findOne(standardId);
       stdDbObj.setStatusForChecked(stdLocalObj.isStatusForChecked());
      // schoolStandardsDefnitionRepository.save(stdDbObj);
       schoolStandardsDefnitionRepository.saveAndFlush(stdDbObj);
     }
   
    return true;*/
    return true;
  }
  
  public SchoolCollection getSchoolCollectionObject(){
    SchoolCollection  schoolCollection=schoolCollectionRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    return schoolCollection;
  }

  public SchoolSubjectsDefinition saveSubject(SchoolSubjectsDefinition schoolSubDef){
   // Set<SchoolSubjectsDefinition> subDefSet=new HashSet<SchoolSubjectsDefinition>();
    SchoolMasterDataDefinition  masterDataObj=masterDataDefinitionRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    masterDataObj.getSchoolSubjectsDefinition().add(schoolSubDef);
    //masterDataObj.setSchoolSubjectsDefinition(subDefSet);
    schoolSubDef.setDefForSubject(masterDataObj);
    masterDataDefinitionRepository.saveAndFlush(masterDataObj);
    //schoolSubjectsDefinitionRepository.save(schoolSubDef);
    return schoolSubDef;
  }
  
  public boolean deleteSection(Integer standardIndexId,Integer sectionIndexId,Integer groupcompareId){
     SchoolStandardsDefnition standardDef= schoolStandardsDefnitionRepository.findOne(standardIndexId);
     if(standardDef.isGroupassigned()!=true){
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
     }else{
       Set<SchoolClassSectionDefinition> dbSectionSet=new HashSet<SchoolClassSectionDefinition>();
       List<SchoolVocationalGroupDefinitionAssignment> groupAssignementList=new ArrayList<SchoolVocationalGroupDefinitionAssignment>(standardDef.getGroupSet()); 
       SchoolVocationalGroupDefinitionAssignment freshGroupAssignmentObj=new SchoolVocationalGroupDefinitionAssignment();
       freshGroupAssignmentObj.setCompareId(groupcompareId);
       int position= groupAssignementList.indexOf(freshGroupAssignmentObj);
       freshGroupAssignmentObj= groupAssignementList.get(position);
        dbSectionSet=freshGroupAssignmentObj.getSectionSet();
        
       List<SchoolClassSectionDefinition> classSectionList= new ArrayList<SchoolClassSectionDefinition>(dbSectionSet);
       dbSectionSet.clear();
       SchoolClassSectionDefinition classSecObj=new SchoolClassSectionDefinition();
       classSecObj.setCompareId(sectionIndexId);
       int index=classSectionList.indexOf(classSecObj);
       classSectionList.remove(index);
       dbSectionSet=new HashSet<SchoolClassSectionDefinition>(classSectionList);
       freshGroupAssignmentObj.setSectionSet(dbSectionSet);
       vocationalGroupAssignmentRepo.saveAndFlush(freshGroupAssignmentObj);
     }
    
     
     
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
     if(stdDefDbObj!=null && !stdDefDbObj.isGroupassigned()){
      
      JSONArray sectionArray= wrapperData.getJSONArray(standardid.toString());
      Set<SchoolClassSectionDefinition> localSectionSet=stdDefDbObj.getSectionSet();
      List<SchoolClassSectionDefinition> schoolSectionList=new ArrayList<SchoolClassSectionDefinition>(stdDefDbObj.getSectionSet());
      //Existing One
      if(sectionArray.length()!=0 && schoolSectionList.size()!=0){
        int arrayLength=sectionArray.length();
        for(int k=0;k<arrayLength ;k++){
          JSONObject object= (JSONObject) sectionArray.get(k);
          System.out.println(object);
          schoolClsSectionDef=new SchoolClassSectionDefinition();
         if( object.has("compareId") && object.get("compareId")!="0"){
           schoolClsSectionDef.setCompareId(object.getInt("compareId"));
           int index=schoolSectionList.indexOf(schoolClsSectionDef);
           if(index!=-1){
             schoolClsSectionDef=schoolSectionList.get(index);
             schoolClsSectionDef.setMaximumStudents(object.getInt("maximumStudents"));
             schoolClsSectionDef.setSectionName(object.getString("sectionName"));
          }
         }else{
           schoolClsSectionDef=(SchoolClassSectionDefinition) appUtills.getBeanFromJsonObject(object.toString(), SchoolClassSectionDefinition.class);
           schoolClsSectionDef.setSchoolStandardsDefnition(stdDefDbObj);
           schoolSectionList.add(schoolClsSectionDef);
         }
        }
        Set<SchoolClassSectionDefinition> sectionSet=new HashSet<SchoolClassSectionDefinition>(schoolSectionList);
        stdDefDbObj.setSectionSet(sectionSet);
       schoolStandardsDefnitionRepository.saveAndFlush(stdDefDbObj);
      }
      //initially creating sections
      else{
        if(sectionArray.length()!=0)
        {
            for(int k=0;k< sectionArray.length();k++)
            {
              JSONObject object= (JSONObject) sectionArray.get(k);
              System.out.println(object);
               schoolClsSectionDef=(SchoolClassSectionDefinition) appUtills.getBeanFromJsonObject(object.toString(), SchoolClassSectionDefinition.class);
               schoolClsSectionDef.setSchoolStandardsDefnition(stdDefDbObj);
               localSectionSet.add(schoolClsSectionDef);
            }
            schoolStandardsDefnitionRepository.saveAndFlush(stdDefDbObj);
        }
    }
     }
     //Group oriented standard sections 
     else{
       SchoolClassSectionDefinition groupSchoolClsSectionDef=null;
       SchoolVocationalGroupDefinitionAssignment freshVocationObject=null;
        List <SchoolVocationalGroupDefinitionAssignment> vocationGroupAssignmentList= new ArrayList<SchoolVocationalGroupDefinitionAssignment>(stdDefDbObj.getGroupSet());
       JSONObject vocationalgroupjson= (JSONObject) wrapperData.get(standardid.toString());
        Iterator<String> keyiterator=vocationalgroupjson.keys();
        while(keyiterator.hasNext()){
        String key   =keyiterator.next();
        freshVocationObject=new SchoolVocationalGroupDefinitionAssignment();
        freshVocationObject.setCompareId(  Integer.parseInt(key));
        int result=  vocationGroupAssignmentList.indexOf(freshVocationObject);
        freshVocationObject=  vocationGroupAssignmentList.get(result);
        JSONArray sectionArray= vocationalgroupjson.getJSONArray(key);
        List<SchoolClassSectionDefinition> vocationalGroupSectionList=new ArrayList<SchoolClassSectionDefinition>(freshVocationObject.getSectionSet());
        if(sectionArray.length()!=0 && vocationalGroupSectionList.size()!=0){
          int arrayLength=sectionArray.length();
          for(int k=0;k<arrayLength ;k++){
            JSONObject object= (JSONObject) sectionArray.get(k);
            System.out.println(object);
            groupSchoolClsSectionDef=new SchoolClassSectionDefinition();
           if( object.has("compareId") && object.get("compareId")!="0"){
             groupSchoolClsSectionDef.setCompareId(object.getInt("compareId"));
             int index=vocationalGroupSectionList.indexOf(groupSchoolClsSectionDef);
             if(index!=-1){
               groupSchoolClsSectionDef=vocationalGroupSectionList.get(index);
               groupSchoolClsSectionDef.setMaximumStudents(object.getInt("maximumStudents"));
               groupSchoolClsSectionDef.setSectionName(object.getString("sectionName"));
            }
           }else{
             groupSchoolClsSectionDef=(SchoolClassSectionDefinition) appUtills.getBeanFromJsonObject(object.toString(), SchoolClassSectionDefinition.class);
             groupSchoolClsSectionDef.setSchoolVocationalGroup(freshVocationObject);
             vocationalGroupSectionList.add(groupSchoolClsSectionDef);
           }
          }
          Set<SchoolClassSectionDefinition> sectionSet=new HashSet<SchoolClassSectionDefinition>(vocationalGroupSectionList);
          freshVocationObject.setSectionSet(sectionSet);
          vocationalGroupAssignmentRepo.saveAndFlush(freshVocationObject);
          } 
        else {
            if (sectionArray.length() != 0)
            {
              int size = sectionArray.length();
              for (int j = 0; j < size; j++) 
              {
                groupSchoolClsSectionDef = (SchoolClassSectionDefinition) appUtills.getBeanFromJsonObject(sectionArray.get(j).toString(), SchoolClassSectionDefinition.class);
                groupSchoolClsSectionDef.setSchoolVocationalGroup(freshVocationObject);
                freshVocationObject.getSectionSet().add(groupSchoolClsSectionDef);
              }
              vocationalGroupAssignmentRepo.saveAndFlush(freshVocationObject);
            }
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
public boolean nonGroupSubjectAssignmentHandler(Integer standardId,JSONObject sectionSubjectJson ){
  Iterator iterator= sectionSubjectJson.keySet().iterator();
  HashSet<SchoolSubjectsDefinitionAssignment> subjectDefSet=null;
     SchoolSubjectsDefinition freshSubjectDef=null;
     SchoolSubjectsDefinitionAssignment subjectAssignment=null;
     SchoolStandardsDefnition stdDef= schoolStandardsDefnitionRepository.findOne(standardId);
     List<SchoolClassSectionDefinition> schoolClassSectionDefList=new ArrayList<SchoolClassSectionDefinition>(stdDef.getSectionSet());
     List<SchoolSubjectsDefinition> schoolsubjectDefList= schoolSubjectsDefinitionRepository.findAll();
   while(iterator.hasNext()){
     String key= (String) iterator.next();
      freshSubjectDef =new SchoolSubjectsDefinition();
     Integer sectionId=Integer.parseInt(key);
     SchoolClassSectionDefinition classSectionDef=new SchoolClassSectionDefinition();
     classSectionDef.setCompareId(sectionId);
     int  index=schoolClassSectionDefList.indexOf(classSectionDef);
     classSectionDef=  schoolClassSectionDefList.get(index);
    /* if(classSectionDef.getSchoolSubjectAssignmentSet().size()!=0){
        classSectionDef.getSchoolSubjectAssignmentSet().clear();
       // classSectionDef.getSchoolSubjectAssignmentSet().add(subjectAssignment);
     }*/
     
     JSONArray subjectArray= (JSONArray) sectionSubjectJson.get(key);
     subjectDefSet =new HashSet<SchoolSubjectsDefinitionAssignment>();
        for(int s=0;s<subjectArray.length();s++){
          
          subjectAssignment=new SchoolSubjectsDefinitionAssignment();
          
          System.out.println(subjectArray.get(s));
          Integer subjectId=(Integer) subjectArray.get(s);
          freshSubjectDef.setCompareId(subjectId);
           int position=schoolsubjectDefList.indexOf(freshSubjectDef);
           freshSubjectDef= schoolsubjectDefList.get(position);
           if(index!=-1){
             subjectAssignment.setSubjectName(freshSubjectDef.getSubjectName());
             subjectAssignment.setSubjectPreferreStd(freshSubjectDef.getSubjectPreferreStd());
             subjectAssignment.setStandardId(standardId);
             subjectAssignment.setBaseSubjectId(freshSubjectDef.getCompareId());
             subjectAssignment.setSchoolClassSection(classSectionDef);
             
             //Set<SchoolSubjectsDefinitionAssignment> existingSubjectInSections= definitionAssignmentRepository.returnSectionSubjectSet(standardId, classSectionDef.getSectionId());
             //System.out.println(existingSubjectInSections.size());
             SchoolSubjectsDefinitionAssignment duplicateSubjectAssignmentObj=definitionAssignmentRepository.findExist(standardId,freshSubjectDef.getCompareId() ,classSectionDef.getCompareId());
             if(duplicateSubjectAssignmentObj==null){
               //subjectDefSet.add(subjectAssignment);
               classSectionDef.getSchoolSubjectAssignmentSet().add(subjectAssignment);
             }
            
           }
           freshSubjectDef=new SchoolSubjectsDefinition();
        }
      // classSectionDef.setSchoolSubjectAssignmentSet(subjectDefSet);
        classSectionRepository.saveAndFlush(classSectionDef);
       System.out.println(sectionId);
  }
   return true;
 }

public boolean groupSubjectAssignmentHandler(Integer groupCompareId,Integer standardId,JSONObject sectionSubjectJson){
  SchoolSubjectsDefinition  freshSubjectDef=null;
  SchoolClassSectionDefinition freshSectionObj=null;
  SchoolSubjectsDefinitionAssignment subjectAssignment=null;
  List<SchoolSubjectsDefinition> schoolsubjectDefList= schoolSubjectsDefinitionRepository.findAll();
  SchoolStandardsDefnition stdDef= schoolStandardsDefnitionRepository.findOne(standardId);
   List<SchoolVocationalGroupDefinitionAssignment> vocationGroupAssignmentList=new ArrayList<SchoolVocationalGroupDefinitionAssignment>(stdDef.getGroupSet());
   SchoolVocationalGroupDefinitionAssignment schoolVocationGroupObj=new SchoolVocationalGroupDefinitionAssignment();
   schoolVocationGroupObj.setCompareId(groupCompareId);
    int position=vocationGroupAssignmentList.indexOf(schoolVocationGroupObj);
    schoolVocationGroupObj= vocationGroupAssignmentList.get(position);
    List<SchoolClassSectionDefinition> schoolClassSectionDefList=new ArrayList<SchoolClassSectionDefinition>( schoolVocationGroupObj.getSectionSet());
    Iterator iterator= sectionSubjectJson.keySet().iterator();
    while(iterator.hasNext()){
       String key= (String) iterator.next();
       freshSubjectDef =new SchoolSubjectsDefinition();
       freshSectionObj=new SchoolClassSectionDefinition();
       Integer sectionId=Integer.parseInt(key);
       freshSectionObj.setCompareId(sectionId);
       int index= schoolClassSectionDefList.indexOf(freshSectionObj);
       freshSectionObj=  schoolClassSectionDefList.get(index);
      /* if(freshSectionObj.getSchoolSubjectAssignmentSet().size()!=0){
         freshSectionObj.getSchoolSubjectAssignmentSet().clear();
       }*/
       JSONArray assignedSubjectArray= sectionSubjectJson.getJSONArray(key);
       int length= assignedSubjectArray.length();
       for(int j=0;j<length;j++){
         subjectAssignment=new SchoolSubjectsDefinitionAssignment();
          Integer subjectId=(Integer) assignedSubjectArray.get(j);
          freshSubjectDef.setCompareId(subjectId);
          int result= schoolsubjectDefList.indexOf(freshSubjectDef);
          if(result!=-1){
            freshSubjectDef= schoolsubjectDefList.get(result);
            
            subjectAssignment.setSubjectName(freshSubjectDef.getSubjectName());
            subjectAssignment.setSubjectPreferreStd(freshSubjectDef.getSubjectPreferreStd());
            subjectAssignment.setStandardId(groupCompareId);
            subjectAssignment.setBaseSubjectId(freshSubjectDef.getCompareId());
            subjectAssignment.setSchoolClassSection(freshSectionObj);
            
            SchoolSubjectsDefinitionAssignment duplicateSubjectAssignmentObj=definitionAssignmentRepository.findExist(groupCompareId,freshSubjectDef.getCompareId() ,freshSectionObj.getCompareId());
            if(duplicateSubjectAssignmentObj==null){
              freshSectionObj.getSchoolSubjectAssignmentSet().add(subjectAssignment);
            }
           
          }
          freshSubjectDef=new SchoolSubjectsDefinition();
       }
       classSectionRepository.saveAndFlush(freshSectionObj);
    }
   // schoolStandardsDefnitionRepository.saveAndFlush(stdDef);
  return true;
}

public boolean nonVocationalGropFeesAssignment(Integer standardId,JSONObject sectionFeesJson,boolean isAllfeesSame,Integer termCompareId){
  SchoolStandardsDefnition standardDef= schoolStandardsDefnitionRepository.findOne(standardId);
  standardDef.setAllSectionFeesSame(isAllfeesSame);
  schoolStandardsDefnitionRepository.saveAndFlush(standardDef);
  SchoolTermDefinition termDefObj=new SchoolTermDefinition();
  TermFrequency termFrequecy=null;
  List< SchoolTermDefinition> schoolTermDefList=new ArrayList<SchoolTermDefinition>(schoolTermDefRepo.findAll());
  termDefObj.setCompareId(termCompareId);
  int position= schoolTermDefList.indexOf(termDefObj);
  termDefObj= schoolTermDefList.get(position);
  List<SchoolClassSectionDefinition> schoolClassSectionList=new ArrayList<SchoolClassSectionDefinition>(standardDef.getSectionSet()); 
  Iterator iterator= sectionFeesJson.keySet().iterator();
  HashSet<SchoolFeesDefinitionAssignment> subjectDefSet=null;
     SchoolFeesDefinition freshFeesDef=null;
     SchoolFeesDefinitionAssignment feesAssignment=null;
     List<SchoolFeesDefinition> schoolFeesDefList= feesDefintionRepository.findAll();
   while(iterator.hasNext()){
      freshFeesDef =new SchoolFeesDefinition();
     String key= (String) iterator.next();
     Integer sectionId=Integer.parseInt(key);
     SchoolClassSectionDefinition classSectionDef= new SchoolClassSectionDefinition();
     classSectionDef.setCompareId(sectionId);
     int result= schoolClassSectionList.indexOf(classSectionDef);
     classSectionDef=  schoolClassSectionList.get(result);
     /*if(classSectionDef.getSchoolFeesDefinitionAssignmentSet().size()!=0){
        classSectionDef.getSchoolFeesDefinitionAssignmentSet().clear();
     }*/
     JSONArray feesArray= (JSONArray) sectionFeesJson.get(key);
     subjectDefSet =new HashSet<SchoolFeesDefinitionAssignment>();
     
        for(int s=0;s<feesArray.length();s++){
          System.out.println(feesArray.get(s));
          Integer subjectId=(Integer) feesArray.get(s);
          freshFeesDef.setCompareId(subjectId);
           int index=schoolFeesDefList.indexOf(freshFeesDef);
           freshFeesDef= schoolFeesDefList.get(index);
           if(index!=-1){
             Iterator<TermFrequency> frequencyIterator= termDefObj.getTermFrequencySet().iterator();
             while(frequencyIterator.hasNext()){
               termFrequecy= frequencyIterator.next();
               feesAssignment=new SchoolFeesDefinitionAssignment();
               feesAssignment.setFeesName(freshFeesDef.getFeesName());
               feesAssignment.setStandardId(standardId);
               feesAssignment.setStandrdName(standardDef.getStandardName());
               feesAssignment.setSectionName(classSectionDef.getSectionName());
               feesAssignment.setBaseFeesId(freshFeesDef.getCompareId());
               feesAssignment.setTermId(termDefObj.getCompareId());
               feesAssignment.setTermtType(termDefObj.getTermName());
               feesAssignment.setTermFrequencyId(termFrequecy.getCompareId());
               feesAssignment.setPeriod(termFrequecy.getTermFrequencyName());
               feesAssignment.setSchoolClassSection(classSectionDef);
               SchoolFeesDefinitionAssignment  duplicateFeeAssignment= feesDefinitionAssignmentRepository.returnDuplicateTermFeesAssignmentForNonVocationalGroupStd(standardId, sectionId, termDefObj.getCompareId(), freshFeesDef.getCompareId(), termFrequecy.getCompareId());
               if(duplicateFeeAssignment==null){
                 classSectionDef.getSchoolFeesDefinitionAssignmentSet().add(feesAssignment);
               }
             
             }
           }
           freshFeesDef=new SchoolFeesDefinition();
        }
        classSectionRepository.saveAndFlush(classSectionDef);
       System.out.println(sectionId);
  }
   return true;
  
  }
public boolean vocationalGroupStandardFeesAssignement(Integer standardId,JSONObject sectionFeesJson,boolean isAllfeesSame,Integer termCompareId,boolean isGroupAssigned,Integer vocationalGroupId){
  SchoolVocationalGroupDefinitionAssignment vocationalGroupDefinitionAssignment= vocationalGroupAssignmentRepo.findOne(vocationalGroupId);
  vocationalGroupDefinitionAssignment.setAllSectionFeesSame(isAllfeesSame);
  vocationalGroupAssignmentRepo.saveAndFlush(vocationalGroupDefinitionAssignment);
  SchoolTermDefinition currentTermDef=new SchoolTermDefinition();
  TermFrequency termFrequecy=null;
  List< SchoolTermDefinition> schoolTermDefList=new ArrayList<SchoolTermDefinition>(schoolTermDefRepo.findAll());
  currentTermDef.setCompareId(termCompareId);
  int position= schoolTermDefList.indexOf(currentTermDef);
  currentTermDef= schoolTermDefList.get(position);
  List<SchoolClassSectionDefinition> schoolClassSectionList=new ArrayList<SchoolClassSectionDefinition>(vocationalGroupDefinitionAssignment.getSectionSet()); 
  Iterator iterator= sectionFeesJson.keySet().iterator();
  HashSet<SchoolFeesDefinitionAssignment> subjectDefSet=null;
  SchoolFeesDefinition freshFeesDef=null;
  SchoolFeesDefinitionAssignment feesAssignment=null;
  List<SchoolFeesDefinition> schoolFeesDefList= feesDefintionRepository.findAll();
  while(iterator.hasNext()){

    freshFeesDef =new SchoolFeesDefinition();
   String key= (String) iterator.next();
   Integer sectionId=Integer.parseInt(key);
   SchoolClassSectionDefinition classSectionDef= new SchoolClassSectionDefinition();
   classSectionDef.setCompareId(sectionId);
   int result= schoolClassSectionList.indexOf(classSectionDef);
   classSectionDef=  schoolClassSectionList.get(result);
   /*if(classSectionDef.getSchoolFeesDefinitionAssignmentSet().size()!=0){
      classSectionDef.getSchoolFeesDefinitionAssignmentSet().clear();
   }*/
   JSONArray feesArray= (JSONArray) sectionFeesJson.get(key);
   subjectDefSet =new HashSet<SchoolFeesDefinitionAssignment>();
   
      for(int s=0;s<feesArray.length();s++){
        System.out.println(feesArray.get(s));
        Integer subjectId=(Integer) feesArray.get(s);
        freshFeesDef.setCompareId(subjectId);
         int index=schoolFeesDefList.indexOf(freshFeesDef);
         freshFeesDef= schoolFeesDefList.get(index);
         if(index!=-1){
           Iterator<TermFrequency> frequencyIterator= currentTermDef.getTermFrequencySet().iterator();
           while(frequencyIterator.hasNext()){
             termFrequecy= frequencyIterator.next();
             feesAssignment=new SchoolFeesDefinitionAssignment();
             feesAssignment.setFeesName(freshFeesDef.getFeesName());
             feesAssignment.setStandardId(standardId);
             feesAssignment.setStandrdName(vocationalGroupDefinitionAssignment.getSchoolStandardsDefnition().getStandardName());
             feesAssignment.setVocationalGroupId(vocationalGroupDefinitionAssignment.getGroupId());
             feesAssignment.setVocationalGroupName(vocationalGroupDefinitionAssignment.getGroupName());
             feesAssignment.setSectionName(classSectionDef.getSectionName());
             feesAssignment.setBaseFeesId(freshFeesDef.getCompareId());
             feesAssignment.setTermId(currentTermDef.getCompareId());
             feesAssignment.setTermtType(currentTermDef.getTermName());
             feesAssignment.setTermFrequencyId(termFrequecy.getCompareId());
             feesAssignment.setPeriod(termFrequecy.getTermFrequencyName());
             feesAssignment.setSchoolClassSection(classSectionDef);
             SchoolFeesDefinitionAssignment  duplicateFeeAssignment= feesDefinitionAssignmentRepository.returnDuplicateTermFeesAssignmentForVocationalGroupStd(vocationalGroupDefinitionAssignment.getGroupId(), sectionId, currentTermDef.getCompareId(), freshFeesDef.getCompareId(), termFrequecy.getCompareId());
             if(duplicateFeeAssignment==null){
               classSectionDef.getSchoolFeesDefinitionAssignmentSet().add(feesAssignment);
             }
             
            // classSectionDef.getSchoolFeesDefinitionAssignmentSet().add(feesAssignment);
           }
         }
         freshFeesDef=new SchoolFeesDefinition();
      }
      classSectionRepository.saveAndFlush(classSectionDef);
     System.out.println(sectionId);

  }
  return true;
}

public JSONObject assignVocationGroupToStandards(JSONObject vocationalStandardJsonObj,String isSectionExit){
  java.util.List<SchoolVocationalGroupDefinition> vocationalgrouplist=schoolVocationalGroupRep.findAll();
  SchoolVocationalGroupDefinitionAssignment vocationalGroupDefinitionAssignment=null;
   Iterator<String> keys=vocationalStandardJsonObj.keys();
   while(keys.hasNext()){
     String key=keys.next();
      JSONArray vocationalGroupArray= (JSONArray) vocationalStandardJsonObj.get(key);
      
     Integer standardId=Integer.parseInt(key);
     SchoolStandardsDefnition standard= schoolStandardsDefnitionRepository.findOne(standardId);
     if(standard.getSectionSet().size()!=0 && isSectionExit.equals("true")){
       standard.getSectionSet().clear();
     }
     
     if(standard.getGroupSet().size()!=0){
       List<SchoolVocationalGroupDefinitionAssignment> oldGroupAssignmentList=  new ArrayList<SchoolVocationalGroupDefinitionAssignment>(standard.getGroupSet());
       Iterator<SchoolVocationalGroupDefinitionAssignment> iterator= oldGroupAssignmentList.iterator();
       int vocatinalgroupsize=vocationalGroupArray.length();
       if(vocationalGroupArray.length()!=0 && vocationalGroupArray !=null){
         for(int i=0;i<vocatinalgroupsize;i++){
           JSONObject groupJson= new JSONObject(vocationalGroupArray.get(i).toString());
           if(groupJson.get("derivedcompareid").equals("NEW")){
             boolean  groupEnabled=groupJson.getBoolean("status");
             Integer basegroupCompareId=  groupJson.getInt("basegroupcompareid");
             SchoolVocationalGroupDefinition freshSchoolVocationalDefObj=new SchoolVocationalGroupDefinition();
              freshSchoolVocationalDefObj.setCompareId(basegroupCompareId);
               int indexId= vocationalgrouplist.indexOf(freshSchoolVocationalDefObj);
               if(indexId !=-1){
                  vocationalGroupDefinitionAssignment=new SchoolVocationalGroupDefinitionAssignment();
                 freshSchoolVocationalDefObj= vocationalgrouplist.get(indexId);
                 vocationalGroupDefinitionAssignment.setGroupName(freshSchoolVocationalDefObj.getGroupName());
                 vocationalGroupDefinitionAssignment.setGroupDefnition(freshSchoolVocationalDefObj.getGroupDefinition());
                 vocationalGroupDefinitionAssignment.setBaseGroupId(freshSchoolVocationalDefObj.getCompareId());
                 vocationalGroupDefinitionAssignment.setGroupEnabled(groupEnabled);
                 vocationalGroupDefinitionAssignment.setSchoolStandardsDefnition(standard);
                 oldGroupAssignmentList.add(vocationalGroupDefinitionAssignment);
                 groupJson.put("derivedcompareid", vocationalGroupDefinitionAssignment.getCompareId());
                 vocationalGroupArray.put(i, groupJson);
               }
           }else{
             Integer derivedcompareid= groupJson.getInt("derivedcompareid");
             SchoolVocationalGroupDefinitionAssignment freshSchoolVocationalDefAssignmentObj=new SchoolVocationalGroupDefinitionAssignment();
             freshSchoolVocationalDefAssignmentObj.setCompareId(derivedcompareid);
              int  indexId=oldGroupAssignmentList.indexOf(freshSchoolVocationalDefAssignmentObj);
              if(indexId!=-1){
                freshSchoolVocationalDefAssignmentObj=oldGroupAssignmentList.get(indexId);
                freshSchoolVocationalDefAssignmentObj.setGroupEnabled(groupJson.getBoolean("status"));
              }
           }
         }
        Set<SchoolVocationalGroupDefinitionAssignment> vocationalAssignmentSet=new HashSet<SchoolVocationalGroupDefinitionAssignment>(oldGroupAssignmentList);
        standard.setGroupSet(vocationalAssignmentSet);
        boolean flag = true;
        for(SchoolVocationalGroupDefinitionAssignment groupAssignment: standard.getGroupSet()){
          if(!groupAssignment.isGroupEnabled()){
            flag=false;
          }else{
            flag=true;
           break; 
          }
        }
       standard.setGroupassigned(flag); 
       schoolStandardsDefnitionRepository.saveAndFlush(standard);
       }
      
     }else{
       int vocatinalgroupsize=vocationalGroupArray.length();
       if(vocationalGroupArray.length()!=0 && vocationalGroupArray !=null){
         for(int i=0;i<vocatinalgroupsize;i++){
          vocationalGroupDefinitionAssignment=new SchoolVocationalGroupDefinitionAssignment();
          SchoolVocationalGroupDefinition freshSchoolVocationalDefObj=new SchoolVocationalGroupDefinition();
          JSONObject vocationalGroup=new JSONObject(vocationalGroupArray.get(i).toString());
          Integer basegroupcompareid= vocationalGroup.getInt("basegroupcompareid");
          boolean groupEnabled=vocationalGroup.getBoolean("status");
          freshSchoolVocationalDefObj.setCompareId(basegroupcompareid);
          int indexId= vocationalgrouplist.indexOf(freshSchoolVocationalDefObj);
          freshSchoolVocationalDefObj= vocationalgrouplist.get(indexId);
          vocationalGroupDefinitionAssignment.setGroupName(freshSchoolVocationalDefObj.getGroupName());
          vocationalGroupDefinitionAssignment.setGroupDefnition(freshSchoolVocationalDefObj.getGroupDefinition());
          vocationalGroupDefinitionAssignment.setBaseGroupId(freshSchoolVocationalDefObj.getCompareId());
          vocationalGroupDefinitionAssignment.setGroupEnabled(groupEnabled);
          vocationalGroupDefinitionAssignment.setSchoolStandardsDefnition(standard);
          standard.getGroupSet().add(vocationalGroupDefinitionAssignment);
          standard.setGroupassigned(true);
          vocationalGroup.put("derivedcompareid",vocationalGroupDefinitionAssignment.getCompareId() );
          vocationalGroupArray.put(i, vocationalGroup);
         }
      schoolStandardsDefnitionRepository.saveAndFlush(standard);
       }
     }
     vocationalStandardJsonObj.put(key, vocationalGroupArray);
   }
  return vocationalStandardJsonObj;
}
public boolean deleteSubjectAssignment(JSONObject deltefactors){
String baseSubjectId=  deltefactors.getString( "basesubjectid");
String sectionId=  deltefactors .getString( "sectionid");
String standardId=  deltefactors.getString( "standardid");
Integer primaryKey=definitionAssignmentRepository.getSubjectAssignmentPrimaryKey(Integer.parseInt(standardId),Integer.parseInt(sectionId),Integer.parseInt(baseSubjectId));
 
if(primaryKey!=null){
  definitionAssignmentRepository.deleteSubjectFromAssignment(primaryKey);
}

//definitionAssignmentRepository.de
//System.out.println("BASE SUBJECT"+baseSubjectId+"section"+sectionId+" standard"+standardId+"row affected:"+rowsAffected);

  return true;
}


  public  Set<SchoolClassSectionDefinition> getAllSections() {
    SchoolMasterDataDefinition schoolMasterDataDefinition =
        masterDataDefinitionRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    Set<SchoolClassSectionDefinition> classSectionSet = new HashSet<SchoolClassSectionDefinition>();
    Set<SchoolStandardsDefnition> standardList =schoolMasterDataDefinition.getSchoolStandardsDefnition();
    
    if(standardList !=null && standardList.size()!=0)
    {
      Iterator<SchoolStandardsDefnition> iterator = standardList.iterator();
      while (iterator != null && iterator.hasNext()) {
        SchoolStandardsDefnition schoolStandObj = (SchoolStandardsDefnition) iterator.next();
        if(schoolStandObj.getStandardId()==69142){
        	System.out.println();
        }
        if(schoolStandObj.isGroupassigned()!=true){
          Iterator<SchoolClassSectionDefinition> sectionIterator =
              schoolStandObj.getSectionSet().iterator();
          while (sectionIterator != null && sectionIterator.hasNext()) {
            SchoolClassSectionDefinition classSectionObj = sectionIterator.next();
            
            classSectionSet.add(classSectionObj);
          }
        }else{
          Iterator<SchoolVocationalGroupDefinitionAssignment> vocationGroupAssignmentIterator =
              schoolStandObj.getGroupSet().iterator();
          while (vocationGroupAssignmentIterator != null && vocationGroupAssignmentIterator.hasNext()) {
            SchoolVocationalGroupDefinitionAssignment vocationalGroup = vocationGroupAssignmentIterator.next();
            Iterator<SchoolClassSectionDefinition> sectionIterator =
                vocationalGroup.getSectionSet().iterator();
            while (sectionIterator != null && sectionIterator.hasNext()) {
              SchoolClassSectionDefinition classSectionObj = sectionIterator.next();
              classSectionSet.add(classSectionObj);
            }
          }
          
        }
       
      }
    }
    
    return classSectionSet;
  }
}


/*
 * public boolean feesAssignment(Integer standardId,JSONObject sectionFeesJson,boolean isAllfeesSame,Integer termCompareId){
  SchoolStandardsDefnition standardDef= schoolStandardsDefnitionRepository.findOne(standardId);
  standardDef.setAllSectionFeesSame(isAllfeesSame);
  schoolStandardsDefnitionRepository.saveAndFlush(standardDef);
  Iterator iterator= sectionFeesJson.keySet().iterator();
  HashSet<SchoolFeesDefinitionAssignment> subjectDefSet=null;
     SchoolFeesDefinition freshFeesDef=null;
     SchoolFeesDefinitionAssignment feesAssignment=null;
     List<SchoolFeesDefinition> schoolFeesDefList= feesDefintionRepository.findAll();
   while(iterator.hasNext()){
      freshFeesDef =new SchoolFeesDefinition();
     String key= (String) iterator.next();
     Integer sectionId=Integer.parseInt(key);
     SchoolClassSectionDefinition classSectionDef= classSectionRepository.findOne(sectionId);
     if(classSectionDef.getSchoolFeesDefinitionAssignmentSet().size()!=0){
        classSectionDef.getSchoolFeesDefinitionAssignmentSet().clear();
     }
     JSONArray feesArray= (JSONArray) sectionFeesJson.get(key);
     subjectDefSet =new HashSet<SchoolFeesDefinitionAssignment>();
     
        for(int s=0;s<feesArray.length();s++){
          feesAssignment=new SchoolFeesDefinitionAssignment();
          System.out.println(feesArray.get(s));
          Integer subjectId=(Integer) feesArray.get(s);
          freshFeesDef.setCompareId(subjectId);
           int index=schoolFeesDefList.indexOf(freshFeesDef);
           freshFeesDef= schoolFeesDefList.get(index);
           if(index!=-1){
             feesAssignment.setFeesName(freshFeesDef.getFeesName());
             feesAssignment.setStandardId(standardId);
             feesAssignment.setBaseFeesId(freshFeesDef.getFeesId());
             feesAssignment.setSchoolClassSection(classSectionDef);
               classSectionDef.getSchoolFeesDefinitionAssignmentSet().add(feesAssignment);
           }
           freshFeesDef=new SchoolFeesDefinition();
        }
      // classSectionDef.setSchoolSubjectAssignmentSet(subjectDefSet);
        classSectionRepository.saveAndFlush(classSectionDef);
       System.out.println(sectionId);
  }
   return true;
  
  }

 * 
 * */
 