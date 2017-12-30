/*(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);
     
    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'home/home.view.html',
                controllerAs: 'vm'
            })

            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'login/login.html',
                controllerAs: 'userCtrl'
            })

            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.html',
              //  templateUrl: 'Blog/Blog.html'
                controllerAs: 'vm'
            })
            
            .when('/blog', {
                controller: 'BlogController',
                templateUrl: 'Blog/Blog.html'
               
                
            })

            .otherwise({ redirectTo: '/login' });
    }

     run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();*/

var app = angular.module('myApp', [ 'ngRoute','ngCookies']);
app.config(function($routeProvider) {
	$routeProvider
    .when('/', {
        controller: 'HomeController',
        templateUrl: 'home/home.view.html',
        controllerAs: 'vm'
    })

    .when('/login', {
        controller: 'LoginController',
        templateUrl: 'login/login.html',
        controllerAs: 'userCtrl'
    })

    .when('/register', {
        controller: 'RegisterController',
        templateUrl: 'register/register.html',
      //  templateUrl: 'Blog/Blog.html'
        controllerAs: 'vm'
    })
    
    .when('/blog', {
        controller: 'BlogController',
        templateUrl: 'Blog/Blog.html'
       
        
    })

    .otherwise({ redirectTo: '/login' });

})
