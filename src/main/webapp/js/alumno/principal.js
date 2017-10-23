app.controller("principalCtrl", function($scope, $http, $httpParamSerializerJQLike) {
	
	var ctrl = this;

	ctrl.alumno={};
	
	this.inicia=function(){
		if(!jQuery.isEmptyObject(alumno)){
			ctrl.alumno=alumno;
		}
	}
	
	this.irExamen=function(){
		location.href=URLExamen;
	}
	
	this.inicia();
});