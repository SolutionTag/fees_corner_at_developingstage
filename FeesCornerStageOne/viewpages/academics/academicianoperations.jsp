<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.atg.com/taglibs/json"  prefix="json"%>
    
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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mixcss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>
<!-- <img  src="/fcds/resources/images/ajax-loader.gif" class="ajaxLaoder" id="loading_image"></img> -->
 <tiles:insertAttribute name="header" />
  <div class="main-container">
  <tiles:insertAttribute name="leftmenu"/>
   <div class="main-content">
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
					<div style="display: none;" id="boysjsondiv">
						<json:array name="boysList" var="academicianinfo"
							items="${setDef.academicianInfoSet}" prettyPrint="true">
							<c:if test="${academicianinfo.academicianGender==\"MALE\"}">
								<json:property name="compareId"
									value="${academicianinfo.compareId}"></json:property>
							</c:if>
						</json:array>
					</div>
					<div style="display: none;" id="girlsjsondiv">
						<json:array name="girlslist" var="academicianinfo"
							items="${setDef.academicianInfoSet}" prettyPrint="true">
							<c:if test="${academicianinfo.academicianGender==\"FEMALE\"}">
								<json:property name="compareId"
									value="${academicianinfo.compareId}"></json:property>
							</c:if>
						</json:array>
					</div>
					<div style="display: none;" id="bothjsondiv">
						<json:array name="bothlist" var="academicianinfo"
							items="${setDef.academicianInfoList}" prettyPrint="true">
						
								<json:property name="compareId"
									value="${academicianinfo.compareId}"></json:property>
						</json:array>
					</div>
					<div class="panel-body">
                            
                            <div class="row"><!-- row -->
                            <!-- tab -->
							<div class="col-sm-12">
											<div class="tabbable">
												<ul id="myTab" class="nav nav-tabs tab-bricky">
													<li class="active">
														<a href="#panel_tab2_example1" data-toggle="tab">
															 Class Assign
														</a>
													</li>
													<li >
														<a href="#panel_tab2_example2" data-toggle="tab">
															Attendance Entry
														</a>
													</li>
													<li >
														<a href="#panel_tab2_example3" data-toggle="tab">
															Message Passing
														</a>
													</li>
													<li >
														<a href="#panel_tab2_example4" data-toggle="tab">
															Promote student
														</a>
													</li>                                                                                                        
												</ul>
												<div class="tab-content">
													<div class="tab-pane in active" id="panel_tab2_example1">
											<!--  tab 1 msg-->
									 <div class="row">
									 <form id="pickupstudentlistform" method="post">
									  <div class="col-xs-6 col-sm-3">
									            <div class="form-group">
													<label class="control-label">
														Select Academic Year <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value="">2012-2013</option>
																<option value="">2013-2014</option>
																<option value="">2014-2015</option>
															</select>
                                                   </div>                                       
									  </div>
									  <div class="col-xs-6 col-sm-3">
									            <div class="form-group">
													<label class="control-label">
														Select Standard Name <span class="symbol required"></span>
													</label>
																<select class="form-control" name="standardId" id="standardId">
																<option value="111" ><big>Select</big></option>
															 <c:forEach var="standardDef"
																items="${schoolMasterDataDefinition.schoolStandardsDefnition}"
																varStatus="standardLoop1">
																 <c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
																<c:if test="${standardDef.statusForChecked==true && noofsections!=0}">
																<option value="${standardLoop1.index+1}" data-standardid="${standardDef.standardId}"><big>${standardDef.standardName}</big></option>
																	  </c:if>
													       </c:forEach>
													</select>
                                                   </div>                                        
									  </div>
									  <div class="col-xs-6 col-sm-3">
									            <div class="form-group">
													<label class="control-label">
														Select Gender <span class="symbol required"></span>
													</label>
															<select name="" id="selectGender" class="form-control" >
															   <option value="OTHERS">Both</option>
																<option value="MALE">Male</option>
																<option value="FEMALE">Female</option>
															</select>
                                                   </div>                                       
									  </div>
									  </form>
									</div> 
									 <hr>
                                    <div class="row">
                                    <div class="col-md-12">
                                    <h5>Total No.of Admission Students are : <label class="label label-info">${fn:length(setDef.academicianInfoSet)}</label>                                    </h5></div>
                                    </div>
                                    <div class="row">
                                    <div class="col-md-12">
                                    <h5>Total No.of Male Students are : <label class="label label-info" id="boyscount"></label>                                    </h5></div>
                                    </div>
                                    <div class="row">
                                    <div class="col-md-12">
                                    <h5>Total No.of Female Students are : <label class="label label-info" id="girlscount"></label>                                    </h5></div>
                                    </div> 
                                    <div class="row">
                                    <div class="col-md-12">
                                    No.of Section are 
	                                    <div class="checkbox-inline">
							<c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="loopStatus">
							<c:set var="noofsections" value="${fn:length(standardDef.sectionSet)}" />
							<c:if test="${fn:length(standardDef.sectionSet)>=1}" >
								<div class="checkbox-inline sectionlist" style="display: none" data-standardid="${standardDef.standardId}">
									<c:if test="${standardDef.statusForChecked==true}">
												<c:forEach items="${standardDef.sectionSet}" var="sectionDef" varStatus="incrementor">
														<label class="checkbox-inline">
														<input type="checkbox" class="flat-green" value=""  data-sectionid="${sectionDef.sectionId}">
														<input type="hidden" id="sectionstrength"  value="${sectionDef.maximumStudents}"  >
															<big data-sectionid="${sectionDef.sectionId}">${sectionDef.sectionName}</big>
														<c:out value="" ></c:out>
														</label>
											</c:forEach>
									   </c:if>
								</div></c:if>
							</c:forEach>
										                                                                                                                     
                                        </div>
                                    </div>
                                    </div>
                                    <div class="row">
                                    <div class="col-md-12">
                                   
                                    <h5>Section strength Value / per Section : <label class="label label-info" data-display="displaySectionstrength"></label>  </h5></div>
                                    </div>
                                    <div class="row">
                                    <div class="col-md-12">
                                    <h5>Status : <label class="label label-success">Fine</label>--- OR ---<label class="label label-danger">Bad</label></h5></div>
                                    </div>
                                    <hr>
<!-- start: FORM CA Result PANEL -->                    	
                   <form:form modelAttribute="setDef" id="sectionAllocationForm" method="post">
                   <c:set var="totalboys" value="0" scope="page" />
                   <c:set var="totalgirls" value="0" scope="page"/>
                            <!--Result Table-->
         <div style="width: auto; max-height: 30em; height: 100%;overflow-y: auto; overflow-style:marquee-line;">    
                            <table class="table table-hover" id="sectionAssignTable">
										<thead>
											<tr>
												<th class="center">#</th>
												<th>Student Name</th>
												<th>Admission No</th>
												<th>Gender</th>
												<th>Class Section </th>
												<th class="center">More</th>
											</tr>
										</thead>
										<tbody>
										
											<c:forEach items="${setDef.academicianInfoSet}" var="studentStds" varStatus="incrementor">
											<tr>
											<input type="hidden" name="studentinfopool" data-studentid="${studentStds.compareId}" data-gender="${studentStds.academicianGender}" data-studentname="${studentStds.academicianFirstName}"/>
											<form:hidden path="academicianInfoSet[${incrementor.index}].academicianId"/>
										    <form:hidden path="academicianInfoSet[${incrementor.index}].academicanStandardId"/>
											<form:hidden path="academicianInfoSet[${incrementor.index}].academicianSectionId"/>
											<form:hidden path="academicianInfoSet[${incrementor.index}].compareId"/> 
											
												<td class="center" data-index="index" >${incrementor.index+1}</td>
												<td>${studentStds.academicianName}</td>
								 				<td>${studentStds.academicianId}</td>
												<td data-gender="${studentStds.academicianGender}"><big>${studentStds.academicianGender}</big></td>
												<td>${studentStds.academicianSectionName}</td>
												<c:if test="${studentStds.academicianGender==\"MALE\"}">
												 <c:set var="totalboys" value="${totalboys+1}" scope="page" />
												</c:if>
												<c:if test="${studentStds.academicianGender==\"FEMALE\"}">
												 <c:set var="totalgirls" value="${totalgirls+1}" scope="page" />
												</c:if>
												<td class="center">
															<button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											</c:forEach>
											
										</tbody>
									</table>
									</div>
                                    <!--/ Result Table-->
                                    <hr>
                                    <div class="row">
									  <div class="col-xs-6 col-sm-3">
                                        Select Rule <span class="symbol required"></span>
                                      </div>                                    
                                    </div>
									<div class="row">
									  <div class="col-md-6 col-md-offset-3">
                                     
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value="" data-allocateby="111" checked="checked" name="rules">FCFS</label>
                                      </div>
                                </div>
                                <br>
                                <div class="row">
									  <div class="col-md-6 col-md-offset-3">
                                      
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value=""  data-allocateby="222" checked="checked" name="rules">FCFS (Separate)</label>
                                      </div>
                                       </div>
                                       <br>
                                <div class="row">
									  <div class="col-md-6 col-md-offset-3">
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value=""  data-allocateby="333"  name="rules">Ratio</label><input type="number" min="0" max="99" size="2" id="bratio" placeholder="B">&nbsp;<big>:</big>&nbsp;<input type="number" min="0"  id="gratio" max="99" size="2" placeholder="G">
                                      </div>
						</div>        
                                    <hr>         
										<div class="row">
                                    <div class="col-md-4">
                                    </div>
											<div class="col-md-4">
												<p>
                                                <a class="btn btn-info btn-block" type="button" href="#pre_model" data-toggle="modal">
													Preview 
												</a>
												</p>
											</div>
                                            
											<div class="col-md-4">
												
												<button class="btn btn-success btn-block" type="submit" id="sectionAllocationSubmit">
													Submit
												</button>                                                
											</div>
										</div>
										 <input type="hidden" id="noofacdemician" value="${fn:length(setDef.academicianInfoSet)}"></input>
										  <input type="hidden" id="totalboys" value="${totalboys}"></input>
										   <input type="hidden" id="totalgirls" value="${totalgirls}"></input> 
									</form:form>     
									<!--start mix code-->
								                <div id="mix_div">
								                            <div class="controls">
								  <label>Section:</label>
								  
								 <!--  <button class="sort-btn" data-dimension="type" data-sort="">A</button>
								  <button class="sort-btn" data-dimension="type" data-sort="">B</button>
								  <button class="sort-btn" data-dimension="type" data-sort="">C</button> -->
								  
								  <label>Sort:</label>
								  <button class="filter-btn" data-dimension="manufacturer" data-filter=".MALE" id="getmale">Male</button>
								  <button class="filter-btn" data-dimension="manufacturer" data-filter=".FEMALE" id="getfemale">Female</button>
								  <button class="filter-btn" data-dimension="manufacturer" data-filter="all" id="all">All</button>
								  <!-- <button class="sort" data-sort="myorder:asc">Asc</button>
								  <button class="sort" data-sort="myorder:desc">Desc</button> -->
								</div>
								<div id="Container_mix" class="container_mix">
								<!--   <div class="mix A gmale" data-myorder="1"></div>
								  <div class="mix A" data-myorder="2" ></div>
								  <div class="mix B" data-myorder="3"></div>
								  <div class="mix B" data-myorder="4"></div>
								  <div class="mix C" data-myorder="5"></div>
								  <div class="mix A gfemale" data-myorder="6"></div>
								  <div class="mix C gmale" data-myorder="7"></div>
								  <div class="mix B" data-myorder="8"></div>
								  <div class="mix A gmale" data-myorder="9"></div>
								  <div class="mix C gfemale" data-myorder="10"></div>
								  <div class="mix C gfemale" data-myorder="11"></div>
								  <div class="mix A" data-myorder="12"></div>
								  <div class="mix B gmale" data-myorder="13"></div>
								  <div class="mix B" data-myorder="14"></div> 
								  <div class="mix A" data-myorder="16"></div>
								  <div class="mix C" data-myorder="15"></div>
								  <div class="mix A" data-myorder="17"></div>
								  <div class="mix B gmale" data-myorder="18"></div>     -->    
								  
								  <div class="gap"></div>
								  <div class="gap"></div>
								</div>
												</div> 
                            <!--end mix code-->       
                            <!-- start: PANEL CONFIGURATION MODAL FORM -->                    							               
<div class="modal fade" id="pre_model" tabindex="-1" role="model" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title">Panel Configuration</h4>
							</div>
							<div class="modal-body">
                           <!--  <div id="mix_div">
								                            <div class="controls">
								  <label>Section:</label>
								  
								  <button class="sort-btn" data-dimension="type" data-sort=".A">A</button>
								  <button class="sort-btn" data-dimension="type" data-sort=".B">B</button>
								  <button class="sort-btn" data-dimension="type" data-sort=".C">C</button>
								  
								  <label>Sort:</label>
								  <button class="filter-btn" data-dimension="manufacturer" data-filter=".MALE" id="getmale">Male</button>
								  <button class="filter-btn" data-dimension="manufacturer" data-filter=".FEMALE" id="getfemale">Female</button>
								  <button class="filter-btn" data-dimension="manufacturer" data-filter="all" id="all">All</button>
								  <button class="sort" data-sort="myorder:asc">Asc</button>
								  <button class="sort" data-sort="myorder:desc">Desc</button>
								</div>
								<div id="Container_mix" class="container_mix">
								  <div class="mix A gmale" data-myorder="1"></div>
								  <div class="mix A" data-myorder="2" ></div>
								  <div class="mix B" data-myorder="3"></div>
								  <div class="mix B" data-myorder="4"></div>
								  <div class="mix C" data-myorder="5"></div>
								  <div class="mix A gfemale" data-myorder="6"></div>
								  <div class="mix C gmale" data-myorder="7"></div>
								  <div class="mix B" data-myorder="8"></div>
								  <div class="mix A gmale" data-myorder="9"></div>
								  <div class="mix C gfemale" data-myorder="10"></div>
								  <div class="mix C gfemale" data-myorder="11"></div>
								  <div class="mix A" data-myorder="12"></div>
								  <div class="mix B gmale" data-myorder="13"></div>
								  <div class="mix B" data-myorder="14"></div> 
								  <div class="mix A" data-myorder="16"></div>
								  <div class="mix C" data-myorder="15"></div>
								  <div class="mix A" data-myorder="17"></div>
								  <div class="mix B gmale" data-myorder="18"></div>        
								  
								  <div class="gap"></div>
								  <div class="gap"></div>
								</div>
												</div> -->
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Close
								</button>
								<button type="button" class="btn btn-primary">
									Save changes
								</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
<!-- end: FORM CA Result PANEL -->                            
                                                                              
											<!-- / tab 1 msg-->                                                    
													</div>
													<div class="tab-pane" id="panel_tab2_example2">
                                                        <!--  tab 2 msg--> 
<!-- start: FORM Attendance Entry PANEL -->
							
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
                                            </div>
                                            <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
													<label class="control-label">
														Select Standard Name <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value=""><big>&#8544;</big></option>
																<option value=""><big>&#8545;</big></option>
																<option value=""><big>&#8546;</big></option>
																<option value=""><big>&#8547;</big></option>
																<option value=""><big>&#8548;</big></option>
																<option value=""><big>&#8549;</big></option>
																<option value=""><big>&#8550;</big></option>
																<option value=""><big>&#8551;</big></option>
																<option value=""><big>&#8552;</big></option>
																<option value=""><big>&#8553;</big></option>
																<option value=""><big>&#8554;</big></option>
																<option value=""><big>&#8555;</big></option>
															</select>
                                                   </div>
                                               </div>
                                            <div class="col-md-4">
                                                        <div class="form-group">
													<label class="control-label">
														Select Section Name <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value="">A</option>
																<option value="">B</option>
																<option value="">C</option>
																<option value="">D</option>
																<option value="">E</option>
															</select>
                                                     </div>
                                                     </div>
                                            <div class="col-md-4">                                               
													<div class="form-group">
													<label class="control-label">
														Date &amp; Time 
													</label>
													<input type="text" placeholder="" class="form-control" id="" name="" disabled="disabled">
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
												<button class="btn btn-green btn-block" type="submit">
													Submit 
												</button>
											</div>
										</div>
									</form>
                    <!-- end: FORM Attendance Entry PANEL -->
                    <hr>
<!-- start: FORM Attendance Result PANEL -->                    	
                   <form action="#" role="form" id="form">
                            <!--Result Table-->
                            <table class="table table-hover" id="sample-table-1">
										<thead>
											<tr>
												<th class="center">#</th>
												<th>Student Name</th>
												<th>Roll No</th>
												<th>Std & Sec</th>
												<th class="center">Status</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="center">1</td>
												<td>xyz</td>
												<td>1001</td>
												<td><big>&#8544;</big> A</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>
											<tr>
												<td class="center">2</td>
												<td>xyz</td>
												<td>1974</td>
												<td><big>&#8544;</big> A</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>
											<tr>
												<td class="center">3</td>
												<td>xyz</td>
												<td>8733</td>
												<td><big>&#8549;</big> C</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>
											<tr>
												<td class="center">4</td>
												<td>xyz</td>
												<td>2478</td>
												<td><big>&#8545;</big> Sec1</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>
											<tr>
												<td class="center">5</td>
												<td>xyz</td>
												<td>1824</td>
												<td><big>&#8553;</big> Sec1</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>
											<tr>
												<td class="center">6</td>
												<td>xyz</td>
												<td>1288</td>
												<td><big>&#8551;</big> Sec1</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>
											<tr>
												<td class="center">7</td>
												<td>xyz</td>
												<td>1278</td>
												<td><big>&#8555;</big> Sec1</td>
												<td class="center">
                                                <div class="checkbox-table">
													<label>
														<input type="checkbox" class="flat-green">
													</label>
												</div>
                                                </td>
											</tr>                	
										</tbody>
									</table>
                                    <!--/ Result Table-->
                                    
                                    <hr>
									<div class="row">
											<div class="col-md-8">
												<p>
                                                <div class="checkbox-table">
                                                <label>
													<input type="checkbox" class="flat-orange">Select All	
                                                 </label>
                                                 </div>
												</p>
											</div>
											<div class="col-md-4">
												<button class="btn btn-orange btn-block" type="submit">
													Submit 
												</button>
											</div>
										</div>
									</form>                                    							               

<!-- end: FORM Attendance Result PANEL -->                            
														<!-- / tab 2 msg--> 
													</div>
													<div class="tab-pane" id="panel_tab2_example3">
                                                        <!--  tab 3 msg--> 
<!-- start: FORM Attendance Entry PANEL -->
							
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
                                            </div>
                                            <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
													<label class="control-label">
														Select Standard Name <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value=""><big>&#8544;</big></option>
																<option value=""><big>&#8545;</big></option>
																<option value=""><big>&#8546;</big></option>
																<option value=""><big>&#8547;</big></option>
																<option value=""><big>&#8548;</big></option>
																<option value=""><big>&#8549;</big></option>
																<option value=""><big>&#8550;</big></option>
																<option value=""><big>&#8551;</big></option>
																<option value=""><big>&#8552;</big></option>
																<option value=""><big>&#8553;</big></option>
																<option value=""><big>&#8554;</big></option>
																<option value=""><big>&#8555;</big></option>
															</select>
                                                   </div>
                                               </div>
                                            <div class="col-md-4">
                                                        <div class="form-group">
													<label class="control-label">
														Select Section Name <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value="">A</option>
																<option value="">B</option>
																<option value="">C</option>
																<option value="">D</option>
																<option value="">E</option>
															</select>
                                                     </div>
                                                     </div>
                                            <div class="col-md-4">                                               
													<div class="form-group">
													<label class="control-label">
														Via of <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value="">SMS</option>
																<option value="">E-Mail</option>
																<option value="">Calendar</option>
															</select>                                                    
                                                </div>
                                                </div>
												</div>
                    <!-- start: FORM MSG PANEL -->  
                    <div id="smsdiv">
                    <hr>
                    <h3><label class="label label-primary">SMS</label></h3>
                    <div class="row">
                    <div class="col-md-6">
									<div class="form-group">
										<label for="form-field-23">
											Message Box :<span class="symbol required"></span>
										</label>
										<textarea maxlength="50" id="form-field-23" class="form-control limited"></textarea>
									</div>                    
                    </div>
                    </div>
                    </div>
                    <!-- end: FORM MSG PANEL -->  
                    <!-- start: FORM Email PANEL -->  
                    <div id="emaildiv">
                    <hr>
                    <h3><label class="label label-primary">E-Mail</label></h3>
                    <div class="row">
                    <div class="col-md-6">
									<div class="form-group">
										<label for="form-field-23">
											Message Box :<span class="symbol required"></span>
										</label>
										<textarea id="form-field-23" class="form-control limited" placeholder="Coming Soon.... New Editor"></textarea>
									</div>                    
                    </div>
                    </div>
                    </div>
                    <!-- end: FORM Email PANEL -->                                     


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
												<button class="btn btn-green btn-block" type="submit">
													Submit 
												</button>
											</div>
										</div>
									</form>
                    <!-- end: FORM Attendance Entry PANEL -->  
                                                      
														<!-- / tab 3 msg--> 
													</div>
													<div class="tab-pane" id="panel_tab2_example4">
                                                        <!--  tab 4 msg--> 
											<!--  tab 1 msg-->
									 <div class="row">
									  <div class="col-xs-6 col-sm-3">
									            <div class="form-group">
													<label class="control-label">
														Select Academic Year <span class="symbol required"></span>
													</label>
															<select name="" id="" class="form-control" >
																<option value=""></option>
																<option value="">2012-2013</option>
																<option value="">2013-2014</option>
																<option value="">2014-2015</option>
															</select>
                                                   </div>                                       
									  </div>
									  <div class="col-xs-6 col-sm-3">
									            <div class="form-group">
													<label class="control-label">
														Select Standard Name <span class="symbol required"></span>
													</label>
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
                                    <div class="row">
                               <div class="col-md-12">
                                    No.of Section are 
	                                  <div class="checkbox-inline">
                                        <label class="checkbox-inline">
										<input type="checkbox" class="flat-green" value="" checked="checked" disabled="disabled">
											<big>A</big>
										</label>
                                      </div>
                                </div>
                                    </div>
<!-- start: FORM CA Result PANEL -->                    	
                   <form action="#" role="form" id="form">
                            <!--Result Table-->
                            <table class="table table-hover" id="sample-table-1">
										<thead>
											<tr>
												<th class="center">#</th>
												<th>Student Name</th>
												<th>Admission No</th>
												<th>Std</th>
												<th class="center">More</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="center">1</td>
												<td>xyz</td>
												<td>1001</td>
												<td><big>&#8544;</big></td>
												<td class="center">
															<button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											<tr>
												<td class="center">2</td>
												<td>xyz</td>
												<td>1974</td>
												<td><big>&#8544;</big></td>
												<td class="center">
                                                <button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											<tr>
												<td class="center">3</td>
												<td>xyz</td>
												<td>8733</td>
												<td><big>&#8549;</big></td>
												<td class="center">
                                                <button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											<tr>
												<td class="center">4</td>
												<td>xyz</td>
												<td>2478</td>
												<td><big>&#8545;</big></td>
												<td class="center">
                                                <button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											<tr>
												<td class="center">5</td>
												<td>xyz</td>
												<td>1824</td>
												<td><big>&#8553;</big></td>
												<td class="center">
                                                <button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											<tr>
												<td class="center">6</td>
												<td>xyz</td>
												<td>1288</td>
												<td><big>&#8551;</big></td>
												<td class="center">
                                                <button class="btn btn-blue">More</button>
                                                </td>
											</tr>
											<tr>
												<td class="center">7</td>
												<td>xyz</td>
												<td>1278</td>
												<td><big>&#8555;</big></td>
												<td class="center">
                                                <button class="btn btn-blue">More</button>
                                                </td>
											</tr>                	
										</tbody>
									</table>
                                    <!--/ Result Table-->
                                    <hr>
                                    <div class="row">
									  <div class="col-xs-6 col-sm-3">
                                        Select Rule <span class="symbol required"></span>
                                      </div>                                    
                                    </div>
						<div class="row">
									  <div class="col-xs-6 col-sm-3">
                                     <center>
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value="" checked="checked" name="optionsRadios1">
										FCFS
									</label>
                                    </center>
                                      </div>
									  <div class="col-xs-6 col-sm-3">
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value="" checked="checked" name="optionsRadios1">
										Ratio
									</label>
                                      </div>
									  <div class="col-xs-6 col-sm-3">
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value="" checked="checked" name="optionsRadios1">
										Rule 3
									</label>
                                      </div>
									  <div class="col-xs-6 col-sm-3">
                                      <label class="radio-inline">
										<input type="radio" class="square-red" value="" checked="checked" name="optionsRadios1">
										Rule 4
									</label>                                      
                                      </div>
						</div>        
                                    <hr>
									<div class="row">
											<div class="col-md-8">
												<p>
												</p>
											</div>
											<div class="col-md-4">
												<button class="btn btn-success btn-block" type="submit">
													Preview 
												</button>
											</div>
										</div>
									</form>                                    							               

<!-- end: FORM CA Result PANEL -->                            
                                                                                                      
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
  <tiles:insertAttribute name="jsfiles" />
  <script  src="${pageContext.request.contextPath}/resources/applicationjs/academicoperations.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.mixitup.js"></script>
  
</body>
</html>