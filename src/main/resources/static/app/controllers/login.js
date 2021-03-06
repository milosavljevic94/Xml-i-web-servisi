// Creating the Angular Controller
app.controller('LoginController', function($http, $scope, $state, AuthService, $rootScope) {
	
	/*$scope.goToRegistration = function() {
		$state.go('register');
	}*/
	
	// method for login
	$scope.login = function() {
		// requesting the token by usename and passoword
		$http({
			url : 'api/authenticate',
			method : "POST",
			params : {
				username : $scope.username,
				password : $scope.password
			}
		}).success(function(res) {
			$scope.password = null;
			// checking if the token is available in the response
			if (res.token) {
				$scope.message = '';
				// setting the Authorization Bearer token with JWT token
				$http.defaults.headers.common['Authorization'] = 'Bearer ' + res.token;
 
				// setting the user in AuthService
				AuthService.user = res.user;
				AuthService.user.role = res.user.roles.role;
				
				AuthService.userRole = res.user.roles.role;
				$rootScope.$broadcast('LoginSuccessful');
				// go to home page for the logged in user
				$state.go('home');
			} else {
				// if the token is not present in the response then the
				// authentication was not successful. Setting the error message.
				$scope.message = 'Uneto korisnicko ime ili lozinka nisu ispravni !';
			}
		}).error(function(error) {
			alert(JSON.stringify(error));
			// if authentication was not successful. Setting the error message.
			$scope.message = 'Prijava na sistem neuspesna !';
		});
	};
});