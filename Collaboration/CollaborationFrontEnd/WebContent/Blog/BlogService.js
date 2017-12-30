app.service('BlogService' , [
			'$http',
			'$rootScope',
			'$q',
			function($http, $rootScope , $q){
				this.getAllBlog = function(){
					var deferred = $q.defer();
					$http.get('http://localhost:9855/Collaboration_Back/get').then(function(response){
						console.log("inside service");
						deferred.resolve(response.data);
					},
					function(error){
						deferred.reject();
					});
					return deferred.promise;
				}
				
				this.getMyBlog = function(buId){
					var defer = $q.defer();
					$http.get('http://localhost:9855/Collaboration_Back/myBlog/' + buId).then(function(response){
						defer.resolve(response.data);
					},function(error){
						defer.reject();
					});
					return defer.promise;
				}
				
				this.addblog = function(blog){
					var deferred = $q.defer();
					$http.post('http://localhost:9855/Collaboration_Back/insert' , blog).then(function(response){
						deferred.resolve(response.data);
					},function(error){
						deferred.reject();
					});
					return deferred.promise;
				}
				
				this.deleteBlog  = function(buId){
					var defer = $q.defer();
					$http.post('http://localhost:9855/Collaboration_Back/delete/' + buId).then(function(response){
						defer.resolve(response.data);
					},function(error){
						defer.reject();
					});
					return defer.promise;
				}
				
				this.setBlogById = function(id){
					var defer = $q.defer();
					$http.get('http://localhost:9855/Collaboration_Back/getblog/' + id).then(function(response){
						defer.resolve(response.data);
					},function(error){
						defer.reject();
					});
					return defer.promise;
				}
				
				this.likeUpdate = function(id){
					var defer = $q.defer();
					$http.post('http://localhost:9855/Collaboration_Back/likeupdate/' + id).then(function(response){
						defer.resolve(response.data);
					},
					function(error){
						defer.reject();
					});
					return defer.promise;
				}
				
				this.approveBlog = function(id){
					var defer = $q.defer();
					$http.post('http://localhost:9855/Collaboration_Back/approveblog/' + id).then(function(response){
						defer.resolve(response.data);
					},
					function(error){
						defer.reject();
					});
					return defer.promise;
				}
				
			}
])