app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.grupo = grupo;
	
	this.Guardar=function(){
		
	}
	
	this.Cancelar=function(){
		location.href=URLGrupos;
	}	
});