var app = angular.module("SRD")
app.controller("HomeCtrl", function(){
	$scope.cerrarSesion = function () {
		$rootScope.usuario.usr_ci = "";
		$rootScope.usuario.usr_nombre = "";
		$rootScope.usuario.estadousr = 0;
		$rootScope.usuario.usr_clave = "";
		$rootScope.usuario.usr_correo = "";
		$rootScope.usuario.usr_telefono = "";
		$scope.$location.path('/').replace();
	}}
);