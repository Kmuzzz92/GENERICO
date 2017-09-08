app.controller("myCtrl", function($scope, $http, $httpParamSerializerJQLike) {

	var ctrl = this;

	ctrl.grupo = grupo;

	this.Guardar = function() {
		if (ctrl.grupo.nombre === "" || ctrl.grupo.nombre===null) {
			alert("Complete los campos.");
		} else {
			$http({
				method : 'POST',
				url : URLRegistro,
				headers : {
					'Content-type' : 'application/x-www-form-urlencoded'
				},
				data : $httpParamSerializerJQLike({
					registro : JSON.stringify(ctrl.grupo)
				})
			}).then(function(response) {
				if (response.data === "OK") {
					alert("Grupo guardado");
					location.href = "/GENERICO/admin/grupos";
				} else {
					alert("No se guardo grupo");
				}
			});

		}
	}
	this.Cancelar = function() {
		location.href = URLGrupos;
	}
});