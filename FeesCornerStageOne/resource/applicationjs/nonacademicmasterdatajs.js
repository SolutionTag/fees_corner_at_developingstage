var availableFeesObj,
wantedForFeesAssignment=new Object(),
MONTHS=["JUNE","JULY ","AUGUST"," SEPT ","OCT" ,"NOV","DEC" ,"JAN" ,"FEB"," MAR","APR" ,"MAY "],
termDefinitionJson=new Object();
$(document).ready(function(){
wantedForFeesAssignment=JSON.parse($("#generateJson").html());
	TD2.init();
	TD3.init();
	displayDate();
	availableFeesObj=$("#availablefees li").clone();
	initDefaultSection($("#standardList option:first").data('standardid'));
	//$("select[data-name=section]").css('display','none');
	//$("#assignedfees, #availablefees" ).sortable({opacity:0.5,connectWith: ".cond"}).disableSelection();	
	
	$( "#assignedfees" ).sortable({opacity:0.5,connectWith: ".cond",
		receive:function(event,ui){
			$(ui.item).attr('data-validforstore',"true");
			var standardId=$("#standardList option:selected").data('standardid');
			var particularsectionid=$("select[data-standardid="+standardId+"][data-currentsection=true] option:selected").data('sectionid');
			if(typeof particularsectionid!="undefined"){
				$(ui.item).attr('data-standardid',standardId);
				$(ui.item).attr('data-sectionid',"111");
			}
			else{
				$(ui.item).attr('data-standardid',standardId);
				$(ui.item).attr('data-sectionid',"111");
			}
			
			
			
		}
	
	}).disableSelection();
	
	$( "#availablefees" ).sortable({opacity:0.5,connectWith: ".cond",
		receive:function(event,ui){
			$(ui.item).attr('data-validforstore',"false");
		}	
	
	}).disableSelection();
	
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
					document.getElementById("feescreationform").reset();
					displayDate();
				alert("saved");
				},
				error : function() {

				}

			})
		
	})
	$("select[name=term]").change(function(){
		$("select[data-name=section]").css('display','none').attr("data-currentsection","false");
		$("div [data-name=vocationalgroupdiv] select[name=vocationalgroupselect]").attr("data-currentgroup","false");
		$("select[data-name=section]").val("111");
		$("select[data-name=section]").css('display','none');
		$("div [data-name=vocationalgroupdiv]").css('display','none');
		$("#assignedfees li").css("display","none");
		$("#assignedfees li").attr("data-validforstore","false");
		$("#availablefees li").css("display","none");
		$("#standardList").val($("#standardList option:first").val())
		
		var standardId=$("#standardList option:first").data('standardid');
		var groupassigned=$("#standardList option:first").data('groupassigned');
		if(groupassigned==true){
			$("div [data-name=vocationalgroupdiv]").css('display','');
			$("div [data-name=vocationalgroupdiv] select[name=vocationalgroupselect][data-standardid="+standardId+"]").css('display','').attr("data-currentgroup","true");
		}else{
			$("select[data-name=section][data-standardid="+standardId+"]").css('display','').attr("data-currentsection","true");
		}
	})
	
	$("#standardList").change(function(event){
		$("select[data-name=section]").css('display','none').attr("data-currentsection","false");
		$("div [data-name=vocationalgroupdiv] select[name=vocationalgroupselect]").attr("data-currentgroup","false")
		$("select[data-name=section]").val("111");
		$("select[data-name=section]").css('display','none');
		$("div [data-name=vocationalgroupdiv]").css('display','none');
		$("div [data-name=sectiondiv]").css('display','none');
		
		$("#assignedfees li").css("display","none");
		$("#assignedfees li").attr("data-validforstore","false");
		$("#availablefees li").css("display","");
		
		$("div [data-name=vocationalgroupdiv] select[name=vocationalgroupselect]").css('display','none');
		var standardId=$(this.selectedOptions).data('standardid');
		var groupassigned=$(this.selectedOptions).data('groupassigned');
		
		
		if(groupassigned==true){
			$("div [data-name=vocationalgroupdiv]").css('display','');
			$("div [data-name=vocationalgroupdiv] select[name=vocationalgroupselect][data-standardid="+standardId+"]").css('display','').attr("data-currentgroup","true");
		}else{
			$("div [data-name=sectiondiv]").css('display','');
			$("div [data-name=sectiondiv] select[data-name=section][data-standardid="+standardId+"]").css('display','').attr("data-currentsection","true");
		}
		
	//	$("#assignedfees li[data-standardid="+standardId+"]").css("display","");
		var  qualifiedFees=$("#assignedfees li[data-standardid="+standardId+"]");
		if(qualifiedFees.length!=0){
			qualifiedFees.each(function(question,answer){
				$("#availablefees li[data-basefeesid="+$(this).attr("data-basefeesid")+"]").css("display","none");
			})
	}
	else{
		$("#availablefees li").css("display","");
	}
		
		//$("#assignedfees li[data-standardid="+standardId+"]").attr("data-validforstore","true");
	});
	$("#feesAssignmentSave").click(function(){
		var sectionFeeses=new Object();
		var finalFeesAssignmentData=new Object();
		var assignedFeeses=$("#assignedfees li[data-validforstore=true]");
		var particularsectionid=$("select[data-name=section][data-currentsection=true] option:selected").data('sectioncomparedid');
		var sectionType =$("select[data-name=section][data-currentsection=true]").val();
		var standardId=$("#standardList option:selected").data('standardid');
		var groupassigned=$("#standardList option:selected").data('groupassigned'); 
		var groupId=$("select[data-currentgroup=true] :selected").data('groupid')
		var optionsArray="";
		 if(groupassigned==true && typeof groupId !="undefined"){
				 optionsArray=wantedForFeesAssignment[groupId];
				 sectionType=	 $("select[data-name=section][data-currentsection=true]").val();
				  particularsectionid=$("select[data-name=section][data-currentsection=true] option:selected").data('sectioncomparedid');
		 }else{
				 optionsArray=wantedForFeesAssignment[standardId];
		 }
	
		var termId=$("select[name=term] :selected").data('termcompareid')
		
		 var indexIds=[];
		 assignedFeeses.each(function(feeskey,feesObj){
				indexIds.push(parseInt(feesObj.dataset.basefeesid));
			});
		 if(sectionType=="111"){
				for(var oA=0;oA<optionsArray.length;oA++){
					console.log(optionsArray[oA])
					console.log(sectionFeeses)
					sectionFeeses[optionsArray[oA].sectionId]=indexIds;
				}
				if(indexIds.length!=0){
					finalFeesAssignmentData.allSectionFeesSame=true;
				}else{
					finalFeesAssignmentData.allSectionFeesSame=false;				
					}
				
			}else{
				sectionFeeses[particularsectionid]=indexIds;
				var existingFeesesForCurrentStandard=[];
				var currentFeesesForCurrentStandard=[];
				$("#assignedfees li[data-validforstore=false][data-standardid="+standardId+"]").each(function(){
					existingFeesesForCurrentStandard.push($(this).attr('data-basefeesid'))
					});
				$("#assignedfees li[data-validforstore=true][data-standardid="+standardId+"]").each(function(){
					currentFeesesForCurrentStandard.push($(this).attr('data-basefeesid'))
					});
				
				for ( var i = 0; i < currentFeesesForCurrentStandard.length; i++) {
					var index = existingFeesesForCurrentStandard
							.indexOf(currentFeesesForCurrentStandard[i]);
					if (index == -1) {
						finalFeesAssignmentData.allSectionFeesSame = false;
						break;
					} else {
						finalFeesAssignmentData.allSectionFeesSame = true;
					}
				}
				if(currentFeesesForCurrentStandard.length==0){
					finalFeesAssignmentData.allSectionFeesSame = false;
				}
			}
		 if(groupassigned==true && groupId !=""){
			 finalFeesAssignmentData.standardId=standardId;
			 finalFeesAssignmentData.sectionData=sectionFeeses;
			 finalFeesAssignmentData.termId=termId;
			 finalFeesAssignmentData.isGroupAssigned=groupassigned;
			 finalFeesAssignmentData.groupId= groupId;
			 
		 }else{
			 finalFeesAssignmentData.standardId=standardId;
			 finalFeesAssignmentData.sectionData=sectionFeeses;
			 finalFeesAssignmentData.termId=termId;
			 finalFeesAssignmentData.isGroupAssigned="false";
			 finalFeesAssignmentData.groupId= 0;
		 }
		 
		// alert(JSON.stringify(finalFeesAssignmentData));
		 $.ajax({
				type:"post",
				cache: false,
				url:"/fcds/settings/feesAssignment",
				data : "finalAssignmentData="+JSON.stringify(finalFeesAssignmentData),
				success:function(data){
					alert(data);
				},
				error:function(){
				}
				
			})
	});
	
/*	$("#termPeriod").change(function(){
		$("#frequency").children().remove();
		var endmonths=parseInt($(this.selectedOptions).val());
		var cycle= parseInt(MONTHS.length/endmonths);
		var newMonthObject = jQuery.extend( [], MONTHS);
		var frequencyhtml='';
		var termfrequecncy='{'
			var termfrequencyArray=[];
		for(var i=0;i<cycle;i++){
			var termfrequency={"termFrequencyName":"","sort":""};
		var months=	newMonthObject.splice(0,endmonths);
		termfrequecncy+=months[0].toLowerCase()+"-"+months[months.length-1].toLowerCase()+',';
		 frequencyhtml+="<div class=\"col-md-"+cycle+"\">"+
			 "<label class=\"checkbox-inline\">"+
			"<input type=\"checkbox\" class=\"flat-orange\"  checked=\"checked\" disabled=\"disabled\" >"+
			"<big>"+months[0].toLowerCase()+"-"+months[months.length-1].toLowerCase()+"</big>"+
			"</label>"+
			"</div>";
		 termfrequency.termFrequencyName=months[0].toLowerCase()+"-"+months[months.length-1].toLowerCase();
		 termfrequency.sort=i+1;
		 termfrequencyArray.push(termfrequency);
		}
		var removecomma=termfrequecncy.lastIndexOf(",")
	    termfrequecncy=termfrequecncy.substring(0,removecomma)+"}"
		termfrequecncy.replace(removecomma,"");
		//$("#termFrequency").val(termfrequecncy);
		termDefinitionJson.termFrequency=termfrequecncy;
		termDefinitionJson.termFrequencySet=termfrequencyArray;
		//$("#termFrequencySet").val(JSON.stringify(termDefinitionJson));
		$("#frequency").append(frequencyhtml);
		$("#frequency input[type=checkbox]").iCheck({checkboxClass: 'icheckbox_flat-orange',radioClass: 'iradio_flat-green'});
		$("#frequency .icheckbox_flat-orange").removeClass('disabled')
	});*/
	$("#createterm").click(function(){
		termDefinitionJson.termName=$("#termName").val();
		var termfrequency={"termFrequencyName":"","sort":""};
		var termfrequecncy='{'
			var termfrequencyArray=[];
		$("div[data-active=true] input[data-name=period]:checked").each(function(k,obj){
			termfrequency={"termFrequencyName":"","sort":""};
			termfrequecncy+=$(obj).val()+',';
			 termfrequency.termFrequencyName=$(obj).val().toLowerCase();
			termfrequency.sort=k+1;
			 termfrequencyArray.push(termfrequency);
			});
		
		var removecomma=termfrequecncy.lastIndexOf(",")
	    termfrequecncy=termfrequecncy.substring(0,removecomma)+"}"
		termDefinitionJson.termFrequency=termfrequecncy;
		termDefinitionJson.termFrequencySet=termfrequencyArray;
		
		/*var size=termDefinitionJson.termFrequencySet.length	 
		for(var i=0;i< size;i++)
		{
			
		var newObject = jQuery.extend( {}, termDefinitionJson);
		termDefinitionJson.termFrequencySet[i].schoolTermDef=newObject
		}*/
		
		 $.ajax({
				type:"post",
				contentType: "application/json",
				url:"/fcds/settings/term-definition",
				data :JSON.stringify(
						{
					termName:$("#termName").val(),
					termFrequency:termDefinitionJson.termFrequency,
					termPeriod:$("#termPeriod").val(),
					termFrequencySet: termDefinitionJson.termFrequencySet
					}
						),
				success:function(data){
					alert(data);
				},
				error:function(){
				}
				
			})
		
	})

});
function displayDate() {
    var today=new Date();
    document.getElementById("feesCreatedDate").value=today;
 }
function initDefaultSection(standardId){
	$("select[data-name=section][data-standardid="+standardId+"]").css('display','').attr("data-currentsection","true");
	
}
$(document).on("change","select[data-name=section][data-currentsection=true]",function(){
	if($(this.selectedOptions).val()!="111"){
		$("#assignedfees li").css("display","none");
		$("#assignedfees li").attr("data-validforstore","false");
		$("#availablefees li").css("display","");
		var groupid="";
		var standardId=$(this.selectedOptions).data('standardid');
		var sectionid=$(this.selectedOptions).data('sectionid');
		if(typeof standardId=="undefined"){
		 groupid=$(this.selectedOptions).data('groupid');
		 standardId=$("select[data-currentgroup=true] option[data-groupid="+groupid+"]").attr('data-standardid')
		}
		var termid=$("select[name=term] :selected").attr('data-termcompareid');
		var termfrequencyIds=$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"][data-termid="+termid+"]").map(function(index,val){
			return $(val).data('termfrequencyid')
			});
		var baseFeesIds=$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"][data-termid="+termid+"]").map(function(index,val){
			return $(val).data('basefeesid')
			});
		var distinctFrequencyIds=$.distinct(termfrequencyIds);
		var distinctBaseFeesIds=$.distinct(baseFeesIds);
		for(var i=0;i<distinctBaseFeesIds.length;i++){
			$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"][data-termid="+termid+"][data-basefeesid="+distinctBaseFeesIds[i]+"][data-termfrequencyid="+distinctFrequencyIds[i]+"]:first").css("display","").attr("data-validforstore","true");
		}
		//$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"][data-termid="+termid+"]").css("display","");
		//$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"]").css("display","");
		var qualifiedFees=$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"][data-termid="+termid+"]");
		$("#availablefees li").remove();
		$(availableFeesObj).css("display","");
		$("#availablefees").append(availableFeesObj)
		if(qualifiedFees.length!=0){
				qualifiedFees.each(function(question,answer){
					$("#availablefees li[data-value="+$(this).attr("data-basefeesid")+"]").css("display","none");
				})
		}
		else{
			$("#availablefees li").css("display","");
		}
		//$("#assignedfees li[data-standardid="+standardId+"][data-sectionid="+sectionid+"]").attr("data-validforstore","true");
	}else{
		var standardId=$(this.selectedOptions).attr('data-standardid');
		$("#assignedfees li").css("display","none");
		$("#assignedfees li").attr("data-validforstore","false");
		$("#availablefees li").css("display","");
		var qualifiedFees=	$("#assignedfees li[data-standardid="+standardId+"]");
		$("#availablefees li").remove();
		$(availableFeesObj).css("display","");
		$("#availablefees").append(availableFeesObj);
			if(qualifiedFees.length!=0){
				
		qualifiedFees.each(function(question,answer){
			$("#availablefees li[data-basefeesid="+$(this).attr("data-basefeesid")+"]").css("display","none");
		});
			}else{
				$("#availablefees li").css("display","");
			}
	//	$("#assignedfees li[data-standardid="+standardId+"]").css("display","");
	//	$("#assignedfees li[data-standardid="+standardId+"]").attr("data-validforstore","true");
	}

	

	
});
$(document).on("change","select[data-currentgroup=true]",function(){
	$("select[data-name=section]").css('display','none').attr("data-currentsection","false");
	$("select[data-name=section]").val("111");
	$("select[data-name=section]").css('display','none');
	$("#assignedfees li").css("display","none");
	$("#assignedfees li").attr("data-validforstore","false");
	$("#availablefees li").css("display","");
	$("div [data-name=sectiondiv]").css('display','none');
	var groupid= $(this.selectedOptions).data('groupid')
	var standardId=$(this.selectedOptions).data('standardid');
	
	//$("select[data-name=section][data-standardid="+standardId+"][data-groupid="+groupid+"]").css('display','').attr("data-currentsection","true");
	$("div [data-name=sectiondiv]").css('display','');
	$("div [data-name=sectiondiv] select[data-name=section][data-standardid="+standardId+"][data-groupid="+groupid+"]").css('display','').attr("data-currentsection","true");
	//$("#assignedfees li[data-standardid="+standardId+"]").css("display","");
	var  qualifiedFees=$("#assignedfees li[data-standardid="+standardId+"]");
	if(qualifiedFees.length!=0){
		qualifiedFees.each(function(question,answer){
			$("#availablefees li[data-value="+$(this).attr("data-basefeesid")+"]").css("display","none");
		})
}
else{
	$("#availablefees li").css("display","");
}
	
	$("#assignedfees li[data-standardid="+standardId+"]").attr("data-validforstore","true");
	
});

$("div #collapseOne5 [class=panel-body]").on("change", "#termPeriod",function(){
    if($("#termPeriod").val()=="ones")
    {
        $("#month_period").removeClass("no-display").attr("data-active","true");
        
		$("#twos_period").addClass("no-display").attr("data-active","false");
		$("#threes_period").addClass("no-display").attr("data-active","false");
		$("#fours_period").addClass("no-display").attr("data-active","false");
		$("#sixs_period").addClass("no-display").attr("data-active","false");
    }
    else if($("#termPeriod").val()=="twos")
    {
    	$("#twos_period").removeClass("no-display").attr("data-active","true");
    	
    	$("#threes_period").addClass("no-display").attr("data-active","false");
        $("#month_period").addClass("no-display").attr("data-active","false");
		$("#fours_period").addClass("no-display").attr("data-active","false");
		$("#sixs_period").addClass("no-display").attr("data-active","false");
    }
	else if($("#termPeriod").val()=="threes")
    {
		$("#threes_period").removeClass("no-display").attr("data-active","true");
		
        $("#month_period").addClass("no-display").attr("data-active","false");
		$("#twos_period").addClass("no-display").attr("data-active","false");
		$("#fours_period").addClass("no-display").attr("data-active","false");
		$("#sixs_period").addClass("no-display").attr("data-active","false");
    }
	else if($("#termPeriod").val()=="fours")
    {   
		$("#fours_period").removeClass("no-display").attr("data-active","true");
		
        $("#month_period").addClass("no-display").attr("data-active","false");
		$("#twos_period").addClass("no-display").attr("data-active","false");
		$("#threes_period").addClass("no-display").attr("data-active","false");
		$("#sixs_period").addClass("no-display").attr("data-active","false");
    }
	else if($("#termPeriod").val()=="sixs")
    {    $("#sixs_period").removeClass("no-display").attr("data-active","true");
		
        $("#month_period").addClass("no-display").attr("data-active","false");
		$("#twos_period").addClass("no-display").attr("data-active","false");
		$("#threes_period").addClass("no-display").attr("data-active","false");
		$("#fours_period").addClass("no-display").attr("data-active","false");
		
    }
	else
	{
        $("#month_period").addClass("no-display").attr("data-active","false");
		$("#twos_period").addClass("no-display").attr("data-active","false");
		$("#threes_period").addClass("no-display").attr("data-active","false");
		$("#fours_period").addClass("no-display").attr("data-active","false");
		$("#sixs_period").addClass("no-display").attr("data-active","false");						
    }
	
});

