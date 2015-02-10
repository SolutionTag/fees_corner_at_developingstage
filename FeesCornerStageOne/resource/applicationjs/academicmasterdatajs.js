var standardJson={standardId:"",standardName:"",isSelected:""};
var selectedStandards;
var standardArray=[];
var checkBoxObjects;
var flagForCheckEmpty=false;
var sectionDeclaratonTable;
var section=new Object();
var sectionsForStandards=new Object();
section={sectionId:"",sectionName:"",maximumStudents:0};
var actionContent;
var masterDataId;
var feed;
var wantedForSubjectAssignment=new Object();
var sectionsForStandards=new Object();
var subjectAssignmentData=new Object();


var sectionArray=[];
$(document).ready(function(){
	masterDataId=document.getElementById("masterDataId").value;
	wantedForSubjectAssignment=JSON.parse($("#generateJson").html());
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
	
	var standardId=$(this.selectedOptions).data('standardid');
	var optionsArray=wantedForSubjectAssignment[standardId]
	
	var options='';
		for(var t=0;t<optionsArray.length;t++){
		options+="<option data-sectionid="+optionsArray[t].sectionId+" value="+optionsArray[t].sectionName+">"+optionsArray[t].sectionName+"</option>"
		}
		$('#sectionList option[value!="111"]').remove();
		$('#sectionList').append(options)
	
})

$("#subjectAssignmentSave").click(function(event){
	var sectionSubjects=new Object();
	var finalAssignmentData=new Object();
	var selectedSubjects=$("#subjectsLists input[type='checkbox']:checked");
	var standardId=$("#standardList option:selected").data('standardid');
	var sectionType =$("#sectionList").val();
	var particularsectionid=$("#sectionList option:selected").data('sectionid')

	var optionsArray=wantedForSubjectAssignment[standardId];
	 var indexIds=[];
	selectedSubjects.each(function(subjectkey,subjectval){
		indexIds.push(subjectval.value);
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
	finalAssignmentData.stanadrdId=standardId;
	finalAssignmentData.sectionData=sectionSubjects;
	
	
	$.ajax({
		type:"post",
		url:"/fcds/settings/subjectAssignment",
		data : "finalAssignmentData="+JSON.stringify(finalAssignmentData),
		success:function(data){
			
		},
		error:function(){
		}
		
	})
	
	
});
	$( "#draggable-list1" ).sortable({
		opacity:0.5,connectWith: ".cond",
		receive:function(event,ui){
			alert("___")
			var subjectval=ui.item;
		if(	subjectval.data().validforstore==true){
			subjectval.data().validforstore=false;
			var indexIds=[];
			var	 finalAssignmentData=new Object();
			var standardId=$("#standardList option:selected").data('standardid');
			var sectionType =$("#sectionList").val();
			var particularsectionid=$("#sectionList option:selected").data('sectionid')
			
			var optionsArray=wantedForSubjectAssignment[standardId];
			var sectionSubjects=new Object();
			
			var subjectIndexId=subjectval.data().value;
				indexIds.push(subjectIndexId);
				
			
				if(sectionType=="111"){
					for(var oA=0;oA<optionsArray.length;oA++){
						console.log(optionsArray[oA])
						console.log(sectionSubjects)
						sectionSubjects[optionsArray[oA].sectionId]=indexIds;
					}
				}else{
					var  indexIds=[];
					sectionSubjects[particularsectionid]=indexIds;
					
				}
				finalAssignmentData.stanadrdId=standardId;
				finalAssignmentData.sectionData=sectionSubjects;
				$.ajax({
					type:"post",
					url:"/fcds/settings/subjectAssignment",
					data : "finalAssignmentData="+JSON.stringify(finalAssignmentData),
					success:function(data){
						
					},
					error:function(){
					}
					
				})
				
		}	
			
		},
	    update:function(ev,ui){
	    }
		
	
	}).disableSelection();
	$("#draggable-list2").sortable({
		opacity:0.5,connectWith: ".cond",
		stop: function (ev, ui) {
		       // if (ui.item.hasClass("number"))
			
		          
		    },
		    receive:function(event,ui){
		    	var subjectval=ui.item;
		    	subjectval.data().validforstore=true;
		    	
		    },
		    update:function(){
		    	 
		    },
		    remove:function(){
		    	
		    },
		    
		
		
	});
});
$(document).on("ifClicked", "#standardsHead input[type=checkbox]",
		function(event) {
			if (!this.checked) {
				$(this).parent().nextAll("input[data-name=checked]").val(true);
			} else {
				$(this).parent().nextAll("input[data-name=checked]").val(false);
			}

		})
$(document).on("click", "#standardsHead input[type=checkbox]",
		function(event) {
			if (!this.checked) {
				$(this).parent().nextAll("input[data-name=checked]").val(true);
			} else {
				$(this).parent().nextAll("input[data-name=checked]").val(false);
			}

		});


function enableOrdisableSectionStandards(){
	
	$("#sectionStandardsTab input[type=radio]").iCheck('disable')
	
	
	
}
$(document).on('click','#saveSecitons',function(event){
var allRadioBoxElements=$("#sectionStandardsTab input[type=radio]");
$(allRadioBoxElements).each(function(radiokey,radiovalue){
	
	var standardid=  $(this).data('standardid');
	var sectionElememts=$(this).parent().parent().parent().nextAll('div[class="input_fields_wrap"]').children();
	var maximumstudentElement=$(this).parent().parent().parent().nextAll('div [data-div=sectionsize]').children('input[data-sectionsize=size]');
	var sectionSize=$(maximumstudentElement).val();
	if(sectionSize=="" && sectionElememts.length!=0){
		
		$(maximumstudentElement).focus();
		$(maximumstudentElement).css('border','solid red');
		flagForCheckEmpty=true;
	}

	
	$(sectionElememts).each(function(sectionkey,sectionval){
		var sectionName=$(this).find('input[data-sectionname=section]').val();
		if(sectionName=="" ){
			
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
	sectionsForStandards[standardid]=sectionArray;
	sectionArray=[];
})
	console.log(sectionsForStandards);
if(flagForCheckEmpty){
	flagForCheckEmpty=false;
	return ;
}else{
	var wrappedSectionData=JSON.stringify(sectionsForStandards);
	encodeURI()
	 var url="/fcds/settings/saveSections?wrappedSectionData="+JSON.stringify(sectionsForStandards)
	// encodeURI(url);
	   // $('#sectionDefinitionForm').attr('method','post');
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
	var optionsArray=wantedForSubjectAssignment[standardId];
	var options='';
		for(var t=0;t<optionsArray.length;t++){
		options+="<option data-sectionid="+optionsArray[t].sectionId+" value="+optionsArray[t].sectionName+">"+optionsArray[t].sectionName+"</option>"
		}
		$('#sectionList option[value!="111"]').remove();
		$('#sectionList').append(options)
	
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
