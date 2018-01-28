angular.module('myApp').controller('userPageCtrl',function($scope){
    var user = ($scope.currentUser);
    // getUsers.getUserById($scope.id).then(function(user){
    //     console.log(user);
    //     $scope.uName = user.uName;
    //     $scope.uId = user.uId;
    //     $scope.mandatoryAttributes = JSON.parse(user.uMandatoryAttributes);
    //     $scope.arbitraryAttributes = JSON.parse(user.uArbitraryAttributes);
    //     $scope.permissions = JSON.parse(user.uResource);
    // })
        console.log(user);
        $scope.uName = user.uName;
        $scope.uId = user.uId;
        $scope.mandatoryAttributes = JSON.parse(user.uMandatoryAttributes);
        $scope.arbitraryAttributes = JSON.parse(user.uArbitraryAttributes);
        $scope.permissions = JSON.parse(user.uResource);
});