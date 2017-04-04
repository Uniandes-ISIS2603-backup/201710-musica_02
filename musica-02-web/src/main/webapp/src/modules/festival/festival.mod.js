/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalModule", ['ui.router']);
    mod.constant("festivalesContext", "api/festivales");
    mod.constant("funcionesContext", "api/funciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/festival/';
            $urlRouterProvider.otherwise("/festivalesList");
            $stateProvider.state('festivales', {
                url: '/festivales',
                abstract: true,
                
                resolve: {
                    festivales: ['$http','festivalesContext' ,function ($http,festivalesContext) {
                            return $http.get(festivalesContext); 
                        }]
                },
                views: {
                    mainView: {

                        templateUrl: basePath + 'festival.html',
                        controller: ['$scope', 'festivales', function ($scope, festivales) {
                                $scope.festivalesRecords = festivales.data;
                            }]
                    }
                }
            }).state('festivalesList', {
                url: '/list',
                parent: 'festivales',
                views: {
                    listView: {
                        templateUrl: basePath + 'festival.list.html'
                    }
                }
            }).state('festivalDetail',{
                url:'/{festivalId:int}/detail',
                parent: 'festivales',
                param:{
                    festivalId: null
                },
                views:{
                    listView:{
                        
                      templateUrl: basePath + 'festival.list.html'  
                    },
                    detailView:{
                        resolve: {
                            funciones: ['$http','funcionesContext', function ($http,funcionesContext) {
                                    return $http.get(funcionesContext);
                                }]
                        },
                        templateUrl: basePath + 'festival.detail.html',
                        controller: ['$scope','funciones', '$stateParams', function ($scope, funciones,$params) {
                                $scope.funcionesRecords = funciones.data;
                                $scope.currentFestival = $scope.festivalesRecords[$params.festivalId-1001];
                            }]
                    }
                }
            });
        }
    ]);
})(window.angular);