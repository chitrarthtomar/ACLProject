angular.module('myApp').controller('homePageCtrl', function($scope,$state) {
    $scope.getSelfInfo= function(){
	$state.transitionTo('userPage',{id:$scope.currentUser.uId});
	}
});
