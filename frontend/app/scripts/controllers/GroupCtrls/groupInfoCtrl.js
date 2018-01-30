/**
 * Controller to handle the information of a group
 */
angular.module('myApp').controller('groupInfoCtrl',['$scope','getGroups','putGroup','getUsers','$stateParams','resourceService', function($scope,getGroups,putGroup,getUsers,
  $stateParams,resourceService) {	 
  $scope.id = $stateParams.id;
  $scope.user_dd = [];
    getGroups.getGroupById($scope.id).then(function(res){  
    $scope.group = res.group;
    $scope.arbAttrList = JSON.parse($scope.group.gArbitraryAttributes);
    $scope.permissions = JSON.parse($scope.group.gResource);
    $scope.groupUsers = $scope.group.gUsers;
	$scope.otherUsers = res.otherUsers;
	$scope.otherUsers.forEach(element => {
      $scope.user_dd.push(element.uId + ':' + element.uName);
      //$scope.dropDown2.push(element.rPermissions.split(","));
    });
	
  });
  $scope.res_dd = [];
  $scope.perm_dd = [];
  $scope.resChoices = [];
  $scope.userChoices = [];
  
  resourceService.getResources().then(function(res){
    $scope.totalResources = res;
    $scope.res_added = $scope.totalResources.filter(function(element){
      if(this.find(function(e){
        return element.id == e.id;
    })) return false;
    else return true;
    },$scope.permissions);
	$scope.totalResources.forEach(element => {
      $scope.res_dd.push(element.rId + ':' + element.rName);
      //$scope.dropDown2.push(element.rPermissions.split(","));
    });
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
  
  $scope.addNewChoice2 = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.resChoices.push({});
  };
    
  $scope.removeChoice2 = function() {
    var lastItem = $scope.choices.length-1;
    $scope.resChoices.splice(lastItem);
  };
  
  $scope.addNewChoice3 = function() {
    var newItemNo = $scope.userChoices.length+1;
    $scope.userChoices.push({});
  };
    
  $scope.removeChoice3 = function() {
    var lastItem = $scope.userChoices.length-1;
    $scope.userChoices.splice(lastItem);
  };
  
  $scope.update = function(item) {
	 //console.log('updating:' + item) ;
    // $scope.permissions.push(item.substr(0,item.indexOf(':')));
	
    $scope.totalResources.forEach(element => {
	  if( element.rId == item.substr(0,item.indexOf(':')))
		$scope.perm_dd.push(element.rPermission.split(","));
	  // if( $.inArray(item.substr(0,item.indexOf(':')),$scope.permissions) == -1){
		  // $scope.dropDown2.push(element.rId + ':' + element.rName);
		  // console.log('not there');
	  // }
    });
  };
  
  var groupDto = {};
  $scope.putGroupm = function (){
	  // $scope.gName;
	  // $scope.gDescription;
	  // $scope.arbitraryChoices;
	  // $scope.choices;
		$scope.users = [];
	   $scope.userChoices.forEach(element => {
		   console.log(element.id);
		   getUsers.getUserById(element.user.split(":")[0]).then(function(user){
				$scope.users.push(user);
		   });
		   $scope.groupUsers.forEach(element => {
			  $scope.users.push(element);
			  //$scope.dropDown2.push(element.rPermissions.split(","));
			});
		   
		});
		putDto = function (){
			groupDto.gName = $scope.group.gName;
			groupDto.gDescription = $scope.group.gDescription;
			groupDto.gArbitraryAttributes = JSON.stringify($scope.arbitraryChoices);
			groupDto.gResource = JSON.stringify($scope.resChoices);
			groupDto.gUsers = ($scope.users);
			putGroup.put(groupDto,$scope.group.gId);
		}
		setTimeout(putDto,2000);
	
		
  }
  
}]);

	