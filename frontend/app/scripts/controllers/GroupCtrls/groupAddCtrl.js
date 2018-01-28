
angular.module('myApp').controller('groupAddCtrl', function($scope,resourceService) {
  
  $scope.arbitraryChoices = [];
  
  $scope.choices = [];
  $scope.permissions=[];
  
  $scope.dropDown1 = [];
  $scope.dropDown2 = [];

  resourceService.getResources().then(function(res){
    $scope.totalResources = res;
    $scope.res_added = $scope.totalResources.filter(function(element){
      if(this.find(function(e){
        return element.id == e.id;
    })) return false;
    else return true;
    },$scope.permissions) 
    console.log($scope.res_added);
    $scope.res_added.forEach(element => {
      $scope.dropDown1.push(element.rName);
      $scope.dropDown2.push(element.rPermissions);
    });console.log($scope.dropDown1);
    console.log($scope.dropDown2);

  });
  
 if($scope.totalResources){
  $scope.res_added = $scope.totalResources.filter(function(element){
    if(this.find(function(e){
      return element.id == e.id;
  })) return false;
  else return true;
  },$scope.permissions) 
 
  
  }




    $scope.arbAddNewChoice = function() {
    var newItemNoArb = $scope.arbitraryChoices.length+1;
    $scope.arbitraryChoices.push({});
  };

  
  // $scope.show_resources = [];
  //  $scope.getPermissions = function(){
	//          var key = $scope.choic;
  //       // Here you could actually go out and fetch the options for a server.
  //       var myNewOptions = option2Options[key];
  //       // Now set the options.
  //       // If you got the results from a server, this would go in the callback
  //       $scope.options2 = myNewOptions;
  //  }
  $scope.arbRemoveChoice = function() {
    var lastItemArb = $scope.arbitraryChoices.length-1;
    $scope.arbitraryChoices.splice(lastItemArb);
  };
  
    $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({});
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };
  
});
