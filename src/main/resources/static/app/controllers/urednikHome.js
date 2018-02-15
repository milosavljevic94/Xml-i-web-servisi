angular.module('app')

// Creating the Angular Controller

.controller('UrednikController', function($http, $scope, AuthService, $state, $rootScope) {
	
	//$scope.korisnik = AuthService.user;
	$rootScope.detailViewRad;
	
	var init = function(){
		$http.get('api/nr/getAll').success(function(res){
			$scope.radovi = res;
			//$scope.message='';
		}).error(function(error){
			alert(JSON.stringify(error));
		});
	};
	init();
	
	$scope.sortType = "rad.coverPage.title"; //default sort type
	$scope.sortReverse = false; 	//default sort order
	$scope.search;	//default search filter term
	
	$scope.details = function(rad) {
		
		$rootScope.detailViewRad = rad;
		
		$state.go('radDetails');
	};
	
	$scope.back = function() {
		
		$state.go('urednikHome');
	}

});