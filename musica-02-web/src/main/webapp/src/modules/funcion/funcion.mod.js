/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionModule", ['ui.router']);
    mod.constant("funcionContext", "api/funciones");
    mod.constant("artistasContext", "api/artistas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/funcion/';
            var basePathArtistas = 'src/modules/artistas/';
            $urlRouterProvider.otherwise("/funcionList");


            $stateProvider.state('funciones', {
                url: '/funciones',
                abstract: true,
                resolve: {
                    funciones: ['$http', 'funcionesContext', function ($http, funcionesContext) {
                            return $http.get(funcionesContext);
                        }],
                    venues: ['$http', function ($http) {
                            return $http.get('api/venues');
                        }],
                    festivales: ['$http', function ($http) {
                            return $http.get('api/festivales');
                        }]

                },
                views: {
                    mainView: {
                        templateUrl: basePath + 'funcion.html',
                        controller: ['$scope', 'funciones', 'festivales', 'venues', function ($scope, funciones, festivales, venues) {
                                $scope.funcionesRecords = funciones.data;
                                $scope.festivalesRecords = festivales.data;
                                $scope.venuesRecords = venues.data;
                            }]
                    }
                }


            }).state('funcionList', {
                url: '/list',
                parent: 'funciones',
                views: {
                    listView: {
                        templateUrl: basePath + 'funcion.list.html',

                    }
                }
            }).state('funcionInsert', {
                url: '/agregar',
                parent: 'funciones',
                views: {
                    insertarView: {
                        templateUrl: basePath + 'funcion.insert.html',
                        resolve: {
                            agregarFuncion: ["$http", function ($http) {
                                    var a =
                                            function (funcion) {
                                                $http.post("api/funciones", funcion)

                                                console.log(funcion);
                                            }
                                    return a;
                                }]
                        },
                        controller: ['$scope', 'agregarFuncion', '$state', function ($scope, agregarFuncion, $state) {
                                $scope.funcion = {};
                                $scope.postFuncion = function () {
                                    agregarFuncion($scope.funcion);
                                    console.log($scope.funcion);
                                    $state.reload();
                                }
                            }]
                    }
                }
            }).state('funcionDetail', {
                url: '/{funcionId:int}/detail',
                parent: 'funciones',
                param: {
                    funcionId: null
                },

                views: {

                    detailView: {

                        resolve: {
                            currentFuncion: ['$http', 'funcionesContext', '$stateParams', function ($http, funcionesContext, $params) {
                                    return $http.get(funcionesContext + '/' + $params.funcionId);
                                }]
                        },
                        templateUrl: basePath + 'funcion.detail.html',
                        controller: ['$scope', 'currentFuncion', '$stateParams', 'funcionContext', '$http', function ($scope, currentFuncion, $http, $params) {

                                $scope.currentFuncion = currentFuncion.data;
                                $scope.artistasRecords = currentFuncion.data.artistasDTOs;
                                $scope.deleteFunciones = function () {
                                    $http.delete("api/funciones/" + currentFuncion.data.id);
                                    $params.go('funcionList');
                                };
                            }]
                    },
                    listView: {
                        templateUrl: basePathArtistas + 'artistas.list.html'

                    }
                }
            }).state('funcionUpdate',{
                url:'/{funcionId:int}/actualizar',
                param:{
                    funcionId:null
                },
                parent:'funciones',
                views:{
                    updateView:{
                        templateUrl: basePath +'funcion.update.html',
                        resolve:{
                            currentFuncion:['$http','funcionContext','$stateParams',function($http,funcionContext,$params){
                                    return $http.get(funcionContext + '/'+ $params.funcionId);
                            }]
                        },
                        controller:['scope','$http','currentFuncion','$state',function($scope,$http,currentFuncion,$state){
                                $scope.funcion={};
                                $scope.funcion.id = currentFuncion.data.id;
                                $scope.putFuncion =function(){
                                    $http.put("api/funciones/", $scope.funcion);
                                    $state.reload();
                                    $state.go('funcionList');
                                };
                                $scope.currentFuncion = currentFuncion.data;
                        }]
                    }
                }
                        
            });
        }
    ]);
})(window.angular);
