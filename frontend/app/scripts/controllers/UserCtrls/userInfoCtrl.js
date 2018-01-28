
angular.module('myApp').controller('userInfoCtrl',['$scope','getUsers','$stateParams', function($scope,getUsers,$stateParams) {
	
 
    $scope.id = $stateParams.id;
    getUsers.getUserById($scope.id).then(function(user){
      console.log(user);
      $scope.user = user;
      $scope.arbAttrList = user.uArbitraryAttributes;
      $scope.permissions = user.uResource;
    })
    
    $scope.totalResources = resourceService.getResources();  
    $scope.choices = [];
    
    $scope.res_dd = ["Mobile", "Office", "Home"];
    $scope.perm_dd = ["Use", "Enter", "Live"];

    $scope.res_added = $scope.totalResources.filter(function(element){
      if(this.find(function(e){
        return element.id == e.id;
      })) return false;
      else return true;
    },$scope.permissions);

    $scope.addNewChoice = function() {
      var newItemNo = $scope.choices.length+1;
      $scope.choices.push({});
    };
      
    $scope.removeChoice = function() {
      var lastItem = $scope.choices.length-1;
      $scope.choices.splice(lastItem);
    };
    
  }]);
  
      