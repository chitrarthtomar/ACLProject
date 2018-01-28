angular.module('myApp').controller('groupsListCtrl',["$state","$scope","getGroups",function($state,$scope,getGroups) {
		getGroups.getList().then(function(groups){
			$scope.groups = groups;
			console.log($scope.groups);
		});	
		$scope.selectGroup = function(id) {
			$state.transitionTo('groupsInfo',{"id": id});
		}
		$scope.addGroup = function(){
			$state.transitionTo('groupAdd');
		}
		
}]);	