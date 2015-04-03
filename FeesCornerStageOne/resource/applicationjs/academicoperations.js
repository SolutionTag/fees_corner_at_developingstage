var infoForRatioSplit={
		"totalstudents":"",
		"totalboys":"",
		"totalgirls":"",
		"noofsections":""
		
},
 sectionArrays = { },
 currentStandardId="",
 boysList=[],
 girlsList=[],
 totalsection,
 bothLists,
 sectionstrength=0,
 sectionStudents=new Object(),
 standardStudents=new Object();
$(document).ready(function(){
	//$("#loading_image").hide();
	boysList=$.grep(JSON.parse($("#boysjsondiv").html()),function(n){ return(n) });
	girlsList=$.grep(JSON.parse($("#girlsjsondiv").html()),function(n){ return(n) });
	bothLists=$.grep(JSON.parse($("#bothjsondiv").html()),function(n){ return(n) });
	$("#boyscount").html($("#totalboys").val())
	$("#girlscount").html($("#totalgirls").val())
	var standardId=parseInt(window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1));
	currentStandardId=standardId;
	if(isNaN(standardId)||typeof standardId == undefined){
		 standardId=$("#standardId option:selected").data('standardid');
		 $(".sectionlist[data-standardid="+standardId+"]").css('display','block');
		  sectionstrength=$(".sectionlist[data-standardid="+standardId+"] input[type=hidden]").val()
		 $("label[data-display=displaySectionstrength]").text(sectionstrength);
		  totalsection=$(".sectionlist[data-standardid="+standardId+"] label").length;
		 if( $("#noofacdemician").val() !="0"){
			// prepareInfoForRatioSplit(totalsection);
		 }
		
		
	}else{
		$(".sectionlist[data-standardid="+standardId+"]").css('display','block');
		 sectionstrength=$(".sectionlist[data-standardid="+standardId+"] input[type=hidden]").val()
		$("label[data-display=displaySectionstrength]").text(sectionstrength);
		$("#standardId").val( $("#standardId option[data-standardid="+standardId+"]").val() );
		 totalsection=$(".sectionlist[data-standardid="+standardId+"] label").length;
		if( $("#noofacdemician").val() !="0"){
			// prepareInfoForRatioSplit(totalsection);
		}
		
		
	}
	
	
	$("#standardId").change(function(event){
		if($(this.selectedOptions).val()!="111"){
		var standardId=$(this.selectedOptions).data('standardid');
		$(".sectionlist").css('display','none');
		//var standardId=	$('#standardId :selected').data('standardid');
		       var url="/fcds/academics/standard/"+standardId
			    $('#pickupstudentlistform').attr('action',url.trim() ).submit();
		 $(".sectionlist[data-standardid="+standardId+"]").css('display','block');
		}else{
			$(this).val($("#standardId option[data-standardid="+currentStandardId+"]").val());
		}
		
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
	 $('#Container_mix').mixItUp( {
		 		effects: ['fade'],
		 		easing: 'snap',
			    filterLogic : 'and',
			    load: {
			        sort: '.A' ,/* default:asc */
			        
			    },
			    selectors: {
			        filter: '.filter-btn', /* .filter */
			        sort: '.sort-btn' /* .sort */
			    },
			   /* animation: {
					effects: 'fade scale translateX stagger'
				},*/
			    callbacks: {
					onMixEnd: function(state){
					
					}			    
			    }
	 });
	
	 
	/* $("input[type=radio][name=rules]").iCheck("ifClicked",function(){
		alert(this.html) 
	 })*/
	 $("#sectionAllocationSubmit").click(function(){
		 var url="/fcds/academics/sectionAllocation?wrappedData="+JSON.stringify(sectionStudents)
			    $('#sectionAllocationForm').attr('action', encodeURI(url)).submit();
		 
		 
	 })
})



$("form").submit(function() {
	
	});
$(document).on("ifClicked", "input[type=radio][name=rules]",function(event) {
	/*			
	var girlsRatio=$(this.parentElement.parentElement).siblings('input[id=gratio]').val()
	var boysRatio=$(this.parentElement.parentElement).siblings('input[id=bratio]').val();
	alert("B"+boysRatio+"G"+girlsRatio);*/
	noofsection=totalsection;
	infoForRatioSplit.noofsections=parseInt(noofsection);
    infoForRatioSplit.totalboys=parseInt($("#totalboys").val());
    infoForRatioSplit.totalgirls=parseInt($("#totalgirls").val());
    infoForRatioSplit.totalstudents=parseInt($("#noofacdemician").val());
    boysList=$.grep(JSON.parse($("#boysjsondiv").html()),function(n){ return(n) });
	girlsList=$.grep(JSON.parse($("#girlsjsondiv").html()),function(n){ return(n) });
	bothLists=$.grep(JSON.parse($("#bothjsondiv").html()),function(n){ return(n) });
    var sectionsize=Math.round(infoForRatioSplit.totalstudents/noofsection);
    var boysCountEachSection=Math.round(infoForRatioSplit.totalboys/noofsection);
    var girlsCountEachSection=Math.round(infoForRatioSplit.totalgirls/noofsection);
    for(var i=0;i<noofsection;i++)
	{
	var sectionName=$("div[data-standardid="+currentStandardId+"] big")[i].textContent;
	sectionArrays[""+sectionName+""]=new Array();
	}
	if(	this.dataset.allocateby=="333"){
			var boyscount=0;
			var girlscount=0;
						for(var section=0;section<noofsection;section++)
						{	
							var sectioninfo=$("div[data-standardid="+currentStandardId+"] big")[section];
							var sectionName=sectioninfo.textContent;
							var sectionid=parseInt(sectioninfo.getAttribute('data-sectionid'));
								for(var boys=0;boys<boysCountEachSection;boys++)
								{
									
									if(typeof boysList[boyscount]!="undefined"){
									sectionArrays[sectionName].push(boysList[boyscount]);
									delete boysList[boyscount];
									/*var index=boysList.indexOf(boysList[boys]);
										if (index > -1) {
											boysList.splice(index, 1);
										}*/
									}
									else{
										console.log(boysList[boys]);
									}
									boyscount++;
								}
								for(var girls=0;girls<girlsCountEachSection;girls++)
								{
									if(typeof girlsList[girlscount]!="undefined"){
									sectionArrays[sectionName].push(girlsList[girlscount]);
									delete girlsList[girlscount];
									}
									/*var index=girlsList.indexOf(girlsList[girls]);
									if (index > -1) {
										girlsList.splice(index, 1);
									}*/
									girlscount++;
								}
								sectionStudents[sectionid]=sectionArrays[sectionName];
								
						}
			buildMixItUp(sectionArrays,noofsection);
			initiateMixItUp();
   }
	else if(this.dataset.allocateby=="111")
   {
		var bothcount=0
		for(var section=0;section<noofsection;section++)
		{
			var sectioninfo=$("div[data-standardid="+currentStandardId+"] big")[section];
			var sectionName=sectioninfo.textContent;
			var sectionid=parseInt(sectioninfo.getAttribute('data-sectionid'));
			for(var both=0;both<sectionstrength;both++){
				if(typeof bothLists[bothcount]!="undefined"){
					sectionArrays[sectionName].push(bothLists[bothcount]);
					delete bothLists[bothcount];
				}else{
					
				}
				bothcount++;
			}
			sectionStudents[sectionid]=sectionArrays[sectionName];
		}
		buildMixItUp(sectionArrays,noofsection);
		initiateMixItUp();
   }
			});

function initiateMixItUp(){
	var filters=$(".filter-btn");
	 var sorts=$(".sort-btn");
	 dimensions = {
		        type: '',
		        manufacturer: ''
		    };
	 filters.unbind('click');
	 filters.click(function(){
		 $(filters).removeClass('active');
		 $(filters).addClass('active');
		 var currentFilter=$(this);
		 dimension = currentFilter.attr('data-dimension'),
	      filter = currentFilter.attr('data-filter');
		 if(filter!="all"){
			 dimensions[dimension] = $('#Container_mix').mixItUp('getState').activeSort+filter;
		 }else{
			 dimensions[dimension] = $('#Container_mix').mixItUp('getState').activeSort;
		 }
		
		 $('#Container_mix').mixItUp('filter',  dimensions['manufacturer']);
		 $(this).addClass('active');
		 //$('#Container_mix').mixItUp('sort',  this);
		 
		 });
	 sorts.unbind("click");
	 sorts.click(function(){
		 $(sorts).removeClass('active');
		// $(sorts).addClass('active');
		 var currentFilter=$(this);
		 dimension = currentFilter.attr('data-dimension'),
	      sort = currentFilter.attr('data-sort');
		 dimensions[dimension] = sort;
		 $('#Container_mix').mixItUp('filter',  dimensions['type']);
		 $('#Container_mix').mixItUp('sort',  dimensions['type']);
		 $(this).addClass('active');
		 });
	
	 

		
/*	 var onloadSort=$(".sort-btn:first").attr('data-sort')
	 $('#Container_mix').mixItUp({
	load: {
		filter: onloadSort,
	}
})*/
	 
	
}
function buildMixItUp(sectionArrays,noofsection){
	$(".controls label:first").nextAll('button[data-dimension=type]').remove();
	$("#Container_mix div[data-type=pick]").remove();
	for ( var section = 0; section < noofsection; section++) {
		var sectionName = $("div[data-standardid="
				+ currentStandardId + "] big")[section].textContent;
		var sectionLength = sectionArrays[sectionName].length;
		var studentLists = sectionArrays[sectionName];
		var button = "<button class=\"sort-btn\" data-dimension=\"type\" data-sort=\"."
				+ sectionName
				+ "\">"
				+ sectionName
				+ "</button>";
		
		$(".controls label:first").after(button);
		var mixItUpObj='';
		for ( var j = 0; j < sectionLength; j++) {
			var studentid = studentLists[j];
			if (typeof studentid != "undefined") {
				var studentInfo = $("input[name=studentinfopool][data-studentid="
						+ studentid + "]")
				if (studentInfo)
					var studentname = studentInfo
							.data('studentname');
				studentInfo.data('gender');
				studentInfo.data('studentid');
				var gender = studentInfo.data('gender');
				var className = "mix " + sectionName + " "
						+ gender;
	mixItUpObj+="<div class=\""+ className+ "\" style=\"width: 13%;\" data-type=\"pick\" data-myorder="+ studentname + "></div>"
				
			}

		}
		$("#Container_mix").append(mixItUpObj);
	}
	
	
}
function init(){
	
	
	
}
/*
 * 
 * $("#sectionAssignTable tr td[data-gender=MALE]").parent()

$("#sectionAssignTable tr td[data-gender=MALE]").parent().css('display','none')

 $("#sectionAssignTable tr:eq(2) td:eq(0)").parent().siblings().first().children('td[data-index="index"]').html()

 $("#sectionAssignTable tr td[data-gender=MALE]").siblings('td[data-index="index"]').parent(1)
 * 
 * 
 */