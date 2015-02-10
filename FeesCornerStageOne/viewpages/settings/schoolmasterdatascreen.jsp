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
									<i class="clip-book"></i>
									School Management
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
                <div class="row">
                  <!-- row -->
                  <!-- tab -->
                  <div class="col-sm-12">
                    <div class="tabbable">
                      <ul id="myTab" class="nav nav-tabs tab-bricky">
                        <li class="active">
                          <a href="#panel_tab2_example1" data-toggle="tab">
                            School Creation
                          </a>
                        </li>
                        <li>
                          <a href="#panel_tab2_example2" data-toggle="tab">
                            School Info Upadte
                          </a>
                        </li>
                      </ul>
                      <div class="tab-content">
                        <div class="tab-pane in active" id="panel_tab2_example1">
                          <!--  tab 1 msg-->
                          <div class="panel-group accordion-custom accordion-teal" id="accordion">
                            <div class="panel panel-default">
                              <div class="panel-heading">
                                <h4 class="panel-title">
                                  <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    <i class="icon-arrow">
                                    </i>
                                    Add New School
                                  </a>
                                </h4>
                              </div>
                              <div id="collapseOne" class="panel-collapse collapse">
                                <div class="panel-body">
                                  <!--   Add New School form-->
                                  
                                  <!-- start: FORM School info PANEL -->
                                  <form:form action="${pageContext.request.contextPath}/settings/save-school" modelAttribute="schoolCollection" method="POST">
                                  
                                    <div class="row">
                                      <div class="col-md-12">
                                        <div class="errorHandler alert alert-danger no-display">
                                          <i class="fa fa-times-sign">
                                          </i>
                                          You have some form errors. Please check below.
                                        </div>
                                        <div class="successHandler alert alert-success no-display">
                                          <i class="fa fa-ok">
                                          </i>
                                          Your form validation is successful!
                                        </div>
                                      </div>
                                      <div class="col-md-6">
                                      
                                        <div class="form-group">
                                          <label class="control-label">
                                            School Name 
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                          <form:input path="schoolName" cssClass="form-control" />
                                        </div>
                                      <div class="form-group">
                                          <label class="control-label">
                                           Academic Year
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:select path="academicYear" cssClass="form-control">
											<form:option  value="2015">2014-2015</form:option>
											<form:option value="2014">2013-2014</form:option>
									     </form:select> 
                                       </div>
                                        <div class="form-group">
                                          <label class="control-label">
                                           Fees Paying Terms
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:select path="noOfTerms" cssClass="form-control">
											<form:option  value="2">Two</form:option>
											<form:option value="3">Three</form:option>
											<form:option value="4">Four</form:option>
									     </form:select> 
                                       </div>
                                        <div class="form-group">
                                          <label class="control-label">
                                            Standard of Education 
                                            <span class="symbol required">
                                            </span>
                                          </label>
								          <form:select path="standardOfEducation" cssClass="form-control">
											<form:option  value="PRE-PRIMARY">PRE-PRIMARY-SCHOOL[Ex:Pre-basic Nursery,Kinder Garden,Montessori Schools]</form:option>
											<form:option value="PRIMARY-SCHOOL">PRIMARY-SCHOOL[Ex:"+one+"to"+five+"]</form:option>
											<form:option value="MIDDLE-SCHOOL">MIDDLE-SCHOOL[Ex:"+one+"to"+eight+"/"+six+"to"+eight+"]"</form:option>
											<form:option value="HIGH-SCHOOL">HIGH-SCHOOL[Ex:"+six+"to"+twelve+"/"+one+"to"+twelve+"/"+nine+"to"+twelve+"/"+eleven+"to"+twelve+"(Truncated School)]</form:option>
										</form:select>                                          
                                        </div>
                                           <div class="form-group">
                                          <label class="control-label">
                                       Education Board
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         	<form:select path="educationBoard" cssClass="form-control">
												<form:option value="CBSE">CBSE-central Board for Secondary Education.</form:option>
												<form:option value="MATRIC">Matriculation-Matriculation Board is typically found in in Tamil Nadu and Pondicherry schools.</form:option>
												<form:option value="STATEBOARD">State boards-State Board - Virtually, every state in India has its own board.</form:option>
												<form:option value="ICSE">ICSE-Indian Certificate of Secondary Education.</form:option>
												<form:option value="ISC">ISC - Indian School Certificate</form:option>
												<form:option value="IGCSE">IGCSE (International General Certificate of Secondary Education) is a curriculum spread over classes IX and X. </form:option>
												<form:option value="CAMB-O">Cambridge O-level,O -levels provide a curriculum spread over classes IX and X.</form:option>
												<form:option value="CAMB-A">Cambridge A-level</form:option>
												<form:option value="IB-IB">IB-IB (International Baccalaureate) offers high quality programmes for children from ages 3 to 19.</form:option>
												<form:option value="ISC">ISC - Indian School Certificate</form:option>
												<form:option value="CAMB-A">Cambridge A-level</form:option>
										</form:select>
                                        </div>
                                        
                                        
                                         <div class="form-group">
                                          <label class="control-label">
                                            School Recognized By
                                            <span class="symbol required">
                                            </span>
                                          </label>
								       <form:select path="schoolRecognizedBy" cssClass="form-control">
											<form:option value="SCH-EDU">The Director of School Education</form:option>
											<form:option value="ELEM-EDU">The Director of Elementary Education</form:option>
											<form:option value=" MATRIC-SCH">The Director of Matriculation School</form:option>
										   <form:option value="TCHR-EDU-RSRCH-TR">The Director of Teacher Education ,Research and Training</form:option>
										</form:select>                                          
                                        </div>
                                        <div class="form-group">
                                          <label class="control-label">
                                           Medium of Instruction
                                            <span class="symbol required">
                                            </span>
                                          </label>
								       <form:select path="schoolMediumOfInstruction" cssClass="form-control">
											<form:option value="Tamil">Tamil</form:option>
											<form:option value="English">English</form:option>
											<form:option value="Hindhi">Hindhi</form:option>
										</form:select>                                          
                                        </div>
                                        <div class="form-group">
                                          <label class="control-label">
                                           School Govt Reg Id
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                          		<form:input path="schoolGovernmentRegId" cssClass="form-control"/>
                                          </div>
                                            <div class="form-group">
                                          <label class="control-label">
                                            Is Boarding School 
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                          <form:select path="boardingSchool" cssClass="form-control">
											<form:option value="Y">YES</form:option>
											<form:option value="N">NO</form:option>
										</form:select> 
                                        </div>                                 
                                      </div>
                                      <div class="col-md-6">
                                                                              
                                        <div class="form-group">
                                          <label class="control-label">
                                            School Location 
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:input path="schoolLocation" cssClass="form-control"/>
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                          <label class="control-label">
                                         School Locate District
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:input path="schoolLocatedDistrict" cssClass="form-control" />
                                        </div>
                                        
                                        <div class="form-group">
                                          <label class="control-label">
                                           School Located State<
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:input path="schoolLocatedState" cssClass="form-control" />
                                        </div>
                                       
                                        <div class="form-group">
                                          <label class="control-label">
                                            School E-Mail Id 
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         	<form:input path="schoolEmailId" cssClass="form-control"/>
                                        </div>
                                        
                                         <div class="form-group">
                                          <label class="control-label">
                                           School Phone Numbers
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         	<form:input path="schoolPhoneNumbers"  cssClass="form-control" />
                                        </div>
                                        
                                         <div class="form-group">
                                          <label class="control-label">
                                          School Vision
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         	<form:textarea path="schoolVision" cssClass="form-control" />
                                        </div>
                                        
                                         <div class="form-group">
                                          <label class="control-label">
                                          School Mission
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:textarea path="schoolMission" cssClass="form-control" />
                                        </div>
                                        
                                         <div class="form-group">
                                          <label class="control-label">
                                          School Long Term Goal
                                            <span class="symbol required">
                                            </span>
                                          </label>
                                         <form:input path="schoolLongTermGoal" cssClass="form-control" />
                                        </div>
                                        
                                      </div>
                                    </div>
                                    <div class="row">
                                      <div class="col-md-12">
                                        <div>
                                          <span class="symbol required">
                                          </span>
                                          Required Fields
                                          <hr>
                                        </div>
                                      </div>
                                    </div>
                                    <div class="row">
                                      <div class="col-md-8">
                                        <p>
                                          
                                        </p>
                                      </div>
                                      <div class="col-md-4">
                                        <button class="btn btn-yellow btn-block" type="submit">
                                          Create 
                                        </button>
                                      </div>
                                    </div>
                                 
                                  </form:form>
                                  <!-- end: FORM School info PANEL -->
                                  
                                  <!-- / Add New School form-->
                                </div>
                              </div>
                            </div>
                            <div class="panel panel-default">
                              <div class="panel-heading">
                                <h4 class="panel-title">
                                  <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                    <i class="icon-arrow">
                                    </i>
                                    View School Info
                                  </a>
                                </h4>
                              </div>
                              <div id="collapseTwo" class="panel-collapse collapse in">
                                <div class="panel-body">
                                  <!-- start: View School info PANEL -->
                                  
                                  <div class="row">
                                    <div class="col-md-12">
                                      <div class="errorHandler alert alert-danger no-display">
                                        <i class="fa fa-times-sign">
                                        </i>
                                        You have some form errors. Please check below.
                                      </div>
                                      <div class="successHandler alert alert-success no-display">
                                        <i class="fa fa-ok">
                                        </i>
                                        Your form validation is successful!
                                      </div>
                                    </div>
                                    <div class="col-md-6">
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Name 
                                        </label>
                                        <input type="text" placeholder="" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          Standard of Education 
                                        </label>
                                        <select name="" id="" class="form-control" disabled="disabled">
                                          <option value="">
                                          </option>
                                          <option value="01">
                                            1
                                          </option>
                                        </select>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Established Year
                                        </label>
                                        <input type="text" placeholder="" id="" name="" class="form-control" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Govt Reg ID
                                        </label>
                                        <input type="text" class="form-control" name="" id="" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Location State 
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Location District
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Phone Number 
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      
                                    </div>
                                    <div class="col-md-6">
                                      <div class="form-group">
                                        <label class="control-label">
                                          Board Education 
                                        </label>
                                        <select name="" id="" class="form-control" disabled="disabled">
                                          <option value="">
                                          </option>
                                          <option value="01">
                                            1
                                          </option>
                                        </select>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          Is Boarding School
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Recognized By
                                        </label>
                                        <select name="" id="" class="form-control" disabled="disabled">
                                          <option value="">
                                          </option>
                                          <option value="01">
                                            1
                                          </option>
                                        </select>
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Location 
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Country 
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School Management Name
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                      <div class="form-group">
                                        <label class="control-label">
                                          School E-Mail Id 
                                        </label>
                                        <input type="text" class="form-control" id="" name="" disabled="disabled">
                                      </div>
                                    </div>
                                  </div>
                                  
                                  
                                  <!-- end: View School info PANEL -->
                                  
                                  <hr>
                                  <a href="#panel_tab2_example2" class="btn btn-yellow show-tab">
                                    Edit School Info
                                  </a>
                                  
                                </div>
                              </div>
                            </div>
                          </div>
                          <!-- / tab 1 msg-->
                        </div>
                        <div class="tab-pane" id="panel_tab2_example2">
                          <!--  tab 2 msg-->
                          <!-- start: FORM School info PANEL -->
                          
                          <form action="#" role="form" id="form">
                            <div class="row">
                              <div class="col-md-12">
                                <div class="errorHandler alert alert-danger no-display">
                                  <i class="fa fa-times-sign">
                                  </i>
                                  You have some form errors. Please check below.
                                </div>
                                <div class="successHandler alert alert-success no-display">
                                  <i class="fa fa-ok">
                                  </i>
                                  Your form validation is successful!
                                </div>
                              </div>
                              <div class="col-md-6">
                                <div class="form-group">
                                  <label class="control-label">
                                    School Name 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" placeholder="" class="form-control" id="" name="">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    Standard of Education 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <select name="" id="" class="form-control">
                                    <option value="">
                                    </option>
                                    <option value="01">
                                      1
                                    </option>
                                  </select>
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Established Year 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" placeholder="" id="" name="" class="form-control">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Govt Reg ID 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" name="" id="">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Location State 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Location District 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                
                                <div class="form-group">
                                  <label class="control-label">
                                    School Phone Number 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                
                              </div>
                              <div class="col-md-6">
                                <div class="form-group">
                                  <label class="control-label">
                                    Board Education 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <select name="" id="" class="form-control">
                                    <option value="">
                                    </option>
                                    <option value="01">
                                      1
                                    </option>
                                  </select>
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    Is Boarding School 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                
                                <div class="form-group">
                                  <label class="control-label">
                                    School Recognized By 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <select name="" id="" class="form-control">
                                    <option value="">
                                    </option>
                                    <option value="01">
                                      1
                                    </option>
                                  </select>
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Location 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Country 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School Management Name 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                                <div class="form-group">
                                  <label class="control-label">
                                    School E-Mail Id 
                                    <span class="symbol required">
                                    </span>
                                  </label>
                                  <input type="text" class="form-control" id="" name="">
                                </div>
                              </div>
                            </div>
                            <div class="row">
                              <div class="col-md-12">
                                <div>
                                  <span class="symbol required">
                                  </span>
                                  Required Fields
                                  <hr>
                                </div>
                              </div>
                            </div>
                            <div class="row">
                              <div class="col-md-8">
                                <p>
                                  
                                </p>
                              </div>
                              <div class="col-md-4">
                                <button class="btn btn-yellow btn-block" type="submit">
                                  Update 
                                </button>
                              </div>
                            </div>
                          </form>
                          <!-- end: FORM School info PANEL -->
                          
                          <!-- / tab 2 msg-->
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- /  tab -->
                  
                </div>
                
                <!-- / row -->
                
                
              </div>
            </div>
          </div>
          
        </div>
      </div>
      <tiles:insertAttribute name="footer" />
      <tiles:insertAttribute name="jsfiles" />
    </body>
  </html>