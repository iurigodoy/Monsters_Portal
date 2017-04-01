<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateCargo"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="car_nome" class="form-control" placeholder="Nome" title="Nome" value="${ cargo.car_nome }">
</div>

<!--	Booleano	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="car_padrao" class="js-switch" title="Cargo Padrao" value="${ cargo.car_padrao }"> <i class="fa fa-plus"></i> Cargo Padrao
  </label>
</div>

<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>

<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_cargo"	value="${ cargo.id_cargo }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ car.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty car.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ car.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ car.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ car.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ car.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ car.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>