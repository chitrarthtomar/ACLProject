angular.module('myApp').factory('putGroup',['$http','URL','$cookies',function($http,URL,$cookies){
    var grpService = {};
    grpService.put = function (dto,id) {
        console.log(URL.path+'/groups'+'?token='+$cookies.get('sessionId'));
        return $http
        .put((URL.path+'/groups/'+id+'?token='+$cookies.get('sessionId')),dto)
        .then(function (res) { 
          alert("successfully updated");
        });
    }
    return grpService;
}]);