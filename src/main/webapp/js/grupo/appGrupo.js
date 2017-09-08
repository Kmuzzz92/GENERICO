var app = angular.module("gruposApp", []); 

app.config(function(){
	this.URLRegistro="/GENERICO/admin/grupo/registrar";
	this.URLEliminar="/GENERICO/admin/grupo/eliminar";
	this.URLGrupo="/GENERICO/admin/grupo";
	this.URLGrupos="/GENERICO/admin/grupos";
	this.URLProfesores="/GENERICO/admin/profesores";
	this.URLProfesoresAsig="/GENERICO/admin/asignaProfesor";
});