/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("venueModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/venues/';
            $urlRouterProvider.otherwise("/venuesList");
            $stateProvider.state('venuesList', {
                url: '/venues/list',

                resolve: {
                    funciones: ['$http', function ($http) {
                            return $http.get('data/venues.json');
                        }]
                },

                templateUrl: basePath + 'venues.list.html',
                controller: ['$scope', 'venues', function ($scope, venues) {
                        $scope.venuesRecords = venues.data;
                    }]
            });
        }
    ]);
})(window.angular);