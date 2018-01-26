angular.module('myApp').factory('getUsers',['$http',function($http){
    var userService = {};
    userService.getList = function () {
        return $http
        .get('http://www.mocky.io/v2/5a6b0fc631000096131b89e3')
        .then(function (res) { 
          return res.data;
        });
    }
    userService.getUserById = function(id) {
        return $http
        .get('http://www.mocky.io/v2/5a6b108e310000230e1b89e6')
        .then(function (res){
            return res.data;
        });
    }
    return userService;
}]);