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
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import antlr.collections.List;

import com.feescorner.masterdata.handlers.MasterDataHandler;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.feescorner.serverstartup.serverstartupServlets.JQueryDataTableParamModel;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinition;
import com.solutiontag.entity.test.DetachedEntityPassedBase;
import com.solutiontag.entity.test.DetachedEntityPassedChild;
import com.solutiontag.entity.test.DetachedEntityPassedSetData;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;
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
  public String processStandardDefinition(@ModelAttribute("schoolMasterDataDefinition")SchoolMasterDataDefinition schoolMasterDataDefinitionformObject ,HttpServletRequest request,HttpServletResponse response,Model model,BindingResult bindingResult) throws Exception{
   // SchoolCollection schoolCollection=  schoolCollectionRepo.findOne("RAVI SCHOOLCBSEPRE-PRIMARY55553");
   boolean isSaved=masterDataHandler.saveStandardDefintion(schoolMasterDataDefinitionformObject);
 System.out.println("standards modified:"+isSaved);
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
  public String saveSections(@RequestParam String wrappedSectionData,HttpServletRequest request,HttpServletResponse response,Model model) throws JsonParseException, JsonMappingException, IOException{
   boolean result= masterDataHandler.saveSection(wrappedSectionData);
    if(!true)
    {
      throw new IOException("Data not saved");
    }
    SchoolMasterDataDefinition schoolMasterDataDefinition =masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY21675");
    model.addAttribute("schoolMasterDataDefinition", schoolMasterDataDefinition);
    
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
  masterDataHandler.deleteSection(standardIndexId, sectionId);
    
    
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
public void subjectAssignment(@RequestParam String finalAssignmentData){
  JSONObject subjectAssignmentJson=new JSONObject(finalAssignmentData);
   Integer standardId= subjectAssignmentJson.getInt("stanadrdId");
   JSONObject jsonObject=new JSONObject(subjectAssignmentJson.get("sectionData").toString());
  boolean result= masterDataHandler.subjectAssignmentHandler(standardId,jsonObject);
  System.out.println("Saved successfully=="+result);
  
}

@RequestMapping(value="fees-creation",method=RequestMethod.POST)
public void feesCreation(@RequestBody SchoolFeesDefinition schoolFeesDef,Model model,HttpServletRequest req,HttpServletResponse response)
{ 
SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY34991");
schoolFeesDef.setDefForFees(schoolMasterDataDefinition);
schoolMasterDataDefinition.getSchoolFeesDefintion().add(schoolFeesDef);
schoolFeesDefinitionRepository.save(schoolFeesDef);

//masterDataRepository.saveAndFlush(schoolMasterDataDefinition);
System.out.println("trigger");
}
@RequestMapping(value="refresh")
public String refreshPage(HttpServletRequest request,HttpServletResponse response){
  
  return "";
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

   

