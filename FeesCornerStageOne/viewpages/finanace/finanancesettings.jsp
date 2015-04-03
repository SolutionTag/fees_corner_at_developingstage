<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.atg.com/taglibs/json"  prefix="json"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true" %>
    
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
										<div class="col-sm-12">
											<div class="tabbable tabs-left">
												<ul id="standardsTab" class="nav nav-tabs tab-green">
													<c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="standardLoop1">
														<c:choose>	
														<c:when test="${standardDef.groupassigned==false }">	
														<c:if test="${standardDef.statusForChecked==true}">
															<li data-standardid="${standardDef.standardId}"  data-groupassigned="false" >
																<a href="#standardpanel-${standardLoop1.index}" data-toggle="tab">
																	<big>${standardDef.standardName}</big>
																</a>
															</li>
														</c:if>
														</c:when>
														<c:when test="${standardDef.groupassigned==true}">
															<c:if test="${standardDef.statusForChecked==true}">
															<li data-standardid="${standardDef.standardId}" data-groupassigned="true" >
																<a href="#standardpanel-${standardLoop1.index}" data-toggle="tab">
																	<big>${standardDef.standardName}</big>
																</a>
															</li>
														</c:if>
														
														</c:when>
														</c:choose>	
													</c:forEach>
												</ul>
<div class="tab-content" data-divname="feesDefinitionArea">
	<c:forEach  var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="standardLoop1">
	  <%--  <h5>${stdwise.key}  ${ standardDef.standardId}</h5>  <h5>${stdwise.value}</h5> --%> <%-- <h5>${stdwise.value}</h5> --%>
	      <c:if test="${standardDef.statusForChecked==true}">
			<div class="tab-pane" id="standardpanel-${standardLoop1.index}" >
                                                    <!--start 1st left tab-->
                                          <!-- start group and section ip-->
								<div class="clearfix" value="${standardDef.standardId}" >
							<c:choose>
								<c:when test="${standardDef.groupassigned==true }">
									<c:if test="${standardDef.statusForChecked==true}">
											
													<div class="col-md-3">
														<div class="form-group">
															<label class="control-label"> Select Group
																Name <span class="symbol required"></span>
															</label>
															 <select name="groups" id="${standardDef.standardId}" class="form-control">
																<c:forEach items="${standardDef.groupSet}" var="vocationalgroup">
																	<option data-groupcompareid="${vocationalgroup.compareId}" value="group1">${vocationalgroup.groupName}</option>
																</c:forEach>
															</select>
														</div>
													</div>
											<c:forEach items="${standardDef.groupSet}" var="vocationalgroup">
											<c:if test="${fn:length(vocationalgroup.sectionSet)!=0 }" >
													<div class="col-md-3" style="display: none;" data-name="groupsectionsdiv" data-groupcompareid="${vocationalgroup.compareId}">
														<div class="form-group">
															<label class="control-label"> Select Group Section
																Name <span class="symbol required"></span>
															</label> 
															<select name="groupsections" id="" data-standardid="${standardDef.standardId}"  data-groupcompareid="${vocationalgroup.compareId}" class="form-control">
																
																<c:if test="${vocationalgroup.allSectionFeesSame==true }">
																<option data-standardid="${standardDef.standardId}" data-groupid="${vocationalgroup.compareId}" value="111">All</option>
																</c:if>
																<c:forEach items="${vocationalgroup.sectionSet}" var="vocationalgroupsection">
																		<option data-sectioncompareid="${vocationalgroupsection.compareId }"  data-standardid="${standardDef.standardId}" value="${vocationalgroupsection.sectionName}">${vocationalgroupsection.sectionName}</option>
																</c:forEach>
														    </select>
														</div>
													</div>
												</c:if>
											</c:forEach>
											
										</c:if>
								</c:when>
								<c:when test="${standardDef.groupassigned==false }">
								<c:if test="${standardDef.statusForChecked==true && fn:length(standardDef.sectionSet)!=0}">
									<div class="col-md-3">
										<div class="form-group">
											<label class="control-label"> Select Section
												Name <span class="symbol required"></span>
											</label>
											 <select name="section" id="${standardDef.standardId}" class="form-control">
											 <c:if test="${standardDef.allSectionFeesSame==true}" >
													<option data-standardid="${standardDef.standardId}" value="111">ALL</option></c:if>
											 <c:forEach items="${standardDef.sectionSet}" var="sectiondef" >
												<option data-standardid="${standardDef.standardId}" data-sectionid="${sectiondef.compareId}"  value="${sectiondef.sectionName}">${sectiondef.sectionName}</option>
											</c:forEach>
											</select>
										</div>
									</div>
								</c:if>
								</c:when>
							</c:choose>
									
								</div>
								<!-- end group and section ip-->
                                           <div class="" >
                                                   <div class="">
                                             <div class="tabbable">
												<ul id="myTab4" class="nav nav-tabs tab-blue">
												<c:forEach items="${fessTermElementArrangement.availableTermsForStdandards}" var="termforcurrentstd" varStatus="status">
												<c:choose>
														<c:when test="${standardDef.groupassigned==false}">
																	<c:if
																		test="${termforcurrentstd.key eq standardDef.standardId}">
																		<c:forEach items="${termforcurrentstd.value}"
																			var="termdefinition"
																			varStatus="termdefinitionStatus">
																			<li class=""><a
																				href="#term-${termdefinitionStatus.index}${standardDef.standardId}"
																				data-toggle="tab"> <big>${termdefinition.termName}</big>
																			</a></li>
																		</c:forEach>
																	</c:if>
														</c:when>
														<c:when test="${standardDef.groupassigned==true}">
														<c:if test="${termforcurrentstd.key eq standardDef.standardId}">
														 <c:forEach items="${termforcurrentstd.value}"
																			var="termdefinition"
																			varStatus="termdefinitionStatus">
																			<li class=""><a
																				href="#term-${termdefinitionStatus.index}${standardDef.standardId}"
																				data-toggle="tab"> <big>${termdefinition.termName}</big>
																			</a></li>
																		</c:forEach>
														</c:if>
														
														</c:when>
												</c:choose>
                                                  </c:forEach>                      
												</ul>
		<div class="tab-content" data-name="term-tabcontent">
			<c:forEach items="${fessTermElementArrangement.availableTermsForStdandards}" var="termforcurrentstd" varStatus="status">
			<c:choose>
				<c:when test="${standardDef.groupassigned==false}">
						<c:if test="${termforcurrentstd.key eq standardDef.standardId}">
								<c:forEach items="${termforcurrentstd.value}" var="termdefinition" varStatus="termdefinitionStatus">
									<div class="tab-pane" id="term-${termdefinitionStatus.index}${standardDef.standardId}" >
                                                    <!--start 1st left tab-->
                                           <c:set var="standardlevel" value="${fessTermElementArrangement.standardFee[standardDef.standardId]}"></c:set>
                                           <c:set var="assignedFeesStd" value="${fessTermElementArrangement.assignedFeesStd[standardDef.standardId]}"></c:set>
                                       <c:forEach  items="${standardDef.sectionSet}" var="section" varStatus="sectionstatus" >  
                                       			<c:set var="assignedFeesSection" value="${assignedFeesStd[section.compareId]}" ></c:set>
                                               <c:set var="termlevel" value="${standardlevel[section.compareId]}"></c:set>
                                               
                                                <c:set var="frequencylevel" value="${termlevel[termdefinition.compareId]}"></c:set>
                                                <c:set var="assignedFeesTerm" value="${assignedFeesSection[termdefinition.compareId]}"></c:set> 
                                            
                                              <c:choose> 
                                               <c:when test="${not empty termlevel}">
                                                <form method="post"   style="display: none;" data-termid="${termdefinition.compareId}" data-tablename="feesamountform" data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId}">
                                                   <!-- start responsive table -->
                                                   
                                                    <div class="table-responsive">
                                                        <table class="table table-bordered table-hover" id="sample-table-1">
                                                            <thead>
                                                            <tr>
	                                                                <th class="center">
	                                                                    <div class="text-success">
	                                                                        <span class="clip-pencil">${fn:length(assignedFeesTerm)}</span>
	                                                                    </div>
	                                                                </th>
	                                                              <c:forEach items="${assignedFeesTerm}" var="feesDef" varStatus="feesStatus">
		                                                                <th>
		                                                                    <div class="text-primary">
		                                                                        ${feesDef.feesName}<span class="symbol required"></span>
		                                                                    </div>
		                                                                </th>
                                                                </c:forEach>
                                                            </tr>
                                                            </thead>
		                                         <tbody>
						                               <tr>
						                               		<c:forEach items="${termdefinition.termFrequencySet}" var="frequencyset">
						                               		 <tr>
                                                              <td class="center">${frequencyset.termFrequencyName}</td>
                                                              <c:forEach items="${frequencylevel[frequencyset.compareId]}" var="sectionfeesesbyfrequency">
                                                            
                                                              <td width="100">
                                                                  <div style="width:100px;">
                                                                   <span class="input-icon">
										                            <input type="text" placeholder=""   
										                             data-frequencyid="${sectionfeesesbyfrequency.termFrequencyId}" 
										                             data-termid="${sectionfeesesbyfrequency.termId}" 
										                             data-basefeesid="${sectionfeesesbyfrequency.baseFeesId}"
										                             data-standardid="${sectionfeesesbyfrequency.standardId}" 
										                             data-sectionfeesid="${sectionfeesesbyfrequency.compareId}" 
										                              data-sectionid="${sectionfeesesbyfrequency.schoolClassSection.compareId}"
										                               data-groupid="" 
										                             data-name="feesamount" 
										                             value="${sectionfeesesbyfrequency. feesAmount}" class="form-control" dir="rtl">
                                                                          <i class="fa fa-inr"></i>
                                                                      </span>
                                                                  </div>
                                                              </td>
                                                              </c:forEach>
                                                               </tr>
                                                           </c:forEach>	 
						                              
		                                          </tbody>
                                                        </table>
                                                    </div>   
                                               
                                                   <!-- end responsive table -->


                                            <div class="col-md-4">
												<span class="symbol required"></span>Required Fields
											</div>
                                            <div class="col-md-3 col-md-offset-8">
												<button class="btn btn-yellow btn-block" type="button" data-buttonname="feesassignmentsave">
													Save 
												</button>
											</div>
                                            </form>
                                        </c:when>
                                          <c:when test="${empty termlevel}">
                                             <div style="" data-id="feesErrorMessage" class="col-md-12" data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId}">
							                    	 <div class="col-md-12">
															 <div class="alert alert-success" role="alert" "="">
																	<h4>Fees is not assigned for this section yet.</h4>
															</div>
													 </div> 
                         					  </div>
                                             </c:when>
                                        </c:choose>
                                             </c:forEach>
                                                    <!--end 1st left tab-->
												</div>
													</c:forEach>
														</c:if>
															</c:when>
													
	<c:when test="${standardDef.groupassigned==true}">
			<c:if test="${termforcurrentstd.key eq standardDef.standardId}">
					<c:forEach items="${termforcurrentstd.value}" var="termdefinition" varStatus="termdefinitionStatus">
									<div class="tab-pane " id="term-${termdefinitionStatus.index}${standardDef.standardId}" >
                                                    <!--start 1st left tab-->
                                  <c:forEach items="${standardDef.groupSet}" var="vocationalgroup">
                                   <c:set var="standardlevel" value="${fessTermElementArrangement.standardFee[vocationalgroup.groupId]}"></c:set>
                                     <%-- <c:if test="${fn:length(standardlevel.value)==0}">
											<div style="" data-id="feesErrorMessage" class="col-md-12" data-sectionid="${section.compareId}" data-standardid="${standardDef.standardId}">
						                    	 <div class="col-md-12">
														 <div class="alert alert-success" role="alert" "="">
																<h4>Fees is not assigned for this section yet.</h4>
														</div>
												 </div> 
                          				 </div>
							        </c:if> --%>
                                     
                                       <c:set var="assignedFeesStd" value="${fessTermElementArrangement.assignedFeesStd[vocationalgroup.groupId]}"></c:set>
                                        <c:forEach  items="${vocationalgroup.sectionSet}" var="section" varStatus="sectionstatus" >  
                                                  <%-- <c:set var="standardlevel" value="${fessTermElementArrangement.standardFee[vocationalgroup.groupId]}"></c:set>
                                                      <c:set var="assignedFeesStd" value="${fessTermElementArrangement.assignedFeesStd[vocationalgroup.groupId]}"></c:set> --%>
                                                      <c:set var="assignedFeesSection" value="${assignedFeesStd[section.compareId]}" ></c:set>
                                                   <c:set var="termlevel" value="${standardlevel[section.compareId]}"></c:set>
                                                   
                                                   <c:set var="frequencylevel" value="${termlevel[termdefinition.compareId]}"></c:set>
                                                   <c:set var="assignedFeesTerm" value="${assignedFeesSection[termdefinition.compareId]}"></c:set>
                                                         <c:choose> 
                                               <c:when test="${not empty frequencylevel}">
                                                <form method="post" action="#"   data-termid="${termdefinition.compareId}"   style="display: none;" data-tablename="feesamountform" data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId}" >
                                                   <!-- start responsive table -->
                                                    <div class="table-responsive">
                                                        <table class="table table-bordered table-hover" id="sample-table-1">
                                                            <thead>
                                                            <tr>
	                                                                <th class="center">
	                                                                    <div class="text-success">
	                                                                        <span class="clip-pencil"></span>
	                                                                    </div>
	                                                                </th>
	                                                                 <c:forEach items="${assignedFeesTerm}" var="feesDef" varStatus="feesStatus">
	                                                                <th>
	                                                                    <div class="text-primary">
	                                                                         ${feesDef.feesName}<span class="symbol required"></span>
	                                                                    </div>
	                                                                </th>
	                                                                </c:forEach>
                                                            </tr>
                                                            </thead>
		                                         <tbody>
						                               <tr>
						                               		<c:forEach items="${termdefinition.termFrequencySet}" var="frequencyset">
						                               		 <tr>
                                                              <td class="center">${frequencyset.termFrequencyName}</td>
                                                              <c:forEach items="${frequencylevel[frequencyset.compareId]}" var="sectionfeesesbyfrequency">
                                                              <td width="100" data-length="${fn:length(frequencylevel[frequencyset.compareId])}">
                                                                  <div style="width:100px;">
                                                                   <span class="input-icon">
                                                                   <%-- ${vocationalgroup.groupName} --- ${sectionfeesesbyfrequency.feesName}---${sectionfeesesbyfrequency.sectionName} --%>
										                            <input type="text" placeholder="" id="" 
										                            data-frequencyid="${sectionfeesesbyfrequency.termFrequencyId}" 
										                            data-groupid="${sectionfeesesbyfrequency.vocationalGroupId}" 
										                            data-standardid="${sectionfeesesbyfrequency.standardId}" 
										                            data-termid="${sectionfeesesbyfrequency.termId}" 
										                            data-sectionid="${sectionfeesesbyfrequency.schoolClassSection.compareId}"
										                            data-basefeesid="${sectionfeesesbyfrequency.baseFeesId}"  data-sectionfeesid="${sectionfeesesbyfrequency.compareId}" 
										                            data-name="feesamount" value="${sectionfeesesbyfrequency.feesAmount}" class="form-control" dir="rtl">
                                                                          <i class="fa fa-inr"></i>
                                                                      </span>
                                                                  </div>
                                                              </td>
                                                              </c:forEach>
                                                               </tr>
                                                           </c:forEach>	 
						                              
		                                          </tbody>
                                                        </table>
                                                    </div>   
                                               
                                                   <!-- end responsive table -->


                                            <div class="col-md-4">
												<span class="symbol required"></span>Required Fields
											</div>
                                            <div class="col-md-3 col-md-offset-8">
												<button class="btn btn-yellow btn-block" data-buttonname="feesassignmentsave" type="button" >
													Save 
												</button>
											</div>
                                            </form>
                                        </c:when>
                                         <c:when test="${empty frequencylevel}">
                                             <div style="" data-id="feesErrorMessage" class="col-md-12" data-standardid="${standardDef.standardId}" data-sectionid="${section.compareId}">
							                    	 <div class="col-md-12">
															 <div class="alert alert-success" role="alert" "="">
																	<h4>Fees is not assigned for this section yet.</h4>
															</div>
													 </div> 
                         					  </div>
                                             </c:when>
                                        
                                        </c:choose>
                                            
                                             </c:forEach>
                                            </c:forEach>
                                            
                                            
                                          
                                                    <!--end 1st left tab-->
													</div>
													</c:forEach>
														
														</c:if>
														
													</c:when>
													</c:choose>
													</c:forEach>
													                                                                                                    
												</div>
											</div>
                                                    <!--end 1st left tab-->
													</div>
													
                                                                                                      
												</div>
											</div>
											</c:if>
											 
											</c:forEach>
											
										</div>
                                        </div>
                                        		</div></div>
                                                  <!-- / tab 1 msg-->
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