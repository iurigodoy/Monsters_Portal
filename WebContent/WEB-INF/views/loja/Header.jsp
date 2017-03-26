<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Monsters Portal</title>
	
    <!-- Bootstrap -->
    <link href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!--==========	maskedinput_plugin(Insere mascaras nos campos)	==========-->
	<script src="<c:url value="/resources/includes/jquery.maskedinput.js"/>" type="text/javascript"></script>
	
	<!--==========	JQuery ui(tema do jquery, usado para efeitos)	==========-->
	<script src="<c:url value="/resources/includes/jquery-ui/jquery-ui.js"/>"></script>
	<link rel="stylesheet" href="<c:url value="/resources/includes/jquery-ui/jquery-ui.css"/>">
	
	<!--==========				Minhas configurações				==========-->
	<script src="<c:url value="/resources/js/mask.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/loja.conf.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/estilo.css"/>">
</head>


<style type="text/css">
	.img_prod_container {
		max-width:180px;
		/*max-height:120px;*/
		width: auto;
		height: 120px;
	}

</style>


<body ondragstart="return false;" ondrop="return false;">
  <div class="container">
	<nav class="navbar navbar-defaut menu-superior">
	  <div class="container-fluid">
		<div class="navbar-header">
		  <ul class="nav navbar-nav menu-superior-logo">
		  
			<li>
			  <a class="navbar-brand menu-superior-logo" href="<c:url value="/index"/>">
				<img src="<c:url value="/resources/imagens/logo.jpg"/>" height="36" width="36" >
			  </a>
			</li>
			
		  </ul>
		  <ul class="nav navbar-nav">
			<li class="${ contato_page }"><a href="<c:url value="/Contato"/>">Contato</a></li>
		  </ul>
		<form method="POST" action="<c:url value="/Procurar"/>" class="navbar-form navbar-left">
		  <div class="input-group">
			<input type="text" name="nome_prod" maxlength="30" required pattern="^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ0-9 ]+$" class="form-control" title="escreva o que você deseja pesquisar" value="">
		  	<div class="input-group-btn">
				<button class="btn btn-new btn-primary" title="Pesquisar"><span class="glyphicon glyphicon-search"></span> Procurar</button>
			</div>
		  </div>
		</form>
		  <ul class="nav navbar-nav navbar-right">
			  <c:if test="${empty clienteLogado.usuario_cliente}">
				<li class="${ cadastro_page }"><a href="<c:url value="/Cadastro"/>">Cadastre-se</a></li>
				<li class="${ login_page }"><a href="<c:url value="/Login"/>">Login</a></li>
			  </c:if>
			  <c:if test="${not empty clienteLogado.usuario_cliente}">
				<li class="${ usuario_page }"><a href="<c:url value="/MinhaConta"/>"><span class="glyphicon glyphicon-user"></span> ${clienteLogado.usuario_cliente}</a></li>
				<!-- <li class="${ carrinho_page }"><a href="<c:url value="/Carrinho"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li> -->
				<li><a href="<c:url value="/Logout"/>"><span class="glyphicon glyphicon-off"></span> Logout</a></li>
			  </c:if>
		  </ul>
		</div>
	  </div>
	</nav>
	<div class="row">
	  <div class="col-xs-2">
		<div class="panel-group" id="accordion">

		
		<c:set var="count1" value="0" scope="page" />
		
		<c:forEach var="categoria" items="${categorias}">
		  <c:if test="${not categoria.hierarquia_categoria}">
		  
		  
		  	<div class="panel panel-default">
				 <a data-toggle="collapse" data-parent="#accordion" data-target="#collapse${ count1 }" href="<c:url value="/Categoria/${ categoria.nome_categoria }"/>">
				  <div class="panel-heading">
					<h4 class="panel-title">
						${ categoria.nome_categoria }
					</h4>
				  </div>
				 </a>
				<div id="collapse${ count1 }" class="panel-collapse collapse">
				
				
				  <c:forEach var="categoria" items="${categorias}">
		  			<c:if test="${categoria.hierarquia_categoria}">
						<div class="panel-body"><a href="<c:url value="/Categoria/${ categoria.nome_categoria }"/>">${ categoria.nome_categoria }</a></div>
					</c:if>
				  </c:forEach>
				
				
				</div>
			  </div>
					  
			<c:set var="count1" value="${count + 1}" scope="page"/>
			
			
		  </c:if>
		</c:forEach>
		
		
		</div>
		<!-- <div class="panel panel-default">
		  <div class="panel-heading">
			<h4 class="panel-title">
				Ofertas
			</h4>
		  </div>
		  <div class="body">
				Ofertas
		  </div>
		</div>-->
	  </div>
	  <div class="col-xs-10">
	  
	  
	  