app.factory('korisnikFactory', function($http, $location) {
	
	var factory = {};
	factory.getKorisnici = function() {
		var url = $location.absUrl() + "getKorisnici";
		//return $http.get('/ObjavaNaucnihRadova/rest/users/getKorisnici');
		return $http.get(url);
	};
	
	factory.checkValidity = function(korisnik) {
		var url = $location.absUrl() + "checkValidity";
		//return $http.post('/ObjavaNaucnihRadova/rest/users/checkValidity', korisnik);
		return $http.post(url, korisnik)
	};
	
	return factory;
	
});