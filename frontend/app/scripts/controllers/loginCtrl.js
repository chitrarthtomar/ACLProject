angular.module('myApp').controller('LoginController', function ($scope,$state, $rootScope, AUTH_EVENTS, 
  AuthService) {
    $scope.credentials = {
      username: '',
      password: ''
    };
    $scope.isLoginPage = true;
    $scope.login = function (credentials) {
      AuthService.login(credentials).then(function (data) {
        $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
        $scope.setCurrentUser(data);
        if(data.user.uRole == 'admin')
          $state.transitionTo('adminWelcome');
        else if(data.user.uRole == 'user')
          $state.transitionTo('userPage',{"id":data.user.uId});
      }, function () {
        alert("Wrong usrname/password");
        $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
      });
    }; 
  });
  