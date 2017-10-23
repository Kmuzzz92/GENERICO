<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/alumno/appAlumno.js" var="app" />
<c:url value="/js/alumno/examen.js" var="ctrl" />

<script type="text/javascript">
	var preguntas = ${preguntas};
</script>

<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro modelado" ng-app="alumnoApp" ng-controller="examenCtrl as ctrl">
	<div class="jumbotron">
		<h1>Examen</h1>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" ng-repeat="pregunta in ctrl.preguntas track by $index">
		<p>{{$index+1}} - {{pregunta.texto}}</p>
		<p>
			<div ng-repeat="respuesta in pregunta.respuestas">
				<input type="radio" ng-model="pregunta.respuesta" value="{{respuesta.idRespuesta}}"/> {{respuesta.texto}} <Sbr>
			</div>
		</p>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<button class="btn btn-danger" style="float: right; margin-bottom: 1em;" ng-click="ctrl.enviar();">Enviar</button>
	</div>
</div>