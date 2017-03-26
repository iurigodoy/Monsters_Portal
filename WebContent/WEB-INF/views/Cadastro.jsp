<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="Header.jsp" />


<div class="panel panel-default">
	<div class="panel-body">
	  <h1></h1>
	  <div class="row">
			<h1>Cadastro</h1>

                <!-- Smart Wizard -->
				<form class="form-horizontal form-label-left" role="form" method="POST" action="CreateCliente">
                
				<input type="hidden" name="ativo_cliente" value="true">
				
				
                	<div id="wizard" class="form_wizard wizard_horizontal">
                      <ul class="wizard_steps">
                        <li>
                          <a href="#step-1">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                                              1º Passo<br />
                                              <small>Dados Pessoais</small>
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-2">
                            <span class="step_no">2</span>
                            <span class="step_descr">
                                              2º Passo<br />
                                              <small>Meu Contato</small>
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-3">
                            <span class="step_no">3</span>
                            <span class="step_descr">
                                              3º Passo<br />
                                              <small>Minha Localização</small>
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-4">
                            <span class="step_no">4</span>
                            <span class="step_descr">
                                              4º Passo<br />
                                              <small>Minha Conta</small>
                                          </span>
                          </a>
                        </li>
                      </ul>
                      
                      
                      
                      
                      
                      
                      <div id="step-1" align="center">
                      
                      	<p class="blue"><small>Faça o cadastro para comprar !</small></p>
                      	
						<h2>Dados pessoais</h2>
						
						
						  <div class="form-group">
							<label>Eu sou: </label>
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-primary btn-sm active">
									<input type="radio"	name="tipo_pessoa" value="fisica" id="tipo_pessoa_fisica" checked><i class="fa fa-user"></i> Pessoa
								</label>
								<label class="btn btn-primary btn-sm">
									<input type="radio"	name="tipo_pessoa" value="juridica" id="tipo_pessoa_juridica"><i class="fa fa-university"></i> Empresa
								</label>
							</div>
						  </div>
						
						<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="nome_cliente" class="col-md-4 control-label">Nome <span id="nome_pessoa_juridica">fantasia</span>: </label>

                            <div class="col-md-6">
                                <input id="nome" type="text" class="form-control" name="nome_cliente" value="${ cliente.nome_cliente }">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.nome_cliente"/></strong>
                                    </span>
                            </div>
                        </div>
			
					 	<div class="form-group ${status.error ? 'has-error' : ''}">
                            <label for="razao" class="col-md-4 control-label">Razao: </label>

                            <div class="col-md-6">
                                <input id="razao" type="text" class="form-control" name="razao_cliente" value="${ cliente.razao_cliente }">

                                    <span class="help-block">
                                        <strong><form:errors path="cadastro.razao_cliente"/></strong>
                                    </span>
                            </div>
                        </div>
                        
						<div class="form-group">
                        	<label class="label-control">Sexo:</label>
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-primary btn-sm">
									<input type="radio" id="sexo_cliente" name="sexo_cliente" value="1"><i class="fa fa-male"></i> Masculino
								</label>
								<label class="btn btn-danger btn-sm">
									<input type="radio" id="sexo_cliente" name="sexo_cliente" value="0">Feminino <i class="fa fa-female"></i>
								</label>
							</div>
						</div>
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="cpf" class="col-md-4 control-label">CPF: </label>

                            <div class="col-md-6">
                                <input id="cpf" type="text" class="form-control cpf" name="cpf_cliente" value="${ cliente.cpf_cliente }">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.cpf_cliente"/></strong>
                                    </span>
                                
                            </div>
                        </div>
                        
						
						<div class="form-group ${status.error ? ' has-error' : ''}">
                            <label for="cnpj" class="col-md-4 control-label">CNPJ: </label>

                            <div class="col-md-6">
                                <input id="cnpj" type="text" class="form-control cnpj" name="cnpj_cliente" value="${ cliente.cnpj_cliente }">

                                
                                    <span class="help-block">
                                        <strong><form:errors path="cliente.cnpj_cliente"/></strong>
                                    </span>
                                
                            </div>
                        </div>
                        
                        
                      </div>
                      <div id="step-2" align="center">
                      
                        <h2>Contato</h2>
                        
                        <p>Precisamos falar com você se tivermos problemas na entrega de seu produto.</p>
                        
                        <span class="help-block">
                       		<strong><form:errors path="cliente.cnpj_cliente"/></strong>
                        </span>
                        
					  <div class="col-md-3 col-sm-1 col-xs-0"></div>
					  <div class="col-md-6 col-sm-10 col-xs-12">
	                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
	                        <input type="text" name="email_cliente" class="form-control has-feedback-left" placeholder="Email" title="Email" value="${ cliente.email_cliente }">
	                        <span class="fa fa-envelope-o form-control-feedback left" aria-hidden="true"></span>
	                      </div>
	                      <div class="col-md-6 col-sm-12 col-xs-12 form-group has-feedback">
	                        <input type="text" name="residencial_cliente" class="form-control has-feedback-left" placeholder="Telefone" title="Telefone" value="${ cliente.residencial_cliente }">
	                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
	                      </div>
	                      <div class="col-md-6 col-sm-12 col-xs-12 form-group has-feedback">
	                        <input type="text" name="celular_cliente" class="form-control has-feedback-left" placeholder="Celular" title="Celular" value="${ cliente.celular_cliente }">
	                        <span class="fa fa-mobile form-control-feedback left" aria-hidden="true"></span>
	                      </div>
                      </div>


                        
                        
                    </div>
                    <div id="step-3" align="center">
                      
                      	<p class="blue"><small>Vamos lá falta pouco !</small></p>
                      
                        <h2>Localização</h2>
                        
                        <p>Onde devemos entregar?</p>

						<div class="col-md-3 col-sm-1 col-xs-0"></div>
						<div class="col-md-6 col-sm-10 col-xs-12">
	                      <div class="col-md-6 col-sm-12 col-xs-12 form-group">
							<input id="cep" type="text" class="form-control cep" name="cep_cliente" placeholder="CEP" title="CEP" value="${ cliente.cep_cliente }">
	                      </div>
	                      <div class="col-md-6 col-sm-12 col-xs-12 form-group">
							<select id="uf" class="form-control" name="estado_cliente">
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
							<input name="cidade_cliente" type="text" class="form-control" placeholder="Município" title="Município" value="${ cliente.cidade_cliente }">
	                      </div>
	                      <div class="col-md-9 col-sm-12 col-xs-12 form-group">
							<input name="endereco_cliente" type="text" class="form-control" placeholder="Endereço" title="Endereço" value="${ cliente.endereco_cliente }">
	                      </div>
	                      <div class="col-md-3 col-sm-12 col-xs-12 form-group">
							<input name="numero_cliente" type="text" class="form-control" placeholder="Nº" title="Nº" value="${ cliente.numero_cliente }">
	                      </div>
	                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
							<input name="complemento_cliente" type="text" class="form-control" placeholder="Complemento" title="Complemento" value="${ cliente.complemento_cliente }">
	                      </div>
	                    </div>
                      
                      
                      
                      
                      </div>
                      <div id="step-4" align="center">
                      
                      	<p class="blue"><small>Esta é a ultima etapa !</small></p>
                      	
                      	<h2>Minha Conta</h2>
                      	
                      	<p>Tenha sua própria conta e garantiremos <br> a <strong class="green">segurança</strong> e privacidade de suas informações.</p>
						
						<div class="col-md-4 col-sm-2 col-xs-0"></div>
						<div class="col-md-4 col-sm-8 col-xs-12">
		                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
		                        <input type="text" name="usuario_cliente" class="form-control has-feedback-left" placeholder="Usuário" title="Usuário" value="${ cliente.usuario_cliente }">
		                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
		                      </div>
	                      
		                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
		                        <input type="password" name="senha_cliente" class="form-control has-feedback-left" placeholder="Senha" title="Senha">
		                        <span class="fa fa-lock form-control-feedback left" aria-hidden="true"></span>
		                      </div>
						
							<div class="form-group">
	                           <input id="newsletter" type="checkbox" name="news_letter_cliente" checked>
	                           <label for="newsletter" class="control-label">Receber nosso Newsletter</label>
	                        </div>
                      </div>
                      
                    </div>
                    
                    
        		</div>
        	</form>
		</div>
	</div>
</div>

<c:import url="Footer.jsp" />


    <!-- jQuery Smart Wizard -->
    <script src="<c:url value="/resources/vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"/>"></script>
    
    <script>
    $(document).ready(function() {
        var $radios = $('#tipo_pessoa_fisica');
        if($radios.is(':checked') === true) {
        	$('#nome_pessoa_juridica').css('display', 'none');
            /*$radios.filter('[value=fisica]').prop('checked', false);
            $radios.filter('[value=juridica]').prop('checked', true);*/
        } else {
        	$('#nome_pessoa_juridica').css('display', 'inline-block');
        	
        }
    });
	</script>

    <!-- jQuery Smart Wizard -->
    <script>
      $(document).ready(function() {
        $('#wizard').smartWizard();

        $('#wizard_verticle').smartWizard({
          transitionEffect: 'slide'
        });

        $('.buttonNext').addClass('btn btn-success');
        $('.buttonPrevious').addClass('btn btn-primary');
        $('.buttonFinish').addClass('btn btn-default');
      });
    </script>
    <!-- /jQuery Smart Wizard -->