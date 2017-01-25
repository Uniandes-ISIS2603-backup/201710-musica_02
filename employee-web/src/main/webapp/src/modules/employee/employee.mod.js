/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
(function (ng) {
    var mod = ng.module('employeeModule', ['ngCrud', 'ui.router']);

    mod.constant('employeeModel', {
        name: 'employee',
        displayName: 'Employee',
        url: 'employees',
        fields: {
            name: {
                displayName: 'Name',
                type: 'String',
                required: true
            },
            salary: {
                displayName: 'Salary',
                type: 'Double',
                required: true
            },
            image: {
                displayName: 'Image',
                type: 'String',
                required: true
            },
            gender: {
                displayName: 'Gender',
                type: 'Integer',
                required: true
            }        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/employee/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('employee', {
                url: '/employees?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'employee.tpl.html',
                        controller: 'employeeCtrl'
                    }
                },
                resolve: {
                    model: 'employeeModel',
                    employees: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('employeeList', {
                url: '/list',
                parent: 'employee',
                views: {
                    employeeView: {
                        templateUrl: basePath + 'list/employee.list.tpl.html',
                        controller: 'employeeListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('employeeNew', {
                url: '/new',
                parent: 'employee',
                views: {
                    employeeView: {
                        templateUrl: basePath + 'new/employee.new.tpl.html',
                        controller: 'employeeNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('employeeInstance', {
                url: '/{employeeId:int}',
                abstract: true,
                parent: 'employee',
                views: {
                    employeeView: {
                        template: '<div ui-view="employeeInstanceView"></div>'
                    }
                },
                resolve: {
                    employee: ['employees', '$stateParams', function (employees, $params) {
                            return employees.get($params.employeeId);
                        }]
                }
            });
            $sp.state('employeeDetail', {
                url: '/details',
                parent: 'employeeInstance',
                views: {
                    employeeInstanceView: {
                        templateUrl: baseInstancePath + 'detail/employee.detail.tpl.html',
                        controller: 'employeeDetailCtrl'
                    }
                }
            });
            $sp.state('employeeEdit', {
                url: '/edit',
                sticky: true,
                parent: 'employeeInstance',
                views: {
                    employeeInstanceView: {
                        templateUrl: baseInstancePath + 'edit/employee.edit.tpl.html',
                        controller: 'employeeEditCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('employeeDelete', {
                url: '/delete',
                parent: 'employeeInstance',
                views: {
                    employeeInstanceView: {
                        templateUrl: baseInstancePath + 'delete/employee.delete.tpl.html',
                        controller: 'employeeDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
	}]);
})(window.angular);
