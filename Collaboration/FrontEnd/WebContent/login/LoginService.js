app.service('LoginService', [
		'$http',
		'$rootScope',
		'$q',
		'$cookieStore',
		 
	function($http, $rootScope, $q,$cookieStore) {

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
		
			this.validate = function(guest) {
				console.log("user service called")
				var deferred = $q.defer();
				$http.post('http://localhost:9855/Collaboration_Back/' + '/login',guest).then(
						function(response) {
							console.log(response.data);
							//console.log(response);
							deferred.resolve(response.data);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
			
			this.editUser=function(currentUser){
				var deferred=$q.defer();
				$http.post(RESTURL + '/updateuser',currentUser)
				.then(
				function(response){
					deferred.resolve(response.data);
					},
					function(error){
						deferred.reject(error);
					});
				return deferred.promise;
				}	
			
			this.addUserProfile=function(users){
				console.log("Job Profile Service called");
				var deferred=$q.defer();
				$http.post(RESTURL + '/adduserprofile',users)
				.then(
				function(response){
					deferred.resolve(response.data);
					},
					function(error){
						deferred.reject(error);
					});
				return deferred.promise;
				}		
			
			
			this.logout=function(data){
				console.log("Logout Service Called");
				
				var deferred=$q.defer();
				$http.post(RESTURL + '/logout',data)
				.then(
				function(response){
				$cookieStore.remove('currentUser');
					deferred.resolve(response);
					},
					function(error){
						deferred.reject(error);
					});
				return deferred.promise;
				}	
				
			
			
			
			
			
			
		}

])