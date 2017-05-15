(function (ng) {
    var mod = ng.module("venuesModule", ['ui.router']);
    mod.constant("venuesContext", "api/venues");
    mod.constant("funcionesContext", "api/funciones");
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
                        resolve: {
                        funciones: ['$http','funcionesContext', function ($http,funcionesContext) {
                                    return $http.get(funcionesContext);
                                }]},
                        templateUrl: basePath + 'venues.detail.html',
                        controller: ['$scope','funciones','$stateParams', function ($scope, funciones, $params) {
                                
                                $scope.currentVenue = $scope.venuesRecords[$params.venueId-1001];
                                $scope.funcionesRecords = funciones.data;
                    }]
                 }
               }
            }).state('venueInsert', {
                url: '/agregar',
                parent: 'venues',
                views: {
                    insertarView: {
                        templateUrl: basePath + 'venue.insertar.html',
                        resolve: {
                            agregarVenue: ["$http", function ($http) {
                                    var a=       
                                    function (venue) {
                                                $http.post("api/venues/", venue);
                                                }
                                 return a;           
                                }]
                        },
                        controller: ['$scope', 'agregarVenue','$state', function ($scope, agregarVenue,$state) {
                                $scope.venue = {};
                                $scope.postVenue = function()
                                {
                                    agregarVenue($scope.venue);
                                    $state.reload();
                                }
                            }]
                    }
                }

            });
        }
    ]);
})(window.angular);





