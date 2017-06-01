<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <select name="produto.id_produto" class="form-control">
	<option value="${ banner.produto.id_produto }">${ banner.produto.nome_pro }</option>
	<c:forEach var="prod" items="${produtos}">
	  <option value="${ prod.id_produto }">${ prod.nome_pro }</option>
	</c:forEach>
  </select>
  <p>Não encontrou o produto certo? <a href="<c:url value="/Admin/produto"/>">Clique Aqui!</a></p>
</div>
				
<!--	Booleano	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="ativo_ban" class="js-switch"  title="Banner Ativo" value="${ banner.ativo_ban }"> Publicar
  </label>
</div>

<!--							PadrÃµes do Sistema									-->

	<input type="hidden" name="id_banner"	value="${ banner.id_banner }"/>
	<input type="hidden" name="arquivo_ban" value="${ banner.arquivo_ban }">
	<input type="hidden" name="produto.id_produto" value="${ produto.id_produto }">

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ banner.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty banner.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ banner.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ banner.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ banner.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ banner.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ banner.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>
