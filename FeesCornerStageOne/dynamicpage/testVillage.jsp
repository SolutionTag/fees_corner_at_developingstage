<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveVillageBean" method="post">
		<form:input path="villageName" />
		<form:input path="villagePlace" />
		<form:input path="villageDistrict" />
		<input type="submit" value="Save Village Profile">
	</form:form>
</body>
</html>