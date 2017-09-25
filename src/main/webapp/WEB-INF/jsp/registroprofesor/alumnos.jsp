<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appProfesor.js" var="app" />
<c:url value="/js/profesor/profesor.js" var="ctrl" />

<script type="text/javascript">
	var personas = ${alumnos};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro" ng-app="profesoresApp" ng-controller="myCtrl as ctrl">
	
	<div class="jumbotron">
		<h1>Alumnos</h1>
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
				<tr ng-repeat="alumno in ctrl.personas" ng-click="ctrl.selected(alumno.id);" ng-class="{selected: alumno.id === ctrl.select}">
					<td>{{alumno.username}}</td>
					<td>{{alumno.paterno}}</td>
					<td>{{alumno.materno}}</td>
					<td>{{alumno.nombre}}</td>
					<td>{{alumno.email}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-success" ng-click="ctrl.NuevoAlumno()">Agregar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-primary" ng-click="ctrl.EditarAlumno()">Editar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-danger" ng-click="ctrl.Desactivar()">Desactivar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-3">
		<button class="btn btn-danger" ng-click="ctrl.Activar()">Activar</button>
	</div>
</div>