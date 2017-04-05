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
					<strong><form:errors path="cliente.cli_nome"/></strong>
					<strong><form:errors path="cliente.cli_cpf"/></strong>
					<strong><form:errors path="cliente.cli_cnpj"/></strong>
					<strong><form:errors path="cliente.cli_sexo"/></strong>
					<strong><form:errors path="cliente.cli_senha"/></strong>
					<strong><form:errors path="cliente.cli_cep"/></strong>
					<strong><form:errors path="cliente.cli_estado"/></strong>
					<strong><form:errors path="cliente.cli_cidade"/></strong>
					<strong><form:errors path="cliente.cli_endereco"/></strong>
					<strong><form:errors path="cliente.cli_numero"/></strong>
					<strong><form:errors path="cliente.cli_complemento"/></strong>
					<strong><form:errors path="cliente.cli_residencial"/></strong>
					<strong><form:errors path="cliente.cli_celular"/></strong>
					<strong><form:errors path="cliente.cli_email"/></strong>
					<strong><form:errors path="cliente.ativo_cli"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Clientes <small class="restore-info blue">É necessário <strong>atualizar</strong> a página para as atualizações entrarem em vigor.</small></h2>
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
							  <th style="width: 10%">CPF</th>
	                          <th style="width: 25%">CNPJ</th>
	                          <th style="width: 25%">Sexo</th>
	                          <th style="width: 25%">Ativo</th>
	                          <th style="width: 25%">Senha</th>
	                          <th style="width: 25%">News Letter</th>
	                          <th style="width: 25%">CEP</th>
	                          <th style="width: 25%">Estado</th>
	                          <th style="width: 25%">Cidade</th>
	                          <th style="width: 25%">Endereço</th>
	                          <th style="width: 25%">Número</th>
	                          <th style="width: 25%">Complemento</th>
	                          <th style="width: 25%">Residencial</th>
	                          <th style="width: 25%">Celular</th>
	                          <th style="width: 25%">E-mail</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="cli" items="${clis}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not cli.deleted }">
	                      	  <tr id="tr_${ cli.id_cliente }" data-history="1">	
	                      	  	<td>${ cli.nome_cli }</td>
	                      	  	<td>${ cli.cpf_cli }</td>
	                      	  	<td>${ cli.cnpj_cli }</td>
	                      	  	<td>${ cli.sexo_cli }</td>
	                      	  	<td>${ cli.ativo_cli }</td>
	                      	  	<td>${ cli.senha_cli }</td>
	                      	  	<td>${ cli.news_letter_cli }</td>
	                      	  	<td>${ cli.cep_cli }</td>
	                      	  	<td>${ cli.estado_cli }</td>
	                      	  	<td>${ cli.cidade_cli }</td>
	                      	  	<td>${ cli.endereco_cli }</td>
	                      	  	<td>${ cli.numero_cli }</td>
	                      	  	<td>${ cli.complemento_cli }</td>
	                      	  	<td>${ cli.residencial_cli }</td>
	                      	  	<td>${ cli.celular_cli }</td>
	                      	  	<td>${ cli.email_cli }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ cli.id_cliente }">
					                  <button type="button" data-id="${ cli.id_cliente }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ cli.id_cliente }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ cli.deleted }">
	                      	  <tr id="tr_${ cli.id_cliente }" data-history="0">
             	  	
	                      	  	<td>${ cli.cli_nome }</td>
	                      	  	<td>${ cli.cli_cpf }</td>
	                      	  	<td>${ cli.cli_cnpj }</td>
	                      	  	<td>${ cli.cli_sexo }</td>
	                      	  	<td>${ cli.cli_ativo }</td>
	                      	  	<td>${ cli.cli_senha }</td>
	                      	  	<td>${ cli.cli_news_letter }</td>
	                      	  	<td>${ cli.cli_cep }</td>
	                      	  	<td>${ cli.cli_estado }</td>
	                      	  	<td>${ cli.cli_cidade }</td>
	                      	  	<td>${ cli.cli_endereco }</td>
	                      	  	<td>${ cli.cli_numero }</td>
	                      	  	<td>${ cli.cli_complemento }</td>
	                      	  	<td>${ cli.cli_residencial }</td>
	                      	  	<td>${ cli.cli_celular }</td>
	                      	  	<td>${ cli.cli_email }</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:	<fmt:formatDate value="${ cli.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:		<fmt:formatDate value="${ cli.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:			<fmt:formatDate value="${ cli.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
									<!--									  (3) ^^^^^^^^^^^^^^^	-->
	                      	  	</td>
	                      	  	
	                      	  	<td>
					              	<button type="button"							 data-id="${ cli.id_cliente }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ cli.id_cliente }">
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
                    <h2><i class="fa fa-plus"></i> Cliente</h2>
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
					<form action="<c:url value="CreateCliente"/>" method="POST" class="form-horizontal form-label-left input_mask">


					<!--	Input sem ícone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_nome" class="form-control" placeholder="Nome" title="Nome" value="${ cliente.cli_nome }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_cpf" class="form-control" placeholder="CPF" title="CPF" value="${ cliente.cli_cpf }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_cnpj" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ cliente.cli_cnpj }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_sexo" class="form-control" placeholder="Sexo" title="Sexo" value="${ cliente.cli_sexo }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_senha" class="form-control" placeholder="Senha" title="Senha" value="${ cliente.cli_senha }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_cep" class="form-control" placeholder="CEP" title="CEP" value="${ cliente.cli_cep }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_estado" class="form-control" placeholder="Estado" title="Estado" value="${ cliente.cli_estado }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_cidade" class="form-control" placeholder="Cidade" title="Cidade" value="${ cliente.cli_cidade }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_endereco" class="form-control" placeholder="Endereco" title="Endereco" value="${ cliente.cli_endereco }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_numero" class="form-control" placeholder="Numero" title="Numero" value="${ cliente.cli_numero }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_complemento" class="form-control" placeholder="Complemento" title="Complemento" value="${ cliente.cli_complemento }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_residencial" class="form-control" placeholder="Residencial" title="Residencial" value="${ cliente.cli_residencial }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_celular" class="form-control" placeholder="Celular" title="Celular" value="${ cliente.cli_celular }">
					</div>

					<!--	Input com ícone
							(Preferencial)  	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cli_email" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ cliente.cli_email }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
					</div>


					<!--	Booleano	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="ativo_cli" class="js-switch" title="Cliente Ativo" value="${ cliente.ativo_cli }"> <i class="fa fa-plus"></i> Cliente Ativo 
					  </label>
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

	edition_param	= "Find_Cliente";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este cliente?';	// Delete Message
	delete_param	= "DeleteCliente";						// Delete Controller Function
	restore_param	= "RestoreCliente";						// Restore Controller Function

</script>

<c:import url="../../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateCliente"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Cliente</h4>
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