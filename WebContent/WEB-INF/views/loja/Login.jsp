<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<c:import url="Header.jsp" />
	<div class="panel panel-defaut">
		<div class="panal-body">
		<h2 align="center">Login</h2>
				<form class="form-horizontal" role="form" method="POST" action="efetuaLogin">

                        <div class="form-group <c:if test="${not empty param.login_error}"> has-error</c:if>">
                            <label for="usuario_cliente" class="col-md-4 control-label">Usuario </label>

                            <div class="col-md-6">
                                <input id="usuario_cliente" type="text" class="form-control" name="usuario_cliente" value="">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.usuario_cliente"/></strong>
                                    </span>

                            </div>
                        </div>

                        <div class="form-group <c:if test="${not empty param.login_error}"> has-error</c:if>">
                            <label for="password" class="col-md-4 control-label">Senha </label>

                            <div class="col-md-6">
                                <input id="password" type="password" class="form-control" name="senha_cliente">

                                    <span class="help-block">
                                        <strong><form:errors path="cliente.senha_cliente"/></strong>
                                    </span>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                              <c:if test="${not empty param.login_error}">
								<h5 style="font-size:16px;color:red;">
									${param.login_error }
								</h5>
							  </c:if>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="remember"> Lembre-Me
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-btn fa-sign-in"></i> Login
                                </button>

                                <a class="btn btn-link" href="LoginEsqueciSenha">Esqueceu sua senha?</a>
                            </div>
                        </div>
                    </form>
	</div>
</div>
<c:import url="Footer.jsp" />
                    