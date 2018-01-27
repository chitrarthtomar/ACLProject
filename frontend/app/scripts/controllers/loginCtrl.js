angular.module('myApp').controller('LoginController', function ($scope,$state, $rootScope, AUTH_EVENTS, AuthService) {
    $scope.credentials = {
      username: '',
      password: ''
    };
    $scope.login = function (credentials) {
      AuthService.login(credentials).then(function (data) {
        
        $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
        $scope.setCurrentUser(data);
        
        $state.transitionTo('adminWelcome');
      }, function () {
        $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
      });
    }; 
  });
  