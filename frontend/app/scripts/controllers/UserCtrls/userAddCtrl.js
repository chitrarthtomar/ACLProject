
angular.module('myApp').controller('userAddCtrl', function($scope,resourceService,getUsers) {
  
  $scope.arbitraryChoices = [];
  $scope.mandatoryChoices = [];
  
  $scope.manAddNewChoice = function() {
    var newItemNoMan = $scope.mandatoryChoices.length+1;
    $scope.mandatoryChoices.push({});
  };
    
  $scope.manRemoveChoice = function() {
    var lastItemMan = $scope.mandatoryChoices.length-1;
    $scope.mandatoryChoices.splice(lastItemMan);
  };
  
    $scope.arbAddNewChoice = function() {
    var newItemNoArb = $scope.arbitraryChoices.length+1;
    $scope.arbitraryChoices.push({});
  };
    
  $scope.arbRemoveChoice = function() {
    var lastItemArb = $scope.arbitraryChoices.length-1;
    $scope.arbitraryChoices.splice(lastItemArb);
  };
  
});
