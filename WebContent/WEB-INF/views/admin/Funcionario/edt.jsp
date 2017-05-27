<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

            <div class="clearfix"></div>

                         <input type="hidden" name="fun_login" value="${ fun.fun_login }">
                        <input type="hidden" name="fun_senha" value="${ fun.fun_senha }">

                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="fun_nome" class="form-control" placeholder="Nome" title="Nome" value="${ fun.fun_nome }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="fun_foto" class="form-control" placeholder="Foto" title="Foto" value="${ fun.fun_foto }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="fun_cpf" class="form-control" placeholder="CPF" title="CPF" value="${ fun.fun_cpf }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="fun_email" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fun.fun_email }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
                      </div>
                      
                      
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
	                        <select name="car.id_cargo" class="form-control">
							  <option value="${ fun.car.id_cargo }" selected>${ fun.car.car_nome }</option>
						  	  <c:forEach var="cargo" items="${cargos}">
	                          	<option value="${ car.id_cargo }">${ car.car_nome }</option>
	                          </c:forEach>
	                        </select>
						  <p>N�o encontrou o cargo certo? <a href="#" title="Editar Cargos">Clique aqui</a></p>
                      </div>


<!--							Padr�es do Sistema									-->

	<input type="hidden" name="id_funcionario"	value="${ funcionario.id_funcionario }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ fun.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty fun.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ fun.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ fun.deleted }"/>



<div class="col-md-12 col-sm-12 col-xs-12">
	<p>
	Criado em:		<strong><fmt:formatDate value="${ fun.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ fun.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ fun.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>
</div>
