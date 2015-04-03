var standardFeeses=new Object();
var assignedFeestoStudent=new Object();
var studentJoinedStandard;
$(document).ready(function(){
	$("div[ data-phonenumberfields=true] input,#markpercentage").ForceNumericOnly();
	standardFeeses=JSON.parse($("#generatejson1").html())
	$("#academicanStandardId").change(function(){
		var standardid=$(this.selectedOptions).attr('data-standardid');
		assignedFeestoStudent=new Object();
		$("div[class=feeslist]").css("display","none");
		studentJoinedStandard=standardid;
		if($(this.selectedOptions).val()!="111"){
			if(typeof standardid!="undefined" && typeof standardFeeses[standardid] !="undefined"){
				assignedFeestoStudent=standardFeeses[standardid];
				$("div[class=feeslist][data-standardfeeslistid="+standardid+"]").css("display","block");
			}
		}
	});
$("div [data-div=feeslists]").on("ifClicked",	"input[type=checkbox][data-name=availablefees]",function(){
	assignedFeestoStudent
	
		
	});
});

function finalfeesAssignmentToStudent(){
	if(typeof studentJoinedStandard!="undefined"){
	for(var i=0;i<assignedFeestoStudent.length;i++){
		if(typeof assignedFeestoStudent[i]!="undefined")
			var ischecked=$("input[type=checkbox][data-standardid="+studentJoinedStandard+"][data-feesid="+assignedFeestoStudent[i].assignedFeesId+"]").is(':checked')
		if(!ischecked){
		delete assignedFeestoStudent[i];
		}
			}
	}
	assignedFeestoStudent=assignedFeestoStudent.filter(function(n){return n !== undefined}); 
	return assignedFeestoStudent;
}