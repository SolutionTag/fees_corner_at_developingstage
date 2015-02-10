<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="./resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	/* $('a[href="#settings"]').click(function(){
		  alert('Sign new href executed.'); 
		}); */
	
});


</script>
<style>
/* CSSTerm.com Simple CSS menu */
.menu_simple ul {
	margin: 0;
	padding: 0;
	width: 185px;
	list-style-type: none;
}

.menu_simple ul li a {
	text-decoration: none;
	color: white;
	padding: 10.5px 11px;
	background-color: #005555;
	display: block;
}

.menu_simple ul li a:visited {
	color: white;
}

.menu_simple ul li a:hover,.menu_simple ul li .current {
	color: white;
	background-color: #5FD367;
}

body {
	margin: 0px;
	background: #FCFCFC;
}

.header {
	height: 50px;
	background: #F0F0F0;
	border: 1px solid #CCC;
	width: 1340px;
	margin: 0px auto;
}

.content {
	width: 1340px;
	background: #F0F0F0;
	border: 1px solid #CCC;
	height: 2000px;
	margin: 20px auto;
}
form {
    border: 1px solid black;
    display: inline-block;
    text-align: left;    
}

body {
    text-align: center; 
}
.wrapper div {
    margin-bottom: 15px;
}
div > input, div > label {
    display: inline-block;
}
div > input {
    width: 77%;
}

div > label {
    width: 20%;
}

</style>
<script >

function submitForm(){
	alert("calling")
	
	document.forms[0].submit();
	
	
}

</script>
</head>
<body>

<head>
<link rel="stylesheet" type="text/css" href="menu.css" />
</head>
<body>

<c:set var="root" value="${pageContext.request.contextPath}"/>
	<div class="header" >
</div>
	<div class="content">
		<div class="menu_simple" style="width: 200px;position: absolute;">
			<ul>
			    <li><a href="#" id="academeics">Academics</a></li>
			    <li><a href="#" id="finance">Finance</a></li>
				<li><a href="#" id="hrmgnt">HR Management </a></li>
				<li><a href="#" id="hostel">Hostel</a></li>
				<li><a href="gotosettings" id="transport">Transport</a></li>
				<li><a href="#settings" id="settings"> Settings</a></li>
				<li><a href="standardDefinitionForm" > Go to Stnadard Defintion</a></li>
				<li><a href="subjectDefinitionForm" > Go to Subject Defintion</a></li>
				
				
				
			</ul>
		</div> 
		<div class="wrapper">
		<%-- commandName="schoolCollection" --%>
		<form:form action="formsubmission" method="POST" commandName="schoolCollection"  modelAttribute="schoolCollection">
		<input type="hidden" name="schoolName">
				<input type="hidden" name="schoolName" value="">
		
		 <div>
		<form:label   path="schoolName" >School Name</form:label>
		<form:input path="schoolName"  />
</div>
 <div>
		<form:label path="standardOfEducation" >Standard of Education</form:label>
		<form:select path="standardOfEducation">
			<form:option  value="PRE-PRIMARY">PRE-PRIMARY-SCHOOL[Ex:Pre-basic Nursery,Kinder Garden,Montessori Schools]</form:option>
			<form:option value="PRIMARY-SCHOOL">PRIMARY-SCHOOL[Ex:"+one+"to"+five+"]</form:option>
			<form:option value="MIDDLE-SCHOOL">MIDDLE-SCHOOL[Ex:"+one+"to"+eight+"/"+six+"to"+eight+"]"</form:option>
			<form:option value="HIGH-SCHOOL">HIGH-SCHOOL[Ex:"+six+"to"+twelve+"/"+one+"to"+twelve+"/"+nine+"to"+twelve+"/"+eleven+"to"+twelve+"(Truncated School)]</form:option>
		</form:select>
		</div>
		 <div>
		<form:label path="educationBoard" >Education Board</form:label>
		<form:select path="educationBoard">
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
 <div>
		<form:label path="schoolRecognizedBy" >School Recognized By</form:label>
		<form:select path="schoolRecognizedBy">
			<form:option value="SCH-EDU">The Director of School Education</form:option>
			<form:option value="ELEM-EDU">The Director of Elementary Education</form:option>
			<form:option value=" MATRIC-SCH">The Director of Matriculation School</form:option>
			<form:option value="TCHR-EDU-RSRCH-TR">The Director of Teacher Education ,Research and Training</form:option>
		</form:select>
</div>
 <div>
		<form:label path="schoolGovernmentRegId" >School Govt Reg Id</form:label>
		<form:input path="schoolGovernmentRegId" />
</div>
 <%-- <div>
		<form:label path="schoolEstablishedYear" >School Established year</form:label>
		<form:input path="schoolEstablishedYear" type="date" />
</div> --%> 
 <div>
		<form:label path="schoolLocation" >School Location</form:label>
		<form:input path="schoolLocation" />
</div>
 <div>
		<form:label path="schoolLocatedDistrict" >School Locate District</form:label>
		<form:input path="schoolLocatedDistrict" />
</div>
 <div>
		<form:label path="schoolLocatedState" >School Located State</form:label>
		<form:input path="schoolLocatedState" />
</div>
 <div>
		<form:label path="schoolVision" >School Vision</form:label>
		<form:textarea path="schoolVision" />
</div>
 <div>
		<form:label path="schoolMission" >School Mission</form:label>
		<form:textarea path="schoolMission" />
</div>
<div>
		<form:label path="schoolLongTermGoal" >School Long Term Goal</form:label>
		<form:input path="schoolLongTermGoal" />
</div>
 <div>
		<form:label path="schoolPhoneNumbers" >School Phone Numbers</form:label>
		<form:input path="schoolPhoneNumbers"  />
</div>
 <div>
		<form:label path="schoolEmailId" >School Email Id</form:label>
		<form:input path="schoolEmailId" />
 </div>
 <div>
 
  <spring:bind path="schoolMasterData"/>
  
<%--  <form:input path="schoolMasterData"/> 
 --%> 
<%--  <spring:bind path="schoolMasterData"/>
 --%><%-- <input type="hidden" name="schoolMasterData" value="${schoolCollection.schoolMasterData}">
 --%>
 <!-- <input type="text" name="{schoolMasterData}">
 <input type="hidden" name="{schoolCollection.schoolMasterData}"> -->
 
  </div>
<input type="submit"/>
</form:form>
	</div>
	</div>
</body>
</html>

