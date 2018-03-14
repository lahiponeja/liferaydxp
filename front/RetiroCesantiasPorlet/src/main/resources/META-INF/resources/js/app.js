(function(){
	
debugger;
console.log("Llego");

var app= angular.module('retiroApp',['ngRoute']);

app.config(['$routeProvider',
  function ($routeProvider) {
        $routeProvider.
        when('/', {
            title: 'Iniciar',
            controller: 'mainController',
               //templateUrl: 'app/views/loginuser.html'
        })
        .otherwise({
                redirectTo: '/login'
            });
  }]);

}());