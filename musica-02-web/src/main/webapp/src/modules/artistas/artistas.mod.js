(function (ng){
    var mod = ng.module("artistaModule", ['ui.router']);
    mod.constant("artistasContext", "api/artistas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/artistas/';
            $urlRouterProvider.otherwise("/artistasList");

            $stateProvider.state('artistas', {
                url: '/artistas',
                abstract: true,
                resolve: {
                    artistas: ['$http', function ($http) {
                            return $http.get('data/artistas.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'artistas.html',
                        controller: ['$scope', 'artistas', function ($scope, artistas) {
                                $scope.artistasRecords = artistas.data;
                            }]
                    }
                }
            }).state('artistasList', {
                url: '/list',
                parent: 'artistas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'artistas.list.html'
                    }
                }
            }).state('artistaDetail', {
                url: '/{artistaId:int}/detail',
                parent: 'artistas',
                param: {
                    artistaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'artistas.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'artistas.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentArtista = $scope.artistasRecords[$params.artistaId-1];
                            }]
                    }

                }

            });
        }]);
})(window.angular);