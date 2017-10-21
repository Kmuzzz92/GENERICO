<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appModelado.js" var="app" />
<c:url value="/js/profesor/examenes.js" var="ctrl" />

<script type="text/javascript">
	var examenes = ${examenes};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro" ng-app="profesorApp" ng-controller="examenesCtrl as ctrl">
	<div class="jumbotron">
		<h1>Examenes</h1>
	</div>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Activo</th>
					<th>Fecha</th>
					<th>Usuario</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="examen in ctrl.examenes" ng-click="ctrl.selected(examen.idExamen);" ng-class="{selected: examen.idExamen === ctrl.select}">
					<td>{{examen.nombre}}</td>
					<td>{{examen.descripcion}}</td>
					<td>{{examen.activo}}</td>
					<td>{{examen.fecha_creacion}}</td>
					<td>{{examen.usuario}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6">
		<button class="btn btn-success" ng-click="ctrl.Agregar()">Agregar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6">
		<button class="btn btn-primary" ng-click="ctrl.Editar()">Editar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6">
		<button class="btn btn-danger" ng-click="ctrl.Eliminar()">Eliminar</button>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6">
		<button class="btn btn-info" ng-click="ctrl.AsignarGrupo()">Asignar Profesor</button>
	</div>
</div>
