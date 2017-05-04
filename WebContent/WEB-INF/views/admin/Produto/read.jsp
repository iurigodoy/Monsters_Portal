<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-building"></i> Empresa</h3>
              </div>
            </div>
            
            <ul>
              <li class="red">NÃO HÁ UPLOAD DE IMAGENS</li>	<!--	Mensagens para nós mesmos	-->
            </ul>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
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
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Produtos <small class="restore-info blue">É necessário <strong>atualizar</strong> a página para as atualizações entrarem em vigor.</small></h2>
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
	                          <th style="width: 10%">Categoria</th> <!-- ver se vai ficar aq mesmo a img -->
	                          <th style="width: 45%">Nome</th>
	                          <th style="width: 25%">Descrição</th>
	                          <th style="width: 25%">Categoria</th>
	                          <th style="width: 25%">Publicado</th>
	                          <th style="width: 25%">Destaque</th>
	                          <th style="width: 25%">Desconto</th>
	                          <th style="width: 25%">Promoção</th>
	                          <th style="width: 25%">Peso</th>
	                          <th style="width: 25%">Altura</th>
	                          <th style="width: 25%">Largura</th>
	                          <th style="width: 25%">Comprimento</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="pro" items="${produtos}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not pro.deleted }">
	                      	  <tr id="tr_${ pro.id_produto }" data-history="1">
								<td>${ pro.categoria.nome_cat }</td>
	                      	  	<td>${ pro.nome_pro }</td>
	                      	  	<td>${ pro.descricao_pro }</td>
	                      	  	<td>${ pro.publicado_pro }</td>
	                      	  	<td>${ pro.destaque_pro }</td>
								<td>${ pro.desconto_pro }</td>
								<td>${ pro.promocao_pro }</td>
	                      	  	<td>${ pro.peso_pro }</td>
	                      	  	<td>${ pro.altura_pro }</td>
	                      	  	<td>${ pro.largura_pro }</td>
	                      	  	<td>${ pro.comprimento_pro }</td>
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
	                      	  	
	                      	  	<td>${ pro.categoria.nome_cat }</td>
	                      	  	<td>${ pro.nome_pro }</td>
	                      	  	<td>${ pro.descricao_pro }</td>
	                      	  	<td>${ pro.publicado_pro }</td>
	                      	  	<td>${ pro.destaque_pro }</td>
								<td>${ pro.desconto_pro }</td>
								<td>${ pro.promocao_pro }</td>
	                      	  	<td>${ pro.peso_pro }</td>
	                      	  	<td>${ pro.altura_pro }</td>
	                      	  	<td>${ pro.largura_pro }</td>
	                      	  	<td>${ pro.comprimento_pro }</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:	<fmt:formatDate value="${ pro.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:		<fmt:formatDate value="${ pro.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:			<fmt:formatDate value="${ pro.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
									<!--									  (3) ^^^^^^^^^^^^^^^	-->
	                      	  	</td>
	                      	  	
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

              <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Produto</h2>
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
					<form action="<c:url value="CreateProduto"/>" method="POST" class="form-horizontal form-label-left input_mask">

					<!--	Input sem ícone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="nome_pro" class="form-control" placeholder="Nome" title="Nome" value="${ produto.nome_pro }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="descricao_pro" class="form-control" placeholder="Descricao" title="Descricao" value="${ produto.descricao_pro }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="desconto_pro" class="form-control" placeholder="Desconto" title="Desconto" value="${ produto.desconto_pro }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="peso_pro" class="form-control" placeholder="Peso" title="Peso" value="${ produto.peso_pro }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="altura_pro" class="form-control" placeholder="Altura" title="Altura" value="${ produto.altura_pro }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="largura_pro" class="form-control" placeholder="Largura" title="Largura" value="${ produto.largura_pro }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="comprimento_pro" class="form-control" placeholder="Comprimento" title="Comprimento" value="${ produto.comprimento_pro }">
					</div>




					<!--	Booleano	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="publicado_pro" class="js-switch"   title="Produto Publicado" value="${ produto.publicado_pro }"> <i class="fa fa-plus"></i> Produto Publicado ?
					  </label>
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="destaque_pro" class="js-switch"   title="Produto Destaque" value="${ produto.destaque_pro }"> <i class="fa fa-plus"></i> Produto Destaque ?
					  </label>
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="promocao_pro" class="js-switch"   title="Promocao" value="${ produto.promocao_pro }"> <i class="fa fa-plus"></i> Produto em Promoção ?
					  </label>
					</div>
					<!--	Select com
							Relacionamento		-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <select type="hidden"name="imagem.id_imagem" class="form-control">
						<option value="0">Imagem</option>
						<!-- foreach de imagem -->
					  </select>
					  <!-- exemplo para facilitar pro usuário -->
					  <p>Não encontrou a imagem certa? <a href="<c:url value="/imagem"/>" title="Editar Imagens">Clique aqui</a></p>
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

	edition_param	= "Find_Produto";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este produto?';	// Delete Message
	delete_param	= "DeleteProduto";						// Delete Controller Function
	restore_param	= "RestoreProduto";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateProduto"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
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