angular.module('myApp').factory('getUsers',['$http','URL','$cookies',function($http,URL,$cookies){
    var userService = {};
    userService.getList = function () {
        return $http
        .get(URL.path+'/users?token='+$cookies.get('sessionId'))
        .then(function (res) { 
          return res.data;
        });
    }
    userService.getUserById = function(id) {
        return $http
        .get(URL.path+'/users/'+id+'?token='+$cookies.get('sessionId'))
        .then(function (res){
            return res.data;
        });
    }
    return userService;
}]);