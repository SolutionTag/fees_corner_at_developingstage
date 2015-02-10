<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <center><h3>school creation form</h3></center>
	<form:form  method="post" action="/schoolcreationform">
		<form:label path="school Name" />
		<form:input path="schoolName" />

		<form:label path="standardOfEducation" />
		<form:select path="standardOfEducation">
			<form:option value="">PRE-PRIMARY-SCHOOL[Ex:Pre-basic Nursery,Kinder Garden,Montessori Schools]</form:option>
			<form:option value="">PRIMARY-SCHOOL[Ex:"+one+"to"+five+"]</form:option>
			<form:option value="">MIDDLE-SCHOOL[Ex:"+one+"to"+eight+"/"+six+"to"+eight+"]"</form:option>
			<form:option value="">HIGH-SCHOOL[Ex:"+six+"to"+twelve+"/"+one+"to"+twelve+"/"+nine+"to"+twelve+"/"+eleven+"to"+twelve+"(Truncated School)]</form:option>
		</form:select>
		
		<form:label path="Education Board" />
		<form:select path="educationBoard">
			<form:option value="">CBSE-central Board for Secondary Education.</form:option>
			<form:option value="">Matriculation-Matriculation Board is typically found in in Tamil Nadu and Pondicherry schools.</form:option>
			<form:option value="">State boards-State Board - Virtually, every state in India has its own board.</form:option>
			<form:option value="">ICSE-Indian Certificate of Secondary Education.</form:option>
			<form:option value="">ISC - Indian School Certificate</form:option>
			<form:option value="">IGCSE (International General Certificate of Secondary Education) is a curriculum spread over classes IX and X. </form:option>
			<form:option value="">Cambridge O-level,O -levels provide a curriculum spread over classes IX and X.</form:option>
			<form:option value="">Cambridge A-level</form:option>
			<form:option value="">IB-IB (International Baccalaureate) offers high quality programmes for children from ages 3 to 19.</form:option>
			<form:option value="">ISC - Indian School Certificate</form:option>
			<form:option value="">Cambridge A-level</form:option>
		</form:select>

		<form:label path="School RecognizedBy" />
		<form:select path="schoolRecognizedBy">
			<form:option value="">The Director of School Education</form:option>
			<form:option value="">The Director of Elementary Education</form:option>
			<form:option value="">The Director of Matriculation School</form:option>
			<form:option value="">The Director of Teacher Education ,Research and Training</form:option>
		</form:select>

		<form:label path="School Government RegId" />
		<form:input path="schoolGovernmentRegId" />

		<form:label path="School Established Year" />
		<form:input path="schoolEstablishedYear" />

		<form:label path="School Location" />
		<form:input path="schoolLocation" />

		<form:label path="School Located District" />
		<form:input path="schoolLocatedDistrict" />

		<form:label path="School Located State" />
		<form:input path="schoolLocatedState" />

		<form:label path="School Vision" />
		<form:textarea path="schoolVision" />

		<form:label path="School Mission" />
		<form:textarea path="schoolMission" />

		<form:label path="SchoolLong TermGoal" />
		<form:input path="schoolLongTermGoal" />

		<form:label path="School Phone Numbers" />
		<form:input path="schoolPhoneNumbers" />

		<form:label path="School EmailId" />
		<form:input path="schoolEmailId" />
		
		<input type="submit" value="CreateSchoo">
	</form:form>

</body>
</html>

