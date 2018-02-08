angular.module('app')

// Creating the Angular Controller

.controller('AutorController', function($http, $scope, AuthService) {
	
	$scope.autor = AuthService.user;
	
	
});