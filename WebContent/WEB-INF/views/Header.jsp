<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!-- iCheck -->
    <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
    <!-- Switchery -->
    <link href="<c:url value="/resources/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">

	<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">
    
    <!-- *************************** - - 
   			Configura��o Pessoal		
    - -  *************************** -->
    
  </head>

  <body class="nav-md">
    <div class="container">
      <div class="main_container">

<!-- <nav class="navbar navbar-inverse"> -->
<nav class="navbar navbar-inverse navbar-custom navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
	  <a class="navbar-brand navbar-logo" href="<c:url value="/index"/>">
		<img src="<c:url value="/resources/imagens/logo.jpg"/>" height="36" width="36" class="img-circle">
	  </a>
    </div>
			<!-- <div class="navbar-header"> -->
    		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			  <ul class="nav navbar-nav">
				<li class="${ contato_page }"><a href="<c:url value="/Contato"/>">Contato</a></li>
			  </ul>
			<form method="POST" action="<c:url value="/Procurar"/>" class="navbar-form navbar-left">
			  <div class="input-group">
				<input type="text" name="nome_prod" maxlength="30" required pattern="^[A-Za-z�������������������������������0-9 ]+$" class="form-control" title="escreva o que voc� deseja pesquisar" value="">
			  	<div class="input-group-btn">
					<button class="btn btn-new btn-primary" title="Pesquisar"><span class="glyphicon glyphicon-search"></span> Procurar</button>
				</div>
			  </div>
			</form>
			  <ul class="nav navbar-nav navbar-right">
				  <c:if test="${empty clienteLogado.email_cli}">
					<li class="${ cadastro_page }"><a href="<c:url value="/Cadastro"/>">Cadastre-se</a></li>
					<li class="${ login_page }"><a href="<c:url value="/Login"/>"><i class="glyphicon glyphicon-log-in"></i> Login</a></li>
				  </c:if>
				  <c:if test="${not empty clienteLogado.email_cli}">
					<li class="${ usuario_page }"><a href="<c:url value="/MinhaConta"/>"><i class="glyphicon glyphicon-user"></i> ${clienteLogadoInfo.nome_cli}</a></li>
					<li class="${ carrinho_page }"><a href="<c:url value="/carrinho"/>"><i class="glyphicon glyphicon-shopping-cart"></i> Carrinho</a></li>
					<li><a href="<c:url value="/Logout"/>"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
				  </c:if>
			  </ul>
			</div>
		  </div>
		</nav>

		<div class="nav-fix-top"></div>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">