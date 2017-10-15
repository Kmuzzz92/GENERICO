<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:url value="/js/profesor/appModelado.js" var="app" />
<c:url value="/js/profesor/modelado.js" var="ctrl" />

<script type="text/javascript">
	var personas = ${alumnos};
</script>
<script type="text/javascript" src="${app}"></script>
<script type="text/javascript" src="${ctrl}"></script>

<div class="container">
<div class="jumbotron">
	<h1>Examenes</h1>
</div>
</div>
