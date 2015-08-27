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
		 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angularcontrollers/masterdata.angular.js"></script>
		<script  src="${pageContext.request.contextPath}/resources/js/cus.js"/></script>
		<style type="text/css">
     .selectedItem{border: 2px dashed #c0ffee;}
       </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <body >
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
														<a href="#standarddeclaration" data-toggle="tab">
															 Standard Declaration
														</a>
													</li>
													<li >
														<a href="#groupcreation" data-toggle="tab">
															Vocational Standard Group  
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
														<a href="#subjectassignment" data-toggle="tab">
															Subject Assignment
														</a>
													</li>                                                                                                        
												</ul>
												<div class="tab-content" ng-app="academic_master_data"  >
													<div class="tab-pane in active" id="standarddeclaration">
											<!--  tab 1 msg-->
											<!--JSON generation Area  -->
										 <div id="generateJsonOne" style="display: none;">
										 ${applicationStringJsons.prerequisitesForSubjectAssignment}
											<%--  <json:object prettyPrint="true" name="section" escapeXml="true">
														<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
													 <json:array name="${standardDef.standardId}" var="wantedForSubjectAssignment">
															<c:if test="${standardDef.statusForChecked==true}">
																<c:forEach items="${standardDef.sectionSet}"
																	var="sectionDef" varStatus="incrementor">
																	<json:object>
																	<json:property name="sectionId" value="${sectionDef.compareId}"/>
															        <json:property name="sectionName" value="${sectionDef.sectionName}" />
															       </json:object>
																</c:forEach>
															</c:if>
															</json:array>
														</c:forEach>
                                                </json:object> --%>
											</div>
											<div id="generateJsonTwo" style="display: none;">
											${applicationStringJsons.prerequisitesForVocationalGroupAssignment}
													<%-- <json:object>
														<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
															<json:array items="${standardDef.groupSet}" var="vocationalgroupassignment" name="${standardDef.standardId }">
																		<json:object>
																	      <json:property name="derivedcompareid" value="${vocationalgroupassignment.compareId}"/>
																	      <json:property name="status" value="${vocationalgroupassignment.groupEnabled}"/>
																	       <json:property name="basegroupcompareid" value="${vocationalgroupassignment.baseGroupId}"/>
																	    </json:object>
															</json:array>
														</c:forEach>
													</json:object> --%>

											</div>
											<div id="generateJsonThree" style="display: none">
											${applicationStringJsons.prerequisitesForVocationalGroupSubjectAssignment}
											<%-- 	 <json:object prettyPrint="true" name="" escapeXml="true">
												<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
													 <json:object name="${standardDef.standardId}" >
															<c:if test="${standardDef.statusForChecked==true}">
																<c:forEach items="${standardDef.groupSet}"
																	var="vocationalgroup" varStatus="incrementor">
																	<c:if test="${vocationalgroup.groupEnabled==true && fn:length(vocationalgroup.sectionSet)!=0 }">
																		<json:array  name="${vocationalgroup.compareId}" var="groupid">
																		<c:forEach items="${vocationalgroup.sectionSet }"
																	var="groupsection" varStatus="incrementor">
																			<json:object>
																				<json:property name="sectionId"
																					value="${groupsection.compareId}" />
																				<json:property name="sectionName"
																					value="${groupsection.sectionName}" />
																			</json:object>
																			</c:forEach>
																		</json:array>
																	</c:if>
																		<json:object name="${vocationalgroup.compareId}"> 
																			<json:property name="groupname">${vocationalgroup.groupName}</json:property>
																			</json:object>
																	</c:forEach>
															</c:if>
															</json:object>
													</c:forEach>
                                                </json:object> --%>
											</div>
                                            <div id="generateJsonFour" style="display: none">
                                            ${applicationStringJsons.prerequisitesForGroupMetaInfo}
											<%-- 	<json:object prettyPrint="true" name="" escapeXml="true">
												<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
															<c:if test="${standardDef.statusForChecked==true}">
																<c:forEach items="${standardDef.groupSet}"
																	var="vocationalgroup" varStatus="incrementor">
																		<json:object name="${vocationalgroup.compareId}"> 
																			<json:property name="groupname">${vocationalgroup.groupName}</json:property>
																		</json:object>
																	</c:forEach>
															</c:if>
													</c:forEach>
                                                </json:object> --%>
											</div>
											<form:form modelAttribute="applicationStringJsons">
												<spring:bind
													path="applicationStringJsons.standardJsonObjectAsString">
													<div id="${status.expression}" style="display: none">
														${status.value}</div>
												</spring:bind>
												<spring:bind
													path="applicationStringJsons.vocationalGroupJsonObjectAsString">
													<div id="${status.expression}" style="display: none">
														${status.value}</div>
												</spring:bind>
											</form:form>
 										
											<!--End Area  -->
											
 <!-- start: FORM School info PANEL -->

							 <form:form modelAttribute="setDefinitions" action="${pageContext.request.contextPath}/settings/saveStandard">
										<div class="row">
											<div class="col-md-12">
												<div class="errorHandler alert alert-danger no-display">
													<i class="fa fa-times-sign"></i> You have some form errors. Please check below.
												</div>
												<div class="successHandler alert alert-success no-display">
													<i class="fa fa-ok"></i> Your form validation is successful!
												</div>
											</div>
                                            <div class="checkbox-inline"  id="standardsHead">
                                 <%--             <div class="row" id="standarddiv">
														<c:forEach var="standardDef"
															items="${setDefinitions.standardDefList}"
															varStatus="loopStatus">
															<spring:bind path="schoolMasterDataDefinition.schoolStandardsDefnition[${loopStatus.index}].standardId"></spring:bind>
															<c:if test="${standardDef.statusForChecked==false}">
															 <div class="col-md-3">
																<label class="checkbox-inline"> <input
																	type="checkbox" class="flat-green"> 
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].statusForChecked">
															<input  name="<c:out value="${status.expression}"/>" data-name="checked" value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].compareId">
															<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
													   </spring:bind>
										  				<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].standardReferenceName">
																		<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
													   </spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].sort">
																	<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].standardName">
																	<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].standardId">
																		<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
																		
																		
																			<form:hidden value="${standardDef.defForStandard}"
																		path="schoolStandardsDefnition[${loopStatus.index}].defForStandard" />
																		
																		
																	<big>${standardDef.standardName}</big>
																</label>
																</div>
															</c:if>
															<c:if test="${standardDef.statusForChecked==true}">
															 <div class="col-md-3">
																<label class="checkbox-inline"> <input type="checkbox"
																	checked="checked" class="flat-green">	
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].statusForChecked">
															<input  name="<c:out value="${status.expression}"/>" data-name="checked" value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].compareId">
															<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
													   </spring:bind>
										  				<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].standardReferenceName">
																		<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
													   </spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].sort">
																	<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].standardName">
																	<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
														<spring:bind path="setDefinitions.standardDefList[${loopStatus.index}].standardId">
																		<input  name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" type="hidden">
														</spring:bind>
																		<form:hidden value="${standardDef.defForStandard}"
																		path="schoolStandardsDefnition[${loopStatus.index}].defForStandard" />
																	<big>${standardDef.standardName}</big>
																</label>
																</div>
															</c:if>
														</c:forEach>
														 </div> --%>
							<div class="row" id="standarddivloop"  ng-controller="standardController">
							 <div class="col-md-3" ng-repeat="standard in standards track by $index | orderBy:'standard.sort'"  >
								   <label class="checkbox-inline"><big>{{standard.standardName}}</big>
								<input type="checkbox" checked="checked" class="flat-green" ng-if=standard.statusForChecked==true>
								<input type="checkbox" class="flat-green" ng-if=standard.statusForChecked==false>
								<input  name=standardDefList[{{$index}}].statusForChecked  data-id="checked"  value="{{standard.statusForChecked}}" type="hidden">
								<input  name=standardDefList[{{$index}}].compareId type="hidden" value="{{standard.compareId}}">
								<input  name=standardDefList[{{$index}}].standardReferenceName type="hidden" value="{{standard.standardReferenceName}}" >
								<input  name=standardDefList[{{$index}}].sort  type="hidden" value="{{standard.sort}}">
								<input  name=standardDefList[{{$index}}].standardName type="hidden" value="{{standard.standardName}}">
								<input  name=standardDefList[{{$index}}].standardId" type="hidden" value="{{standard.standardId}}">
									</label>
							</div>
							</div>
				</div>
                                           <div class="col-md-4">
												<button class="btn btn-green" type="submit"   id="saveStandards">
													Save 
												</button>
                                      		</div>                                              
                                                		                                      
										</div>
									 </form:form>
									 <br>
									<div class="row">
                                     <div class="col-md-12">
                                     <div class="col-md-4 no-display" id="addnewip">
                                     <form:form method="post" modelAttribute="standardFormModelAttribute" id="standardform" action="${pageContext.request.contextPath}/settings/add-new-standard">
                                          <div class="input-group">
                                          <form:input path="standardName" cssClass="form-control tipmsg" placeholder="Standard Name" />
                                          <form:hidden path="sort"  value= "${fn:length(schoolMasterDataDefinition.schoolStandardsDefnition) + 1}" />
                                           <span class="input-group-btn">
                                         <button class="btn btn-info" id="addstandard" type="submit" style="height: 34px;">
                                         <span class="clip-checkmark-2"></span></button>
                                           </span>
                                         </div>
                                         </form:form>
                                     </div>
                                          <button class="btn btn-danger no-display" type="button" id="bcktocreate" style="height: 34px;">
                                             <span class="clip-close"></span>
                                         </button>
                                         <button class="btn btn-blue" type="button" id="openstandardform">Add New</button>
                                     </div>    
                                       </div>
                    <!-- end: FORM School info PANEL -->                                                        
														<!-- / tab 1 msg-->                                                    
													</div>
														<div class="tab-pane in " id="groupcreation">
                                                  <!--  tab 1 msg-->
 <div class="panel-group accordion-custom accordion-teal" id="accordion">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
													<i class="icon-arrow"></i>
													Vocational Standard Group Creation
												</a></h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse">
												<div class="panel-body">
													<!--   Add New School form--> 
 <!-- start: FORM School info PANEL -->
							<form id="vocationalgroupdef"  role="form" action="/fcds/settings/creategroup" method="post" ng-controller="vocationalGroupDefinition">
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
														Group Name <span class="symbol required"></span>
													</label>
													<input type="text" placeholder="" class="form-control" id=groupName name="groupName">
												</div>
												<div class="form-group">
													<label class="control-label">
														Group Definition <span class="symbol required"></span>
													</label>
													<textarea rows="" cols="" class="form-control" id="groupDefinition" name="groupDefinition"></textarea>
													
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
										<div class="row" >
											<div class="col-md-8">
												<p>
													
												</p>
											</div>
											<div class="col-md-4">
												<button class="btn btn-yellow btn-block" ng-click="vocationGroupFormSubmit()" id="vocationalGroupSave" type="button">
													Create 
												</button>
											</div>
										</div>
									</form>
                    <!-- end: FORM School info PANEL -->                                                                                                      
                                                    <!-- / Add New School form-->
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#groupAssign">
													<i class="icon-arrow"></i>
														Vocational Standard Group  Assign
												</a></h4>
											</div>
											<div id="groupAssign" class="panel-collapse collapse">
												<div class="panel-body">
													<!--   Add New Subject form--> 
 <!-- start: FORM Subject PANEL -->
							
									<form action="#" role="form" id="vocationGroupAssingForm"   name="vocationGroupAssingForm" ng-controller="vocationalGroupAssignController">
										<div class="row">
											<div class="col-md-12">
												<div class="errorHandler alert alert-danger no-display">
													<i class="fa fa-times-sign"></i> You have some form errors. Please check below.
												</div>
												<div class="successHandler alert alert-success no-display">
													<i class="fa fa-ok"></i> Your form validation is successful!
												</div>
											</div>
                                                <div class="col-md-12">
												<div class="form-group connected-group">
													<label class="control-label">
														Select Standard Name <span class="symbol required"></span>
													</label>
													<div class="row">
														<div class="col-md-3">
															<%-- 	<select class="form-control" name="standardsforassigngroup" id="standardsforassigngroup">
															 <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:if test="${standardDef.statusForChecked==true}">
																<c:choose>
																<c:when test="${fn:length(standardDef.sectionSet) !=0}">
																<option data-issectionexit="true" data-standardid="${standardDef.standardId}" value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></option>
																</c:when>
																<c:when test="${fn:length(standardDef.sectionSet) ==0}">
																<option data-issectionexit="false" data-standardid="${standardDef.standardId}" value="${standardLoop1.index+1}"><big>${standardDef.standardName}</big></option>
																</c:when>
																</c:choose>
																
																	  </c:if>
																</c:forEach>
														</select> --%>
														<select  class="form-control" novalidate="" name="standardsforassigngroup" id="standardsforassigngroup" >
														 <option value="">Select Standard</option> 
														 <option data-issectionexit="false"  ng-if="schoolStandards.statusForChecked==true && schoolStandards.sectionSet.length==0" ng-repeat=" schoolStandards in schoolStandardBeanAsJson track by $index | orderBy:'standard.sort'" data-standardid="{{schoolStandards.standardId}}" value="{{$index+1}">
														 <big>{{schoolStandards.standardName}}</big>
														 </option>
														  <option data-issectionexit="false"  ng-if="schoolStandards.statusForChecked==true && schoolStandards.sectionSet.length!=0" ng-repeat=" schoolStandards in schoolStandardBeanAsJson track by $index | orderBy:'standard.sort'" data-standardid="{{schoolStandards.standardId}}" value="{{$index+1}">
														  <big>{{schoolStandards.standardName}}</big>
														  </option>
														</select>
														<!--  <span class="error" ng-show="vocationGroupAssingForm.standardsforassigngroup.$dirty && vocationGroupAssingForm.standardsforassigngroup.$dirty">Select Standard</span> -->
														</div>
													</div>
												</div>
                                                </div>
                                         <div class="checkbox-inline">
                                        <h4><label class="label label-default">Available Vocational Groups </label></h4>
                            <div class="row" id="vocationalgrouplists"  >
                                   <%--   <c:forEach var="vocational" items="${schoolMasterDataDefinition.vocatinalGroupDefSet}" varStatus="loopStatus">
									<div class="col-md-3" >
										<label class="checkbox-inline"> 
											<input  data-derivedcompareid=""  data-basegroupcompareid="${vocational.compareId}" type="checkbox" class="flat-green">
															<big>${vocational.groupName}</big>
															
										</label>
									</div>
									</c:forEach> --%>
									<div class="col-md-3"   ng-repeat="vocationalGroup in vocationalGroupList track by $index" >
										<label class="checkbox-inline"> 
											<input  type="checkbox" class="flat-green"  data-basegroupcompareid="{{vocationalGroup.compareId}}">
															<big>{{vocationalGroup.groupName}}</big>
										</label>
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
												<button class="btn btn-green btn-block" type="button" id="assignvocationaltostandards">
													Assign 
												</button>
											</div>
										</div>
									</form>
                    <!-- end: FORM Subject PANEL -->                                                                                                      
                                                    <!-- / Add New Subject form-->
												</div>
											</div>										</div>
									</div>
                                                  <!-- / tab 1 msg-->
													</div>
<div class="tab-pane" id="sectionStandardsTab">
   <input type="hidden" id="masterDataId" value="${schoolMasterDataDefinition.masterDataId}">    
 <form id="sectionDefinitionForm" method="post"  ng-controller="standardController">   
 <div class="" ng-if="standard.statusForChecked==true" ng-repeat="standard in standards track by $index | orderBy:'standard.sort'">
	   <div class="row" data-isgroupenabled="{{standard.groupassigned}}" ng-if=standard.statusForChecked==true data-standardid="{{standard.standardId}}"><!--group wise head row-->
			 <div class="col-md-2">
				<h4><label class="label label-teal">{{standard.standardName}}</label></h4>
			</div>
		</div>
		
<!-- / group wise head row-->
<div class=""  ng-if=standard.groupassigned==true ng-repeat="groups in standard.groupSet track by $index">
			<div class="row" data-name="sectionrow" ng-if=groups.groupEnabled==true  data-standardid="{{standard.standardId}}"><!-- / group1 wise row-->
							<div class="col-md-2" data-groupcompareid="{{groups.compareId}}" data-ishavinggroup="yes">
								<center>
									<label> <big>{{groups.groupName}}</big>
									</label>
								</center>
							</div>
							<div class="input_fields_wrap" data-name="groupassignedsections">
								   <div class="col-md-1" ng-repeat="groupsection in groups.sectionSet track by $index">
	             						<span class="input-icon input-icon-right">
	             						<input type="text"  data-sectionname="section" value="{{groupsection.sectionName}}" class="form-control ipbox border_ip">
	              						<input type="hidden" name="indexId"  data-groupcompareid="{{groups.compareId}}" data-standardid="{{standardDef.standardId}}" value="{{groupsection.compareId}}">
	               						<i class="clip-close-2 remove_field"></i></span>
									</div>
							</div>
							<div class="col-md-1">
								<button type="button"
									class="btn btn-purple btn-sm add_field_button">
									<i class="fa fa-plus"></i>
								</button>
							</div>
                             <div class="col-md-1 sectionsize" ng-if="groups.sectionSet.length==0" data-div="sectionsize">
                            			<input type="text" data-sectionsize="size"  value=""  class="form-control ipbox border_ip"> 
                            </div>
                           
                             <div class="col-md-1 sectionsize" ng-if="groups.sectionSet.length>0" data-div="sectionsize">
                            			<input type="text" data-sectionsize="size" value="{{groups.sectionSet[0].maximumStudents}}" ng-bind="{{maximumStudentInSection}}"  class="form-control ipbox border_ip"> 
                             </div>
		 </div>	
<br ng-if=groups.groupEnabled==true><hr ng-if=groups.groupEnabled==true></div>
 <div class="row" data-name="sectionrow" ng-if=standard.groupassigned==false data-standardid="{{standard.standardId}}"  >
 <br> <!-- / std row-->
 				<div class="col-md-1"></div>
						<div class="input_fields_wrap">
						             <div class="col-md-1" ng-repeat="sectionDef in standard.sectionSet">
							             	<span class="input-icon input-icon-right">
							             	<input type="text"  data-sectionname="section" value="{{sectionDef.sectionName}}" class="form-control ipbox border_ip">
							              	<input type="hidden" name="indexId"  data-standardid="{{standardDef.standardId}}" value="{{sectionDef.compareId}}">
							               <i class="clip-close-2 remove_field"></i></span>
						             </div>
						</div>
						 <div class="col-md-1">
						 		<button type="button" class="btn btn-purple btn-sm add_field_button" ><i class="fa fa-plus"></i></button>
						 </div>
                		 <div class="col-md-1 sectionsize" ng-if=standard.sectionSet.length==0 data-div="sectionsize">
               					<input type="text" data-sectionsize="size"  value=""  class="form-control ipbox border_ip"> 
              			 </div>
                 		 <div class="col-md-1 sectionsize" ng-if="standard.sectionSet.length>0" data-div="sectionsize">
               					<input type="text" data-sectionsize="size"  value="{{standard.sectionSet[0].maximumStudents}}"  class="form-control ipbox border_ip"> 
               			</div>
</div><hr ng-if=standard.groupassigned==false><!-- / std row-->
 </div>
 
 
                                           <!--  tab 2 msg--> 
<%-- <c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="loopStatus">
 <c:if test="${standardDef.statusForChecked==true}">            
		<div class="row" data-isgroupenabled="${standardDef.groupassigned}" data-standardid="${standardDef.standardId}">
		<!--group wise head row-->
			 <div class="col-md-2">
				<h4><label class="label label-teal">${standardDef.standardName}</label></h4>
			</div>
		</div>
<c:if test="${standardDef.groupassigned==true}">
<br><!-- / group wise head row-->
<c:forEach items="${standardDef.groupSet}" var="groups">
<c:if test="${groups.groupEnabled==true}">
			<div class="row" data-name="sectionrow"  data-standardid="${standardDef.standardId}"  ><!-- / group1 wise row-->
					<div class="col-md-2" data-groupcompareid="${groups.compareId}" data-ishavinggroup="yes">
						<center>
							<label> <big>${groups.groupName}</big>
							</label>
						</center>
					</div>
					<c:set var="noofsections" value="${fn:length(groups.sectionSet)}" />
							<div class="input_fields_wrap" data-name="groupassignedsections">
														<c:forEach items="${groups.sectionSet}" var="groupsection">
																		<div class="col-md-1">
											             						<span class="input-icon input-icon-right">
											             						<input type="text"  data-sectionname="section" value="${groupsection.sectionName}" class="form-control ipbox border_ip">
											              						<input type="hidden" name="indexId"  data-groupcompareid="${groups.compareId}" data-standardid="${standardDef.standardId}" value="${groupsection.compareId}">
											               						<i class="clip-close-2 remove_field"></i></span>
											              						<c:set var="sectionsize" scope="page" value="${groupsection.maximumStudents}"></c:set>
         															   </div>
														</c:forEach>
								</div>
																		<div class="col-md-1">
																			<button type="button"
																				class="btn btn-purple btn-sm add_field_button">
																				<i class="fa fa-plus"></i>
																			</button>
																		</div>
																		 <c:if test="${noofsections==0}" >
						                                       <div class="col-md-1 sectionsize" data-div="sectionsize">
						                                     			<input type="text" data-sectionsize="size"  value=""  class="form-control ipbox border_ip"> 
						                                     </div></c:if>
						                                     <c:if test="${noofsections>0}">
						                                       <div class="col-md-1 sectionsize" data-div="sectionsize">
						                                     			<input type="text" data-sectionsize="size"  value="${sectionsize}"  class="form-control ipbox border_ip"> 
						                                     </div></c:if>
		 </div>	<br></c:if>
</c:forEach>
				<br><hr>
      </c:if>
<c:if test="${standardDef.groupassigned==false}">
<br>
 <div class="row" data-name="sectionrow" data-standardid="${standardDef.standardId}" ><!-- / std row-->
 <div class="col-md-1">
 </div>
  <c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
<div class="input_fields_wrap">
	     <c:forEach items="${standardDef.sectionSet}" var="sectionDef"  varStatus="incrementor" >
             <div class="col-md-1">
	             	<span class="input-icon input-icon-right">
	             	<input type="text"  data-sectionname="section" value="${sectionDef.sectionName}" class="form-control ipbox border_ip">
	              	<input type="hidden" name="indexId"  data-standardid="${standardDef.standardId}" value="${sectionDef.compareId}">
	               <i class="clip-close-2 remove_field"></i></span>
	               <c:set var="sectionsize" scope="page" value="${sectionDef.maximumStudents}"></c:set>
             </div>
         </c:forEach>
</div>
 <div class="col-md-1">
 <button type="button" class="btn btn-purple btn-sm add_field_button" ><i class="fa fa-plus"></i></button>
 </div>
			 <c:if test="${noofsections==0}" >
			          <div class="col-md-1 sectionsize" data-div="sectionsize">
			        			<input type="text" data-sectionsize="size"  value=""  class="form-control ipbox border_ip"> 
			        </div>
			 </c:if>
		   	<c:if test="${noofsections>0}">
			            <div class="col-md-1 sectionsize" data-div="sectionsize">
			          			<input type="text" data-sectionsize="size"  value="${sectionsize}"  class="form-control ipbox border_ip"> 
			          </div>
			 </c:if>
</div><!-- / std row-->
<hr>
</c:if>
</c:if>
</c:forEach> --%>

</form>
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
                                     
														<!-- / tab 2 msg--> 
													
</div>
												
												
													
													<div class="tab-pane" id="subjectDefnitionTab">
                                                        <!--  tab 3 msg--> 
 <div class="panel-group accordion-custom accordion-teal" id="accordion">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#addSubject">
													<i class="icon-arrow"></i>
													Add New Subject
												</a></h4>
											</div>
											<div id="addSubject" class="panel-collapse collapse">
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
													<div class="tab-pane" id="subjectassignment">
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
							<form action="#" role="form" id="subjectassignmentform">
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
														<select class="form-control" name="standardList" id="standardList">
															 <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																  <c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
											  <c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
													<c:choose>
														<c:when
															test="${standardDef.statusForChecked==true && noofsections!=0 }">
															<option
																data-standardid="${standardDef.standardId}"
																value="${standardLoop1.index+1}">
																<big>${standardDef.standardName}</big>
															</option>
														</c:when>
														<c:when
															test="${standardDef.statusForChecked==true && standardDef.groupassigned==true }">
															<option
																data-standardid="${standardDef.standardId}"
																value="${standardLoop1.index+1}" data-groupassigned="true">
																<big>${standardDef.standardName}</big>
															</option>
														</c:when>
													</c:choose>
																	</c:forEach>
														</select>
                                               </div>
												</div>
												<div class="col-md-3" style="display: none;" data-name="vocationalgroupdiv"> 
                                                        <div class="form-group">                                               
													<label class="control-label">
														Select Group Name <span class="symbol required"></span>
													</label>

															<select name="vocationalgroupselect" id="vocationalgroupselect" class="form-control">
																<option value="111">All</option>
																
															</select>
                                                            </div>
												</div>
												
														<div class="col-md-3"> 
                                                        <div class="form-group" id="sectionDiv">                                               
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
												<ul class="alert panel-box list-inline cond ui-sortable"
													id="assignedsubjects" style="cursor: move;">
												<c:forEach items="${setDefinitions.classSectionDefSet}" varStatus="increment" var="classSectionDef">
													<c:if test="${fn:length(classSectionDef.schoolSubjectAssignmentSet)!=0}">
													  <c:forEach items="${classSectionDef.schoolSubjectAssignmentSet}" var="subjectAssignmentObj">
													  <li data-validforstore="false" class="label label-default ui-sortable-handle" 
													  data-standardid="${subjectAssignmentObj.standardId}"
													   data-sectionid="${subjectAssignmentObj.schoolClassSection.compareId}" 
													   data-basesubjectid="${subjectAssignmentObj.baseSubjectId}"  
													   data-value="${subjectAssignmentObj.baseSubjectId}" 
													   title="${subjectAssignmentObj.subjectName}" style="margin:5px;display: none;background-color: #FF9F71 !important;border-color: #FF9F71 !important;">
													  <span class="h4">${subjectAssignmentObj.subjectName}</span>
													  <i class="clip-close-4 remove_field" data-basesubjectid="${subjectAssignmentObj.baseSubjectId}" data-name="subjectdelete" data-sectionid="${subjectAssignmentObj.schoolClassSection.compareId}"   data-standardid="${subjectAssignmentObj.standardId}" style=" cursor: pointer;"></i>
													  </li>
													  </c:forEach>
													</c:if>
												</c:forEach>
												</ul>
											</div>
											<div class="col-md-6">
									<!-- start:  PANEL -->Available Subjects 
										            <ul class="alert panel-box list-inline cond ui-sortable" id="availablesubjects" style="cursor:move;">
										             <c:forEach var="subject" items="${schoolMasterDataDefinition.schoolSubjectsDefinition}" varStatus="standardLoop1">
									                           <li  data-validforstore="false" class="label label-success ui-sortable-handle" 
									                           data-basesubjectid="${subject.compareId}" 
									                           data-value="${subject.subjectId}" title="${subject.subjectName}" style="margin:5px;"><span class="h4">${subject.subjectRefId}</span></li>
													</c:forEach>
									                      </ul>
												</div>                  
</div><!--end row-->
                                           <!--end drag & drop section-->   
                                           </div>
											
										</div>
										<div class="row">
											<div class="col-md-12">
                                           <span class="label label-success">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;
                                           <span class="label label-default" style="background-color: #FF9F71 !important;border-color: #FF9F71 !important;">&nbsp;</span>&nbsp;-&nbsp;Assigned&nbsp;&nbsp;&nbsp;&nbsp;                                           
                                           <span class="label label-default" style="background-color: #D3D3D3 !important;border-color: #D3D3D3 !important;" >&nbsp;</span>&nbsp;-&nbsp;To be Assigned&nbsp;&nbsp;&nbsp;&nbsp;                                           
											</div>
										</div>
										<br>
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