<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="login">
	<h3>Por favor, Ingrese su Usuario y Contraseña</h3>
	<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type='password' name='password' /></td>
			</tr>
		</table>
		<p><input name="submit" type="submit" value="Entrar" /></p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
	<c:if test="${not empty error}">
		<script type="text/javascript">
			alert("${error}");
		</script>
	</c:if>
</div>