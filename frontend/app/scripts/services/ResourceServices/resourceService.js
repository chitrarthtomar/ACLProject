angular.module('myApp').factory('resourceService',['$http','URL','$cookies',function($http,URL,$cookies){
    var resourceService = {};
    var resources = [];
    resourceService.getResources = function () {
        console.log(URL.path+'/resources'+'?token='+$cookies.get('sessionId'));
        return $http
        .get(URL.path+'/resources'+'?token='+$cookies.get('sessionId'))
        .then(function (res) {  
          return res.data;
        });
    }
    resourceService.postResource = function(resource){
        $http
        .post((URL.path+'/resources?token='+$cookies.get('sessionId')),resource)
        .then(function (res){
            alert('Successfully Added');
        });
    }
    resourceService.getResourceById = function(id) {
        return $http
        .get(URL.path+'/resources/'+id+'?token='+$cookies.get('sessionId'))
        .then(function (res) {  
          return res.data;
        });
    }
    return resourceService;
}]);