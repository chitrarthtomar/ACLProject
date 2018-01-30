
angular.module('myApp').controller('groupAddCtrl', function($scope,resourceService, getUsers,postGroup) {  
  $scope.arbitraryChoices = [];

  $scope.choices = [];
  $scope.permissions=[];
  
  $scope.dropDown1 = [];
  $scope.dropDown2 = [];
  
  $scope.userChoices = [];
  $scope.allUsers = [];
  getUsers.getList().then( function(res){
	 res.forEach(element => {
		 console.log('opop' + element.uId);
      $scope.allUsers.push(element.uId + ':' + element.uName);
    });
  });
  
  resourceService.getResources().then(function(res){
    $scope.totalResources = res;
    $scope.totalResources.forEach(element => {
      $scope.dropDown1.push(element.rId + ':' + element.rName);
    });
    
  });
    $scope.arbAddNewChoice = function() {
    var newItemNoArb = $scope.arbitraryChoices.length+1;
    $scope.arbitraryChoices.push({});
  };

  $scope.options1 = $scope.dropDown1;
  $scope.options2 = [];
   $scope.getPermissions = function(){
   var key = $scope.options1.indexOf($scope.choice1);   
        var myNewOptions = $scope.dropDown2[key];
        $scope.options2 = myNewOptions;
   }
  $scope.arbRemoveChoice = function() {
    var lastItemArb = $scope.arbitraryChoices.length-1;
    $scope.arbitraryChoices.splice(lastItemArb);
  };
  
	$scope.tempvar ;
    $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({});
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };
  
  $scope.addNewChoice3 = function() {
    var newItemNo = $scope.userChoices.length+1;
    $scope.userChoices.push({});
	$scope.userChoices.forEach(element => {
		  console.log(element.id);
	  });
  };
    
  $scope.removeChoice3 = function() {
    var lastItem = $scope.userChoices.length-1;
    $scope.userChoices.splice(lastItem);
	$scope.userChoices.forEach(element => {
		  console.log(element.id);
	  });
	  console.log('Length is:' +$scope.userChoices.length);
  };
  
  $scope.update = function(item) {
	 console.log('updating:' + item) ;
    $scope.totalResources.forEach(element => {
	  if( element.rId == item.substr(0,item.indexOf(':')))
		$scope.dropDown2.push(element.rPermission.split(","));
    });
  };
  var groupDto = {};
  $scope.postGroup = function (){
		$scope.users = [];
	   $scope.userChoices.forEach(element => {
		   console.log(element.id);
		   getUsers.getUserById(element.id.split(":")[0]).then(function(user){
				$scope.users.push(user);
		   });
		});
		postDto = function (groupName,groupDescription){
			groupDto.gName = $scope.groupName;
			groupDto.gDescription = $scope.groupDescription;
			groupDto.gArbitraryAttributes = JSON.stringify($scope.arbitraryChoices);
			groupDto.gResource = JSON.stringify($scope.choices);
			groupDto.gUsers = ($scope.users);
			postGroup.post(groupDto);
		}
		setTimeout(postDto,2000);		
  }
});
