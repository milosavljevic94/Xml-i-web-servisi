angular.module('app')
// Creating the Angular Controller
.controller('HomeController', function($http, $scope, AuthService, $state) {
	$scope.user = AuthService.user;
	var userRole = AuthService.user.roles.role;
	if(userRole.indexOf("Autor") > -1){
		$state.go("autorHome");
	}else if(userRole.indexOf("Upravnik") > -1){
		$state.go("upravnikHome");
	}
});