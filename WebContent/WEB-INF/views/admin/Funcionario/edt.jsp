<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateFuncionario"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="fun_nome" class="form-control" placeholder="Nome" title="Nome" value="${ funcionario.fun_nome }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="fun_cpf" class="form-control" placeholder="CPF" title="CPF" value="${ funcionario.fun_cpf }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="fun_celular" class="form-control" placeholder="Celular" title="Celular" value="${ funcionario.fun_celular }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="fun_senha" class="form-control" placeholder="Senha" title="Senha" value="${ funcionario.fun_senha }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="fun_foto" class="form-control" placeholder="Foto" title="Foto" value="${ funcionario.fun_foto}">
</div>
<!--	Input com ícone
		(Preferencial)  	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="fun_email" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ funcionario.fun_email }">
  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
</div>


<!--	Select com
		Relacionamento		-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <select name="cargo.id_cargo" class="form-control">
	<option value="0">Cargo</option>
	<c:forEach var="cargo" items="${cargos}">
	  <option value="${ cargo.id_cargo }">${ cargo.nome_cargo }</option>
	</c:forEach>
  </select>
  <!-- exemplo para facilitar pro usuário -->
  <p>Não encontrou o cargo certo? <a href="<c:url value="/cargo"/>" title="Editar Cargos">Clique aqui</a></p>
</div>

<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>
<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_funcionario"	value="${ funcionario.id_funcionario }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ fun.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty fun.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ fun.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ fun.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ fun.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ fun.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ fun.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>