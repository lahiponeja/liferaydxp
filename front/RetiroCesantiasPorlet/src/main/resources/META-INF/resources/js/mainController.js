var serverUrl='';
 
app.controller('mainController',function ($scope, $http) {
	console.log("Llego al controller");
    $scope.nombre="";
    $scope.telefono="";
 
    (function init() {
        /* Inicializamos */
        })();
 
    $scope.submitForm = function($event) {
        $event.preventDefault();
 
        $http.post( serverUrl, {
            nombre: $scope.nombre,
            telefono: $scope.telefono,
            }).success(function(data) {
                 
                    if ( data.success )
                        $("#errors").append("<div class='alert-info'>"+data.success+"</div>" );
                     
                    if ( data.err ) {
                        $("#errors").append("<div class='alert-error'>"+data.err+"</div>" );
                        }
                     
                    }).error(function(data) {
                            console.log('Error: ' + data);
                    });
 
        }
 
    
    });/**
 * 
 */