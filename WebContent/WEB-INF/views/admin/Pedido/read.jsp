<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-road"></i> Pedido</h3>
              </div>
            </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="pedido.preco_ped"/></strong>
					<strong><form:errors path="pedido.parcelas_ped"/></strong>
					<strong><form:errors path="pedido.status_ped"/></strong>
					<strong><form:errors path="pedido.peso_ped"/></strong>
					<strong><form:errors path="pedido.altura_ped"/></strong>
					<strong><form:errors path="pedido.ped_largura"/></strong>
					<strong><form:errors path="pedido.comprimento_ped"/></strong>
					<strong><form:errors path="pedido.entrega_data_ped"/></strong>
					<strong><form:errors path="pedido.entrega_hora_ped"/></strong>
					
				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-pencil-square-o"></i> Pedidos <small class="restore-info blue">É necessário <strong>atualizar</strong> a página para as atualizações entrarem em vigor.</small></h2>
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
                        </ul>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<div id="ajax-content-table">
                 		<table id="datatable-pt_br-responsivo" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
	                      <thead>
	                        <tr>
	                          <th style="width: 50%">Cliente</th> 
	                          <th style="width: 25%">Custos</th>
	                          <th style="width: 25%">Status</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="ped" items="${pedidos}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not ped.deleted }">
	                      	  <tr id="tr_${ ped.id_pedido }" data-history="1">
	                      	  	<td>${ ped.cliente.nome_cli }
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ ped.id_pedido }">
						              <button type="button" data-id="${ ped.id_pedido }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
						        </td>
	                      	  	<td><small>Preço:</small> ${ ped.preco_ped }
								<br><small>Forma de Pagamento:</small> ${ ped.custo_forma_de_pagamento_ped }
								<br><small>Frete:</small> ${ ped.custo_frete_ped }</td>
								<td>${ ped.status_ped }
								<br>Data de entrega: ${ ped.data_entrega_ped }</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ ped.deleted }">
	                      	  <tr id="tr_${ ped.id_pedido }" data-history="0">
	                      	  	
	                      	  	<td>${ ped.cliente.nome_cli }
					              	<button type="button"							 data-id="${ ped.id_pedido }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ ped.id_pedido }">
									<!--													 (2) ^^^^^^^^^^^^^^^^^^^	-->
					              	<i class="fa fa-refresh"></i> Restaurar</button>
					            </td>
	                      	  	<td><small>Preço:</small> ${ ped.preco_ped }
								<br><small>Forma de Pagamento:</small> ${ ped.custo_forma_de_pagamento_ped }
								<br><small>Frete:</small> ${ ped.custo_frete_ped }</td>
								<td>${ ped.status_ped }
								<br>Data de entrega: ${ ped.data_entrega_ped }</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
                      		</c:forEach>
	                      </tbody>
	                    </table>
	              	</div>
                  </div>
                </div>
              </div>
			<!-- 
              <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Pedido</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					
				<form action="<c:url value="CreatePedido"/>" method="POST" class="form-horizontal form-label-left input_mask">
					<input type="hidden" name="status_pedido" value="0">
					<input type="hidden" name="preco" value="0.00">
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <select type="hidden" name="cliente.id_cliente" class="form-control">
						<option value="0">Cliente</option>
						<c:forEach var="cli" items="${clientes}">
						  <option value="${ cli.id_cliente }">${ cli.nome_cli }</option>
						</c:forEach>
					  </select>
					  <p>Não encontrou o cliente certo? <a href="<c:url value="/Admin/cliente"/>" title="Editar Cliente">Clique aqui</a></p>
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <select type="hidden" name="produto.id_produto" class="form-control">
						<option value="0">Produto</option>
						<c:forEach var="prod" items="${produtos}">
						  <option value="${ prod.id_produto }">${ prod.nome_pro }</option>
						</c:forEach>
					  </select>
					  <p>Não encontrou o produto certo? <a href="<c:url value="/Admin/produto"/>" title="Editar Produto">Clique aqui</a></p>
					</div>

					<p>Preço: R$ 0,00</p>
					<p>Frete: R$ 0,00</p>
					<p>Total: R$ 0,00</p>
					
					<div class="btn-group pull-right">
					  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
						<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
					  </button>
					</div>	
					</form>
                  </div>
                </div>
              </div>-->
            </div>

<script type="text/javascript">

	edition_param	= "FindPedido";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este pedido?';	// Delete Message
	delete_param	= "DeletePedido";						// Delete Controller Function
	restore_param	= "RestorePedido";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdatePedido"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Pedido</h4>
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