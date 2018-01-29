angular.module('myApp').controller('logoutCtrl',function($scope){
    (function(){
        localStorage.removeItem("user");
    })();
});