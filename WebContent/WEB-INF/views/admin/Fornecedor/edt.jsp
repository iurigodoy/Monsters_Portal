<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateFornecedor"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_nome" class="form-control" placeholder="Nome" title="Nome" value="${ fornecedor.for_nome }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_cnpj" class="form-control" placeholder="CPNJ" title="CPNJ" value="${ fornecedor.for_cnpj }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_cep" class="form-control" placeholder="CEP" title="CEP" value="${ fornecedor.for_cep }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_estado" class="form-control" placeholder="Estado" title="Estado" value="${ fornecedor.for_estado }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_cidade" class="form-control" placeholder="Cidade" title="Cidade" value="${ fornecedor.for_cidade }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_endereco" class="form-control" placeholder="Endereco" title="Endereco" value="${ fornecedor.for_endereco }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_numero" class="form-control" placeholder="Numero" title="Numero" value="${ fornecedor.for_numero }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_complemento" class="form-control" placeholder="Complemento" title="Complemento" value="${ fornecedor.for_complemento }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_comercial" class="form-control" placeholder="Comercial" title="Comercial" value="${ fornecedor.for_comercial }">
</div>

<!--	Input com ícone
		(Preferencial)  	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="for_email" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fornecedor.for_email }">
  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
</div>


<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>
<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_fornecedor"	value="${ fornecedor.id_fornecedor }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ for.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty for.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ for.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ for.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ for.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ for.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ for.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>