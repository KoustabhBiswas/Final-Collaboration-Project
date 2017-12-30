app.service('UserService', [
		'$http',
		'$rootScope',
		'$q',
		 
		'RESTURL',
	function($http, $rootScope, $q,  RESTURL) {
			var RESTURL='http://localhost:9866/Collaboration_Back'
			this.addUser=function(user){
				var deferred=$q.defer();
				$http.post(RESTURL + '/register',user)
				.then(
				function(response){
					deferred.resolve(response.data);
					},
					function(error){
						deferred.reject(error);
					});
				return deferred.promise;
				}	
		}]);