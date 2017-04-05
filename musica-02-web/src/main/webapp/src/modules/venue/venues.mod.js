(function (ng) {
    var mod = ng.module("venuesModule", ['ui.router']);
    mod.constant("venuesContext", "api/venues");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/venue/';

            $urlRouterProvider.otherwise("/venuesList");

            $stateProvider.state('venues', {
                url: '/venues',
                abstract: true,

                resolve: {
                    venues: ['$http', 'venuesContext', function ($http, venuesContext) {
                            return $http.get(venuesContext);
                        }]
                },
                views: {
                    mainView: {templateUrl: basePath + 'venues.html',
                        controller: ['$scope', 'venues', function ($scope, venues) {
                                $scope.venuesRecords = venues.data;
                            }]
                    }
                }
            }).state('venuesList', {
                url: '/list',
                parent: 'venues',
                views:{
                    'listView': {
                        templateUrl: basePath + 'venues.list.html'
                    }
                }
            }).state('venueDetail', {
                url: '/{venueId:int}/detail',
                parent: 'venues',
                param: {
                    venueId: null
                },
                resolve: {
                    currentVenue:['$http', 'venuesContext', '$stateParams', function($http, 
                        venuesContext, $params){
                            return $http.get(venuesContext+'/'+$params.venueId);
                        }]
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'venues.list.html'
                    },
                    'detailView':{
                        templateUrl: basePath + 'venues.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentVenue = $scope.venuesRecords[$params.venueId-1001];
                    }]
                 }
               }
            });
        }
    ]);
})(window.angular);





