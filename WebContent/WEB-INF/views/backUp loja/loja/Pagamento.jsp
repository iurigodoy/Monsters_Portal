<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:import url="Header.jsp" />
  <div class="row">
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
				
					
					<a href="#boleto" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse">
					  <div class="panel-heading">
						<h4 class="panel-title">
						  <h4><img src="<c:url value="/resources/imagens/loja/pagamento/boleto.png"/>" height="30" width="30" > Boleto</h4>
						</h4>
					  </div>
					</a>
					  <div id="collapse" class="panel-collapse collapse">
					  
					  
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
							<p align="Justify">O boleto deve ser impresso ap�s a finaliza��o do pedido.
							Na impossibilidade de imprimi-lo, voc� poder� fazer o pagamento atrav�s do Internet Banking de seu banco.
							Para isso, utilize o c�digo de barras localizado na parte superior esquerda do boleto.
							A Worldcell n�o envia boletos por correio.<br><br>
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
					
					  </div>
					  
					  
				  </div>
				  <div class="panel panel-default">
						
						
					<a href="#boleto" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse2">
					  <div class="panel-heading">
						<h4 class="panel-title">
						  <h4>D�bito Bancario</h4>
						</h4>
					  </div>
					</a>
					<div id="collapse2" class="panel-collapse collapse">
					  
					<div id="tabs">
					  <ul>
						<li>
						  <a href="#tabs-1">
							<img src="<c:url value="/resources/imagens/loja/pagamento/banco_do_brasil.png"/>" height="30" width="30" >
						  </a>
						</li>
						<li>
						  <a href="#tabs-2">
							<img src="<c:url value="/resources/imagens/loja/pagamento/itau.png"/>" height="30" width="30" >
						  </a>
						</li>
					  </ul>
					  
						
						<div id="tabs-1">
						  <div class="panel-body">
							<p  align="Justify">O produto ser� entregue depois da confirma��o do pagamento pela institui��o financeira, isso pode levar at� 48 horas,
							clicando em "Finalizar Pedido", abrir� a p�gina do Banco do Brasil e voc� finalizar� a sua compra com seus dados pessoais.</p>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<a href="http://www.bb.com.br"><button class="btn btn-primary">Finalizar Pedido</button></a><br>
							  </div>
							</div>
						  </div>
						</div>
					  
					  
						<div id="tabs-2">
						  <div class="panel-body">
							<p  align="Justify">O produto ser� entregue depois da confirma��o do pagamento pela institui��o financeira, isso pode levar at� 48 horas,
							clicando em "Finalizar Pedido", abrir� a p�gina do Ita� e voc� finalizar� a sua compra com seus dados pessoais.</p>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<a href="http://www.itau.com.br"><button class="btn btn-primary">Finalizar Pedido</button></a>
							  </div>
							</div>
						  </div>
						</div>
					</div>
						
						
					</div>
					  
					  
				  </div>
				  <div class="panel panel-default">
						
						
					<a href="#boleto" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse3">
					  <div class="panel-heading">
						<h4 class="panel-title">
						  <h4>Cart�o de Cr�dito</h4>
						</h4>
					  </div>
					</a>
					<div id="collapse3" class="panel-collapse collapse">
					  <div id="tabs2">
					  
					  
						<ul>
							<li>
							  <a href="#tabs-1">
								<img src="<c:url value="/resources/imagens/loja/pagamento/visa.png"/>" height="30" width="30" >
							  </a>
							</li>
							<li>
							  <a href="#tabs-2">
								<img src="<c:url value="/resources/imagens/loja/pagamento/master_card.png"/>" height="30" width="30" >
							  </a>
							</li>
							<li>
							  <a href="#tabs-3">
								<img src="<c:url value="/resources/imagens/loja/pagamento/cielo_elo.png"/>" height="30" width="30" >
							  </a>
							</li>
							<li>
							  <a href="#tabs-4">
							  <img src="<c:url value="/resources/imagens/loja/pagamento/diners.png"/>" height="30" width="30" >	
							  </a>
							</li>
						</ul>
						
						<div id="tabs-1">
						  <div class="panel-body">
							<p align="Justify">O produto ser� entregue depois da confirma��o do pagamento pela institui��o financeira, isso pode levar at� 48 horas,
							clicando em "Finalizar Pedido", abrir� a p�gina da Visa e voc� finalizar� a sua compra com seus dados pessoais.</p>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<button class="btn btn-primary">Finalizar Pedido</button>
							  </div>
							</div>
						  </div>
						</div>
							
						<div id="tabs-2">
						  <div class="panel-body">
						  
							<p align="Justify">O produto ser� entregue depois da confirma��o do pagamento pela institui��o financeira, isso pode levar at� 48 horas,
							clicando em "Finalizar Pedido", abrir� a p�gina do Master Card e voc� finalizar� a sua compra com seus dados pessoais.</p>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<button class="btn btn-primary">Finalizar Pedido</button>
							  </div>
							</div>
						  </div>
						</div>
							
						<div id="tabs-3">
						  <div class="panel-body">
					  
							<p align="Justify">O produto ser� entregue depois da confirma��o do pagamento pela institui��o financeira, isso pode levar at� 48 horas,
							clicando em "Finalizar Pedido", abrir� a p�gina da Cielo e voc� finalizar� a sua compra com seus dados pessoais.</p>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<button class="btn btn-primary">Finalizar Pedido</button>
							  </div>
							</div>
						  </div>
						</div>
							
						<div id="tabs-4">
						  <div class="panel-body">
					  
							<p align="Justify">O produto ser� entregue depois da confirma��o do pagamento pela institui��o financeira, isso pode levar at� 48 horas,
							clicando em "Finalizar Pedido", abrir� a p�gina do Diners e voc� finalizar� a sua compra com seus dados pessoais.</p>
							<div class="row">
							  <div class="col-xs-3"></div>
							  <div class="col-xs-6">
								<button class="btn btn-primary">Finalizar Pedido</button>
							  </div>
							</div>
						  </div>
						</div>
					  </div>
					</div>
						
						
				  </div>
				  <div class="panel panel-default">
				  
					  
					<a href="#boleto" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse4">
					  <div class="panel-heading">
						<h4 class="panel-title">
						  <h4>Cart�o de D�bito</h4>
						</h4>
					  </div>
					</a>
					  <div id="collapse4" class="panel-collapse collapse">
					  
					  
						<button class="btn" id="visa_eletron_button"><img src="<c:url value="/resources/imagens/loja/pagamento/visa_eletron.png"/>" height="30" width="30" ></button>
						<div id="visa_eletron">
						  <div class="panel-body">
							<p align="Justify">Aten��o: Existem bancos que exigem uma autoriza��o especial para habilitar a utiliza��o do Visa Electron pela internet.
							Caso n�o seja poss�vel completar a sua compra, verifique com o seu banco a habilita��o dessa fun��o.</p>
								
								Preencha os campos abaixo com os dados do seu cart�o.<br>
							<div class="row">
							  <div class="col-xs-12">
								N�mero do cart�o<input type="text" class="form-control"><br>
								Nome impresso no cart�o<input type="text" class="form-control"><br>
								Validade<input type="text" class="form-control"><br>
							  </div>
							  <div class="col-xs-6">
								C�digo de seguran�a<input type="text" class="form-control">
							  </div>
							  <div class="col-xs-6">
								<img src="<c:url value="/resources/imagens/loja/pagamento/codigo_cartao.jpg"/>" height="30" width="30" >
							  </div>
							  <div class="col-xs-12">
								<button class="btn btn-primary">Finalizar Pedido</button>
							  </div>
							</div>
						  </div>
						</div>
					
					
					  </div>
				</div>
			  </div>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
<c:import url="Footer.jsp" />