angular.module('myApp').service('SelectionService',["$http", function ($http) {
    var selectedItem;
    var selector = {};
    selector.selectItem = function (selectId) {
        return $http
        .post('http://www.mocky.io/v2/5a671d1e2d0000ae12becda5',selectId)
        .then(function (res) {
            console.log(res);
            selectedItem= res.data;
            return;
        });
    };
    selector.getItem = function () {
        return selectedItem;
    }
    return selector;
  }]);
  