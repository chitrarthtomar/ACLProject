
angular.module('myApp').controller('ApplicationController', function ($scope,
    USER_ROLES,
    AuthService,$cookies,resourceService) {  
      $scope.currentUser = localStorage.getItem("user");
      $scope.userRoles = USER_ROLES;
      $scope.isAuthorized = AuthService.isAuthorized;
      $scope.isLoginPage = false;
      // $scope.resources = localStorage.getItem("resources");
      // resourceService.setResources();
      $scope.setCurrentUser = function (data) {
        // resourceService.setResources();
        $scope.currentUser = data.user;
        $scope.token = data.sessionId;
        $cookies.put("sessionId",$scope.token);
        localStorage.setItem("user",data.user);
        // resourceService.setResources();
        $scope.logout = function () {
        localStorage.removeItem("user");
        $cookies.remove("sessionId");
        localStorage.removeItem("resources")
      }
    };
});