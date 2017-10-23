app.controller("examenCtrl", function($scope, $http, $httpParamSerializerJQLike,$timeout) {

	var ctrl = this;
	
	ctrl.preguntas=[];
	
	this.inicia=function(){
		if(!jQuery.isEmptyObject(preguntas)){
			ctrl.preguntas=preguntas;
			for(var pre in ctrl.preguntas){
				ctrl.preguntas[pre].respuesta=1;
			}
		}
		$timeout(function(){ctrl.enviar();},1200000);
	}
	
	this.enviar=function(){
		$http({
			method : 'POST',
			url : URLSave,
			headers : {
				'Content-type' : 'application/x-www-form-urlencoded'
			},
			data : $httpParamSerializerJQLike({
				registro : angular.toJson(ctrl.preguntas)
			})
		}).then(function(response) {
			if (response.data === "ok") {
				alert("Examen Enviado");
				location.href = "/GENERICO/alumno/";
			} else {
				alert("No se pudo enviar el examen");
			}
		}).catch(function(data){
			alert("El examen no se pudo Enviar, actualice la página por favor");
		});
	}
	
	this.inicia();
});