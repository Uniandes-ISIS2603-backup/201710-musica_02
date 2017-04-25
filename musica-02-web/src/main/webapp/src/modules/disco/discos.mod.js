(function (ng){
    var mod = ng.module("discoModule", ['ui.router']);
    mod.constant("discosContext", "/api/artistas/idArtista/discos");
    
    mod.config(['$stateProvider', '$urlRouterProvider', 
        
        function ($stateProvider, $urlRouterProvider) 
        {
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
                url: '/{artistaId:int}/{discoId:int}/detail',
                parent: 'discos',
                param: {
                    discoId: null,
                    artistaId: null
                },
                views: {
                    'childrenView': {
                        resolve: {
                            canciones: ['$http', '$stateParams', function ($http, $params) {
                                    return $http.get('api/artistas/' + $params.artistaId + '/discos/' + $params.discoId+'/canciones');
                                }]
                        },
                        templateUrl: 'src/modules/cancion/cancion.list.html',
                        controller: ['$scope', 'canciones', '$stateParams', function ($scope, canciones, $params) {
                                $scope.cancionesRecords = canciones.data;
                            }]
                    },
                    detailView: {
                        
                        resolve: {
                            currentDisco: ['$http', '$stateParams', function ($http, $params) {
                                    return $http.get('api/artistas/' + $params.artistaId + '/discos/' + $params.discoId);
                                }]
                        },
                        templateUrl: basePath + 'discos.detail.html',
                        controller: ['$scope', '$stateParams','currentDisco', function ($scope, $params,currentDisco) {
                                $scope.currentDisco = currentDisco.data;
                            }]
                    }

                }

            });
        }]);
})(window.angular);