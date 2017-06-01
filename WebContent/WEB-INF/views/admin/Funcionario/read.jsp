<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-user"></i> Funcionário</h3>
              </div>
            </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="funcionario.nome_fun"/></strong>
					<strong><form:errors path="funcionario.foto_fun"/></strong>
					<strong><form:errors path="funcionario.cpf_fun"/></strong>
					<strong><form:errors path="funcionario.email_fun"/></strong>
					<strong><form:errors path="funcionario.senha_fun"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
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
	                          <th style="width: 20%">Foto</th>
	                          <th style="width: 20%">Nome</th>
	                          <th style="width: 25%">Contato</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="fun" items="${funcionarios}">
							<!--			^^^^			^^^^	-->
					  		
					  		<c:if test="${ not fun.deleted }">
	                      	  <tr id="tr_${ fun.id_funcionario }" data-history="1">
								<td><img src="<c:url value="/resources/imagens/funcionarios/${ fun.foto_fun }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td><strong>${ fun.nome_fun }</strong>
	                      	  	<br><small>${ fun.cargo.nome_car }</small>
	                      	  	<br><small>${ fun.cpf_fun }</small></td>
	                      	  	<td>${ fun.email_fun }<br>
								<small>Tel:</small> ${ fun.residencial_fun }
								<small>Cel:</small> ${ fun.celular_fun }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ fun.id_funcionario }">
					                  <button type="button" data-id="${ fun.id_funcionario }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ fun.id_funcionario }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
									<br>
	                      	  	  	<c:if test="${ not fun.bloqueado_fun }">
										<button type="button" data-id="${ fun.id_funcionario }" class="btn btn-danger btn-sm"
											title="Bloquear"><i class="fa fa-unlock"></i></button>
	                      	  	  	</c:if>
	                      	  	  	<c:if test="${ fun.bloqueado_fun }">
										<button type="button" data-id="${ fun.id_funcionario }" class="btn btn-success btn-sm"
											title="Desbloquear"><i class="fa fa-lock"></i></button>
	                      	  	  	</c:if>
									<a href="<c:url value="/Admin/ProcurarRelatorios/${ fun.id_funcionario }"/>" target="blank" class="btn btn-default btn-sm"
										title="Relatório"><i class="fa fa-file-text-o"></i> Relatório</a>
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ fun.deleted }">
	                      	  <tr id="tr_${ fun.id_funcionario }" data-history="0">
								<td><img src="<c:url value="/resources/imagens/funcionarios/${ fun.foto_fun }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td><strong>${ fun.nome_fun }</strong>
	                      	  	<br><small>${ fun.cargo.nome_car }</small>
	                      	  	<br><small>${ fun.cpf_fun }</small></td>
	                      	  	<td>${ fun.email_fun }<br>
								<small>Tel:</small> ${ fun.residencial_fun }
								<small>Cel:</small> ${ fun.celular_fun }</td>
	                      	  	<td>
					              	<button type="button"							 data-id="${ fun.id_funcionario }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ fun.id_funcionario }">
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
                    <h2><i class="fa fa-plus"></i> Adicionar <small>Funcionario</small></h2>
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
					<form action="<c:url value="CreateFuncionario"/>" method="POST" class="form-horizontal form-label-left input_mask">

                      <input type="hidden" name="foto_fun" value="teste.jpg">

                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="nome_fun" class="form-control" placeholder="Nome" title="Nome" value="${ funcionario.nome_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="cpf_fun" class="form-control" placeholder="CPF" title="CPF" value="${ funcionario.cpf_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="celular_fun" class="form-control has-feedback-left" placeholder="Celular" title="Celular" value="${ funcionario.celular_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-phone"></i></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="email_fun" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ funcionario.email_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="senha_fun" class="form-control has-feedback-left" placeholder="Senha" title="Senha" value="123456" readonly>
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-lock"></i></span>
                      </div>
                      
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
	                        <select name="cargo.id_cargo" class="form-control">
							  <option value="" selected>Cargo</option>
						  	  <c:forEach var="cargo" items="${cargos}">
	                          	<option value="${ cargo.id_cargo }">${ cargo.nome_car }</option>
	                          </c:forEach>
	                        </select>
						  <p>Não encontrou o cargo certo? <a href="<c:url value="/Admin/cargo"/>" title="Editar Cargos">Clique aqui</a></p>
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

	edition_param	= "FindFuncionario";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este funcionário?';	// Delete Message
	delete_param	= "DeleteFuncionario";						// Delete Controller Function
	restore_param	= "RestoreFuncionario";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateFuncionario"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Funcionário</h4>
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