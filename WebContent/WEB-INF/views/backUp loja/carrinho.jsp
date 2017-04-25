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
		
		  <table class="table table-striped dt-responsive nowrap" cellspacing="0" width="100%">
			<thead>
			 <tr></tr>
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
					<td>${ prod.quantidade }</td>
					<td>${ prod.produto_has_fornecedor.preco_prod }</td><!-- PROVISÓRIO -->
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
			  	<tr id="total-carrinho"><td></td><td></td><td></td><td>${ carrinho.total }</td><td></td></tr>
			</tbody>
		  </table>
	    
		</div>
	  </div>
	</div>
  </div>
<c:import url="Footer.jsp" />