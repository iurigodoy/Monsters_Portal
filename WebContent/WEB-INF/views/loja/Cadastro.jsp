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
	  Cadastro
	</h2>
  </div>
<div class="panel-body">
  <div class="row">
		<div id="tabs">
			  <ul>
				<li><a href="#tabs-1">Pessoa</a></li>
				<li><a href="#tabs-2">Empresa</a></li>
			  </ul>
<!------------------------------------------------------------------------------------------------------------------------------------------------------------>
<!------------------------------------------------------------------					---------------------------------------------------------------------->
<!------------------------------------------------------------------		PESSOA		---------------------------------------------------------------------->
<!------------------------------------------------------------------					---------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------------------------------------------------------------------>
			<div id="tabs-1">
				<form class="form-horizontal" role="form" method="POST" action="CreateCliente">
				
					<input type="hidden" name="ativo_cli" value="true">
						
						<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="nome" class="col-md-4 control-label">Nome: </label>

                            <div class="col-md-6">
                                <input id="nome" type="text" class="form-control" name="nome_cli">

                                    <span class="help-block">
                                        <strong><form:errors path="cli.nome_cli"/></strong>
                                    </span>
                            </div>
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="email" class="col-md-4 control-label">E-mail</label>

                            <div class="col-md-6">
                                <input id="email" type="email" class="form-control" name="email_cli">

                                    <span class="help-block">
                                        <strong><form:errors path="cli.email_cli"/></strong>
                                    </span>
                            </div>
                        </div>
						
						<div class="form-group">
						  <div class=" ${status.error ? ' has-error' : ''}">
                            <label for="telefone" class="col-md-4 control-label">Telefone: </label>

                            <div class="col-md-2">
                                <input id="telefone" type="text" class="form-control" name="residencial_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.residencial_cli"/></strong>
                                    </span>
                                
                            </div>
                          </div>
							
						  <div class=" ${status.error ? ' has-error' : ''}">
                            <label for="celular" class="col-md-2 control-label">Celular: </label>

                            <div class="col-md-2">
                                <input id="celular" type="text" class="form-control" name="celular_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.celular_cli"/></strong>
                                    </span>
                                
                            </div>
                          </div>
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="cpf" class="col-md-4 control-label">CPF: </label>

                            <div class="col-md-6">
                                <input id="cpf" type="text" class="form-control cpf" name="cpf_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.cpf_cli"/></strong>
                                    </span>
                                
                            </div>
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label class="col-md-4 control-label">Sexo: </label>

                            <div class="col-md-2"></div>

                            <div class="col-md-4">
								<label class="radio-inline"><input type="radio" id="sexo_cli" name="sexo_cli" value="1">Masculino</label>
                                <label class="radio-inline"><input type="radio" id="sexo_cli" name="sexo_cli" value="0">Feminino</label>

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.sexo_cli"/></strong>
                                    </span>
                                
                            </div>
                        </div>
						
						<div class="col-md-12"><br><br></div>
						
						<div class="form-group">
						  <div class=" ${status.error ? ' has-error' : ''}">
                            <label for="cep" class="col-md-4 control-label">CEP: </label>

                            <div class="col-md-3">
                                <input id="cep" type="text" class="form-control cep" name="cep_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.cep_cli"/></strong>
                                    </span>
                                
                            </div>
                          </div>
							
							
						  <div class=" ${status.error ? ' has-error' : ''}">
                            <label for="uf" class="col-md-1 control-label">Estado: </label>

                            <div class="col-md-2">
								<select id="uf" class="form-control" name="estado_cli">
									<option value="">Selecione
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
                                        <strong><form:errors path="cli.estado_cli"/></strong>
                                    </span>
                                
                            </div>
						  </div>
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="cidade" class="col-md-4 control-label">Município: </label>

                            <div class="col-md-6">
                                <input id="cidade" type="text" class="form-control" name="cidade_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.cidade_cli"/></strong>
                                    </span>
                                
                            </div>
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
						
						  <div class="{{ $errors->has('endereco_cli') ? ' has-error' : '' }}">
                            <label for="endereco_cli" class="col-md-4 control-label">Endereço: </label>

                            <div class="col-md-3">
                                <input id="endereco_cli" type="text" class="form-control" name="endereco_cli">

                                    <span class="help-block">
                                        <strong><form:errors path="cli.endereco_cli"/></strong>
                                    </span>
                                
                            </div>
                          </div>
							
						  <div class=" ${status.error ? ' has-error' : ''}">
                            <label for="numero" class="col-md-1 control-label">Nº: </label>

                            <div class="col-md-2">
                                <input id="numero" type="text" class="form-control" name="numero_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.numero_cli"/></strong>
                                    </span>
                                
                            </div>
                          </div>
						  
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="complemento" class="col-md-4 control-label">Complemento: </label>

                            <div class="col-md-6">
                                <input id="complemento" type="text" class="form-control" name="complemento_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.complemento_cli"/></strong>
                                    </span>
                                
                            </div>
                        </div>
						
						<div class="col-md-12"><br><br></div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="usuario" class="col-md-4 control-label">Usuário: </label>

                            <div class="col-md-6">
                                <input id="usuario" type="text" class="form-control" name="usuario_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="usuario_cli"/></strong>
                                    </span>
                                
                            </div>
                        </div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="password" class="col-md-4 control-label">Senha: </label>

                            <div class="col-md-6">
                                <input id="password" type="password" class="form-control" name="senha_cli">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cli.senha_cli"/></strong>
                                    </span>
                                
                            </div>
                        </div>
						
						<div class="form-group">
							<div class="col-md-4"></div>
                            <div class="col-md-4">
                                <input id="newsletter" type="checkbox" name="news_letter_cli" checked>
                                <label for="newsletter" class="control-label">Receber nosso Newsletter</label>
                            </div>
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-primary pull-right">
                                    <i class="fa fa-btn fa-user"></i> Registrar
                                </button>
                            </div>
                        </div>
						
				</form>
			</div>
<!------------------------------------------------------------------------------------------------------------------------------------------------------------>
<!------------------------------------------------------------------					---------------------------------------------------------------------->
<!------------------------------------------------------------------		EMPRESA		---------------------------------------------------------------------->
<!------------------------------------------------------------------					---------------------------------------------------------------------->
<!------------------------------------------------------------------------------------------------------------------------------------------------------------>
			
			<div id="tabs-2">
				<form action="cadastra_form.php" method="post" onsubmit="return valida_form(this)">
				
					<input type="hidden" name="ativo_cli" value="1">
					
						<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="nome_cli" class="col-md-4 control-label">Nome fantasia: </label>

                            <div class="col-md-6">
                                <input id="nome" type="text" class="form-control" name="nome_fantasia">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.nome_fantasia"/></strong>
                                    </span>
                            </div>
                        </div>
			
					 	<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="razao" class="col-md-4 control-label">Razao: </label>

                            <div class="col-md-6">
                                <input id="razao" type="text" class="form-control" name="razao">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.razao"/></strong>
                                    </span>
                            </div>
                        </div>
                        
						<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="email de contato" class="col-md-4 control-label">Email de Contato: </label>

                            <div class="col-md-6">
                                <input id="nome" type="text" class="form-control" name="email_de_contato">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.email_de_contato"/></strong>
                                    </span>
                            </div>
                        </div>
                        
						 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="telefone" class="col-md-4 control-label">Telefone: </label>

                            <div class="col-md-6">
                                <input id="telefone" type="text" class="form-control" name="telefone">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.telefone"/></strong>
                                    </span>
                            </div>
                        </div>
			
						 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="cnpj" class="col-md-4 control-label">CNPJ: </label>

                            <div class="col-md-6">
                                <input id="cnpj" type="text" class="form-control" name="cnpj">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.cnpj"/></strong>
                                    </span>
                            </div>
                        </div>

					 <div class="col-xs-2">
						<div class="cpf_cnpj_valido"><br><br><b>OK</b></div>
						<div class="cpf_cnpj_invalido"><br><b>Inválido</b></div>
					</div>
				
					 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="estado" class="col-md-4 control-label">ESTADO: </label>

                            <div class="col-md-6">
                                <input id="estado" type="text" class="form-control" name="estado">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.estado"/></strong>
                                    </span>
                            </div>
                        </div>
						<select name="estados" id="uf" class="form-control">
							<option value="0">Selecione
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
					 
					 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="cep" class="col-md-4 control-label">CEP: </label>

                            <div class="col-md-6">
                                <input id="cep" type="text" class="form-control" name="cep">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.cep"/></strong>
                                    </span>
                            </div>
                        </div>
					
						 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="municipio" class="col-md-4 control-label">Municipio: </label>

                            <div class="col-md-6">
                                <input id="municipio" type="text" class="form-control" name="municipio">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.municipio"/></strong>
                                    </span>
                            </div>
                        </div>
					
						<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="endereco" class="col-md-4 control-label">Endereco: </label>

                            <div class="col-md-6">
                                <input id="endereco" type="text" class="form-control" name="endereco">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.endereco"/></strong>
                                    </span>
                            </div>
                        </div>
					 
						<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="numero" class="col-md-4 control-label">Nº: </label>

                            <div class="col-md-6">
                                <input id="numero" type="text" class="form-control" name="numero">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.numero"/></strong>
                                    </span>
                            </div>
                        </div>

						 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="complemento" class="col-md-4 control-label">Complemento: </label>

                            <div class="col-md-6">
                                <input id="complemento" type="text" class="form-control" name="complemento">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.complemento"/></strong>
                                    </span>
                            </div>
                        </div>
					
						 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="usuario" class="col-md-4 control-label">Usuario: </label>

                            <div class="col-md-6">
                                <input id="usuario" type="text" class="form-control" name="usuario">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.usuario"/></strong>
                                    </span>
                            </div>
                        </div>

					 <div class="col-xs-2">
						<div class="user_valido"><br><b>OK</b>
						</div>
						<div class="user_invalido"><br>Usuário já existente
						</div>
					 </div>
					
					 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="sua senha" class="col-md-4 control-label">Sua Senha: </label>

                            <div class="col-md-6">
                                <input id="sua senha" type="text" class="form-control" name="sua senha">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.sua senha"/></strong>
                                    </span>
                            </div>
                        </div>
					
						 <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="confirme a senha" class="col-md-4 control-label">Confirme a Senha: </label>

                            <div class="col-md-6">
                                <input id="confirme a senha" type="text" class="form-control" name="confirme a senha">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.confirme a senha"/></strong>
                                    </span>
                            </div>
                        </div>

					<div class="row">
					 <div class="col-xs-2"></div>
					 <div class="col-xs-8">
						<br>
						<input type="checkbox" id="NL" name="newsletter" checked><label for="NL">Receber nosso NewsLetter</label>
						<br>
						<br>
						<br>
					 </div><!-- ok -->
					</div>
					<div class="row">
					 <div class="col-xs-2"></div>
					 <div class="col-xs-8">
					  <div class="form-group">
						<input type="submit" class="form-control" value="Enviar os dados">
					  </div>
					 </div><!-- ok -->
					</div>
		  </form>
		</div>
	  </div>
	</div>
  </div>
</div>

<c:import url="Footer.jsp" />