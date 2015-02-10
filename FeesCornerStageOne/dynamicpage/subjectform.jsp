<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">

$(function(){
	
	
	$(document).on('input propertychange','#standardDef',function(){
	
		$.ajax({
			type:'post',
			url:'/fcds/defineSection',
			success:function(){
				
				
			},
			error:function(){
				
				
			}
			
			
		})
		
		
	})
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Subject Defintion</h3>
<form:select path="standardDefintionSet">
   <c:forEach var="standardDef" items="${standardDefintionSet}" varStatus="loopStatus">
   <form:option value="${standardDef.standardName}">${standardDef.standardName}</form:option>
 <%--  <option id="${standardDef.standardName}">${standardDef.standardName}<option/> --%>
   </c:forEach>

</form:select>
</body>
</html>