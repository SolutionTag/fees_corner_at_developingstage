<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->
<!--<![endif]-->
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.3.min.js">\x3C/script>')</script>

<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>

<script  src="${pageContext.request.contextPath}/resources/applicationjs/jsutills.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/circular-json.js"></script>

<script  src="${pageContext.request.contextPath}/resources/js/jquery.livequery.min.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/blockUI/jquery.blockUI.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/iCheck/jquery.icheck.min.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/perfect-scrollbar/src/jquery.mousewheel.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/perfect-scrollbar/src/perfect-scrollbar.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/less/less-1.5.0.min.js"></script>

<script  src="${pageContext.request.contextPath}/resources/plugins/jquery-cookie/jquery.cookie.js"/></script>

<script  src="${pageContext.request.contextPath}/resources//plugins/bootstrap-colorpalette/js/bootstrap-colorpalette.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/js/main.js"/></script>

<script  src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"/></script>

<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/DataTables/media/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/DataTables/media/js/DT_bootstrap.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/table-data.js"></script>







<!-- end: MAIN JAVASCRIPTS -->
<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->

<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>
			jQuery(document).ready(function() {
				Main.init();
				TD.init();
				TD1.init();
				jQuery.fn.ForceNumericOnly =
					function()
					{
					    return this.each(function()
					    {
					        $(this).keydown(function(e)
					        {
					            var key = e.charCode || e.keyCode || 0;
					            // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
					            // home, end, period, and numpad decimal
					            return (
					                key == 8 || 
					                key == 9 ||
					                key == 13 ||
					                key == 46 ||
					                key == 110 ||
					                key == 190 ||
					                (key >= 35 && key <= 40) ||
					                (key >= 48 && key <= 57) ||
					                (key >= 96 && key <= 105));
					        });
					    });
					};
					Array.prototype.unique = function() {
						var sorted = this;
						sorted.sort();
						return sorted.filter(function(value, index, arr) {
							if (index < 1) {
								return true;
							} else {
								if (value != arr[index - 1]) {
									return false;
								} else {
									return true;
								}

							}
						});
					}
					Array.prototype.getUnique = function(){
						   var u = {}, a = [];
						   for(var i = 0, l = this.length; i < l; ++i){
						      if(u.hasOwnProperty(this[i])) {
						         continue;
						      }
						      a.push(this[i]);
						      u[this[i]] = 1;
						   }
						   return a;
						};
						$.extend({
						    distinct : function(anArray) {
						       var result = [];
						       $.each(anArray, function(i,v){
						           if ($.inArray(v, result) == -1) result.push(v);
						       });
						       return result;
						    }
						});
			});
			
			 if(typeof window.history.pushState == 'function') {
			     //   window.history.pushState({}, "Hide", "http://localhost:2020/fcds/solutiontag");
			    }
			
			
		</script>