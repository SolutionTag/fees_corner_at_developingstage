var homestandardId,
 feesAssignmentJsonObject=new Object(),
 wantedforTermDefinition=new Object(),
 section=new Object(),
feesAssignmentJson={
	    "feesAmount": "",
	    "termAmountPercentage": "",
	    "monthAmountPercentage": "",
	    "dueAmountforFees": "",
	    "termAmount": "",
	    "monthAmount": ""
	},
	 arrayOfFeeses=[],
 stanardWiseFeesObject=new Object(),
 feesAssignmentDataArray=[];
$(document).ready(function(){
	/*feesAssignmentJsonObject=JSON.parse($("#feesAssignmentJsondivOne").text())
    wantedforTermDefinition=JSON.parse($("#feesAssignmentJsondivTwo").html())*/
	$("input[type=text][data-name=amountparticulars]").ForceNumericOnly();
	$("#standardsTab li").click(function(){
		 $("form[data-tablename=feesamountform]").css("display","none").attr("data-commonform","false")
		homestandardId=$(this).attr('data-standardid');
	
		/*TermComboBox(homestandardId)*/
		 var sectionid=$("select[name=section][id="+homestandardId+"] option:selected").attr('data-sectionid');
		 var nextsectionid=	 $("select[name=section][id="+homestandardId+"] option:selected").next().data('sectionid');
		 var termcompareid= $("select[name=term][id="+homestandardId+"] :selected").attr('data-termcompareid');
		 var groupassigned=$(this).attr('data-groupassigned');
		 if(groupassigned=="false"){
			 $("form[data-tablename=feesamountform]").css("display","none").attr("data-commonform","false")
			 var optionVal=  $("select[name=section][id="+homestandardId+"] option:selected").val();
			 if(optionVal != "111"){
					$("form[data-tablename=feesamountform][data-standardid="+homestandardId+"][data-sectionid="+sectionid+"]").css("display","");
					UnbindEventCommonAmountEntry(homestandardId,sectionid,"");
				}else{
					var nextsectionid=	 $("select[name=section][id="+homestandardId+"] option:selected").next().data('sectionid');
					$("form[data-tablename=feesamountform][data-standardid="+homestandardId+"][data-sectionid="+nextsectionid+"]").css("display","").attr("data-commonform","true")
					induceCommonAmountEntry(homestandardId,nextsectionid);
				}
				inducesectionComboBox(homestandardId);
		 }else if(groupassigned=="true"){
			 induceGroupComboBox(homestandardId);
				$("div [data-name=groupsectionsdiv]").css("display","none");
				$("select [name=groupsections]").css("display","none");
				var standardid=homestandardId
				var vocationalGroupId=$("select[name=groups][id="+standardid+"] :selected").data("groupcompareid")
				$("div [data-name=groupsectionsdiv][data-groupcompareid="+vocationalGroupId+"]").css("display","");
				$("select [name=groupsections][data-groupcomapareid="+vocationalGroupId+"][data-standardid="+standardid+"]").css("display","");
				var groupSectionValOnTabOpen=$("select[name=groupsections][data-groupcompareid="+vocationalGroupId+"][data-standardid="+standardid+"] :selected").val();
				if(groupSectionValOnTabOpen!="111"){
					var sectionid=$("select[name=groupsections][data-groupcompareid="+vocationalGroupId+"][data-standardid="+standardid+"] :selected").data('sectioncompareid');
					$("form[data-tablename=feesamountform][data-standardid="+standardid+"][data-sectionid="+sectionid+"]").css("display","");
					UnbindEventCommonAmountEntry(standardid,sectionid,vocationalGroupId);
				}else{
					var nextsectionid=$("select[name=groupsections][data-groupcompareid="+vocationalGroupId+"][data-standardid="+standardid+"] :selected").next().data('sectioncompareid');
					$("form[data-tablename=feesamountform][data-standardid="+standardid+"][data-sectionid="+nextsectionid+"]").css("display","").attr("data-commonform","true")
					induceCommonAmountEntry(standardid,nextsectionid);
				}
				induceGroupSectionComboBox(standardid,vocationalGroupId);
		 }
		
		
	});
	$("button[data-buttonname=feesassignmentsave]").unbind("click").click(function(){
		/*var allamounts=$(this).closest('form').children("div.table-responsive").children('table').find('tbody tr td input[data-name=feesamount]');*/
		var formData=$(this).closest('form').data();
		var allamounts="";
		var termId=formData.termid;
		var standardId=formData.standardid;
		var commonform =formData.commonform;
		if(commonform!=true){
		 allamounts=	$(this).closest('form').find('input');
		}else{
			allamounts=	$(this).closest('.tab-pane').find('form input');
		}
		var feesasignmentdata={"compareId":0,"feesAmount":0};
		 feesAssignmentDataArray=[];
		$.each(allamounts,function(k,v){
			feesasignmentdata={"compareId":0,"feesAmount":0};
			var compareId= $(this).data("sectionfeesid");
			var feesAmount=$(this).val();
			if(typeof compareId !="undefined" &&  feesAmount!=""){
				feesasignmentdata={"compareId":compareId,"feesAmount":parseInt(feesAmount)};
				feesAssignmentDataArray.push(feesasignmentdata);
			}else{
				return false;
			}
		});
		
		
		$.ajax({
			type : 'post',
			contentType: "application/json",
			url : '/fcds/finance/save-fees-amount',
			data:JSON.stringify(feesAssignmentDataArray),
			success : function(data) {
				alert("success");
			},
			error : function() {

			}

		})
		
	})
	
	
});


function inducesectionComboBox(standardId){
	$("select[name=section][id="+standardId+"]").unbind("change").change(function(event){
		$("form[data-tablename=feesamountform]").css("display","none").attr("data-commonform","false")
		var  optionVal=$(this.selectedOptions).val();
	
		var sectionid=$(this.selectedOptions).data('sectionid');
		var standardid=$(this.selectedOptions).data('standardid');
		if(optionVal != "111"){
			$("form[data-tablename=feesamountform][data-standardid="+standardid+"][data-sectionid="+sectionid+"]").css("display","");
			UnbindEventCommonAmountEntry(standardid,sectionid,"");
		}else{
			var nextsectionid=	 $(this.selectedOptions).next().data('sectionid');
			$("form[data-tablename=feesamountform][data-standardid="+standardid+"][data-sectionid="+nextsectionid+"]").css("display",""). $("form[data-tablename=feesamountform]").css("display","none").attr("data-commonform","true");
			induceCommonAmountEntry(standardid,nextsectionid);
		}
	})
}
function induceGroupComboBox(standardId){
	$("select[name=groups][id="+standardId+"]").unbind("change").change(function(event){
		
		$("div [data-name=groupsectionsdiv]").css("display","none");
		$("select [name=groupsections]").css("display","none");
		var standardid=this.id;
		var vocationalGroupId=$(this.selectedOptions).data('groupcompareid');
		$("div [data-name=groupsectionsdiv][data-groupcompareid="+vocationalGroupId+"]").css("display","");
		$("select [name=groupsections][data-groupcomapareid="+vocationalGroupId+"][data-standardid="+standardid+"]").css("display","");
		induceGroupSectionComboBox(standardid,vocationalGroupId);
	});
}

function induceGroupSectionComboBox(standardid,vocationalGroupId){
	$("select[name=groupsections][data-groupcompareid="+vocationalGroupId+"][data-standardid="+standardid+"]").unbind("change").change(function(){
		$("form[data-tablename=feesamountform]").css("display","none").attr("data-commonform","false")
		var  optionVal=$(this.selectedOptions).val();
		var groupcompareid=$(this).data("groupcompareid");
		var sectionid=$(this.selectedOptions).data('sectioncompareid');
		var standardid=$(this.selectedOptions).data('standardid');
		if(optionVal != "111"){
			$("form[data-tablename=feesamountform][data-standardid="+standardid+"][data-sectionid="+sectionid+"]").css("display","");
			UnbindEventCommonAmountEntry(standardid,sectionid,groupcompareid);
		}else{
			var nextsectionid=	$(this.selectedOptions).next().data('sectioncompareid');
			$("form[data-tablename=feesamountform][data-standardid="+standardid+"][data-sectionid="+nextsectionid+"]").css("display","").attr("data-commonform","true")
			induceCommonAmountEntry(standardid,nextsectionid);
		}
	})
}
/*	function TermComboBox(standardId)
	{
	$(document).unbind("change").on( "change","select[name=term][id="+standardId+"]",function(event){
		$("div[data-name=termheader]").css("display","none")
		$("div[data-name=termfrequncybody]").css("display","none");
	var termcompareid=$(this.selectedOptions).attr('data-termcompareid')
	 var sectionid=$("select[name=section][id="+standardId+"] option:selected").attr('data-sectionid');
	var nextsectionid=	 $("select[name=section][id="+standardId+"] option:selected").next().data('sectionid');
	if($("select[name=section][id="+standardId+"] option:selected").val()=="111"){
		 $("div [data-name=termfrequncybody][data-termid="+termcompareid+"][data-standardid="+standardId+"][data-sectionid="+nextsectionid+"]").css("display","");
		 $("div [data-name=termheader][data-termid="+termcompareid+"][data-standardid="+standardId+"][data-sectionid="+nextsectionid+"]").css("display","")
	}else{
		 $("div [data-name=termfrequncybody][data-termid="+termcompareid+"][data-standardid="+standardId+"][data-sectionid="+sectionid+"]").css("display","");
		 $("div [data-name=termheader][data-termid="+termcompareid+"][data-standardid="+standardId+"][data-sectionid="+sectionid+"]").css("display","")
	}
	
	});
	
}*/

function induceCommonAmountEntry(standardid,nextsectionid){
	$(" div [data-divname=feesDefinitionArea]").unbind("input propertychange").on("input propertychange","input[type=text][data-name=feesamount][data-standardid="+standardid+"][data-sectionid="+nextsectionid+"]",function(){
		var inputDatas= $(this).data();
		var value=	$(this).val();
		var groupid=inputDatas.groupid;
		var standardid=inputDatas.standardid;
		var termid=inputDatas.termid;
		var basefeesid=inputDatas.basefeesid;
		var frequencyid = inputDatas.frequencyid;
		if(groupid!="" && typeof groupid!="undefined"){
			$("input[type=text][data-name=feesamount][data-frequencyid="+frequencyid+"][data-groupid="+groupid+"][data-standardid="+standardid+"][data-basefeesid="+basefeesid+"]").val(value);
		}else{
			$("input[type=text][data-name=feesamount][data-frequencyid="+frequencyid+"][data-standardid="+standardid+"][data-basefeesid="+basefeesid+"]").val(value);
		}
	})
}
function UnbindEventCommonAmountEntry(standardid,sectionid,vocationalGroupId){
	document.querySelectorAll("div [data-divname=feesDefinitionArea] input[type=text][data-name=feesamount]").onchange=undefined;
	$("div [data-divname=feesDefinitionArea] input[type=text][data-name=feesamount]").off( "input propertychange", "**" );
	if(vocationalGroupId!=""){
		//$("input[type=text][data-name=feesamount][data-sectionid="+sectionid+"][data-standardid="+standardid+"]").val("");
		$("input[type=text][data-name=feesamount][data-groupid="+vocationalGroupId+"][data-standardid="+standardid+"][data-sectionid="+sectionid+"]").off( "input propertychange", "**" );
	}
	else{
		//$("input[type=text][data-name=feesamount][data-sectionid="+sectionid+"][data-standardid="+standardid+"][data-groupid="+vocationalGroupId+"]").val("");
		$("input[type=text][data-name=feesamount][data-standardid="+standardid+"][data-sectionid="+sectionid+"]").unbind("input propertychange").off( "input propertychange", "**" );
	}
}

	
$("div #feesDefinitionArea").on("input propertychange","input[type=text][data-name=amountparticulars][name=termAmountPercentage]",function(){
	setValueForHiddenDatas(this);
})

$("div #feesDefinitionArea").on("input propertychange","input[type=text][data-name=amountparticulars][name=monthAmountPercentage]",function(){
	setValueForHiddenDatas(this);
})
$("div #feesDefinitionArea").on("input propertychange","input[type=text][data-name=amountparticulars][name=feesAmount]",function(){
	var termPercentage= $(this.parentElement.parentElement.parentElement).children("div[name=termpercol]").children().children('input[name=termAmountPercentage]').val()
	var monthPercentage =$(this.parentElement.parentElement.parentElement).children("div[name=monthpercol]").children().children('input[name=monthAmountPercentage]').val()
	var marginAmount=this.value;
	var termAmout=fpercentStr(marginAmount,termPercentage);
	var monthAmout=fpercentStr(marginAmount,monthPercentage);
	$(this.parentElement.parentElement.parentElement).children("div[name=termpercol]").children().children('input[name=termAmount]').val(termAmout);
	$(this.parentElement.parentElement.parentElement).children("div[name=monthpercol]").children().children('input[name=monthAmount]').val(monthAmout);
})

function setValueForHiddenDatas(obj){
	var result= percentageValidator($(obj).val());
	if(typeof  result=="number"){
		var marginAmount=$(obj.parentElement.parentElement.parentElement).children('div [name=marginamountcol]').find('input[id=feesAmount]').val();
		var percentage=$(obj).val();
		obj.nextElementSibling.value=parseInt(marginAmount)+parseInt(fpercentStr(marginAmount,percentage));
	}else{
		obj.value="";
	}
		
}
function fpercentStr(quantity, percentString)
{
    var percent = new Number(percentString.replace("%", ""));
    return fpercent(quantity, percent);
}

function fpercent(quantity, percent)
{
    return quantity * percent / 100;
}
function percentageValidator(number){
	var percentage=new RegExp(/^\d{1,2}$/);
	if(percentage.test(number)){
		
		return parseInt(number);
	}
	else if(number!=""){
		alert("enter number between 0 t0 99")
		return false;
	}
}


/*var standardid=this.dataset.standardid;
var eachSectionFeeses=feesAssignmentJsonObject[standardid];
var icncr=0;
var feesObj={};
for(var i=0;i<eachSectionFeeses.length;i++){
	 var sectionFeeses= eachSectionFeeses[i];
	 $.each(sectionFeeses,function(key,val){
		 if(icncr < 1)
		 {
		var sectionId=key;
		 $.each(val,function(k,feesIds){
			 for(var j=0;j<feesIds.length;j++){
				 var sectionFeeses= feesAssignmentJsonObject[replicatestandardid][0];
				 var arrayOfFeesIds= sectionFeeses[replicatesectionid][0];
				 feesObj={};
				feesObj.compareId=feesIds[j];
				var serializedObject= $("div [data-name=termfrequncybody][data-standardid="+standardid+"][data-sectionid="+replicatesectionid+"][data-feesid="+arrayOfFeesIds[j]+"] input").serializeArray();
					$.each(serializedObject,function(index,obj){
						feesObj[obj.name]=obj.value;
						 });
				var newObject = jQuery.extend( {}, feesObj);
				arrayOfFeeses.push(newObject);
			 }
			 section[parseInt(sectionId)]=arrayOfFeeses;
			 arrayOfFeeses=[];
		 })
		 }
		// icncr++;
	 })
	 stanardWiseFeesObject[standardid]=section;
	 stanardWiseFeesObject.standardId=parseInt(standardid);
	 section=new Object();
}

var url="/fcds/finance/save-standard-feesparticulars";
$("#"+replicatesectionid).attr("action",url);
$("#"+replicatesectionid).attr("method","post")
 $("#"+replicatesectionid).append("<input type='hidden' name='customParameter' value='"+JSON.stringify(stanardWiseFeesObject)+"' />");
 //$("#"+replicatesectionid).submit();*/