/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 17, 2015                        TODO

 */
package com.solutiontag.finance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;

import com.feescorner.academic.services.CollectionDefinition;
import com.feescorner.masterdata.beans.SchoolFeesDefinitionAdaptors;
import com.feescorner.masterdata.handlers.MasterDataHandler;
import com.solutiontag.entity.finance.FeesTermsElementsArrangements;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.finance.handler.FinanceSettingHandlers;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionAssignmentRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;
import com.solutiontag.repository.test.DetachedEntityPassedBaseRepo;
import com.solutiontag.repository.test.DetachedEntityPassedChildRepo;
import com.solutiontag.repository.test.DetachedEntityPassedSetDataRepo;

@Controller
@RequestMapping("finance")
public class FinanceController {
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
  public FinanceSettingHandlers financesettinghandlers;
  
  @Autowired
  public SchoolFeesDefinitionAssignmentRepository feesAssignmentRepo;
  
  
  
  
  @Autowired
  public SchoolCollectionRepository schoolCollectionRepo;
  @RequestMapping("finanace-settings")
  public String launchfinancesettingspage(HttpServletRequest request,HttpServletResponse response,Model model)
  {
    
    
    

   
    CollectionDefinition setDef=new CollectionDefinition();
    SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY79936");
    long startTime = System.currentTimeMillis();
    FeesTermsElementsArrangements fessTermElementArrangement=financesettinghandlers.getfeesTermElementArrangement(schoolMasterDataDefinition.getSchoolStandardsDefnition());
    long endTime = System.currentTimeMillis();
  /*  long duration = (endTime - startTime); */
    System.out.println("That took " + (endTime - startTime) + " milliseconds");
    SchoolFeesDefinitionAdaptors adaptors=new SchoolFeesDefinitionAdaptors();
   // String json = adaptors.schoolFeesDefinitionToJson(fessTermElementArrangement.getStandardWiseTerm()); 
    //System.out.println(json);
   // fessTermElementArrangement.getStandardWiseTerm().get(key);
    setDef.setSchoolFeesDefSet( schoolMasterDataDefinition.getSchoolFeesDefintion());
    setDef.setClassSectionDefSet(masterDataHandler.getAllSections());
    model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
    model.addAttribute("setDef",setDef);
    model.addAttribute("fessTermElementArrangement",fessTermElementArrangement);
   
    return "financesettingsscreen";
  }
  
/*  @RequestMapping(value="save-standard-feesparticulars",method=RequestMethod.POST)
  public void saveStandardFeesParticulars(@RequestBody  String stanardWiseFeesObject, HttpServletRequest request,HttpServletResponse response) throws IOException{
   PrintWriter writter=response.getWriter();
    stanardWiseFeesObject= request.getParameter("monthAmount");
    JSONObject standardFeesParticulars=new JSONObject(stanardWiseFeesObject);
    int standardId= standardFeesParticulars.getInt("standardId");
   JSONObject feesParticualrsObject=  standardFeesParticulars.getJSONObject(String.valueOf(standardId));
  //  financesettinghandlers.saveStandardFeesParticualrs(feesParticualrsObject, standardId);
    System.out.println();
  
  }*/
 
  @RequestMapping(value="save-standard-feesparticulars",method=RequestMethod.POST)
  public String saveStandardFeesParticulars(@RequestParam("customParameter") String stanardWiseFeesObject, HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
    JSONObject standardFeesParticulars=new JSONObject(stanardWiseFeesObject);
    CollectionDefinition setDef=new CollectionDefinition();
    int standardId= standardFeesParticulars.getInt("standardId");
    JSONObject feesParticualrsObject=  standardFeesParticulars.getJSONObject(String.valueOf(standardId));
    financesettinghandlers.saveStandardFeesParticualrs(feesParticualrsObject, standardId);
    SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY79936");
    model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
    model.addAttribute("setDef",setDef);
    System.out.println();
    return "financesettingsscreen";
  }
  
  @RequestMapping(value="save-fees-amount",method=RequestMethod.POST)
  public void saveFeesAssignment(@RequestBody String feesAssingmentJson,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
    PrintWriter writter=response.getWriter();
    List<SchoolFeesDefinitionAssignment> feesDefAssignmenList=  feesAssignmentRepo.findAll();
    org.json.JSONArray feesAmountDataArray=new  org.json.JSONArray(feesAssingmentJson);
    System.out.println(feesAmountDataArray.length());
    int length=feesAmountDataArray.length();
    for(int i=0;i<length;i++){
      JSONObject feesamount= new JSONObject( feesAmountDataArray.get(i).toString());
      Integer compareId= feesamount.getInt("compareId");
      Float feesAmount= (float) feesamount.getInt("feesAmount");
      SchoolFeesDefinitionAssignment feesAssignmentFresh=new SchoolFeesDefinitionAssignment();
      feesAssignmentFresh.setCompareId(compareId);
      int position=feesDefAssignmenList.indexOf(feesAssignmentFresh);
      feesDefAssignmenList.get(position).setFeesAmount(feesAmount);
      feesAssignmentRepo.saveAndFlush( feesDefAssignmenList.get(position));
    }
    writter.print("success");
   
    
   
  }

}
