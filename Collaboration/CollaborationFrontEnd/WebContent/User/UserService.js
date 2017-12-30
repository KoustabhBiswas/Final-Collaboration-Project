app.service('UserService' , [
	'$http',
	'$q',
	'$rootScope' ,
	function($http , $q , $rootScope){
		this.createUser = function(user){
			var defer = $q.defer();
			$http.post('http://localhost:9855/Collaboration_Back/register',user).then(function(response){
				 defer.resolve(response.data);
			},function(error){
				defer.reject(response.data);
			});
			return defer.promise;
		}
		
		this.validate = function(guest) {
			console.log("user service called")
			var deferred = $q.defer();
			$http.post('http://localhost:9855/Collaboration_Back/login',guest).then(
					function(response) {
						console.log(response.data);
						//console.log(response);
						deferred.resolve(response.data);
					}, function(error) {
						deferred.reject(error);
					});
			return deferred.promise;
		}
		
		this.validateAdmin = function(admin){
			var defer = $q.defer();
			$http.post('http://localhost:9855/Collaboration_Back/adminLogin' , admin).then(function(response){
				defer.resolve(response.data);
			},function(error){
				defer.reject();
			});
			return defer.promise;
		}
	}
])