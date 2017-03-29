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
            $stateProvider.state('funcionList', {
                url: '/funciones/list',

                resolve: {
                    funciones: ['$http', function ($http) {
                            return $http.get('data/funciones.json');
                        }]
                },

                templateUrl: basePath + 'funcion.list.html',
                controller: ['$scope', 'funciones', function ($scope, funciones) {
                        $scope.funcionesRecords = funciones.data;
                    }]
            });
        }
    ]);
})(window.angular);

