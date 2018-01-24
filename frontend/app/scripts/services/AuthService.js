angular.module('myApp').factory('AuthService', function ($http, Session) {
    var authService = {};
   
    authService.login = function (credentials) {
      return $http
        .post('http://www.mocky.io/v2/5a671d1e2d0000ae12becda5',credentials)
        .then(function (res) {
          //console.log(res)
          Session.create(res.data.id, res.data.user.id,
                         res.data.user.role);
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
  