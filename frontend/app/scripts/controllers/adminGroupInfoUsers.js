angular.module('myApp').controller('groupInfoUsersCtrl', function($scope) {
	
    $scope.users ={
    "user" : ["Aditi","Sita","Gita"]
    }
    $scope.userChoices = [];
    $scope.user_dd = ["Aditi", "Sam", "Ram"];
  
    $scope.userAddNewChoice = function() {
    var newItemNo = $scope.userChoices.length+1;
    $scope.userChoices.push({});
  };
    
  $scope.userRemoveChoice = function() {
    var lastItem = $scope.userChoices.length-1;
    $scope.userChoices.splice(lastItem);
  };
  
});

	