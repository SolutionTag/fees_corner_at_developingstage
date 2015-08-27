jQuery.fn.extend({
convertStringArraytoJsonArray:function(strArray){
	var originalArray=[];
	$.each(strArray,function(k,v){
		originalArray.put(JSON.parse(this));
	})
},
convertJsonStrArrayToObjectArray:function(strArray){
	var obj=[];
	if (typeof strArray != "undefined" && strArray!=null) {
		obj=jQuery.parseJSON("[" + strArray.myArrayList+ "]");
	}
	return obj;
}
})

