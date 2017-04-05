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
              <li class="red">NÃO HÁ UPLOAD DE IMAGENS</li>
            </ul>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
                    <strong><form:errors path="fun.nome_fun"/></strong>
                    <strong><form:errors path="fun.foto_fun"/></strong>
                    <strong><form:errors path="fun.cpf_fun"/></strong>
                    <strong><form:errors path="fun.email_fun"/></strong>
                    <strong><form:errors path="fun.login_fun"/></strong>
                    <strong><form:errors path="fun.senha_fun"/></strong>
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Funcionários</h2>
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
	                          <th style="width: 10%">Foto</th>
	                          <th style="width: 45%">Nome</th>
	                          <th style="width: 25%">Cargo</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="fun" items="${funcs}">
	                      	  <tr id="delete_row_${ fun.id_funcionario }">
	                      	  	<td><img src="<c:url value="resources/imagens/funcionarios/${ fun.foto_fun }"/>" class="avatar" alt="Foto"></td>
	                      	  	<td>${ fun.nome_fun }<br><small>${ fun.email_fun }</small></td>
	                      	  	<td><strong>${ fun.cargo.nome_cargo }</strong></td>
	                      	  	<td>
				                  <button type="button" data-id="${ fun.id_funcionario }" class="btn btn-primary btn-xs ModalFuncionario"
				                  		data-toggle="modal" data-target=".bs-funcionario-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
					              <button type="button" data-id="${ fun.id_funcionario }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
	                      	  	</td>
	                      	  </tr>
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
		          	<form action="<c:url value="CreateFuncionario"/>" method="POST" class="form-horizontal form-label-left input_mask">
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="nome_fun" class="form-control" placeholder="Nome" title="Nome" value="${ funcionario.nome_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="foto_fun" class="form-control" placeholder="Foto" title="Foto" value="${ funcionario.foto_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="cpf_fun" class="form-control" placeholder="CPF" title="CPF" value="${ funcionario.cpf_fun }">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="email_fun" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ funcionario.email_func }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
                      </div>
                      
                      
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
	                        <select name="car.id_cargo" class="form-control">
	                          <option value="0">Cargo</option>
						  	  <c:forEach var="cargo" items="${cargos}">
	                          	<option value="${ car.id_cargo }">${ car.nome_car }</option>
	                          </c:forEach>
	                        </select>
						  <p>Não encontrou o cargo certo? <a href="<c:url value="/cargo"/>" title="Editar Cargos">Clique aqui</a></p>
                      </div>
                      
                      
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <select name="ramal.id_ramal" class="form-control">
                          <option value="0">Ramal</option>
					  	  <c:forEach var="ramal" items="${ramais}">
                          	<option value="${ ramal.id_ramal }">${ ramal.numero_ram }</option>
                          </c:forEach>
                        </select>
						<p>Não encontrou o ramal? <a href="<c:url value="/Setores_Ramais"/>" title="Editar Setores e Ramais">Clique aqui</a></p>
                      </div>
                      
                      
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="text" name="login_fun" class="form-control has-feedback-left" placeholder="Usuário" title="Login" value="${ fun.login_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-user"></i></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                        <input type="password" name="senha_fun" class="form-control has-feedback-left" placeholder="Senha" title="Senha" value="${ fun.senha_fun }">
				        <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-lock"></i></span>
                      </div>
					  <div class="btn-group pull-right">
						<button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
						  <i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
						</button>
					  </div>
		          	</form>
                  </div>
                </div>
              </div>
            </div>

<c:import url="../../Footer.jsp" />

<div class="modal fade bs-funcionario-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateFuncionario"/>" method="POST" class="form-horizontal form-label-left input_mask">

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel">Funcionário</h4>
	    </div>
	    <div class="modal-body">
	                          
	    	<div id="conteudo_funcionario"></div>
	                          
	    </div>
	    <div class="modal-footer">
	    	<button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
	        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Salvar</button>
	    </div>

	  </form>
	</div>
  </div>
</div>



<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/edt_modal/funcionario.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="resources/js/history/funcionario.js"/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value="resources/js/delete/funcionario.js"/>"></script>