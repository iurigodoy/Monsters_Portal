<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="Header.jsp" />
  <div class="content">
	<div class="col-xs-12">
	  <div class="panel panel-default">
		<div class="panel-heading">
		  <h2 class="panel-title">
			Carrinho
		  </h2>
		</div>
		<div class="panel-body">
		<c:if test="${ (carrinho.total > 0.0) }">
		  <table class="table table-striped dt-responsive nowrap" cellspacing="0" width="100%">
			<thead>
			 <tr>
			 	<td></td>
			 	<td></td>
			 	<td align="center">fornecedor</td>
			 	<td>quantidade</td>
			 	<td>preço unitário</td>
			 	<td></td>
			 </tr>
			</thead>
			<tbody>
			  <c:forEach var="prod" items="${carrinho.itens}" varStatus="delete">

				  <tr>
				  	<td>
					  <c:forEach var="imagem" items="${ prod.produto_has_fornecedor.produto.imagem }" begin="0" end="0">
						<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_ima }"/>" class="img_prod_container" >
					  </c:forEach>
					</td>
				  	<td>${ prod.produto_has_fornecedor.produto.nome_pro }</td>
				  	<td align="center">
					 <small>Vendido e entregue por:</small><br>
					 <strong>${ prod.produto_has_fornecedor.fornecedor.nome_for }</strong>
				  	</td>
					<td>${ prod.quantidade }</td>
					<td>R$ ${ prod.produto_has_fornecedor.preco_prod }</td><!-- PROVISÓRIO -->
					<td>
					  <form action="<c:url value="RemoveItemCarrinho"/>" method="POST">
						  <input type="hidden" name="indiceItem" value="${ delete.index }">
						  <button type="submit" class="btn btn-xs btn-danger pull-right" data-delete="${ delete.index }" title="Remover do carrinho">
							<i class="fa fa-close" style="font-size:12px;"></i>
						  </button>
					  </form>
					</td>
				  </tr>

			  </c:forEach>
			  	<tr id="total-carrinho"><td></td><td></td><td></td><td>total: R$  ${ carrinho.total }</td><td></td></tr>
			</tbody>
		  </table>
		  <div class="col-xs-12 col-sm-4 col-md-3 pull-right">
			<a href="<c:url value="/checarIdentificacao"/>">
			  <button class="btn btn-danger btn-block btn-comprar">
				<i class="fa fa-"></i> Finalizar Compra
			  </button>
			</a>
		  </div>
		  </c:if>
		  <c:if test="${ not (carrinho.total > 0.0) }"><p>Nenhum Item no carrinho</p></c:if>
		</div>
	  </div>
	</div>
  </div>
<c:import url="Footer.jsp" />