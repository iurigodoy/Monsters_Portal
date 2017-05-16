<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:import url="../Header.jsp" />
  <div class="content">
	<div class="col-xs-12">
	  <div class="panel panel-default">
		<div class="panel-heading">
		  <h2 class="panel-title">
			Formas de Pagamento
		  </h2>
		</div>
		
		<div class="panel-body">
		  <div class="row">
		   	<div class="col-xs-3">
				
			</div>
			<div class="col-xs-6">
			<h3 align="center">
			  <strong class="red">
				<i class="fa fa-warning"></i> ATENÇÃO: ESSE PORTAL e-COMMERCE É APENAS DEMONSTRATIVO, NÃO COMPRE PRODUTOS ATRAVÉS DELE!!!
			  </strong>
			</h3>
			
			<form:errors path="pedido.*"/>
			  
			  <c:forEach var="cliente" items="${clienteLogadoInfo}">
			    <c:set var="id_cliente" value="${cliente.id_cliente }" />
			  </c:forEach>
			  
			  <c:forEach var="produto" items="${produtos}">
			  	<c:set var="now" value="<%=new java.util.Date()%>" />
				<c:set var="id_produto"		value="${ produto.id_produto }"			scope="page" />
				<c:set var="frete"			value="0.00"							scope="page" />
				<c:set var="ped_preco"		value="${ produto.preco_produto }"		scope="page" />
				
				<h3>${ produto.nome_produto }</h3>
			  </c:forEach>
			</div>
		  </div>
		  <div class="row">
		   <div class="col-xs-2"></div>
			<div class="col-xs-8">
			  <div id="accordion_pay" class="panel-group">
				  <div class="panel panel-default">
				
					
					<a href="#boleto" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse1">
					  <div class="panel-heading">
						<h4><i class="fa fa-barcode"></i> Boleto <strong class="red">Frete não incluido</strong></h4>
					  </div>
					</a>
					  <div id="collapse1" class="panel-collapse collapse">
					  
						<form action="<c:url value="/FinalizarCompraSegura"/>" method="post">
						  <input type="hidden" name="numero_ped"					value="0000000000">
						  <input type="hidden" name="preco_ped"						value="${carrinho.total}">
						  <input type="hidden" name="custo_forma_de_pagamento_ped"	value="0.00">
						  <input type="hidden" name="custo_frete_ped"				value="0.00">
						  <input type="hidden" name="status_ped"					value="0">
						  <div class="panel-body">
						  
					  		<strong>Necessário confirmar dados</strong>
					  		
							<p align="Justify">O boleto deve ser impresso após a finalização do pedido.
							Na impossibilidade de imprimi-lo, você poderá fazer o pagamento através do Internet Banking de seu banco.
							Para isso, utilize o código de barras localizado na parte superior esquerda do boleto.
							Não enviamos boletos por correio.<br><br>
							A data limite para a realização do pagamento é de 5 (cinco) dias contados a partir da data de geração do boleto. Decorrido este prazo, ele perderá a validade.
							Não é possível pagar o seu pedido através de DOC, transferência ou depósito para a conta indicada no boleto.
							O produto será entregue logo após a confirmação do pagamento, que pode levar de 1 a 5 dias úteis.</p><br>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<button class="btn btn-primary form-control">Gerar Boleto</button>
							  </div>
							</div>
						  </div>
						</form>
					
					</div><!--/ panel -->
				  </div><!--/ col-xs-6 -->
				  
				  <div class="col-xs-6">
				    <div class="panel panel-default">
					  <a href="#paypal" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse2">
						<div class="panel-heading">
						  <h4><i class="fa fa-paypal blue"></i> PayPal </h4>
						</div>
					  </a>
					  <div id="collapse2" class="panel-collapse collapse">
						<div class="panel-body">
						  <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
							<input type="hidden" name="cmd" value="_s-xclick">
							<input type="hidden" name="hosted_button_id" value="LAYE2KNAZBHJN">
							<input type="image" src="https://www.paypalobjects.com/pt_BR/BR/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - A maneira fácil e segura de enviar pagamentos online!">
							<img alt="" border="0" src="https://www.paypalobjects.com/pt_BR/i/scr/pixel.gif" width="1" height="1">
						  </form>
						</div>
				  	  </div>
					</div><!--/ panel -->
				  </div><!--/ col-xs-6 -->
				  
				  <div class="col-xs-6">
				 	<div class="panel panel-default">
					
					  <a href="#paypal" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse3">
						<div class="panel-heading">
						  <h4 class="green">PagSeguro </h4>
						</div>
					  </a>
					  <div id="collapse3" class="panel-collapse collapse">
					  	<div class="panel-body">
						  	<!-- INICIO FORMULARIO BOTAO PAGSEGURO -->
							<form action="https://pagseguro.uol.com.br/checkout/v2/payment.html" method="post">
							<!-- NÃO EDITE OS COMANDOS DAS LINHAS ABAIXO -->
							<input type="hidden" name="code" value="27F951FC5C5CEFFCC41B0F981983AB76" />
							<input type="hidden" name="iot" value="button" />
							<input type="image" src="https://stc.pagseguro.uol.com.br/public/img/botoes/pagamentos/209x48-comprar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FINAL FORMULARIO BOTAO PAGSEGURO -->
						</div>
					  </div>
					</div><!--/ panel -->
				  </div><!--/ col-xs-6 -->
			  </div><!--/ accordion -->
			</div><!--/ col-xs-8 -->
		  </div><!--/ row -->
		</div><!--/ panel-body -->
	  </div><!--/ panel -->
	  <h4 align="center">
		<strong class="blue"> Qualquer compra feita através deste site será considerada uma doação para os desenvolvedores. </strong>
	  </h4>
	</div><!--/ col-xs-12 -->
  </div><!--/ container -->
<c:import url="../Footer.jsp" />