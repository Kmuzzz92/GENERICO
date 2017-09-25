app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.Nuevo = new JSONRegistro();
		
	this.Fill=function(){
		if(!jQuery.isEmptyObject(profesor)){
			ctrl.Nuevo.id=profesor.id;
			ctrl.Nuevo.username=profesor.username;
			ctrl.Nuevo.email=profesor.email;
			ctrl.Nuevo.nombre=profesor.nombre;
			ctrl.Nuevo.paterno=profesor.paterno;
			ctrl.Nuevo.materno=profesor.materno;
			ctrl.Nuevo.edad=new Date(profesor.edad);
			ctrl.Nuevo.grupo=profesor.grupo;
			ctrl.Nuevo.contrasena="";
		}
	}
	
	this.Enviar=function(){
		$http({
            method: 'POST',
            url: URLRegistroP,
            headers: { 'Content-type': 'application/x-www-form-urlencoded'},
            data: $httpParamSerializerJQLike({
                registro: JSON.stringify(ctrl.Nuevo)
            })
        }).then(function (response) {
            if(response.data==="OK"){
            	alert ("Profesor guardado");
            	window.history.back();
            }
            else {
            	alert ("No se guardo profesor");
            }
        });
	}
	
	this.Cancelar=function(){
		window.history.back();
	}
	
	this.Fill();
});