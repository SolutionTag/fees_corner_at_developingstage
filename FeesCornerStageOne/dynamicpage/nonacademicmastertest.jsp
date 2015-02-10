<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fees Creation title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/trail/jquery-ui.js"></script>
<link href="${pageContext.request.contextPath}/resources/trail/jquery-ui.css">
<link href="${pageContext.request.contextPath}/resources/trail/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css?timestamp=${build.timestamp}"  > 
<script type="text/javascript">
var MONTHS=["JUNE","JULY ","AUGUST"," SEPT ","OCT" ,"NOV"," DEC" ,"JAN" ,"FEB"," MAR"," APR" ,"MAY "];
var feesFinalObj=new Object();
var feesParticulars=[];
var oldTerm=0;
var termWiseFeesDatas={
	    "feesId": "",
	    "feesName": "",
	    "standardId": "",
	    "standardName": "",
	    "sectionId": "",
	    "termWiseAmount": "",
	    "month":"",
	    "type":"TERM"
	}
$(document).ready(function(){
	jQuery.fn.ForceNumericOnly =
		function()
		{
		    return this.each(function()
		    {
		        $(this).keydown(function(e)
		        {
		            var key = e.charCode || e.keyCode || 0;
		            // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
		            // home, end, period, and numpad decimal
		            return (
		                key == 8 || 
		                key == 9 ||
		                key == 13 ||
		                key == 46 ||
		                key == 110 ||
		                key == 190 ||
		                (key >= 35 && key <= 40) ||
		                (key >= 48 && key <= 57) ||
		                (key >= 96 && key <= 105));
		        });
		    });
		};
		$("#termcount").ForceNumericOnly() ;
	 	$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
	    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
	    displayDate();
	    $(".table-bordered td").click(function(){
	        if($(this).attr("contentEditable") == true){
	            $(this).attr("contentEditable","false");
	        } else {
	            $(this).attr("contentEditable","true");
	        }
	    });
	    $(document).on('input propertychange', '#termcount', function(event) {
	    	if(event.target.value.length>1){
	    		event.target.value="";
	    	}

		})
		$("#splitTble").click(function(event){
			var standardId=$( "#tabs li[aria-selected=true]" ).attr('data-standardid');
			var stanadrdName=$( "#tabs li[aria-selected=true]" ).attr('data-stanadrdName');
			var tables=$( "#tabs li[aria-selected=true] a" ).attr('href')+" table"

			var termtableId="#"+$(tables+"[name=term]").attr('id');
			 var column= $("#feesAssignmentTermTable1 tr th").length;
			 var termcount= Math.round( MONTHS.length/$("#termcount").val());
			 
			var duplicate=MONTHS.length/$("#termcount").val();
			var termsize=0;
			resetTable(termsize,column,termtableId,termcount);
			for(var i=0;i<=$("#termcount").val();i++){
					if(i==0){
						termsize=1
					}else{
						termsize=i*termcount+1;
					}
					for(var j=1;j<column;j++){
					var	obj=$(termtableId+" tr:nth("+(termsize)+") td:nth("+j+")");
					var rowObj=$(termtableId+" tr:nth("+(termsize)+")");
					$(obj).attr("rowspan",termcount.toString());
					$(obj).attr('data-rowid',j);
						var columnIndex=$(obj).parent().children().index(obj);
						var feesId=$(obj).closest("table").find("th").eq(columnIndex).data("feesid")
						var feesName=$(obj).closest("table").find("th").eq(columnIndex).data("feesname")
						var termMonth=$(obj).closest("table").find("th").eq(columnIndex).text().trim();
						//alert("Fees Id"+feesId+"FeesName"+feesName);
						$(obj).attr("data-feesid",feesId);
						$(obj).attr("data-feesName",feesName);
						$(obj).attr("data-termMonth",termMonth);
						$(rowObj).attr("data-qualified","true");
						$(rowObj).attr("data-standardid",standardId);
						$(rowObj).attr("data-stanadrdName",stanadrdName);
					//	$("#feesAssignmentTable1 tr:nth("+(termsize)+") td:nth("+j+")").hide();
					}
			} 
			oldTerm=termcount;
			
		})
		function resetTable(termsize,column,termtableId,termcount){
	    	if(oldTerm!=0){
	    		termcount=oldTerm;
	    	}
	    
			for(var i=0;i<=termcount;i++){
				if(i==0){
					termsize=1
				}else{
					termsize=i*termcount+1;
				}
				
				for(var j=1;j<column;j++){
					var	obj=$(termtableId+" tr:nth("+(termsize)+") td:nth("+j+")");
					var rowObj=$(termtableId+" tr:nth("+(termsize)+")");
					$(obj).attr('data-rowid',j);
					//alert(j);
					$(obj).attr("data-feesid"," ");
					$(obj).attr("data-feesName"," ");
					$(obj).attr("data-termMonth"," ");
					$(rowObj).attr("data-qualified"," ");
					$(rowObj).attr("data-standardid"," ");
					$(rowObj).attr("data-stanadrdName"," ");
					$(obj).attr("rowspan",-termcount.toString());
				//	$("#feesAssignmentTable1 tr:nth("+(termsize)+") td:nth("+j+")").hide();
				}
				alert(termtableId);
		} 
		}
	    $(".saveFeesParticulars").click(function(){
	    	feesFinalObj=new Object();
	    	 /* feesFinalObj=new Object();
	    	 feesParticulars=[];
	    	 feesDatas=new Object(); */
	    	var selectedRows=$("#feesAssignmentTermTable1 tr[data-qualified=true]")
	    $.each(selectedRows,function(k,cells){
	    	var rowname=this.dataset.rowname;
	    	var standardid=this.dataset.standardid;
	    	var stanadrdName=this.dataset.stanadrdname;
	    	$.each(this.cells,function(k,v){
	    		if(k!=0){
	    		var feesId=this.dataset.feesid;
	    		var feesName=this.dataset.feesname;
	    	var feesAmount=this.textContent;
	    		
	    		termWiseFeesDatas={
	    			    "feesId": feesId,
	    			    "feesName":feesName,
	    			    "standardId": standardid,
	    			    "standardName": stanadrdName,
	    			    "sectionId": "",
	    			    "month": rowname,
	    			    "termWiseAmount":feesAmount,
	    			    "type":"TERM"
	    			    
	    			}
	    		feesParticulars.push(termWiseFeesDatas);
	    		}
	    		
	    	});
	    	feesFinalObj[rowname]=feesParticulars;
	    	feesParticulars=[];
	    	termWiseFeesDatas={
	    		    "feesId": "",
	    		    "feesName": "",
	    		    "standardId": "",
	    		    "standardName": "",
	    		    "sectionId": "",
	    		    "month": "",
	    		    "termWiseAmount":"",
	    		    "type":"TERM"
	    		}
	    	
	    })
	    	
	    });
})
function displayDate() {
     var today=new Date();
    // var date=today.toISOString().slice(0, -14);
     // Strip last 14 characters, ISO format is like
     // 2012-12-30T17:41:49.027Z but we want
     // 2012-12-30
     document.getElementById("feesCreatedDate").value=today;
  }
$(function(){
$("#createfees").click(function(){
	var serializeArray=$("#feescreationform").serializeArray();
	var serializeData={};
	
	$.each(serializeArray,function(k,v){
		console.log(v.name);
		console.log(v.value);
		serializeData[v.name]=v.value
	})
	console.log(serializeData)
	$.ajax({
			type : 'post',
			contentType: "application/json",
			url : '/fcds/settings/fees-creation',
			data:JSON.stringify(serializeData),
			success : function() {
	alert("saved")
			},
			error : function() {

			}

		})
	
})


		$(document).on('input propertychange', '#standardDef', function() {

		})
	});
</script>
<style type="text/css">
tr.noBorder td {border: 0; }
#c1, #c2 {
    width:auto ;
    height: auto;
    background: rgb(235, 243, 242);

}

#c3 {
    width: auto;
    height: 171px;
    background: rgb(235, 243, 242);
    }
#container{
  width: 70%;
  margin: auto;
  padding: 20px;
  border: 1px solid #666;
  background: #ffffff;
}
</style>
<script>
  /* $(function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
  });
 */ 
  </script>
<style>
  .ui-tabs-vertical { width: 55em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
 label {
    float: left;
    width: 20%;
    text-align: right;
    margin-right: 0.5em;

    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    -o-text-overflow: ellipsis;
}
.form-field-no-caption {
    margin-left: 20%;
    padding-left: 0.5em;
}
* { 
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
  </style>
</head>
<body>
	<div id="c1" style="color: rgb(19, 17, 17);font-size: 20px;" >
	Fees Creation Form
		<div id="container">
			<form name="feescreationform" id="feescreationform">
				<div>
					<input id="feesName" name="feesName"> 
				</div>
					<div>
					<input id="feesType" name="feesType"> 
				</div>
					<div>
					<input id="purpose" name="purpose"> 
				</div>
				<div>
					<input id="feesCreatedDate" name="feesCreatedDate"> 
				</div>
				<div>
				<button type="button"
						id="createfees" value="save" >Save</button>
				
				</div>
			</form>
		</div>
		<div class="refresh">
		<button><a href="${pageContext.request.contextPath}/academics/nonacademic-master-data">Refresh</a></button>
		</div>
	</div><br>
	<br>
	<br>
	<div id="c2">
<%-- 	<c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="standardLoop1">
		<c:if test="${standardDef.statusForChecked==false}">
	<a href="#">${standardDef.standardName} </a><br>
		
	       </c:if>
 </c:forEach>
		<h2>second div</h2>
		<h3>Fees List</h3>
		<c:forEach items="${setDef.schoolFeesDefSet}" var="feesdefinition" >
		<a href="#">${feesdefinition.feesName}</a>
		</c:forEach> --%>
		<div id="tabs">
  <ul>
  <c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="standardLoop1">
		<c:if test="${standardDef.statusForChecked==false}">
	 <li data-standardId="${standardDef.standardId}" data-stanadrdName="${standardDef.standardName}"><a href="#tabs-${standardLoop1.index}">${standardDef.standardName}</a></li>
       </c:if>
													       </c:forEach>
    <!-- <li><a href="#tabs-1">Nunc tincidunt</a></li>
    <li><a href="#tabs-2">Proin dolor</a></li>
    <li><a href="#tabs-3">Aenean lacinia</a></li> -->
  </ul>
 <c:forEach var="standardDef" items="${schoolMasterDataDefinition.schoolStandardsDefnition}" varStatus="standardLoop1">
  <div id="tabs-${standardLoop1.index}" >
  <!-- style="background:  rgb(228, 227, 188); " -->
    <h2>  ${standardDef.standardName} Standard Fees Definition</h2>
   <div class="col-md-6">
    <form>
    <c:forEach items="${setDef.schoolFeesDefSet}" var="feesdefinition" varStatus="incr">
    
	   <label class="control-label">${feesdefinition.feesName}</label>	
	   <input type="text" class="form-control" data-compareid="${feesdefinition.compareId}" id="schoolFeesDefSet[${incr.index }.feesId]">
	   
		</c:forEach>
		                                      
		</form>
    </div>
    <div class="col-md-6">
 		
       <label class="" style="text-overflow: clip;width: auto;">
			<input type="radio" class="" value="" checked="checked" name="selectwise">
			YEAR WISE</input>
		</label >
       <label class="" style="text-overflow: clip;width: auto;">
			<input type="radio" class="square-red" value="" checked="checked" name="selectwise">
			TERM WISE</input>
			<lable>Enter terms count</lable>
			<input type="text" name="termcount" id="termcount">
			<input type="button" value="go" id="splitTble"></input>
		</label>
        <label class="" style="text-overflow: clip;width: auto;">
			<input type="radio" class="square-red" value="" checked="checked" name="selectwise">
			MONTH WISE
		</label>
			</div>
			 <div class="col-md-12" >
     <div class="col-md-3" style="width: auto;">
	   <table class="table table-striped table-bordered table-hover table-full-width"  name="term" id="feesAssignmentTermTable${standardLoop1.index+1}">
				<thead>
					<tr>
						<th>Month</th>
						<c:forEach items="${setDef.schoolFeesDefSet}"
							var="feesdefinition" varStatus="incr">
							<th data-feesid="${feesdefinition.feesId}" data-feesname="${feesdefinition.feesName}">${feesdefinition.feesName}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody >
				<c:forEach items="${setDef.monthsList}" varStatus="monthincr" var="months">
					<tr bordercolor="red" class="noBorder" data-rowname="${months}">
						<td>${months}</td>
						<c:forEach items="${setDef.schoolFeesDefSet}"
							var="feesdefinition" varStatus="incr">
							<td></td>
						</c:forEach>
					</tr>
				</c:forEach>
							</tbody>
     </table>
     </div>
     <div class="col-md-3" style="width: auto;">
	   <table class="table table-striped table-bordered table-hover table-full-width"  name="month" id="feesAssignmentMonthTable${standardLoop1.index+1}">
				<thead>
					<tr data-rowname="${months}">
						<th>Month</th>
						<c:forEach items="${setDef.schoolFeesDefSet}"
							var="feesdefinition" varStatus="incr">
							<th data-feesid="${feesdefinition.feesId}" data-feesname="${feesdefinition.feesName}">${feesdefinition.feesName}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody >
				<c:forEach items="${setDef.monthsList}" varStatus="monthincr" var="months">
					<tr bordercolor="red" class="noBorder">
						<td>${months}</td>
						<c:forEach items="${setDef.schoolFeesDefSet}"
							var="feesdefinition" varStatus="incr">
							<td></td>
						</c:forEach>
					</tr>
				</c:forEach>
							</tbody>
     </table>
     </div>
     <input type="button" class="saveFeesParticulars">
     </div>
  </div>
  </c:forEach>
  
 
  
</div>
	</div>
</body>
</html>