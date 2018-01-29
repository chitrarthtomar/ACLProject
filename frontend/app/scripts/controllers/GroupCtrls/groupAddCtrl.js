
angular.module('myApp').controller('groupAddCtrl', function($scope,resourceService, getUsers,postGroup) {
  
  $scope.arbitraryChoices = [];
  
  $scope.choices = [];
  $scope.permissions=[];
  
  $scope.dropDown1 = [];
  $scope.dropDown2 = [];
  
  $scope.userChoices = [];
  $scope.allUsers = [];
  $scope.gName = '';
  $scope.gDescription = '';
  getUsers.getList().then( function(res){
	 res.forEach(element => {
		 console.log('opop' + element.uId);
      $scope.allUsers.push(element.uId + ':' + element.uName);
      //$scope.dropDown2.push(element.rPermissions.split(","));
    });
  });
  
  resourceService.getResources().then(function(res){
    $scope.totalResources = res;
    // $scope.res_added = $scope.totalResources.filter(function(element){
      // if(this.find(function(e){
        // return element.id == e.id;
    // })) return false;
    // else return true;
    // },$scope.permissions)
    // console.log('res_added: ' + $scope.res_added);
	// console.log('total: ' + $scope.totalResources);
	// console.log('permissions: ' + $scope.permissions);
    $scope.totalResources.forEach(element => {
      $scope.dropDown1.push(element.rId + ':' + element.rName);
      //$scope.dropDown2.push(element.rPermissions.split(","));
    });
    
    // console.log($scope.dropDown1);
    // console.log($scope.dropDown2);

  });
  
  
  
  
  
 // if($scope.totalResources){
  // $scope.res_added = $scope.totalResources.filter(function(element){
    // if(this.find(function(e){
      // return element.id == e.id;
  // })) return false;
  // else return true;
  // },$scope.permissions) 
  // }



    $scope.arbAddNewChoice = function() {
    var newItemNoArb = $scope.arbitraryChoices.length+1;
    $scope.arbitraryChoices.push({});
  };

  $scope.options1 = $scope.dropDown1;
  $scope.options2 = [];
  // $scope.show_resources = [];
   $scope.getPermissions = function(){
   var key = $scope.options1.indexOf($scope.choice1);   

           
        // Here you could actually go out and fetch the options for a server.
        var myNewOptions = $scope.dropDown2[key];
        // Now set the options.
        // If you got the results from a server, this would go in the callback
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
	//$scope.dropDown2.pop();
	// if($scope.permissions.length!=0)
		// $scope.dropDown1=[];
	
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
	// $scope.choices.splice($scope.permissions.length-1);
  };
  
  $scope.addNewChoice3 = function() {
    var newItemNo = $scope.userChoices.length+1;
    $scope.userChoices.push({});
	$scope.userChoices.forEach(element => {
		  //var userId = element.id.split(":")[0];
		  console.log(element.id);
	  });
  };
    
  $scope.removeChoice3 = function() {
    var lastItem = $scope.userChoices.length-1;
    $scope.userChoices.splice(lastItem);
	$scope.userChoices.forEach(element => {
		  //var userId = element.id.split(":")[0];
		  console.log(element.id);
	  });
	  console.log('Length is:' +$scope.userChoices.length);
  };
  
  $scope.update = function(item) {
	 console.log('updating:' + item) ;
    // $scope.permissions.push(item.substr(0,item.indexOf(':')));
	
    $scope.totalResources.forEach(element => {
	  if( element.rId == item.substr(0,item.indexOf(':')))
		$scope.dropDown2.push(element.rPermissions.split(","));
	  // if( $.inArray(item.substr(0,item.indexOf(':')),$scope.permissions) == -1){
		  // $scope.dropDown2.push(element.rId + ':' + element.rName);
		  // console.log('not there');
	  // }
    });
  };
  var groupDto = {};
  $scope.postGroup = function (){
	  // $scope.gName;
	  // $scope.gDescription;
	  // $scope.arbitraryChoices;
	  // $scope.choices;
		$scope.users = [];
	   $scope.userChoices.forEach(element => {
		   console.log(element.id);
		   getUsers.getUserById(element.id.split(":")[0]).then(function(user){
				$scope.users.push(user);
		   });
		});
		postDto = function (){
			groupDto.gName = $scope.gName;
			groupDto.gDescription = $scope.gDescription;
			groupDto.gArbitraryAttributes = JSON.stringify($scope.arbitraryChoices);
			groupDto.gResource = JSON.stringify($scope.choices);
			groupDto.gUsers = ($scope.users);
			postGroup.post(groupDto);
		}
		setTimeout(postDto,2000);
	
		
  }
});
