<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<c:import url="Header.jsp" />
				<form class="form-horizontal" role="form" method="POST" action="efetuaLogin">

                        <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
                            <label for="usuario_cliente" class="col-md-4 control-label">E-Mail Address</label>

                            <div class="col-md-6">
                                <input id="usuario_cliente" type="text" class="form-control" name="usuario_cliente" value="">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.usuario_cliente"/></strong>
                                    </span>

                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-btn fa-sign-in"></i> Enviar email
                                </button>

                                <a class="btn btn-link" href="Login">Voltar</a>
                            </div>
                        </div>
                    </form>
<c:import url="Footer.jsp" />
                    