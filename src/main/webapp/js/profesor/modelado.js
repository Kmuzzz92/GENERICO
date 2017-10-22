app.controller("modeladoCtrl", function($scope,$http,$httpParamSerializerJQLike){
	
	var ctrl = this;
	
	ctrl.preguntas=[];
	
	ctrl.temas = [];
	
	ctrl.nivel = [1,2,3,4];
	
	this.addPregunta=function(){
		if(ctrl.preguntas.length>0){
			var tmp = ctrl.preguntas.pop();
			ctrl.preguntas.push(tmp);
			if(tmp.texto!=="" && tmp.respuestas.length>0 && tmp.nivel>0 && tmp.tema>0){
				ctrl.preguntas.push(new Pregunta());
			}else{
				alert("Por favor, complete la anterior pregunta");
			}
		}else{
			ctrl.preguntas.push(new Pregunta());
		}
	}
	
	this.addRespuesta=function(pregunta){
		if(pregunta.respuestas.length>0){
			var tmp = pregunta.respuestas.pop();
			pregunta.respuestas.push(tmp);
			if(tmp.texto!==""){
				pregunta.respuestas.push(new Respuesta());
			}else{
				alert("Por favor, complete la respuesta anterior");
			}
		}else
			pregunta.respuestas.push(new Respuesta());
	}
	
	this.checkPreguntas=function(){
		var ret = "ok";
		for(var pregunta in ctrl.preguntas){
			if(ctrl.preguntas[pregunta].texto!=="" && ctrl.preguntas[pregunta].tema>0 && ctrl.preguntas[pregunta].nivel>0 && ctrl.preguntas[pregunta].respuestas.length>0){
				for(var respuesta in ctrl.preguntas[pregunta].respuestas){
					if(ctrl.preguntas[pregunta].respuestas[respuesta].texto===""){
						ret="Complete la pregunta: "+(pregunta+1);
						break;
					}
				}
			}else{
				ret="Complete la pregunta: "+(pregunta+1);
				break;
			}
		}
		return ret;
	}
	
	this.savePregunta=function(){
		var ret = ctrl.checkPreguntas();
		if(ctrl.preguntas.length>0 && ret==="ok"){
			$http({
				method : 'POST',
				url : URLGuardar,
				headers : {
					'Content-type' : 'application/x-www-form-urlencoded'
				},
				data : $httpParamSerializerJQLike({
					preguntas : angular.toJson(ctrl.preguntas)
				})
			}).then(function(response) {
				console.log(response);
				if (response.data === "ok") {
					alert("Preguntas guardadas");
					location.href = "/GENERICO/profesor/preguntas";
				} else {
					alert("No se guardaron las preguntas");
				}
			});
		}else if(ret==="ok"){
			alert("Por favor, al menos ingresé una pregunta");
		}else{
			alert(ret);
		}
	}
	
	this.inicia=function(){
		ctrl.temas=temas;
		if(!jQuery.isEmptyObject(preguntas)){
			ctrl.preguntas = preguntas;
			for(var pre in ctrl.preguntas){
				ctrl.preguntas[pre].nivel = ""+ctrl.preguntas[pre].nivel;
				ctrl.preguntas[pre].tema = ""+ctrl.preguntas[pre].tema;
			}
		}
	}
	
	this.cancelar=function(){
		location.href=URLCancelar;
	}
	
	this.inicia();
	
	$(document).ready(function(){
        $(".collapse.in").each(function(){
        	$(this).siblings(".panel-heading").find(".glyphicon").addClass("glyphicon-minus").removeClass("glyphicon-plus");
        });
        $(".collapse").on('show.bs.collapse', function(){
        	$(this).parent().find(".glyphicon").removeClass("glyphicon-plus").addClass("glyphicon-minus");
        }).on('hide.bs.collapse', function(){
        	$(this).parent().find(".glyphicon").removeClass("glyphicon-minus").addClass("glyphicon-plus");
        });
    });
});