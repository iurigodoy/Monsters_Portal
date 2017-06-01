<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<title>Painel de Controle</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="/resources/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
    <!-- Dropzone.js -->
    <link href="<c:url value="/resources/vendors/dropzone/dist/min/dropzone.min.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="<c:url value="/resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"/>" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="<c:url value="/resources/vendors/google-code-prettify/bin/prettify.min.css"/>" rel="stylesheet">
    <!-- Switchery -->
    <link href="<c:url value="/resources/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">
    <!-- Select2 -->
    <link href="<c:url value="/resources/vendors/select2/dist/css/select2.min.css"/>" rel="stylesheet">
    <!-- Datatables -->
    <link href="<c:url value="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"/>" rel="stylesheet">
    
    <!-- bootstrap-daterangepicker -->
    <link href="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.css"/>" rel="stylesheet">
    
    <!-- Jquery Confirm -->
    <link href="<c:url value="/resources/vendors/jquery-confirm-master/dist/jquery-confirm.min.css"/>" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value="/resources/build/css/custom.min.css"/>" rel="stylesheet">
    
    <!-- *************************** - - 
   			Configuraï¿½ï¿½o Pessoal		
    - -  *************************** -->
    <style>
    	.restore-info{
    		visibility: hidden;
    	}
    </style>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-institution"></i> <span>Pentágono Portal</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="<c:url value="/resources/imagens/funcionarios/${ administradorLogado.foto_fun }"/>" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Bem Vindo(a),</span>
                <h2>${ administradorLogado.email_fun }</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>${ administradorLogado.cargo.nome_car }</h3>
                <ul class="nav side-menu">
	     			<li><a href="<c:url value="/Admin/dashboard"/>"><i class="fa fa-bar-chart-o"></i> Dashboard</a>
	                </li>
                      <li><a href="<c:url value="/Admin/pedido"/>"><i class="fa fa-road"></i> Pedidos</a>
	                  </li>
                      <li><a><i class="fa fa-cubes"></i> Produtos <span class="fa fa-chevron-down"></span></a>
	                    <ul class="nav child_menu">
                     	  <li><a href="<c:url value="/Admin/adicionar_produto"/>"><i class="fa fa-plus"></i> Adicionar</a></li>
                     	  <li><a href="<c:url value="/Admin/produto"/>"><i class="fa fa-edit"></i> Editar</a></li>
                     	  <li><a href="<c:url value="/Admin/categoria"/>"><i class="fa fa-th"></i> Categorias</a></li>
	                    </ul>
	                  </li>
                      <li><a href="<c:url value="/Admin/cliente"/>"><i class="fa fa-users"></i> Clientes</a>
                      </li>
	                  <li><a href="<c:url value="/Admin/fornecedor"/>"><i class="fa fa-truck"></i> Fornecedores</a>
	                  </li>
                  
                  
                  <li><a><i class="fa fa-users"></i> Funcionarios <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="<c:url value="/Admin/funcionario"/>"><i class="fa fa-eye"></i> Visualizar</a></li>
                      <li><a href="<c:url value="/Admin/cargo"/>"><i class="fa fa-sitemap"></i> Cargos</a></li>
                    </ul>
                  </li>
                  <li><a href="<c:url value="/Admin/banner"/>"><i class="fa fa-clone"></i> Banners</a>
                  </li>
                  <li><a><i class="fa fa-question"></i> HELP</a></li>
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="HELP!">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="<c:url value="/Admin/LogoutAdmin"/>">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="<c:url value="/resources/imagens/funcionarios/${ administradorLogado.foto_fun }"/>" alt="">${ administradorLogado.email_fun }
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <!-- <li><a href="javascript:;"> Perfil</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Configurações</span>
                      </a>
                    </li> -->
                    <li><a href="javascript:;"> Ajuda</a></li>
                    <li><a href="<c:url value="/Admin/LogoutAdmin"/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">