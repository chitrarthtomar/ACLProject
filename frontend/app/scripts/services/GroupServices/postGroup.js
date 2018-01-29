angular.module('myApp').factory('postGroup',['$http','URL','$cookies',function($http,URL,$cookies){
    var grpService = {};
    grpService.post = function (dto) {
        console.log(URL.path+'/groups'+'?token='+$cookies.get('sessionId'));
        return $http
        .post((URL.path+'/groups'+'?token='+$cookies.get('sessionId')),dto)
        .then(function (res) { 
          alert("success");
        });
    }
    return grpService;
}]);