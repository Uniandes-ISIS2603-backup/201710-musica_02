/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("reviewModule", ['ui.router']);
    mod.constant("reviewsContext", "api/reviews");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/review/';
            $urlRouterProvider.otherwise("/reviewsList");

            $stateProvider.state('reviews', {
                url: '/reviews',
                abstract: true,
                parent: 'funcionDetail',
                views: {
                    childrenView: {
                        resolve: {
                            funciones: ['$http', function ($http) {
                                    return $http.get('data/funciones.json');
                                }],
                            reviews: ['$http', function ($http) {
                                    return $http.get('data/reviews.json');
                                }]
                        },
                        templateUrl: basePath + 'review.html',
                        controller: ['$scope', 'funciones', 'reviews', '$stateParams', function ($scope, funciones, reviews, $params) {
                                $scope.currentFuncion = funciones.data[$params.funcionId - 1];
                                $scope.reviewsRecords = reviews.data;
                            }]
                    }
                }
            }).state('reviewsList', {
                url: '/list',
                parent: 'reviews',
                views: {
                    'listView': {
                        templateUrl: basePath + 'review.list.html'
                    }
                }
            });
        }]);
})(window.angular);


