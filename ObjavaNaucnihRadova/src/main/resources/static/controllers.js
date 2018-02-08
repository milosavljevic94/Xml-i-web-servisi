app.controller('loginController', function($scope, $http, $rootScope, korisnikFactory) {
	$scope.test = "Pocetna stranica projekta!";
	$scope.korisnik = {};
	
    function init() {
    	console.log('loginController.Init');
        korisnikFactory.getKorisnici().success(function (data) {
        	$scope.korisnici = data;
		});
    }
	init();
	
	$scope.submit = function() {
		
		korisnikFactory.checkValidity($scope.korisnik).then(function(data) {
			toast("Uspesno logovanje.");
			$location.path('/welcome');
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Korisnicko ime i/ili lozinka nisu ispravni.");
		});
	}
});