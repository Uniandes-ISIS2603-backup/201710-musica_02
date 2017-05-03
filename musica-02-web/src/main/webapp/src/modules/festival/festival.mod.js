/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalModule", ['ui.router']);
    mod.constant("festivalesContext", "api/festivales");
    mod.constant("funcionesContext", "api/funciones");
    mod.constant("artistasContext", "api/artistas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/festival/';
            $urlRouterProvider.otherwise("/festivalesList");
            $stateProvider.state('festivales', {
                url: '/festivales',
                abstract: true,
                resolve: {
                    festivales: ['$http', 'festivalesContext', function ($http, festivalesContext) {
                            return $http.get(festivalesContext);
                        }],
                    ciudades: ['$http', function ($http) {
                            return $http.get('api/ciudades');
                        }],
                    generos: ['$http', function ($http) {
                            return $http.get('api/generos');
                        }]
                },
                views: {
                    mainView: {

                        templateUrl: basePath + 'festival.html',
                        controller: ['$scope', 'festivales', 'generos', 'ciudades', function ($scope, festivales, generos, ciudades) {
                                $scope.festivalesRecords = festivales.data;
                                $scope.generosRecords = generos.data;
                                $scope.ciudadesRecords = ciudades.data;
                            }]
                    }
                }
            }).state('festivalesList', {
                url: '/list',
                parent: 'festivales',
                views: {
                    listView: {
                        templateUrl: basePath + 'festival.list.html',

                    }
                }
            }).state('festivalGenList', {
                url: 'festivalesPorGenero/{genero:int}/',
                parent: 'festivales',
                param: {
                    genero: null
                },
                views: {
                    listView: {
                        templateUrl: basePath + 'festival.list.html',
                        resolve: {
                            currentFestivales: ['$http', 'festivalesContext', '$stateParams', function ($http, festivalesContext, $params) {
                                    return $http.get(festivalesContext + '/genero/' + $params.genero);
                                }]
                        },
                        controller: ['$scope', 'currentFestivales', function ($scope, currentFestivales) {
                                $scope.festivalesRecords = currentFestivales.data;
                            }]
                    }

                }
            }).state('festivalDetail', {
                url: '/{festivalId:int}/detail',
                parent: 'festivales',
                param: {
                    festivalId: null
                },
                views: {
                    childrenView: {
                        resolve: {
                            currentArtistas: ['$http', 'artistasContext', '$stateParams', function ($http, artistasContext, $params) {
                                    return $http.get(artistasContext + '/festival/' + $params.festivalId);
                                }]
                        },
                        templateUrl: 'src/modules/artistas/artistas.list.html',
                        controller: ['$scope', 'currentArtistas', function ($scope, currentArtistas) {
                                $scope.artistasRecords = currentArtistas.data;
                            }]
                    },
                    detailView: {
                        resolve: {
                            funciones: ['$http', 'funcionesContext', function ($http, funcionesContext) {
                                    return $http.get(funcionesContext);
                                }],
                            currentFestival: ['$http', 'festivalesContext', '$stateParams', function ($http, festivalesContext, $params) {
                                    return $http.get(festivalesContext + '/' + $params.festivalId);
                                }]
                        },
                        templateUrl: basePath + 'festival.detail.html',
                        controller: ['$scope', 'funciones', 'currentFestival', function ($scope, funciones, currentFestival) {
                                $scope.funcionesRecords = funciones.data;
                                $scope.currentFestival = currentFestival.data;
                            }]
                    }
                }
            }).state('festivalInsert', {
                url: '/agregar',
                parent: 'festivales',
                views: {
                    insertarView: {
                        templateUrl: basePath + 'festival.insertar.html',
                        resolve: {
                            agregarFestival: ["$http", function ($http) {
                                    var a=       
                                    function (festival) {
                                                $http.post("api/festivales/", festival);
                                                }
                                 return a;           
                                }]
                        },
                        controller: ['$scope', 'agregarFestival','$state', function ($scope, agregarFestival,$state) {
                                $scope.festival = {};
                                $scope.postFestival = function()
                                {
                                    agregarFestival($scope.festival);
                                    $state.reload();
                                }
                            }]
                    }
                }

            });
        }
    ]);
})(window.angular);
