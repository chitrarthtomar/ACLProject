angular.module('myApp').service('Session', function () {
    this.create = function (sessionId, userId, userRole) {
      console.log(userRole);
  
      this.id = sessionId;
      this.userId = userId;
      this.userRole = userRole;
    };
    this.destroy = function () {
      this.id = null;
      this.userId = null;
      this.userRole = null;
    };
  });
  