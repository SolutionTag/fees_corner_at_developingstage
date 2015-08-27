var vocationalGroupListScope;
var academic_master_data = angular.module("academic_master_data", []).config(function($httpProvider) {
	$httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8';
})
var standardmasterdataCtrl = academic_master_data.controller("standardController", function($scope) {
	var standardArray = new Object();
	standardArray = JSON.parse($("#standardJsonObjectAsString").html());
	$scope.standards = $.fn.convertJsonStrArrayToObjectArray(standardArray);
	//$scope.maximumStudentInSection=0;
});
var vocationalGroupDefinition = academic_master_data.controller("vocationalGroupDefinition", function($scope, $http) {
	$scope.vocationGroupFormSubmit = function() {
		var status;
		var vocationalForm = $("#vocationalgroupdef").serializeArray();
		var serializedObject = {};
		$.each(vocationalForm, function(key, val) {
			serializedObject[val.name] = val.value;
		});
		var req = {
			method: 'POST',
			url: '/fcds/settings/create-vocational-group',
			async: false,
			data: JSON.stringify(serializedObject)
		}
		var promise = $http(req).success(function(json, status) {
			document.getElementById("vocationalgroupdef").reset();
			status = status;
			vocationalGroupListScope.vocationalGroupList = $.fn.convertJsonStrArrayToObjectArray(json);
			vocationalGroupListScope.$watch('vocationalGroupList', function() {
				$("#vocationalgrouplists label>input").iCheck({
					checkboxClass: 'icheckbox_flat-green',
				});
			});
		}).error(function(data, status) {
			status = status;
		});
		promise.then(function(data) {
			$("#vocationalgrouplists label>input").iCheck({
				checkboxClass: 'icheckbox_flat-green',
			});
		});

	}

});

/*var vocationalGropListDisplayCtrl = academic_master_data.controller("vocationalGropListDisplayCtrl", ["$scope", "$http", function($scope, $http) {
	vocationalGroupListScope = $scope;
	var subjectArray = new Object();
	subjectArray = JSON.parse($("#vocationalGroupJsonObjectAsString").html());
	$scope.vocationalGroupList = $.fn.convertJsonStrArrayToObjectArray(subjectArray);
}])*/

var vocationalGroupAssignController=academic_master_data.controller("vocationalGroupAssignController", ["$scope", "$http", function($scope, $http) {
	 $scope.schoolStandardBeanAsJson=getStandardBeanObjectAsJson();
	 $scope.selectStandard=function(obj){
		
	   }
	vocationalGroupListScope = $scope;
	var subjectArray = new Object();
	subjectArray = JSON.parse($("#vocationalGroupJsonObjectAsString").html());
	$scope.vocationalGroupList = $.fn.convertJsonStrArrayToObjectArray(subjectArray);
}]);

/*var classSectionDisplayCtrl = academic_master_data.controller("classSectionDisplayCtrl", ["$scope", "$http", function($scope, $http) {
	$scope.standardData = JSON.parse($("#standardJsonObjectAsString").html());
}]);*/


