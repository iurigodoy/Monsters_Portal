<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-truck"></i> Fornecedor</h3>
              </div>
            </div>

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
                    <h2><i class="fa fa-pencil-square-o"></i> Editar <small class="restore-info blue">� necess�rio <strong>atualizar</strong> a p�gina para as atualiza��es entrarem em vigor.</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a class="toolbox-history"><i class="fa fa-history"></i> Exibir Hist�rico</a>
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
	                          <th style="width: 25%">Localiza��o</th>
	                          <th style="width: 20%">Contato</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="forn" items="${fornecedores}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not forn.deleted }">
	                      	  <tr id="tr_${ forn.id_fornecedor }" data-history="1">
	                      	  	<td><strong>${ forn.nome_for }</strong><br><small>${ forn.cnpj_for }</small></td>
	                      	  	<td>${ forn.cep_for } 
	                      	  	<br> ${ forn.cidade_for } - ${ forn.estado_for }
	                      	  	<br> ${ forn.endereco_for }
	                      	  	<br> ${ forn.complemento_for }</td>
	                      	  	<td>${ forn.email_for }<br><small>Tel:</small>${ forn.comercial_for }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ forn.id_fornecedor }">
	                      	  	    <c:if test="${ permissao.atualizarFornecedor }">
					                  <button type="button" data-id="${ forn.id_fornecedor }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
					                </c:if>
	                      	  	    <c:if test="${ permissao.excluirFornecedor }">
						              <button type="button" data-id="${ forn.id_fornecedor }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									</c:if>
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ forn.deleted }">
	                      	  <tr id="tr_${ forn.id_fornecedor }" data-history="0">
	                      	  	<td><strong>${ forn.nome_for }</strong><br><small>${ forn.cnpj_for }</small></td>
	                      	  	<td>${ forn.cep_for } 
	                      	  	<br> ${ forn.cidade_for } - ${ forn.estado_for }
	                      	  	<br> ${ forn.endereco_for }
	                      	  	<br> ${ forn.complemento_for }</td>
	                      	  	<td>${ forn.email_for }<br><small>Tel:</small>${ forn.comercial_for }</td>
	                      	  	<td>
	                      	  	  <c:if test="${ permissao.restaurarFornecedor }">
					              	<button type="button"							 data-id="${ forn.id_fornecedor }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ forn.id_fornecedor }">
									<!--													 (2) ^^^^^^^^^^^^^^^^^^^	-->
					              	<i class="fa fa-refresh"></i> Restaurar</button>
					              </c:if>
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

	        <c:if test="${ permissao.criarFornecedor }">
              <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Adicionar <small>Fornecedor</small></h2>
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
					
							Formul�rio Create Aqui !!! -->
					<!--		Formul�rio		-->
					<form action="<c:url value="CreateFornecedor"/>" method="POST" class="form-horizontal form-label-left input_mask">

						<input type="hidden" name="logo_for" value="teste.jpg">
						<!--	Input sem �cone 	-->
						<div class="col-md-12 col-sm-12 col-xs-12 form-group">
						  <input type="text" name="nome_for" class="form-control" placeholder="Nome" title="Nome" value="${ fornecedor.nome_for }">
						</div>
						
						<div class="col-md-12 col-sm-12 col-xs-12 form-group">
						  <input type="text" name="cnpj_for" class="form-control" placeholder="CPNJ" title="CPNJ" value="${ fornecedor.cnpj_for }">
						</div>
						
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="cep_for" class="form-control" placeholder="CEP" title="CEP" value="${ fornecedor.cep_for }">
						</div>
						
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
											<select class="form-control" name="estado_for">
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
						
						<div class="col-md-9 col-sm-9 col-xs-12 form-group">
						  <input type="text" name="endereco_for" class="form-control" placeholder="Endereco" title="Endereco" value="${ fornecedor.endereco_for }">
						</div>
						
						<div class="col-md-3 col-sm-3 col-xs-12 form-group">
						  <input type="text" name="numero_for" class="form-control" placeholder="Numero" title="Numero" value="${ fornecedor.numero_for }">
						</div>
						
						<div class="col-md-12 col-sm-12 col-xs-12 form-group">
						  <input type="text" name="complemento_for" class="form-control" placeholder="Complemento" title="Complemento" value="${ fornecedor.complemento_for }">
						</div>
						
						<div class="col-md-12 col-sm-12 col-xs-12 form-group">
						  <input type="text" name="comercial_for" class="form-control has-feedback-left" placeholder="Comercial" title="Comercial" value="${ fornecedor.comercial_for }">
						  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-phone"></i></span>
						</div>
						
						<!--	Input com �cone
								(Preferencial)  	-->
						<div class="col-md-12 col-sm-12 col-xs-12 form-group">
						  <input type="text" name="email_for" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fornecedor.email_for }">
						  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
						</div>


						<!--	Bot�o de envio	-->
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
            </c:if>
            </div>

<script type="text/javascript">

	edition_param	= "FindFornecedor";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este fornecedor?';	// Delete Message
	delete_param	= "DeleteFornecedor";						// Delete Controller Function
	restore_param	= "RestoreFornecedor";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateFornecedor"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">�</span>
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