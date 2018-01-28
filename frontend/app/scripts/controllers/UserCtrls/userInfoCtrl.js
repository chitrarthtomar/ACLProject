
angular.module('myApp').controller('userInfoCtrl',['$scope','getUsers','$stateParams','resourceService', function($scope,getUsers
  ,$stateParams,resourceService) {

    $scope.id = $stateParams.id;
    getUsers.getUserById($scope.id).then(function(user){
      console.log(user);
      $scope.user = user;
      $scope.arbAttrList = JSON.parse($scope.user.uArbitraryAttributes);
	  $scope.manAttrList = JSON.parse($scope.user.uMandatoryAttributes);
      $scope.permissions = JSON.parse($scope.user.uResource);
    })
	
	  resourceService.getResources().then(function(res){
    $scope.totalResources = res;
    $scope.res_added = $scope.totalResources.filter(function(element){
      if(this.find(function(e){
        return element.id == e.id;
    })) return false;
    else return true;
    },$scope.permissions) 
  });

  if($scope.totalResources){
  $scope.res_added = $scope.totalResources.filter(function(element){
    if(this.find(function(e){
      return element.id == e.id;
  })) return false;
  else return true;
  },$scope.permissions) 
  }
    
   // $scope.totalResources = resourceService.getResources();  


    // $scope.res_added = $scope.totalResources.filter(function(element){
    //   if(this.find(function(e){
    //     return element.id == e.id;
    //   })) return false;
    //   else return true;
    // },$scope.permissions);

    $scope.choices = [];
    $scope.arbitraryChoices = [];
    $scope.mandatoryChoices = [];

    $scope.addNewChoice = function() {
      var newItemNo = $scope.choices.length+1;
      $scope.choices.push({});
    };
      
    $scope.removeChoice = function() {
      var lastItem = $scope.choices.length-1;
      $scope.choices.splice(lastItem);
    };
	
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
    
  }]);
  
      