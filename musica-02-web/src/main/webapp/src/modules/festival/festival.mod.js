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
                }
                ,
                views: {
                    childrenView: {

                        templateUrl: 'src/modules/artistas/artistas.list.html',
                        resolve: {
                            currentArtistas: ['$http', 'artistasContext', '$stateParams', function ($http, artistasContext, $params) {
                                    return $http.get(artistasContext + '/festival/' + $params.festivalId);
                                }]

                        },
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
                                }],
                            nombresArtistas: ['$http', 'artistasContext', '$stateParams', function ($http, artistasContext, $params) {
                                    return $http.get(artistasContext + '/festival/String/' + $params.festivalId);
                                }],
                            anteriorFestival: ['$http', 'festivalesContext', '$stateParams', function ($http, festivalesContext, $params) {
                                    return $http.get(festivalesContext + '/darAnterior/' + $params.festivalId);
                                }],
                            siguienteFestival: ['$http', 'festivalesContext', '$stateParams', function ($http, festivalesContext, $params) {
                                    return $http.get(festivalesContext + '/darSiguiente/' + $params.festivalId);
                                }]

                        },
                        templateUrl: basePath + 'festival.detail.html',
                        controller: ['$scope', 'funciones', 'currentFestival', 'nombresArtistas', '$http', '$state', 'anteriorFestival', 'siguienteFestival', function ($scope, funciones, currentFestival, nombresArtistas, $http, $state, anteriorFestival, siguienteFestival) {
                                $scope.funcionesRecords = funciones.data;
                                $scope.nombresArtistas = nombresArtistas.data;

                                $scope.currentFestival = currentFestival.data;
                                $scope.deleteFestival = function ()
                                {
                                    $http.delete("api/festivales/" + currentFestival.data.id).then(function () {
                                        $state.go('festivalesList', {}, {reload: true});
                                    });

                                };
                                $scope.irAnteriorFestival = function ()
                                {
                                    $state.go('festivalDetail', {festivalId: anteriorFestival.data.id}, {reload: true});

                                };
                                $scope.irSiguienteFestival = function ()
                                {
                                    $state.go('festivalDetail', {festivalId: siguienteFestival.data.id}, {reload: true});

                                };
                            }]
                    }
                }
            }).state('festivalInsert', {
                url: '/agregar',
                parent: 'festivales',
                views: {
                    insertarView: {
                        templateUrl: basePath + 'festival.insertar.html',
                        controller: ['$scope', '$http', '$state', function ($scope, $http, $state) {
                                $scope.festival = {};
                                $scope.postFestival = function ()
                                {
                                    $http.post("api/festivales/", $scope.festival).then(function () {
                                        $state.go('festivalesList', {}, {reload: true});
                                    });
                                };
                            }]
                    }
                }

            }).state('festivalUpdate', {

                url: '/{festivalId:int}/actualizar',
                param: {
                    festivalId: null
                },
                parent: 'festivales',
                views: {
                    updateView: {
                        templateUrl: basePath + 'festival.update.html',
                        resolve: {

                            currentFestival: ['$http', 'festivalesContext', '$stateParams', function ($http, festivalesContext, $params) {
                                    return $http.get(festivalesContext + '/' + $params.festivalId);
                                }]
                        },
                        controller: ['$scope', '$http', 'currentFestival', '$state', function ($scope, $http, currentFestival, $state) {
                                $scope.festival = {};
                                $scope.festival.id = currentFestival.data.id;
                                $scope.putFestival = function ()
                                {
                                    $http.put("api/festivales/", $scope.festival).then(function () {
                                        $state.go('festivalesList', {}, {reload: true});


                                    });

                                };
                                $scope.currentFestival = currentFestival.data;

                            }]
                    }
                }

            });
        }
    ]);
})(window.angular);
