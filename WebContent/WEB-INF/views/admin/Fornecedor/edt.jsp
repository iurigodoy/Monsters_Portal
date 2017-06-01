<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="nome_for" class="form-control" placeholder="Nome" title="Nome" value="${ fornecedor.nome_for }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cnpj_for" class="form-control" placeholder="CPNJ" title="CPNJ" value="${ fornecedor.cnpj_for }">
</div>

<div class="col-md-6 col-sm-6 col-xs-12 form-group">
  <input type="text" name="cep_for" class="form-control" placeholder="CEP" title="CEP" value="${ fornecedor.cep_for }">
</div>

<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					<select class="form-control" name="estado_for">
							<option value="${ fornecedor.estado_for }">${ fornecedor.estado_for }
							<option value="">Estado
							<option value="AC">AC
							<option value="AL">AL
							<option value="AP">AP
							<option value="AM">AM
							<option value="BA">BA
							<option value="CE">CE
							<option value="DF">DF
							<option value="ES">ES
							<option value="GO">GO
							<option value="MA">MA
							<option value="MT">MT
							<option value="MS">MS
							<option value="MG">MG
							<option value="PA">PA
							<option value="PB">PB
							<option value="PR">PR
							<option value="PE">PE
							<option value="PI">PI
							<option value="RJ">RJ
							<option value="RN">RN
							<option value="RO">RO
							<option value="RS">RS
							<option value="RR">RR
							<option value="SC">SC
							<option value="SP">SP
							<option value="SE">SE
							<option value="TO">TO
						</select>
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="cidade_for" class="form-control" placeholder="Cidade" title="Cidade" value="${ fornecedor.cidade_for }">
</div>

<div class="col-md-9 col-sm-9 col-xs-12 form-group">
  <input type="text" name="endereco_for" class="form-control" placeholder="Endereco" title="Endereco" value="${ fornecedor.endereco_for }">
</div>

<div class="col-md-3 col-sm-3 col-xs-12 form-group">
  <input type="text" name="numero_for" class="form-control" placeholder="Numero" title="Numero" value="${ fornecedor.numero_for }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="complemento_for" class="form-control" placeholder="Complemento" title="Complemento" value="${ fornecedor.complemento_for }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="comercial_for" class="form-control has-feedback-left" placeholder="Comercial" title="Comercial" value="${ fornecedor.comercial_for }">
  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-phone"></i></span>
</div>

<!--	Input com ícone
		(Preferencial)  	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="email_for" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ fornecedor.email_for }">
  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
</div>

<!--							Padrões do Sistema									-->

<input type="hidden" name="id_fornecedor"	value="${ fornecedor.id_fornecedor }"/>
<input type="hidden" name="logo_for" value="${ fornecedor.logo_for }">

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ fornecedor.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty fornecedor.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ fornecedor.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ fornecedor.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ fornecedor.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ fornecedor.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ fornecedor.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>
