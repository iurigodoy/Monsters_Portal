<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-group"></i> Funcionários </h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Procure por...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Vá!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

<c:forEach var="fun" items="${funs}">

                        <input type="hidden" name="login_fun" value="${ fun.login_fun }">
                        <input type="hidden" name="senha_fun" value="${ fun.senha_fun }">

                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="nome_fun" class="form-control" placeholder="Nome" title="Nome" value="${ fun.nome_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="foto_fun" class="form-control" placeholder="Foto" title="Foto" value="${ fun.foto_fun }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="cpf_fun" class="form-control" placeholder="CPF" title="CPF" value="${ fun.cpf_fun }">
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <input type="text" name="email_fun" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fun.email_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
                      </div>
                      
                      
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
	                        <select name="car.id_cargo" class="form-control">
							  <option value="${ fun.car.id_cargo }" selected>${ fun.car.nome_car }</option>
						  	  <c:forEach var="cargo" items="${cargos}">
	                          	<option value="${ car.id_cargo }">${ car.nome_cargo }</option>
	                          </c:forEach>
	                        </select>
						  <p>Não encontrou o cargo certo? <a href="#" title="Editar Cargos">Clique aqui</a></p>
                      </div>
                      
                      
                      <div class="col-md-6 col-sm-6 col-xs-12 form-group">
                        <select name="ramal.id_ramal" class="form-control">
						  <option value="${ fun.ramal.id_ramal }">${ fun.ramal.numero_ram }</option>
					  	  <c:forEach var="ramal" items="${ramais}">
                          	<option value="${ ramal.id_ramal }">${ ramal.numero_ram }</option>
                          </c:forEach>
                        </select>
						<p>Não encontrou o ramal? <a href="<c:url value="/Setores_Ramais"/>" title="Editar Setores e Ramais">Clique aqui</a></p>
                      </div>

<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_funcionario"	value="${ fun.id_funcionario }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ fun.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty fun.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ fun.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ fun.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ fun.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ fun.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ fun.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</c:forEach>

<c:import url="../Footer.jsp" />