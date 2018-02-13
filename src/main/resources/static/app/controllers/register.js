// Creating the Angular Controller
app.controller('RegisterController', function($http, $scope, $state, $rootScope) {
	// method for login
	$scope.korisnik = {};
	$scope.korisnik.ime;
	$scope.korisnik.prezime;
	$scope.korisnik.username;
	$scope.korisnik.password;
	$scope.korisnik.orcid;
	$scope.korisnik.role;
	//$scope.roles = {};
	//$scope.roles.role;
	
	$scope.register = function() {
		// requesting the token by usename and password
		//$scope.korisnik.roles = $scope.roles;
		$http({
			url : 'api/add/korisnik',
			method : "POST",
			params : {
				//korisnik : $scope.korisnik
				"ime" : $scope.korisnik.ime,
				"prezime" : $scope.korisnik.prezime,
				"username" : $scope.korisnik.username,
				"password" : $scope.korisnik.password,
				"orcid" : $scope.korisnik.orcid,
				"role" : $scope.korisnik.role
			}
		}).success(function(res) {
			alert("success " + res);
		}).error(function(error) {
			alert("Error " + error);
		});
	};
});