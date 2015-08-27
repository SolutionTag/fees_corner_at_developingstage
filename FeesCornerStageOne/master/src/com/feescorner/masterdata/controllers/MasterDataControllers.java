/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.feescorner.masterdata.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.feescorner.academic.services.ApplicationStringJsons;
import com.feescorner.academic.services.CollectionDefinition;
import com.feescorner.masterdata.handlers.MasterDataHandler;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.feescorner.serverstartup.serverstartupServlets.JQueryDataTableParamModel;
import com.meshyog.edument.prerequisites.AcademicMasterDataJsonPrerequisites;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolTermDefinition;
import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinition;
import com.solutiontag.entity.masterdata.TermFrequency;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;
import com.solutiontag.repository.masterdata.SchoolTermDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolVocationalGroupDefinitionRepository;
import com.solutiontag.repository.test.DetachedEntityPassedBaseRepo;
import com.solutiontag.repository.test.DetachedEntityPassedChildRepo;
import com.solutiontag.repository.test.DetachedEntityPassedSetDataRepo;

@Controller
/*@SessionAttributes("schoolCollection")
*/
@RequestMapping("/settings")
public class MasterDataControllers {
  public MasterDataControllers(){
  }
  
  public static ObjectMapper mapper=new ObjectMapper();
  private static final Logger log=Logger.getLogger(MasterDataControllers.class);
  
  @Autowired
  public DetachedEntityPassedBaseRepo baseRepo;
  @Autowired
  public DetachedEntityPassedChildRepo childRepo;
  @Autowired
  DetachedEntityPassedSetDataRepo childsetRepo;
  @Autowired
  public SchoolStandardsDefnitionRepository schoolStandardsDefnitionRepository;
  @Autowired
  public SchoolMasterDataDefinitionRepository masterDataRepository;
  @Autowired
  public MasterDataHandler masterDataHandler;
  @Autowired 
  public SchoolFeesDefinitionRepository schoolFeesDefinitionRepository;
  @Autowired
  public SchoolVocationalGroupDefinitionRepository schoolVocationalGroupRep;
  @Autowired
  public SchoolTermDefinitionRepository schoolTermRepo;
  @Autowired
  public ApplicationStringJsons applicationStringJsons;
  @Autowired
  public AcademicMasterDataJsonPrerequisites jsonPrerequisites;
  
  @Autowired
  public SchoolCollectionRepository schoolCollectionRepo;
  public ApplicationUtills appUtills=new ApplicationUtills();
  @RequestMapping("/school")
  public String  schoolSettings(Model model){
    model.addAttribute("schoolCollection",new SchoolCollection()); 
    System.out.println("loader school settings page.");
    //return "viewpage/mastermodule/adminmainpage";
    return "schoolsetting" ;
  }
  @RequestMapping(value="/gg")
  public String formSubmissioncheck(){
    System.out.println("Trigger value");
    return "academicmasterdata";
    
  }
  @RequestMapping(value="/lauchschoolsetting",method=RequestMethod.GET)
  public ModelAndView lauchSchoolCreationScreen()
  {
   SchoolCollection schoolCollection=new SchoolCollection();
   
   
    //SchoolCollection schoolCollection= masterDataHandler.getSchoolObject();
    // schoolCollection.setSchoolName("RAVI SCHOOL");
   //  @SessionAttributes ("command");
   // model.addAttribute("schoolCollection", schoolCollection);
    return new ModelAndView("schoolsetting", "schoolCollection", schoolCollection);
   // return "schoolsetting";
  }
  
  @RequestMapping(value="/save-school",method=RequestMethod.POST)
  public String formsubmission(@ModelAttribute("schoolCollection") SchoolCollection schoolCollection,ModelMap model,RedirectAttributes redirectAttributes){
   boolean result =masterDataHandler.saveSchool(schoolCollection);
   if(result==true){
     redirectAttributes.addFlashAttribute("SchoolSaved Successfully");
     log.debug("school saved successfully.");
   }
    return "redirect:/home";
  }
  @RequestMapping(value="/gotosettings",method=RequestMethod.GET)
public String launchSettingsScreen(HttpServletRequest request,HttpServletResponse resposnse){
    return "dummysettings";
  }
  @RequestMapping(value="/standardDefinitionForm",method=RequestMethod.GET)
  public String launchStandardDefScreen(Model model){
  model.addAttribute("standardDefinition",new SchoolStandardsDefnition());
  return "standardform";
    }
 
  @RequestMapping(value="/saveStandard",method=RequestMethod.POST)
  public String processStandardDefinition(@ModelAttribute("setDefinitions") CollectionDefinition setDef ,HttpServletRequest request,HttpServletResponse response,Model model,BindingResult bindingResult) throws Exception{
   SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
   boolean isSaved=masterDataHandler.saveStandardDefintion(setDef.getStandardDefList(),schoolMasterDataDefinition);
   model.addAttribute("standardFormModelAttribute",new SchoolStandardsDefnition());
   System.out.println("standards modified:"+isSaved);
   List<SchoolStandardsDefnition> standardDefList=new ArrayList<SchoolStandardsDefnition>(schoolMasterDataDefinition.getSchoolStandardsDefnition());
   setDef.setClassSectionDefSet(masterDataHandler.getAllSections());
   setDef.setStandardDefList(standardDefList);
   model.addAttribute("setDefinitions", setDef);
   model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
   model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
   model.addAttribute("vocationalgroupdef",new SchoolVocationalGroupDefinition());
   model.addAttribute("standardFormModelAttribute",new SchoolStandardsDefnition());
    return "academicmasterdatascreen";
  }
  @RequestMapping(value="/add-new-standard",method=RequestMethod.POST)
  public String addNewStandard(@ModelAttribute("standardFormModelAttribute") SchoolStandardsDefnition schoolStandardDef,Model model,HttpServletRequest request,HttpServletResponse resp) throws IOException{
    SchoolMasterDataDefinition schoolMasterDataDefinition =masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    schoolStandardDef.setDefForStandard(schoolMasterDataDefinition);
    schoolMasterDataDefinition.getSchoolStandardsDefnition().add(schoolStandardDef);
 /*   HashSet<SchoolStandardsDefnition> standardSet=new HashSet<SchoolStandardsDefnition>();
    standardSet.add(schoolStandardDef);
    schoolMasterDataDefinition.setSchoolStandardsDefnition(standardSet);*/
   schoolStandardsDefnitionRepository.save(schoolStandardDef);
   // masterDataRepository.saveAndFlush(schoolMasterDataDefinition);
    CollectionDefinition setDefinitions=new CollectionDefinition();
    Set<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentSet=new HashSet<SchoolSubjectsDefinitionAssignment>();
    setDefinitions.setClassSectionDefSet(masterDataHandler.getAllSections());
    List<SchoolStandardsDefnition> standardDefList=new ArrayList<SchoolStandardsDefnition>(schoolMasterDataDefinition.getSchoolStandardsDefnition());
    setDefinitions.setSchoolSubjectAssignmentSet(schoolSubjectAssignmentSet);
    setDefinitions.setStandardDefList(standardDefList);
    model.addAttribute("setDefinitions", setDefinitions);
    model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
    model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
    model.addAttribute("vocationalgroupdef",new SchoolVocationalGroupDefinition());
    model.addAttribute("standardFormModelAttribute",new SchoolStandardsDefnition());
  //model.addAttribute(schoolMasterDataDefinition.getSchoolStandardsDefnition());
   return "academicmasterdatascreen";
    
  }
  
  
  @RequestMapping(value = "/subjectDefinitionForm", method = RequestMethod.GET)
  public String launchSubjectDefScreen(Model model) {
    SchoolCollection schoolCollection = masterDataHandler.getSchoolCollectionObject();
    Set<SchoolStandardsDefnition> standardDefintionSet =
        schoolCollection.getSchoolMasterData()
            .getSchoolStandardsDefnition();
    /*java.util.List<SchoolStandardsDefnition> standardDefintionList =
        new ArrayList<SchoolStandardsDefnition>(standardDefintionSet);*/
    model.addAttribute("standardDefintionSet", standardDefintionSet);
    model.addAttribute("subjectDefinition", new SchoolSubjectsDefinition());
    return "subjectform";
  }
  
  @RequestMapping(value="/saveSections",method=RequestMethod.POST)
  public String saveSections(@RequestParam("customParameter") String wrappedSectionData,HttpServletRequest request,HttpServletResponse response,Model model) throws JsonParseException, JsonMappingException, IOException{
   boolean result= masterDataHandler.saveSection(wrappedSectionData);
   System.out.println(result);
   CollectionDefinition setDefinitions=new CollectionDefinition();
    SchoolMasterDataDefinition schoolMasterDataDefinition =masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    List<SchoolStandardsDefnition> standardDefList=new ArrayList<SchoolStandardsDefnition>(schoolMasterDataDefinition.getSchoolStandardsDefnition());
    setDefinitions.setClassSectionDefSet(masterDataHandler.getAllSections());
    setDefinitions.setStandardDefList(standardDefList);
    model.addAttribute("setDefinitions", setDefinitions);
    model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
    model.addAttribute("schoolMasterDataDefinition", schoolMasterDataDefinition);
    model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
    model.addAttribute("vocationalgroupdef",new SchoolVocationalGroupDefinition());
    model.addAttribute("standardFormModelAttribute",new SchoolStandardsDefnition());
    return  "academicmasterdatascreen";
  }
  
  @RequestMapping(value="/saveSubject",method=RequestMethod.POST,produces="application/json")
  public  void  saveSubject(@RequestBody SchoolSubjectsDefinition schoolSubjectDef,  @RequestParam String subjectData,HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
   // masterDataHandler.saveSubject(schoolSubjectDef);
   // schoolSubjectDef.setDefForSubject(ApplicationUtills.getSchoolCollectionObject().getSchoolMasterData());
   //String subjectData=request.getParameter("subjectDeclarationData");
   
    JSONObject subjectJsonObj=new JSONObject(subjectData);
    JSONObject subjectOrderedJson=new JSONObject();
    response.setContentType( "application/json");
    PrintWriter writter=response.getWriter();
    System.out.println(schoolSubjectDef.getCompareId());
    SchoolSubjectsDefinition subjectDeclarationObj= masterDataHandler.saveSubject(schoolSubjectDef);
    subjectOrderedJson.put("subjectId",subjectDeclarationObj.getSubjectId());
    subjectOrderedJson.put("compareId",subjectDeclarationObj.getCompareId());
    subjectOrderedJson.put("subjectName",subjectJsonObj.get("subjectName"));
    subjectOrderedJson.put("subjectRefId",subjectJsonObj.get("subjectRefId"));
    subjectOrderedJson.put("subjectPreferreStd",subjectJsonObj.get("subjectPreferreStd"));
    subjectOrderedJson.put("action","");
    writter.append(subjectOrderedJson.toString());
  
  }
  @RequestMapping(value="/deleteSection",method=RequestMethod.POST,produces="application/json")
  public void deleteSection(@RequestBody String deletingParameters,HttpServletRequest request,HttpServletResponse response) throws IOException{
  String json= java.net.URLDecoder.decode(deletingParameters,"UTF-8");
  JSONObject deleteParams=new JSONObject(json);
  Integer standardIndexId=deleteParams.getInt("standardIndexId");
  Integer sectionId=deleteParams.getInt("sectionIndexId");
  Integer groupCompareid=0;
  if(deleteParams.has("groupcompareId")){
     groupCompareid=deleteParams.getInt("groupcompareId");   
  }
 
  masterDataHandler.deleteSection(standardIndexId, sectionId,groupCompareid);
    
    
  }
  @RequestMapping(value="/loadsectiondata",method=RequestMethod.GET)
  public void loadsectiondata(@RequestParam String masterdataid,@ModelAttribute JQueryDataTableParamModel model,HttpServletRequest request,HttpServletResponse response) throws IOException{
   String data=request.getParameter("data");
   
   //request.getP
   System.out.println(data);
   // System.out.println(masterdataid);
    System.out.println("*****************************");
    response.setContentType( "application/json");
    PrintWriter writter=response.getWriter();
   String sectionArrayData= masterDataHandler.getSectionTable(model,masterdataid);
    writter.append(sectionArrayData);
    System.out.println();
  }


@RequestMapping(value="/subjectAssignment",method=RequestMethod.POST)
public void subjectAssignment(@RequestParam String finalAssignmentData,HttpServletRequest request,HttpServletResponse response) throws IOException{
  PrintWriter writter=response.getWriter();
  JSONObject subjectAssignmentJson=new JSONObject(finalAssignmentData);
   Integer standardId= subjectAssignmentJson.getInt("standardId");
  
   JSONObject jsonObject=new JSONObject(subjectAssignmentJson.get("sectionData").toString());
 boolean groupAssigned=  subjectAssignmentJson.getBoolean("groupassigned");
 
 if(groupAssigned==false){
   boolean result= masterDataHandler.nonGroupSubjectAssignmentHandler(standardId,jsonObject);
   System.out.println(result);
 }else if(groupAssigned==true && subjectAssignmentJson.has("groupassignedId")){
   Integer groupCompareId= subjectAssignmentJson.getInt("groupassignedId");
   masterDataHandler.groupSubjectAssignmentHandler(groupCompareId, standardId, jsonObject);
 }
 
  
 writter.append("success");
  
}
@RequestMapping(value="/feesAssignment",method=RequestMethod.POST)
public void feesAssignment(@RequestParam String finalAssignmentData,HttpServletRequest request,HttpServletResponse response) throws IOException{
  PrintWriter writter=response.getWriter();
  JSONObject feesAssignmentJson=new JSONObject(finalAssignmentData);
  Integer standardId= feesAssignmentJson.getInt("standardId"); 
  JSONObject jsonObject=new JSONObject(feesAssignmentJson.get("sectionData").toString());
  boolean isAllfeesSame= feesAssignmentJson.getBoolean("allSectionFeesSame");
  Integer termCompareId= feesAssignmentJson.getInt("termId");
  boolean groupAssigned=feesAssignmentJson.getBoolean("isGroupAssigned");
  Integer groupId=feesAssignmentJson.getInt("groupId" );
  if(groupAssigned!=true){
    boolean result= masterDataHandler.nonVocationalGropFeesAssignment(standardId,jsonObject,isAllfeesSame,termCompareId);
  }
  else{
    masterDataHandler.vocationalGroupStandardFeesAssignement(standardId, jsonObject, isAllfeesSame, termCompareId, groupAssigned, groupId);
  }
 
// System.out.println("Saved successfully=="+result);
 writter.append("success");
}

@RequestMapping(value="fees-creation",method=RequestMethod.POST)
public void feesCreation(@RequestBody SchoolFeesDefinition schoolFeesDef,Model model,HttpServletRequest req,HttpServletResponse response)
{ 
SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
schoolFeesDef.setDefForFees(schoolMasterDataDefinition);
schoolMasterDataDefinition.getSchoolFeesDefintion().add(schoolFeesDef);
schoolFeesDefinitionRepository.save(schoolFeesDef);

//masterDataRepository.saveAndFlush(schoolMasterDataDefinition);
System.out.println("trigger");
}


@RequestMapping(value="create-vocational-group",method=RequestMethod.POST)
public void createVocationalGroup(@RequestBody SchoolVocationalGroupDefinition schoolVocationalGroup,Model model,HttpServletRequest request,HttpServletResponse resp) throws IOException{
  PrintWriter writter=resp.getWriter();
  SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
  schoolVocationalGroup.setDefForVocationalDefinition(schoolMasterDataDefinition);
  schoolMasterDataDefinition.getVocatinalGroupDefSet().add(schoolVocationalGroup);
  schoolVocationalGroupRep.save(schoolVocationalGroup);
  List<SchoolVocationalGroupDefinition> vocationalGroupDefinitionsList=  new ArrayList<SchoolVocationalGroupDefinition>(schoolMasterDataDefinition.getVocatinalGroupDefSet());
  String vocationalGroupJsonString=ApplicationUtills.convertListToJsonString(vocationalGroupDefinitionsList);
  writter.print(vocationalGroupJsonString);
  
}

@RequestMapping(value="/assign-vocational-group",method=RequestMethod.POST)
public String assignVocationGroups(@RequestParam("customParameter") String  vocationalStandard,HttpServletRequest request,HttpServletResponse resp,Model model) throws IOException{
  java.util.List<SchoolVocationalGroupDefinition> vocationalgrouplist=schoolVocationalGroupRep.findAll();
  System.out.println(vocationalgrouplist.size());
  JSONObject data=new JSONObject(vocationalStandard);
  JSONObject vocationalStandardJsonObj=data.getJSONObject("vocationalstandars");
  String isGroupAssigned=data.getString("isSectionExit");
  JSONObject afterAssignedGroupToStandard=  masterDataHandler.assignVocationGroupToStandards(vocationalStandardJsonObj,isGroupAssigned);
  model=preRequisiteForlaunchAcademicMasterData(model);
  return "academicmasterdatascreen";
}
@RequestMapping(value="refresh")
public String refreshPage(HttpServletRequest request,HttpServletResponse response){
  
  return "";
}
@RequestMapping(value="term-definition",method=RequestMethod.POST, consumes="application/json")
public void createTermDefinition(@RequestBody  SchoolTermDefinition termDefinition, HttpServletResponse response ,HttpServletRequest request ,Model model) throws IOException
{
  PrintWriter writter=response.getWriter();
 // CollectionDefinition setDefinitions=new CollectionDefinition();
 // Set<SchoolFeesDefinitionAssignment> feesAssignmentSet=new HashSet<SchoolFeesDefinitionAssignment>();
  Iterator<TermFrequency> iterator= termDefinition.getTermFrequencySet().iterator();
  while(iterator.hasNext()){
    TermFrequency termfrequency= iterator.next();
    System.out.println("===>"+termfrequency.getTermFrequencyName());
    termfrequency.setSchoolTermDef(termDefinition);
  }
  SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
  termDefinition.setDefForTerm(schoolMasterDataDefinition);
  schoolMasterDataDefinition.getTermDefinitionSet().add(termDefinition);
  schoolTermRepo.save(termDefinition);
 // setDefinitions.setClassSectionDefSet(masterDataHandler.getAllSections());
 // setDefinitions.setSchoolFeesDefSet( schoolMasterDataDefinition.getSchoolFeesDefintion());
  //setDefinitions.setSchoolFeesAssignmentSet(feesAssignmentSet);
  //model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
  //model.addAttribute("setDef",setDefinitions);
 // model.addAttribute("termDefinition", new SchoolTermDefinition());
  writter.print("success");
}
@RequestMapping(value="delte-subject-assignment",method=RequestMethod.POST)
public void deleteSubjectAssignment(@RequestBody String deleteParameters,HttpServletRequest request,HttpServletResponse response) throws IOException{
  PrintWriter writter=response.getWriter();
  JSONObject deleteFactors=new JSONObject(deleteParameters);
  masterDataHandler.deleteSubjectAssignment(deleteFactors);
  writter.print(deleteParameters);
  
}

public Model preRequisiteForlaunchAcademicMasterData(Model model){
	CollectionDefinition setDefinitions=new CollectionDefinition();
	  //  Set<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentSet=new HashSet<SchoolSubjectsDefinitionAssignment>();
	   SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
	   List<SchoolStandardsDefnition> standardDefList=new ArrayList<SchoolStandardsDefnition>(schoolMasterDataDefinition.getSchoolStandardsDefnition());
	   applicationStringJsons=applicationStringJsons.getApplicationStringJsonForAcademicMasterData(schoolMasterDataDefinition);
	   setDefinitions.setClassSectionDefSet(masterDataHandler.getAllSections());
	  // setDefinitions.setSchoolSubjectAssignmentSet(schoolSubjectAssignmentSet);
	   setDefinitions.setStandardDefList(standardDefList);
	   model.addAttribute("applicationStringJsons",applicationStringJsons);
	   model.addAttribute("setDefinitions", setDefinitions);
	   model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
	   model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
	   model.addAttribute("vocationalgroupdef",new SchoolVocationalGroupDefinition());
	   model.addAttribute("standardFormModelAttribute",new SchoolStandardsDefnition());
	
	return model;
}

}

/*For Ref:
 * 
 *  mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
   mapper.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES,false);
   if(result==true){
     writter.append(mapper.writeValueAsString(schoolSubjectDef));
   }else{
     
     writter.append(mapper.writeValueAsString(schoolSubjectDef));
     
     
     
   }
   
    /* DetachedEntityPassedBase base=new DetachedEntityPassedBase();
 base.setDetachedName("RAGAVAN");
 DetachedEntityPassedChild child=new DetachedEntityPassedChild();
 base.setDetachedChild(child);
 child.setDetachedBase(base);
 baseRepo.save(base);*/
/*  
 DetachedEntityPassedChild child= childRepo.findOne(27650);
  DetachedEntityPassedSetData setdata=new DetachedEntityPassedSetData();
  setdata.setSetName("ram");
  Set<DetachedEntityPassedSetData> newSet=new HashSet<DetachedEntityPassedSetData>();
  newSet.add(setdata);
  child.setDetachedSet(newSet);
  setdata.setDetachedEntitychildset(child);
 
  childsetRepo.save(setdata);*/
 /*DetachedEntityPassedChild child= childRepo.findOne(27650);
  DetachedEntityPassedSetData setdata=new DetachedEntityPassedSetData();
  setdata.setCompareId(332010927);
  setdata.setSetName("oops");
  setdata.setSetId(52065);
  Set<DetachedEntityPassedSetData> dbSet= child.getDetachedSet();
  java.util.List<DetachedEntityPassedSetData> dbList=new ArrayList<DetachedEntityPassedSetData>(dbSet);
  int index=dbList.indexOf(setdata);
  dbList.remove(index);
  dbList.add(index,setdata);
 // boolean result=dbSet.remove(setdata);
  //dbSet.add(setdata);
  Set<DetachedEntityPassedSetData> newSet=new HashSet<DetachedEntityPassedSetData>(dbList);
  setdata.setDetachedEntitychildset(child);
  child.setDetachedSet(newSet);
  childRepo.save(child);*/
  //childsetRepo.saveAndFlush(setdata);

   

