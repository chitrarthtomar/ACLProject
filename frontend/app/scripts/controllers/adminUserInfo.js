angular.module('myApp').controller('userInfoCtrl', function($scope) {
	
  $scope.manAttrList ={
    "email" : "adt@xyz",
    "Country" : "India",
    "Town" : "Gangtok"
  }
  
    $scope.arbAttrList ={
    "Age" : "35",
    "Height" : "5ft",
    "Hobby" : "reading"
  }
  
    $scope.permissions ={
    "Pantry" : "Enter",
    "Food" : "Eat",
  }
  
  $scope.choices = [];
  
  $scope.res_dd = ["Mobile", "Office", "Home"];
  $scope.perm_dd = ["Use", "Enter", "Live"];
  $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({});
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };
  
});

	