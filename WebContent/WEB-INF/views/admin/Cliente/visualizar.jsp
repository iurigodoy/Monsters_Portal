<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-group"></i> Clientes </h3>
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
                    <h2><i class="fa fa-user"></i> Pessoa Física <small>Clientes Comuns</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Clientes Excluidos</a>
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
                      Clientes 
                    </p>
                    <table id="datatable-fisica" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Nome</td>
	                      <td>e-mail</td>
	                      <td>Telefone</td>
	                      <td>Celular</td>
	                      <td>Sexo</td>
	                      <td>CPF</td>
	                      <td>Ativo</td>
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
						<c:forEach var="cliente" items="${clientes}">
	                        <tr>
	                          <td>${cliente.nome_cliente}</td>
	                          <td>${cliente.email_cliente}</td>
	                          <td>${cliente.residencial_cliente}</td>
	                          <td>${cliente.celular_cliente}</td>
	                          <td>${cliente.sexo_cliente}</td>
	                          <td>${cliente.cpf_cliente}</td>
	                          <td>${cliente.ativo_cliente}</td>
	                          <td>${cliente.cep_cliente}</td>
	                          <td>${cliente.estado_cliente}</td>
	                          <td>${cliente.cidade_cliente}</td>
	                          <td>${cliente.endereco_cliente}</td>
	                          <td>${cliente.numero_cliente}</td>
	                          <td>${cliente.complemento_cliente}</td>
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
                    <h2><i class="fa fa-university"></i> Pessoa Jurídica <small>Empresa</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir Clientes Excluidos</a>
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
                      Clientes Empresariais
                    </p>
                    <table id="datatable-juridica" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Razão</td>
	                      <td>Objetivo</td>
	                      <td>e-mail</td>
	                      <td>Telefone</td>
	                      <td>Celular</td>
	                      <td>CNPJ</td>
	                      <td>Ativo</td>
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
						<c:forEach var="cliente" items="${clientes}">
	                        <tr>
	                          <td>${cliente.razao_cliente}</td>
	                          <td>${cliente.objetivo_cliente}</td>
	                          <td>${cliente.email_cliente}</td>
	                          <td>${cliente.residencial_cliente}</td>
	                          <td>${cliente.celular_cliente}</td>
	                          <td>${cliente.cnpj_cliente}</td>
	                          <td>${cliente.ativo_cliente}</td>
	                          <td>${cliente.cep_cliente}</td>
	                          <td>${cliente.estado_cliente}</td>
	                          <td>${cliente.cidade_cliente}</td>
	                          <td>${cliente.endereco_cliente}</td>
	                          <td>${cliente.numero_cliente}</td>
	                          <td>${cliente.complemento_cliente}</td>
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