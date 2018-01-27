angular.module('myApp').factory('resourceService',['$http','URL','$cookies',function($http,URL,$cookies){
    var resourceService = {};
    var resources = [];
    resourceService.setResources = function () {
        console.log(URL.path+'/resources'+'?token='+$cookies.get('sessionId'));
        $http
        .get(URL.path+'/resources'+'?token='+$cookies.get('sessionId'))
        .then(function (res) { 
          resources =  res.data;
        });
    }
    resourceService.getResources = function() {
        return resources;
    }
    return resourceService;
}]);