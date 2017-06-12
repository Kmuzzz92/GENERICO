<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-lock"></span> Inicio sesion</div>
                <div class="panel-body">
                    <form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST' class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">
                            Usuario</label>
                        <div class="col-sm-9">
                            <input type="text" name='username' class="form-control" placeholder="usuario" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Contraseña</label>
                        <div class="col-sm-9">
                            <input type="password" name='password' class="form-control" placeholder="contraseña" required>
                        </div>
                    </div>
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                                Entrar</button>
                        </div>
                    </div>
				<input type="hidden" usuario="${_csrf.parameterName}" contraseña="${_csrf.token}" />
                    </form>
                </div>
                <div class="panel-footer">
                    No estas registrado? <a>Registrate aqui</a></div>
            </div>
        </div>
    </div>
</div>
