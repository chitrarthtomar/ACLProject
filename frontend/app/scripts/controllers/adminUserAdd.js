angular.module('myApp').controller('userAddCtrl', function($scope) {
  
  $scope.mandatoryChoices = [];
  $scope.manRes_dd = ["manres1", "manres2", "manres3"];
  $scope.manPerm_dd = ["manperm1", "manperm2", "manperm3"];
  
  $scope.arbitraryChoices = [];
  $scope.arbRes_dd = ["arbres1", "arbres2", "arbres3"];
  $scope.arbPerm_dd = ["arbperm1", "arbperm2", "arbperm3"];
  
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
