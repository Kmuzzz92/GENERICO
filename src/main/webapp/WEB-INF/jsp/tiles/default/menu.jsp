<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/j_spring_security_logout" var="logoutForm"></c:url>

<script type="text/javascript">
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
<form action="${logoutForm}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<ul class="nav nav-tabs">
		<li><a href="/GENERICO/admin/grupos">Grupos</a></li>
		<li><a href="/GENERICO/admin/profesores">Profesores</a></li>
		<li><a href="/GENERICO/admin/alumnos">Alumnos</a></li>
		<li><a href="javascript:formSubmit()">Salir</a></li>
	</ul>
</form>