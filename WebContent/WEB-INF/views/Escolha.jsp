<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page session="true"%>
 
<fmt:setLocale value="pt-BR" />
<c:import url="Header.jsp" />

<div class="panel panel-defaut">
			
		<div class="panel-body">
		
	  
	  		<div class="col-md-5 col-sm-12 col-xs-12">
		
			  
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					  
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
				  	<c:set var="EscolhaCount1" value="0" scope="page" />
				  	

					  <c:forEach var="imagem" items="${ produto.imagem }">
						  <div class="item <c:if test="${EscolhaCount1 == 0}">active</c:if>">
							<div class="row" align="center">
							  <a href="" class="img_galery">
								<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_ima }"/>" class="img_container" >
							  </a>
							</div>
						  </div>
					  	<c:set var="EscolhaCount1" value="${EscolhaCount1 + 1}" scope="page"/>
					  </c:forEach>
					  
					</div>


					<!-- Var de separação de imagens -->
				  	<c:set var="EscolhaCount" value="0" scope="page" />
				  	
				  	
					<!-- Indicators -->
					  <ol class="carousel-indicators">
					  	<c:forEach var="imagem" items="${ produto.imagem }">
							<li data-target="#myCarousel" data-slide-to="${ EscolhaCount }" class="imgs_galery <c:if test="${EscolhaCount == 1}">active</c:if>">
								<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_ima }"/>" class="indicator_img_container" >
							</li>
					  	  <c:set var="EscolhaCount" value="${EscolhaCount + 1}" scope="page"/>
						</c:forEach>
					  </ol>
					<!-- /Indicators -->
					
				</div>
				
				
			</div>
				  

						<!----------------------
						
									NOME		
						
						----------------------->
						
						
			  <div class="col-md-6 col-sm-12 col-xs-12">
	  		
	  			  <div class="row row-separator">
	  			  
					<h2><strong>${ produto.nome_pro }</strong></h2>
					
				  </div>
				
				
				
	  		
	  			  <div class="row row-separator row-comprar">
				  	<div class="col-md-6 col-sm-12 col-xs-12">
						
						<h4 align="center">Vendido e entregue por:</h4>
						<h3 align="center"><strong>${prod_forn.fornecedor.nome_for}</strong></h3>
						
						<br>
						
<!--------------------------------------	CALCULO do DESCONTO 	--------------------------------------->
						<p align="center">
						
						  <c:if test="${ produto.promocao_pro == true }">

							<c:set var="preco"	value="${ prod_forn.preco_prod }"/>
							
							<c:set var="calc_desconto_prod"	value="${ preco * ( produto.desconto_pro / 100 ) }" scope="page" />
							
							<font class="preco_desconto"> <fmt:formatNumber value="${ preco }" type="currency"/></font> -
							<font class="desconto"> <fmt:formatNumber value="${ calc_desconto_prod }" type="currency"/></font> = <br>
							<font class="preco"> <fmt:formatNumber value="${ produto.calcularDesconto(preco) }" type="currency"/> </font>
						
						  </c:if>
						  
						  
<!--------------------------------------	Se não houver DESCONTO 	--------------------------------------->
						  <c:if test="${ produto.promocao_pro == false }">
							<font class="preco"> <fmt:formatNumber value="${ preco }" type="currency"/></font>
						  </c:if>
						  
						</p>
<!--------------------------------------	DESCONTO 	--------------------------------------->
						<p align="center" class="desconto">
							<c:if test="${ produto.promocao_pro == true }">
								Desconto de ${ produto.desconto_pro }%
							</c:if>
						</p>
						
					</div>
					
					
					
					
					
				  	<div class="col-md-5 col-sm-12 col-xs-12 col-md-offset-1 col-sm-offset-0 col-xs-offset-0">
					  <div class="row">
				  
					  	<!--<c:if test="${empty clienteLogado.email_cli}">
							<h3>Faça o <a href="<c:url value="/Login"/>">Login</a></h3>
							<h4>ou <a href="<c:url value="/Cadastro"/>">Cadastre-se</a></h4>
						</c:if>-->
						
					 	<!--<c:if test="${not empty clienteLogado.email_cli}"></c:if>-->
						  <div class="row">
						  	<p align="center">
						  		<a class="" data-toggle="modal" data-target=".bs-oferta-md" href="#">
						  			Fornecedor Recomendado <i class="fa fa-question-circle"></i>
						  		</a>
							</p>
						  </div>
						  <div class="row">
						 	  <div class="col-md-12 col-sm-12 col-xs-12">
								<form action="<c:url value="/AdicionaItemCarrinho"/>" method="POST">
								  <input type="hidden" name="quantidade" value="1">
								  <input type="hidden" name="id_prod" value="${ produto.id_produto }">
								  <input type="hidden" name="id_forn" value="${ prod_forn.fornecedor.id_fornecedor }">
							  	  <button type="submit" class="btn btn-danger btn-block btn-comprar">Comprar</button>
								</form>
							  </div>
						  </div>
					
					  </div>
					  <div class="row">
						<div class="btn btn-sm form-control">Fornecedor 1</div>
						<div class="btn btn-sm form-control">Fornecedor 2</div>
						<div class="btn btn-sm form-control">Fornecedor 3</div>
					  </div>
					</div>
							<!--			FORNECEDOR			

						<div class="btn btn-sm form-control">Fornecedor 1</div>
						<div class="btn btn-sm form-control">Fornecedor 2</div>
						<div class="btn btn-sm form-control">Fornecedor 3</div>-->
				  </div>
				  
				  
				  
					  <!--			FORMAS DE PAGAMENTO			-->

					  <div class="row row-separator">
					  	<p><i class="fa fa-barcode"></i>
					  	<strong>
					  	
							<c:if test="${ produto.promocao_pro == true }">		<!-- SE HOUVER desconto -->
					  			<fmt:formatNumber value="${ desconto_prod }" type="currency"/>
					  		</c:if>
					  		<c:if test="${ produto.promocao_pro == false }">	<!-- SE NÃO HOUVER desconto -->
					  			<fmt:formatNumber value="${ produto.preco_pro }" type="currency"/>
					  		</c:if>
					  		
					  	</strong> no Boleto (<span class="green">Nenhum acréscimo</span>)</p>
					  </div>

					  <!-- <div class="row row-separator">
					  	<p><i class="fa fa-credit-card"></i> <strong><fmt:formatNumber value="${ preco }" type="currency"/></strong> no Cartão de Débito (<span class="red">+ 10%</span>) <strong class="red"><-- ERRO DE CALCULO AKI !</strong></p>
					  </div>

					  <div class="row row-separator">
					  	<p><i class="fa fa-credit-card"></i> <strong><fmt:formatNumber value="${ preco }" type="currency"/></strong> no Cartão de Crédito (<span class="red">+ 10%</span>) <strong class="red"><-- ERRO DE CALCULO AKI !</strong></p>
					  </div> -->
					  
				 
					  <!--			FRETE			-->
						
					  <div class="row row-separator row-frete">
							<div class="form-horizontal">
							  <div class="form-group">
								<label for="cep" class="col-md-4 control-label">Calcular frete e prazo: </label>
								
	                            <div class="col-md-4">
			  					  <div class="input-group">
			  					  
							  		<c:if test="${empty clienteLogado.email_cli}">
										<input type="text" id="cep" name="cep" placeholder="CEP" value="" class="form-control cep cep-correios">
									</c:if>
							  		<c:if test="${not empty clienteLogado.email_cli}">
										<input type="text" id="cep" name="cep" placeholder="CEP" class="form-control cep cep-correios" value="${ cep_cliente }" placeholder="CEP">
									</c:if>
									
									<div class="input-group-btn">
										<button class="btn btn-secundary">Ok</button>
									</div>
									
								  </div>
							  	  <a href="http://m.correios.com.br/movel/buscaCepConfirma.do" target="blank">Não sei meu CEP</a>
								</div>
								
							  </div>
							</div>
					  </div>
					  
					  
				</div>
			  </div>
			
						<!----------------------
						
								DESCRIÇÃO		
						
						----------------------->
			<div class="col-xs-12">
			  <div class="col-md-6 col-sm-6 col-xs-12">
				  <h3 class="prod_header_descricao">Descrição técnica produto: </h3>
					<table class="table table-condensed table-striped table-hover">
					  <thead>
						<tr></tr>
					  </thead>
					  <tbody>
						  <tr><td> Peso: ${ produto.peso_pro } </td></tr>
						  <tr><td> Altura: ${ produto.altura_pro } </td></tr>
						  <tr><td> Largura: ${ produto.largura_pro } </td></tr>
						  <tr><td> Comprimento: ${ produto.comprimento_pro } </td></tr>
					  </tbody>
				  	</table>
			  </div>
				  
			  <div class="col-md-6 col-sm-6 col-xs-12">
				  <h3 class="prod_header_descricao">Informações do produto: </h3>
				  <h5>${ produto.descricao_pro }</h5>
			  </div>
			</div>
	</div>
				  
<c:import url="Footer.jsp" />




<!-- 	Modal	 -->
<div class="modal fade bs-oferta-md" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Fornecedor Recomendado</h4>
      </div>
      <div class="modal-body modal-oferta">
        <div class="row">
          <div class="col-xs-12">
	        <p class="paragrafo_oferta">Esta loja é apenas um intermediario entre você e nossos parceiros, então um mesmo produto pode ser vendido e entregue por vários fornecedores.</p>
	        <p class="paragrafo_oferta">O produto oferecido em destaque é a combinação de alguns fatores:</p>
	        <ul class="fa-ul">
	          <li title="Procuramos o fornecedor mais próximo de você"><i class="fa-li fa fa-truck"></i> <strong>Valor do Frete</strong>;</li>
	          <li title="Procuramos o fornecedor mais próximo de você"><i class="fa-li fa fa-calendar"></i> <strong>Prazo de Entrega</strong>;</li>
	          <li title="Procuramos o fornecedor com o menor preço"><i class="fa-li fa fa-money"></i> <strong>Preço do produto</strong>;</li>
	        </ul>
	        <p class="paragrafo_oferta">Fazemos com que você tenha sempre a melhor escolha.</p>
          </div>
      	</div><!-- Fim Row -->
      </div>
    </div>
  </div>
</div>