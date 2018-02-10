angular.module('app')

// Creating the Angular Controller

.controller('AutorController', function($http, $scope, AuthService) {
	
	$scope.korisnik = AuthService.user;
	
	$scope.orcid2;
	
	$scope.coverPage = {};
	$scope.coverPage.title;
	$scope.autor = {};
	$scope.autor.firstName;
	$scope.autor.lastName;
	$scope.autor.affiliation;
	$scope.autor.email;
	$scope.autor.phoneNumber;
	//$scope.autor.orcid;
	$scope.autorAdresa = {};
	$scope.autorAdresa.street;
	$scope.autorAdresa.streetNumber;
	$scope.autorAdresa.city;
	$scope.autorAdresa.country;
	$scope.nrDef = {};
	$scope.nrDef.abstractText;
	$scope.keywords;
	$scope.paper = {};
	$scope.PrimaryHeader = {};
	$scope.PrimaryHeader.primaryHeaderTitle;
	$scope.PrimaryHeader.primaryHeaderText;
	
	
	/*$scope.coverPage = {'author': []};
	$scope.autor = {};
	$scope.autorAdresa = {};
	$scope.nrDef = {'coverPage': '', 'keywords': '', 'paper': ''};
	$scope.keywords = [];
	$scope.PrimaryHeader = {};
	$scope.paper = {};*/
	
	$scope.addNaucniRad = function(){
		
		/*$scope.autor.authorAddress = $scope.autorAdresa;
		$scope.coverPage.author = $scope.autor;
		$scope.nrDef.coverPage = $scope.coverPage;
		$scope.nrDef.keywords = $scope.keywords;
		$scope.paper.primaryHeader = $scope.PrimaryHeader;
		$scope.nrDef.paper = $scope.paper;*/
		$scope.autor.orcid = [$scope.orcid2];
		$scope.keywords2 = $scope.keywords.split(',');
		$scope.nrDef.keywords = {};
		$scope.nrDef.keywords.keyword = [];
		var listaKeywords = [];
		for(var i=0; i<$scope.keywords2.length; i++) {
			listaKeywords[i] = $scope.keywords2[i];
		}
		$scope.nrDef.keywords.keyword = listaKeywords;
		$scope.autor.authorAddress = $scope.autorAdresa;
		$scope.coverPage.author = [$scope.autor];
		$scope.nrDef.coverPage = $scope.coverPage;
		//$scope.nrDef.keywords = $scope.keywords2;
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