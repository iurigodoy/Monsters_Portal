<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


                        <input type="hidden" name="login_func" value="${ func.login_func }">
                        <input type="hidden" name="senha_func" value="${ func.senha_func }">

                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="nome_func" class="form-control" placeholder="Nome" title="Nome" value="${ func.nome_func }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="foto_func" class="form-control" placeholder="Foto" title="Foto" value="${ func.foto_func }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="cpf_func" class="form-control" placeholder="CPF" title="CPF" value="${ func.cpf_func }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="email_func" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ func.email_func }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
                      </div>
                      
                      
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
	                        <select name="cargo.id_cargo" class="form-control">
							  <option value="${ func.cargo.id_cargo }" selected>${ func.cargo.nome_cargo }</option>
						  	  <c:forEach var="cargo" items="${cargos}">
	                          	<option value="${ cargo.id_cargo }">${ cargo.nome_cargo }</option>
	                          </c:forEach>
	                        </select>
						  <p>Não encontrou o cargo certo? <a href="#" title="Editar Cargos">Clique aqui</a></p>
                      </div>
                      
                      
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <select name="ramal.id_ramal" class="form-control">
						  <option value="${ func.ramal.id_ramal }">${ func.ramal.numero_ram }</option>
					  	  <c:forEach var="ramal" items="${ramais}">
                          	<option value="${ ramal.id_ramal }">${ ramal.numero_ram }</option>
                          </c:forEach>
                        </select>
						<p>Não encontrou o ramal? <a href="<c:url value="/Setores_Ramais"/>" title="Editar Setores e Ramais">Clique aqui</a></p>
                      </div>

<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_funcionario"	value="${ func.id_funcionario }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ func.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty func.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ func.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ func.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ func.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ func.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ func.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

