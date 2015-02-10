<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
var standardJson={standardId:"",managementId:"",standardName:""};
var selectedStandards;
var standardArray=[];
$(document).ready(function(){
	var lis = $("ol li").each(function(i, el)
			{
			    $(this).data("index", i+1);
			});


$(document).on('click','#saveStandard',function(){
	selectedStandards=$("#standardLists input[type='checkbox']:checked");
	if(selectedStandards.length!=0)
	{
		$.each(selectedStandards,function(key,value){
			var standardName=$(this).parent().data('index');
			var standardId="STD0"+standardName;
			standardJson.standardName=standardName;
			standardJson.standardId=standardId;
			standardArray.push(standardJson);
			standardJson={standardId:"",managementId:"",standardName:""};
		});
		
		$.ajax({
			type:'post',
			url:"/fcds/saveStandard",
			data : "standardArray="+JSON.stringify(standardArray),
			success:function(data){
				
			},
			error:function(){
				
				
			}
			
		})
		
	}
	else
	{
		alert("Please select atleast one standard to add.");
		
	}
});
})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.checkbox-grid li {

    float: left;
    width: 25%;
}
.checkbox-grid input {

    float: left;
    width: 25%;
}
</style>
</head>
<body>
<h3>Subject Definition</h3>
	<%-- <form:form name="standardDefinitionFrom" action="saveStandard" method="post" modelAttribute="standardDefinition">
 <div>
		<form:label path="standardName" >Standard Name</form:label>
		<form:input path="standardName" />
</div>
<input type="submit">

</form:form> --%>

<ol type="I" class="checkbox-grid" id="standardLists">
    <li value=""><input type="checkbox" /></li>
    <li value=""><input type="checkbox" /></li>
    <li value=""><input type="checkbox" /></li>
    <li value=""><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
    <li><input type="checkbox" /></li>
</ol>

<div class="checkbox-grid">
<input type="button" id="saveStandard" value="Save Standards">
<input type="button" value="Reset All">
<input type="button" id="removestandard" value="Remove Selected">

</div>
</body>
</html>