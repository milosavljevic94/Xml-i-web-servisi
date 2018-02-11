angular.module('app')
// Creating the Angular Controller
.controller('RegisterController', function($http, $scope, $state, AuthService, $rootScope) {
	// method for login
	$scope.korisnik = {};
	$scope.korisnik.username;
	$scope.korisnik.password;
	$scope.korisnik.ime;
	$scope.korisnik.prezime;
	$scope.korisnik.orcid;
	$scope.roles = {};
	$scope.roles.role;
	
	$scope.register = function() {
		// requesting the token by usename and password
		$scope.korisnik.roles = $scope.roles;
		$http({
			url : 'api/add/korisnik/'+$scope.korisnik.username,
			method : "POST",
			params : {
				k : $scope.korisnik
			}
		}).success(function(res) {
			$scope.password = null;
			// checking if the token is available in the response
			if (res==="OK") {
				$scope.message = 'Registracija uspesna.';
				// setting the Authorization Bearer token with JWT token
				$http.defaults.headers.common['Authorization'] = 'Bearer ' + res.token;
 
				// setting the user in AuthService
				AuthService.user = res.user;
				AuthService.userRole = res.user.roles;
				$rootScope.$broadcast('LoginSuccessful');
				// go to home page for the logged in user
				$state.go('home');
			} else {
				// if the token is not present in the response then the
				// authentication was not successful. Setting the error message.
				$scope.message = 'Korisnik sa unetim korisnickim imenom vec postoji !';
			}
		}).error(function(error) {
			alert(JSON.stringify(error));
			// if authentication was not successful. Setting the error message.
			$scope.message = 'Prijava na sistem neuspesna !';
		});
	};
});