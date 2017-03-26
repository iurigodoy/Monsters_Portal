<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-group"></i> Funcionários </h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Procure por...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Vá!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-info"></i> Informações <small>dos Funcionários</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Funcionários Excluidos</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Funcionários e suas informações cadastrais
                    </p>
                    <table id="datatable-info" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Foto</td>
	                      <td>Nome</td>
	                      <td>CPF</td>
	                      <td>RG</td>
	                      <td>Cargo</td>
	                      <td>Ativo</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="funcionario" items="${funcionarios}">
	                        <tr>
	                          <td>${funcionario.foto_funcionario}</td>
	                          <td>${funcionario.nome_funcionario}</td>
	                          <td>${funcionario.cpf_funcionario}</td>
	                          <td>${funcionario.rg_funcionario}</td>
	                          <td>${funcionario.cargo.nome_cargo}</td>
	                          <td>${funcionario.bloqueado_funcionario}</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>
              
              
              
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-phone"></i> Contato <small>dos Funcionarios</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Funcionarios Excluidos</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                     Contato dos Funcionarios, e-mail, telefones residencial e celular.
                    </p>
                    <table id="datatable-contato" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Nome</td>
	                      <td>e-mail</td>
	                      <td>Tel. Residencial</td>
	                      <td>Tel. Celular</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="funcionario" items="${funcionarios}">
	                        <tr>
	                          <td>${funcionario.nome_funcionario}</td>
	                          <td>${funcionario.email_funcionario}</td>
	                          <td>${funcionario.residencial_funcionario}</td>
	                          <td>${funcionario.celular_funcionario}</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>
			  
			  
			  
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-globe"></i> Localização <small>dos Funcionários</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Funcionários Excluidos</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Funcionários e sua localização
                    </p>
                    <table id="datatable-local" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Nome</td>
	                      <td>CEP</td>
	                      <td>Estado</td>
	                      <td>Cidade</td>
	                      <td>Endereço</td>
	                      <td>Número</td>
	                      <td>Complemento</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="funcionario" items="${funcionarios}">
	                        <tr>
	                          <td>${funcionario.nome_funcionario}</td>
	                          <td>${funcionario.cep_funcionario}</td>
	                          <td>${funcionario.estado_funcionario}</td>
	                          <td>${funcionario.cidade_funcionario}</td>
	                          <td>${funcionario.endereco_funcionario}</td>
	                          <td>${funcionario.numero_funcionario}</td>
	                          <td>${funcionario.complemento_funcionario}</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />