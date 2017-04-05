<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../../Header.jsp" />

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
					<strong><form:errors path="fornecedor.for_nome"/></strong>
					<strong><form:errors path="fornecedor.for_cnpj"/></strong>
					<strong><form:errors path="fornecedor.for_logo"/></strong>
					<strong><form:errors path="fornecedor.for_cep"/></strong>
					<strong><form:errors path="fornecedor.for_estado"/></strong>
					<strong><form:errors path="fornecedor.for_cidade"/></strong>
					<strong><form:errors path="fornecedor.for_endereco"/></strong>
					<strong><form:errors path="fornecedor.for_numero"/></strong>
					<strong><form:errors path="fornecedor.for_complemento"/></strong>
					<strong><form:errors path="fornecedor.for_email"/></strong>
					<strong><form:errors path="fornecedor.for_comercial"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Fornecedores <small class="restore-info blue">É necessário <strong>atualizar</strong> a página para as atualizações entrarem em vigor.</small></h2>
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
							  <th style="width: 45%">Nome</th>
	                          <th style="width: 10%">CNPJ</th>
	                          <th style="width: 45%">Logo</th>
	                          <th style="width: 25%">CEP</th>
	                          <th style="width: 25%">Estado</th>
	                          <th style="width: 25%">Cidade</th>
	                          <th style="width: 25%">Endereço</th>
	                          <th style="width: 25%">Número</th>
	                          <th style="width: 25%">Complemento</th>
	                          <th style="width: 25%">E-mail</th>
	                          <th style="width: 25%">Comercial</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="for" items="${fors}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not for.deleted }">
	                      	  <tr id="tr_${ for.id_fornecedor }" data-history="1">
	                      	  	<td>${ for.nome_for }</td>
	                      	  	<td>${ for.cnpj_for }</td>
	                      	  	<td>${ for.logo_for }</td>
	                      	  	<td>${ for.cep_for }</td>
	                      	  	<td>${ for.estado_for }</td>
	                      	  	<td>${ for.cidade_for }</td>
								<td>${ for.endereco_for }</td>
								<td>${ for.numero_for }</td>
	                      	  	<td>${ for.complemento_for }</td>
	                      	  	<td>${ for.email_for }</td>
	                      	  	<td>${ for.comercial_for }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ for.id_fornecedor }">
					                  <button type="button" data-id="${ for.id_fornecedor }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ for.id_fornecedor }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ for.deleted }">
	                      	  <tr id="tr_${ for.id_fornecedor }" data-history="0">
	                      	  	
	                      	  	<td>${ for.nome_for }</td>
	                      	  	<td>${ for.cnpj_for }</td>
	                      	  	<td>${ for.logo_for }</td>
	                      	  	<td>${ for.cep_for }</td>
	                      	  	<td>${ for.estado_for }</td>
	                      	  	<td>${ for.cidade_for }</td>
								<td>${ for.endereco_for }</td>
								<td>${ for.numero_for }</td>
	                      	  	<td>${ for.complemento_for }</td>
	                      	  	<td>${ for.email_for }</td>
	                      	  	<td>${ for.comercial_for }</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:	<fmt:formatDate value="${ for.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:		<fmt:formatDate value="${ for.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:			<fmt:formatDate value="${ for.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
									<!--									  (3) ^^^^^^^^^^^^^^^	-->
	                      	  	</td>
	                      	  	
	                      	  	<td>
					              	<button type="button"							 data-id="${ for.id_fornecedor }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ for.id_fornecedor }">
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
                    <h2><i class="fa fa-plus"></i> Fornecedor</h2>
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
					<form action="<c:url value="CreateFornecedor"/>" method="POST" class="form-horizontal form-label-left input_mask">

					<!--	Input sem ícone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_nome" class="form-control" placeholder="Nome" title="Nome" value="${ fornecedor.for_nome }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_cnpj" class="form-control" placeholder="CPNJ" title="CPNJ" value="${ fornecedor.for_cnpj }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_cep" class="form-control" placeholder="CEP" title="CEP" value="${ fornecedor.for_cep }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_estado" class="form-control" placeholder="Estado" title="Estado" value="${ fornecedor.for_estado }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_cidade" class="form-control" placeholder="Cidade" title="Cidade" value="${ fornecedor.for_cidade }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_endereco" class="form-control" placeholder="Endereco" title="Endereco" value="${ fornecedor.for_endereco }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_numero" class="form-control" placeholder="Numero" title="Numero" value="${ fornecedor.for_numero }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_complemento" class="form-control" placeholder="Complemento" title="Complemento" value="${ fornecedor.for_complemento }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_comercial" class="form-control" placeholder="Comercial" title="Comercial" value="${ fornecedor.for_comercial }">
					</div>

					<!--	Input com ícone
							(Preferencial)  	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="for_email" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fornecedor.for_email }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
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

	edition_param	= "Find_Fornecedor";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este fornecedor?';	// Delete Message
	delete_param	= "DeleteFornecedor";						// Delete Controller Function
	restore_param	= "RestoreFornecedor";						// Restore Controller Function

</script>

<c:import url="../../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateFornecedor"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Fornecedor</h4>
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