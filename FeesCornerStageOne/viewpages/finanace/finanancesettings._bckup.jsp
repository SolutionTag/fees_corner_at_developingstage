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
									<i class="fa fa-inr"></i>
								Settings
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
															 Fee Values Assign
														</a>
													</li>
													<li >
														<a href="#panel_tab2_example2" data-toggle="tab">
															Empty
														</a>
													</li>
												</ul>
												<div class="tab-content">
													<div class="tab-pane in active" id="panel_tab2_example1">
                                                  <!--  tab 1 msg-->
                                                  <div class="row">
               <div id="feesAssignmentJsondivOne" style="display: none"> 
				 <json:object prettyPrint="" name="section" escapeXml="true">
						<c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="loopStatus">
							 <json:array name="${standardDef.standardId}" var="wantedForSubjectAssignment">
								<c:if test="${standardDef.statusForChecked==true}">
								<json:object>
									<c:forEach items="${standardDef.sectionSet}" var="sectionDef"
										varStatus="incrementor">
										 <json:array name="${sectionDef.compareId }">
										 <c:if test="${fn:length(sectionDef.schoolFeesDefinitionAssignmentSet)!=0}">
										<json:array var="fees"
											items="${sectionDef.schoolFeesDefinitionAssignmentSet}">
												<json:property name="fessId" value="${fees.compareId}" />
										</json:array></c:if>
										</json:array>
									</c:forEach>
									</json:object>
								</c:if>
							</json:array>
						</c:forEach>
             </json:object>
					</div >
					<div id="feesAssignmentJsondivTwo" style="display: none">
					 <json:object prettyPrint="true" name="termdef" escapeXml="true">
						<c:forEach var="termDef" items="${schoolMasterDataDefinition.termDefinitionSet}" varStatus="loopStatus">
								<json:array name="${termDef.compareId}">
										<c:forEach items="${termDef.termFrequencySet}"
											var="frequency">
											<json:property name="frequencycompareid"
												value="${frequency.compareId }"></json:property>
										</c:forEach>
								</json:array>
						</c:forEach>
						</json:object>
					</div>
					<div class="col-sm-12">
						<div class="tabbable tabs-left">
							<ul id="standardsTab" class="nav nav-tabs tab-green">
								<c:forEach var="standardDef"
									items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
									varStatus="standardLoop1">
									<c:if
										test="${standardDef.statusForChecked==true && fn:length(standardDef.sectionSet)!=0}">
										<li class=""
											data-standardid="${standardDef.standardId}"><a
											href="#panel-${standardLoop1.index}" data-toggle="tab">
												<big>${standardDef.standardName}</big>
										</a></li>
									</c:if>
								</c:forEach>
							</ul>
							<div class="tab-content" id="feesDefinitionArea">
								<c:forEach var="standardDef"
									items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
									varStatus="standardLoop1">
									<div class="tab-pane " id="panel-${standardLoop1.index}">
										<!--start 1st left tab-->
											<div class="col-md-12">
											 <c:set var="selectcount" value="0"></c:set>
                          <c:forEach items="${standardDef.sectionSet}" var="section" varStatus="sectionstatus">
								<c:if  test="${selectcount eq 0}">
                                                    <div class="col-md-3 ">
                                                    <div class="form-group">
													<label class="control-label">
														Select Term Type <span class="symbol required"></span>
													</label>
													<select name="term" id="${standardDef.standardId}"  class="form-control" >
														<c:forEach items="${schoolMasterDataDefinition.termDefinitionSet}" var="termdef" varStatus="sectionstatus">
															<option  data-termcompareid="${termdef.compareId}" value="${termdef.termName}">${termdef.termName}</option>
													   </c:forEach>
													</select>
												</div>
                                                    </div>
                                                      <div class="col-md-3">
                                                    <div class="form-group">
													<label class="control-label">
														Select Section Name <span class="symbol required"></span>
													</label>
													<select name="standard"  class="form-control" id="${standardDef.standardId}" >
													<c:if test="${standardDef.allSectionFeesSame==true}" >
													<option data-standardid="${standardDef.standardId}" value="111">ALL</option></c:if>
														<c:forEach items="${standardDef.sectionSet}" var="section"
																							varStatus="sectionstatus">
													<option data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId}" value="${section.sectionName}">${section.sectionName}</option>
																								
													   </c:forEach>
													</select>
												      </div>
                                                    </div>
                                                     <c:set var="selectcount" value="1"></c:set>
                                  </c:if>
                                  </c:forEach>
                                  
											</div>
				  <c:forEach items="${standardDef.sectionSet}" var="section" varStatus="sectionstatus">
					  <c:choose>
                    	  <c:when test="${fn:length(section.schoolFeesDefinitionAssignmentSet)!=0}" >
                    	  <form id="${section.compareId}">
							<c:forEach items="${schoolMasterDataDefinition.termDefinitionSet}" var="term">
									 <div class="col-md-12" data-termid="${term.compareId}" data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId }" data-name="termheader" style="display: none">
                                              <div class="form-group">
													<label class="col-md-3 control-label center text-success">
														<h4><u>Period</u></h4>
													</label>
		                                           <c:forEach items="${section.schoolFeesDefinitionAssignmentSet}"  var="feesdefinition" varStatus="incr">
		                                          		 <label class="col-md-3 control-label center text-success">
														<h4><u>${feesdefinition.feesName}</u></h4>
													   </label>
													</c:forEach>
											  </div>
                                      </div>
                                     <c:forEach items="${term.termFrequencySet}" var="termfrequency">
                                        <div class="col-md-12" style="display: none"  data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId }" data-termid="${term.compareId}" data-frequencyid="${termfrequency.compareId}" data-name="termfrequncybody">
                                            <div class="form-group" data-name="">
											<label class="col-md-3 control-label center">
												<h5>${termfrequency.termFrequencyName}</h5>
											</label>
											  <c:forEach items="${section.schoolFeesDefinitionAssignmentSet}"  var="feesdefinition" varStatus="incr">
												<div class="col-md-2" data-name="feesbody">
		                                            <span class="input-icon">
													<input type="text" placeholder="" id="feesAmount" name="feesAmount" value="" class="form-control">
													<input type="hidden" placeholder="" id="sectionfeescompareId" name="sectionfeescompareId" value="${feesdefinition.compareId}">
													<%-- <input type="hidden" placeholder="" id="baseFeesId" name="baseFeesId" value="${feesdefinition.baseFeesId}"> --%>
													<input type="hidden" placeholder="" id="period" name="period" value="${termfrequency.termFrequencyName}">
													<input type="hidden" placeholder="" id="termId" name="termId" value="${term.compareId}">
													<input type="hidden" placeholder="" id="termName" name="termName" value="${term.termName}">
	                                                <i class="fa fa-inr"></i></span>
												</div>
											</c:forEach>
											<!-- <div class="col-md-2">
	                                            <span class="input-icon input-icon-right">
												<input type="text" placeholder="" id="" class="form-control">
                                                <i class="fa fa fa-temp">%</i></span>
											</div>
											<div class="col-md-2">
                                            	<span class="input-icon input-icon-right">
												<input type="text" placeholder="" id="" class="form-control">
                                                <i class="fa fa fa-temp">%</i></span>
											</div>
                                            <div class="col-md-2">
                                            	<span class="input-icon input-icon-right">
												<input type="text" placeholder="" id="" class="form-control">
                                                <i class="fa fa fa-temp">%</i></span>
											</div> -->
											</div>
                                        </div></c:forEach>
                                          </c:forEach>
                                         <div class="wrapperforEachSection" style="display: none;" data-standardid="${standardDef.standardId}" data-name="sectionbutton" data-sectionid="${section.compareId}">
		                <div class="col-md-4" >
							<span class="symbol required"></span>Required Fields
						</div>
		               <div class="col-md-3 col-md-offset-8">
							<button class="btn btn-yellow btn-block" type="button" data-standardid="${standardDef.standardId}" data-name="sectionbutton" data-sectionid="${section.compareId}">
								Save 
							</button>
						</div>
				</div>
                                      
                                        </form>
                                        </c:when>
                                        <c:when test="${fn:length(section.schoolFeesDefinitionAssignmentSet)==0}">
                    	 <div style="display:none;"  data-id="feesErrorMessage"  class="col-md-12"  data-sectionid="${section.compareId}" data-standardid="${standardDef.standardId}">
			                    	 <div class="col-md-12">
											 <div class="alert alert-success" role="alert"">
													<h4>Fees is not assigned for this section yet.</h4>
											</div>
									 </div> 
                           </div>
                    	</c:when>
                                        </c:choose>
                                      </c:forEach>
                                      <c:forEach items="${standardDef.sectionSet}" var="section" varStatus="sectionstatus">
            <c:if test="${fn:length(section.schoolFeesDefinitionAssignmentSet)!=0 && sectionstatus.index eq 1}">
              <div class="wrapperforEachStandard" data-standardid="${standardDef.standardId}" data-name="standardbutton" style="display: none;" >
               <div class="col-md-4">
					<span class="symbol required"></span>Required Fields
				</div>
               <div class="col-md-3 col-md-offset-8">
					<button class="btn btn-yellow btn-block"  data-standardid="${standardDef.standardId}" type=button>
						Save 
					</button>
				</div>
				</div>
				</c:if>
				
				</c:forEach>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
												<!-- / tab 1 msg-->
													</div>
												
												</div>
											</div>
										</div><!-- /  tab -->	
                                        </div> <!-- / row -->
							
							
							</div>
					</div>
				
          </div>
          
        </div>
      </div></div>
      	<tiles:insertAttribute name="jsfiles" />
      	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/applicationjs/financesettingsjs.js"></script>
      	<script src="${pageContext.request.contextPath}/resources/trail/jquery.form.js"></script> 
      <tiles:insertAttribute name="footer" />
      
    </body>
  </html>