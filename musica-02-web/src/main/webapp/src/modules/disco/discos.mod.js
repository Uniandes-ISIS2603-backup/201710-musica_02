(function (ng){
    var mod = ng.module("discoModule", ['ui.router']);
    mod.constant("discosContext", "api/discos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
           
            
            var basePath = 'src/modules/disco/';
            $urlRouterProvider.otherwise("/discosList");

            $stateProvider.state('discos', {
                url: '/discos',
                abstract: true,
                resolve: {
                    discos: ['$http', function ($http) {
                            return $http.get('data/discos.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'discos.html',
                        controller: ['$scope', 'discos', function ($scope, discos) {
                                $scope.discosRecords = discos.data;
                            }]
                    }
                }
            }).state('discosList', {
                url: '/list',
                parent: 'discos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'discos.list.html'
                    }
                }
            }).state('discoDetail', {
                url: '/{discoId:int}/detail',
                parent: 'discos',
                param: {
                    discoId: null
                },
                views: {
                    'listView': {
                        resolve: {
                            canciones: ['$http', function ($http) {
                                    return $http.get('data/canciones.json');
                                }]
                        },
                        templateUrl: 'src/modules/cancion/cancion.list.html',
                        controller: ['$scope', 'canciones', '$stateParams', function ($scope, canciones, $params) {
                                $scope.currentDisco = $scope.discosRecords[$params.discoId - 1];
                                $scope.cancionesRecords = canciones.data;
                            }]
                    },
                    detailView: {
                        templateUrl: basePath + 'discos.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentDisco = $scope.discosRecords[$params.discoId-1];
                            }]
                    }

                }

            });
        }]);
})(window.angular);