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
		<h3 align="center">${ produto.nome_produto }
			<!-- <span class="star glyphicon glyphicon-star gold-star"></span>
			<span class="star glyphicon glyphicon-star gold-star"></span>
			<span class="star glyphicon glyphicon-star gold-star"></span>
			<span class="star glyphicon glyphicon-star gold-star"></span>
			<span class="star glyphicon glyphicon-star-empty gold-star"></span> (50) -->
		</h3>
		
	  
	  		<div class="col-xs-5">
		
			  
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


				
				
				
				  	<c:set var="EscolhaCount" value="0" scope="page" />
					<!-- Indicators -->
					  <ol class="carousel-indicators">
					  	<c:forEach var="imagem" items="${ produto.imagem }">
							<li data-target="#myCarousel" data-slide-to="${ EscolhaCount }" class="imgs_galery <c:if test="${EscolhaCount == 1}">active</c:if>">
								<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_imagem }"/>" class="img_container" >
							</li>
					  	  <c:set var="EscolhaCount" value="${EscolhaCount + 1}" scope="page"/>
						</c:forEach>
					  </ol>
				</div>
				
				
			  </div>
				  
				  
<!--------------------------------------	DESCRIÇÃO	--------------------------------------->
			  <div class="col-xs-7">
				<div class="panel panel-default">
				  <div class="panel-body">
					<div class="col-xs-6">
					
						<span class="star glyphicon glyphicon-star gold-star"></span>
						<span class="star glyphicon glyphicon-star gold-star"></span>
						<span class="star glyphicon glyphicon-star gold-star"></span>
						<span class="star glyphicon glyphicon-star gold-star"></span>
						<span class="star glyphicon glyphicon-star-empty gold-star"></span>
						
						<p align="left">
						  
<!--------------------------------------	CALCULO do DESCONTO 	--------------------------------------->
						  <c:if test="${ produto.promocao_produto == true }">
		 			  
							
							<c:set var="calc_desconto_prod"	value="${ produto.preco_produto * ( produto.desconto_produto / 100 ) }" scope="page" />
							<c:set var="desconto_prod"	value="${ produto.preco_produto - calc_desconto_prod }" scope="page" />
		 			  
							<c:set var="valor_prod_div"	value="${ desconto_prod / dividir_prod }" scope="page" />
							<c:set var="valor_parcelas"	value="${ valor_prod_div * parcelas }" scope="page" />
							
							
							<!-- <font class="preco_desconto"> <fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font> -
							<font class="desconto"> <fmt:formatNumber value="${ calc_desconto_prod }" type="currency"/></font> = <br>
							<font class="preco"> <fmt:formatNumber value="${ desconto_prod }" type="currency"/> </font> -->
		 			  
		 			  
							<font class="preco_desconto_preco">de <font class="preco_desconto"><fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font> por</font><br>
							<font class="preco"> <fmt:formatNumber value="${ desconto_prod }" type="currency"/> </font>
						
						  </c:if>
						  
						  
<!--------------------------------------	Se não houver DESCONTO 	--------------------------------------->
						  <c:if test="${ produto.promocao_produto == false }">
							<font class="preco"> <fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font>
						  </c:if>
						  
						</p>
<!--------------------------------------	DESCONTO 	--------------------------------------->
						<p align="left" class="desconto">
							<c:if test="${ produto.promocao_produto == true }">
								Desconto de ${ produto.desconto_produto }%
							</c:if>
						</p>
						<p align="left">${ parcelas } x de <fmt:formatNumber value="${ valor_prod_div }" type="currency"/> sem juros</p>
					</div>
					
					
					<div class="col-xs-6">
					  <div class="row">
				  
					  	<c:if test="${empty clienteLogado.usuario_cliente}">
							<h3>Faça o <a href="Login">Login</a></h3>
							<h4>ou <a href="Cadastro">Cadastre-se</a></h4>
						</c:if>
						
					 	<c:if test="${not empty clienteLogado.usuario_cliente}">
						  <div class="row"><br></div>
						  <div class="row">
						 	  <div class="col-xs-12">
								  <a href="<c:url value="/Pagamento/${ produto.nome_produto }"/>">
									<button class="btn btn-lg btn-danger btn-block btn-comprar">Comprar</button>
								  </a>
							  </div>
						 		<!-- <div class="btn-group">
									<button class="btn btn-sm btn-success"><span class="glyphicon glyphicon-gift"></span> Presentear</button>
									<button class="btn btn-sm btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</button>
								</div> -->
							</div>
						</c:if>
					
					  </div>
					</div>
							<!--			FORNECEDOR			

						<div class="btn btn-sm form-control">Fornecedor 1</div>
						<div class="btn btn-sm form-control">Fornecedor 2</div>
						<div class="btn btn-sm form-control">Fornecedor 3</div>-->
				  </div>
				  
				  
				  
				  <!-- <div class="panel-body" align="center">
					
				  </div> -->
				  
				  <div class="col-xs-12">
				    <div class="row"><br><br></div>
				    <div class="row">
						<!--			FRETE			
						<h4 align="center">Calcular frete e prazo: </h4>
						<div class="form-horizontal">
						  <div class="form-group">
							<label for="cep" class="col-md-4 control-label">CEP:</label>
                            <div class="col-md-6">
						  		<c:if test="${empty clienteLogado.usuario_cliente}">
									<input type="text" id="cep" name="cep" value="" class="form-control cep">
								</c:if>
						  		<c:if test="${not empty clienteLogado.usuario_cliente}">
									<input type="text" id="cep" name="cep" class="form-control cep" value="${ cep_cliente }">
								</c:if>
							</div>
						  </div>
						</div>-->
						<h4 align="center">Fornecedor: ${produto.fornecedor.nome_fornecedor} </h4>
					</div>
				  </div>
					
				</div>
			</div>
</div>
			
			
			
			  <div class="panel panel-default">
				<div class="panel-body">
				  <h3>Descrição técnica produto: </h3>
				  <h5>${ produto.descricao_produto }</h5>
				  
				  <div class="col-xs-12">
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
				</div>
			  </div>
			
	  </c:forEach>
</div>
				
				<c:if test="${not empty clienteLogado.usuario_cliente}">
				  <div class="panel panel-default">
					<div class="panel-body">
					  <div class="col-xs-2">
						<div class="img-thumbnail">
							<span class="glyphicon glyphicon-user" style="font-size:32px;"></span>
						</div><br>
						${clienteLogado.usuario_cliente}
					  </div>
					  <form action="CreateAvaliacao" method="POST">
						<div class="col-xs-10">
						  <div class="row">
							<div class="btn-group" data-toggle="buttons">
									<input type="hidden" name="id_produto"		value="${ id_produto }">
									<input type="hidden" name="nome_produto"	value="${ nome_produto }">
									<label class="btn btn-md">
										<input type="radio"	name="nota_avaliacao" value="1" checked>
										<span class="star glyphicon glyphicon-star-empty gold-star"></span>
									</label>
									<label class="btn btn-md">
										<input type="radio"	name="nota_avaliacao" value="2">
										<span class="star glyphicon glyphicon-star-empty gold-star"></span>
									</label>
									<label class="btn btn-md">
										<input type="radio"	name="nota_avaliacao" value="3">
										<span class="star glyphicon glyphicon-star-empty gold-star"></span>
									</label>
									<label class="btn btn-md">
										<input type="radio"	name="nota_avaliacao" value="4">
										<span class="star glyphicon glyphicon-star-empty gold-star"></span>
									</label>
									<label class="btn btn-md">
										<input type="radio"	name="nota_avaliacao" value="5">
										<span class="star glyphicon glyphicon-star-empty gold-star"></span>
									</label>
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
				  </div>
				</c:if>
				
				
		
  				<c:forEach var="avaliacao" items="${avaliacoes}">
				  <div class="panel panel-default">
					<div class="panel-body">
					  <div class="col-xs-2">
						<div class="img-thumbnail">
							<span class="glyphicon glyphicon-user" style="font-size:32px;"></span>
						</div><br>
					  </div>
					  <div class="col-xs-10">
						<div class="row">
						<c:choose>
						    <c:when test="${avaliacao.nota_avaliacao >= 0 and avaliacao.nota_avaliacao < 2}">
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span> (${avaliacao.nota_avaliacao})
						    </c:when>
						    <c:when test="${avaliacao.nota_avaliacao >= 2 and avaliacao.nota_avaliacao < 4}">
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span> (${avaliacao.nota_avaliacao})
						    </c:when>
						    <c:when test="${avaliacao.nota_avaliacao >= 4 and avaliacao.nota_avaliacao < 6}">
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span> (${avaliacao.nota_avaliacao})
						    </c:when>
						    <c:when test="${avaliacao.nota_avaliacao >= 6 and avaliacao.nota_avaliacao < 8}">
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star-empty gold-star"></span> (${avaliacao.nota_avaliacao})
						    </c:when>
						    <c:when test="${avaliacao.nota_avaliacao >= 8 and avaliacao.nota_avaliacao < 10}">
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span>
								<span class="star glyphicon glyphicon-star gold-star"></span> (${avaliacao.nota_avaliacao})
						    </c:when>
						</c:choose>
						</div>
						<div class="row">
							<p>
							${ avaliacao.comentario_avaliacao }
							</p>
						</div>
					  </div>
					</div>
				  </div>
				</c:forEach>
				  
<c:import url="Footer.jsp" />