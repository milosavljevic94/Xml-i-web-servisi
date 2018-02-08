var app = angular.module('app',['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/',
	{
		templateUrl: 'partials/login.html'
	}).when('/welcome',
	{
		templateUrl: 'partials/welcome.html'
	})
});