var app = angular.module("profesoresApp", []); 

app.config(function(){
	this.URLRegistrar="/GENERICO/registrar";
	this.URLRegistro="/GENERICO/admin/registro";
	this.URLActivar="/GENERICO/admin/activar";
	this.URLDesactivar="/GENERICO/admin/desactivar";
	this.URLRegistrarAlum="/GENERICO/registro";
});