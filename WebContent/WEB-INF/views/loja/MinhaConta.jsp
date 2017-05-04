<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="Header.jsp" />


<div class="panel panel-default">
  <div class="panel-heading">
	<h2 class="panel-title">
	  ${clienteLogado.usuario_cliente}
	</h2>
  </div>
<div class="panel-body">
  <div class="row">
	<div class="col-xs-12">
		<h5 style="font-size:16px;color:red;">
			<!-- ERROS AKI -->
			<form:errors path="cliente.id_cliente"/>
			<form:errors path="cliente.nome_cliente"/>
			<form:errors path="cliente.razao_cliente"/>
			<form:errors path="cliente.objetivo_cliente"/>
			<form:errors path="cliente.cpf_cliente"/>
			<form:errors path="cliente.cnpj_cliente"/>
			<form:errors path="cliente.sexo_cliente"/>
			<form:errors path="cliente.ativo_cliente"/>
			<form:errors path="cliente.usuario_cliente"/>
			<form:errors path="cliente.senha_cliente"/>
			<form:errors path="cliente.news_letter_cliente"/>
			<form:errors path="cliente.cep_cliente"/>
			<form:errors path="cliente.estado_cliente"/>
			<form:errors path="cliente.cidade_cliente"/>
			<form:errors path="cliente.endereco_cliente"/>
			<form:errors path="cliente.numero_cliente"/>
			<form:errors path="cliente.complemento_cliente"/>
			<form:errors path="cliente.residencial_cliente"/>
			<form:errors path="cliente.celular_cliente"/>
			<form:errors path="cliente.email_cliente"/>
			<!-- ... -->
		</h5>
	</div>
  </div>
  <div class="row">
  	
	<c:forEach var="cliente" items="${clienteLogadoInfo}">
	<form action="UpdateCliente" method="POST" class="form-horizontal">

		<input type="hidden" name="id_cliente"			value="${ cliente.id_cliente }">
		<input type="hidden" name="usuario_cliente"		value="${ cliente.usuario_cliente}">
		<input type="hidden" name="senha_cliente"		value="${ cliente.senha_cliente}">
		<input type="hidden" name="ativo_cliente"		value="${ cliente.ativo_cliente}">
		<input type="hidden" name="news_letter_cliente"	value="${ cliente.news_letter_cliente}">
		<input type="hidden" name="razao_cliente"		value="${ cliente.razao_cliente}">
		<input type="hidden" name="objetivo_cliente"	value="${ cliente.objetivo_cliente}">
		<input type="hidden" name="cnpj_cliente"		value="${ cliente.cnpj_cliente}">
  
	
	<div class="col-xs-3">
	  <h4 align="center">Alterar imagem de perfil</h4>
	  <div class="img-thumbnail">
		<span class="glyphicon glyphicon-user" style="font-size:120px;"></span>
	  </div>
	  <!-- <input type="file" class="filestyle"> -->
	</div>
	
	
	<div class="col-xs-9">
	  <h4 align="center">Alterar dados pessoais</h4>

						<div class="form-group{{ $errors->has('name') ? ' has-error' : '' }}">
							<label for="name" class="col-md-3 control-label">Nome</label>

							<div class="col-md-7">
								<input id="name" type="text" class="form-control" name="nome_cliente" value="${ cliente.nome_cliente }">


									<span class="help-block">
										<strong><form:errors path="cliente.nome_cliente"/></strong>
									</span>

							</div>
						</div>

						
                        <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
                            <label for="email" class="col-md-3 control-label">E-Mail</label>

                            <div class="col-md-7">
                                <input id="email" type="email" class="form-control" name="email_cliente" value="${ cliente.email_cliente }">
                            
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.email_cliente"/></strong>
                                    </span>
                            </div>
                        </div>
						

                        <div class="form-group{{ $errors->has('telefone') ? ' has-error' : '' }}">
                            <label for="telefone" class="col-md-3 control-label">Telefone</label>

                            <div class="col-md-7">
								<input type="text" id="telefone" name="residencial_cliente" class="form-control telefone_cliente" value="${ cliente.residencial_cliente }">
								  
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.residencial_cliente"/></strong>
                                    </span>
                            </div>
                        </div>
						

                        <div class="form-group{{ $errors->has('celular') ? ' has-error' : '' }}">
                            <label for="celular" class="col-md-3 control-label">Celular: </label>

                            <div class="col-md-7">
								<input type="text" id="celular" name="celular_cliente" class="form-control telefone_cliente" value="${ cliente.celular_cliente }">
								  
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.celular_cliente"/></strong>
                                    </span>
                            </div>
                        </div>
					
					
                        <div class="form-group{{ $errors->has('cpf') ? ' has-error' : '' }}">
                            <label for="cpf" class="col-md-3 control-label">CPF</label>

                            <div class="col-md-7">
								<input type="text" id="cpf" name="cpf_cliente" class="form-control cpf" required pattern="^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$" value="${ cliente.cpf_cliente }">


                                    <span class="help-block">
                                        <strong><form:errors path="cliente.cpf_cliente"/></strong>
                                    </span>

                            </div>
                        </div>
					
					
                        <div class="form-group{{ $errors->has('sexo') ? ' has-error' : '' }}">
                            <label for="sexo" class="col-md-3 control-label">Sexo</label>
                            <div class="col-md-7">
								<label class="radio-inline"><input type="radio" name="sexo_cliente" value="1" checked>Masculino</label>
								<label class="radio-inline"><input type="radio" name="sexo_cliente" value="0">Feminino</label>
								

                                    <span class="help-block">
                                        <strong><form:errors path="cliente.sexo_cliente"/></strong>
                                    </span>

                            </div>
                        </div>
					
					
						<div class="form-group{{ $errors->has('estado') ? ' has-error' : '' }}">
							<label for="estado" class="col-md-3 control-label">Estado</label>

							<div class="col-md-3">
								<select name="estado_cliente" id="estado" class="form-control">
									<option value="${ cliente.estado_cliente }">${ cliente.estado_cliente }
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
								

                                    <span class="help-block">
                                        <strong><form:errors path="cliente.estado_cliente"/></strong>
                                    </span>

							  </div><!-- ok -->
							  
							  
							<label for="cep" class="col-md-1 control-label">CEP</label>
							<div class="col-md-3">
							
								<input type="text" id="cep" name="cep_cliente" class="form-control cep" required pattern="\d{5}-\d{3}" value="${ cliente.cep_cliente }">
								

                                    <span class="help-block">
                                        <strong><form:errors path="cliente.cep_cliente"/></strong>
                                    </span>

								
							</div>
						</div>
					
					
						<div class="form-group{{ $errors->has('cidade') ? ' has-error' : '' }}">
							<label for="cidade" class="col-md-3 control-label">Cidade</label>

							<div class="col-md-7">
								<input type="text" id="cidade" name="cidade_cliente" required pattern="^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" class="form-control" value="${ cliente.cidade_cliente }">


									<span class="help-block">
										<strong><form:errors path="cliente.cidade_cliente"/></strong>
									</span>

							</div>
						</div>
					
					
						<div class="form-group{{ $errors->has('endereco') ? ' has-error' : '' }}">
							<label for="endereco_cliente" class="col-md-3 control-label">Endereço</label>

							<div class="col-md-4">
								<input type="text" id="endereco_cliente" name="endereco_cliente" class="form-control"  value="${ cliente.endereco_cliente }">


									<span class="help-block">
										<strong><form:errors path="cliente.endereco_cliente"/></strong>
									</span>

							</div>
							
							
							<label for="numero" class="col-md-1 control-label">Nº</label>

							<div class="col-md-2">
								<input type="text" id="number" name="numero_cliente" maxlength="9" required pattern="^[0-9]+$" class="form-control" value="${ cliente.numero_cliente }">


									<span class="help-block">
										<strong><form:errors path="cliente.numero_cliente"/></strong>
									</span>

							</div>
						</div>
					
					
						<div class="form-group{{ $errors->has('complemento') ? ' has-error' : '' }}">
							<label for="complemento" class="col-md-3 control-label">Complemento</label>

							<div class="col-md-7">
								<input type="text" id="complemento" name="complemento_cliente" class="form-control" value="${ cliente.complemento_cliente }">

								
									<span class="help-block">
										<strong><form:errors path="cliente.complemento_cliente"/></strong>
									</span>

							</div>
						</div>
					
                        <div class="form-group">
                            <div class="col-md-8 col-md-offset-5">
                                <button type="submit" class="btn btn-success">
                                    <i class="fa fa-btn fa-user"></i> Salvar alterações
                                </button>
                            </div>
                        </div>
          </div>
      	</form>
	  </c:forEach>
  </div>

	<div class="col-xs-3"></div>
	<div class="col-xs-9">
	  <h3 align="center">Alterar Senha</h3>
		
		<form action="AlterarSenha" method="POST" class="form-horizontal">
	  
                        <div class="form-group{{ $errors->has('password') ? ' has-error' : '' }}">
                            <label for="password" class="col-md-3 control-label">Senha Antiga</label>

                            <div class="col-md-7">
                                <input id="password" type="password" class="form-control" name="senha_cliente">

                                    <span class="help-block">
                                        <strong><form:errors path="cliente.senha_cliente"/></strong>
                                    </span>

                            </div>
                        </div>
						
                        <div class="form-group{{ $errors->has('new_password') ? ' has-error' : '' }}">
                            <label for="new_password" class="col-md-3 control-label">Nova Senha</label>

                            <div class="col-md-7">
                                <input id="new_password" type="password" class="form-control" name="nova_senha_cliente">

                                    <span class="help-block">
                                        <strong><form:errors path="nova_senha_cliente"/></strong>
                                    </span>

                            </div>
                        </div>

                        <div class="form-group{{ $errors->has('password_confirmation') ? ' has-error' : '' }}">
                            <label for="password-confirm" class="col-md-3 control-label">Confirmar Senha</label>

                            <div class="col-md-7">
                                <input id="password-confirm" type="password" name="confirma_nova_senha_cliente" class="form-control">


                                    <span class="help-block">
                                        <strong><form:errors path="confirma_nova_senha_cliente"/></strong>
                                    </span>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-7 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-btn fa-user"></i> Alterar
                                </button>
                            </div>
                        </div>
		</form>
	</div>
	
	
	
	<div class="col-xs-12">
		<h2>Meus Pedidos</h2>
		
	  <div class="row">
		<div class="col-xs-8">
			<div id="paginacao"></div>
		</div>
		<div class="col-xs-4">
		  <div class="form-inline">
			<nav class="panel-heading">
			  <ul class="pagination">
				<label>Exibir</label>
				<select name="" class="form-control" id="Itemsperpage">
					<option value="10" selected>10
					<option value="25">25
					<option value="50">50
					<option value="100">100
					<option value="All">Todos
				</select>
				<label>produtos</label>
			  </ul>
			</nav>
		  </div>
		</div>
	  </div>
	  <div class="row">
		<div class="col-xs-12">
			<table class="table table-condensed table-striped table-hover" id="table">
				<thead>
					<tr><td></td></tr>
				</thead>
				<tbody>
					<c:forEach var="pedido" items="${pedidos}">
					<tr>
					  <td>
						<div class="row">
						  <div class="col-xs-8">
							<form action="UpdatePedido" method="POST">
							  ${ pedido.numero_pedido }
						  	</form>
						  </div>
						  <div class="col-xs-2">
						  	<form method="POST" action="Imprimir_Boleto">
								<input type="hidden" name="numb_ped" value="${ pedido.numero_pedido }">
								<button class="btn btn-success form-control" id="imprimir_boleto">
								  <i class="glyphicon glyphicon-print"></i> Imprimir
								</button>
							</form>
						  </div>
							<div class="col-xs-2">
							  <form action="CancelaPedido" method="POST">
							  	<input type="hidden" name="id_pedido" value="${ pedido.id_pedido }">
								<button class="btn btn-danger form-control">
								  <i class="glyphicon glyphicon-remove"></i> Cancelar
								</button>
							  </form>
							</div>
						</div>
					  </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	  </div>
	  
	</div>
  </div>
</div>

<c:import url="Footer.jsp" />