angular.module('myApp').controller('resourceListCtrl',['resourceService','$scope','$state', function(resourceService,$scope,
$state) {
     resourceService.getResources().then(function(res){
        $scope.resources = res;
    })
    $scope.addResource = function (){
        $state.transitionTo('resourceAdd');
    }
    $scope.selectResource = function(id) {
        $state.transitionTo('resourceInfo',{"id": id});
    }
}]);