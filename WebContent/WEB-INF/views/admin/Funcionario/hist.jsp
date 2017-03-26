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
					  		<c:forEach var="func" items="${funcs}">
	                      	  <tr id="funcionario_${ func.id_funcionario }">
	                      	  	<td>
	                      	  	  <c:if test="${ func.deleted }">
	                      	  		<i class="fa fa-trash"></i>
	                      	  	  </c:if>
	                      	  	</td>
	                      	  	
	                      	  	<td><img src="<c:url value="resources/imagens/funcionarios/${ func.foto_func }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td>${ func.nome_func }<br><small>${ func.email_func }<br></small>${ func.cargo.nome_cargo } - Atendente</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:		<fmt:formatDate value="${ func.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:	<fmt:formatDate value="${ func.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:		<fmt:formatDate value="${ func.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
	                      	  	</td>
	                      	  	
	                      	  	<td>
	                      	  	  <c:if test="${ func.deleted }">
					              	<button type="button"							 data-id="${ func.id_funcionario }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ func.id_funcionario }">
					              	<i class="fa fa-refresh"></i> Restaurar</button>
	                      	  	  </c:if>
	                      	  	</td>
	                      	  </tr>
                      		</c:forEach>
	                      </tbody>
	                    </table>
	 
    <script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/table.conf.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/restore/funcionario.js"/>"></script>
