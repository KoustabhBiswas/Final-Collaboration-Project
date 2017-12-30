app.controller("ChatController",function($scope,ChatService){
	
	$scope.messages = [];
	$scope.message = "";
	$scope.max = 140;	
	
	
    $scope.addMessage = function() {
    	console.log("Chat Add Message called")
	ChatService.send($scope.message);
	$scope.message = "";
	};
	
	ChatService.receive().then(null, null, function(message) {
		console.log("Message received....");
		console.log(message)
	    $scope.messages.push(message);
	  });
	
	
	
	
});