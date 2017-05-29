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
    <style>
    	.navbar{
    		-webkit-box-shadow: 0px 10px 20px -10px rgba(0,0,0,0.75);
			-moz-box-shadow: 0px 10px 20px -10px rgba(0,0,0,0.75);
			box-shadow: 0px 10px 20px -10px rgba(0,0,0,0.75);
    	}
    	.navbar-white{
    		background-color: white;
    	}
    	.navbar-brand{
    		padding-top: 1px;
    		padding-bottom: 0px;
    		height: 60px;
    	}
    	.nav >li >a {
		  padding-top: 20px;
		  padding-bottom: 20px;
		}
		.navbar-collapse > .navbar-form {
		  padding-top: 5px;
		  padding-bottom: 5px;
		}
		.navbar-nav > li > a, .navbar-brand, .navbar-nav > li > a {
		  color: #1aa3ff !important; }
		  
		  .nome_produto {
			  max-width: 300px;
			  overflow: hidden;
			  text-overflow: ellipsis;
			  white-space: nowrap;
			}
			
		.dropdown > a {
			color: #1aa3ff !important;
		}
		/*.container{
		width: 100%;
		padding: 0px;
		margin: 0px;
		}*/
			.banner_img{
				padding-left: 4px;
				max-height: 530px;
			}
			
			.escolha-panel{
				padding: 0px 50px 12px 50px;
			}
				#myCarousel .carousel-inner{
					margin-top: 10px;
					margin-bottom: 20px;
				}
				#myCarousel .carousel-indicators{
					padding: 0px 16px 0px 16px;
				}
		        #myCarousel .carousel-indicators li {
		        	border: 1px;
		        	border-style: solid;
		        	border-color: #ddd;
		        	-webkit-border-radius: 2px;
					-moz-border-radius: 2px;
					border-radius: 2px;
					margin: 0px 2px 0px 2px !important;
		        }
	
		.escolher-fornecedor > a:hover{
			color: #444;
		}
		
		.preco_desconto{
			text-decoration: line-through;
			color: #999;
		}
		.preco{
			font-size: 42px;
			font-weight: bold;
			color: #222;
		}
		.btn-comprar{
			widht: 100%;
			border-radius: 0px;
			background-color: #e60014;
			font-weight: bold;
			font-size: 24px;
		}
		.input-group{
			margin-bottom: 4px;
		}
			.frete-label{
				font-weight: normal;
				color: #4e6973;
			}
		.spin-load{
			visibility: hidden;
		}
		
    </style>
    
  </head>

<body>

<!-- <nav class="navbar navbar-inverse"> -->
<nav class="navbar navbar-white">
  <div class="container"><!-- -fluid -->
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
	  <a class="navbar-brand" href="<c:url value="/index"/>"><!--  567 174 -->
		<img src="<c:url value="/resources/imagens/logo.jpg"/>" height="58" width="189">
	  </a>
    </div>
			  <ul class="nav navbar-nav navbar-left">
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Categorias</a>
                        <ul class="dropdown-menu" role="menu">
						  <c:forEach var="cat" items="${categorias}">
						  <li><a href="<c:url value="/Categoria/${ cat.id_categoria }"/>">${ cat.nome_cat }</a>
                          </li>
						  </c:forEach>
                        </ul>
                      </li>
			  </ul>
			<!-- <div class="navbar-header"> -->
    		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<form method="POST" action="<c:url value="/Procurar"/>" class="navbar-form navbar-left">
			  <div class="input-group">
				<input type="text" name="nome_prod" maxlength="30" class="form-control" title="escreva o que você deseja pesquisar" value="" placeholder="Procurar">
			  	<div class="input-group-btn">
					<button class="btn btn-new btn-primary" title="Pesquisar"><span style="font-size: 20px" class="fa fa-search"></span></button>
				</div>
			  </div>
			</form>
			  <ul class="nav navbar-nav navbar-right">
				  <c:if test="${empty clienteLogado.email_cli}">
					<li><a href="<c:url value="/cadastro"/>">Cadastre-se</a></li>
					<li><a href="<c:url value="/login"/>"><i class="glyphicon glyphicon-log-in"></i> Login</a></li>
				  </c:if>
				  <c:if test="${not empty clienteLogado.email_cli}">
					<li><a href="<c:url value="/MinhaConta"/>"><i class="glyphicon glyphicon-user"></i> ${clienteLogado.nome_cli}</a></li>
					<li><a href="<c:url value="/logout"/>"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
				  </c:if>
				<li><a href="<c:url value="/carrinho"/>">
					<i class="fa fa-shopping-cart" style="font-size: 20px"></i>
				</a></li>
			  </ul>
			</div>
		  </div>
		</nav>

		<!-- <div class="nav-fix-top"></div> -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">