var formIncr = 0,
    superFormFldValues = [],
    jsonData, b = true,
    arrData2 = [],
    indexId, isRetrive = false,
    gridster, columnLength = 1,
    isDeleteWidget = true,
    gridster = [];
var inputTypes = [],
    popUpLists = [],
    inputTypes = ['TEXT', 'LIST', 'TEXTAREA', 'POPUP', 'DATE', 'DATETIME', 'FILE', 'HIDDEN', 'SELECT', 'AUTOFILL', 'CHECKBOX', , 'PASSWORD', 'RADIO', 'HIDDEN', 'BLANK'],
    values = {},
    draggableId, popupForms, listId = 0,
    listValId = '',
    popUpList, dragId, allFldsValues = [],
    formIncr = 1,
    IncrId = 1,
    arrayData, deleteIncr = 1,
    formIdAndValues = JSON.parse("{}"),
    divIdAndValues=JSON.parse("{}"),
     divObj,
    dupformType;

function deleteWidget(deleteId, ev) {
    alert(formIdAndValues);
   var action="deleteWidget";
    deleteId = "#" + deleteId;
    var widgetId = $(deleteId).nthParent(1).attr('id');
    var listIndexId=$("#"+widgetId).attr("listindexid")
    var divListIndexId=$("#"+widgetId).nthParent(2).attr("data_divListIndexId")
    var jsonKey = $("#" + widgetId).attr("data_keyid");
    var namespace=$("#" + widgetId).attr("namespace").substring(1);
    var gridsterObj = $("#"+$("#"+widgetId).nthParent(2).attr('id')+' ul').gridster().data('gridster');
    var formID = "#" + $("#" + widgetId).attr("data_keyid");
    if (formID != "#") {
    	alert("form having")
    	gridsterObj.remove_widget($("#" + widgetId));
    	var formValues= formIdAndValues[namespace];
        delete formValues[jsonKey];
        var obj={"listIndexId":listIndexId,
        		"divListIndexId":divListIndexId}
        var strJson=encodeURIComponent(JSON.stringify(obj));
        // write ajax code to remove divfieldsVO from Form
        $.ajax({
        	url:"/apld/dynui/PageDesign.echn?action=" + action + "&strJson=" + strJson,
        	type:'post',
        	success: function (data) {
        		 alertMessage(JSON.parse(data).statusMessage);
            },
            error: function (xhr, status, error) {
            	
                console.log(xhr);
                console.log(status);
                console.log(error);
            }
        	
        })
        $("#" + jsonKey).parent().parent().hide();
    } else {
    	alert("form not having")
    	gridsterObj.remove_widget($("#" + widgetId));
    	alert(jsonKey);
        $(jsonKey).hide();
    }

    columnLength--;
    isDeleteWidget = false;
    ev.stopPropagation();
}

$.fn.nthParent = function (n) {
    var p = this;
    for (var i = 0; i < n; i++)
        p = p.parent();
    return p;
}

function gridsterDragandDropMain(divsionGridId) {

	$(divsionGridId).click(function(){
		var divKeyId=$(this).attr("data_divlistindexid")
		$("#fldForm").children().hide();
		$("#divInfoEditForm").loadJSON(divIdAndValues[divKeyId]);
		$("#divForm").show();
		
		
	})
    $("#dragId").children().find("ul li").draggable({
        revert: 'invalid',
        helper: 'clone',
        drag: function () {
            dragId = $(this).attr('id');
        }
    });
    $(divsionGridId).droppable({
        accept: $("#dragId").children().find("ul li"),
        activeClass: "active",
        hoverClass: "hover",
        tolerance: "fit",
        containment: 'parent',
        drop: function (event, ui) {
        /*    if ($(this).attr("id") == "grid1") {*/
                gridster = $(divsionGridId+ " ul").gridster({
                    namespace: divsionGridId,
                    widget_base_dimensions: [147, 22],
                    autogenerate_stylesheet: true,
                    avoid_overlapped_widgets: false,
                    widget_margins: [5, 5],
                    min_rows: 3,
                    max_cols: 3,
                    size_x: 3,
                    size_y: 3,
                    serialize_params: function ($w, wgd) {
                        return {
                            col: wgd.col,
                            row: wgd.row,
                            size_x: wgd.size_x,
                            size_y: wgd.size_y,
                            data_keyid: $($w).attr('data_keyid'),
                            listIndexId: $($w).attr('listIndexId'),
                            data_type: $($w).attr('data_type'),
                            namespace: $($w).attr('namespace'),
                            id: $($w).attr('id')
                        };
                    }
                }).data('gridster');
             /*}else {
                gridster = $("#grid2 ul").gridster({
                    namespace: '#grid2',
                    widget_base_dimensions: [147, 22],
                    autogenerate_stylesheet: true,
                    avoid_overlapped_widgets: false,
                    widget_margins: [5, 5],
                    min_rows: 3,
                    max_cols: 3,
                    size_x: 3,
                    size_y: 3,
                    serialize_params: function ($w, wgd) {
                        return {
                            col: wgd.col,
                            row: wgd.row,
                            size_x: wgd.size_x,
                            size_y: wgd.size_y,
                            data_keyid: $($w).attr('data_keyid'),
                            listIndexId: $($w).attr('listIndexId'),
                            data_type: $($w).attr('data_type'),
                            namespace: $($w).attr('namespace'),
                            id: $($w).attr('id')
                        };
                    }
                }).data('gridster');
            }*/
            draggableId = "#" + dragId;
            $(draggableId).removeAttr("style");
            var indexNo = inputTypes.indexOf($(draggableId).text().trim());
            var inputType = inputTypes[indexNo];
            inputType = inputType.toLowerCase();
            var gridsterSize = $("#grid1>").children().length + 1;
            gridsterSize = gridsterSize;
            var fieldType;
            if (inputType == 'select') {
                fieldType = '<div class="form-group" style="margin-top: 9px;padding: 0px 16px 19px 18px;margin-right:13px">' +
                    '<label for="" class="col-sm-2 control-label" style="margin-top: -5px;padding-left: 0px;font-size: 11px;">' + inputType.toUpperCase() + '</label>' +
                    '<div class="col-sm-10" style="left: 27px;bottom: 8px;">' +
                    '<select disabled="disabled" class="form-control">' +
                    '<option>1</option>' +
                    '<option>2</option>' +
                    '<option>3</option>' +
                    '<option>4</option>' +
                    '<option>5</option>' +
                    '</select>' +
                    '</div>' +
                    '</div><span class="glyphicon glyphicon-trash" id="deleteWidget" onclick="return deleteWidget(this.id,event);" style="float: right;top: -39px;"></span>';
            } else {
                fieldType = '<div class="form-group" style="margin-top: 9px;padding: 0px 16px 19px 18px;margin-right:13px">' +
                    '<label for="" class="col-sm-2 control-label" style="margin-top: -5px;padding-left: 0px;font-size: 11px;">' + inputType.toUpperCase() + '</label>' +
                    '<div class="col-sm-10" style="left: 27px;bottom: 8px;">' +
                    '<input type="' + inputType + '" disabled="disabled" class="form-control" id="" placeholder="' + inputType + '">' +
                    '</div>' +
                    '</div><span class="glyphicon glyphicon-trash" id="deleteWidget' + (deleteIncr++) + '" onclick="return deleteWidget(this.id,event);" style="float: right;top: -38px;"></span>';
            }

            console.log("gridsterSize " + gridsterSize);
            console.log("columnLength " + columnLength);

            if (gridsterSize < columnLength) {
                gridsterSize = columnLength;
            }
            for (gridsterSize; gridsterSize <= columnLength; gridsterSize++) {
                listId++;
                var namespace = gridster.options.namespace;
                namespace = namespace.replace("#", "_");
                var datarow = Math.floor(gridsterSize / 1) + 1;
                var datacol = (gridsterSize % 1) + 1;
                var listVal = '<li namespace="' + namespace + '" data_type="' + inputType + '" data-html="true"  id="' + inputType + '' + listId + '" name="' + inputType + '" data_sizey="1" data_sizex="1" data_row="' + datarow + '" data_col="' + datacol + '" data_keyid="" style="background-color: rgb(144, 144, 131);" listIndexId=""></li>';
                listValId = $(listVal).attr('id')
                gridster.add_widget(listVal);
            }
            document.getElementById(listValId).innerHTML = fieldType;
            listValId = "#" + listValId;
            popUpLists.push(listValId);
            $(listValId).click(function (e) {
                $(popUpLists.toString()).css("background-color", "rgb(134, 122, 226)").not(this).css("background-color", "rgb(144, 144, 131)");
                var fieldType = $(this).attr('data_type');

                /*  cmnFrmHdr,lrsFrmHdr,popupFrmHdr,textAreaFrmHdr*/
                if (fieldType == 'select' || fieldType == 'list' || fieldType == 'radio') {
                    var formType = "#lrsFrmHdr";
                    fieldFormCreateUpdate(this, formType);
                } else if (fieldType == 'popup') {
                    var formType = "#popupFrmHdr"
                    fieldFormCreateUpdate(this, formType);
                } else if (fieldType == 'textarea') {
                    var formType = "#textAreaFrmHdr";
                    fieldFormCreateUpdate(this, formType);
                } else {
                    var formType = "#cmnFrmHdr";
                    fieldFormCreateUpdate(this, formType);
                }
                return false;
            });

        }, //drop function end place
        deactivate: function (event, ui) {
            columnLength++;
        }
    });
}

function appearFormCrspondingFlds(obj, fieldFormId, j, k, formname) {

    var lrsForm = $(formname).html();
    $("#fldForm").html(lrsForm);
    var formData = $("#" + $(obj).attr('id')).children(':nth-child(2)').data();
    $("#fldForm").find('form').attr("id", fieldFormId);
    $("#" + fieldFormId).loadJSON(formData);

    var btnId = $('#fldForm :button')[0];

    btnId = $(btnId).attr("id", "save" + $(obj).attr('id') + (k++))
    btnIdPool(btnId);

    var row = $("#" + dummyJsonKey).find(':input[type=hidden]')[0];
    $(row).attr("value", $("#" + $(obj).attr('id')).attr("data_row"));
    var col = $("#" + dummyJsonKey).find(':input[type=hidden]')[1];
    $(col).attr("value", $("#" + $(obj).attr('id')).attr("data_col"));
}
var i = 0;

function fieldFormCreateUpdate(obj, formType) {
    
    if ($("#fldForm>").find('form').attr("id") == "" || $("#fldForm>").find('form').attr("id") != undefined || $("#fldForm>").find('form').attr("id") == undefined) {
        if ($(obj).attr("data_keyid") == "") {

            $("#fldForm").children().hide();

            var formId = $(obj).attr('id') + (formIncr++);
            /* setting form Id */

            $(obj).attr("data_keyid", formId + $(obj).attr("namespace"));

            dupformType = formType + '>';
            $(dupformType).find('form').attr("id", $(obj).attr("data_keyid"));
            var chkKey = "#" + $(obj).attr("data_keyid");
            $(chkKey).nthParent(2).show();
            $(chkKey + " input:not(:submit,:button)").val("").removeAttr('checked').removeAttr('selected');
        } else {
            $("#fldForm").children().hide();

            dupformType = formType + '>';
            $(dupformType).find('form').attr("id", $(obj).attr("data_keyid"));
            var chkKey = "#" + $(obj).attr("data_keyid");
            $(chkKey).nthParent(2).show();
            $(chkKey + " input:not(:submit,:button)").val("").removeAttr('checked').removeAttr('selected');
            updateForm($(obj).attr("data_keyid"),$(obj).attr("namespace").substring(1));
        }
        var row = $(formType + ' form').find(':input[type=hidden]')[0];;
        $(row).attr("value", $("#" + $(obj).attr('id')).attr("data_row"))
        var col = $(formType + ' form').find(':input[type=hidden]')[1];
        $(col).attr("value", $("#" + $(obj).attr('id')).attr("data_col"))
        var sizeX = $(formType + ' form').find(':input[type=hidden]')[2];
        $(sizeX).attr("value", $("#" + $(obj).attr('id')).attr("data_sizex"))
        var sizeY = $(formType + ' form').find(':input[type=hidden]')[3];
        $(sizeY).attr("value", $("#" + $(obj).attr('id')).attr("data_sizey"))
        var btnId = $(formType + ' .btn-info').attr("id", "save" + $(formType + ' form').attr("id"));
        //var btnId = $(formType+" form :button[id=\"\"]").attr("id", "save" + $(formType + ' form').attr("id"));
        //var btnId = $(formType+" form :submit[id=\"\"]").attr("id", "save" + $(formType + ' form').attr("id"));

        $(btnId).off('click', '**');
        $(btnId).unbind("submit");

        var formId = $(btnId).closest('form').attr('id');

        /*$('#ready').html("<script>\n$(document).ready(function(){\n"+            
            "activatePageDesignValidator('"+formId+"');\n"+
        "});\n</script>");*/


        /*$(btnId).on('click', function (e) {
            var formId = "#" + $(this).closest('form').attr('id');
            var jsonKey = $(this).closest('form').attr('id');
            formId = formId + ' :input';
            var serializeForm = $(formId).serializeArray();
            var values = {};
            $.each(serializeForm, function (i, field) {
                values[field.name] = field.value;
            });
            formIdAndValues[jsonKey] = values;
            $(formId).submit();
            
        });*/

    }
}

function updateForm(chkKey,nameSpace) {
	var formValues=formIdAndValues[nameSpace];
    if (typeof formIdAndValues[nameSpace] !="undefined" && typeof formValues[chkKey] != "undefined") {
        $("#" + chkKey).loadJSON(formValues[chkKey]);
    } else {
        $("#" + chkKey + " input:not(:submit,:button)").val('').removeAttr('checked').removeAttr('selected');
    }
}
var j = 0;

function activatePageDesignValidator() {
	alert("activatePageDesignValidator");
    var messi = null;

    var i = $('form')
        .validate({
            onKeyup: true,
            sendForm: false,
            eachValidField: function () {
                $(this).removeClass('error');

            },
            eachInvalidField: function () {
                $(this).addClass('error');
            },
            eachField: function () {
                if ($(this).attr('data-description') != undefined) {
                    $(this).addClass('error');
                }
            },

            description: {
                mandateMsg: {
                    required: ''
                }
            },
            valid: function (event) {
            	//if added for process divInforForm values alone
                var serializeForm = $("#" + event.target.id).serializeArray();
                var values = {};
                var action = "save";
                var listIndexId = 0;
                var divListIndexId=0;
                $.each(serializeForm, function (i, field) {
                    values[field.name] = field.value;
                });
               var divFldValues = JSON.parse("{}");
               var divKey=$("li[data_keyid=" + event.target.id + "]").attr("namespace");
               divKey=divKey.substring(1);
               if(typeof formIdAndValues[divKey] !="undefined"){
            	   divFldValues=formIdAndValues[divKey];
               }else{
            	   formIdAndValues[divKey]=divFldValues;
               }
                if (typeof formIdAndValues[event.target.id] != "undefined") {
                    action = "edit";
                    listIndexId = $("li[data_keyid=" + event.target.id + "]").attr("listIndexId");
                     divObj=$("li[data_keyid=" + event.target.id + "]").nthParent(2)
                    divListIndexId=$(divObj).attr("data_divlistindexid");
                }
                divFldValues[event.target.id] = values;
                formIdAndValues[divKey]=divFldValues;
                
                divObj=$("li[data_keyid=" + event.target.id + "]").nthParent(2)
                divListIndexId=$(divObj).attr("data_divlistindexid");
                document.getElementById('modalLayer').style.visibility = 'visible';
                var fldJson = {
                    "object": JSON.stringify(values),
                    "listIndexId": listIndexId,
                    "divListIndexId":divListIndexId
                };
                alert(fldJson.divListIndexId)
                var strJson = encodeURIComponent(JSON.stringify(fldJson));
                $("#" + event.target.id).ajaxSubmit({
                    type: "POST",
                    url: "/apld/dynui/PageDesign.echn?action=" + action + "&strJson=" + strJson,
                    success: function (data) {
                    	
                        console.log(data);
                        fldJson = JSON.parse(data);
                        //add listIndexId;
                        $("li[data_keyid=" + event.target.id + "]").attr("listIndexId", fldJson.listIndexId);
                      alert("Data Collected Successfully")
                        alertMessage('Data collected successfully');
                    },
                    error: function (xhr, status, error) {
                    	alert("Data not Collected Successfully")
                        console.log(xhr);
                        console.log(status);
                        console.log(error);
                    },
                    dataType: "text"
                });
                console.log("Success");
                document.getElementById('modalLayer').style.visibility = 'hidden';
            
            },
            invalid: function () {
                alertMessage('All red marked fields are mandatory');
            }
        });    
}

function serializeGrid() {
    //since Object doesn't have length, Object.keys(json).length will returns length of the json object. 
    var gridLen = 0;
    var attrLen = Object.keys(formIdAndValues).length;
    var gridPool = JSON.parse("{}");
    $(".gridster").each(function (index) {
        gridLen = (gridLen * 1) + Object.keys($("#" + this.id + " ul").gridster().data('gridster').serialize()).length;
        gridPool[this.id] = JSON.stringify($("#" + this.id + " ul").gridster().data('gridster').serialize());
    });
    console.log(gridLen);
    console.log(JSON.stringify(gridPool));
    if((gridLen*1)==0){
    	alertMessage('Please drag atleast one element');
    	event.preventDefault();
    }
    if ((attrLen*1)>0 && (gridLen*1) == (attrLen*1)) {
        // to source will convert serialize json to gridster array			   
    	

    } else {
        // do nothing
        // throw validation msg
        alertMessage('Please provide attribute values for each element in grid');
    }

    
    return JSON.stringify(gridPool);
}

function constructDiv(serializedGridObj){
	$.each(serializedGridObj,function(key,value){
		
		var ul = "<ul class=\"ulClss\" style=\"list-style: none; position: absolute;\"></ul>";
		$('<div id="'+key+'" class="gridster" style="background-color: rgb(182, 228, 219);width: 851px;height: 248px;">'+ul+'</div>').appendTo(".main-div");
		$('<div class="space-more"><br/></div>').appendTo(".main-div");	
		var selector = "#"+key+" ul";
		var grid =  $(selector).gridster({
                namespace: '#'+key,
                widget_base_dimensions: [147, 22],
                autogenerate_stylesheet: true,
                avoid_overlapped_widgets: false,
                widget_margins: [5, 5],
                min_rows: 3,
                max_cols: 3,
                size_x: 3,
                size_y: 3,
                serialize_params: function($w, wgd) {
                    return {
                        col: wgd.col,
                        row: wgd.row,
                        size_x: wgd.size_x,
                        size_y: wgd.size_y,
                        data_keyid:$($w).attr('data_keyid'),
                        listIndexId:$($w).attr('listIndexId'),
                        data_type:$($w).attr('data_type'),
                        namespace:$($w).attr('namespace'),
                        id:$($w).attr('id')                            
                    };
                }
            }).data('gridster');
			
			var serializeValue = eval(value);
			$.each(serializeValue, function() {					
				var fieldContent="";
				if (this.data_type == 'select') {
					fieldContent = '<div class="form-group" style="margin-top: 9px;padding: 0px 16px 19px 18px;margin-right:13px">' +
						'<label for="" class="col-sm-2 control-label" style="margin-top: -5px;padding-left: 0px;font-size: 11px;">' + this.data_type.toUpperCase() + '</label>' +
						'<div class="col-sm-10" style="left: 27px;bottom: 8px;">' +
						'<select disabled="disabled" class="form-control">' +
						'<option>1</option>' +
						'<option>2</option>' +
						'<option>3</option>' +
						'<option>4</option>' +
						'<option>5</option>' +
						'</select>' +
						'</div>' +
						'</div><span class="glyphicon glyphicon-trash" id="deleteWidget" onclick="return deleteWidget(this.id,event);" style="float: right;top: -39px;"></span>';
				} else {
					fieldContent = '<div class="form-group" style="margin-top: 9px;padding: 0px 16px 19px 18px;margin-right:13px">' +
						'<label for="" class="col-sm-2 control-label" style="margin-top: -5px;padding-left: 0px;font-size: 11px;">' + this.data_type.toUpperCase() + '</label>' +
						'<div class="col-sm-10" style="left: 27px;bottom: 8px;">' +
						'<input type="' + this.data_type + '" disabled="disabled" class="form-control" id="" placeholder="' + this.data_type + '">' +
						'</div>' +
						'</div><span class="glyphicon glyphicon-trash" id="deleteWidget' + (deleteIncr++) + '" onclick="return deleteWidget(this.id,event);" style="float: right;top: -38px;"></span>';
				}
				var listCnt = '<li namespace="' + this.namespace + '" data_type="' + this.data_type + '" data-html="true"  id="' + this.id + '" name="' + this.data_type +
				'"data_sizey="'+this.size_y+'" data_sizex="'+this.size_y+'" data-row="' + this.row + '" data-col="' + this.col + '" data_keyid="'+this.data_keyid+
				'" style="background-color: rgb(144, 144, 131);" listIndexId="'+this.listIndexId+'">'+fieldContent+'</li>';
				
				grid.add_widget(listCnt, this.size_x, this.size_y, this.col, this.row);
			});
	});
	
	//setting event listener for populated fields
	$('.gridster li')
		.each(function(){
			$(this).click(function(){					
				$('.gridster li').css("background-color", "rgb(134, 122, 226)").not(this).css("background-color", "rgb(144, 144, 131)");
				var	fieldType = $(this).attr("data_Type"),						
					formName ="";
				if (fieldType == 'select' || fieldType == 'list' || fieldType == 'radio') {
					 formName = "#lrsFrmHdr";						
				} else if (fieldType == 'popup') {
					 formName = "#popupFrmHdr";						
				} else if (fieldType == 'textarea') {
					 formName = "#textAreaFrmHdr";						
				} else {
					formName = "#cmnFrmHdr";					
				}
				showForm(this,formName);
			});
		});
}

function showForm(fieldObj,formName){		
	var formObj = $(formName+' form').attr("id",$(fieldObj).attr("data_keyid"));			
	var btnObj = $("#"+$(formObj).attr("id") +' .btn-info').attr("id",'#save'+$(formObj).attr("id"));
	var btnId = $(btnObj).attr('id');
	console.log(btnId);
	$(btnId).off('click', '**');
	$(formObj).loadJSON(formIdAndValues[$(fieldObj).attr("data_keyid")]);		
	$(formName).show();
}
function activateDivInfoFormValidator(formId) {
	
	var io=0;
	 var messi=null;  
	 var px=0;
	 var i = $("#"+formId)
     .validate({
         onKeyup: true,
         sendForm: false,
         onfocusout: false,
         eachValidField: function () {
             $(this).removeClass('error');

         },
	    eachInvalidField : function() {
	     $(this).addClass('error');
	    },
	    eachField : function() {
	     if ($(this).attr('data-description') != undefined) {
	      $(this).addClass('error');
	     }
	    },

	    description : {
	      mandateMsg : {
	         required : ''
	     }
	    },
	  
	    valid : function(event) {
	    	
	    	var px=0;
	    	var divName=$("#"+event.target.id).find("#divName").val()
	    	var displayOrder=$("#"+event.target.id).find("#displayOrder").val()
	    	var divIdentSeq=$("#"+event.target.id).find("#identifierSeq").val();
	    	 px=px+40;
	    	 
	    	 
	    	var gridDiv='<div id="grid'+displayOrder+'" data_divListIndexId="" class="gridster" style="background-color: rgb(182, 228, 219);width: 600px;height: 248px;margin-left: 0px;margin-top:'+px+'px">'+
			'<ul class="ulClss" style="list-style: none; position: absolute; "></ul>'+
			'</div>';
	    	
	    	
	    	var divsionGridId="#"+$(gridDiv).attr("id")
	    	//Div forms submit starts here
	    	 var serializeDivForm = $("#" + event.target.id).serializeArray();
	    	  var values = {};
              var action = "saveDivInfo";
              var listIndexId = 0;
              $.each(serializeDivForm, function (i, field) {
                  values[field.name] = field.value;
              });
              var json = {
                      "object": JSON.stringify(values)
                  };
              var strJson = encodeURIComponent(JSON.stringify(json));
              $(this).ajaxSubmit({
                  type: "POST",
                  url: "/apld/dynui/PageDesign.echn?action=" + action + "&strJson=" + strJson,
                  success: function (data) {
                	 
                	  var jsonDivListId=JSON.parse(data);
                	  var divId="#"+$(gridDiv).attr("id");
                	  setDivListIndexId(divId,jsonDivListId)
                	 // alert("list Index Id:"+jsonDivListId.divListIndexId);
                      
                  },
                  error: function (xhr, status, error) {
                	  
                      console.log(xhr);
                      console.log(status);
                      console.log(error);
                  },
                  dataType: "text"
              });
             
              $(".main-div .outsideGrid").before(gridDiv);
	    	
	    	gridsterDragandDropMain(divsionGridId);
	    	$('#myModal').modal('hide')
	    },
	  
	    invalid : function() {     
	     
	      messi =new Messi('All new one red marked fields are mandatory');
	    }
	    
	   });
	
	}
function setDivListIndexId(divId,divValuesInJsonObj){
	var divListIndId=divValuesInJsonObj.divListIndexId;
	divIdAndValues[divListIndId]=JSON.parse(divValuesInJsonObj.object);
	$(divId).attr('data_divlistindexid',divListIndId);
}

