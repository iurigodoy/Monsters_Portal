<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:set var="count_prod" value="1" scope="page" />

<fmt:setLocale value="pt-BR" />

<c:forEach var="produto" items="${produtos}">
	<c:if test="${count_prod == 1}"><div class="row"></c:if>
	
	
	
			<c:forEach var="forn" items="${produto.produto_has_fornecedor}">
				<c:set var="valor_prod"	value="${ forn.preco_prod }" scope="page" />
			</c:forEach>
	
	
	
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="panel panel-default panel-produto">
<!--------------------------------------	IMAGEM	--------------------------------------->
				<p align="center">
				  <a href="<c:url value="/Produtos/${ produto.id_produto }"/>" title="${ produto.nome_pro }">
				  
					<c:forEach var="imagem" items="${ produto.imagem }" begin="0" end="0">
					  <img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_ima }"/>" class="img_prod_container" >
					</c:forEach>
					
				  </a>
				</p>
				  
				  <div class="panel-body">
<!--------------------------------------	NOME	--------------------------------------->
					<h4 class="nome_produto" title="${ produto.nome_pro }">
					  <a href="<c:url value="/Produtos/${ produto.id_produto }"/>">${ fn:substring(produto.nome_pro,0,30) } ...<br>
		 			  	<i class="fa fa-star gold-star"></i>
		 			  	<i class="fa fa-star gold-star"></i>
		 			  	<i class="fa fa-star gold-star"></i>
		 			  	<i class="fa fa-star gold-star"></i>
		 			  	<i class="fa fa-star"></i>
					  </a>
					  <strong class="red"><-- Erro!</strong>
					</h4>
		 			  	
					<!-- Se houver desconto -->
<!--------------------------------------	CALCULO do DESCONTO 	--------------------------------------->
		 			  <c:if test="${ produto.promocao_pro == true }">
						<font class="preco_desconto_preco">de <font class="preco_desconto"><fmt:formatNumber value="${ valor_prod }" type="currency"/></font> por</font><br>
						<font class="preco"> <fmt:formatNumber value="${ calcularDesconto(valor_prod) }" type="currency"/> </font>
					  </c:if>
						
						
						
<!--------------------------------------	Se n�o houver DESCONTO 	--------------------------------------->
		 			  <c:if test="${ produto.promocao_pro == false }">
						<br><font class="preco"> <fmt:formatNumber value="${ valor_prod }" type="currency"/> </font>
					  </c:if>
					
					
			  		<a href="<c:url value="/Pagamento/${ produto.id_produto }"/>">
					  <button class="btn btn-danger btn-block btn-comprar">Comprar</button>
				    </a>
				    
					<c:forEach var="forn" items="${produto.produto_has_fornecedor}">
						<form action="<c:url value="AdicionaItemCarrinho"/>" method="POST">
						  <input type="hidden" name="quantidade" value="1">
						  <input type="hidden" name="id_prod" value="${ forn.produto.id_produto }">
						  <input type="hidden" name="id_forn" value="${ forn.fornecedor.id_fornecedor }">
						  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
							<i class="fa fa-shopping-cart" style="font-size:12px;"></i> Carrinho
						  </button>
						</form>
				    </c:forEach>
				    
				  </div>

				  <div class="footer"></div>
			</div>
		</div>  
		
		
		
	<c:if test="${count_prod == 4}">
		</div>
		<c:set var="count_prod" value="0" scope="page" />
	</c:if>
	
	<c:set var="count_prod" value="${count_prod + 1}" scope="page"/>
</c:forEach>
<c:if test="${count_prod == 1}"></div><c:set var="count_prod" value="0" scope="page" /></c:if>
<c:if test="${count_prod == 2}"></div><c:set var="count_prod" value="0" scope="page" /></c:if>
<c:if test="${count_prod == 3}"></div><c:set var="count_prod" value="0" scope="page" /></c:if>
<c:if test="${count_prod == 4}"></div><c:set var="count_prod" value="0" scope="page" /></c:if>