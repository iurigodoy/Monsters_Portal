<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateCliente"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="nome_cli" class="form-control" placeholder="Nome" title="Nome" value="${ cliente.nome_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cpf_cli" class="form-control" placeholder="CPF" title="CPF" value="${ cliente.cpf_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cpnj_cli" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ cliente.cpnj_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="sexo_cli" class="form-control" placeholder="Sexo" title="Sexo" value="${ cliente.sexo_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="senha_cli" class="form-control" placeholder="Senha" title="Senha" value="${ cliente.senha_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cep_cli" class="form-control" placeholder="CEP" title="CEP" value="${ cliente.cep_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="estado_cli" class="form-control" placeholder="Estado" title="Estado" value="${ cliente.estado_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cidade_cli" class="form-control" placeholder="Cidade" title="Cidade" value="${ cliente.cidade_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="endereco_cli" class="form-control" placeholder="Endereco" title="Endereco" value="${ cliente.endereco_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="numero_cli" class="form-control" placeholder="Numero" title="Numero" value="${ cliente.numero_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="complemento_cli" class="form-control" placeholder="Complemento" title="Complemento" value="${ cliente.complemento_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="residencial_cli" class="form-control" placeholder="Residencial" title="Residencial" value="${ cliente.residencial_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="celular_cli" class="form-control" placeholder="Celular" title="Celular" value="${ cliente.celular_cli }">
</div>

<!--	Input com ícone
		(Preferencial)  	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="email_cli" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ cliente.email_cli }">
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