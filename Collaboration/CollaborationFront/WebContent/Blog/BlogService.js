'use strict'

app.service('BlogService',['$http','$q','$rootScope',function($http,$q,$rootScope)
{
	var baseurl='http://localhost:9855/Collaboration_Back/';

		 
		//var RESTURL= 'http://localhost:9866/Collaboration_Back/'
		this.fetchAllBlogs = function(){
			 
			$http.get(baseurl + '/get')
			.then(
			function(response){
				 response.data;
				},
				function(error){
					deferred.reject(error);
				});
			 
			}	
	
}
]);