/*(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            //console.log(vm.user.emailId);
            AuthenticationService.Login(vm.user, function (response) {
                if (response.success) {
                	console.log('Success');
                   AuthenticationService.SetCredentials(vm.user);
                    console.log('Email id'+vm.user.emailId);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();
*/

app.controller('UserController', [
		'UserService',
		'$http',
		'$scope',
		'$location',
		'$rootScope',
		'$cookieStore',
		function(LoginService, $http, $scope, $location,$rootScope,$cookieStore){
			var self = this;
			
			self.user = {};
			self.guest={};

				
				self.currentUser=$cookieStore.get('currentUser');
				
				
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
							$location.path('/afterlogin');
							
						}, function(error) {
							alert("Invalid Credentials......Please Login Again.");
							console.log(error);
						});
			        } 
			
			self.updateUser = function(currentUser){
				console.log("UpdateController called");
				
				UserService.editUser(self.currentUser).then(
						function(data){
							$rootScope.currentUser=data;	
						alert("Profile is Updated :)")
							
							$location.path('/goto');
						},function(error) {
							console.log();		
						});
			}

			self.update=function(){
				self.updateUser($rootScope.currentUser);
				
			}
			
			self.createJobProfile=function(){
				self.users.user=$rootScope.registeredUser;
				console.log('Job Profile of User called');
				UserService.addUserProfile(self.users).then(
				function(response){
				alert("Your Registration is complete....Please Login to Continue!!")
					
					//$rootScope.currentRegUser=self.user;
					console.log($rootScope.currentProfile);
					$location.path('/');
				},function(error) {
					console.log(error);		
				});
			}
			
			self.logOut=function(){
				
				console.log("Logout Controller called");
				
				//$cookieStore.remove('currentUser');
				UserService.logout($rootScope.currentUser).then(
						function(response){
							//$cookieStore.remove('currentUser');
						alert("Logout Successfull...:)")
							
							$location.path('/');
						},function(error) {
							console.log(error);		
						});
			}
		
			
			
		} ])