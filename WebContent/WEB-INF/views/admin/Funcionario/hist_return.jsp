<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                 		<table id="datatable-pt_br-responsivo" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
	                      <thead>
	                        <tr>
	                          <th style="width: 10%">Foto</th>
	                          <th style="width: 45%">Nome</th>
	                          <th style="width: 25%">Cargo</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="func" items="${funcs}">
	                      	  <tr id="delete_row_${ func.id_funcionario }">
	                      	  	<td><img src="<c:url value="resources/imagens/funcionarios/${ func.foto_func }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td>${ func.nome_func }<br><small>${ func.email_func }</small></td>
	                      	  	<td><strong>Cargo</strong><br><small>Atendente</small></td>
	                      	  	<td>
				                  <button type="button" data-id="${ func.id_funcionario }" class="btn btn-primary btn-xs ModalFuncionario"
				                  		data-toggle="modal" data-target=".bs-funcionario-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
					              <button type="button" data-id="${ func.id_funcionario }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
	                      	  	</td>
	                      	  </tr>
                      		</c:forEach>
	                      </tbody>
	                    </table>
	 
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/table.conf.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/edt_modal/funcionario.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/history/funcionario.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/delete/funcionario.js"/>"></script>
	 