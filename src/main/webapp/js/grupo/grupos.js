app.controller("myCtrl", function($scope,$http,$httpParamSerializerJQLike) {
    
	function AsignarGrupo(){
		this.idGrupo=0;
		this.nombre="";
		this.idProfesor=0;
	}
	
	function Profesores(){
		this.users="";
		this.nombre="";
	}
	
	var ctrl = this;
	
	ctrl.grupos = grupos;
	
	ctrl.grupoAsignar= new AsignarGrupo();
	
	ctrl.select = 0;
	
	ctrl.profesores=[];
	
	this.selected=function(id){
		ctrl.select = id;
	}
	
	this.Agregar = function(){
		location.href=URLGrupo+"?grupo=0";
	}
	
	this.Editar = function(){
		if(ctrl.select!==0)
			location.href=URLGrupo+"?grupo="+ctrl.select;
		else
			alert("Seleccione un grupo, por favor");
	}
	
	this.Eliminar = function(){
		if(ctrl.select!==0){
			$http({
				method : 'POST',
				url : URLEliminar,
				headers : {
					'Content-type' : 'application/x-www-form-urlencoded'
				},
				data : $httpParamSerializerJQLike({
					grupo : ""+ctrl.select
				})
			}).then(function(response) {
				if (response.data === "OK") {
					alert("Grupo eliminado");
					location.href = "/GENERICO/admin/grupos";
				} else {
					alert("No se elimino el grupo");
				}
			});
		}else{
			alert("Seleccione un grupo, por favor");
		}
	}
	
	this.AsignarGrupo=function(){
		if(ctrl.select!==0){
			ctrl.GetProfesores();
			var index = ctrl.grupos.findIndex(i => i.idGrupo===ctrl.select);
			ctrl.grupoAsignar.idGrupo = ctrl.select	;
			ctrl.grupoAsignar.nombre = ctrl.grupos[index].nombre;
			ctrl.grupoAsignar.idProfesor=ctrl.grupos[index].profesor;
			
		}else{
			alert("Seleccione un grupo, por favor");
		}
	}
	
	this.GetProfesores=function(){
		$http({
			method : 'POST',
			url : URLProfesores,
			headers : {
				'Content-type' : 'application/x-www-form-urlencoded'
			}
		}).then(function(response) {
			for(i=0;i<response.data[0].length;i++){
				var nue = new Profesores();
				nue.users=response.data[0][i];
				nue.nombre=response.data[1][i];
				ctrl.profesores.push(nue);
			}
			$("#asignar").modal('show');
		});
	}
	
	this.asignar=function(){
		if(ctrl.grupoAsignar.idGrupo!==0 && ctrl.grupoAsignar.idProfesor!==0){
			$http({
				method : 'POST',
				url : URLProfesoresAsig,
				headers : {
					'Content-type' : 'application/x-www-form-urlencoded'
				},
				data : $httpParamSerializerJQLike({
					idGrupo : ctrl.grupoAsignar.idGrupo,
					profesor: ctrl.grupoAsignar.idProfesor
				})
			}).then(function(response) {
				alert(response.data);
				$("#asignar").modal('hide');
			}).catch(function(response){
				alert(response);
			});
		}else{
			alert("Verifique los campos, por favor");
		}
	}
});