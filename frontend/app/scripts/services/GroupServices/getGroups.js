angular.module('myApp').factory('getGroups',['$http',function($http){
    var grpService = {};
    grpService.getList = function () {
        return $http
        .get('http://www.mocky.io/v2/5a6af1e8310000a60f1b8964')
        .then(function (res) { 
          return res.data;
        });
    }
    grpService.getGroupById = function(id) {
        return $http
        .get('http://www.mocky.io/v2/5a6b29893100005b171b8a48')
        .then(function (res){
            return res.data;
        });
    }
    return grpService;
}]);