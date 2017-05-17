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
                        }],
                    ciudades: ['$http', function ($http) {
                            return $http.get('api/ciudades');
                        }],
                    festivales: ['$http', function ($http) {
                            return $http.get('api/festivales');
                        }]
                },
                views: {
                    mainView: {templateUrl: basePath + 'venues.html',
                        controller: ['$scope', 'venues', 'ciudades', 'festivales', function ($scope, venues, ciudades, festivales) {
                                $scope.venuesRecords = venues.data;
                                $scope.ciudadesRecords = ciudades.data;
                                $scope.festivalesRecords = festivales.data;
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
                        controller: ['$scope','funciones','$stateParams', function ($scope, funciones, $params, $http, $state) {
                                
                                $scope.currentVenue = $scope.venuesRecords[$params.venueId-1001];
                                $scope.funcionesRecords = funciones.data;
                                $scope.deleteVenue = function ()
                                {
                                    $http.delete("api/venues/" + currentVenue.data.id);
                                    $state.go('venuesList');
                                };
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

            }).state('venueUpdate', {
                
                url: '/{venueId:int}/actualizar',
                param: {
                    venueId: null
                },
                parent: 'venues',
                views: {
                    updateView: {
                        templateUrl: basePath + 'venue.update.html',
                        resolve: {

                            currentVenue: ['$http', 'venuesContext', '$stateParams', function ($http, venuesContext, $params) {
                                    return $http.get(venuesContext + '/' + $params.venueId);
                                }]
                        },
                        controller: ['$scope', '$http', 'currentVenue', '$state', function ($scope, $http, currentVenue, $state) {
                                $scope.venue = {};
                                $scope.venue.id = currentVenue.data.id;
                                $scope.putVenue = function ()
                                {
                                    $http.put("api/venues/", $scope.venue);
                                    $state.reload();
                                    $state.go('venuesList');
                                };
                                $scope.currentVenue = currentVenue.data;

                            }]
                    }
                }

            });
        }
    ]);
})(window.angular);





