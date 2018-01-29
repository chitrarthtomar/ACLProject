angular.module('myApp').factory('AuthService', function ($http, Session,URL) {
    var authService = {};
   
    authService.login = function (credentials) {
      return $http
        .post(URL.path+'/login',credentials)
        .then(function (res) {
          //console.log(res)
          Session.create(res.data.sessionId, res.data.user.uId,
                         res.data.user.uRole);
          return res.data;
        });
    };
   
    authService.isAuthenticated = function () {
      return !!Session.userId;
    };
   
    authService.isAuthorized = function (authorizedRoles) {
      if(authorizedRoles == "*") return true;
      if (!angular.isArray(authorizedRoles)) {
        authorizedRoles = [authorizedRoles];
      }
      return (authService.isAuthenticated() &&
        authorizedRoles.indexOf(Session.userRole) !== -1);
    };
   
    return authService;
  });
  