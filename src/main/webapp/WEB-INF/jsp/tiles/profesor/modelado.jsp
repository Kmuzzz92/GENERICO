<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appModelado.js" var="app" />
<c:url value="/js/profesor/modelado.js" var="ctrl" />
<c:url value="/js/profesor/examen.js" var="obj" />

<script type="text/javascript">
	var temas = $
	{
		temas
	};
	var preguntas = ${preguntas};
</script>

<script type="text/javascript" src="${obj}"></script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro modelado" ng-app="profesorApp" ng-controller="modeladoCtrl as ctrl">
	<div class="jumbotron">
		<h1>Preguntas</h1>
	</div>
	<div class="panel-group" id="accordion">
		<div ng-repeat="pregunta in ctrl.preguntas track by $index">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse{{pregunta.idPregunta}}"><span class="glyphicon glyphicon-plus"></span> {{pregunta.texto}}</a>
					</h4>
				</div>
				<div id="collapse{{pregunta.idPregunta}}" class="panel-collapse collapse">
					<div class="panel-body">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							Texto Pregunta: <input type="text" ng-model="pregunta.texto" />
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<label>Nivel: </label> <select ng-model="pregunta.nivel">
								<option ng-repeat="nivel in ctrl.nivel" value="{{nivel}}">{{nivel}}</option>
							</select>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
							<label>Tema: </label> <select ng-model="pregunta.tema">
								<option ng-repeat="tema in ctrl.temas" value="{{tema.idTema}}">{{tema.nombre}}</option>
							</select>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp"
							ng-repeat="respuesta in pregunta.respuestas">
							<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
							<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									Texto Respuesta:
									<textarea ng-model="respuesta.texto"></textarea>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									Correcta: <input type="checkbox" ng-model="respuesta.correcto" />
								</div>
							</div>
							<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 respuesta">
							<button class="btn btn-success"
								ng-click="ctrl.addRespuesta(pregunta)">+ respuesta</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 agregar">
		<button class="btn btn-success" ng-click="ctrl.savePregunta();">Guardar</button>
		<button class="btn btn-danger" ng-click="ctrl.cancelar();">Cancelar</button>
		<button class="btn btn-primary" style="float: right;"
			ng-click="ctrl.addPregunta();">+ pregunta</button>
	</div>
</div>