<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appModelado.js" var="app" />
<c:url value="/js/profesor/alumnos.js" var="ctrl" />

<script type="text/javascript">
	var grupos = ${grupos};
</script>

<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro modelado" ng-app="profesorApp" ng-controller="alumnosCtrl as ctrl">
	<div class="jumbotron">
		<h1>Alumnos</h1>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 panel-group" id="accordion"	ng-repeat="grupo in ctrl.grupos">
		<div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse{{grupo.idGrupo}}"><span class="glyphicon glyphicon-plus"></span> {{grupo.nombre}}</a>
                </h4>
            </div>
            <div id="collapse{{grupo.idGrupo}}" class="panel-collapse collapse g">
                <div class="panel-body">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 panel-group" id="accordionP" ng-repeat="persona in grupo.personas">
							<div class="panel panel-default">
            					<div class="panel-heading">
                					<h4 class="panel-title">
                    					<a data-toggle="collapse" data-parent="#accordionP" href="#collapse{{persona.id}}"><span class="glyphicon glyphicon-plus"></span> {{persona.nombre +' '+persona.paterno+' ' + persona.materno}}</a>
                					</h4>
            					</div>
            					<div id="collapse{{persona.id}}" class="panel-collapse collapse">
                					<div class="panel-body">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 panel-group" id="accordionE" ng-repeat="examen in persona.examenes">
												<div class="panel panel-default">
					            					<div class="panel-heading">
					                					<h4 class="panel-title">
					                    					<a data-toggle="collapse" data-parent="#accordionE" href="#collapse{{examen.idExamen}}"><span class="glyphicon glyphicon-plus"></span> {{examen.nombre}}</a>
					                					</h4>
					            					</div>
					            					<div id="collapse{{examen.idExamen}}" class="panel-collapse collapse">
					                					<div class="panel-body">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp" ng-repeat="pregunta in examen.preguntas">
																<p>{{pregunta.texto}}</p>
																<p ng-repeat="respuesta in pregunta.respuestas" class="{{respuesta.correcto?'correcto':'incorrecto'}}"> - {{respuesta.texto}}</p>
															</div>
														</div>
													</div>
												</div>
											</div>		
										</div>
									</div>
								</div>
							</div>
						</div>					
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 margin-resp">
	</div>
</div>