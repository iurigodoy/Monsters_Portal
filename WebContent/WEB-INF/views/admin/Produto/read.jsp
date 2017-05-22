<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-cubes"></i> Produtos <a href="<c:url value="/Admin/adicionar_produto"/>" class="btn btn-default blue"><i class="fa fa-plus"></i> Adicionar</a></h3>
              </div>
            </div>

              <div class="title_right">
                <div class="col-md-6 col-sm-12 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="produto.nome_pro"/></strong>
					<strong><form:errors path="produto.descricao_pro"/></strong>
					<strong><form:errors path="produto.publicado_pro"/></strong>
					<strong><form:errors path="produto.destaque_pro"/></strong>
					<strong><form:errors path="produto.promocao_pro"/></strong>
					<strong><form:errors path="produto.peso_pro"/></strong>
					<strong><form:errors path="produto.altura_pro"/></strong>
					<strong><form:errors path="produto.largura_pro"/></strong>
					<strong><form:errors path="produto.comprimento_pro"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-pencil-square-o"></i> Editar <small class="restore-info blue">é necessário <strong>atualizar</strong> a página para as atualizações entrarem em vigor.</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a class="toolbox-history"><i class="fa fa-history"></i> Exibir Histórico</a>
                          </li>
                          <li><a class="toolbox-history-return"><i class="fa fa-history"></i> Voltar</a>
                          </li>
                          <li><a href="<c:url value="/Admin/adicionar_produto"/>"><i class="fa fa-plus"></i> Adicionar Produto</a>
                          </li>
                          <li><a href="<c:url value="/Admin/categoria"/>"><i class="fa fa-cog"></i> editar categoria</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<div id="ajax-content-table">
                 		<table id="datatable-pt_br-responsivo" class="table table-striped table-bordered dt-responsive nowrap">
	                      <thead>
	                        <tr>
	                          <th style="width: 20%">Nome</th>
	                          <!-- <th style="width: 10%">Descrição</th>
	                          <th style="width: 10%">Publicado</th>
	                          <th style="width: 10%">Destaque</th>
	                          <th style="width: 10%">Desconto</th>
	                          <th style="width: 10%">Promoção</th> -->
	                          <th style="width: 30%">Peso e Dimensões</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="pro" items="${produtos}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not pro.deleted }">
	                      	  <tr id="tr_${ pro.id_produto }" data-history="1">
	                      	  	<td><strong>${ pro.nome_pro }</strong><br>${ pro.categoria.nome_cat }</td>
	                      		<!-- <td>${ pro.descricao_pro }</td>
	                      	  	<td>${ pro.publicado_pro }</td>
	                      	  	<td>${ pro.destaque_pro }</td>
								<td>${ pro.desconto_pro }</td>
								<td>${ pro.promocao_pro }</td> -->
	                      	  	<td>
	                      	  	Peso: ${ pro.peso_pro } <small>(kg)</small><br>
	                      	  	Altura: ${ pro.altura_pro } <small>(cm)</small><br>
	                      	  	Largura: ${ pro.largura_pro } <small>(cm)</small><br>
	                      	  	Comprimento: ${ pro.comprimento_pro } <small>(cm)</small><br>
	                      	  	Diâmetro: ${ pro.diametro_pro } <small>(cm)</small>
	                      	  	</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ pro.id_produto }">
					                  <button type="button" data-id="${ pro.id_produto }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ pro.id_produto }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ pro.deleted }">
	                      	  <tr id="tr_${ pro.id_produto }" data-history="0">
	                      	  	
	                      	  	<td>${ pro.nome_pro }<br>${ pro.categoria.nome_cat }</td>
	                      	  	<!-- <td>${ pro.descricao_pro }</td>
	                      	  	<td>${ pro.publicado_pro }</td>
	                      	  	<td>${ pro.destaque_pro }</td>
								<td>${ pro.desconto_pro }</td>
								<td>${ pro.promocao_pro }</td> -->
	                      	  	<td>
	                      	  	Peso: ${ pro.peso_pro } <small>(kg)</small><br>
	                      	  	Altura: ${ pro.altura_pro } <small>(cm)</small><br>
	                      	  	Largura: ${ pro.largura_pro } <small>(cm)</small><br>
	                      	  	Comprimento: ${ pro.comprimento_pro } <small>(cm)</small><br>
	                      	  	Diâmetro: ${ pro.diametro_pro } <small>(cm)</small>
	                      	  	</td>
	                      	  	
	                      	  	<!-- <td>
									<small>Criado em:	<fmt:formatDate value="${ pro.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:		<fmt:formatDate value="${ pro.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:			<fmt:formatDate value="${ pro.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
	                      	  	</td> -->
	                      	  	
	                      	  	<td>
					              	<button type="button"							 data-id="${ pro.id_produto }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ pro.id_produto }">
									<!--													 (2) ^^^^^^^^^^^^^^^^^^^	-->
					              	<i class="fa fa-refresh"></i> Restaurar</button>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
                      		</c:forEach>
	                      </tbody>
	                    </table>
	              	</div>
                  </div>
                </div>
              </div>
            </div>

<script type="text/javascript">

	edition_param	= "FindProduto";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este produto?';	// Delete Message
	delete_param	= "DeleteProduto";						// Delete Controller Function
	restore_param	= "RestoreProduto";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="../resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateProduto"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Produto</h4>
		  <!--																						^^^^^^^^^^^	-->
	    </div>
	    <div class="modal-body">
	                          
	    	<div id="modal_content"></div>
	                          
	    </div>
	    <div class="modal-footer">
	    	<button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
	        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Salvar</button>
	    </div>

	  </form>
	</div>
  </div>
</div>