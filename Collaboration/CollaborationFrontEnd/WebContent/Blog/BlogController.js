app.controller('BlogController', [
				
				'BlogService',
				'$http',
				'$scope',
				'$rootScope',
				'$location',
				'$cookieStore', 
				
				function(BlogService, $http,$scope,$rootScope,$location,$cookieStore){
					var self = this;
					// self.blogs = {blogId: '',blogName: '', blogPost: '' , blogStatus: '' , createDate: '', blogLikes: ''};
					 self.blogs={};
					 self.blog = {};
					 self.myBlogs = {};
					 self.delBlog={};
					console.log("hii");
					self.blogList = function(){
						//self.blogs = $rootScope.currentUser;
						BlogService.getAllBlog().then(function(response){
							console.log("in side controller");
							self.blogs = response;
							
							 
						},
						function(errors){
							alert("Error");
						});
					}
					
					self.myBlogList = function(){
						self.buId = $cookieStore.get('currentUser').userId;
						BlogService.getMyBlog(self.buId).then(function(response){
							self.myBlogs = response;
						},function(error){
							alert("Error getting data");
						});
					}
					
					self.createBlog = function(){
						self.blog.user = $rootScope.currentUser;
						BlogService.addblog(self.blog).then( 
								self.myBlogList,
								function(error){
							alert("Error inserting data");
						})
					}
					
					self.updateBlogById = function(id){
						BlogService.setBlogById(id).then(function(d){
								//sself.myBlogList;
							self.blog = d;
							 //$location.path("/blog"); 
						},function(error){
							alert("Error");
						})
					}
					
					self.deleteBlog = function(buId){
						 self.delBlog = $cookieStore.get('currentUser').userId;
						BlogService.deleteBlog(buId).then(
								self.blogList,
								function(error){
									alert("can not be deleted");
								})
					}
					
					self.likeClick = function(id){
						BlogService.likeUpdate(id).then(
								self.myBlogList,
								function(error){
									console.log("error");
								})
					}
					
					self.approveBlog = function(id){
						BlogService.approveBlog(id).then(
								self.blogList,function(error){
									alert("Sorry...Error in Approving the Blog");
								});
					}
				}
				
])