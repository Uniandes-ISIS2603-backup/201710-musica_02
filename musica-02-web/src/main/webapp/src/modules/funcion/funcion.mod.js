/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionModule", ['ui.router']);
    mod.constant("authorsContext", "api/funcion");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/funcion/';
            var basePathArtistas = 'src/modules/artistas/';
            $urlRouterProvider.otherwise("/funcionList");


            $stateProvider.state('funciones', {
                url: '/funciones',
                abstract: true,
                resolve: {
                    funciones: ['$http', function ($http) {
                            return $http.get('data/funciones.json');
                        }]
                },
                views: {
                    mainView: {
                        templateUrl: basePath + 'funcion.html',
                        controller: ['$scope', 'funciones', function ($scope, funciones) {
                                $scope.funcionesRecords = funciones.data;
                            }]
                    }
                }


            }).state('funcionList', {
                url: '/list',
                parent: 'funciones',
                views: {
                    listView: {
                        templateUrl: basePath + 'funcion.list.html'
                    }
                }
            }).state('funcionDetail', {
                url: '/{funcionId:int}/detail',
                parent: 'funciones',
                param: {
                    funcionId: null
                },
                views: {
                    listView: {
                        resolve: {
                            artistas: ['$http', function ($http) {
                                    return $http.get('data/artistas.json');
                                }]
                        },
                        templateUrl: basePathArtistas + 'artistas.list.html',
                        controller: ['$scope', 'artistas', '$stateParams', function ($scope, artistas, $params) {
                                $scope.artistasRecords = artistas.data;
                                $scope.currentFuncion = $scope.funcionesRecords[$params.funcionId - 1];
                            }]
                    },
                    detailView: {
                        templateUrl: basePath + 'funcion.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentFuncion = $scope.funcionesRecords[$params.funcionId - 1];
                            }]
                    }
                }
            });
        }
    ]);
})(window.angular);

