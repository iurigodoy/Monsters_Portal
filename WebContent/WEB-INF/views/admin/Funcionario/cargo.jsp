<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-sitemap"></i> Cargos</h3>
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
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-eye"></i> Cargos</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					<c:forEach var="cargo" items="${cargos}">
						<div class="row">
							<div class="col-md-8 col-sm-6 col xs-6"><h4>${ car.nome_car }</h4></div>
		                    <div class="col-md-4 col-sm-6 col xs-6">
			                    <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
			                    <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
			                </div>
	                    </div>
                    </c:forEach>
                  </div>
                </div>
              </div>
              
              <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Cargo Padrão</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<p>Excluir um cargo, fará com que todos os funcionários pertencentes aquele cargo sejam transferidos ao cargo padrão.</p>
                  	<p>Defina um cargo Padrão.</p>
                  </div>
                </div>
              </div>
              
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Adicionar Cargo</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<input type="text" name="nome_car" class="form-control" placeholder="Nome do Cargo">
                  	<h4 align="center">Permissões</h4>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-cube"></i> Produto</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="produto_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="produto_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="produto_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="produto_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="produto_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="produto_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-user"></i> Cliente</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cliente_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cliente_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cliente_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cliente_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cliente_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cliente_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-road"></i> Pedido</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="pedido_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="pedido_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="pedido_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="pedido_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="pedido_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="pedido_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-truck"></i> Fornecedor</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="fornecedor_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="fornecedor_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="fornecedor_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="fornecedor_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="fornecedor_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="fornecedor_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-user"></i> funcionario</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="funcionario_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="funcionario_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="funcionario_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="funcionario_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="funcionario_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="funcionario_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-sitemap"></i> Cargo</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cargo_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cargo_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cargo_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cargo_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cargo_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="cargo_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4><i class="fa fa-clone"></i> Banner</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="banner_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="banner_add_permissao" class="js-switch"> <i class="fa fa-plus"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="banner_edt_permissao" class="js-switch"> <i class="fa fa-edit"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="banner_exc_permissao" class="js-switch"> <i class="fa fa-close"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="banner_hist_permissao" class="js-switch"> <i class="fa fa-history"></i>
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="banner_rest_permissao" class="js-switch"> <i class="fa fa-undo"></i>
	                  	  </label>
	                    </div>
	                </div>
                  	<div class="col-md-3 col-sm-4 col-xs-6">
	                  	<h4>Outros</h4>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="dashboard_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i> <i class="fa fa-bar-chart-o"></i> Dashboard
	                  	  </label>
	                    </div>
	                  	<div class="">
	                  	  <label>
	                  		<input type="checkbox" name="dashboard2_ler_permissao" class="js-switch"> <i class="fa fa-eye"></i> <i class="fa fa-file-text"></i> Relatórios
	                  	  </label>
	                    </div>
	                </div>
                  </div>
                </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />