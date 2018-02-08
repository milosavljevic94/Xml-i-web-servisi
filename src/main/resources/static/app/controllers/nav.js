angular.module('app')
// Creating the Angular Controller
.controller('NavController', function($http, $scope, AuthService, $state, $rootScope) {
	
	// Check if user has role admin
	function checkOption(role, roles) {
		if((roles).indexOf(role) != -1){
			return true;
		}else {
			return false;
		}
	};
	
	$scope.$on('LoginSuccessful', function() {
		$scope.user = AuthService.user;
		$scope.userAutor = checkOption("Autor", AuthService.user.roles.role);
	});
	$scope.$on('LogoutSuccessful', function() {
		$scope.user = null;
	});
	$scope.logout = function() {
		AuthService.user = null;
		$rootScope.$broadcast('LogoutSuccessful');
		$state.go('login');
	};
});