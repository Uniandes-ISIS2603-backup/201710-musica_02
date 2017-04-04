(function (ng){
    var mod = ng.module("cancionModule", ['ui.router']);
    mod.constant("cancionesContext", "api/canciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cancion/';
            $urlRouterProvider.otherwise("/cancionesList");

            $stateProvider.state('canciones', {
                url: '/canciones',
                abstract: true,
                resolve: {
                    canciones: ['$http', function ($http) {
                            return $http.get('data/canciones.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'canciones.html',
                        controller: ['$scope', 'canciones', function ($scope, canciones) {
                                $scope.cancionesRecords = canciones.data;
                            }]
                    }
                }
            }).state('cancionesList', {
                url: '/list',
                parent: 'canciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'canciones.list.html'
                    }
                }
            });
        }]);
})(window.angular);