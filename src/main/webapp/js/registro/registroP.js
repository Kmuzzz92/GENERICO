app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.Nuevo = new JSONRegistro();
		
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
            	location.href="/GENERICO/login";
            }
            else {
            	alert ("No se guardo profesor");
            }
        });
	}
});