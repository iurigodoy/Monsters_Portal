<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="nome_cli" class="form-control" placeholder="Nome" title="Nome" value="${ cliente.nome_cli }">
</div>

<div class="col-md-6 col-sm-6 col-xs-12 form-group">
  <input type="text" name="cpf_cli" class="form-control" placeholder="CPF" title="CPF" value="${ cliente.cpf_cli }">
</div>

<div class="col-md-6 col-sm-6 col-xs-12 form-group">
  <input type="text" name="cnpj_cli" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ cliente.cnpj_cli }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="sexo_cli" class="form-control" placeholder="Sexo" title="Sexo" value="${ cliente.sexo_cli }">
</div>


					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="cep_cli" class="form-control" placeholder="CEP" title="CEP" value="${ cliente.cep_cli }">
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <select name="estado_cli" class="form-control">
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

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="cidade_cli" class="form-control" placeholder="Cidade" title="Cidade" value="${ cliente.cidade_cli }">
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="endereco_cli" class="form-control" placeholder="Endereco" title="Endereco" value="${ cliente.endereco_cli }">
					</div>

					<div class="col-md-3 col-sm-3 col-xs-12 form-group">
					  <input type="text" name="numero_cli" class="form-control" placeholder="Numero" title="Numero" value="${ cliente.numero_cli }">
					</div>

					<div class="col-md-9 col-sm-9 col-xs-12 form-group">
					  <input type="text" name="complemento_cli" class="form-control" placeholder="Complemento" title="Complemento" value="${ cliente.complemento_cli }">
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="residencial_cli" class="form-control" placeholder="Tel. Residencial" title="Residencial" value="${ cliente.residencial_cli }">
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
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
	<input type="checkbox" name="ativo_cli" class="js-switch" title="Cliente Ativo" value="${ cliente.ativo_cli }"> Cliente Ativo 
  </label>
</div>

<!--							Padrões do Sistema									-->

<input type="hidden" name="id_cliente"	value="${ cliente.id_cliente }"/>
<input type="hidden" name="senha_cli" class="form-control" placeholder="Senha" title="Senha" value="${ cliente.senha_cli }">

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ cliente.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty cliente.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ cliente.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ cliente.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ cliente.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ cliente.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ cliente.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

