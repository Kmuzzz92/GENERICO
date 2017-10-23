app.controller("examenesCtrl", function($scope, $http, $httpParamSerializerJQLike,$timeout) {
		
	var ctrl = this;
	
	ctrl.examenes = [];
	
	this.inicia=function(){
		if(!jQuery.isEmptyObject(examenes)){
			ctrl.examenes = examenes;
		}
	}
	
	this.inicia();
	
});