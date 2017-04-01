<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateCliente"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_nome" class="form-control" placeholder="Nome" title="Nome" value="${ cliente.cli_nome }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_cpf" class="form-control" placeholder="CPF" title="CPF" value="${ cliente.cli_cpf }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_cnpj" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ cliente.cli_cnpj }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_sexo" class="form-control" placeholder="Sexo" title="Sexo" value="${ cliente.cli_sexo }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_senha" class="form-control" placeholder="Senha" title="Senha" value="${ cliente.cli_senha }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_cep" class="form-control" placeholder="CEP" title="CEP" value="${ cliente.cli_cep }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_estado" class="form-control" placeholder="Estado" title="Estado" value="${ cliente.cli_estado }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_cidade" class="form-control" placeholder="Cidade" title="Cidade" value="${ cliente.cli_cidade }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_endereco" class="form-control" placeholder="Endereco" title="Endereco" value="${ cliente.cli_endereco }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_numero" class="form-control" placeholder="Numero" title="Numero" value="${ cliente.cli_numero }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_complemento" class="form-control" placeholder="Complemento" title="Complemento" value="${ cliente.cli_complemento }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_residencial" class="form-control" placeholder="Residencial" title="Residencial" value="${ cliente.cli_residencial }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_celular" class="form-control" placeholder="Celular" title="Celular" value="${ cliente.cli_celular }">
</div>

<!--	Input com ícone
		(Preferencial)  	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cli_email" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ cliente.cli_email }">
  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
</div>


<!--	Booleano	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="ativo_cli" class="js-switch" title="Cliente Ativo" value="${ cliente.ativo_cli }"> <i class="fa fa-plus"></i> Cliente Ativo 
  </label>
</div>


<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>

<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_cliente"	value="${ cliente.id_cliente }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ cli.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty cli.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ cli.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ cli.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ cli.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ cli.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ cli.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>