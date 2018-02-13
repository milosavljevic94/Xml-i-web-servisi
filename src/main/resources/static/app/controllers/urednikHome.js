angular.module('app')

// Creating the Angular Controller

.controller('UrednikController', function($http, $scope, AuthService) {
	
	//$scope.korisnik = AuthService.user;

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

});