<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="Header.jsp" />
  <div class="row">
	<div class="col-xs-12">
	  <div class="panel panel-default">
		<div class="panel-heading">
		  <h2 class="panel-title" align="center">
			Quem somos?
		  </h2>
		</div>
		<div class="panel-body">
		  <div class="col-xs-12" align="center">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3654.3958324467067!2d-46.530391430678925!3d-23.661798454911136!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce4289a6ce0a51%3A0xcdeec0304ee021f6!2sFaculdade+de+Tecnologia+Pent%C3%A1gono%2C+Uninade+Centro!5e0!3m2!1spt-BR!2sbr!4v1470532339321" width="800" height="200" frameborder="0" style="border:0" allowfullscreen></iframe>
		  </div>
		  <div class="col-xs-3"></div>
		  <div class="col-xs-6">
			<br><br>
			<div class="col-xs-12" align="center">
						<a href="https://www.facebook.com" target="_blank"><img src="<c:url value="/resources/imagens/loja/facebook.jpg"/>" weight="30" height="30" ></a>
						<a href="https://apps.google.com" target="_blank"><img src="<c:url value="/resources/imagens/loja/google.png"/>" weight="30" height="30" ></a>
						<a href="https://twitter.com/?lang=pt-br" target="_blank"><img src="<c:url value="/resources/imagens/loja/twitter.png"/>" weight="30" height="30" ></a>
						<a href="https://www.youtube.com/" target="_blank"><img src="<c:url value="/resources/imagens/loja/youtube.png"/>" weight="30" height="30" ></a>
			</div>
			<br><br>
			<div class="col-xs-12">
				<p align="center">Loja. - CNPJ 11.222.333/4444-55<br>Endereço: Rua:Osvaldo Orico Nº265<br>Sto.André - SP</p>
			</div>
		  </div>
		  <div class="col-xs-3"></div>
		</div>
		<div class="panel-footer"></div>
	  </div>
	</div>
  </div>
  <div class="row">
	<div class="col-xs-6">
	  <div class="panel panel-default">
		<div class="panel-heading">
		  <h2 class="panel-title">
			<span class="glyphicon glyphicon-question-sign"></span> Dúvidas
		  </h2>
		</div>
		<div class="panel-body">
			<div class="panel panel-default">
				<a data-toggle="collapse" data-parent="#accordion" href="#contato1">
				  <div class="panel-heading">
					<h4 class="panel-title">
						Como se cadastrar.
					</h4>
				  </div>
				</a>
				<div id="contato1" class="panel-collapse collapse">
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="panel panel-default">
				<a data-toggle="collapse" data-parent="#accordion" href="#contato2">
				  <div class="panel-heading">
					<h4 class="panel-title">
						Como realizar uma compra.
					</h4>
				  </div>
				</a>
				<div id="contato2" class="panel-collapse collapse">
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="panel panel-default">
				<a data-toggle="collapse" data-parent="#accordion" href="#contato3">
				  <div class="panel-heading">
					<h4 class="panel-title">
						Como realizar uma compra com vários produtos diferentes.
					</h4>
				  </div>
				</a>
				<div id="contato3" class="panel-collapse collapse">
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="panel panel-default">
				<a data-toggle="collapse" data-parent="#accordion" href="#contato4">
				  <div class="panel-heading">
					<h4 class="panel-title">
						Como funciona o carrinho.
					</h4>
				  </div>
				</a>
				<div id="contato4" class="panel-collapse collapse">
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="panel panel-default">
				<a data-toggle="collapse" data-parent="#accordion" href="#contato5">
				  <div class="panel-heading">
					<h4 class="panel-title">
						Como ver meus pedidos.
					</h4>
				  </div>
				</a>
				<div id="contato5" class="panel-collapse collapse">
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="panel panel-default">
				<a data-toggle="collapse" data-parent="#accordion" href="#contato6">
				  <div class="panel-heading">
					<h4 class="panel-title">
						Como editar ou cancelar um pedido.
					</h4>
				  </div>
				</a>
				<div id="contato6" class="panel-collapse collapse">
					<div class="panel-body"></div>
				</div>
			  </div>
		</div>
		<div class="panel-footer"></div>
	  </div>
	</div>
	<div class="col-xs-6">
	  <div class="panel panel-default">
		<div class="panel-heading">
		  <h2 class="panel-title">
			Central de atendimento
		  </h2>
		</div>
		<div class="panel-body">
			<span class="glyphicon glyphicon-earphone"></span>	Telefone: 0800-XXXX<br>
			<span class="glyphicon glyphicon-hdd"></span>		Atendimento Desktop.<br>
			<span class="glyphicon glyphicon-comment"></span>	Chat.<br><br>
			<p><span class="glyphicon glyphicon-envelope"></span> Ainda com dúvidas, ou encontrou algum problema?<br>Envie um e-mail e logo retornaremos.</p>
			<div class="input-group">
			  <div class="input-group-btn">
				<button class="btn btn-new btn-primary" title="Enviar"><span class="glyphicon glyphicon-envelope"></span></button>
			  </div>
			  <input type="email" class="form-control btn-secondary">
			</div>
		</div>
		<div class="panel-footer"></div>
	  </div>
	</div>
  </div>
<c:import url="Footer.jsp" />