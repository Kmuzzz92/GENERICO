app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.grupos = grupos;
	
	ctrl.select = 0;
	
	this.selected=function(id){
		ctrl.select = id;
	}
	
	this.Agregar = function(){
		location.href=URLGrupo+"?grupo=0";
	}
	
	this.Editar = function(){
		location.href=URLGrupo+"?grupo="+ctrl.select;
	}
	
	this.Eliminar = function(){
		
	}
	
});