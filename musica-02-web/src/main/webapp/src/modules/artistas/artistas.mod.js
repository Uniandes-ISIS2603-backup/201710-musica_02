(function (ng) {
    var mod = ng.module("artistaModule", ['ui.router']);
    mod.constant("artistasContext", "api/artistas");
    mod.constant("dicosContext", "discos");
    mod.constant("generosContext", "api/generos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/artistas/';
            $urlRouterProvider.otherwise("/artistasList");

            $stateProvider.state('artistas', {
                url: '/artistas',
                abstract: true,
                resolve:
                {
                    artistas: ['$http', 'artistasContext', function ($http, artistasContext) {
                            return $http.get(artistasContext);
                        }],
                }
                ,
                views: 
                {
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
                    'childrenView': {
                        resolve: {
                            discos: ['$http', 'artistasContext', '$stateParams', function ($http, artistasContext, $params) 
                                    {
                                    return $http.get(artistasContext + '/' + $params.artistaId + '/discos');
                                    }
                                    ]
                                },
                        templateUrl: 'src/modules/disco/discos.list.html',
                        controller: ['$scope', 'discos', function ($scope, discos) {
                                $scope.discosRecords = discos.data;
                            }]
                    },
                    'detailView': {
                        resolve: {
                            currentArtista: ['$http', 'artistasContext', '$stateParams', function ($http, artistasContext, $params) {
                                    return $http.get(artistasContext + '/' + $params.artistaId);
                                }]
                        },
                        templateUrl: basePath + 'artistas.detail.html',
                        controller: ['$scope','currentArtista' , function ($scope, currentArtista) {
                                $scope.currentArtista = currentArtista.data;
                            }]
                    }

                }

            });
            
            $stateProvider.state('artistaCreate', {
                url: '/create',
                parent: 'artistas',
                views: {
                    'createView': {
                        resolve:
                        {                          
                            generos: ['$http', 'generosContext', function ($http, generosContext) 
                            {
                                    return $http.get(generosContext);
                            }]
                        },
                        
                        templateUrl: basePath + 'artistas.create.html',
                        controller: ['$scope', '$http', '$state', 'generos', function ($scope, $http, $state, generos) {
                                
                                $scope.generosRecords = generos.data;
                                
                                $scope.artista = {};
                                $scope.postArtista = function ()
                                {
                                    $http.post("api/artistas/", $scope.artista);
                                    $state.reload();
                                };
                            }]
                    }
                }
            });
            
        }]);
})(window.angular);