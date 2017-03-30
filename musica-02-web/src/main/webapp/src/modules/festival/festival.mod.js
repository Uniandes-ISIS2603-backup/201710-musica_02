/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    // Definición del módulo
    var mod = ng.module("festivalModule", ['ui.router']);
 
   // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/festival/';
            // Mostrar la lista de libros será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/festivalesList");
            // Definición del estado 'festivalesList' donde se listan los festivales
            $stateProvider.state('festivalesList', {
                // Url que aparecerá en el browser
                url: '/festivales/list',
                // Se define una variable festivales (del estado) que toma por valor 
                // la colección de festivales que obtiene utilizando $http.get 
                 resolve: {
                    festivales: ['$http', function ($http) {
                            return $http.get('data/festivales.json'); // $http retorna un apromesa que aquí no se está manejando si viene con error.
                        }]
                },
                // Template que se utilizara para ejecutar el estado
                templateUrl: basePath + 'festival.list.html',
                // El controlador guarda en el scope en la variable festivalesRecords los datos que trajo el resolve
                // festivalesRecords será visible en el template
                controller: ['$scope', 'festivales', function ($scope, festivales) {
                        $scope.festivalesRecords = festivales.data;
                    }]              
            });
        }
    ]);
})(window.angular);