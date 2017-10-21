<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appModelado.js" var="app" />
<c:url value="/js/profesor/modelado.js" var="ctrl" />

<script type="text/javascript">
	var examen = ${examen};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container registro" ng-app="gruposApp" ng-controller="modeladoCtrl as ctrl">
	<div class="jumbotron">
		<h1>Examen</h1>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">Nombre: <input type="text" ng-model="ctrl.examen.nombre"></div>
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
</div>