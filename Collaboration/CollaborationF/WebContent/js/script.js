angular.module('RoutingApp', ['ngRoute'])
	.config( ['$routeProvider', function($routeProvider)
	          {
		$routeProvider
		
			.when('/contact', {
				templateUrl: 'contact.html'
			})
			.when('/second', {
				templateUrl: 'second.html'
			})
			.when('/login', {
				templateUrl: 'login.html'
			})
			.when('/register', {
				templateUrl: 'registration.html'
			})
			.otherwise({
				redirectTo: '/login'
			});
	}]);