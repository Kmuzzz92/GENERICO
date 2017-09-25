app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.personas = personas;
	
	ctrl.select = 0;

	this.selected=function(id){
		ctrl.select = id;
	}
	
	this.Agregar=function(){
		location.href=URLRegistro+"?aux=0";
	}
	
	this.Editar=function(){
		if(ctrl.select===0)
			alert("Seleccione un usuario, por favor");
		else
			location.href=URLRegistro+"?aux="+ctrl.select;
	}
	
	this.EditarAlumno=function(){
		if(ctrl.select===0)
			alert("Seleccione un usuario, por favor");
		else
			location.href=URLRegistrarAlum+"?aux="+ctrl.select;
	}
	
	this.Activar=function(){
		var user = ctrl.personas.filter(x=> x.id===ctrl.select)
		$http({
			method : 'POST',
			url : URLActivar,
			headers : {
				'Content-type' : 'application/x-www-form-urlencoded'
			},
			data : $httpParamSerializerJQLike({
				username : user[0].username
			})
		}).then(function(response) {
			if (response.data === "OK") {
				alert("Usuario Activado");
			} else {
				alert("No se pudo Activar el usuario");
			}
		});
	}
	
	this.Desactivar=function(){
		var user = ctrl.personas.filter(x=> x.id===ctrl.select)
		console.log(user);
		$http({
			method : 'POST',
			url : URLDesactivar,
			headers : {
				'Content-type' : 'application/x-www-form-urlencoded'
			},
			data : $httpParamSerializerJQLike({
				username : user[0].username
			})
		}).then(function(response) {
			if (response.data === "OK") {
				alert("Usuario desactivado");
			} else {
				alert("No se pudo Desactivar el usuario");
			}
		});
	}
	
	this.NuevoAlumno=function(){
		location.href=URLRegistrarAlum+"?aux=0";
	}
});