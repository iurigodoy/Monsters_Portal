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
              <li class="red">N�O H� UPLOAD DE IMAGENS</li>	<!--	Mensagens para nós mesmos	-->
            </ul>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="fun.nome_fun"/></strong>
					<strong><form:errors path="fun.foto_fun"/></strong>
					<strong><form:errors path="fun.cpf_fun"/></strong>
					<strong><form:errors path="fun.email_fun"/></strong>
					<strong><form:errors path="fun.senha_fun"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Funcionários <small class="restore-info blue">É necessário <strong>atualizar</strong> a página para as atualizações entrarem em vigor.</small></h2>
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
	                          <th style="width: 10%">Cargo</th> <!-- ver se vai ficar aq mesmo -->
	                          <th style="width: 10%">Nome</th>
	                          <th style="width: 45%">CPF</th>
	                          <th style="width: 25%">Bloqueado</th>
	                          <th style="width: 25%">Foto</th>
	                          <th style="width: 25%">Residencial</th>
	                          <th style="width: 25%">Celular</th>
	                          <th style="width: 25%">E-mail</th>
	                          <th style="width: 25%">Senha</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="fun" items="${funcionarios}">
							<!--			^^^^			^^^^	-->
					  		${ fun.nome_fun }
					  		<c:if test="${ not fun.deleted }">
	                      	  <tr id="tr_${ fun.id_funcionario }" data-history="1">
	                      	  	<td>${ fun.cargo.nome_car }</td>
	                      	  	<td>${ fun.nome_fun }</td>
	                      	  	<td>${ fun.cpf_fun }</td>
	                      	  	<td>${ fun.bloqueado_fun }</td>
								<td><img src="<c:url value="resources/imagens/funcionarios/${ fun.foto_fun }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td>${ fun.residencial_fun }</td>
	                      	  	<td>${ fun.celular_fun }</td>
	                      	  	<td>${ fun.email_fun }</td>
	                      	  	<td>${ fun.senha_fun }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ fun.id_funcionario }">
					                  <button type="button" data-id="${ fun.id_funcionario }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ fun.id_funcionario }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
	                      	  
	                      	  
					  		<c:if test="${ fun.deleted }">
	                      	  <tr id="tr_${ fun.id_funcionario }" data-history="0">
	                      	  	
	                      	  	<td><img src="<c:url value="resources/imagens/funcionarios/${ fun.foto_fun }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td>${ fun.nome_fun }<br><small>${ fun.email_fun }<br></small>${ fun.cargo.nome_car } - Atendente</td>
	                      	  	
	                      	  	<td>
									<small>Criado em:	<fmt:formatDate value="${ fun.created_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Atualizado em:		<fmt:formatDate value="${ fun.updated_at }" pattern="dd/MM/yyyy HH:mm"/><br>
								    Apagado em:			<fmt:formatDate value="${ fun.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></small>
									<!--									  (3) ^^^^^^^^^^^^^^^	-->
	                      	  	</td>
	                      	  	
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
                    <h2><i class="fa fa-plus"></i> Funcionário</h2>
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

					<!--	Input sem ícone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="nome_fun" class="form-control" placeholder="Nome" title="Nome" value="${ fun.nome_fun }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cpf_fun" class="form-control" placeholder="CPF" title="CPF" value="${ fun.cpf_fun }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="celular_fun" class="form-control" placeholder="Celular" title="Celular" value="${ fun.celular_fun }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="senha_fun" class="form-control" placeholder="Senha" title="Senha" value="${ fun.senha_fun }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="foto_fun" class="form-control" placeholder="Foto" title="Foto" value="${ fun.foto_fun}">
					</div>
					<!--	Input com ícone
							(Preferencial)  	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="email_fun" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fun.email_fun }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
					</div>


					<!--	Select com
							Relacionamento		-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <select name="cargo.id_cargo" class="form-control">
						<option value="0">Cargo</option>
						<c:forEach var="cargo" items="${cargos}">
						  <option value="${ cargo.id_cargo }">${ cargo.nome_cargo }</option>
						</c:forEach>
					  </select>
					  <!-- exemplo para facilitar pro usuário -->
					  <p>Não encontrou o cargo certo? <a href="<c:url value="/cargo"/>" title="Editar Cargos">Clique aqui</a></p>
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

	edition_param	= "Find_Funcionario";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este funcionário?';	// Delete Message
	delete_param	= "DeleteFuncionario";						// Delete Controller Function
	restore_param	= "RestoreFuncionario";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="../resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateFuncionario"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">X</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Funcion�rio</h4>
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