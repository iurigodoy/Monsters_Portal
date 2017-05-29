<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="Header.jsp" />
  <div class="container">
	<h2>${ produtos[0].categoria.nome_cat }</h2>
	<div class="col-xs-12">
	  <c:import url="Produto.jsp" />
	</div>
  </div>
<c:import url="Footer.jsp" />