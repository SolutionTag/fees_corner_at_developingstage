<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
   <head>
		<meta charset="utf-8">
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description">
		<meta content="" name="author">
		<tiles:insertAttribute name="cssfiles"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script>
 function displayDate() {
     var today=new Date();
     var date=today.toISOString().slice(0, -14);
     // Strip last 14 characters, ISO format is like
     // 2012-12-30T17:41:49.027Z but we want
     // 2012-12-30
     document.getElementById("academicianAdmissionDate").value=date;
     document.getElementById("academicianDob").value=date;
  }
 function generateFullName(lastNameObj){
	 var lastName=$("#academicianLastName").val()
	 var firstName=$("#academicianFirstName").val();
	 $("#academicianName").val(lastName.substring(0,1).toUpperCase()+" "+firstName.toUpperCase());
	 
 }
 window.onload = function(){
	 displayDate();
	 
 }
         
     </script>
<title>Insert title here</title>
</head>
    <body>
    <tiles:insertAttribute name="header" />
      <div class="main-container">
        <tiles:insertAttribute name="leftmenu"/>
        
        <div class="main-content">
          <!-- start: PANEL CONFIGURATION MODAL FORM -->
          <tiles:insertAttribute name="panel-config"/>
          <div class="container" style="min-height: 760px;">
            <tiles:insertAttribute name="designtoolbox"/>
         <div class="panel panel-default">
								<div class="panel-heading">
									<i class="clip-user-plus"></i>
									Student Admission
									<div class="panel-tools">
										<a class="btn btn-xs btn-link panel-collapse collapses" href="#">
										</a>
										<a class="btn btn-xs btn-link panel-config" href="#panel-config" data-toggle="modal">
											<i class="fa fa-wrench"></i>
										</a>
										<a class="btn btn-xs btn-link panel-refresh" href="#">
											<i class="fa fa-refresh"></i>
										</a>
										<a class="btn btn-xs btn-link panel-expand" href="#">
											<i class="fa fa-resize-full"></i>
										</a>
										<a class="btn btn-xs btn-link panel-close" href="#">
											<i class="fa fa-times"></i>
										</a>
									</div>
								</div>
							<div class="panel-body">
                            
                            <!--form stepbystep -->
									<form:form modelAttribute="academicianInfo"  role="form" class="smart-wizard form-horizontal" id="form">
										<div id="wizard" class="swMain">
											<ul class="anchor">
												<li>
													<a href="#step-1" class="selected" isdone="1" rel="1">
														<div class="stepNumber">
															1
														</div>
														<span class="stepDesc"> Step 1
															<br>
															<small>Personal Details</small> </span>
													</a>
												</li>
												<li>
													<a href="#step-2" class="disabled" isdone="0" rel="2">
														<div class="stepNumber">
															2
														</div>
														<span class="stepDesc"> Step 2
															<br>
															<small>Education Details</small> </span>
													</a>
												</li>
												<li>
													<a href="#step-3" class="disabled" isdone="0" rel="3">
														<div class="stepNumber">
															3
														</div>
														<span class="stepDesc"> Step 3
															<br>
															<small>Admission Details</small> </span>
													</a>
												</li>
												<li>
													<a href="#step-4" class="disabled" isdone="0" rel="4">
														<div class="stepNumber">
															4
														</div>
														<span class="stepDesc"> Step 4
															<br>
															<small>Details for View</small> </span>
													</a>
												</li>
											</ul>
											
											
											
											
											
									
                            
                            <!--/ form stepbystep -->
                            
                           
							
							
							<div class="stepContainer" style="height: 480px;"><div class="progress progress-striped active progress-sm content">
												<div aria-valuemax="100" aria-valuemin="0" role="progressbar" class="progress-bar progress-bar-info step-bar" style="width: 25%;">
													<span class="sr-only"> 0% Complete (success)</span>
												</div>
											</div><div id="step-1" class="content" style="display: block;">
                                            <!-- start : step1 -->
                                            <div class="row"><!--start row -->
									 <div class="col-md-6"><!-- start 6 -->
										<div class="">
                                          <label class="control-label">
                                            Student First Name
                                            <span class="symbol required"></span>
                                          </label>
                                          <form:input path="academicianFirstName" id="academicianFirstName" onchange="generateFullName();" cssClass="form-control"/>
                                        </div>
									<div class="">
                                          <label class="control-label">
                                            Student Last Name
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:input path="academicianLastName" id="academicianLastName" onchange="generateFullName();" cssClass="form-control"/>
                                        </div>
                                        	<div class="">
                                          <label class="control-label">
                                            Student  Name
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:input path="academicianName" id="academicianName" cssClass="form-control"/>
                                        </div>
								 	<div class="">
                                          <label class="control-label">
                                            Student Gender
                                            <span class="symbol required">
                                       </span>
                                          </label>
													<form:select path="academicianGender"
														cssClass="form-control">
														<form:option value="S">Select</form:option>
														<form:option value="M">Male</form:option>
														<form:option value="F">Female</form:option>
														<form:option value="O">Other</form:option>
													</form:select>
                                        </div>
                                      <div class="">
                                          <label class="control-label">
                                            Student Date of Birth
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                            <form:input path="academicianDob" type="date" cssClass="form-control"/>
                                           
                                       </div>
								<div class="">
                                          <label class="control-label">
                                            Student Blood Group
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                             <form:select path="academicianBloodGroup" cssClass="form-control">
                                         		<form:option value="s">Select</form:option>
												<form:option value="o+">O+</form:option>
												<form:option value="o-">O-</form:option>
												<form:option value="a+">A+</form:option>
												<form:option value="a-">A-</form:option>
												<form:option value="b+">B+</form:option>
												<form:option value="b-">B-</form:option>
												<form:option value="ab+">AB+</form:option>
												<form:option value="ab-">AB-</form:option>
                                            </form:select>
                                   </div>
                                     <div class="">
                                          <label class="control-label">
                                            Student Category
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                          <form:select path="academicianCategory" id="academicianCategory" cssClass="form-control">
                                          <form:option value="S">Select</form:option>
                                          <form:option value="bc">BC</form:option>
                                          <form:option value="mbc">MBC</form:option>
                                          <form:option value="sc">SC</form:option>
                                          <form:option value="st">ST</form:option>
                                         
                                          </form:select>
                                 </div>
                                   	 
									 <div class="">
                                          <label class="control-label">
                                            Student Religion
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                          <form:select path="academicianReligion" id="academicianReligion" cssClass="form-control">
                                          <form:option value="s">Select</form:option>
                                          <form:option value="HINDU">Hinduism</form:option>
                                          <form:option value="ISLAM">Islam</form:option>
                                          <form:option value="CHRIST">Christianity</form:option>
                                          <form:option value="SIKHI">Sikhism</form:option>
                                          <form:option value="BUDDHIS">Buddhism</form:option>
                                          <form:option value="JAINIS">Jainism</form:option>
                                          
                                          </form:select>
                                 </div>
                                   	<div class="">
                                          <label class="control-label">
                                            Guardian First Name
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:input path="academicianGurdianInfo.guardianFirstName" id="guardianFirstName" cssClass="form-control"/>
                                        </div>
                                        
                                         	<div class="">
                                          <label class="control-label">
                                            Guardian Last Name
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:input path="academicianGurdianInfo.guardianLastName" id="guardianLastName" cssClass="form-control"/>
                                        </div>
								                                                                                                                                                             
                                        </div><!-- end 6 -->
                                   
									 <div class="col-md-6"><!-- start 6 -->
									 
									 	<div class="">
                                          <label class="control-label">
                                            Guardian Dob
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:input path="academicianGurdianInfo.guardianDob" id="guardianDob"  type="date" cssClass="form-control"/>
                                        </div>
                                        	<div class="">
                                          <label class="control-label">
                                            Guardian   Occupation
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:select path="academicianGurdianInfo.guardianOccupation" id="guardianOccupation"  cssClass="form-control">
                                          <form:option value="s">Select</form:option>
                                          <form:option value="AGRICULTURE">Agriculture</form:option>
                                          <form:option value="ARCHITECTURE">Architecture</form:option>
                                          <form:option value="BIOLOGICAL">Biological</form:option>
                                          <form:option value="BUSINESS">Business</form:option>
                                          <form:option value="COMMUNICATIONANDJOUNALISM">Communications and Journalism</form:option>
                                          <form:option value="COMPUTERSCIENCE">Computer Sciences</form:option>
                                          <form:option value="EDUCATION">Education</form:option>
                                          <form:option value="ENGINEERING">Engineering</form:option>
                                          <form:option value="LEGAL">Legal</form:option>
                                          <form:option value="LIBERALARTSANDHUMANITIES">Liberal Arts and Humanities</form:option>
                                          <form:option value="MECHANICANDREPAIRTECH">Mechanic and Repair Technologies</form:option>
                                          <form:option value="MEDICALANDHEALTHPROFESSIONS">Medical and Health Professions</form:option>
                                          <form:option value="CULTUREARTSANDPERSONALSERVICE">Culinary Arts and Personal Services</form:option>
                                          <form:option value="MEDICALANDHEALTH">Medical and Health Professions</form:option>
                                          <form:option value="PHYSICALSCIENCE">Physical Sciences</form:option>
                                          <form:option value="PSYCHOLOGY">Psychology</form:option>
                                          <form:option value="TRANSPORTATIONANDDISTRIBUTION">Transportation and Distribution</form:option>
                                          <form:option value="VISUALANDPERFORMINGARTS">Visual and Performing Arts</form:option>
                                          <form:option value="s">Other</form:option>
                                          </form:select>
                                            
                                        </div>
                                        	<div class="">
                                          <label class="control-label">
                                            Guardian Income
                                            <span class="symbol required"></span>
                                          </label>
                                            <form:input path="academicianGurdianInfo.guardianIncome" id="guardianIncome" cssClass="form-control"/>
                                        </div>
                                                                 
									<div class="">
                                          <label class="control-label">
                                            Street name &  Door No
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                           <form:input path="academicianAddress.academicianStreetName" cssClass="form-control" type="text" value=""/>
                                    </div>   
                                       <div class="">
                                          <label class="control-label">
                                            Home Town
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                          <form:input path="academicianAddress.academicianHomeTown"  cssClass="form-control" type="text" value=""/>
                                        </div>
                                    
                                    
                                     <div class="">
                                          <label class="control-label">
                                           District
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                            <form:input path="academicianAddress.academicianDistrict"  cssClass="form-control" type="text" value=""/>
                                        </div>
                                        
                                         <div class="">
                                          <label class="control-label">
                                           State
                                            <span class="symbol required">
                                          </span>
                                          </label>
                                           <form:input path="academicianAddress.academicianState"  cssClass="form-control" type="text" value=""/>
                                        </div>
                                             <div class="">
                                          <label class="control-label">
                                            Student Country
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                           <form:select path="academicianNationality" id="academicianNationality" name="academicianNationality" cssClass="form-control">
												<form:option value="IND">India</form:option>
												<form:option value="OTH">Others</form:option>
											</form:select>
                                          
                                 </div>
                                        <c:forEach items="${academicianInfo.academicianAddress.academicianPhoneNumbersSet}" var="phonenumberset" varStatus="increment">
                                        <div class="">
                                          <label class="control-label">
                                           ${phonenumberset.phoneMode}
                                            <span class="symbol required">
                                          </span>
                                          </label>
                                           <form:input path="academicianAddress.academicianPhoneNumbersSet[${increment.index}].phoneNumber"  cssClass="form-control" type="text"/>
                                        </div>
                                        
                                        </c:forEach>
                                        
                                        
                                        
                                        </div><!-- end 6 -->  
                                        </div><!-- end row -->
                                        <br>
                               
                                        <div>
                                          <span class="symbol required"></span>Required Fields
                                          <hr>
                                        </div>           					 	
												<div class="form-group">
													<div class="col-sm-2 col-sm-offset-8">
														<button type="button" class="btn btn-blue next-step btn-block">
															Next <i class="fa fa-arrow-circle-right"></i>
														</button>
													</div>
												</div>
                                            <!-- end : step1 -->                                                
											</div><div id="step-2" class="content" style="display: none;">
                                            <!-- start : step2 -->                     
                                                <div class="row"><!--start row -->
									 <div class="col-md-6"><!-- start 6 -->
                                          <div class="">
                                          <label class="control-label">
                                           Last Studied School Name
                                            <span class="symbol required">
                                      	 </span>
                                          </label>
                                          <form:input path="academicianPreviousSchoolDetails.lastStudiedSchoolName" name="academicianPreviousSchoolDetails.lastStudiedSchoolName" cssClass="form-control" type="text" value=""/>
                                        </div>
                                        <div class="">
                                          <label class="control-label">
                                            Standrd Passesd
                                            <span class="symbol required">
                                      	 </span>
                                          </label>
                                         <form:select path="academicianPreviousSchoolDetails.standardPassed" name="academicianPreviousSchoolDetails.standardPassed" cssClass="form-control">
                                            <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:if test="${standardDef.statusForChecked==true}">
																<form:option value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></form:option>
																	  </c:if>
																</c:forEach>
											</form:select>
                                        </div>
                                        <div class="">
                                          <label class="control-label">
                                           Studied Medium
                                            <span class="symbol required">
                                      	 </span>
                                          </label>
                                           <form:select path="academicianPreviousSchoolDetails.studiedMedium" cssClass="form-control">
												<form:option value="TAM">Tamil</form:option>
												<form:option value="ENG">English</form:option>
											</form:select>
                                        </div>                                         
                                                                                
                                        </div><!-- end 6 -->  
                                        <div class="col-md-6"><!-- start 6 -->
                                        <div class="">
                                          <label class="control-label">
                                           Studeid From Date 
                                            <span class="symbol required">
                                      	 </span>
                                          </label>
                                         <form:input path="academicianPreviousSchoolDetails.lastSchoolStudiedFrom"  cssClass="form-control" type="date" value=""/>
                                        </div>
                                        <div class="">
                                          <label class="control-label">
                                          Studeid To Date
                                            <span class="symbol required">
                                      	 </span>
                                          </label>
                                          <form:input path="academicianPreviousSchoolDetails.lastSchoolStudiedTo"  cssClass="form-control" type="date" value=""/>
                                        </div>
                                        <div class="">
                                          <label class="control-label">
                                          Reason For Leaving
                                            <span class="symbol required">
                                      	 </span>
                                          </label>
                                         <form:textarea path= "academicianPreviousSchoolDetails.reasonForLeaving"  cssClass="form-control"/>
                                        </div>  
                                        </div><!-- end 6 -->
                                        </div><!-- end row -->
                                          <div>
                                          <span class="symbol required"></span>Required Fields
                                          <hr>
                                        </div>
												<div class="form-group">
													<div class="col-sm-2 col-sm-offset-3">
														<button class="btn btn-light-grey back-step btn-block">
															<i class="fa fa-circle-arrow-left"></i> Back
														</button>
													</div>
													<div class="col-sm-2 col-sm-offset-3">
														<button class="btn btn-blue next-step btn-block">
															Next <i class="fa fa-arrow-circle-right"></i>
														</button>
													</div>
												</div>
                                            <!-- end : step2 -->                                                
											</div><div id="step-3" class="content" style="display: none;">
                                            <!-- start : step3 -->                                            
                                            <div class="row"><!-- start row -->
	                                            <div class="col-md-6"><!-- start 6 -->
                                                <div class="">
                                          <label class="control-label">
                                            Student Admission Number
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                          <form:input path="academicianAdmissionNumber" name="academicianAdmissionNumber" cssClass="form-control" type="text" value="" disabled="disabled"/>
                                        </div>
                                         
									 <div class="">
                                          <label class="control-label">
                                            Student Admission Date
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                       <form:input type="date" path="academicianAdmissionDate" id="academicianAdmissionDate" name="academicianAdmissionDate" cssClass="form-control" />
                                        </div> 
                                       
                                       <div class="">
                                          <label class="control-label">
                                            Student Joining Standard
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                           <form:select path="academicanStandardId" name="academicanStandardId" cssClass="form-control">
                                            <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:if test="${standardDef.statusForChecked==true}">
																<form:option value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></form:option>
																	  </c:if>
																</c:forEach>
											</form:select>
                                        </div> 

                                                </div><!-- end 6 -->
												<div class="col-md-6"><!-- start 6 -->
	                                             <div class="">
                                          <label class="control-label">
                                            Student From
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                   <form:input path="academicianFrom" name="academicianFrom" cssClass="form-control" type="text" value=""/>
                                        </div>
                               <div class="">
                                          <label class="control-label">
                                            Student Travel Method
                                            <span class="symbol required">
                                       </span>
                                          </label>
                                            <form:select path="academicianTravelmMthod" name="academicianTravelmMthod" cssClass="form-control">
												<form:option value="S">Select</form:option>
												<form:option value="PRIVATE">Private Vehicle</form:option>
												<form:option value="SCHOOL">School Bus</form:option>
												<form:option value="PUBLIC">Public Transport</form:option>
											</form:select>
                                </div>   
                                                </div><!-- end 6 -->
                                        </div><!-- end row -->
                                        <br>
                                          <div>
                                          <span class="symbol required"></span>Required Fields
                                          <hr>
                                        </div>
												<div class="form-group">
													<div class="col-sm-2 col-sm-offset-3">
														<button class="btn btn-light-grey back-step btn-block">
															<i class="fa fa-circle-arrow-left"></i> Back
														</button>
													</div>
													<div class="col-sm-2 col-sm-offset-3">
														<button class="btn btn-blue next-step btn-block">
															Next <i class="fa fa-arrow-circle-right"></i>
														</button>
													</div>
												</div>
                                            <!-- end : step3 -->                                                
											</div><div id="step-4" class="content" style="display: none;">
                                            <!-- start : step4 -->                                            
												<h3>Personal</h3>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														First Name:
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianFirstName"></p>
													</div>
												</div>
                                                <!-- add more -->
												<h3>Education</h3>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														Last Studied School Name :
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianPreviousSchoolDetails.lastStudiedSchoolName"></p>
													</div>
												</div>
											 <!-- add more -->
												<h3>Admission</h3>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														Admission Number:
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianAdmissionNumber"></p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														Admission Date:
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianAdmissionDate"></p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														Joining Standard :
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianAdmissionStd"></p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														Student From:
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianFrom"></p>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-3 control-label">
														Student Travel Method:
													</label>
													<div class="col-sm-7">
														<p class="form-control-static display-value" data-display="academicianTravelmMthod"></p>
													</div>
												</div>
                                                <!-- add more -->
                                                <hr>
												<div class="form-group">
													<div class="col-sm-2 col-sm-offset-8">
														<button class="btn btn-success finish-step btn-block">
															Finish <i class="fa fa-arrow-circle-right"></i>
														</button>
													</div>
												</div>
                                            <!-- end : step4 -->                                            
											</div></div><div class="actionBar"><div class="msgBox"><div class="content"></div><a href="#" class="close">X</a></div><div class="loader">Loading</div><a href="#" class="buttonFinish buttonDisabled">Finish</a><a href="#" class="buttonNext">Next</a><a href="#" class="buttonPrevious buttonDisabled">Previous</a></div></div>
											</form:form>
					</div>
                    <!-- end: PANEL -->					
					<!-- end: PAGE CONTENT-->
				</div>
          </div>
          
        </div>
      </div>
      <tiles:insertAttribute name="footer" />
      <tiles:insertAttribute name="jsfiles" />
       <script src="${pageContext.request.contextPath}/resources/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/plugins/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/form-wizard.js"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
		 FormWizard.init();
 });</script>
    </body>
  </html>