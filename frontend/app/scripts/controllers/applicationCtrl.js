
angular.module('myApp').controller('ApplicationController', function ($scope,
    USER_ROLES,
    AuthService,$cookies) {
  
  $scope.currentUser = localStorage.getItem("user");
  $scope.userRoles = USER_ROLES;
  $scope.isAuthorized = AuthService.isAuthorized;
  $scope.isLoginPage = false;
  $scope.setCurrentUser = function (data) {
  $scope.currentUser = data.user;
  $scope.token = data.sessionId;
  $cookies.put("sessionId",$scope.token);
  localStorage.setItem("user",data.user);
  $scope.logout = function () {
    localStorage.removeItem("user");
  }
  };
  });