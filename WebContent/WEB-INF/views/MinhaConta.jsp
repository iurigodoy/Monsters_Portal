<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="Header.jsp" />
  <div class="container">
	<div class="panel panel-defaut">
	  <div class="panel-body escolha-panel">
		<h2>${ clienteLogado.nome_cli }</h2>
	  	<div class="col-xs-3">
	  	  <ul class="nav nav-tabs tabs-left">
	  	  	<li class="active"><a href="#pedidos" data-toggle="tab">Meus Pedidos</a></li>
	  	  	<li><a href="#dados" data-toggle="tab">Dados Cadastrais</a></li>
	  	  	<li><a href="#senha" data-toggle="tab">Alterar Senha</a></li>
	  	  </ul>
	  	</div>
	  	<div class="col-xs-9">
	  	  <div class="tab-content">
	  	  	<div class="tab-pane active" id="pedidos">
			  	<h4>Meus Pedidos</h4>
			  	<table class="table table-striped dt-responsive nowrap">
			      <thead>
					<tr>
					  <th style="width: 25%">Identificação do pedido</th>
					  <th style="width: 25%">Status</th>
					  <th style="width: 25%">Total:</th>
					  <th style="width: 25%">Realizado em:</th>
					</tr>
				  </thead>
				  <tbody>
					<c:forEach var="pedido" items="${pedidos}">
					  <tr>
					  	<td>${ pedido.id_pedido }</td>
					  	<td>
					  	${ pedido.status_ped }
					  	</td>
					  	<td>R$ ${ pedido.preco_ped }</td>
						<td>${ pedido.created_at }</td>
					  </tr>
					</c:forEach>
				  </tbody>
				</table>
	  	  	</div><!-- tab-pane -->
	  	  	<div class="tab-pane" id="dados">
	  		  <h4>Meus Dados</h4>
				<strong class="red">
	  				<form:errors path="cliente.nome_cli"/>
					<form:errors path="cliente.cpf_cli"/>
					<form:errors path="cliente.cnpj_cli"/>
					<form:errors path="cliente.sexo_cli"/>
					<form:errors path="cliente.senha_cli"/>
					<form:errors path="cliente.cep_cli"/>
					<form:errors path="cliente.estado_cli"/>
					<form:errors path="cliente.cidade_cli"/>
					<form:errors path="cliente.endereco_cli"/>
					<form:errors path="cliente.numero_cli"/>
					<form:errors path="cliente.complemento_cli"/>
					<form:errors path="cliente.residencial_cli"/>
					<form:errors path="cliente.celular_cli"/>
					<form:errors path="cliente.email_cli"/>
					<form:errors path="cliente.ativo_cli"/></strong>

		  		<form action="<c:url value="UpdateCliente"/>" method="POST" class="form-horizontal form-label-left input_mask">
					<input type="hidden" value="1" name="ativo_cli">

					<div class="row">
						  <div class="col-md-12 col-sm-12 col-xs-12 form-group">
							<input type="text" name="nome_cli" class="form-control" placeholder="Nome" title="Nome" value="${ clienteLogado.nome_cli }">
						  </div>
					</div>
	
					<div class="row">
					  <c:if test="${ not empty clienteLogado.cpf_cli }">
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="cpf_cli" class="form-control" placeholder="CPF" title="CPF" value="${ clienteLogado.cpf_cli }">
						</div>
					  </c:if>
					  <c:if test="${ not empty clienteLogado.cnpj_cli }">
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="cnpj_cli" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ clienteLogado.cnpj_cli }">
						</div>
					  </c:if>
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
						  <input type="text" name="cep_cli" class="form-control" placeholder="CEP" title="CEP" value="${ clienteLogado.cep_cli }">
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
						  <input type="text" name="cidade_cli" class="form-control" placeholder="Cidade" title="Cidade" value="${ clienteLogado.cidade_cli }">
						</div>
	
						<!-- <div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="endereco_cli" class="form-control" placeholder="Bairro" title="Bairro" value="${ clienteLogado.endereco_cli }">
						</div> -->
	
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="endereco_cli" class="form-control" placeholder="Endereco" title="Endereco" value="${ clienteLogado.endereco_cli }">
						</div>
					</div>
	
					<div class="row">
						<div class="col-md-3 col-sm-4 col-xs-4 form-group">
						  <input type="text" name="numero_cli" class="form-control" placeholder="Numero" title="Numero" value="${ clienteLogado.numero_cli }">
						</div>
	
						<div class="col-md-9 col-sm-8 col-xs-8 form-group">
						  <input type="text" name="complemento_cli" class="form-control" placeholder="Complemento" title="Complemento" value="${ clienteLogado.complemento_cli }">
						</div>
					</div>
						
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="residencial_cli" class="form-control has-feedback-left" placeholder="Telefone Residencial" title="Telefone Residencial" value="${ clienteLogado.residencial_cli }">
						  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-phone"></i></span>
						</div>
						
						<div class="col-md-6 col-sm-12 col-xs-12 form-group">
						  <input type="text" name="celular_cli" class="form-control has-feedback-left" placeholder="Celular (Opcional)" title="Celular" value="${ clienteLogado.celular_cli }">
						  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-mobile"></i></span>
						</div>
					</div>
	
						<!--	Input com Ã­cone
								(Preferencial)  	-->
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <input type="text" name="email_cli" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ clienteLogado.email_cli }">
						  <span class="form-control-feedback left" aria-hidden="true"><i class="fa fa-envelope-o"></i></span>
						</div>
						  <input type="hidden" name="senha_cli" value="${ clienteLogado.senha_cli }">
	
						<!--	Booleano	-->
						<div class="col-md-6 col-sm-6 col-xs-12 form-group">
						  <label>
							<input type="checkbox" name="news_letter_cli" class="js-switch" title="Receber nosso NewsLetter" value="${ clienteLogado.news_letter_cli }" > <i class="fa fa-newspaper-o"></i> Receber nosso NewsLetter
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
	  	  	</div><!-- tab-pane -->
	  	  	<div class="tab-pane" id="senha">
	  		  <h4>Alterar Senha</h4>
		  	  <form action="<c:url value="AlterarSenha"/>" method="POST" class="form-horizontal form-label-left input_mask">
		  		<input type="password" class="form-control" name="senha_antiga" placeholder="Senha antiga">
		  		<input type="password" class="form-control" name="nova_senha" placeholder="Nova senha">
		  		<input type="password" class="form-control" name="confirma_nova_senha" placeholder="Confirme a nova senha">
				<!--	BotÃ£o de envio	-->
				<div class="btn-group pull-right">
				  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
					<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Alterar
				  </button>
				</div>
		  	  </form>
	  	  	</div>
	  	  </div><!-- tab-content -->
	  	</div>
	  </div>
	</div>
  </div>
<c:import url="Footer.jsp" />