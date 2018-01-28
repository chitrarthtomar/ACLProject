/**
 * Controller to handle the information of a group
 */
angular.module('myApp').controller('groupInfoCtrl',['$scope','getGroups','$stateParams','resourceService', function($scope,getGroups,
  $stateParams,resourceService) {	 
  $scope.id = $stateParams.id;
    getGroups.getGroupById($scope.id).then(function(res){  
    $scope.group = res.group;
    $scope.arbAttrList = JSON.parse($scope.group.gArbitraryAttributes);
    $scope.permissions = JSON.parse($scope.group.gResource);
    $scope.users = $scope.group.gUsers;
  });
  
  resourceService.getResources().then(function(res){
    $scope.totalResources = res;
    $scope.res_added = $scope.totalResources.filter(function(element){
      if(this.find(function(e){
        return element.id == e.id;
    })) return false;
    else return true;
    },$scope.permissions) 
  });
  // $scope.choices = [];  
  // $scope.res_dd = ["Mobile", "Office", "Home"];
  // $scope.perm_dd = ["Use", "Enter", "Live"];
  if($scope.totalResources){
  $scope.res_added = $scope.totalResources.filter(function(element){
    if(this.find(function(e){
      return element.id == e.id;
  })) return false;
  else return true;
  },$scope.permissions) 
  }
$scope.choices = [];
  $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({});
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };
  
}]);

	