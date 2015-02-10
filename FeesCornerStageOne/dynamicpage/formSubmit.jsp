<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form  action="formsubmission" method="POST">


<div>
		<form:label   path="schoolName" >School Name</form:label>
		<form:input path="schoolName" />
</div>
 <div>
		<form:label path="standardOfEducation" >Standard of Education</form:label>
		<form:select path="standardOfEducation">
			<form:option value="PRE-PRIMARY-SCHOOL[Ex:Pre-basic Nursery,Kinder Garden,Montessori Schools]">PRE-PRIMARY-SCHOOL[Ex:Pre-basic Nursery,Kinder Garden,Montessori Schools]</form:option>
			<form:option value="PRIMARY-SCHOOL[Ex:\"+one+\"to\"+five+\"]">PRIMARY-SCHOOL[Ex:"+one+"to"+five+"]</form:option>
			<form:option value="MIDDLE-SCHOOL[Ex:\"+one+\"to\"+eight+\"/\"+six+\"to\"+eight+\"]">MIDDLE-SCHOOL[Ex:"+one+"to"+eight+"/"+six+"to"+eight+"]"</form:option>
			<form:option value="HIGH-SCHOOL[Ex:\"+six+\"to\"+twelve+\"/\"+one+\"to\"+twelve+\"/\"+nine+\"to\"+twelve+\"/\"+eleven+\"to\"+twelve+\"(Truncated School)]">HIGH-SCHOOL[Ex:"+six+"to"+twelve+"/"+one+"to"+twelve+"/"+nine+"to"+twelve+"/"+eleven+"to"+twelve+"(Truncated School)]</form:option>
		</form:select>
		</div>
		 <div>
		<form:label path="educationBoard" >Education Board</form:label>
		<form:select path="educationBoard">
			<form:option value="CBSE-central Board for Secondary Education.">CBSE-central Board for Secondary Education.</form:option>
			<form:option value="Matriculation-Matriculation Board is typically found in in Tamil Nadu and Pondicherry schools">Matriculation-Matriculation Board is typically found in in Tamil Nadu and Pondicherry schools.</form:option>
			<form:option value="State boards-State Board - Virtually, every state in India has its own board">State boards-State Board - Virtually, every state in India has its own board.</form:option>
			<form:option value="ICSE-Indian Certificate of Secondary Education">ICSE-Indian Certificate of Secondary Education.</form:option>
			<form:option value="ISC - Indian School Certificate">ISC - Indian School Certificate</form:option>
			<form:option value="IGCSE (International General Certificate of Secondary Education) is a curriculum spread over classes IX and X. ">IGCSE (International General Certificate of Secondary Education) is a curriculum spread over classes IX and X. </form:option>
			<form:option value="Cambridge O-level,O -levels provide a curriculum spread over classes IX and X.">Cambridge O-level,O -levels provide a curriculum spread over classes IX and X.</form:option>
			<form:option value="Cambridge A-level">Cambridge A-level</form:option>
			<form:option value="IB-IB (International Baccalaureate) offers high quality programmes for children from ages 3 to 19">IB-IB (International Baccalaureate) offers high quality programmes for children from ages 3 to 19.</form:option>
			<form:option value="ISC - Indian School Certificate">ISC - Indian School Certificate</form:option>
			<form:option value="Cambridge A-level">Cambridge A-level</form:option>
		</form:select>
</div>
 <div>
		<form:label path="schoolRecognizedBy" >School Recognized By</form:label>
		<form:select path="schoolRecognizedBy">
			<form:option value="The Director of School Education">The Director of School Education</form:option>
			<form:option value="The Director of Elementary Education">The Director of Elementary Education</form:option>
			<form:option value="The Director of Matriculation School">The Director of Matriculation School</form:option>
			<form:option value="The Director of Teacher Education ,Research and Training">The Director of Teacher Education ,Research and Training</form:option>
		</form:select>
</div>
 <div>
		<form:label path="schoolGovernmentRegId" >School Govt Reg Id</form:label>
		<form:input path="schoolGovernmentRegId" />
</div>
  <div>
		<form:label path="schoolEstablishedYear" >School Established year</form:label>
		<form:input path="schoolEstablishedYear" type="date" />
		
</div> 


<input type="submit">
</form:form>




</body>
</html>