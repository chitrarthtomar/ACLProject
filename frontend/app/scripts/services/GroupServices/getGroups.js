angular.module('myApp').factory('getGroups',['$http','URL','$cookies',function($http,URL,$cookies){
    var grpService = {};
    grpService.getList = function () {
        console.log(URL.path+'/groups'+'?token='+$cookies.get('sessionId'));
        return $http
        .get(URL.path+'/groups'+'?token='+$cookies.get('sessionId'))
        .then(function (res) { 
          return res.data;
        });
    }
    grpService.getGroupById = function(id) {
        return $http
        .get(URL.path+'/groups/'+id+'?token='+$cookies.get('sessionId'))
        .then(function (res){
            return res.data;
        });
    }
    return grpService;
}]);