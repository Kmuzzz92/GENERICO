var app = angular.module("profesorApp", []); 

app.config(function(){
	this.URLExamen="/GENERICO/profesor/examenes/examen";
	this.URLGuardar="/GENERICO/profesor/preguntas/save";
	this.URLCancelar="/GENERICO/profesor/preguntas";
});