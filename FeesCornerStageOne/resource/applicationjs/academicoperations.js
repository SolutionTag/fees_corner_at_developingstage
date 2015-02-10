var infoForRatioSplit={
		"totalstudents":"",
		"totalboys":"",
		"totalgirls":"",
		"noofsections":""
		
},
 sectionArrays = { }
$(document).ready(function(){
	//$("#loading_image").hide();
	var standardId=parseInt(window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1));
	if(isNaN(standardId)||typeof standardId == undefined){
		 standardId=$("#standardId option:selected").data('standardid');
		 $(".sectionlist[data-standardid="+standardId+"]").css('display','block');
		 var totalsection=$(".sectionlist[data-standardid="+standardId+"] label").length;
		 if( $("#noofacdemician").val() !="0"){
			 prepareInfoForRatioSplit(totalsection);
		 }
		
		
	}else{
		$(".sectionlist[data-standardid="+standardId+"]").css('display','block');
		$("#standardId").val( $("#standardId option[data-standardid="+standardId+"]").val() );
		var totalsection=$(".sectionlist[data-standardid="+standardId+"] label").length;
		if( $("#noofacdemician").val() !="0"){
			 prepareInfoForRatioSplit(totalsection);
		}
		
		
	}
	
	
	$("#standardId").change(function(event){
		var standardId=$(this.selectedOptions).data('standardid');
		$(".sectionlist").css('display','none');
		//var standardId=	$('#standardId :selected').data('standardid');
		       var url="/fcds/academics/standard/"+standardId
			    $('#pickupstudentlistform').attr('action',url.trim() ).submit();
		 $(".sectionlist[data-standardid="+standardId+"]").css('display','block');
		
	})
			$("#selectGender").change(function(event) {
						var option = $(this).val();
						if (option == "MALE") {
							$("#sectionAssignTable tr td[data-gender=MALE]")
									.parent().css('display', '');
							$("#sectionAssignTable tr td[data-gender=FEMALE]")
									.parent().css('display', 'none');
						} else if (option == "FEMALE") {
							$("#sectionAssignTable tr td[data-gender=FEMALE]")
									.parent().css('display', '');
							$("#sectionAssignTable tr td[data-gender=MALE]")
									.parent().css('display', 'none');
						} else {
							$("#sectionAssignTable tr td[data-gender=FEMALE]")
									.parent().css('display', '');
							$("#sectionAssignTable tr td[data-gender=MALE]")
									.parent().css('display', '');
						}

					});

})

function prepareInfoForRatioSplit(noofsection){
	infoForRatioSplit.noofsections=parseInt(noofsection);
    infoForRatioSplit.totalboys=parseInt($("#totalboys").val());
    infoForRatioSplit.totalgirls=parseInt($("#totalgirls").val());
    infoForRatioSplit.totalstudents=parseInt($("#noofacdemician").val());
    var sectionsize=Math.round(infoForRatioSplit.totalstudents/noofsection);
    


for(var i=0;i<noofsection;i++)
{
sectionArrays["sectionStack"+i+""]=new Array(sectionsize);

}

}

$("form").submit(function() {
	
	});

/*
 * 
 * $("#sectionAssignTable tr td[data-gender=MALE]").parent()

$("#sectionAssignTable tr td[data-gender=MALE]").parent().css('display','none')

 $("#sectionAssignTable tr:eq(2) td:eq(0)").parent().siblings().first().children('td[data-index="index"]').html()

 $("#sectionAssignTable tr td[data-gender=MALE]").siblings('td[data-index="index"]').parent(1)
 * 
 * 
 */