<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="Header.jsp" />
  <div class="row">
	<div class="col-xs-12">
	  <div class="panel panel-default">
		<div class="panel-heading">
		  <h2 class="panel-title">
			Boleto
		  </h2>
		</div>
		
		<div class="panel-body">
		  <div class="row">
			<div class="col-xs-3"></div>
			<div class="col-xs-6">
			
				<br><br>
				
				<h3 align="center">ID: ${ param.numb_ped }</h3>
				<p align="center">Atenção: guarde este número</p>
			
				<br><br>
			
		 	</div>
		  </div>
		  <div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
			
			<div align="center">
				
						  	<form method="POST" action="Imprimir_Boleto">
								<input type="hidden" name="numb_ped" value="${ param.numb_ped }">
								<button class="btn btn-success form-control" id="imprimir_boleto">
								  <i class="glyphicon glyphicon-print"></i> Imprimir
								</button>
							</form>
							
			</div>
			<br><br>
			<p align="justify">Você tem até 5 dias úteis para efetuar o pagamento, assim que o pedido for faturado, estaremos realizando a entrega do produto.</p>
			<br><br><br><br><br><br><br><br><br>
			</div>
		  </div>
	  	</div>
	  </div>
	</div>
  </div>
<c:import url="Footer.jsp" />