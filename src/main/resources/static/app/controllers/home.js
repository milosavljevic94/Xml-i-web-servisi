angular.module('app')
// Creating the Angular Controller
.controller('HomeController', function($http, $scope, AuthService, $state) {
	$scope.user = AuthService.user;
	var userRole = AuthService.user.roles.role;
	if(userRole === "Autor"){
		$state.go("autorHome");
	}
	else if(userRole === "Urednik") {
		$state.go("urednikHome");
	}
	else if(userRole === "Recenzent"){
		$state.go("autorHome");
	}
});