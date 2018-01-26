angular.module('myApp').factory('getUsers',['$http','URL',function($http,URL){
    var userService = {};
    userService.getList = function () {
        return $http
        .get(URL.path+'/users')
        .then(function (res) { 
          return res.data;
        });
    }
    userService.getUserById = function(id) {
        return $http
        .get(URL.path+'/users/'+id)
        .then(function (res){
            return res.data;
        });
    }
    return userService;
}]);