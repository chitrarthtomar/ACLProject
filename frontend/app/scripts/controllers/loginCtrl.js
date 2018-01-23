angular.module('myApp').controller('LoginController', function ($scope,$state, $rootScope, AUTH_EVENTS, AuthService) {
    $scope.credentials = {
      username: '',
      password: ''
    };
    $scope.login = function (credentials) {
      AuthService.login(credentials).then(function (user) {
        
        $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
        $scope.setCurrentUser(user);
        $state.transitionTo('profile');
      }, function () {
        $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
      });
    }; 
  });
  