/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 10, 2015                        TODO

 */
package com.feescorner.masterdata.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feescorner.masterdata.handlers.LoginHandler;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.solutiontag.entity.masterdata.AdminCredentials;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;

@Controller
public class LoginController {
  @Autowired
  public LoginHandler loginHandler;
  
  @Autowired
  public SchoolCollectionRepository schoolCollectionRepository;
  
  
  @RequestMapping(value="/")
  public String lauchadminLoginScreen(Model model,HttpServletRequest request,HttpServletResponse response){
   
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 1)
    {
        if(cookies[0].getValue().compareTo("solutiontag")==0 && cookies[1].getValue().compareTo("solutiontag")==0)
        {
         SchoolCollection schoolCollection=schoolCollectionRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
          if(schoolCollection !=null){
            ApplicationUtills.setSchoolCollectionObject(schoolCollection);
          }
         
        return "homescreen";
        }
        else
        {
          model.addAttribute("admincredentials", new AdminCredentials());
          return "loginpage";
        }
    }
    model.addAttribute("admincredentials", new AdminCredentials());
    return "loginpage";
  }
  
 @RequestMapping(value="/determineUser",method=RequestMethod.POST)
 public String launchadminMainScreen(@ModelAttribute("admincredentials")AdminCredentials adminCredentials, HttpServletRequest request,HttpServletResponse response){
   Cookie cookie1=new Cookie("adminusername",adminCredentials.getAdminLoginUserName());
   Cookie cookie2=new Cookie("adminpassword",adminCredentials.getAdminLoginPassword());
   response.addCookie(cookie1);
   cookie1.setMaxAge(365 * 24 * 60 * 60);
   cookie2.setMaxAge(365 * 24 * 60 * 60);
   response.addCookie(cookie1);
   response.addCookie(cookie2);
   SchoolCollection schoolCollection=schoolCollectionRepository.findOne("RAdVI SCHOOLCBSEPRE-PRIMARY10337");
   if(schoolCollection !=null){
   ApplicationUtills.setSchoolCollectionObject(schoolCollection);
   }
   //loginHandler.saveLoginCredentials(adminCredentials);
   return "homescreen";
 }
 
 @RequestMapping(value="/logOut")
 public String logOut(Model model,HttpServletRequest request,HttpServletResponse response){
   HttpSession session=request.getSession(false);
   if(request.isRequestedSessionIdValid() && session != null)
   {
       session.invalidate();

   }
   response.setContentType("text/html");
  Cookie[] cookies = request.getCookies();
   for(int j=0;j<cookies.length;j++){
     cookies[j].setComment("EXPIRING COOKIE at " + System.currentTimeMillis());
     cookies[j].setMaxAge(0);
     cookies[j].setValue(null);
     response.addCookie(cookies[j]);
     
   }
   model.addAttribute("admincredentials", new AdminCredentials());
   return "loginpage";
 }
 
 
  
}
