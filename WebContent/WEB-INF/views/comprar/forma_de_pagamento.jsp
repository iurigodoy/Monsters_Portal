<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:import url="Header.jsp" />
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
				<i class="fa fa-warning"></i> ATEN��O: ESSE PORTAL e-COMMERCE � APENAS DEMONSTRATIVO, N�O COMPRE PRODUTOS ATRAV�S DELE!!!
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
				<c:set var="ped_qtd"		value="1"								scope="page" />
				<c:set var="ped_parcelas"	value="1"								scope="page" />
				<c:set var="ped_peso"		value="${ produto.peso_produto }"		scope="page" />
				<c:set var="ped_altura"		value="${ produto.altura_produto }"		scope="page" />
				<c:set var="ped_largura"	value="${ produto.largura_produto }"	scope="page" />
				<c:set var="ped_comprimento" value="${ produto.comprimento_produto }" scope="page" />
				
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
						<h4><i class="fa fa-barcode"></i> Boleto </h4>
					  </div>
					</a>
					  <div id="collapse1" class="panel-collapse collapse">
					  
						<form action="<c:url value="/Comprar_um"/>" method="post">
						  <input type="hidden" name="id_produto"						value="${id_produto}">
						  <input type="hidden" name="cliente.id_cliente"				value="${id_cliente}">
						  <input type="hidden" name="forma_de_pagamento_pedido"			value="boleto">
						  <input type="hidden" name="custo_forma_de_pagamento_pedido"	value="0.00">
						  <input type="hidden" name="numero_pedido"						value="0000000000">
						  <input type="hidden" name="data_pedido"						value="<fmt:formatDate type="date" value="${now}" pattern="yyyy/MM/dd" />">
						  <input type="hidden" name="hora_pedido"						value="<fmt:formatDate value="${now}" pattern="MM/dd/yyyy HH:mm" />">
						  <input type="hidden" name="status_pedido"						value="1">
						  <input type="hidden" name="preco_pedido"				value="${ped_preco}">
						  <input type="hidden" name="qtd_pedido"				value="${ped_qtd}">
						  <input type="hidden" name="custo_frete_pedido"		value="0.00">
						  <input type="hidden" name="parcelas_pedido"			value="${ped_parcelas}">
						  <input type="hidden" name="peso_pedido"				value="${ped_peso}">
						  <input type="hidden" name="altura_pedido"				value="${ped_altura}">
						  <input type="hidden" name="largura_pedido"			value="${ped_largura}">
						  <input type="hidden" name="comprimento_pedido"		value="${ped_comprimento}">
						  <div class="panel-body">
						  
					  		<strong>Necess�rio confirmar dados</strong>
					  		
							<p align="Justify">O boleto deve ser impresso ap�s a finaliza��o do pedido.
							Na impossibilidade de imprimi-lo, voc� poder� fazer o pagamento atrav�s do Internet Banking de seu banco.
							Para isso, utilize o c�digo de barras localizado na parte superior esquerda do boleto.
							N�o enviamos boletos por correio.<br><br>
							A data limite para a realiza��o do pagamento � de 5 (cinco) dias contados a partir da data de gera��o do boleto. Decorrido este prazo, ele perder� a validade.
							N�o � poss�vel pagar o seu pedido atrav�s de DOC, transfer�ncia ou dep�sito para a conta indicada no boleto.
							O produto ser� entregue logo ap�s a confirma��o do pagamento, que pode levar de 1 a 5 dias �teis.</p><br>
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
							<input type="image" src="https://www.paypalobjects.com/pt_BR/BR/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - A maneira f�cil e segura de enviar pagamentos online!">
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
							<!-- N�O EDITE OS COMANDOS DAS LINHAS ABAIXO -->
							<input type="hidden" name="code" value="27F951FC5C5CEFFCC41B0F981983AB76" />
							<input type="hidden" name="iot" value="button" />
							<input type="image" src="https://stc.pagseguro.uol.com.br/public/img/botoes/pagamentos/209x48-comprar-assina.gif" name="submit" alt="Pague com PagSeguro - � r�pido, gr�tis e seguro!" />
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
	</div><!--/ col-xs-12 -->
  </div><!--/ container -->
<c:import url="Footer.jsp" />