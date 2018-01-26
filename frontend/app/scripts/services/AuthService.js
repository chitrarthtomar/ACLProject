angular.module('myApp').factory('AuthService', function ($http, Session) {
    var authService = {};
   
    authService.login = function (credentials) {
      return $http
        .post('http://www.mocky.io/v2/5a6aed8d310000ef0d1b8959',credentials)
        .then(function (res) {
          //console.log(res)
          Session.create(res.data.sessionId, res.data.user.uId,
                         res.data.user.uRole);
          return res.data.user;
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
  