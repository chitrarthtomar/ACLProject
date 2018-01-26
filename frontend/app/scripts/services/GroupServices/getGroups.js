angular.module('myApp').factory('getGroups',['$http','URL',function($http,URL){
    var grpService = {};
    grpService.getList = function () {
        return $http
        .get(URL.path+'/groups')
        .then(function (res) { 
          return res.data;
        });
    }
    grpService.getGroupById = function(id) {
        return $http
        .get(URL.path+'/groups/'+id)
        .then(function (res){
            return res.data;
        });
    }
    return grpService;
}]);