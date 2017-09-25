<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appProfesor.js" var="app" />
<c:url value="/js/profesor/profesor.js" var="ctrl" />

<script type="text/javascript">
	var personas = ${profesores};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro" ng-app="profesoresApp" ng-controller="myCtrl as ctrl">
	
	<div class="jumbotron">
		<h1>Profesores</h1>
	</div>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Username</th>
					<th>Paterno</th>
					<th>Materno</th>
					<th>Nombre</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="profesor in ctrl.personas" ng-click="ctrl.selected(profesor.id);" ng-class="{selected: profesor.id === ctrl.select}">
					<td>{{profesor.username}}</td>
					<td>{{profesor.paterno}}</td>
					<td>{{profesor.materno}}</td>
					<td>{{profesor.nombre}}</td>
					<td>{{profesor.email}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-success" ng-click="ctrl.Agregar()">Agregar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-primary" ng-click="ctrl.Editar()">Editar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-danger" ng-click="ctrl.Desactivar()">Desactivar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-danger" ng-click="ctrl.Activar()">Activar</button>
	</div>
</div>