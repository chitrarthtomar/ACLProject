angular.module('myApp').controller('groupsListCtrl',["SelectionService","$state","$scope", function(SelectionService,$state,$scope) {
	$scope.groups1 = [
		{name : 'Group1', id : 1},
		{name : 'Group2', id : 2},
		{name : 'Group3', id : 3}
	];
	$scope.selectGroup = function(groupId) {
		SelectionService.selectItem(groupId).then(function(){
			$state.transitionTo("groupsInfo");
		})
			
	}	
}]);	