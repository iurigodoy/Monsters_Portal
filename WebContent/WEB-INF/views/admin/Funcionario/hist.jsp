<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                 		<table id="datatable-pt_br-responsivo" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
	                      <thead>
	                        <tr>
	                          <th style="width: 2%">#</th>
	                          <th style="width: 8%">Foto</th>
	                          <th style="width: 40%">Nome</th>
	                          <th style="width: 25%">Informações</th>
	                          <th style="width: 15%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="fun" items="${funcs}">
	                      	  <tr id="funcionario_${ fun.id_funcionario }">
	                      	  	<td>
	                      	  	  <c:if test="${ fun.deleted }">
	                      	  		<i class="fa fa-trash"></i>
	                      	  	  </c:if>
	                      	  	</td>
	                      	  	
	                      	  	<td><img src="<c:url value="resources/imagens/funcionarios/${ fun.foto_fun}"/>" class="avatar" alt="Foto"></td>
	                      	  	<td>${ fun.nome_fun}<br><small>${ fun.email_fun}<br></small>${ fun.car.nome_car } - Atendente</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:		<fmt:formatDate value="${ fun.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:	<fmt:formatDate value="${ fun.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:		<fmt:formatDate value="${ fun.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
	                      	  	</td>
	                      	  	
	                      	  	<td>
	                      	  	  <c:if test="${ fun.deleted }">
					              	<button type="button"							 data-id="${ fun.id_funcionario }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ fun.id_funcionario }">
					              	<i class="fa fa-refresh"></i> Restaurar</button>
	                      	  	  </c:if>
	                      	  	</td>
	                      	  </tr>
                      		</c:forEach>
	                      </tbody>
	                    </table>
	 
    <script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/table.conf.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/restore/funcionario.js"/>"></script>
