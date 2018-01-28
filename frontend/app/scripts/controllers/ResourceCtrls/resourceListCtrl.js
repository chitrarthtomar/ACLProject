angular.module('myApp').controller('resourceListCtrl',['resourceService','$scope', function(resourceService,$scope) {
     resourceService.getResources().then(function(res){
        $scope.resources = res;
    })
}]);