<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/grupo/appGrupo.js" var="app" />
<c:url value="/js/grupo/grupos.js" var="ctrl" />

<script type="text/javascript">
	var grupos = ${gruposLista};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro" ng-app="gruposApp" ng-controller="myCtrl as ctrl">
	
	<div class="jumbotron">
		<h1>Grupos</h1>
	</div>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="grupo in ctrl.grupos" ng-click="ctrl.selected(grupo.idGrupo);" ng-class="{selected: grupo.idGrupo === ctrl.select}">
					<td>{{grupo.idGrupo}}</td>
					<td>{{grupo.nombre}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-12">
		<button class="btn btn-success" ng-click="ctrl.Agregar()">Agregar</button>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-12">
		<button class="btn btn-primary" ng-click="ctrl.Editar()">Editar</button>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-12">
			<button class="btn btn-danger" ng-click="ctrl.Eliminar()">Eliminar</button>
	</div>
</div>