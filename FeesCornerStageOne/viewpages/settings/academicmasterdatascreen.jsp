<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.atg.com/taglibs/json"  prefix="json"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
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
		<tiles:insertAttribute name="jsfiles" />
		<script  src="${pageContext.request.contextPath}/resources/applicationjs/academicmasterdatajs.js"/></script>
		<script  src="${pageContext.request.contextPath}/resources/js/cus.js"/></script>
		<style type="text/css">
     .selectedItem{border: 2px dashed #c0ffee;}
       </style>
		
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
                          
                            <div class="row"><!-- row -->
                            <!-- tab -->
							<div class="col-sm-12">
											<div class="tabbable">
												<ul id="myTab" class="nav nav-tabs tab-bricky">
													<li class="active">
														<a href="#panel_tab2_example1" data-toggle="tab">
															 Standard Declaration
														</a>
													</li>
													<li >
														<a href="#sectionStandardsTab" data-toggle="tab">
															Section Declaration
														</a>
													</li>
													<li >
														<a href="#subjectDefnitionTab" data-toggle="tab">
															Subject Declaration
														</a>
													</li>
													<li >
														<a href="#panel_tab2_example4" data-toggle="tab">
															Subject Assignment
														</a>
													</li>                                                                                                        
												</ul>
												<div class="tab-content">
													<div class="tab-pane in active" id="panel_tab2_example1">
											<!--  tab 1 msg-->
											
											<!--JSON generation Area  -->
											<div id="generateJson" style="display: none;">
											
											 <json:object prettyPrint="true" name="section" escapeXml="true">
														<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
													 <json:array name="${standardDef.standardId}" var="wantedForSubjectAssignment">
															<c:if test="${standardDef.statusForChecked==true}">
																<c:forEach items="${standardDef.sectionSet}"
																	var="sectionDef" varStatus="incrementor">
																	<json:object>
																	<json:property name="sectionId" value="${sectionDef.sectionId}"/>
															       <json:property name="sectionName" value="${sectionDef.sectionName}" />
															       </json:object>
																</c:forEach>
															</c:if>
														<%-- 	
														commented for should not appear not checked standards 
														<c:if test="${standardDef.statusForChecked==false}">
																<c:forEach items="${standardDef.sectionSet}"
																	var="sectionDef" varStatus="incrementor">
																	<json:object>
																	<json:property name="sectionId" value="${sectionDef.sectionId}"/>
															       <json:property name="sectionName" value="${sectionDef.sectionName}" />
															       </json:object>
																</c:forEach>
															</c:if> --%>
															</json:array>
														</c:forEach>
                                                </json:object>
											</div>
                                            
										
											<!--End Area  -->
											
 <!-- start: FORM School info PANEL -->

							 <form:form modelAttribute="schoolMasterDataDefinition" action="${pageContext.request.contextPath}/settings/saveStandard">
							  <form:hidden path="masterDataId"  value="${masterDataId}"/>
										<div class="row">
											<div class="col-md-12">
												<div class="errorHandler alert alert-danger no-display">
													<i class="fa fa-times-sign"></i> You have some form errors. Please check below.
												</div>
												<div class="successHandler alert alert-success no-display">
													<i class="fa fa-ok"></i> Your form validation is successful!
												</div>
											</div>
                                            <div class="checkbox-inline" id="standardsHead">
                                             <div class="row">
														<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
															
															<c:if test="${standardDef.statusForChecked==false}">
															 <div class="col-md-3">
																<label class="checkbox-inline"> <input
																	type="checkbox" class="flat-green"> <form:hidden
																		value="${standardDef.statusForChecked}"
																		data-name="checked"
																		path="schoolStandardsDefnition[${loopStatus.index}].statusForChecked" />
																	<form:hidden value="${standardDef.compareId}"
																		path="schoolStandardsDefnition[${loopStatus.index}].compareId" />
																	<form:hidden value="${standardDef.standardReferenceName}"
																		path="schoolStandardsDefnition[${loopStatus.index}].standardReferenceName" />
																	<form:hidden value="${standardDef.sort}"
																		path="schoolStandardsDefnition[${loopStatus.index}].sort" />
																	<form:hidden value="${standardDef.standardName}"
																		path="schoolStandardsDefnition[${loopStatus.index}].standardName" />
																		<form:hidden value="${standardDef.standardId}"
																		path="schoolStandardsDefnition[${loopStatus.index}].standardId" />
																		
																		
																			<%-- <form:hidden value="${standardDef.defForStandard}"
																		path="schoolStandardsDefnition[${loopStatus.index}].defForStandard" /> --%>
																		
																		
																	<big>${standardDef.standardName}</big>
																</label>
																</div>
															</c:if>
															<c:if test="${standardDef.statusForChecked==true}">
															 <div class="col-md-3">
																<label class="checkbox-inline"> <input type="checkbox"
																	checked="checked" class="flat-green"> <form:hidden
																		value="${standardDef.statusForChecked}"
																		data-name="checked"
																		path="schoolStandardsDefnition[${loopStatus.index}].statusForChecked" />
																	<form:hidden value="${standardDef.compareId}"
																		path="schoolStandardsDefnition[${loopStatus.index}].compareId" />
																	<form:hidden value="${standardDef.standardReferenceName}"
																		path="schoolStandardsDefnition[${loopStatus.index}].standardReferenceName" />
																	<form:hidden value="${standardDef.sort}"
																		path="schoolStandardsDefnition[${loopStatus.index}].sort" />
																	<form:hidden value="${standardDef.standardName}"
																		path="schoolStandardsDefnition[${loopStatus.index}].standardName" />
																	<form:hidden value="${standardDef.standardId}"
																		path="schoolStandardsDefnition[${loopStatus.index}].standardId" />
																		<%-- <form:hidden value="${standardDef.defForStandard}"
																		path="schoolStandardsDefnition[${loopStatus.index}].defForStandard" /> --%>
																	<big>${standardDef.standardName}</big>
																</label>
																</div>
															</c:if>
														</c:forEach>
														 </div>
													</div>
                                            <p style="margin-left:20px;">
												<button class="btn btn-blue" type="button" id="addNewStd">
													Add New 
												</button>
												<button class="btn btn-green" type="submit" id="saveStandards">
													Save 
												</button>
                                      		</p>                                                
                                                		                                      
										</div>
									 </form:form>
                    <!-- end: FORM School info PANEL -->                                                        
														<!-- / tab 1 msg-->                                                    
													</div>
													<div class="tab-pane" id="sectionStandardsTab">
                                                        <!--  tab 2 msg--> 
                                                        <form id="sectionDefinitionForm" method="post">
                                    <c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="loopStatus">    
                                      <c:if test="${standardDef.statusForChecked==true}">            
									           <div class="radio">
				                                    <div class="row"><!--row-->
						                                   <div class="col-md-1" >
																<label>
													             <input type="radio" data-standardid="${standardDef.standardId}" name="enabledStandards"  class="flat-orange">			
																		<big>${standardDef.standardName}</big>
																</label>
						                                     </div>
						                                     <c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
						                                     
						                                      <div class="input_fields_wrap">
						                                     <c:forEach items="${standardDef.sectionSet}" var="sectionDef"  varStatus="incrementor" >
								       	                             <div class="col-md-1">
								           	                          	<span class="input-icon input-icon-right">
								           	                          	<input type="text"  data-sectionname="section" value="${sectionDef.sectionName}" class="form-control ipbox border_ip">
								           	                          	<input type="hidden" name="indexId"  data-standardid="${standardDef.standardId}" value="${sectionDef.compareId}">
								   	            	                     <i class="clip-close-2 remove_field w_ip"></i></span>
								   	            	                     <c:set var="sectionsize" scope="page" value="${sectionDef.maximumStudents}"></c:set>
								                       	             </div>
						                                     </c:forEach> </div>
						                                     <div class="col-md-1">
						                                     		<button type="button" class="btn btn-purple btn-sm add_field_button" ><i class="fa fa-plus"></i></button>
						                                     </div> 	<c:if test="${noofsections==0}" >
						                                       <div class="col-md-1 sectionsize" data-div="sectionsize">
						                                     			<input type="text" data-sectionsize="size"  value=""  class="form-control ipbox border_ip"> 
						                                     </div></c:if>
						                                     <c:if test="${noofsections>0}">
						                                       <div class="col-md-1 sectionsize" data-div="sectionsize">
						                                     			<input type="text" data-sectionsize="size"  value="${sectionsize}"  class="form-control ipbox border_ip"> 
						                                     </div></c:if>
				                                    </div><!-- / row-->
									          </div>
                                    <hr>
                                    </c:if>  
                                  <c:if test="${standardDef.statusForChecked==false}">      
                                       <div class="radio">
                                       <div class="row"><!--row-->
		                                    <div class="col-md-1">
												<label>
													<input type="radio" data-standardid="${standardDef.standardId}" disabled="disabled" class="flat-orange"  name="disableStandards" class="flat-orange">			
														<big>${standardDef.standardName}</big>
												</label>
		                                     </div>
		                                          <c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
		                                     <div class="input_fields_wrap">
		                                      <c:forEach items="${standardDef.sectionSet}" var="sectionDef"  varStatus="incrementor">
				    	                                          <div class="col-md-1">
				        	                         	             <span class="input-icon input-icon-right">
				         	                                       	<input type="text" data-sectionname="section" value="${sectionDef.sectionName}" class="form-control ipbox border_ip"> 
				         	                                        <input type="hidden" name="indexId" data-standardid="${standardDef.standardId}" value="${sectionDef.compareId}">
					            	                                           <i class="clip-close-2 remove_field w_ip"></i></span>
					            	                                             <c:set var="sectionsize" scope="page" value="${sectionDef.maximumStudents}"></c:set>
				                    	                         </div>
				                                              
		                                     </c:forEach> </div>
		                                     <div class="col-md-1">
		                                     		<button type="button" class="btn btn-purple btn-sm" ><i class="fa fa-plus"></i></button>
		                                     </div>
		                                     <c:if test="${noofsections==0}" >
		                                     <div class="col-md-1 sectionsize" data-div="sectionsize" >
						                            <input type="text" data-sectionsize="size" value="" class="form-control ipbox border_ip"> 
						                                     </div></c:if>
						                                      <c:if test="${noofsections>0}" >
		                                     <div class="col-md-1 sectionsize" data-div="sectionsize" >
						                            <input type="text" data-sectionsize="size" value="${sectionsize}" class="form-control ipbox border_ip"> 
						                                     </div></c:if>
                                    </div><!-- / row-->
									</div>
                                        <hr>
                                       </c:if>
                                     </c:forEach> 
                                 
                                 	   <p style="margin-left:20px;">
											<!-- 	<button class="btn btn-green" type="button" id="saveSecitons">
													Save 
												</button> -->
												<div class="row">
											<div class="col-md-8">
												<p>
													
												</p>
											</div>
											<div class="col-md-4">
												<button class="btn btn-green btn-block" type="button" id="saveSecitons">
													Save Section 
												</button>
											</div>
										</div>
												
                                      		</p> 
                                 
                                  </form>
                                       
                                     
														<!-- / tab 2 msg--> 
														
													
													</div>
												
												
													
													<div class="tab-pane" id="subjectDefnitionTab">
                                                        <!--  tab 3 msg--> 
 <div class="panel-group accordion-custom accordion-teal" id="accordion">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
													<i class="icon-arrow"></i>
													Add New Subject
												</a></h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse">
												<div class="panel-body">
													<!--   Add New Subject form--> 
 <!-- start: FORM Subject PANEL --><!--  action="${pageContext.request.contextPath}/settings/saveSubject" -->
						 
								<form id="subjectDeclartionForm" method="post" >
										<div class="row">
											<div class="col-md-12">
												<div class="errorHandler alert alert-danger no-display">
													<i class="fa fa-times-sign"></i> You have some form errors. Please check below.
												</div>
												<div class="successHandler alert alert-success no-display">
													<i class="fa fa-ok"></i> Your form validation is successful!
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">
														Subject Name <span class="symbol required"></span>
													</label>
													<input type="text" name="subjectName" id="subjectName" class="form-control">
												</div>  
                                              </div>
                                              <div class="col-md-6">                                          
												<div class="form-group">
													<label class="control-label">
														Subject ID <span class="symbol required"></span>
													</label>
													<input type="text" name="subjectRefId" id="subjectRefId" class="form-control">
													<!-- <input type="hidden" name="subjectRefId" id="subjectPreferreStd" class="form-control"> -->
												</div>
                                                </div>
                                                <div class="col-md-12">
												<div class="form-group connected-group">
													<label class="control-label">
														Standard Preferred</span>
													</label>
													<div class="row">
													<div class="col-md-3">
														<%-- <form:select path="subjectPreferreStd" multiple="false" id="preferredFrom" cssClass="form-control"> --%>
														<select class="form-control" name="preferredFrom" id="preferredFrom">
															 <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:if test="${standardDef.statusForChecked==true}">
																<option value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></option>
																	  </c:if>
																</c:forEach>
														</select>
														</div> 
                                                        <div class="col-md-1">
                                                        <big>To</big>
                                                        </div>
														<div class="col-md-3">
														<%-- <form:select path="subjectPreferreStd" multiple="false" id="preferredFrom" cssClass="form-control"> --%>
														<select class="form-control" name="preferredTo" id="preferredTo">
															 <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:if test="${standardDef.statusForChecked==true}">
																<option value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></option>
																	  </c:if>
													       </c:forEach>
													</select>
														</div> 
													</div>
												</div>
                                                </div>
											
										</div>
										<div class="row">
											<div class="col-md-12">
												<div>
													<span class="symbol required"></span>Required Fields
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
												<button class="btn btn-green btn-block" id="savesubject" type="button">
													Create 
												</button>
											</div>
										</div>
									</form>
                    <!-- end: FORM Subject PANEL -->                                                                                                      
                                                    <!-- / Add New Subject form-->
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
													<i class="icon-arrow"></i>
													View Subject
												</a></h4>
											</div>
											<div id="collapseTwo" class="panel-collapse collapse in">
												<div class="panel-body">
 <!-- start: View Subject PANEL -->
									<table class="table table-striped table-bordered table-hover table-full-width" id="sectionDeclarationTable">
									<thead></thead>
									<tbody></tbody>
										<!-- <thead>
											<tr>
												<th>Subject Name</th>
												<th class="hidden-xs">Subject ID</th>
												<th>Standard Preferred</th>
												<th class="hidden-xs">Action</th>
											</tr>
										</thead> -->
							<!-- 			<tbody>
											<tr>
												<td>Enterprise Resource Planning</td>
												<td class="hidden-xs">ERP</td>
												<td>9 To 10</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>                                                
											</tr>
											<tr>
												<td>Visual Basic</td>
												<td class="hidden-xs">VB</td>
												<td>8</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>												
											</tr>
											<tr>
												<td>Social Science</td>
												<td class="hidden-xs">SS</td>
												<td>1 To 10</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>												
											</tr>
											<tr>
												<td>Genral English</td>
												<td class="hidden-xs">GE</td>
												<td>1 To 9</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>												
											</tr>
											<tr>
												<td>Genral Tamil</td>
												<td class="hidden-xs">GT</td>
												<td>1 To 9</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>
												
											</tr>
											
										</tbody> -->
									</table>
 
  <!-- end: View Subject PANEL -->													
                                                                                                       
												</div>
											</div>
										</div>
									</div>                                                        
														<!-- / tab 3 msg--> 
													</div>
													<div class="tab-pane" id="panel_tab2_example4">
                                                        <!--  tab 4 msg--> 
 <div class="panel-group accordion-custom accordion-teal" id="accordion4">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion4" href="#collapseOne4">
													<i class="icon-arrow"></i>
													Add New Subject Assignment
												</a></h4>
											</div>
											<div id="collapseOne4" class="panel-collapse collapse">
												<div class="panel-body">
													<!--   Add New Subject form--> 
 <!-- start: FORM Subject PANEL -->
							<form action="#" role="form" id="form">
										<div class="row">
											<div class="col-md-12">
												<div class="errorHandler alert alert-danger no-display">
													<i class="fa fa-times-sign"></i> You have some form errors. Please check below.
												</div>
												<div class="successHandler alert alert-success no-display">
													<i class="fa fa-ok"></i> Your form validation is successful!
												</div>
											</div>
                                                <div class="row">
                                                <div class="col-md-12">
														<div class="col-md-3">
                                           <div class="form-group" id="standardDiv">
													<label class="control-label">
														Select Standard Name <span class="symbol required"></span>
													</label>
														<select class="form-control" name="standard" id="standardList">
															 <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:if test="${standardDef.statusForChecked==true}">
																<option data-standardid="${standardDef.standardId}"  value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></option>
																	  </c:if>
																</c:forEach>
														</select>
                                               </div>
												</div>
														<div class="col-md-3"> 
                                                        <div class="form-group">                                               
													<label class="control-label">
														Select Section Name <span class="symbol required"></span>
													</label>

															<select name="sectionList" id="sectionList" class="form-control">
																<option value="111">All</option>
																
															</select>
                                                            </div>
												</div>                                                
                                           </div>
                                           </div>
                                               
                                               
                                        <div class="col-lg-12">
                                           <!--start drag & drop section -->
                                        <div class="row"><!--start row-->
											<div class="col-md-6">
												<!-- start:  PANEL -->
												Assigned Subjects <span class="symbol required"></span>
												<ul
													class="alert panel-box list-inline cond ui-sortable"
													id="draggable-list1" style="cursor: move;">
												</ul>
											</div>
											<div class="col-md-6">
									<!-- start:  PANEL -->Available Subjects 
										            <ul class="alert panel-box list-inline cond ui-sortable" id="draggable-list2" style="cursor:move;">
										             <c:forEach var="subject" items="${schoolMasterDataDefinition.schoolSubjectsDefinition}" varStatus="standardLoop1">
									                           <li data-validforstore="true" class="label label-default ui-sortable-handle" data-value="${subject.compareId}" title="${subject.subjectName}" style="margin:5px;"><span class="h4">${subject.subjectName}</span></li>
													</c:forEach>
									                      </ul>
												</div>                  
</div><!--end row-->
                                           <!--end drag & drop section-->   
                                           </div>
											
										</div>
										<div class="row">
											<div class="col-md-12">
												<div>
													<span class="symbol required"></span>Required Fields
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
												<button class="btn btn-green btn-block" type="button" id="subjectAssignmentSave">
													Create 
												</button>
											</div>
										</div>
									</form>
                    <!-- end: FORM Subject PANEL -->                                                                                                      
                                                    <!-- / Add New Subject form-->
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#collapseTwo4">
													<i class="icon-arrow"></i>
													View Subject Assignment
												</a></h4>
											</div>
											<div id="collapseTwo4" class="panel-collapse collapse in">
												<div class="panel-body">
 <!-- start: View Subject PANEL -->
									<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
										<thead>
											<tr>
												<th>Standard Name</th>
												<th class="hidden-xs">Assigned Subject</th>
												<th class="hidden-xs">Action</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><big>&#8549;</big></td>
												<td class="hidden-xs">ERP, VB, CPP, J2EE</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>                                                
											</tr>
											<tr>
												<td><big>&#8544;</big></td>
												<td class="hidden-xs">VB, GE, GT, PT, SS</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>												
											</tr>
											<tr>
												<td><big>&#8550;</big></td>
												<td class="hidden-xs">SS, C, VB</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>												
											</tr>
											<tr>
												<td><big>&#8545;</big></td>
												<td class="hidden-xs">GE, GT, SQL, PHP, Mysql</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>												
											</tr>
											<tr>
												<td><big>&#8553;</big></td>
												<td class="hidden-xs">GT, SS, ST, ERP, CA</td>
                                                <td class="center">
												<div class="visible-md visible-lg hidden-sm hidden-xs">
													<a href="#" class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit"><i class="fa fa-edit"></i></a>
													<a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-edit"></i> Edit
																</a>
															</li>
															<li role="presentation">
																<a role="menuitem" tabindex="-1" href="#">
																	<i class="fa fa-times"></i> Remove
																</a>
															</li>
														</ul>
													</div>
												</div></td>
												
											</tr>
											
										</tbody>
									</table>
 
  <!-- end: View Subject PANEL -->													
                                                                                                       
												</div>
											</div>
										</div>
									</div>                                                                
														<!-- / tab 4 msg--> 
													</div>
												</div>
											</div>
										</div><!-- /  tab -->	
                                        </div> <!-- / row -->
							
							
							</div>
					</div>
          </div>
          
        </div>
      </div>
      <tiles:insertAttribute name="footer" />
      
    </body>
  </html>