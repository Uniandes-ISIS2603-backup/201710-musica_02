/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    // Definición del módulo
    var mod = ng.module("cancionModule", ['ui.router']);
 
   // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/cancion/';
            // Mostrar la lista de libros será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/cancionesList");
            
            $stateProvider.state('cancionesList', {
                // Url que aparecerá en el browser
                url: '/canciones/list',
                // Se define una variable books (del estado) que toma por valor 
                // la colección de libros que obtiene utilizando $http.get 
                 resolve: {
                    books: ['$http', function ($http) {
                            return $http.get('data/canciones.json'); // $http retorna un apromesa que aquí no se está manejando si viene con error.
                        }]
                },
                // Template que se utilizara para ejecutar el estado
                templateUrl: basePath + 'cancion.list.html',
                // cancionesRecords será visible en el template
                controller: ['$scope', 'canciones', function ($scope, canciones) {
                        $scope.cancionesRecords = canciones.data;
                    }]              
            });
        }
    ]);
})(window.angular);
