<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-sitemap"></i> Cargo</h3>
              </div>
            </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="car.nome_car "/></strong>
					<strong><form:errors path="car.padrao_car "/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-7 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
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
                          <li><a href="<c:url value="/Admin/funcionario"/>"><i class="fa fa-users"></i> Funcionários</a>
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
	                          <th style="width: 20%">Nome</th>
	                          <th style="width: 60%">Permissões</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="car" items="${cargos}">
					  		<c:if test="${ not car.deleted }">
	                      	  <tr id="tr_${ car.id_cargo }" data-history="1">
	                      	  	<td>${ car.nome_car }</td>
	                      	  	<td>
	                      	  	${ car.permissao.lerBanner }
	                      	  	</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ car.id_cargo }">
					                  <button type="button" data-id="${ car.id_cargo }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ car.id_cargo }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
					  		<c:if test="${ car.deleted }">
	                      	  <tr id="tr_${ car.id_cargo }" data-history="0">
	                      	  	<td>${ car.nome_car }</td>
	                      	  	<td>
	                      	  	${ car.permissao.lerBanner }
	                      	  	</td>
	                      	  	<td>
					              	<button type="button"							 data-id="${ car.id_cargo }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ car.id_cargo }">
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

              <div class="col-md-5 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Cargo</h2>
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
					
							FormulÃ¡rio Create Aqui !!! -->
					<!--		FormulÃ¡rio		-->
					<form action="<c:url value="CreateCargo"/>" method="POST" class="form-horizontal form-label-left input_mask">

					<!--	Input sem Ã­cone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="nome_car" class="form-control" placeholder="Nome" title="Nome" value="${ car.nome_car }">
					</div>

					<!--	Booleano	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="padrao_car" class="js-switch" title="Cargo Padrao" value="${ cargo.padrao_car }"> Cargo Padrão
					  </label>
					</div>
					
					<!--	Booleano	-->
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-clone"></i> Banner</h4>
					  <label>
						<input type="checkbox" name="lerBanner" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarBanner" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarBanner" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirBanner" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarBanner" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-sitemap"></i> Cargo</h4>
					  <label>
						<input type="checkbox" name="lerCargo" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarCargo" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarCargo" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirCargo" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarCargo" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-clone"></i> Categoria</h4>
					  <label>
						<input type="checkbox" name="lerCategoria" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarCategoria" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarCategoria" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirCategoria" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarCategoria" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-users"></i> Cliente</h4>
					  <label>
						<input type="checkbox" name="lerCliente" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarCliente" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarCliente" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirCliente" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarCliente" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-truck"></i> Fornecedor</h4>
					  <label>
						<input type="checkbox" name="lerFornecedor" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarFornecedor" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarFornecedor" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirFornecedor" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarFornecedor" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-users"></i> Funcionário</h4>
					  <label>
						<input type="checkbox" name="lerFuncionario" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarFuncionario" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarFuncionario" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirFuncionario" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarFuncionario" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-road"></i> Pedido</h4>
					  <label>
						<input type="checkbox" name="lerPedido" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarPedido" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarPedido" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirPedido" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarPedido" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-cubes"></i> Produto</h4>
					  <label>
						<input type="checkbox" name="lerProduto" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarProduto" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarProduto" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirProduto" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarProduto" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>

					<!--	BotÃ£o de envio	-->
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

	edition_param	= "FindCargo";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este cargo?';	// Delete Message
	delete_param	= "DeleteCargo";						// Delete Controller Function
	restore_param	= "RestoreCargo";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateCargo"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Cargo</h4>
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