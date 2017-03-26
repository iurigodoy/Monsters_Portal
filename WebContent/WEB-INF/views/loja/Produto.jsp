<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:set var="count_prod" value="1" scope="page" />

<fmt:setLocale value="pt-BR" />

<c:forEach var="produto" items="${produtos}">
	<c:if test="${count_prod == 1}"><div class="row"></c:if>
	
	
	
			<c:set var="parcelas"		value="12" scope="page" />
			<c:set var="dividir_prod"	value="10" scope="page" />
			<c:set var="valor_prod_div"	value="${ produto.preco_produto / dividir_prod }" scope="page" />
			<c:set var="valor_parcelas"	value="${ valor_prod_div * parcelas }" scope="page" />
	
	
	
		<div class="col-xs-3">
			<div class="panel panel-default panel-produto">
<!--------------------------------------	IMAGEM	--------------------------------------->
				  <a href="<c:url value="/Produtos/${ produto.nome_produto }"/>">
					<div class="panel-body" align="center" title="${ produto.nome_produto }">
					
						<c:forEach var="imagem" items="${ produto.imagem }" begin="0" end="0">
					  		<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_imagem }"/>" class="img_prod_container" >
						</c:forEach>
					
					</div>
				  </a>
				  
				  <div class="panel-body">
<!--------------------------------------	NOME	--------------------------------------->
					<p>
					  <h4 class="panel-title nome_produto" align="center" title="${ produto.nome_produto }">
						<a href="<c:url value="/Produtos/${ produto.nome_produto }"/>">${ fn:substring(produto.nome_produto,0,16) } ...</a>
					  </h4>
					</p>
					
					<!-- Se houver desconto -->
<!--------------------------------------	CALCULO do DESCONTO 	--------------------------------------->
		 			  <c:if test="${ produto.promocao_produto == true }">
		 			  
							
							<c:set var="calc_desconto_prod"	value="${ produto.preco_produto * ( produto.desconto_produto / 100 ) }" scope="page" />
							<c:set var="desconto_prod"	value="${ produto.preco_produto - calc_desconto_prod }" scope="page" />
		 			  
							<c:set var="valor_prod_div"	value="${ desconto_prod / dividir_prod }" scope="page" />
							<c:set var="valor_parcelas"	value="${ valor_prod_div * parcelas }" scope="page" />
		 			  
		 			  
						<font class="preco_desconto_preco">de <font class="preco_desconto"><fmt:formatNumber value="${ produto.preco_produto }" type="currency"/></font> por</font><br>
						<font class="preco"> <fmt:formatNumber value="${ desconto_prod }" type="currency"/> </font>
						
					  </c:if>
						
						
						
<!--------------------------------------	Se não houver DESCONTO 	--------------------------------------->
		 			  <c:if test="${ produto.promocao_produto == false }">
						<br><font class="preco"> <fmt:formatNumber value="${ produto.preco_produto }" type="currency"/> </font>
					  </c:if>
<!--------------------------------------	DESCONTO 	--------------------------------------->
					<p class="parcelas">${ parcelas } x de <fmt:formatNumber value="${ valor_prod_div }" type="currency"/> sem juros</p>
					
					
			  		<a href="<c:url value="/Pagamento/${ produto.nome_produto }"/>">
					  <button class="btn btn-danger btn-block btn-comprar">Comprar</button>
				    </a>
				    
				    
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