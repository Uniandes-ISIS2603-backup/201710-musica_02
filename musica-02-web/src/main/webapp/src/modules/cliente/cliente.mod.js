/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("clienteModule", ['ui.router']);

    mod.constant("clientesContext", "api/clientes");
    mod.constant 

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("/clientesList");

            $stateProvider.state('clientes', {
                url: '/clientes',
                abstract: true,
                resolve: {
                    clientes: ['$http', 'clientesContext',function ($http,clientesContext) {
                            return $http.get(clientesContext);
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'cliente.html',
                        controller: ['$scope', 'clientes', function ($scope, clientes) {
                                $scope.clienteRecords = clientes.data;
                            }]
                    }
                }

            }).state('clientesList', {
                url: '/list',
                parent:'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'cliente.list.html'
//                        templateUrl: 'src/modules/funcion/funcion.list.html'
                    }
                }
            }).state('clienteEntradas', {
                url: '{usuario}/entradas',
                parent: 'clientes',
                param: {
                    usuario: null
                },
                views: {
                    'listView': {
                        resolve: {
                            entradas: ['$http','$stateParams', function($http,$params) {
                                    return $http.get('api/clientes/'+$params.usuario+'/entradas');
                                }]
                        },
                        templateUrl: basePath + 'clienteEntradas.html',
                        controller: ['$scope', 'entradas', '$stateParams', function($scope,entradas,$params) {
                                $scope.entradaRecords = entradas.data;
                        }]
                    }
                }
            }).state('test' , {
                url:'/entradas',
                parent:'clientes',
                views: {
                    'listView': {
                        templateUrl:basePath+'clienteEntradas.html'
                    }
                }
            });
        }
    ]);
})(window.angular);


