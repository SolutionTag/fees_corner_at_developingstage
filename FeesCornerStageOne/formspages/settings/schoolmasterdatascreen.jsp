<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="main-content">
	<tiles:insertAttribute name="panelconfig" />
	<div class="container" style="min-height: 760px;">
		<tiles:insertAttribute name="pageheader" />
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
													<i class="icon-arrow"></i>
													Add New School
												</a></h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse">
												<div class="panel-body">
													<!--   Add New School form--> 
 <!-- start: FORM School info PANEL -->
							
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
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">
														School Name <span class="symbol required"></span>
													</label>
													<input type="text" placeholder="" class="form-control" id="" name="">
												</div>
												<div class="form-group">
													<label class="control-label">
														Standard of Education <span class="symbol required"></span>
													</label>
													<select name="" id="" class="form-control">
																<option value=""></option>
																<option value="01">1</option>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">
														School Established Year <span class="symbol required"></span>
													</label>
													<input type="text" placeholder="" id="" name="" class="form-control">
												</div>
												<div class="form-group">
													<label class="control-label">
														School Govt Reg ID <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" name="" id="">
												</div>
												<div class="form-group">
													<label class="control-label">
														School Location State <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
												<div class="form-group">
													<label class="control-label">
														School Location District <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>  
                                                <div class="form-group">
													<label class="control-label">
														School Phone Number <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>                                                
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">
														Board Education <span class="symbol required"></span>
													</label>
													<select name="" id="" class="form-control">
																<option value=""></option>
																<option value="01">1</option>
													</select>
												</div>
                                                <div class="form-group">
													<label class="control-label">
														Is Boarding School <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>  
												<div class="form-group">
													<label class="control-label">
														School Recognized By <span class="symbol required"></span>
													</label>
													<select name="" id="" class="form-control">
																<option value=""></option>
																<option value="01">1</option>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">
														School Location <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														School Country <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														School Management Name <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														School E-Mail Id <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
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
												<button class="btn btn-yellow btn-block" type="submit">
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
												<a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
													<i class="icon-arrow"></i>
													View School Info
												</a></h4>
											</div>
											<div id="collapseTwo" class="panel-collapse collapse in">
												<div class="panel-body">
 <!-- start: View School info PANEL -->
							
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
														School Name 
													</label>
													<input type="text" placeholder="" class="form-control" id="" name="" disabled="disabled">
												</div>
												<div class="form-group">
													<label class="control-label">
														Standard of Education 
													</label>
													<select name="" id="" class="form-control" disabled="disabled">
																<option value=""></option>
																<option value="01">1</option>
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
																<option value=""></option>
																<option value="01">1</option>
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
																<option value=""></option>
																<option value="01">1</option>
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
													<i class="fa fa-times-sign"></i> You have some form errors. Please check below.
												</div>
												<div class="successHandler alert alert-success no-display">
													<i class="fa fa-ok"></i> Your form validation is successful!
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">
														School Name <span class="symbol required"></span>
													</label>
													<input type="text" placeholder="" class="form-control" id="" name="">
												</div>
												<div class="form-group">
													<label class="control-label">
														Standard of Education <span class="symbol required"></span>
													</label>
													<select name="" id="" class="form-control">
																<option value=""></option>
																<option value="01">1</option>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">
														School Established Year <span class="symbol required"></span>
													</label>
													<input type="text" placeholder="" id="" name="" class="form-control">
												</div>
												<div class="form-group">
													<label class="control-label">
														School Govt Reg ID <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" name="" id="">
												</div>
												<div class="form-group">
													<label class="control-label">
														School Location State <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
												<div class="form-group">
													<label class="control-label">
														School Location District <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>  
                                                <div class="form-group">
													<label class="control-label">
														School Phone Number <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>                                                
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">
														Board Education <span class="symbol required"></span>
													</label>
													<select name="" id="" class="form-control">
																<option value=""></option>
																<option value="01">1</option>
													</select>
												</div>
                                                <div class="form-group">
													<label class="control-label">
														Is Boarding School <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>  
												<div class="form-group">
													<label class="control-label">
														School Recognized By <span class="symbol required"></span>
													</label>
													<select name="" id="" class="form-control">
																<option value=""></option>
																<option value="01">1</option>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">
														School Location <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														School Country <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														School Management Name <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
												</div>
                                                <div class="form-group">
													<label class="control-label">
														School E-Mail Id <span class="symbol required"></span>
													</label>
													<input type="text" class="form-control" id="" name="">
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
										</div><!-- /  tab -->	
                                        </div> <!-- / row -->
							
							
							</div>
					</div>
	</div>
</div>