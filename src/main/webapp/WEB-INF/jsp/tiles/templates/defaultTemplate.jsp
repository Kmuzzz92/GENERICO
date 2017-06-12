<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>

<c:url value="/css/estilo_general.css" var="general_max" />
<c:url value="/css/bootstrap/css/bootstrap.min.css" var="bootstrapmin" />
<c:url value="/js/jquery-3.2.1.min.js" var="jquery" />
<c:url value="/js/angular.min.js" var="angular" />
<c:url value="/js/angular.route.min.js" var="route" />

<html lang="es-419">
	<head>
		<title>GENERICO</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="${jquery}"></script>
		<link rel="stylesheet" type="text/css" href="${bootstrapmin}">
		<script type="text/javascript" src="${angular}"></script>
		<script type="text/javascript" src="${route}"></script>
		<link rel="stylesheet" type="text/css" href="${general_max}">
		<put-list-attribute name="scripts">
		</put-list-attribute>
	</head>
	<body>
		<tiles:insertAttribute name="leftPanel"/>
		<tiles:insertAttribute name="body" />
	</body>
</html>

