
angular.module('myApp').controller('groupInfoCtrl',['$scope','getGroups','$stateParams', function($scope,getGroups,$stateParams) {
	
  //   $scope.users ={
  //   "user" : ["Aditi","Sita","Gita"]
  // }
  
  //   $scope.arbAttrList ={
  //   "Age" : "35",
  //   "Height" : "5ft",
  //   "Hobby" : "reading"
  // }
  
  //   $scope.permissions ={
  //   "Pantry" : "Enter",
  //   "Food" : "Eat",
  // }
  $scope.id = $stateParams.id;
  getGroups.getGroupById($scope.id).then(function(group){
    console.log(group);
    $scope.group = group;
    $scope.arbAttrList = $scope.group.gArbitraryAttributes;
    $scope.permissions = $scope.group.gResource;
  })
  
    
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
  
}]);

	