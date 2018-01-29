angular.module('myApp').controller('userListCtrl',["$state","$scope","getUsers",function($state,$scope,getUsers) {
	getUsers.getList().then(function(users){
		$scope.users = users;
		console.log($scope.users);
	});	
	$scope.selectUser = function(id) {
		$state.transitionTo('userInfo',{"id": id});
	}
	
	$scope.addUser = function(){
		$state.transitionTo('userAdd');
	}
	
}]);	