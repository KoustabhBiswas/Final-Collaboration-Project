'use strict' ;
app.controller('BlogController', ['$scope', 'BlogService', '$location', '$rootScope',
                                function($scope, BlogService,  $location, $rootScope) {
	
	//console.log("user blog controller");
	
	var self = this;
    self.blog={
    		blogId:'', blogName:'', 
    		blogPost:'', blogStatus:'', blogLikes:'', createDate: ''};

    self.blogs=[];
   // var baseurl='http://localhost:9855/Collaboration_Back/'

    
    self.fetchAllBlog = function()
    {
    	//console.log("hi");
        BlogService.fetchAllBlogs().then(function(d)
    	{
        	self.blogs = d;
            console.log("Fetch all user blogs");
        },
        function(errResponse)
        {
        	console.error('Error while fetching User blog'+ errResponse);
        }
      )
    	/*$http.get(baseurl + '/get')
		.then(
		function(response){
			 response.data;
			},
			function(error){
				deferred.reject(error);
			});*/
		 
   }
    
  self.fetchAllBlog();
   
 
}]);
