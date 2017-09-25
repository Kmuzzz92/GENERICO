app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.Nuevo = new JSONRegistro();
		
	this.Enviar=function(){
		$http({
            method: 'POST',
            url: URLRegistro,
            headers: { 'Content-type': 'application/x-www-form-urlencoded'},
            data: $httpParamSerializerJQLike({
                registro: JSON.stringify(ctrl.Nuevo)
            })
        }).then(function (response) {
            if(response.data==="OK"){
            	alert ("Alumno guardado");
            	window.history.back();
            }
            else {
            	alert ("No se guardo alumno");
            }
        });
	}
	
	this.Fill=function(){
		if(!jQuery.isEmptyObject(alumno)){
			ctrl.Nuevo.id=alumno.id;
			ctrl.Nuevo.username=alumno.username;
			ctrl.Nuevo.email=alumno.email;
			ctrl.Nuevo.nombre=alumno.nombre;
			ctrl.Nuevo.paterno=alumno.paterno;
			ctrl.Nuevo.materno=alumno.materno;
			ctrl.Nuevo.edad=new Date(alumno.edad);
			ctrl.Nuevo.grupo=alumno.grupo;
		}
	}
	
	this.Cancelar=function(){
		window.history.back();
	}
	
	this.Fill();
});