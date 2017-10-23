<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/alumno/appAlumno.js" var="app" />
<c:url value="/js/alumno/principal.js" var="ctrl" />

<script type="text/javascript">
	var alumno = ${alumno};
	
</script>

<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro modelado" ng-app="alumnoApp" ng-controller="principalCtrl as ctrl">
	<div class="jumbotron">
		<h1>Bienvenido</h1>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
		<p><h2 class="p-principal">Hola {{ctrl.alumno.nombre+ ' ' +ctrl.alumno.paterno+' '+ctrl.alumno.materno}}!</h2></p>
		<p><h2 class="p-principal">Para iniciar el examen, pulsa el siguiente bóton: </h2></p>
		<p><h2 class="p-principal">Recuerda que solo cuentas con 20 minutos!</h2></p>
		<p class="p-principal"><button class="btn btn-lg btn-success" ng-click="ctrl.irExamen();">Iniciar</button>
	</div>
</div>