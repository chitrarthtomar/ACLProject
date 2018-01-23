
angular.module('myApp').config(['$stateProvider','USER_ROLES', function( $stateProvider,USER_ROLES) {
    $stateProvider.state('loginForm',{
      url : "/loginForm",
      templateUrl: "./views/login/loginForm.html",
      data : {
          authorizedRoles : [USER_ROLES.all]
      }
    });
    $stateProvider.state('profile',{
        url : "/profile",
        templateUrl: "./views/profile/profile.html",
        data : {
            authorizedRoles : [USER_ROLES.all]
        }
      });
  }]);
  
  

  angular.module('myApp').run(function ($rootScope, AUTH_EVENTS, AuthService) {
    $rootScope.$on('$stateChangeStart', function (event, next) {
      var authorizedRoles = next.data.authorizedRoles;
      console.log(authorizedRoles);
      if (!AuthService.isAuthorized(authorizedRoles)) {
        console.log("oops");
        event.preventDefault();
        if (AuthService.isAuthenticated()) {
          // user is not allowed
          $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
        } else {
          // user is not logged in
          $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
        }
      }
    });
  });
  