<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="Header.jsp" />


<div class="panel panel-default">
	<div class="panel-body">
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


					<!--	Input sem ícone 	-->
					  <div class="col-md-12 col-sm-12 col-xs-12 form-group">
						<input type="text" name="nome_cli" class="form-control" placeholder="Nome" title="Nome" value="${ cliente.nome_cli }">
					  </div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cpf_cli" class="form-control" placeholder="CPF" title="CPF" value="${ cliente.cpf_cli }">
					</div>

					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="cnpj_cli" class="form-control" placeholder="CNPJ" title="CNPJ" value="${ cliente.cnpj_cli }">
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
<input type="hidden" value="1" name="news_letter_cli">
<input type="hidden" value="1" name="ativo_cli">
					<!--	Booleano	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="news_letter_cli" class="js-switch" title="Cliente Ativo" value="${ cliente.ativo_cli }"> <i class="fa fa-plus"></i> Cliente Ativo 
					  </label>
					</div>


					<!--	Botão de envio	-->
					<div class="btn-group pull-right">
					  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
						<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
					  </button>
					</div>

					</form>
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