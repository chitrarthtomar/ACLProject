angular.module('myApp').controller('resourceAddCtrl', function($scope,resourceService) {
  
  $scope.choices = [];
    $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({});
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };
  
  $scope.resource = {};
  

  $scope.addResource = function () {
    $array = [];
    $scope.resource.rName = $scope.rName;
  $scope.choices.forEach(element => {
      $array.push(element.permission);

  });
  $scope.resource.rPermissions = $array.toString();
  console.log($scope.resource);
  resourceService.postResource($scope.resource);
  }

  $scope.clearText=function(){
      $scope.rName="";
      $scope.choices = [];
  }


  
});
