<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

            <div class="clearfix"></div>

                        <input type="hidden" name="senha_fun" value="${ funcionario.senha_fun }">

                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="nome_fun" class="form-control" placeholder="Nome" title="Nome" value="${ funcionario.nome_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="foto_fun" class="form-control" placeholder="Foto" title="Foto" value="${ funcionario.foto_fun }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="cpf_fun" class="form-control" placeholder="CPF" title="CPF" value="${ funcionario.cpf_fun }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="celular_fun" class="form-control has-feedback-left" placeholder="Celular" title="Celular" value="${ funcionario.celular_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-phone"></i></span>
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="email_fun" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ funcionario.email_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
                      </div>
                      
                      
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
	                        <select name="cargo.id_cargo" class="form-control">
							  <option value="${ funcionario.cargo.id_cargo }" selected>${ funcionario.cargo.nome_car }</option>
						  	  <c:forEach var="cargo" items="${cargos}">
	                          	<option value="${ cargo.id_cargo }">${ cargo.nome_car }</option>
	                          </c:forEach>
	                        </select>
						  <p>Não encontrou o cargo certo? <a href="<c:url value="/Admin/cargo"/>" title="Editar Cargos">Clique aqui</a></p>
                      </div>


<!--							Padrï¿½es do Sistema									-->

	<input type="hidden" name="id_funcionario"	value="${ funcionario.id_funcionario }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ funcionario.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty funcionario.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ funcionario.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ funcionario.deleted }"/>



<div class="col-md-12 col-sm-12 col-xs-12">
	<p>
	Criado em:		<strong><fmt:formatDate value="${ funcionario.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ funcionario.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ funcionario.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>
</div>
