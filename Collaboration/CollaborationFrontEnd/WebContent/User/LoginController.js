app.controller('LoginController' , [
	'UserService',
	'$http',
	'$scope',
	'$rootScope',
	'$location',
	'$cookieStore',
	 function(UserService, $http , $scope , $rootScope, $location , $cookieStore){
		var self = this;
		self.user = {};
		self.guest = {};
		self.admin = {};
		self.currentUser  = $cookieStore.get('currentUser');
		console.log(self.currentUser);
		self.createUser = function(){
			console.log("registration called");
			UserService.createUser(self.user).then(function(data){
				//$rootScope.registeredUser = data;
				$location.path('/');
			},function(error){
				alert("Email or UserName already Exist..Try with another Email or UserName!!!!")
				console.log(error);		
			});
		}
		
		self.validateUser = function() {
			console.log('validate user called');
			//console.log('self.guset');
			
			console.log(self.currentUserId);
			console.log(self.guest);
			UserService.validate(self.guest).then(
					
					function(data) {
					self.responsedata=data;
						
						console.log(self.responsedata);
						//$rootScope.currentUserName=data.name;
						console.log(self.responsedata.userId)
						$rootScope.currentUser=self.responsedata;
						
						$cookieStore.put('currentUser',self.responsedata);
						
						console.log($rootScope.currentUser);
						$location.path('/home');
						
					}, function(error) {
						alert("Invalid Credentials......Please Login Again.");
						console.log(error);
					});
		        } 
		
		self.validateAdmin = function(){
			UserService.validateAdmin(self.admin).then(function(response){
				$location.path("/blog");
			},function(error){
				alert("Inavalid Login Credentials..");
			});
		}
		
		
	}
	
])