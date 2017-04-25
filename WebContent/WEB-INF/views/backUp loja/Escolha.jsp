<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page session="true"%>
 
<fmt:setLocale value="pt-BR" />
<c:import url="Header.jsp" />

    <!-- starrr -->
    <link href="<c:url value="/resources/vendors/starrr/dist/starrr.css"/>" rel="stylesheet">

<div class="panel panel-defaut">

  <c:forEach var="cliente" items="${clienteLogadoInfo}">
	<c:set var="cep_cliente"		value="${ cliente.cep_cliente }"			scope="page" />
  </c:forEach>
		
  <c:forEach var="produto" items="${produtos}">
		
		
		
		
			<c:set var="id_produto"		value="${ produto.id_produto }"		scope="page" />
			<c:set var="nome_produto"	value="${ produto.nome_produto }"	scope="page" />
			
			<c:set var="parcelas"		value="12" scope="page" />
			<c:set var="dividir_prod"	value="10" scope="page" />
			<c:set var="valor_prod_div"	value="${ produto.preco_produto / dividir_prod }" scope="page" />
			<c:set var="valor_parcelas"	value="${ valor_prod_div * parcelas }" scope="page" />
		
		
		
		
		
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
								<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_imagem }"/>" class="img_container" >
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
								<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_imagem }"/>" class="indicator_img_container" >
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
	  			  
					<h2><strong>${ produto.nome_produto }</strong></h2>
					  <h4>
						<i class="star fa fa-star gold-star"></i><i class="star fa fa-star gold-star"></i><i class="star fa fa-star gold-star"></i><i class="star fa fa-star gold-star"></i><i class="star fa fa-star-o gold-star"></i> <small>(50)</small>
					  </h4>
					
				  </div>
				
				
				
	  		
	  			  <div class="row row-separator row-comprar">
				  	<div class="col-md-6 col-sm-12 col-xs-12">
						
						<h5 align="center">
							Vendido e entregue por:
							<br> <strong>${produto.fornecedor.nome_fornecedor}</strong>
						</h5>
						
						<br>
						
<!--------------------------------------	CALCULO do DESCONTO 	--------------------------------------->
						<p align="center">
						
						  <c:if test="${ produto.promocao_produto == true }">
		 			  
							
							<c:set var="calc_desconto_prod"	value="${ produto.preco_produto * ( produto.desconto_produto / 100 ) }" scope="page" />
							<c:set var="desconto_prod"	value="${ produto.preco_produto - calc_desconto_prod }" scope="page" />
		 			  
							<c:set var="valor_prod_div"	value="${ desconto_prod / dividir_prod }" scope="page" />
							<c:set var="valor_parcelas"	value="${ valor_prod_div * parcelas }" scope="page" />
							
							
							<font class="preco_desconto"> <fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font> -
							<font class="desconto"> <fmt:formatNumber value="${ calc_desconto_prod }" type="currency"/></font> = <br>
							<font class="preco"> <fmt:formatNumber value="${ desconto_prod }" type="currency"/> </font>
		 			  
		 			  
							<font class="preco_desconto_preco">de <font class="preco_desconto"><fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font> por</font><br>
							<font class="preco"> <fmt:formatNumber value="${ desconto_prod }" type="currency"/> </font>
						
						  </c:if>
						  
						  
<!--------------------------------------	Se não houver DESCONTO 	--------------------------------------->
						  <c:if test="${ produto.promocao_produto == false }">
							<font class="preco"> <fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font>
						  </c:if>
						  
						</p>
<!--------------------------------------	DESCONTO 	--------------------------------------->
						<p align="center" class="desconto">
							<c:if test="${ produto.promocao_produto == true }">
								Desconto de ${ produto.desconto_produto }%
							</c:if>
						</p>
						<p align="center">${ parcelas } x de <fmt:formatNumber value="${ valor_prod_div }" type="currency"/> s/ juros</p>
						
					</div>
					
					
					
					
					
				  	<div class="col-md-5 col-sm-12 col-xs-12 col-md-offset-1 col-sm-offset-0 col-xs-offset-0">
					  <div class="row">
				  
					  	<c:if test="${empty clienteLogado.usuario_cliente}">
							<h3>Faça o <a href="Login">Login</a></h3>
							<h4>ou <a href="Cadastro">Cadastre-se</a></h4>
						</c:if>
						
					 	<c:if test="${not empty clienteLogado.usuario_cliente}">
						  <div class="row">
						  	<p align="center">
						  		<a class="" data-toggle="modal" data-target=".bs-oferta-md" href="#">
						  			Fornecedor Recomendado <i class="fa fa-question-circle"></i>
						  		</a>
							</p>
						  </div>
						  <div class="row">
						 	  <div class="col-md-9 col-sm-9 col-xs-9">
								  <a href="<c:url value="/Pagamento/${ produto.nome_produto }"/>">
									<button class="btn btn-lg btn-danger btn-block btn-comprar">Comprar</button>
								  </a>
							  </div>
							  <div class="col-md-3 col-sm-3 col-xs-3">
						 		<div class="btn-group">
									<button class="btn btn-lg btn-primary" title="Carrinho"><span class="glyphicon glyphicon-shopping-cart"></span></button>
								</div>
							  </div>
						  </div>
						</c:if>
					
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
					  	
							<c:if test="${ produto.promocao_produto == true }">		<!-- SE HOUVER desconto -->
					  			<fmt:formatNumber value="${ desconto_prod }" type="currency"/>
					  		</c:if>
					  		<c:if test="${ produto.promocao_produto == false }">	<!-- SE NÃO HOUVER desconto -->
					  			<fmt:formatNumber value="${ produto.preco_produto }" type="currency"/>
					  		</c:if>
					  		
					  	</strong> no Boleto (<span class="green">Nenhum acréscimo</span>)</p>
					  </div>

					  <div class="row row-separator">
					  	<p><i class="fa fa-credit-card"></i> <strong><fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></strong> no Cartão de Débito (<span class="red">+ 10%</span>) <strong class="red"><-- ERRO DE CALCULO AKI !</strong></p>
					  </div>

					  <div class="row row-separator">
					  	<p><i class="fa fa-credit-card"></i> <strong><fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></strong> no Cartão de Crédito (<span class="red">+ 10%</span>) <strong class="red"><-- ERRO DE CALCULO AKI !</strong></p>
					  </div>
					  
				 
					  <!--			FRETE			-->
						
					  <div class="row row-separator row-frete">
							<div class="form-horizontal">
							  <div class="form-group">
								<label for="cep" class="col-md-4 control-label">Calcular frete e prazo: </label>
								
	                            <div class="col-md-4">
			  					  <div class="input-group">
			  					  
							  		<c:if test="${empty clienteLogado.usuario_cliente}">
										<input type="text" id="cep" name="cep" value="" class="form-control cep cep-correios">
									</c:if>
							  		<c:if test="${not empty clienteLogado.usuario_cliente}">
										<input type="text" id="cep" name="cep" class="form-control cep cep-correios" value="${ cep_cliente }" placeholder="CEP">
									</c:if>
									
									<div class="input-group-btn">
										<button class="btn btn-secundary">Ok</button>
									</div>
									
								  </div>
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
						  <tr><td> Peso: ${ produto.peso_produto } </td></tr>
						  <tr><td> Altura: ${ produto.altura_produto } </td></tr>
						  <tr><td> Largura: ${ produto.largura_produto } </td></tr>
						  <tr><td> Comprimento: ${ produto.comprimento_produto } </td></tr>
						  <tr><td> Garantia: ${ produto.garantia_produto } </td></tr>
					  </tbody>
				  	</table>
			  </div>
				  
			  <div class="col-md-6 col-sm-6 col-xs-12">
				  <h3 class="prod_header_descricao">Informações do produto: </h3>
				  <h5>${ produto.descricao_produto }</h5>
			  </div>
			</div>
	</div>
			
	  </c:forEach>







						<!----------------------
						
								Avaliações		
						
						----------------------->



			<div class="container_avaliacao">
				
				<h2>Avaliações</h2>
	
				<!--<c:if test="${not empty clienteLogado.usuario_cliente}">
	  		
	  			  <div class="row row-separator">
					  <div class="col-xs-2">
						<div class="img-thumbnail">
							<span class="glyphicon glyphicon-user" style="font-size:32px;"></span>
						</div><br>
						${clienteLogado.usuario_cliente}
					  </div>
					  <form action="CreateAvaliacao" method="POST">
						<div class="col-xs-10">
						  <div class="row">
						  
						  
                      			<div class="starrr stars"></div>(<span class="stars-count">0</span>)
                      			
                      			
							<div class="btn-group" data-toggle="buttons">
							</div>
						  </div>
						  <div class="row">
							<textarea name="avaliacao" class="form-control" rows="4"></textarea>
						  </div>
						  <div class="row">
							<button class="btn btn-primary pull-right">Enviar</button>
						  </div>
						</div>
					  </form>
					  
				  </div>
				  
				</c:if>-->
		
  				<c:forEach var="avaliacao" items="${avaliacoes}" varStatus="Starloop1">
	  		
	  			  <div class="row row-separator">
					  <div class="col-xs-12">
						<div class="row">
					  		<h4>${ avaliacao.cliente.nome_cliente }</h4>
					  		<div class="starrr stars-existing${Starloop1.index}" data-rating='${ avaliacao.nota_avaliacao }'></div> (<span class="stars-count-existing">${avaliacao.nota_avaliacao}</span>)
					  	</div>
							
						<div class="row">
							<h4>
							${ avaliacao.comentario_avaliacao }
							</h4>
						</div>
					  </div>
					</div>
					
				</c:forEach>
				
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
	        <ul>
	          <li title="Procuramos o fornecedor mais próximo de você"><i class="fa fa-truck"></i> <strong>Valor do Frete</strong>;</li>
	          <li title="Procuramos o fornecedor mais próximo de você"><i class="fa fa-calendar"></i> <strong>Prazo de Entrega</strong>;</li>
	          <li title="Procuramos o fornecedor com o menor preço"><i class="fa fa-money"></i> <strong>Preço do produto</strong>;</li>
	        </ul>
	        <p class="paragrafo_oferta">Fazemos com que você tenha sempre a melhor escolha.</p>
          </div>
      	</div><!-- Fim Row -->
      </div>
    </div>
  </div>
</div>







    <!-- starrr -->
    <script src="<c:url value="/resources/vendors/starrr/dist/starrr.js"/>" ></script>
							
  				<c:forEach var="avaliacao" items="${avaliacoes}" varStatus="Starloop">
							<script>
						      $(document).ready(function() {
						        $('.stars-existing'+${Starloop.index}).starrr({
						          rating: ${ avaliacao.nota_avaliacao },
						          readOnly: true
						        });
						      });
					        </script>
				</c:forEach>

    <!-- Starrr -->
    <script>
      $(document).ready(function() {
        $(".stars").starrr();

        $('.stars').on('starrr:change', function (e, value) {
          $('.stars-count').html(value);
        });
      });
    </script>
    <!-- /Starrr -->