<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-truck"></i> Fornecedores </h3>
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
                    <h2><i class="fa fa-align-left"></i> Descrição <small>dos Fornecedores</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Fornecedores Excluidos</a>
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
                     Descrição dos Fornecedores, Logo, Razão Social, Objetivo e CNPJ.
                    </p>
                    <table id="datatable-descricao" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Logo</td>
	                      <td>Razão</td>
	                      <td>Objetivo</td>
	                      <td>CNPJ</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="fornecedor" items="${fornecedores}">
	                        <tr>
	                          <td>${for.logo_for}</td>
	                          <td>${for.razao_for}</td>
	                          <td>${for.objetivo_for}</td>
	                          <td>${for.cnpj_for}</td>
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
                    <h2><i class="fa fa-phone"></i> Contato <small>dos Fornecedores</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Fornecedores Excluidos</a>
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
                     Contato dos Fornecedores, e-mail, telefones residencial, corporativo e celular.
                    </p>
                    <table id="datatable-contato" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Razão</td>
	                      <td>e-mail</td>
	                      <td>Tel. Residencial</td>
	                      <td>Tel. Celular</td>
	                      <td>Tel. Corporativo</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="fornecedor" items="${fornecedores}">
	                        <tr>
	                          <td>${for.razao_for}</td>
	                          <td>${for.email_for}</td>
	                          <td>${for.residencial_for}</td>
	                          <td>${for.celular_for}</td>
	                          <td>${for.comercial_for}</td>
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
                    <h2><i class="fa fa-globe"></i> Localização <small>dos Fornecedores</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Fornecedores Excluidos</a>
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
                     Localização dos Fornecedores, com CEP e endereço completo.
                    </p>
                    <table id="datatable-local" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Razão</td>
	                      <td>CEP</td>
	                      <td>Estado</td>
	                      <td>Cidade</td>
	                      <td>Endereço</td>
	                      <td>Nº</td>
	                      <td>Complemento</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="fornecedor" items="${fornecedores}">
	                        <tr>
	                          <td>${for.razao_forn}</td>
	                          <td>${for.cep_forn}</td>
	                          <td>${for.estado_for}</td>
	                          <td>${for.cidade_for}</td>
	                          <td>${for.endereco_for}</td>
	                          <td>${for.numero_for}</td>
	                          <td>${for.complemento_for}</td>
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