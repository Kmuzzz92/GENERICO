app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	var ctrl = this;
	
	ctrl.Nuevo = new JSONRegistro();
		
	this.Enviar=function(){
		$http({
            method: 'POST',
            url: URLRegistro,
            headers: { 'Content-type': 'application/x-www-form-urlencoded'},
            data: $httpParamSerializerJQLike({
                n: JSON.stringify(ctrl.Nuevo)
            })
        }).then(function (response) {
            console.log(reponse);               
        });
	}
});