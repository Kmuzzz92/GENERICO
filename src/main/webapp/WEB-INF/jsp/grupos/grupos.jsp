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
					<th>Profesor</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="grupo in ctrl.grupos" ng-click="ctrl.selected(grupo.idGrupo);" ng-class="{selected: grupo.idGrupo === ctrl.select}">
					<td>{{grupo.idGrupo}}</td>
					<td>{{grupo.nombre}}</td>
					<td>{{grupo.aux}}</td>
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
	<!-- Modal -->
  <div class="modal fade" id="asignar" role="dialog" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">{{ctrl.grupoAsignar.nombre}}</h4>
        </div>
        <div class="modal-body">
          <p><label>Elija un Profesor: </label>
          <select ng-model="ctrl.grupoAsignar.idProfesor">
          	<option ng-repeat="profe in ctrl.profesores" value="{{profe.users}}">{{profe.nombre}}</option>
          </select></p>
        </div>
        <div class="modal-footer">
        	<button type="button" class="btn btn-default" ng-click="ctrl.asignar();">Asignar</button>
          	<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
      </div>
      
    </div>
  </div>
</div>