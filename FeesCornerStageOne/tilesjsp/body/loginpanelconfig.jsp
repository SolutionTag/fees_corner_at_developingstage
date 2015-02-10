<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
					<!-- start: PAGE HEADER -->
                    <br><br>
				  <div class="row">
						<div class="col-sm-12">
							<!-- start: PAGE TITLE & BREADCRUMB -->
							<div class="page-header">
								<h1>Login Page<small></small></h1>
							</div>
							<!-- end: PAGE TITLE & BREADCRUMB -->
						</div>
					</div>
                    
					<!-- end: PAGE HEADER -->
					<!-- start: PAGE CONTENT -->
                    <div class="row">
                    <div class="col-md-8"><!--  row 2-->
                    </div>
                    <div class="col-md-4"><!--  row 2-->
					<!-- start: LOGIN BOX -->
                    <div class="panel panel-default">
								<div class="panel-heading">
									<i class="fa fa-external-link-square"></i>
									Login to FC
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
			<div class="box-login" style="display: block;">
				<h3>Sign in to your account</h3>
				<p>
					Please enter your name and password to log in.
				</p>
				<form:form cssClass="form-login" action="#"  novalidate="novalidate" >
				
				
				
				</form:form>
				
				<form:form cssClass="form-login" action="determineUser" method="POST"  novalidate="novalidate" modelAttribute="admincredentials">
					<div class="errorHandler alert alert-danger no-display">
						<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
					</div>
					<fieldset>
						<div class="form-group">
							<span class="input-icon">
							<form:input path="adminLoginUserName" cssClass="form-control" placeholder="Username"/>
								<i class="fa fa-user"></i> </span>
							<!-- To mark the incorrectly filled input, you must add the class "error" to the input -->
							<!-- example: <input type="text" class="login error" name="login" value="Username" /> -->
						</div>
						<div class="form-group form-actions">
							<span class="input-icon">
								<form:password path="adminLoginPassword"  cssClass="form-control password" placeholder="password"/>
								<i class="fa fa-lock"></i>
								<a class="forgot" href="#" style="color: #909090;font-size: 12px;position: absolute;right: 10px;text-shadow: 1px 1px 1px #FFFFFF;top: 9px;">
									I forgot my password
								</a> </span>
						</div>
						<div class="form-actions">
							<label for="remember" class="checkbox-inline">
								<div class="icheckbox_minimal-grey" style="position: relative;"><input type="checkbox" class="grey remember" id="remember" name="remember" style="position: absolute; top: -10%; left: -10%; display: block; width: 120%; height: 120%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"><ins class="iCheck-helper" style="position: absolute; top: -10%; left: -10%; display: block; width: 120%; height: 120%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins></div>
								Keep me signed in
							</label>
							<button type="submit" class="btn btn-bricky pull-right">
								Login <i class="fa fa-arrow-circle-right"></i>
							</button>
						</div>
					</fieldset>
</form:form>				
				
				
			</div>
			<!-- end: LOGIN BOX -->
            	<!-- start: FORGOT BOX -->
			<div class="box-forgot" style="display: none;">
				<h3>Forget Password?</h3>
				<p>
					Enter your e-mail address below to reset your password.
				</p>
				<form class="form-forgot" novalidate="novalidate">
					<div class="errorHandler alert alert-danger no-display">
						<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
					</div>
					<fieldset>
						<div class="form-group">
							<span class="input-icon">
								<input type="email" class="form-control" name="email" placeholder="Email">
								<i class="fa fa-envelope"></i> </span>
						</div>
						<div class="form-actions">
							<a class="btn btn-light-grey go-back">
								<i class="fa fa-circle-arrow-left"></i> Back
							</a>
							<button type="submit" class="btn btn-bricky pull-right">
								Submit <i class="fa fa-arrow-circle-right"></i>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
			<!-- end: FORGOT BOX -->
            </div><!-- / Panel Body -->
            </div><!-- / row 2-->
            </div>
					<!-- end: PAGE CONTENT-->
				</div>
			</div>