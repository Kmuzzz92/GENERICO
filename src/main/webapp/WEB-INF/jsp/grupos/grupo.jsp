<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/grupo/appGrupo.js" var="app" />
<c:url value="/js/grupo/grupo.js" var="ctrl" />

<script type="text/javascript">
	var grupo = ${grupo};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro" ng-app="gruposApp" ng-controller="myCtrl as ctrl">
	
	<div class="jumbotron">
		<h1>Editar Grupo</h1>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-0"></div>
	<div class="col-lg-6 col-md-6 col-sm-12">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>ID:</label><input type="text" ng-model="ctrl.grupo.idGrupo"/>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label>Nombre:</label><input type="text" ng-model="ctrl.grupo.nombre"/>
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-0"></div>
	<div class="col-lg-6 col-md-6 col-sm-12">
		<button class="btn btn-primary" ng-click="ctrl.Guardar()">Guardar</button>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-12">
			<button class="btn btn-danger" ng-click="ctrl.Cancelar()">Cancelar</button>
	</div>
</div>