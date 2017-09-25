<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/registro/appRegistro.js" var="app" />
<c:url value="/js/registro/registroP.js" var="ctrl" />
<c:url value="/js/registro/JSONRegistro.js" var="json" />

<script type="text/javascript">
	
	var profesor=${profesor};
</script>

<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>
<script type="text/javascript" src="${json}"></script>



<div class="container registro" ng-app="registroApp" ng-controller="myCtrl as ctrl">
	<div class="jumbotron">
		<h1>Registro Profesor</h1>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-0"></div>
	<div class="col-lg-6 col-md-6 col-sm-12">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Username:</label><input type="text" maxlength="20"
				ng-model="ctrl.Nuevo.username" ng-disabled="{{ctrl.Nuevo.id!==0}}"/>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Contraseña:</label><input type="password" maxlength="30"
				ng-model="ctrl.Nuevo.contrasena" />
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>E-mail:</label><input type="email" maxlength="100"
				ng-model="ctrl.Nuevo.email" />
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Nombre:</label><input type="text" maxlength="30"
				ng-model="ctrl.Nuevo.nombre" />
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Paterno:</label><input type="text" maxlength="30"
				ng-model="ctrl.Nuevo.paterno" />
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Materno:</label><input type="text" maxlength="30"
				ng-model="ctrl.Nuevo.materno" />
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Edad:</label><input type="date" maxlength="30"
				ng-model="ctrl.Nuevo.edad" />
		</div>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12">
		<div class="col-lg-6 col-md-6 col-sm-6">
			<button class="btn btn-success" ng-click="ctrl.Enviar()">Agregar</button>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6">
			<button class="btn btn-danger" ng-click="ctrl.Cancelar()">Cancelar</button>
		</div>
	</div>
</div>
<div class="col-lg-3 col-md-3 col-sm-0"></div>
</div>