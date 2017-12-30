var app=angular.module('myApp', ['ngRoute']);
app.config( function($routeProvider){
	$routeProvider
	.when("/", {
		templateUrl : 'login.html'
    })
		.when('/login',{
			templateUrl : 'login.html'
		})
		.when('/register',{
			templateUrl : 'Registration/registration.html',
				controller: 'RegistrationController'
		})
		.when('/blog',{
			templateUrl : 'Blog/Blog.html',
				controller: 'BlogController'
		});
});
