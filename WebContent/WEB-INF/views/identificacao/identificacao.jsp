<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<c:import url="../Header.jsp" />

<style>
.cadastro{
	display: none;
}
</style>

<div class="container">
  <div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
		  <div class="col-xs-6">
			<h2>Identificação</h2>
		  </div>
		  <div class="col-xs-6">
			<h5 class="green"><i class="fa fa-lock"></i> Compra segura</h5>
		  </div>
		</div>
	  	<div class="col-md-6 col-sm-6 col-xs-12">
	  	  <h4>Login</h4>
			<form class="form-horizontal form-label-left input_mask" role="form" method="POST" action="loginIdentificacao">
		
				<div class="row">
				                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
				                        <input type="text" name="email" class="form-control has-feedback-left" placeholder="E-Mail" title="E-Mail" value="${ email }">
				                        <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
				                      </div>
			    </div>
				<div class="row">
				                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
				                        <input type="password" name="senha" class="form-control has-feedback-left" placeholder="Senha" title="Senha">
				                        <span class="fa fa-lock form-control-feedback left" aria-hidden="true"></span>
				                      </div>
				</div>
		                        <div class="form-group">
		                            <div class="col-md-8 col-md-offset-2">
		                              <c:if test="${not empty param.login_error}">
										<h5 style="font-size:16px;color:red;">
											${param.login_error }
										</h5>
									  </c:if>
		                            </div>
		                        </div>
		
		                        <div class="form-group">
		                            <div class="col-md-10 col-md-offset-1">
		                                <button type="submit" class="btn btn-primary">
		                                    <i class="fa fa-btn fa-sign-in"></i> Login
		                                </button>
		                            </div>
		                        </div>
			</form>
		</div>
	  	<div class="col-md-6 col-sm-6 col-xs-12 footer-left-border-div">
	  		<h4>Cadastro</h4>
	  		<br>
	  		<p><strong>fazer cadastro</strong></p>
	  		<ul>
	  		  <li>Receba promoções só pra você!</li>
	  		  <li>Compras rápidas com poucos cliques.</li>
	  		  <li>Salve seus dados e não perca tempo.</li>
	  		</ul>
		</div>
	  	<div class="col-md-offset-6 col-sm-offset-6 col-xs-offset-0 col-md-6 col-sm-6 col-xs-12">
	  	  <button class="btn btn-md btn-success btn-cadastro">Cadastrar</button>
	  	  <br><br>
	  	  <div class="cadastro">
			<c:import url="cadastro_completo.jsp" />
		  </div>
		</div>
	</div>
  </div>
</div>

<c:import url="../Footer.jsp" />
<script>
$(document).ready(function(){
	$(".btn-cadastro").click(function(){
	    $(".cadastro").fadeIn();
	});
});
</script>
                    