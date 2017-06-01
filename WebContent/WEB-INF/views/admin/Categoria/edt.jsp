<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
	<input type="text" class="form-control" name="nome_cat" placeholder="Nome" value="${ categoria.nome_cat }">
	<!--	Padrões do Sistema	-->

	<input type="hidden" name="id_categoria"	value="${ categoria.id_categoria }"/>

	<!-- Propriedades de Tempo -->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ categoria.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty categoria.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ categoria.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ categoria.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ categoria.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ categoria.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ categoria.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

			  
