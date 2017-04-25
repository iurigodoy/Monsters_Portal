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
							<p align="Justify">O boleto deve ser impresso após a finalização do pedido.
							Na impossibilidade de imprimi-lo, você poderá fazer o pagamento através do Internet Banking de seu banco.
							Para isso, utilize o código de barras localizado na parte superior esquerda do boleto.
							A Worldcell não envia boletos por correio.<br><br>
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
					
					  </div>
					  
					  
				  </div>
				  <div class="panel panel-default">
						
						
					<a href="#boleto" data-toggle="collapse" data-parent="#accordion_pay" data-target="#collapse2">
					  <div class="panel-heading">
						<h4 class="panel-title">
						  <h4>Débito Bancario</h4>
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
							<p  align="Justify">O produto será entregue depois da confirmação do pagamento pela instituição financeira, isso pode levar até 48 horas,
							clicando em "Finalizar Pedido", abrirá a página do Banco do Brasil e você finalizará a sua compra com seus dados pessoais.</p>
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
							<p  align="Justify">O produto será entregue depois da confirmação do pagamento pela instituição financeira, isso pode levar até 48 horas,
							clicando em "Finalizar Pedido", abrirá a página do Itaú e você finalizará a sua compra com seus dados pessoais.</p>
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
						  <h4>Cartão de Crédito</h4>
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
							<p align="Justify">O produto será entregue depois da confirmação do pagamento pela instituição financeira, isso pode levar até 48 horas,
							clicando em "Finalizar Pedido", abrirá a página da Visa e você finalizará a sua compra com seus dados pessoais.</p>
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
						  
							<p align="Justify">O produto será entregue depois da confirmação do pagamento pela instituição financeira, isso pode levar até 48 horas,
							clicando em "Finalizar Pedido", abrirá a página do Master Card e você finalizará a sua compra com seus dados pessoais.</p>
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
					  
							<p align="Justify">O produto será entregue depois da confirmação do pagamento pela instituição financeira, isso pode levar até 48 horas,
							clicando em "Finalizar Pedido", abrirá a página da Cielo e você finalizará a sua compra com seus dados pessoais.</p>
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
					  
							<p align="Justify">O produto será entregue depois da confirmação do pagamento pela instituição financeira, isso pode levar até 48 horas,
							clicando em "Finalizar Pedido", abrirá a página do Diners e você finalizará a sua compra com seus dados pessoais.</p>
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
						  <h4>Cartão de Débito</h4>
						</h4>
					  </div>
					</a>
					  <div id="collapse4" class="panel-collapse collapse">
					  
					  
						<button class="btn" id="visa_eletron_button"><img src="<c:url value="/resources/imagens/loja/pagamento/visa_eletron.png"/>" height="30" width="30" ></button>
						<div id="visa_eletron">
						  <div class="panel-body">
							<p align="Justify">Atenção: Existem bancos que exigem uma autorização especial para habilitar a utilização do Visa Electron pela internet.
							Caso não seja possível completar a sua compra, verifique com o seu banco a habilitação dessa função.</p>
								
								Preencha os campos abaixo com os dados do seu cartão.<br>
							<div class="row">
							  <div class="col-xs-12">
								Número do cartão<input type="text" class="form-control"><br>
								Nome impresso no cartão<input type="text" class="form-control"><br>
								Validade<input type="text" class="form-control"><br>
							  </div>
							  <div class="col-xs-6">
								Código de segurança<input type="text" class="form-control">
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