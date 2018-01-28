angular.module('myApp').controller('resourceInfoCtrl', function($scope,resourceService,$stateParams) {
    $scope.id = $stateParams.id;
	resourceService.getResourceById($scope.id).then(function(resourceDTO){
        $scope.rName = resourceDTO.rName;
        $scope.permissions = resourceDTO.rPermissions.split(",");
    });
});
