$(document).ready(function() {
    var max_fields      = 100; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    var sectionSize     = $(".sectionsize");
   
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
            $(this).parent().parent().children('.input_fields_wrap').append('<div class="col-md-1"><span class="input-icon input-icon-right"><input type="text"  data-sectionname="section" value="" class="form-control ipbox "><input type="hidden" name="indexId"  data-standardid="" value=""><i class="clip-close-2 remove_field"></i></span></div>'); //add input box
        
    });
   
    $(wrapper).on("mousedown",".remove_field", function(e){ //user click on remove text
         var  standardIndexId=$(this.parentElement).find('input[data-standardid]').data('standardid');
         var sectionIndexId=$(this.parentElement).find('input[data-standardid]').val();
         if( sectionIndexId !="" && standardIndexId !=""){
         	var deleteParameters= {"standardIndexId":standardIndexId,
         		 "sectionIndexId":sectionIndexId}
         	deleteSection(deleteParameters);
         	$(this).parent('span').parent('div').remove();
         }else{
        	 $(this).parent('span').parent('div').remove();
         }
    })
  $(wrapper).on("focus",".ipbox", function(e){
$(this).removeClass( "border_ip" );
$(this).parent('span').find(".remove_field").removeClass( "w_ip" );

  });
  $(wrapper).on("blur",".ipbox", function(e){
	  
	 $(this).addClass( "border_ip" );
	// $(this)(".remove_field").addClass( "w_ip" );
	$(this).parent('span').find(".remove_field").addClass( "w_ip" );
//    $(this).css("border","none");
	//alert("Blur");
  });	
  
  $(sectionSize).on("blur",".ipbox",function(){
	  $(this).addClass( "border_ip" );
  })
  $(sectionSize).on("focus",".ipbox", function(e){
	  $(this).removeClass( "border_ip" );
	  $(this).parent('span').find(".remove_field").removeClass( "w_ip" );
  });
  $(wrapper).on("mouseenter",".remove_field", function(e){
//$(this).removeClass( "w_ip" );
//$(this).css("visibility","visible");  //visibility:visible
	//alert("Focus");
  });
  $(wrapper).on("mouseleave",".remove_field", function(e){
//$(this).css("visibility","hidden");	 //visibility:hidden 
//$(this).addClass( "w_ip" );
	//alert("Blur");
  });	
   
   

	
});

