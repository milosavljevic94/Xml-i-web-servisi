angular.module('app')

// Creating the Angular Controller

.controller('AutorController', function($http, $scope, AuthService) {
	
	$scope.korisnik = AuthService.user;
	$scope.buttonText = "Dodaj";
	var edit = false;
	
	$scope.orcid2;
	var initializeValues = function(){
		$scope.coverPage = {};
		$scope.coverPage.title;
		$scope.autor = {};
		$scope.autor.firstName;
		$scope.autor.lastName;
		$scope.autor.affiliation;
		$scope.autor.email;
		$scope.autor.phoneNumber;
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
		
		$scope.nazivNaucnogRadaZaCoverLetter;
		$scope.orcidZaCoverLetter;
		
		$scope.coverLetter = {};
		$scope.coverLetter.titleText;
		$scope.coverLetter.name = {};
		$scope.coverLetter.nameOfUniversity;
		$scope.coverLetter.universityAddress = {};
		$scope.coverLetter.email;
		$scope.coverLetter.recipient = {};
		$scope.coverLetter.date;
		$scope.coverLetter.letterText;
		$scope.coverLetter.signature = {};
		
		$scope.coverLetterAutor = {};
		$scope.coverLetterAutor.name;
		$scope.coverLetterAutor.lastName;
		
		$scope.universityAddress = {};
		$scope.universityAddress.street;
		$scope.universityAddress.streetNumber;
		$scope.universityAddress.city;
		$scope.universityAddress.country;
		$scope.universityAddress.postalNumber;
		
		$scope.recipient1 = {};
		$scope.recipient1.name;
		$scope.recipient1.lastName;
		$scope.recipient1.role;
		$scope.recipient1.journalName;
		$scope.recipient = {};
		$scope.recipient.recipientName;
		$scope.recipient.recipientRole;
		$scope.recipient.journalName;
		
		$scope.signature1 = {};
		$scope.signature1.name;
		$scope.signature1.lastName;
		$scope.signature1.academicDegree;
		$scope.signature1.department;
		$scope.signature1.university;
		$scope.signature = {};
		$scope.signature.name;
		$scope.signature.academicDegree;
		$scope.signature.department;
		$scope.signature.university;
	};
	
	initializeValues();
	
	$scope.radovi = [];
	
	var init = function(){
		
		$http.get('api/nr/' + $scope.korisnik.orcid).success(function(res){
			$scope.radovi = res;
			$scope.message='';
			$scope.buttonText = 'Dodaj';
		}).success(function(res){
	
		}).error(function(error){
			
		});
	};
	
	init();
	
	$scope.submit = function() {
		if(edit){
			editRad();
		}else{
			addNaucniRad();	
		}
	};
	
	var editRad = function(){
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
		$scope.paper.primaryHeader = $scope.PrimaryHeader;
		$scope.nrDef.paper = $scope.paper;
		
		$http.put('api/nr/' + $scope.korisnik.orcid + '/' + $scope.nrDef.coverPage.title + '/', $scope.nrDef).success(function(res) {
			initializeValues();
			$scope.message = "Azuriranje uspesno";
			init();
		}).error(function(error) {
			$scope.message =error.message;
		});
	};
	
	$scope.disabledTittle = false;
	
	$scope.initEdit = function(rad) {
		edit = true;
		$scope.disabledTittle = true;
		initializeValues();
		$scope.coverPage = rad.coverPage;
		$scope.coverPage.title = rad.coverPage.title;
		$scope.autor.firstName = rad.coverPage.author[0].firstName;
		$scope.autor.lastName = rad.coverPage.author[0].lastName;
		$scope.autor.affiliation = rad.coverPage.author[0].affiliation;
		$scope.autor.email = rad.coverPage.author[0].email;
		$scope.autor.phoneNumber = rad.coverPage.author[0].phoneNumber;
		$scope.orcid2 = rad.coverPage.author[0].orcid[0];
		
		$scope.autorAdresa.street = rad.coverPage.author[0].authorAddress.street;
		$scope.autorAdresa.streetNumber = rad.coverPage.author[0].authorAddress.streetNumber;
		$scope.autorAdresa.city = rad.coverPage.author[0].authorAddress.city;
		$scope.autorAdresa.country = rad.coverPage.author[0].authorAddress.country;
		
		
		$scope.nrDef.abstractText = rad.abstractText;
		$scope.keywords = "";
		for(var i=0; i<rad.keywords.keyword.length; i++) {
			
			$scope.keywords += rad.keywords.keyword[i] + ",";
		}
		$scope.keywords = $scope.keywords.slice(0, -1);
		
		$scope.PrimaryHeader.primaryHeaderTitle = rad.paper.primaryHeader.primaryHeaderTitle;
		$scope.PrimaryHeader.primaryHeaderText = rad.paper.primaryHeader.primaryHeaderText;
		
		$scope.message='';
		$scope.deleteMessageRad = '';
		$scope.buttonText = 'Azuriraj';
	};

	$scope.initAddRad = function() {
		edit = false;
		$scope.disabledTittle = false;
		initializeValues();
		$scope.message='';
		$scope.deleteMessageRad = '';
		$scope.buttonText = 'Dodaj';
	};

	$scope.deleteRad = function(rad) {
		$http.delete('api/nr/'+ $scope.korisnik.orcid + '/' + rad.coverPage.title).success(function(res) {
			$scope.deleteMessage ="Uspesno!";
			$scope.radovi = res;
			init();
		}).error(function(error) {
			$scope.deleteMessage = error.message;
		});
	};
	
	var addNaucniRad = function(){
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
		$scope.paper.primaryHeader = $scope.PrimaryHeader;
		$scope.nrDef.paper = $scope.paper;
		
		$http({ 
		    method: 'POST',
		    url: 'api/add/nr/' + $scope.korisnik.orcid,
		    data: $scope.nrDef
		}).success(function(red){
			init();
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.addCoverLetter = function() {
		$scope.coverLetter.name = $scope.coverLetterAutor.name + " " + $scope.coverLetterAutor.lastName;
		$scope.coverLetter.universityAddress = $scope.universityAddress;
		
		$scope.recipient.recipientName = $scope.recipient1.name + " " + $scope.recipient1.lastName;
		$scope.recipient.recipientRole = $scope.recipient1.role;
		$scope.recipient.journalName = $scope.recipient1.journalName;
		$scope.coverLetter.recipient = $scope.recipient;
		
		$scope.coverLetter.date = new Date();
		
		$scope.signature.name = $scope.signature1.name + " " + $scope.signature1.lastName;
		$scope.signature.academicDegree = $scope.signature1.academicDegree;
		$scope.signature.department = $scope.signature1.department;
		$scope.signature.university = $scope.signature1.university;
		$scope.coverLetter.signature = $scope.signature;
		
		$http({ 
		    method: 'POST',
		    url: 'api/add/coverLetter/' + $scope.nazivNaucnogRadaZaCoverLetter + "/" + $scope.orcidZaCoverLetter,
		    data: $scope.coverLetter
		}).success(function(res){
			init();
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
});