/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/funcion/';
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


            }).state('funcionList',{
                url : '/list',
                parent:'funcion',
                views:{
                    listView:{
                       templateUrl: basePath + 'funcion.list.html' 
                    }
                }
            }).state('funcionDetail',{
                url:'/{funcionId:int}/detail',
                parent: 'funciones',
                param:{
                    funcionId: null
                },
                views:{
                    listView:{
                      templateUrl: basePath + 'funcion.list.html'  
                    },
                    detailView:{
                        templateUrl: basePath + 'funcion.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentFuncion = $scope.funcionRecords[$params.funcionId-1];
                            }]
                    }
                }
            });
        }
    ]);
})(window.angular);

