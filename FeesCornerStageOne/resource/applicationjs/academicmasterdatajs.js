var standardJson={standardId:"",standardName:"",isSelected:""},
 selectedStandards,
 standardArray=[],
 checkBoxObjects,
 flagForCheckEmpty=false,
 sectionDeclaratonTable,
 section=new Object(),
 groupsections=new Object(),
 sectionsForStandards=new Object(),
 section={sectionId:"",sectionName:"",maximumStudents:0},
 actionContent,
 masterDataId,
 feed,
 wantedForSubjectAssignment=new Object(),
 wantedForGroupSubjectAssignment=new Object(),
 wantedForGroupMetaInfo=new Object(),
 sectionsForStandards=new Object(),
 subjectAssignmentData=new Object(),
 availableSubjectObj,
 wantedForVocationalGroupAssignment=new Object();

var sectionArray=[];
$(document).ready(function(){
	availableSubjectObj=$("#availablesubjects li").clone();
	masterDataId=document.getElementById("masterDataId").value;
	wantedForSubjectAssignment=JSON.parse($("#generateJsonOne").html());
	wantedForGroupSubjectAssignment=JSON.parse($("#generateJsonThree").html());
	wantedForVocationalGroupAssignment=JSON.parse($("#generateJsonTwo").html())
	wantedForGroupMetaInfo=JSON.parse($("#generateJsonFour").html())
	loadSection();
    actionContent=	"<td class=\"center\">"+
	"<div class=\"visible-md visible-lg hidden-sm hidden-xs\">"+
	"<a href=\"#\" class=\"btn btn-xs btn-teal tooltips\" data-placement=\"top\" data-original-title=\"Edit\"><i class=\"fa fa-edit\"></i></a>&nbsp;&nbsp;"+
	"<a href=\"#\" class=\"btn btn-xs btn-bricky tooltips\" data-placement=\"top\" data-original-title=\"Remove\"><i class=\"fa fa-times fa fa-white\"></i></a>"+
"</div>"+
"<div class=\"visible-xs visible-sm hidden-md hidden-lg\">"+
"<div class=\"btn-group\">"+
	"<a class=\"btn btn-primary dropdown-toggle btn-sm\" data-toggle=\"dropdown\" href=\"#\">"+
			"<i class=\"fa fa-cog\"></i> <span class=\"caret\"></span>"+
	"</a>"+
	"<ul role=\"menu\" class=\"dropdown-menu pull-right\">"+
		"<li role=\"presentation\">"+
			"<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">"+
			"<i class=\"fa fa-edit\"></i> Edit"+
			"</a>"+
			"</li> "+
			"<li role=\"presentation\">"+
			"<a role=\"menuitem\" tabindex=\"-1\" href=\"#\">"+
			"<i class=\"fa fa-times\"></i> Remove"+
			"</a>"+
		"</li>"+
	  "</ul>"+
	"</div>"+
"</div></td>";
	
	// $("#sectionDeclarationTable").DataTable();
	 sectionDeclaratonTable=$("#sectionDeclarationTable").DataTable({
		 "aoColumnDefs": [
		 
		 {
			"aTargets": [0], "sClass": "sorting"
			 
		 },
		 {
			 "aTargets": [1],"sClass": "hidden-xs sorting_asc"
			 
		 },
		 {
			 "aTargets": [2],"sClass": "sorting"
			 
		 },
		 {
			 "aTargets": [3],"sClass": "hidden-xs sorting_asc"
			 
		 },
		 {
			 "aTargets": [4],"sClass": "sorting"
			 
		 },
		 {
			 "aTargets": [5],
			 "sClass": "hidden-xs sorting_asc",
		      "mRender": function ( data, type, full ) {
		        return  actionContent;
		      }
		 }
		 
		 
		 ],
		 "bAutoWidth": true,
		 "bServerSide": true,
		 "bProcessing": true,
		 "bLengthChange": false,
		 "destroy" : true,
	     "iDisplayLength": 10,
		 "sAjaxDataProp": "aoData",
		 "sAjaxSource": "/fcds/settings/loadsectiondata?masterdataid="+masterDataId,
		  "fnServerData": function (sSource, aoData, fnCallback ) {
			/*  var aoHash = {};
			  $.each(aoData, function() {
			      var item = this;
			      aoHash[item.name] = item.value;
			  })*/
			      $.ajax({
                  dataType: 'json',
                  type: "GET",
                  contentType: "application/json; charset=utf-8",
                  url: sSource,
                  data: aoData,
                  success: function(data){
                	  var copyarray=JSON.parse(data.aoData);
                	  var dummyArray=[];
                	  Object.keys(copyarray).forEach(function(k,v){
                	  dummyArray.push(JSON.parse(copyarray[k]))
                	  });
                	  data.aoData=dummyArray;
                	  fnCallback(data)
                	  
                  },
                  error : function (e) {
                      //alert (e);
                  }
              })
          },
         
            
      	"aoColumns": [
      			    { "sTitle": "SubjectId","bVisible": false ,"mData":"subjectId" },
      			    { "sTitle": "CompareId" ,"bVisible": false ,"mData":"compareId"  },
      			    { "sTitle": "Subject Name",         "mData":"subjectName"  },
      			    { "sTitle": "Subject Reference Id" ,"mData":"subjectRefId" },
      			    { "sTitle": "Standard Preferred" ,  "mData":"subjectPreferreStd"},
      			    { "sTitle": "Action","mData":"action"}

      			],
       
        	  
});
	

	$("#preferredTo").change(function(){
		
		var preferredFrom=$("#preferredFrom").val();
		var preferredTo=$(this).val();
		if(preferredFrom <= preferredTo){
			
		}else{
			alert("Please change the value \"HIGHER\" than Prefeered From");
			$(this).val(1);
			$("#preferredFrom").val(1);
		}
	})
	$("#preferredFrom").change(function(){
		
		var preferredFrom=$(this).val();
		var preferredTo=$("#preferredTo").val();
		if(preferredFrom <= preferredTo){
			
		}else{
			alert("Please change the value \"LOWER\" than Prefeered To");
			$(this).val(1);
			$("#preferredTo").val(1);
		}
	})
$("#standardDiv #standardList").change(function(event){
	$("#assignedsubjects li").css("display","none");
	$("#assignedsubjects li").attr("data-validforstore","false");
	$("#availablesubjects li").css("display","");
	$('#sectionList option[value="111"]').data("vocationalgroupid","");
	var standardId=$(this.selectedOptions).data('standardid');
	var isgroupAssigned=$(this.selectedOptions).data('groupassigned');
//	$("#assignedsubjects li[data-standardid="+standardId+"]").css("display","");
	var  qualifiedSubjects=$("#assignedsubjects li[data-standardid="+standardId+"]");
	if(qualifiedSubjects.length!=0){
		qualifiedSubjects.each(function(question,answer){
			$("#availablesubjects li[data-basesubjectid="+$(this).attr("data-basesubjectid")+"]").css("display","none");
		})
}
else{
	$("#availablesubjects li").css("display","");
}
	if(isgroupAssigned==true &&(typeof isgroupAssigned!="undefined" || isgroupAssigned==false)){
		
		$("div [data-name=vocationalgroupdiv]").css("display","")
		var vocationalGroups= wantedForGroupSubjectAssignment[standardId];
		var options='';
		Object.keys(vocationalGroups).forEach(function(vocatinalgroupid,v){
			if(typeof wantedForGroupMetaInfo[vocatinalgroupid]!="undefined"){
				var groupName=wantedForGroupMetaInfo[vocatinalgroupid].groupname;	
				options+="<option data-standardid="+standardId+" data-vocationalgroupid="+vocatinalgroupid+" value="+groupName+">"+groupName+"</option>"
			}
			})
			$('#vocationalgroupselect option[value!="111"]').remove();
			$('#vocationalgroupselect option[value="111"]').attr("data-standardid",standardId);
			$("#vocationalgroupselect").append(options)
			$('#sectionList option[value!="111"]').remove();
	}
	else{
		$("div [data-name=vocationalgroupdiv]").css("display","none")
		$("#assignedsubjects li[data-standardid="+standardId+"]").attr("data-validforstore","true");
		var optionsArray=wantedForSubjectAssignment[standardId]
		
		var options='';
			for(var t=0;t<optionsArray.length;t++){
			options+="<option data-standardid="+standardId+" data-sectionid="+optionsArray[t].sectionId+" value="+optionsArray[t].sectionName+">"+optionsArray[t].sectionName+"</option>"
			}
			$('#sectionList option[value!="111"]').remove();
			$('#sectionList option[value="111"]').attr("data-standardid",standardId);
			$('#sectionList').append(options)
	}
	
	
});
	$("select#vocationalgroupselect").change(function(){
		$("#assignedsubjects li").css("display","none");
		$("#assignedsubjects li").attr("data-validforstore","false");
		$("#availablesubjects li").css("display","");
		$('#sectionList option[value="111"]').data("vocationalgroupid","")
		if($(this.selectedOptions).val()!="111"){
		var standardid=$(this.selectedOptions).data('standardid');
		var vocationalgroupid=$(this.selectedOptions).data('vocationalgroupid');
		var vocationalGroups= wantedForGroupSubjectAssignment[standardid];
		var optionsArray=vocationalGroups[vocationalgroupid];
		var options='';
			for(var t=0;t<optionsArray.length;t++){
			options+="<option  data-vocationalgroupid="+vocationalgroupid+" data-sectionid="+optionsArray[t].sectionId+" value="+optionsArray[t].sectionName+">"+optionsArray[t].sectionName+"</option>"
			}
			$('#sectionList option[value!="111"]').remove();
			$('#sectionList option[value="111"]').data("vocationalgroupid",vocationalgroupid);
			$('#sectionList option[value="111"]').attr("data-vocationalgroup","true");
			$('#sectionList').append(options)
	}else{
		$('#sectionList option[value!="111"]').remove();
	}
	});
	$("#sectionDiv #sectionList").change(function(event){
		if($(this.selectedOptions).val()!="111"){
			$("#assignedsubjects li").css("display","none");
			$("#assignedsubjects li").attr("data-validforstore","false");
			$("#availablesubjects li").css("display","");
			
			var standardId=$(this.selectedOptions).data('standardid');
			typeof standardId=="undefined"?standardId=$(this.selectedOptions).data('vocationalgroupid'):standardId=standardId
			var sectionid=$(this.selectedOptions).data('sectionid');
			
			
			$("#assignedsubjects li[data-standardid="+standardId+"][data-sectionid="+sectionid+"]").css("display","");
			var qualifiedSubjects=$("#assignedsubjects li[data-standardid="+standardId+"][data-sectionid="+sectionid+"]");
			$("#availablesubjects li").remove();
			$(availableSubjectObj).css("display","");
			$("#availablesubjects").append(availableSubjectObj)
			if(qualifiedSubjects.length!=0){
					qualifiedSubjects.each(function(question,answer){
						$("#availablesubjects li[data-basesubjectid="+$(this).attr("data-basesubjectid")+"]").css("display","none");
					})
			}
			else{
				$("#availablesubjects li").css("display","");
			}
			$("#assignedsubjects li[data-standardid="+standardId+"][data-sectionid="+sectionid+"]").attr("data-validforstore","true");
		}else{
			var standardId=$(this.selectedOptions).data('standardid');
			var isGroupAssigned=$(this.selectedOptions).data('vocationalgroup'); 
			typeof standardId=="undefined"?standardId=$(this.selectedOptions).data('vocationalgroupid'):standardId=standardId;
			
			$("#assignedsubjects li").css("display","none");
			$("#assignedsubjects li").attr("data-validforstore","false");
			$("#availablesubjects li").css("display","");
			var qualifiedSubjects=	$("#assignedsubjects li[data-standardid="+standardId+"]");
				if(isGroupAssigned==true && qualifiedSubjects.length==0) {
					qualifiedSubjects=	$("#assignedsubjects li[data-standardid="+$(this.selectedOptions).data('vocationalgroupid')+"]"); 
			}
			$("#availablesubjects li").remove();
			$(availableSubjectObj).css("display","");
			$("#availablesubjects").append(availableSubjectObj);
				if(qualifiedSubjects.length!=0){
					
			qualifiedSubjects.each(function(question,answer){
				$("#availablesubjects li[data-basesubjectid="+$(this).attr("data-basesubjectid")+"]").css("display","none");
			});
				}else{
					$("#availablesubjects li").css("display","");
				}
			/*$("#assignedsubjects li[data-standardid="+standardId+"]").css("display","");
			$("#assignedsubjects li[data-standardid="+standardId+"]").attr("data-validforstore","true");*/
		}
		
	});	
	

$("#subjectAssignmentSave").click(function(event){
	var sectionSubjects=new Object();
	var finalAssignmentData=new Object();
	var selectedSubjects=$("#assignedsubjects li[data-validforstore=true]");
	
	
	var standardId=$("#standardList option:selected").data('standardid');
	var groupassigned=$("#standardList option:selected").data('groupassigned');
	if(groupassigned!=true){
		var sectionType =$("#sectionList").val();
		var particularsectionid=$("#sectionList option:selected").data('sectionid')

		var optionsArray=wantedForSubjectAssignment[standardId];
		 var indexIds=[];
		selectedSubjects.each(function(subjectkey,subjectval){
			indexIds.push(parseInt(subjectval.dataset.basesubjectid));
		});
		
		if(sectionType=="111"){
			for(var oA=0;oA<optionsArray.length;oA++){
				console.log(optionsArray[oA])
				console.log(sectionSubjects)
				sectionSubjects[optionsArray[oA].sectionId]=indexIds;
			}
		}else{
			sectionSubjects[particularsectionid]=indexIds;
			
		}
		finalAssignmentData.standardId=standardId;
		finalAssignmentData.sectionData=sectionSubjects;
		finalAssignmentData.groupassigned=false;
		
	}else{
		var sectionType =$("#sectionList").val();
		var particularsectionid=$("#sectionList option:selected").data('sectionid')
		var vocationalgroupid=$("#sectionList option:selected").data('vocationalgroupid');
		//var optionsArray=wantedForSubjectAssignment[standardId];
		
		var vocationalGroups= wantedForGroupSubjectAssignment[standardId];
		var optionsArray=vocationalGroups[vocationalgroupid];
		 var indexIds=[];
		selectedSubjects.each(function(subjectkey,subjectval){
			indexIds.push(parseInt(subjectval.dataset.basesubjectid));
		});
		
		if(sectionType=="111"){
			for(var oA=0;oA<optionsArray.length;oA++){
				sectionSubjects[optionsArray[oA].sectionId]=indexIds;
			}
		}else{
			sectionSubjects[particularsectionid]=indexIds;
			
		}
		finalAssignmentData.standardId=standardId;
		finalAssignmentData.sectionData=sectionSubjects;
		finalAssignmentData.groupassigned=true;
		finalAssignmentData.groupassignedId=vocationalgroupid;
	}

	
	
	
	$.ajax({
		type:"post",
		cache: false,
		url:"/fcds/settings/subjectAssignment",
		data : "finalAssignmentData="+JSON.stringify(finalAssignmentData),
		success:function(data){
			alert(data);
		},
		error:function(){
		}
		
	})
	
	
});
	$( "#assignedsubjects" ).sortable({opacity:0.5,connectWith: ".cond",
		receive:function(event,ui){
			$(ui.item).attr('data-validforstore',"true");
			$(ui.item).css("background-color","#D3D3D3 !important");
			$(ui.item).css("border-color","#D3D3D3 !important");
		}
	
	}).disableSelection();
	$( "#availablesubjects" ).sortable({opacity:0.5,connectWith: ".cond",
		receive:function(event,ui){
			$(ui.item).attr('data-validforstore',"false");
			$(ui.item).css("background-color","");
			$(ui.item).css("border-color","");
		}	
	
	}).disableSelection();
	 var completed = false;
	$("#vocationalGroupSave_modified").click(function(){
		var def1 = $.Deferred();
	    var def2 = $.Deferred();
	    var def3 = $.Deferred();
		var vocationalForm= $("#vocationalgroupdef").serializeArray();
		var serializedObject={};
		$.each(vocationalForm,function(key,val){
			serializedObject[val.name]=val.value;
		});
		var req = {
				 method: 'POST',
				 url: '/fcds/settings/create-vocational-group',
				 async: true,
				 data:  JSON.stringify(serializedObject) 
				}
		var promise= vocationalGroupAjax(req).success(function(json) {
			alert("ajax sucess")
		    	completed=true;
		        vocationalGroupScope.vocationalGroupList=$.fn.convertJsonStrArrayToObjectArray(json.myArrayList);
		        $("#vocationalgrouplists label>input").iCheck({
		            checkboxClass: 'icheckbox_flat-green',
		            });
		    }).error(function(xhr,response){
		    	completed=true;
		    });
		alert("before ajax completion")
		promise.then(function(data){
			$("#vocationalgrouplists label>input").iCheck({
	            checkboxClass: 'icheckbox_flat-green',
	            });
			
		});
		
})
if(completed){
    	alert("comming")
    	$("#vocationalgrouplists label>input").iCheck({
            checkboxClass: 'icheckbox_flat-green',
            });
    } 
		/*var vocationalForm= $("#vocationalgroupdef").serializeArray();
		var serializedObject={};
		$.each(vocationalForm,function(key,val){
			serializedObject[val.name]=val.value;
		})
		$.ajax({
			type:"post",
			cache: false,
			contentType: "application/json; charset=utf-8",
			url:"/fcds/settings/create-vocational-group",
			data :JSON.stringify(serializedObject),
			success:function(data){
				$.parseJSON("["+JSON.parse(data).myArrayList+"]")
				document.getElementById("vocationalgroupdef").reset();
				
			},
			error:function(){
			}
		})*/

	$("#standardsforassigngroup").change(function(){
		$("#vocationalgrouplists input[type='checkbox']").iCheck('uncheck');
		$("#vocationalgrouplists input[type=checkbox]").attr("data-derivedcompareid","");
		var standardId=$(this.selectedOptions).data('standardid');
		var vocationalGroupArray= wantedForVocationalGroupAssignment[standardId];
		var size=vocationalGroupArray.length;
		if(size!=0){
			for(var i=0;i<size;i++){
				var baseGroupCompareId=vocationalGroupArray[i].basegroupcompareid;
				var derivedcompareid=vocationalGroupArray[i].derivedcompareid;
				var status=vocationalGroupArray[i].status;
				$("input[data-basegroupcompareid="+baseGroupCompareId+"]").attr("data-derivedcompareid",derivedcompareid);
				if(status){
					$("input[data-basegroupcompareid="+baseGroupCompareId+"]").iCheck('check');
				}
			}
		}
		
	});
	$("#assignvocationaltostandards").click(function(){
	var standardid=	$("#standardsforassigngroup :selected").attr('data-standardid')
	var sectionassigned=$("#standardsforassigngroup :selected").attr('data-issectionexit')
	var response;
	if(sectionassigned=="true"){
		 response= confirm("Sections are created for this standard.If you continue all the SECTIONS Would be Deleted.Do You want to Continue?");
	}else{
		response=true;
	}
	if(response){
	var assignedvocationalgroups="";
	if(wantedForVocationalGroupAssignment[standardid].length!=0){
		 assignedvocationalgroups = $("#vocationalgrouplists input[type='checkbox']");
	}else{
		 assignedvocationalgroups = $("#vocationalgrouplists input[type='checkbox']:checked");
	}
		var vocationalStandard=new Object();
		var standardid=$("#standardsforassigngroup option:selected").attr("data-standardid");
		var assignedVocatinal=new Object();
		assignedVocatinal=$.map(assignedvocationalgroups,function(obj,i){
		
						var basegroupcompareid=obj.dataset.basegroupcompareid;
						var derivedcompareid=obj.dataset.derivedcompareid;
						var groupobject=new Object();
						if(obj.checked){
							groupobject.status=true;
						}else{
							groupobject.status=false;
						}
						groupobject.basegroupcompareid=parseInt(basegroupcompareid);
						if(derivedcompareid!=""){
							groupobject.derivedcompareid=parseInt(derivedcompareid)
						}else{
							groupobject.derivedcompareid="NEW";
						}
						
						
						return groupobject;
			});
		
		vocationalStandard[standardid]=assignedVocatinal;
		 var data={ "vocationalstandars":vocationalStandard,
				   "isSectionExit":sectionassigned
		 }
		 var url="/fcds/settings/assign-vocational-group/";
				    $('#vocationGroupAssingForm').attr('method','post');
				   $("#vocationGroupAssingForm").append("<input type='hidden' name='customParameter' value='"+JSON.stringify(data)+"' />");
				   $('#vocationGroupAssingForm').attr('action', encodeURI(url)).submit();
		 //Commented for form submission instead of Ajax call......will required future.///
	/*	$.ajax({
			 type:"post",
			 data:JSON.stringify(data),
			 contentType: 'application/json',
			 url:"/fcds/settings/assign-vocational-group",
			 success:function(data){
				 var standardid=	$("#standardsforassigngroup :selected").attr('data-standardid')
				 wantedForVocationalGroupAssignment[standardid]=JSON.parse(data)[standardid];
					$("#vocationalgrouplists input[type='checkbox']").iCheck('uncheck');
					$("#vocationalgrouplists input[type=checkbox]").attr("data-derivedcompareid","");
					var standardId=standardid;
					var vocationalGroupArray= wantedForVocationalGroupAssignment[standardId];
					var size=vocationalGroupArray.length;
					if(size!=0){
						for(var i=0;i<size;i++){
							var baseGroupCompareId=vocationalGroupArray[i].basegroupcompareid;
							var derivedcompareid=vocationalGroupArray[i].derivedcompareid;
							var status=vocationalGroupArray[i].status;
							$("input[data-basegroupcompareid="+baseGroupCompareId+"]").attr("data-derivedcompareid",derivedcompareid);
							if(status){
								$("input[data-basegroupcompareid="+baseGroupCompareId+"]").iCheck('check');
							}
						}
					}
			alert(data);
			},
			error:function(){
				
			}
		})*/
	}else{
		return false;
	}
	})
	$("#openstandardform").click(function () {
	    $("#openstandardform").addClass('no-display');
	    $("#addnewip").removeClass('no-display');
	    $("#bcktocreate").removeClass('no-display');

	});
	$("#bcktocreate").click(function () {
	    $("#openstandardform").removeClass('no-display');
	    $("#addnewip").addClass('no-display');
	    $("#bcktocreate").addClass('no-display');
	});
	$("i[data-name=subjectdelete]").click(function(event){
		var basesubjectid=this.dataset.basesubjectid;
		var sectionid=this.dataset.sectionid;
		var standardid=this.dataset.standardid
		alert("base "+basesubjectid+"section "+sectionid+"standard"+standardid)
		var deleteparameters=
		{
			"basesubjectid":basesubjectid,
			"sectionid":sectionid,
			"standardid":standardid
		}
		$.ajax({
			type:"post",
			data:JSON.stringify(deleteparameters),
			contentType: 'application/json',
			url:"/fcds/settings/delte-subject-assignment",
			success:function(data){
				var deleteParameters= JSON.parse(data);
				$("#assignedsubjects li[data-standardid="+deleteParameters.standardid+"][data-sectionid="+deleteParameters.sectionid+"][data-basesubjectid="+deleteParameters.basesubjectid+"]").remove();
				alert("deleted successfully");
			},
			error:function(){
				
			}
			
		});
		
		
		
	})
	

});
$(document).on("ifClicked", "#standardsHead input[type=checkbox]",
		function(event) {
			if (!this.checked) {
				$(this).parent().nextAll("input[data-id=checked]").val(true);
			} else {
				$(this).parent().nextAll("input[data-id=checked]").val(false);
			}

		})
$(document).on("click", "#standardsHead input[type=checkbox]",
		function(event) {
			if (!this.checked) {
				$(this).parent().nextAll("input[data-id=checked]").val(true);
			} else {
				$(this).parent().nextAll("input[data-id=checked]").val(false);
			}

		});


function enableOrdisableSectionStandards(){
	
	$("#sectionStandardsTab input[type=radio]").iCheck('disable')
	
	
	
}
$(document).on('click','#saveSecitons',function(event){
var groupEnabledStandards=$("div[data-isgroupenabled=true]");
var groupDisabledStandards=$("div[data-isgroupenabled=false]");
		groupEnabledStandards.each(function(key,val){
			
		var standardId=$(val).data('standardid');
		var groupsLists=$("div[data-name=sectionrow][data-standardid="+standardId+"]")
		groupsLists.each(function(k,v){
			var groupcompareid=$(this).children('div [data-ishavinggroup=yes]').data('groupcompareid');
			var sectionElememts=$(this).children('div [class=input_fields_wrap]').children();
			var maximumstudentElement=$(this).children('div [data-div=sectionsize]').children('input[data-sectionsize=size]');
			var sectionSize=$(maximumstudentElement).val();
			if(sectionSize=="" && sectionElememts.length!=0)
			{
				$(maximumstudentElement).focus();
				$(maximumstudentElement).css('border','solid red');
				flagForCheckEmpty=true;
			}
			sectionArray=	getClassSectionsOfStandard(sectionElememts,sectionSize)
			var sectionArrayCopyObj = jQuery.extend( [], sectionArray);
			groupsections[groupcompareid]=sectionArrayCopyObj;
			sectionArray=[];
			
		});
		var grousectionCopyObj = jQuery.extend( {}, groupsections);
		sectionsForStandards[standardId]=grousectionCopyObj;
		groupsections=new Object();
		
		});
		
		groupDisabledStandards.each(function(key,val){
			var standardId=$(val).data('standardid');
			var groupsLists=$("div[data-name=sectionrow][data-standardid="+standardId+"]")
			groupsLists.each(function(k,v){
				var groupcompareid=$(this).children('div [data-ishavinggroup=yes]').data('groupcompareid');
				var sectionElememts=$(this).children('div [class=input_fields_wrap]').children();
				var maximumstudentElement=$(this).children('div [data-div=sectionsize]').children('input[data-sectionsize=size]');
				var sectionSize=$(maximumstudentElement).val();
				if(sectionSize=="" && sectionElememts.length!=0)
				{
					$(maximumstudentElement).focus();
					$(maximumstudentElement).css('border','solid red');
					flagForCheckEmpty=true;
				}
				sectionArray=	getClassSectionsOfStandard(sectionElememts,sectionSize)
				var sectionArrayCopyObj = jQuery.extend( [], sectionArray);
				sectionsForStandards[standardId]=sectionArrayCopyObj;
				sectionArray=[];
			
			});
			
		})


var allSectionRowElements=$("#sectionStandardsTab div[data-name=sectionrow]");
/*$(allSectionRowElements).each(function(radiokey,radiovalue){
	var standardid=  $(this).data('standardid');
	//groupsections=new Object();
	var sectionElememts=$(this).children('div [class=input_fields_wrap]').children();
	var maximumstudentElement=$(this).children('div [data-div=sectionsize]').children('input[data-sectionsize=size]');
	var sectionSize=$(maximumstudentElement).val();
	if(sectionSize=="" && sectionElememts.length!=0)
	{
		$(maximumstudentElement).focus();
		$(maximumstudentElement).css('border','solid red');
		flagForCheckEmpty=true;
	}

	if($(this).children('div [data-ishavinggroup=yes]').length!=0){
		var groupcompareid=$(this).children('div [data-ishavinggroup=yes]').data('groupcompareid');
		if(groupcompareid!=0){
			sectionArray=getClassSectionsOfStandard(sectionElememts);
			var sectionArrayCopyObj = jQuery.extend( [], sectionArray);
			groupsections[groupcompareid]=sectionArrayCopyObj;
		}
		var grousectionCopyObj = jQuery.extend( {}, groupsections);
		sectionsForStandards[standardid]=grousectionCopyObj;
		groupsections=new Object();
		sectionArray=[];
	}else{
		groupsections=new Object();
		sectionArray=getClassSectionsOfStandard(sectionElememts);
		var sectionArrayCopyObj = jQuery.extend( [], sectionArray);
		sectionsForStandards[standardid]=sectionArrayCopyObj;
		sectionArray=[];
	}
});*/

	console.log(sectionsForStandards);
if(flagForCheckEmpty){
	flagForCheckEmpty=false;
	sectionsForStandards=new Object();
	sectionArray=[];
	groupsections=new Object();
	return ;
}else{
	var wrappedSectionData=JSON.stringify(sectionsForStandards);
	encodeURI()
	 var url="/fcds/settings/saveSections/";
	// encodeURI(url);
		// alert(JSON.stringify(sectionsForStandards))
	    $('#sectionDefinitionForm').attr('method','post');
	   $("#sectionDefinitionForm").append("<input type='hidden' name='customParameter' value='"+JSON.stringify(sectionsForStandards)+"' />");
	   $('#sectionDefinitionForm').attr('action', encodeURI(url)).submit();
	 return false; //
	
}

    
});

$(document).on("click", "#savesubject", function() {
	var serializedArray = $("#subjectDeclartionForm").serializeArray()
	
	var url = "/fcds/settings/saveSubject"
	var serilaizedForm = {};
	$.each(serializedArray, function(key, value) {
		serilaizedForm[value.name] = value.value;
	});
	serilaizedForm.subjectPreferreStd="{"+findNumBtwn(serilaizedForm.preferredFrom,serilaizedForm.preferredTo).toString()+"}";
	//var childData= {"subjectName":serilaizedForm.subjectName,"subjectRefId":serilaizedForm.subjectRefId,"subjectPreferreStd":serilaizedForm.subjectPreferreStd}
	//serilaizedForm.schoolSubjectAssignment=childData;
	delete serilaizedForm.preferredFrom;
	delete serilaizedForm.preferredTo;
	
	$.ajax({
		type : "post",
		contentType: "application/json",
		url : "/fcds/settings/saveSubject?subjectData="+JSON.stringify(serilaizedForm),
		data:JSON.stringify(serilaizedForm),
		dataType: 'json',
		success : function(responseData, textStatus, jqXHR) {
			alert("data saved;")
  	/*	var newSubjectObject=	Object.keys(responseData).map(function(k) { return responseData[k] });*/
			sectionDeclaratonTable.fnAddData(responseData); 
     	    var tableDatas= sectionDeclaratonTable.fnGetData();
		    sectionDeclaratonTable.fnClearTable();
		    sectionDeclaratonTable.fnAddData(tableDatas); 
		    console.log(tableDatas);
          /* Object.keys(tableDatas).forEach(function(k,v) { 
        	   console.log(k)
        	   console.log(v);
        	   sectionDeclaratonTable.fnAddData(tableDatas); 
           });*/
		    $("#subjectDeclartionForm").reset();
           tableDatas="";
          // sectionDeclaratonTable.fnAddData(responseData); 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	})
	
	serilaizedForm={};
});

function deleteSection(deleteParamerters){
	return $.ajax({
			 type:"post",
			 url:"/fcds/settings/deleteSection",
			 data:JSON.stringify(deleteParamerters),
			 async:false,
			 success:function(data){
				 
				
			 }
		   });
	
	
}
var findNumBtwn=function(a,b,c,d){d=[];c=b-a+1;while(c--){d[c]=b--}return d}
function loadSection(){
	var standardId=$("#standardList option:first").data('standardid');
	var isgroupAssigned=$("#standardList option:first").data('groupassigned');
	if(isgroupAssigned==true){
		$("div [data-name=vocationalgroupdiv]").css("display","")
		var vocationalGroups= wantedForGroupSubjectAssignment[standardId];
		var options='';
		Object.keys(vocationalGroups).forEach(function(vocatinalgroupid,v){
			if(typeof wantedForGroupMetaInfo[vocatinalgroupid]!="undefined"){
				var groupName=wantedForGroupMetaInfo[vocatinalgroupid].groupname;	
				options+="<option data-standardid="+standardId+" data-vocationalgroupid="+vocatinalgroupid+" value="+groupName+">"+groupName+"</option>"
			}
			})
			$('#vocationalgroupselect option[value!="111"]').remove();
			$('#vocationalgroupselect option[value="111"]').attr("data-standardid",standardId);
			$("#vocationalgroupselect").append(options)
			$('#sectionList option[value!="111"]').remove();
	}else{
		
	
	if(typeof standardId !="undefined"){
	var optionsArray=wantedForSubjectAssignment[standardId];
	var options='';
		for(var t=0;t<optionsArray.length;t++){
		options+="<option data-standardid="+standardId+" data-sectionid="+optionsArray[t].sectionId+" value="+optionsArray[t].sectionName+">"+optionsArray[t].sectionName+"</option>"
		}
		$('#sectionList option[value!="111"]').remove();
		$('#sectionList option[value="111"]').attr('data-standardid',standardId);
		$('#sectionList').append(options)
	}
	
	}
}




	/*
	 * $("#standardsHead input").change(function(){
	 * 
	 * alert(this) })
	 */
/*$(document).on('click','#saveStandards',function(){
	standardArray=[];
	selectedStandards=$("#standardsHead input[type='checkbox']:checked");
	if(selectedStandards.length!=0)
	{
		$.each(selectedStandards,function(key,value){
			var standardName=$(this).data('index');
			var standardId="STD0"+standardName;
			standardJson.standardName=standardName;
			standardJson.standardId=standardId;
			standardArray.push(standardJson);
			standardJson={standardId:"",standardName:""};
		});
		
		$.ajax({
			type:"post",
			url:"/fcds/settings/saveStandard",
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
});*/

function getClassSectionsOfStandard(sectionElememts,sectionSize){
	$(sectionElememts).each(function(sectionkey,sectionval){
		var sectionName=$(this).find('input[data-sectionname=section]').val();
		if(sectionName=="" )
		{
			flagForCheckEmpty=true;
			$(this).find('input').css('border','solid green');
			$(this).find('input').focus();
			sectionArray=[];
			section={sectionId:"",sectionName:"",maximumStudents:0};
			return  ;
			
			event.preventDefault();
			return  ;
		}
		else
		{
			if(typeof sectionName!="undefined"){
				section.sectionName=sectionName.toUpperCase();
			}
			if(typeof sectionSize!="undefined"){
				section.maximumStudents=sectionSize;
			}
		var indexId=$(this).find("input[name='indexId']").val();
				if(indexId!="" && indexId!=0){
					section.compareId=indexId;
				}else{
					//section.indexId=0;
				}
		sectionArray.push(section);
	
		section={sectionId:"",sectionName:"",maximumStudents:0};
		}
	})
	return sectionArray;
}
function getStandardBeanObjectAsJson(){
	var standardArray = new Object();
	standardArray = JSON.parse($("#standardJsonObjectAsString").html());
	return  $.fn.convertJsonStrArrayToObjectArray(standardArray);
}