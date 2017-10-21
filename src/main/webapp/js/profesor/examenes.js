app.controller("examenesCtrl", function($scope,$http,$httpParamSerializerJQLike){
	
	var ctrl = this;
	
	ctrl.examenes=[];
	
	ctrl.select=0;
	
	this.selected=function(examen){
		ctrl.select=examen;
	}
	
	this.inicia=function(){
		ctrl.examenes=examenes;
	}
	
	this.Agregar=function(){
		location.href=URLExamen+"?examen=0";
	}
	
	this.Editar=function(){
		if(ctrl.select>0){
			location.href=URLExamen+"?examen="+ctrl.select;
		}else{
			alert("Seleccione un examen, por favor!");
		}
	}
	
	ctrl.inicia();
});