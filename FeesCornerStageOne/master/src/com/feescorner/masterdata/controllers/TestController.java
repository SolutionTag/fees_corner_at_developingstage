package com.feescorner.masterdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.feescorner.masterdata.services.TestVillageService;
import com.feescorner.masterdata.test.model.TestVillage;

@Controller
public class TestController {
 @Autowired
  private TestVillageService testVillageService;
  @RequestMapping("/")
  public ModelAndView init(){
    System.out.println("Index controller");
    return new ModelAndView("testVillage", "command", new TestVillage());
  }
  @RequestMapping(value="/saveVillageBean")
  public String saveTestVillageBean(@ModelAttribute("testVillage")TestVillage testVillage,ModelMap model){
    //testVillageService=new TestVillageService();
   // testVillage.setVillageId(25698);
    testVillageService.save(testVillage);
    //BuildSpringEntityManager.getJpaTransactionManager().commit((TransactionStatus) testVillage);
  
    return "success";
    
  }

}
