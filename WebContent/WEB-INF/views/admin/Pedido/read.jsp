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
              <div class="col-md-8 col-sm-12 col-xs-12">
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
	                          <th style="width: 10%">ID Cliente</th> 
	                          <th style="width: 45%">Forma de Pagamento</th> 
							  <th style="width: 45%">Número</th>
	                          <th style="width: 25%">Preço</th>
	                          <th style="width: 25%">Custo Forma/Pagamento</th>
	                          <th style="width: 25%">Custo Frete</th>
	                          <th style="width: 25%">Parcelas</th>
	                          <th style="width: 25%">Status</th>
	                          <th style="width: 25%">Peso</th>
	                          <th style="width: 25%">Altura</th>
	                          <th style="width: 25%">Largura</th>
	                          <th style="width: 25%">Comprimento</th>
	                          <th style="width: 25%">Data de Entrega</th>
	                          <th style="width: 25%">Hora de Entrega</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="ped" items="${peds}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not ped.deleted }">
	                      	  <tr id="tr_${ ped.id_pedido }" data-history="1">
	                      	  	<td>${ ped.cliente.nome_cli }</td>
	                      	  	<td>${ ped.forma_pagamento.forma_pagamento_nome }</td>
	                      	  	<td>${ ped.numero_ped }</td>
	                      	  	<td>${ ped.preco_ped }</td>
	                      	  	<td>${ ped.custo_forma_de_pagamento_ped }</td>
	                      	  	<td>${ ped.custo_frete_ped }</td>
								<td>${ ped.parcelas_ped }</td>
								<td>${ ped.status_ped }</td>
	                      	  	<td>${ ped.peso_ped }</td>
	                      	  	<td>${ ped.altura_ped }</td>
	                      	  	<td>${ ped.largura_ped }</td>
	                      	  	<td>${ ped.comprimento_ped }</td>
	                      	  	<td>${ ped.entrega_data_ped }</td>
	                      	  	<td>${ ped.entrega_hora_ped }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ ped.id_pedido }">
					                  <button type="button" data-id="${ ped.id_pedido }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ ped.id_pedido }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ ped.deleted }">
	                      	  <tr id="tr_${ ped.id_pedido }" data-history="0">
	                      	  	
	                      	  	<td>${ ped.cliente.nome_cli }</td>
	                      	  	<td>${ ped.forma_pagamento.forma_pagamento_nome }</td>
	                      	  	<td>${ ped.numero_ped }</td>
	                      	  	<td>${ ped.preco_ped }</td>
	                      	  	<td>${ ped.custo_forma_de_pagamento_ped }</td>
	                      	  	<td>${ ped.custo_frete_ped }</td>
								<td>${ ped.parcelas_ped }</td>
								<td>${ ped.status_ped }</td>
	                      	  	<td>${ ped.peso_ped }</td>
	                      	  	<td>${ ped.altura_ped }</td>
	                      	  	<td>${ ped.largura_ped }</td>
	                      	  	<td>${ ped.comprimento_ped }</td>
	                      	  	<td>${ ped.entrega_data_ped }</td>
	                      	  	<td>${ ped.entrega_hora_ped }</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:	<fmt:formatDate value="${ ped.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:		<fmt:formatDate value="${ ped.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:			<fmt:formatDate value="${ ped.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
									<!--									  (3) ^^^^^^^^^^^^^^^	-->
	                      	  	</td>
	                      	  	
	                      	  	<td>
					              	<button type="button"							 data-id="${ ped.id_pedido }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ ped.id_pedido }">
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
					<!--	
					
							Formulário Create Aqui !!! -->
					<!--		Formulário		-->
					<form action="<c:url value="CreatePedido"/>" method="POST" class="form-horizontal form-label-left input_mask">

					<!--	Input sem ícone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="preco_ped" class="form-control" placeholder="Preco" title="Preco" value="${ pedido.preco_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="parcelas_ped" class="form-control" placeholder="Parcelas" title="Parcelas" value="${ pedido.parcelas_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="status_ped" class="form-control" placeholder="Status Pedido" title="Status" value="${ pedido.status_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="peso_ped" class="form-control" placeholder="Peso" title="Peso" value="${ pedido.peso_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="altura_ped" class="form-control" placeholder="Altura" title="Altura" value="${ pedido.altura_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="comprimento_ped" class="form-control" placeholder="Comprimento" title="Comprimento" value="${ pedido.comprimento_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="entrega_data_ped" class="form-control" placeholder="Data de Entrega" title="Data de Entrega" value="${ pedido.entrega_data_ped }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="entrega_hora_ped" class="form-control" placeholder="Hora de Entrega" title="Hora de Entrega" value="${ pedido.entrega_hora_ped }">
					</div>



					<!--	Select com
							Relacionamento		-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <select type="hidden" name="fornecedor.id_fornecedor" class="form-control">
						<option value="0">Fornecedor</option>
						<c:forEach var="fornecedor" items="${fornecedores}">
						  <option value="${ fornecedor.id_fornecedor }">${ fornecedor.nome_for }</option>
						</c:forEach>
					  </select>
					  <!-- exemplo para facilitar pro usuário -->
					  <p>Não encontrou o Fornecedor certo? <a href="<c:url value="/fornecedor"/>" title="Editar Fornecedores">Clique aqui</a></p>
					</div>

					<!--	Botão de envio	-->
					<div class="btn-group pull-right">
					  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
						<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
					  </button>
					</div>	
					</form>
				<!--	-->
                  </div>
                </div>
              </div>
            </div>

<script type="text/javascript">

	edition_param	= "Find_Pedido";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este pedido?';	// Delete Message
	delete_param	= "DeletePedido";						// Delete Controller Function
	restore_param	= "RestorePedido";						// Restore Controller Function

</script>

<c:import url="../../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/crud.js"/>"></script>

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