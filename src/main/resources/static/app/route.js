angular.module('app').config(function($stateProvider, $urlRouterProvider) {
	// the ui router will redirect if a invalid state has come.
	$urlRouterProvider.otherwise('/page-not-found');
	// parent view - navigation state
	$stateProvider.state('nav', {
		abstract : true,
		url : '',
		views : {
			'nav@' : {
				templateUrl : 'app/views/nav.html',
				controller : 'NavController'
			}
		}
	}).state('autorHome', {
		parent : 'nav',
		url : '/autorHome',
		views : {
			'content@' : {
				templateUrl : 'app/views/autorHome.html',
				controller : 'AutorController',
			}
		}
	}).state('urednikHome', {
		parent : 'nav',
		url : '/urednikHome',
		views : {
			'content@' : {
				templateUrl : 'app/views/urednikHome.html',
				controller : 'UrednikController',
			}
		}
	}).state('home', {
		parent : 'nav',
		url : '/',
		views : {
			'content@' : {
				templateUrl : 'app/views/home.html',
				controller : 'HomeController'
			}
		}
	}).state('login', {
		parent : 'nav',
		url : '/login',
		views : {
			'content@' : {
				templateUrl : 'app/views/login.html',
				controller : 'LoginController'
			}
		}
	}).state('register', {
		parent : 'nav',
		url : '/register',
		views : {
			'content@' : {
				templateUrl : 'app/views/register.html'
				//controller : 'RegisterController'
			}
		}
	}).state('page-not-found', {
		parent : 'nav',
		url : '/page-not-found',
		views : {
			'content@' : {
				templateUrl : 'app/views/page-not-found.html',
				controller : 'PageNotFoundController'
			}
		}
	});
});