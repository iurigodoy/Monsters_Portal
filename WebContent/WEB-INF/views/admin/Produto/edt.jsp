<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateProduto"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="nome_pro" class="form-control" placeholder="Nome" title="Nome" value="${ produto.nome_pro }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="descricao_pro" class="form-control" placeholder="Descricao" title="Descricao" value="${ produto.descricao_pro }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="desconto_pro" class="form-control" placeholder="Desconto" title="Desconto" value="${ produto.desconto_pro }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="peso_pro" class="form-control" placeholder="Peso" title="Peso" value="${ produto.peso_pro }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="altura_pro" class="form-control" placeholder="Altura" title="Altura" value="${ produto.altura_pro }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="largura_pro" class="form-control" placeholder="Largura" title="Largura" value="${ produto.largura_pro }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="comprimento_pro" class="form-control" placeholder="Comprimento" title="Comprimento" value="${ produto.comprimento_pro }">
</div>




<!--	Booleano	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="publicado_pro" class="js-switch"   title="Produto Publicado" value="${ produto.publicado_pro }"> <i class="fa fa-plus"></i> Produto Publicado ?
  </label>
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="destaque_pro" class="js-switch"   title="Produto Destaque" value="${ produto.destaque_pro }"> <i class="fa fa-plus"></i> Produto Destaque ?
  </label>
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="promocao_pro" class="js-switch"   title="Promocao" value="${ produto.promocao_pro }"> <i class="fa fa-plus"></i> Produto em Promoção ?
  </label>
</div>
<!--	Select com
		Relacionamento		-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <select type="hidden"name="imagem.id_imagem" class="form-control">
	<option value="0">Imagem</option>
  </select>
  <!-- exemplo para facilitar pro usuário -->
  <p>Não encontrou a imagem certa? <a href="<c:url value="/imagem"/>" title="Editar Imagens">Clique aqui</a></p>
</div>

<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>
<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_produto"	value="${ produto.id_produto }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ produto.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty produto.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ produto.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ produto.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ produto.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ produto.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ produto.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>


