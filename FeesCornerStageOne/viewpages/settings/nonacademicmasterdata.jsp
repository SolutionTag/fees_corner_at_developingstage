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
									<i class="clip-file"></i>
								Non Academic Master Data
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
								<div id="generateJson" style="display: none;">
											 <json:object prettyPrint="true" name="section" escapeXml="true">
														<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="loopStatus">
													<c:choose>
															<c:when test="${standardDef.groupassigned!=true}">
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
													</c:when>
													<c:when test="${standardDef.groupassigned==true}">
													<c:forEach var="groupdef"
															items="${standardDef.groupSet}"
															varStatus="loopStatus">
													 <json:array name="${groupdef.groupId}" var="wantedForSubjectAssignment">
																		<c:if test="${standardDef.statusForChecked==true}">
																			<c:forEach items="${groupdef.sectionSet}"
																				var="sectionDef" varStatus="incrementor">
																				<json:object>
																				<json:property name="sectionId" value="${sectionDef.compareId}"/>
																		       <json:property name="sectionName" value="${sectionDef.sectionName}" />
																		       </json:object>
																			</c:forEach>
																		</c:if>
																</json:array>
																</c:forEach>
													</c:when>
											</c:choose>
														</c:forEach>
                                                </json:object>
											</div>
							<div class="panel-body">
                            
                            <div class="row"><!-- row -->
                            <!-- tab -->
							<div class="col-sm-12">
											<div class="tabbable">
												<ul id="myTab" class="nav nav-tabs tab-bricky">
												   <li class="active">
														<a href="#termtypecreation" data-toggle="tab">
															Term Type Creation
														</a>
													</li>
													<li class="">
														<a href="#feescreationpannel" data-toggle="tab">
															 Fee Creation
														</a>
													</li>
													<li >
														<a href="#feesassignpannel" data-toggle="tab">
															Fee Assign
														</a>
													</li>
													 
												</ul>
												<div class="tab-content">
												
												
												 <div class="tab-pane" id="termtypecreation">
														<!--  tab 3 msg-->
 <div class="panel-group accordion-custom accordion-teal" id="accordion5">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#collapseOne5">
													<i class="icon-arrow"></i>
													Add New Period
												</a></h4>
											</div>
											<div id="collapseOne5" class="panel-collapse collapse">
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
                                                        <div class="form-group">
													<label class="control-label">
														 Period Name <span class="symbol required"></span>
													</label>
															<input type="text" id="termName" name="termName" class="form-control">
                                                            </div>
												</div>
                                                		
													
                                                		<div class="col-md-3">
                                                        <div class="form-group">
													<label class="control-label">
														Select Period Duration <span class="symbol required"></span>
													</label>
															<select name="termPeriod" id="termPeriod" class="form-control" >
																<option value="ones">Month Wise</option>
                                                                <option value="twele">Per Year </option>
																<option value="sixs">Semi Annually</option>
																<option value="fours">Tri Annual</option>
                                                                <option value="threes">Quarterly</option>
                                                                <option value="twos">Bi Annual</option>
															</select>
                                                            </div>
												</div>                                               
                                           </div>
                                           <div class="col-md-12">
                                           <!--start month_period-->
                                     <div class="no-display"  data-active="false" id="month_period">
                                        <div class="checkbox-inline">
                                        <div class="row">
                                         <div class="col-md-2">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JUNE" checked="checked">
											<big>Jun</big>
										</label>
                                        </div>
                                        <div class="col-md-2">
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JULY" checked="checked">
											<big>Jul</big>
										</label> 
										</div>
                                        <div class="col-md-2">                                        
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="AUGUST" checked="checked">
											<big>Aug</big>
										</label> 
                                        </div>
                                        <div class="col-md-2">
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="SEPT" checked="checked">
											<big>Sep</big>
										</label> 				
                                        </div>
                                        <div class="col-md-2">						
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="OCT" checked="checked">
											<big>Oct</big>
										</label> 				
                                        </div>
                                        <div class="col-md-2">						
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="NOV" checked="checked">
											<big>Nov</big>
										</label> 			
                                        </div>
                                        <div class="col-md-2">							
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="DEC" checked="checked">
											<big>Dec</big>
										</label> 				
                                        </div>
                                        <div class="col-md-2">						
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JAN" checked="checked">
											<big>Jan</big>
										</label>
                                        </div>
                                        <div class="col-md-2">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="FEB" checked="checked">
											<big>Feb</big>
										</label>
                                        </div>
                                        <div class="col-md-2">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value=" MAR" checked="checked">
											<big>Mar</big>
										</label>
                                        </div>
                                        <div class="col-md-2">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="APR" checked="checked">
											<big>Apr</big>
										</label>
                                        </div>
                                        <div class="col-md-2">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="MAY" checked="checked">
											<big>May</big>
										</label>
                                        </div>
                                        </div>
                                        </div>
                                                </div>
                                                <!--end month_period-->
                                                <!--start 2's_period-->
                                           		<div class="no-display"  data-active="false" id="twos_period">
                                                <div class="checkbox-inline">
                                            <div class="row">
                                         <div class="col-md-4">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JUNE-JULY" checked="checked">
											<big>Jun - Jul</big>
										</label>
                                        </div>
                                        <div class="col-md-4">                                        
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="AUGUST-SEPT" checked="checked">
											<big>Aug - Sep</big>
										</label> 
                                        </div>
                                        <div class="col-md-4">						
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="OCT-NOV" checked="checked">
											<big>Oct - Nov</big>
										</label> 				
                                        </div>
                                        <div class="col-md-4">							
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="DEC-JAN" checked="checked">
											<big>Dec - Jan</big>
										</label> 				
                                        </div>
                                        <div class="col-md-4">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="FEB-MAR" checked="checked">
											<big>Feb - Mar</big>
										</label>
                                        </div>
                                        <div class="col-md-4">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="APR-MAY" checked="checked">
											<big>Apr - May</big>
										</label>
                                        </div>
                                        
                                        </div>
                                        </div>

                                                </div>
                                                <!--end 2's_period-->
                                                 <!--start 3's_period-->
                                           		<div class="no-display"  data-active="false" id="threes_period">
                                                <div class="checkbox-inline">
                                            <div class="row">
                                         <div class="col-md-6">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JUNE-AUGUST" checked="checked">
											<big>Jun - Aug</big>
										</label>
                                        </div>
                                        <div class="col-md-6">                                        
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="SEPT -NOV" checked="checked">
											<big>Sep - Nov</big>
										</label> 
                                        </div>
                                        <div class="col-md-6">							
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="DEC-FEB" checked="checked">
											<big>Dec - Feb</big>
										</label> 				
                                        </div>
                                        <div class="col-md-6">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="MAR-MAY" checked="checked">
											<big>Mar - May</big>
										</label>
                                        </div>
                                        
                                        </div>
                                        </div>

                                                </div>
                                                <!--end 3's_period-->
                                                <!--start 4's_period-->
                                           		<div class="no-display"  data-active="false" id="fours_period">
                                                <div class="checkbox-inline">
                                            <div class="row">
                                         <div class="col-md-6">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JUNE-SEPT" checked="checked">
											<big>Jun - Sep</big>
										</label>
                                        </div>
                                        <div class="col-md-6">                                        
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="OCT-JAN" checked="checked">
											<big>Oct - Jan</big>
										</label> 
                                        </div>
                                        <div class="col-md-6">							
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="FEB-MAY" checked="checked">
											<big>Feb - May</big>
										</label> 				
                                        </div>
                                        
                                        </div>
                                        </div>

                                                </div>
                                                <!--end 4's_period-->
                                                <!--start 6's_period-->
                                           		<div class="no-display"  data-active="false" id="sixs_period">
                                                <div class="checkbox-inline">
                                            <div class="row">
                                         <div class="col-md-12">
                                        <label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="JUNE-NOV" ,"NOV" checked="checked">
											<big>Jun - Nov</big>
										</label>
                                        </div>
                                        <div class="col-md-12">                                        
										<label class="checkbox-inline">
										<input type="checkbox" data-name="period" class="flat-green" value="DEC-MAY" checked="checked">
											<big>Dec - May</big>
										</label> 
                                        </div>
                                        
                                        </div>
                                        </div>

                                                </div>
                                                <!--end 6's_period-->
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
                                           											
											</div>
											<div class="col-md-4">
												<button class="btn btn-green btn-block" type="button" id="createterm">
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
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion5" href="#collapseTwo5">
													<i class="icon-arrow"></i>
													View Period
												</a></h4>
											</div>
											<div id="collapseTwo5" class="panel-collapse collapse in">
												<div class="panel-body">
 <!-- start: View Subject PANEL -->
									<table class="table table-striped table-bordered table-hover table-full-width" id="sample_4">
										<thead>
											<tr>
												<th>Please Change</th>
                                                <th>Please Change</th>
												<th class="hidden-xs">Please Change</th>
												<th class="hidden-xs">Please Change</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><big>&#8549;</big></td>
                                                <td>A</td>
												<td class="hidden-xs">kok, jjj, Adn48, Bus24</td>
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
                                           				<!-- / tab 3 msg-->
													</div>
												
													<div class="tab-pane" id="feescreationpannel">
                                                  <!--  tab 1 msg-->
 <div class="panel-group accordion-custom accordion-teal" id="accordion">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#feescreationcollapse">
													<i class="icon-arrow"></i>
													Create New Fee
												</a></h4>
											</div>
											<div id="feescreationcollapse" class="panel-collapse collapse">
												<div class="panel-body">
													<!--   Add New School form--> 
 <!-- start: FORM School info PANEL -->
							
									<form action="#" role="form" id="feescreationform" >
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
														Fee Name <span class="symbol required"></span>
													</label>
													<input type="text" placeholder="" class="form-control" id="feesName" name="feesName">
												</div>
												<div class="form-group">
													<label class="control-label">
														Fee Type <span class="symbol required"></span>
													</label>
													<select  id="feesType" name="feesType" class="form-control" >
																<option value="">Select</option>
																<option value="General">General</option>
																<option value="NonGeneral">Non General</option>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">
														Fee Date <span class="symbol required"></span>
													</label>
													<input type="text"  disabled="disabled" placeholder="" id="feesCreatedDate" name="feesCreatedDate" class="form-control">
												</div>
												<div class="form-group">
													<label class="control-label">
														Fee Purpose <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control"  id="purpose" name="purpose">
												</div>                                               
											</div>
											<!-- <div class="col-md-6">
                                                <div class="form-group">
													<label class="control-label">
														Month Fee ( % )<span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>  
												<div class="form-group">
													<label class="control-label">
														Term Fee ( % )<span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														Year Fee ( % )<span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
											</div> -->
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
												<button class="btn btn-yellow btn-block" id="createfees" type="button">
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
												<a class="accordion-toggle " data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
													<i class="icon-arrow"></i>
													View Fee Details
												</a></h4>
											</div>
											<div id="collapseTwo" class="panel-collapse collapse in">
												<div class="panel-body">
<!-- start: View Subject PANEL -->
									<table class="table table-striped table-bordered table-hover table-full-width" id="sample_3">
										<thead>
											<tr>
												<th>Fee Name</th>
												<th class="hidden-xs">Fee ID</th>
												<th>Fee Type</th>
                                                <th>Fee Date</th>
                                                <th>Fee Purpose</th>
                                                <th>Month Fee</th>
                                                <th>Term Fee</th>
                                                <th>Year Fee</th>
												<th class="hidden-xs">Action</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Bus Fee</td>
												<td class="hidden-xs">7788</td>
												<td>General</td>
                                                <td>26/01/2015</td>
                                                <td>Transport Fee</td>
                                                <td>3%</td>
                                                <td>2%</td>
                                                <td>0%</td>
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
												<td>Hostel Fee</td>
												<td class="hidden-xs">7711</td>
												<td>General</td>
                                                <td>05/02/2015</td>
                                                <td>Hostel Fee</td>
                                                <td>5%</td>
                                                <td>1%</td>
                                                <td>0%</td>
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
												<td>Book Fee</td>
												<td class="hidden-xs">7799</td>
												<td>General</td>
                                                <td>31/03/2015</td>
                                                <td>Books Fee</td>
                                                <td>4%</td>
                                                <td>2%</td>
                                                <td>0%</td>
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
                                                  <!-- / tab 1 msg-->
													</div>
													<div class="tab-pane" id="feesassignpannel">
														<!--  tab 2 msg-->
 <div class="panel-group accordion-custom accordion-teal" id="accordion4">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#collapseOne4">
													<i class="icon-arrow"></i>
													Add New Fee Assignment
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
                                                <div class="col-md-3" data-name="termlistdiv">
                                                <div class="form-group">
														<label class="control-label"> Select
															Term  Name <span class="symbol required"></span>
														</label> 
														<select name="term" id=""  class="form-control" >
														<c:forEach items="${schoolMasterDataDefinition.termDefinitionSet}" var="termdef" varStatus="sectionstatus">
															<option  data-termcompareid="${termdef.compareId}" value="${termdef.termName}">${termdef.termName}</option>
													   </c:forEach>
													</select>
													</div>
                                                
                                                </div>
												<div class="col-md-3">
													<div class="form-group">
														<label class="control-label"> Select
															Standard Name <span class="symbol required"></span>
														</label>
														 <select name="standardList" id="standardList"
															class="form-control">
															<c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																<c:choose>
																<c:when test="${standardDef.groupassigned!=true}">
																<c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
																<c:if test="${standardDef.statusForChecked==true && noofsections!=0}">
																	<option data-standardid="${standardDef.standardId}" data-groupassigned="false" value="${standardLoop1.index+1}">
																		<big>${standardDef.standardName}</big>
																	</option>
																</c:if>
																</c:when>
																<c:when test="${standardDef.groupassigned==true}">
																<c:if test="${standardDef.statusForChecked==true}">
																	<option data-standardid="${standardDef.standardId}" data-groupassigned="true" value="${standardLoop1.index+1}">
																		<big>${standardDef.standardName}</big>
																	</option>
																</c:if>
																</c:when>
																</c:choose>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-3"> 
                                                   <div class="form-group" style="display: none;" data-name="vocationalgroupdiv">                                               
													<label class="control-label">
														Select Group Name <span class="symbol required"></span>
													</label>
													<c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="standardLoop1">
															<c:if test="${standardDef.statusForChecked==true &&  standardDef.groupassigned==true}">
																<select name="vocationalgroupselect" data-standardid="${standardDef.standardId}" data-currentgroup="false" id="vocationalgroupselect" class="form-control" style="display: none;">
																<option value="111">All</option>
																<c:forEach items="${standardDef.groupSet}" var="vocationalgroup">
																<c:if test="${vocationalgroup.groupEnabled==true}">
																			<option data-standardid="${standardDef.standardId}" data-groupid="${vocationalgroup.groupId}" value="${vocationalgroup.groupName}">${vocationalgroup.groupName}</option>
																</c:if>
																</c:forEach>
																</select>
															</c:if>
													</c:forEach>
                                                   </div>
												</div>
												<div class="col-md-3">
													<div class="form-group" style="display: none;" data-name="sectiondiv">
														<label class="control-label"> Select
															Section Name <span class="symbol required"></span>
														</label>
														<c:forEach var="standardDef"
															items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
															varStatus="standardLoop1">
															<c:choose>
															<c:when test="${standardDef.groupassigned==true}">
													<c:forEach items="${standardDef.groupSet}" var="groupdef">
														<c:set var="nogroupsection" value="${fn:length(groupdef.sectionSet)}" />
															<c:if test="${standardDef.statusForChecked==true && nogroupsection!=0}">
																<select name="sectionselect" data-groupname="${groupdef.groupName}"  data-currentsection="false" data-groupid="${groupdef.groupId}" 
																data-standardid="${standardDef.standardId}" data-name="section" style="display: none;" class="form-control">
																			<option value="111" data-standardid="${standardDef.standardId}" selected="selected" data-groupid="${groupdef.groupId}" >All</option>
																			<c:forEach items="${groupdef.sectionSet}" var="groupsection">
																				<option data-sectioncomparedid="${groupsection.compareId}" data-groupid="${groupdef.groupId}" data-sectionid="${groupsection.sectionId}"
																					value="${groupsection.sectionName}">${groupsection.sectionName}</option>
																			</c:forEach>
																</select>
															</c:if>
												</c:forEach>
											</c:when>
											<c:when test="${standardDef.groupassigned!=true}">
																<c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
															<c:set var="noofsections"
																value="${fn:length(standardDef.sectionSet)}" />
															<c:if
																test="${standardDef.statusForChecked==true && noofsections!=0}">
																<select
																	data-standardid="${standardDef.standardId}"
																	data-name="section" data-currentsection="false"
																	class="form-control" style="display: none;">
																	<option value="111"
																		data-standardid="${standardDef.standardId}"
																		selected="selected">All</option>
																	<c:forEach items="${standardDef.sectionSet}"
																		var="section">
																		<option
																			data-standardid="${standardDef.standardId}"
																			data-sectionid="${section.sectionId}" data-sectioncomparedid="${section.compareId}"
																			value="${section.sectionName}">${section.sectionName}</option>
																	</c:forEach>
																</select>
															</c:if>
											</c:when>
											
								</c:choose>
														</c:forEach>
													</div>
												</div>
																		</div>
                                           </div>
                                           <div class="col-lg-12">
                                           <!--start drag & drop section -->
                                           <div class="row"><!--start row-->
                                        
                                           <div class="col-md-6">
                                            <!-- start:  PANEL -->
						Assigned Fees <span class="symbol required"></span>
			            <ul class="alert panel-box list-inline cond" id="assignedfees" style="cursor:move;">
                     <!--    <li class="label label-default" title="Enterprise Resource Planning" style="margin:5px;"><span class="h4">Bus01</span></li>
                        <li class="label label-warning" title="Programming in C++" style="margin:5px;"><span class="h4">Book08</span></li>
                         <li class="label label-danger" title="Tamil" style="margin:5px;"><span class="h4">Tut11</span></li>
                         <li class="label label-info" title="English" style="margin:5px;"><span class="h4">Reg55</span></li> 
                        <li class="label label-success" title="Data Structure" style="margin:5px;"><span class="h4">asdf</span></li>
                        <li class="label label-warning" title="Digital Logic Fundamental" style="margin:5px;"><span class="h4">labfee</span></li>
                         <li class="label label-danger" title="JavaScript" style="margin:5px;"><span class="h4">nofee</span></li>
                         <li class="label label-inverse" title="JavaScript" style="margin:5px;"><span class="h4">jolyfee</span></li>       -->    
                         <c:forEach items="${setDef.classSectionDefSet}" varStatus="increment" var="classSectionDef">
                         <c:if test="${fn:length(classSectionDef.schoolFeesDefinitionAssignmentSet)!=0}"></c:if>
                         <c:forEach items="${classSectionDef.schoolFeesDefinitionAssignmentSet}" var="FeesAssignmentObj">
                          <li data-validforstore="false" class="label label-default ui-sortable-handle" 
													  data-standardid="${FeesAssignmentObj.standardId}"
													   data-sectionid="${FeesAssignmentObj.schoolClassSection.sectionId}" 
													   data-basefeesid="${FeesAssignmentObj.baseFeesId}"  
													   data-termid="${FeesAssignmentObj.termId}"
													   data-termfrequencyid="${FeesAssignmentObj.termFrequencyId}"
													   data-termperiod="${FeesAssignmentObj.period}"
													   data-value="${FeesAssignmentObj.compareId}" 
													   title="${FeesAssignmentObj.baseFeesId}" style="margin:5px;display: none;">
													   <span class="h4">${FeesAssignmentObj.feesName}</span>
													   </li>
                         </c:forEach>
                         </c:forEach>                                             
						</ul>
							

                    </div>
                    <div class="col-md-6">
 <!-- start:  PANEL -->
								Available Fees
				<ul class="alert panel-box list-inline cond"
					id="availablefees" style="cursor: move;">
					<c:forEach items="${setDef.schoolFeesDefSet}"
						var="feesdefinition" varStatus="incr">
						<li data-validforstore="false" data-basefeesid="${feesdefinition.compareId}"  data-value="${feesdefinition.compareId}"
							class="label label-default"
							title="${feesdefinition.feesName}"
							style="margin: 5px;"><span class="h4">${feesdefinition.feesName}</span></li>
					</c:forEach>
				</ul>

																			</div>                  
</div><!--end row-->

                                           <!--end drag & drop section-->   
                                           </div>
                                       											
										</div>
										<div class="row">
											<div class="col-md-12">
                                           <span class="label label-danger">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;
                                           <span class="label label-success">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;                                           <span class="label label-info">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;                                           <span class="label label-warning">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;                                           <span class="label label-default">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;
                                           <span class="label label-inverse">&nbsp;</span>&nbsp;-&nbsp;Available&nbsp;&nbsp;&nbsp;&nbsp;
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
                                           											
											</div>
											<div class="col-md-4">
												<button class="btn btn-green btn-block" id="feesAssignmentSave" type="button">
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
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion4" href="#collapseTwo4">
													<i class="icon-arrow"></i>
													View Subject Assignment
												</a></h4>
											</div>
											<div id="collapseTwo4" class="panel-collapse collapse in">
												<div class="panel-body">
 <!-- start: View Subject PANEL -->
									<table class="table table-striped table-bordered table-hover table-full-width" id="sample_4">
										<thead>
											<tr>
												<th>Standard Name</th>
                                                <th>Section Name</th>
												<th class="hidden-xs">Assigned Fee</th>
												<th class="hidden-xs">Action</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><big>&#8549;</big></td>
                                                <td>A</td>
												<td class="hidden-xs">kok, jjj, Adn48, Bus24</td>
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
												<td><big>&#8549;</big></td>
                                                <td>B</td>
												<td class="hidden-xs">kok, jjj, Adn48, Bus24</td>
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
                                                <td>D</td>
												<td class="hidden-xs">kok, jjj, Adn48, Bus24</td>
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
											</tr>						<tr>
												<td><big>&#8554;</big></td>
                                                <td>All</td>
												<td class="hidden-xs">kok, jjj, Adn48, Bus24</td>
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
                                           				<!-- / tab 2 msg-->
													</div>

												</div>
											</div>
										</div><!-- /  tab -->	
                                        </div> <!-- / row -->
							
							
							</div>
					</div>
                    <!-- end: PANEL -->					
					<!-- end: PAGE CONTENT-->
				
				
				
          </div>
          
        </div>
      </div>
      <tiles:insertAttribute name="jsfiles" />
      <script src="${pageContext.request.contextPath}/resources/applicationjs/nonacademicmasterdatajs.js"></script>
      <tiles:insertAttribute name="footer" />
      
    </body>
  </html>