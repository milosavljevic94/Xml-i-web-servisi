angular.module('app')

// Creating the Angular Controller

.controller('AutorController', function($http, $scope, AuthService) {
	
	$scope.korisnik = AuthService.user;
	
	$scope.coverPage = {'author': []};
	$scope.autor = {};
	$scope.autorAdresa = {};
	$scope.nrDef = {'coverPage': '', 'keywords': '', 'paper': ''};
	$scope.keywords = [];
	$scope.PrimaryHeader = {};
	$scope.paper = {};
	
	$scope.addNaucniRad = function(){
		
		$scope.autor.authorAddress = $scope.autorAdresa;
		$scope.coverPage.author = $scope.autor;
		$scope.nrDef.coverPage = $scope.coverPage;
		$scope.nrDef.keywords = $scope.keywords;
		$scope.paper.primaryHeader = $scope.PrimaryHeader;
		$scope.nrDef.paper = $scope.paper;
		
		$http({ 
		    method: 'POST',
		    url: 'api/add/nr/',
		    data: $scope.nrDef
		}).error(function(error) {
			$scope.message = error.message;
		});
        
	};
	
	parseXml = function(xmlStr) {
        return ( new DOMParser () ).parseFromString(xmlStr, "text/xml");
    };
});