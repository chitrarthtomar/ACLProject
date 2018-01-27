
angular.module('myApp').controller('groupInfoCtrl',['$scope','getGroups','$stateParams', function($scope,getGroups,$stateParams) {
	
 
  $scope.id = $stateParams.id;
  getGroups.getGroupById($scope.id).then(function(res){
    
    $scope.group = res.group;
    $scope.arbAttrList = JSON.parse($scope.group.gArbitraryAttributes);
     $scope.permissions = JSON.parse($scope.group.gResource);
    $scope.users = $scope.group.gUsers;
  });
  
    
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

	