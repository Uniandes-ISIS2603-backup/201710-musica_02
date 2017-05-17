/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("reviewModule",['ui.router']);
    mod.constant("funcionesContext","api/funciones");
    mod.constant("reviewsContext","reviews");
    
    mod.config(['$stateProvider','$urlRouterProvider',function($stateProvider, $urlRouterProvider){
         var basePath = 'src/modules/review/';
         $urlRouterProvider.otherwise("/reviewsList");
         
         $stateProvider.state('reviews',{
             url: '/reviews',
             abstract: true,
             parent:'funcionDetail',
             resolve:{
                 reviews: ['$http','funcionesContext','reviewsContext','$stateParams',function($http,funcionesContext,reviewsContext,$params){
                         return $http.get(funcionesContext +  '/' + $params.funcionId + '/'+ reviewsContext);
                 }]
             },
             views:{
                 childrenView:{
                     templateUrl: basePath+'review.html'
                 }
             },
         }).state('reviewsList',{
             url:'/list',
             parent:'reviews',
             views:{
                 listView:{
                     templateUrl: basePath + 'review.list.html',
                     controller:['$scope','reviews',function($scope,reviews){
                             $scope.reviewsRecords = reviews.data;
                     }]
                 }
             }
         }).state('reviewInsert',{
            url:'/agregar',
            parent:'reviews',
            views:{
                insertView:{
                    templateUrl: basePath + 'review.list.html',
                    resolve:{
                        agregarReview:['$http','funcionesContext','reviewsContext','$stateParams', function($http,$params,funcionesContext,reviewsContext){
                                var a = 
                                        function(review){
                                            $http.post(funcionesContext +'/'+ $params.funcionId+'/'+reviewsContext,review);
                                            console.log(review);
                                }
                                return a;
                        }]
                    },
                    controller:['$scope','agregarReview','$state',function($scope,agregarReview,$state){
                           $scope.review ={};
                           $scope.postReview= function(){
                               agregarReview($scope.review);
                               console.log($scope.review);
                               $state.reload();
                           }
                    }]
                }
            }
         });
    }]);
})(window.angular);