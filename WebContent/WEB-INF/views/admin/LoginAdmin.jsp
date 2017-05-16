<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Pentágono Portal</title>

    <!-- Bootstrap -->
    <link href="../resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="../resources/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../resources/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
			<form method="POST" action="<c:url value="/Admin/efetuaLoginAdmin"/>">
              <h1>Login</h1>
              <div>
                <input type="text" name="email_fun" class="form-control" placeholder="Usuario" required="" />
              </div>
              <div>
                <input type="password" name="senha_fun" class="form-control" placeholder="Senha" required="" />
              </div>
              <div>
	              <c:if test="${not empty administradorLogado.email_fun}">
	              	<div class="alert alert-danger" role="alert"> Você já está logado! </div>
				  </c:if>
				  <c:if test="${not empty param.login_error}">
				  	<div class="alert alert-danger" role="alert"> ${ param.login_error} </div>
				  </c:if>
              </div>
              <div>
                <button class="btn btn-default submit">Log in</button>
                <a href="#signup" class="reset_pass">Esqueci a Senha!</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-university"></i> Pentágono Portal!</h1>
                  <p>2016 Todos os direitos reservados. Pentágono Portal! Desenvolvido por Monsters Dev. <a href="#term">Termos de privacidade</a></p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Esqueci a Senha</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" />
              </div>
              <div>
	          	<button class="btn btn-default submit">Enviar</button>
	          	Lembrou? <a href="#signin" class="to_register"> Log in </a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Pentágono Portal!</h1>
                  <p>2016 Todos os direitos reservados. Pentágono Portal! Desenvolvido por Monsters. <a href="#term">Termos de privacidade</a></p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>