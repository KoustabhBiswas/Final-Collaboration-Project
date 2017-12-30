/*(function () {
    'use strict';
 
    angular
        .module('app')
        .factory('RegistrationService', UserService);
 
    UserService.$inject = ['$timeout', '$filter', '$q'];
    function UserService($timeout, $filter, $q) {
 
        var service = {};
 
        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;
 
        return service;
 
        function GetAll() {
            var deferred = $q.defer();
            deferred.resolve(getUsers());
            return deferred.promise;
        }
 
        function GetById(id) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getUsers(), { id: id });
            var user = filtered.length ? filtered[0] : null;
            deferred.resolve(user);
            return deferred.promise;
        }
 
        function GetByUsername(username) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getUsers(), { username: username });
            var user = filtered.length ? filtered[0] : null;
            deferred.resolve(user);
            return deferred.promise;
        }
 
        function Create(user) {
            var deferred = $q.defer();
 
            // simulate api call with $timeout
            $timeout(function () {
                GetByUsername(user.username)
                    .then(function (duplicateUser) {
                        if (duplicateUser !== null) {
                            deferred.resolve({ success: false, message: 'Username "' + user.username + '" is already taken' });
                        } else {
                            var users = getUsers();
 
                            // assign id
                            var lastUser = users[users.length - 1] || { id: 0 };
                            user.id = lastUser.id + 1;
 
                            // save to local storage
                            users.push(user);
                            setUsers(users);
 
                            deferred.resolve({ success: true });
                        }
                    });
            }, 1000);
 
            return deferred.promise;
        }
 
        function Update(user) {
            var deferred = $q.defer();
 
            var users = getUsers();
            for (var i = 0; i < users.length; i++) {
                if (users[i].id === user.id) {
                    users[i] = user;
                    break;
                }
            }
            setUsers(users);
            deferred.resolve();
 
            return deferred.promise;
        }
 
        function Delete(id) {
            var deferred = $q.defer();
 
            var users = getUsers();
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                if (user.id === id) {
                    users.splice(i, 1);
                    break;
                }
            }
            setUsers(users);
            deferred.resolve();
 
            return deferred.promise;
        }
 
        // private functions
 
        function getUsers() {
            if(!localStorage.users){
                localStorage.users = JSON.stringify([]);
            }
 
            return JSON.parse(localStorage.users);
        }
 
        function setUsers(users) {
            localStorage.users = JSON.stringify(users);
        }
    }
})();*/

'use strict';

app.factory('RegistrationService',['$http', '$q', '$rootScope', function($http,$q,$rootScope)
{
	console.log("user profile service");

	var baseurl = 'http://localhost:9855/Collaboration_Back/'
	return{
		 fetchAllUsers: function() {
	        return $http.get(baseurl+'/allusers')
	            .then(
	            function (response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                return $q.reject(errResponse);
	            }
	        );
	        
	    },
	    
	    createUser: function(user)
	    {
	        return $http.post(baseurl+'/register/',user)
	            .then(
	            function (response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                return $q.reject(errResponse);
	            }
	        );
	    },
	    
	    approveduser: function(useremail,yesno)
	    {
	        return $http.post(baseurl+'/getuserapprove/' + useremail + '/' + yesno)
	            .then(
	            function (response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                return $q.reject(errResponse);
	            }
	        );
	    },
	    
	    authenticate: function(user){
	    	return $http.post(baseurl + '/authenticate', user)
	    		.then(function(response)
	    		{
	    			return response.data;
	    		},
	    		function(errResponse)
	    		{
	    			$rootScope.UserLoggedIn = false;
	    			console.error('Error while getting user');
	    		}
	    	);
	    },
	    
	    logout: function(id){
	    	return $http.get(baseurl + '/logout')
            .then(
    	            function (response) {
    	                return response.data;
    	            },
    	            function(errResponse){
    	                console.error('Error while logout User');
    	                return $q.reject(errResponse);
    	            }
	    	
            );
	    },

 	}
}]);