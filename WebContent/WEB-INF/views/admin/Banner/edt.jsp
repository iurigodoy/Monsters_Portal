<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-group"></i> Banner </h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Procure por...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Vá!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>


<!--	Formulário de Edição Aqui !!!	-->
<!--		Formulário		-->
<form action="<c:url value="UpdateBanner"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ban_arquivo" class="form-control" placeholder="Arquivo Banner" title="Arquivo Banner" value="${ banner.ban_arquivo }">
</div>


<!--	Booleano	-->

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <label>
	<input type="checkbox" name="ban_ativo" class="js-switch"  title="Banner Ativo" value="${ banner.ban_ativo }"><i class="fa fa-plus"></i> Banner Ativo ?
  </label>
</div>


<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>
<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_banner"	value="${ banner.id_banner }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ ban.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty ban.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ ban.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ ban.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ ban.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ ban.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ ban.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>
