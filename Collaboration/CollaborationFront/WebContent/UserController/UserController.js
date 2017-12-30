app.controller('UserController', ['$scope', 'UserService', '$location', '$rootScope',
                                function($scope, UserService, $location, $rootScope){
	var self=this;
	self.createuser= createuser;
	self.user={};
	self.createUser=function(){
		console.log('adduser called');
		self.user.status="New";
		UserService.addUser(self.user).then(
				
		function(data){
			$rootScope.registeredUser=data;
		$location.path('/userprofile');
		},function(error) {
			alert("Email or UserName already Exist..Try with another Email or UserName!!!!")
			console.log(error);		
		});
	}
}]);