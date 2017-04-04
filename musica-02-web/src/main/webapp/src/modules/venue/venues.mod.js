(function (ng) {
    var mod = ng.module("venuesModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/venue/';

            $urlRouterProvider.otherwise("/venuesList");

            $stateProvider.state('venues', {
                url: '/venues',
                abstract: true,

                resolve: {
                    venues: ['$http', function ($http) {
                            return $http.get('data/venues.json');
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
                views: {
                    'listView': {
                        templateUrl: basePath + 'venues.list.html'
                    },
                    'detailView':{
                        templateUrl: basePath + 'venues.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentVenue = $scope.venuesRecords[$params.venueId-1];
                    }]
                 }
               }
            });
        }
    ]);
})(window.angular);





