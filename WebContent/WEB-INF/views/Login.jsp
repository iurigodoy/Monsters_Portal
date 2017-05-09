<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<c:import url="Header.jsp" />

    <!-- Animate.css -->
    <link href="resources/vendors/animate.css/animate.min.css" rel="stylesheet">

      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>
      
	<div class="login_wrapper">



        <div class="animate form login_form">
		  <section class="login_content">
			  <div class="panel panel-defaut panel-login">
				<div class="panal-body">
					<h2 align="center">Login</h2>
						<form class="form-horizontal form-label-left input_mask" role="form" method="POST" action="efetuaLogin">
		
		                            <div class="col-md-12 col-sm-12 col-xs-12">
				                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
				                        <input type="text" name="email" class="form-control has-feedback-left" placeholder="E-Mail" title="E-Mail" value="${ email }">
				                        <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
				                      </div>
			                      
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
		
		                                <a class="btn btn-link"  href="#signup">Esqueci a senha !</a>
		                            </div>
		                        </div>
		                    </form>
				</div>
			  </div>
		  </section>
		</div>
			
			
        <div id="register" class="animate form registration_form">
			<div class="panel panel-defaut panel-login">
				<div class="panal-body">
						<h2 align="center"> Esqueci minha senha </h2>
						<form class="form-horizontal" role="form" method="POST" action="">
		
		                   		<div class="col-md-12 col-sm-12 col-xs-12">
		                            <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
		                                <input id="email_cli" type="text" class="form-control has-feedback-left" name="email_cli" title="E-Mail" placeholder="E-Mail">
										<span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
		                            </div>
		                        </div>
		
		                        <div class="form-group">
		                            <div class="col-xs-8 col-md-offset-2">
		                              <c:if test="${not empty param.senha_error}">
										<h5 style="font-size:16px;color:red;">
											${param.senha_error }
										</h5>
									  </c:if>
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <div class="col-md-10 col-md-offset-1">
		                                <button type="submit" class="btn btn-primary">
		                                    <i class="fa fa-btn fa-paper-plane"></i> Enviar nova Senha
		                                </button>
		
		                                <a class="btn btn-link" href="#signin">Voltar</a>
		                            </div>
		                        </div>
		                        
		        	</form>
				</div>
			</div>
		</div>
		
		
</div>
<c:import url="Footer.jsp" />
                    