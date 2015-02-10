/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 10, 2015                        TODO

 */
package com.feescorner.masterdata.controllers;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feescorner.academic.services.SetDefnitions;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinition;
import com.solutiontag.repository.masterdata.SchoolClassSectionDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;

@Controller
@RequestMapping("/academics")
public class MasterDataNavigationController {
  
  @Autowired
  public SchoolStandardsDefnitionRepository standardDefintionRepo;
  @Autowired 
  public SchoolMasterDataDefinitionRepository masterDataRepository;
  
  @Autowired
  public SchoolClassSectionDefinitionRepository schoolSectionRepo;
  
  @RequestMapping(value="/display-school-master-data",method=RequestMethod.GET)
  public String lauchAcademicMasterDataScreen(Model model){
    SchoolCollection schoolCollection= new SchoolCollection();
    model.addAttribute("schoolCollection",schoolCollection);
    return "schoolmasterdatascreen";
  }
 @RequestMapping(value="/display-academic-master-data")
 public String launchAcademicMasterDataScrenn(Model model){
   SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY21675");
   Set<SchoolStandardsDefnition> standardList=  schoolMasterDataDefinition.getSchoolStandardsDefnition();
   Iterator<SchoolStandardsDefnition> iterator=standardList.iterator();
   while(iterator.hasNext()){
     SchoolStandardsDefnition schoolStandObj= (SchoolStandardsDefnition) iterator.next();
     //System.out.println(schoolStandObj.getEqualObjectId()+","+schoolStandObj.getSort()+","+schoolStandObj.getStandardName()+","+schoolStandObj.isStatusForChecked()+","+schoolStandObj.getStandardId());
   }
  model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
  model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
 
  //model.addAttribute(schoolMasterDataDefinition.getSchoolStandardsDefnition());
   return "academicmasterdatascreen";
 }
 @RequestMapping(value="/nonacademic-master-data")
 public String lauchNonAcademicmasterDataScreen(Model model){
   SetDefnitions setDef=new SetDefnitions();
   SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY21675");
   setDef.setSchoolFeesDefSet( schoolMasterDataDefinition.getSchoolFeesDefintion());
   model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
   model.addAttribute("setDef",setDef);
   return "nonacademicmasterdatascreen";
 }
 
 
 
}



/*http://stackoverflow.com/questions/19249049/how-to-pass-parameters-to-redirect-page-in-spring-mvc
You can write a handler method like this to handle the redirect request:

@RequestMapping(value="/home", method = RequestMethod.GET )
public String showHomePage()  {
    return "home";
}
And you can re-write the logOut handler method as follows:

@RequestMapping(value="/logOut", method = RequestMethod.POST )
public String logOut(Model model, RedirectAttributes redirectAttributes)  {
    redirectAttributes.addFlashAttribute("message", "success logout");
    System.out.println("/logOut");
    return "redirect:/home";
}

 //  SchoolMasterDataDefinition schoolMasterDataDefinition= ApplicationUtills.getSchoolCollectionObject().getSchoolMasterData();
   //schoolMasterDataDefinition.setSchoolCollection(ApplicationUtills.getSchoolCollectionObject());
   //List<SchoolStandardsDefnition> schoolStandardsDefnitionsSet=schoolCollection.getSchoolMasterData().getSchoolStandardsDefnition();
  /*Iterator<SchoolStandardsDefnition> iterator= schoolStandardsDefnitionsSet.iterator();
  SchoolClassSectionDefinition section1=null;
  SchoolClassSectionDefinition section2=null;
  SchoolClassSectionDefinition section3=null;
  List<SchoolClassSectionDefinition> schoolSectionList=null;
 while(iterator.hasNext()){
  
   schoolSectionList=new ArrayList<SchoolClassSectionDefinition>();
   SchoolStandardsDefnition schoolStandObj=iterator.next();
   
    section1=new SchoolClassSectionDefinition();
    section1.setSectionName("A");
    section1.setSchoolStandardsDefnition(schoolStandObj);
    schoolSectionRepo.save(section1);
    
    section2=new SchoolClassSectionDefinition();
    section2.setSectionName("B");
    section2.setSchoolStandardsDefnition(schoolStandObj);
    schoolSectionRepo.save(section2);

    
    section3=new SchoolClassSectionDefinition();
    section3.setSectionName("C");
    section3.setSchoolStandardsDefnition(schoolStandObj);
    schoolSectionRepo.save(section3);
   
   // standardDefintionRepo.save(schoolStandObj);
   
    if(schoolStandObj.isStatusForChecked()){
      System.out.println(schoolStandObj.getHashSetIndexId()+","+schoolStandObj.getSort()+","+schoolStandObj.getStandardName()+","+schoolStandObj.isStatusForChecked()+","+schoolStandObj.getStandardId());
      System.out.print(schoolStandObj.getSort()+",");
    }
    schoolStandObj=null;
    schoolSectionList=null;
  }*/



