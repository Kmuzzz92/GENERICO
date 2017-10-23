<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/alumno/appAlumno.js" var="app" />
<c:url value="/js/alumno/examenes.js" var="ctrl" />

<script type="text/javascript">
	var examenes = ${examenes};
</script>

<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro modelado" ng-app="alumnoApp" ng-controller="examenesCtrl as ctrl">
	<div class="jumbotron">
		<h1>Examenes</h1>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 panel-group" id="accordion"	ng-repeat="examen in ctrl.examenes">
		<div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse{{examen.idExamen}}"><span class="glyphicon glyphicon-plus"></span> {{examen.nombre}}</a>
                </h4>
            </div>
            <div id="collapse{{examen.idExamen}}" class="panel-collapse collapse g">
                <div class="panel-body">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp" ng-repeat="pregunta in examen.preguntas">
							<p>{{pregunta.texto}}</p>
							<p ng-repeat="respuesta in pregunta.respuestas" class="{{respuesta.correcto?'correcto':'incorrecto'}}"> - {{respuesta.texto}}</p>
						</div>			
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp">
	</div>
</div>