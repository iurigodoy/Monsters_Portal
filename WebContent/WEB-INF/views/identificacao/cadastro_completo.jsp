<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:useBean id="cliente" class="br.com.monster.portal.model.Cliente"></jsp:useBean>

					<strong class="red"><form:errors path="cliente.nome_cli"/></strong>
					<strong><form:errors path="cliente.cpf_cli"/></strong>
					<strong><form:errors path="cliente.cnpj_cli"/></strong>
					<strong><form:errors path="cliente.sexo_cli"/></strong>
					<strong><form:errors path="cliente.senha_cli"/></strong>
					<strong><form:errors path="cliente.cep_cli"/></strong>
					<strong><form:errors path="cliente.estado_cli"/></strong>
					<strong><form:errors path="cliente.cidade_cli"/></strong>
					<strong><form:errors path="cliente.endereco_cli"/></strong>
					<strong><form:errors path="cliente.numero_cli"/></strong>
					<strong><form:errors path="cliente.complemento_cli"/></strong>
					<strong><form:errors path="cliente.residencial_cli"/></strong>
					<strong><form:errors path="cliente.celular_cli"/></strong>
					<strong><form:errors path="cliente.email_cli"/></strong>
					<strong><form:errors path="cliente.ativo_cli"/></strong>

				<form action="<c:url value="CreateCliente"/>" method="POST" class="form-horizontal form-label-left input_mask">
					<input type="hidden" value="1" name="ativo_cli">

				<div class="row">
					  <div class="col-md-12 col-sm-12 col-xs-12 form-group">
						<input type="text" name="nome_cli" class="form-control" placeholder="Nome" title="Nome" value="${ cliente.nome_cli }">
					  </div>
				</div>

				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="cpf_cli" class="form-control" placeholder="CPF" title="CPF" value="${ cliente.cpf_cli }">
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="cnpj_cli" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ cliente.cnpj_cli }">
					</div>
				</div>

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
						<label class="radio-inline">Sexo:</label>
					    <label class="radio-inline">
					      <input type="radio" name="sexo_cli" value="1"> Masculino
					    </label>
					    <label class="radio-inline">
					      <input type="radio" name="sexo_cli" value="0"> Feminino
					    </label>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-6 form-group">
					  <input type="text" name="cep_cli" class="form-control" placeholder="CEP" title="CEP" value="${ cliente.cep_cli }">
							  	  <a href="http://m.correios.com.br/movel/buscaCepConfirma.do" target="blank">Não sei meu CEP</a>
					</div>

				<div class="col-md-6 col-sm-6 col-xs-6 form-group">
				  <select name="estado_cli" class="form-control" title="Estado">
				    <option value="">Estado</option>
				    <option value="AC">Acre</option>
				    <option value="AL">Alagoas</option>
				    <option value="AP">Amapá</option>
				    <option value="AM">Amazonas</option>
				    <option value="BA">Bahia</option>
				    <option value="CE">Ceará</option>
				    <option value="DF">Distrito Federal</option>
				    <option value="ES">Espirito Santo</option>
				    <option value="GO">Goiás</option>
				    <option value="MA">Maranhão</option>
				    <option value="MS">Mato Grosso do Sul</option>
				    <option value="MT">Mato Grosso</option>
				    <option value="MG">Minas Gerais</option>
				    <option value="PA">Pará</option>
				    <option value="PB">Paraíba</option>
				    <option value="PR">Paraná</option>
				    <option value="PE">Pernambuco</option>
				    <option value="PI">Piauí</option>
				    <option value="RJ">Rio de Janeiro</option>
				    <option value="RN">Rio Grande do Norte</option>
				    <option value="RS">Rio Grande do Sul</option>
				    <option value="RO">Rondônia</option>
				    <option value="RR">Roraima</option>
				    <option value="SC">Santa Catarina</option>
				    <option value="SP">São Paulo</option>
				    <option value="SE">Sergipe</option>
				    <option value="TO">Tocantins</option>
				  </select>
				</div>
				</div>

				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="cidade_cli" class="form-control" placeholder="Cidade" title="Cidade" value="${ cliente.cidade_cli }">
					</div>

					<!-- <div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="endereco_cli" class="form-control" placeholder="Bairro" title="Bairro" value="${ cliente.endereco_cli }">
					</div> -->
				</div>

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="endereco_cli" class="form-control" placeholder="Endereco" title="Endereco" value="${ cliente.endereco_cli }">
					</div>
				</div>

				<div class="row">
					<div class="col-md-3 col-sm-4 col-xs-4 form-group">
					  <input type="text" name="numero_cli" class="form-control" placeholder="Numero" title="Numero" value="${ cliente.numero_cli }">
					</div>

					<div class="col-md-9 col-sm-8 col-xs-8 form-group">
					  <input type="text" name="complemento_cli" class="form-control" placeholder="Complemento" title="Complemento" value="${ cliente.complemento_cli }">
					</div>
				</div>
					
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="residencial_cli" class="form-control has-feedback-left" placeholder="Telefone Residencial" title="Telefone Residencial" value="${ cliente.residencial_cli }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-phone"></i></span>
					</div>
					
					<div class="col-md-6 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="celular_cli" class="form-control has-feedback-left" placeholder="Celular (Opcional)" title="Celular" value="${ cliente.celular_cli }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-mobile"></i></span>
					</div>
				</div>

					<!--	Input com Ã­cone
							(Preferencial)  	-->
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="text" name="email_cli" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ cliente.email_cli }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group">
					  <input type="password" name="senha_cli" class="form-control has-feedback-left" placeholder="Senha" title="Senha" value="${ cliente.senha_cli }">
					  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-lock"></i></span>
					</div>
				</div>

				<div class="row">
					<!--	Booleano	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="news_letter_cli" class="js-switch" title="Receber nosso NewsLetter" value="${ cliente.news_letter_cli }" > <i class="fa fa-newspaper-o"></i> Receber nosso NewsLetter
					  </label>
					</div>
				</div>


					<!--	BotÃ£o de envio	-->
					<div class="btn-group pull-right">
					  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
						<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
					  </button>
					</div>

					</form>