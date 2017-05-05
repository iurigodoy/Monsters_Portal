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
					<strong><form:errors path="fornecedor.nome_for"/></strong>
					<strong><form:errors path="fornecedor.cnpj_for"/></strong>
					<strong><form:errors path="fornecedor.logo_for"/></strong>
					<strong><form:errors path="fornecedor.cep_for"/></strong>
					<strong><form:errors path="fornecedor.estado_for"/></strong>
					<strong><form:errors path="fornecedor.cidade_for"/></strong>
					<strong><form:errors path="fornecedor.endereco_for"/></strong>
					<strong><form:errors path="fornecedor.numero_for"/></strong>
					<strong><form:errors path="fornecedor.complemento_for"/></strong>
					<strong><form:errors path="fornecedor.email_for"/></strong>
					<strong><form:errors path="fornecedor.comercial_for"/></strong>

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
					  <input type="text" name="nome_for" class="form-control" placeholder="Nome" title="Nome" value="${ fornecedor.nome_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cnpj_for" class="form-control" placeholder="CPNJ" title="CPNJ" value="${ fornecedor.cnpj_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cep_for" class="form-control" placeholder="CEP" title="CEP" value="${ fornecedor.cep_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="estado_for" class="form-control" placeholder="Estado" title="Estado" value="${ fornecedor.estado_for }">
					  <select>
							<option value="">Estado
							<option value="AC">AC
							<option value="AL">AL
							<option value="AP">AP
							<option value="AM">AM
							<option value="BA">BA
							<option value="CE">CE
							<option value="DF">DF
							<option value="ES">ES
							<option value="GO">GO
							<option value="MA">MA
							<option value="MT">MT
							<option value="MS">MS
							<option value="MG">MG
							<option value="PA">PA
							<option value="PB">PB
							<option value="PR">PR
							<option value="PE">PE
							<option value="PI">PI
							<option value="RJ">RJ
							<option value="RN">RN
							<option value="RO">RO
							<option value="RS">RS
							<option value="RR">RR
							<option value="SC">SC
							<option value="SP">SP
							<option value="SE">SE
							<option value="TO">TO
						</select>
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cidade_for" class="form-control" placeholder="Cidade" title="Cidade" value="${ fornecedor.cidade_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="endereco_for" class="form-control" placeholder="Endereco" title="Endereco" value="${ fornecedor.endereco_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="numero_for" class="form-control" placeholder="Numero" title="Numero" value="${ fornecedor.numero_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="complemento_for" class="form-control" placeholder="Complemento" title="Complemento" value="${ fornecedor.complemento_for }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="comercial_for" class="form-control" placeholder="Comercial" title="Comercial" value="${ fornecedor.comercial_for }">
					</div>

					<!--	Input com ícone
							(Preferencial)  	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="email_for" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fornecedor.email_for }">
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