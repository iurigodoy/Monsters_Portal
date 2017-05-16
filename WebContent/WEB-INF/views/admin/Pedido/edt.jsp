<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-road"></i> Pedidos </h3>
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
<form action="<c:url value="UpdatePedido"/>" method="POST" class="form-horizontal form-label-left input_mask">

<!--	Input sem ícone 	-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_preco" class="form-control" placeholder="Preco" title="Preco" value="${ pedido.ped_preco }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_parcelas" class="form-control" placeholder="Parcelas" title="Parcelas" value="${ pedido.ped_parcelas }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_status" class="form-control" placeholder="Status Pedido" title="Status" value="${ pedido.ped_status }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_peso" class="form-control" placeholder="Peso" title="Peso" value="${ pedido.ped_peso }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_altura" class="form-control" placeholder="Altura" title="Altura" value="${ pedido.ped_altura }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_comprimento" class="form-control" placeholder="Comprimento" title="Comprimento" value="${ pedido.ped_comprimento }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_entrega_data" class="form-control" placeholder="Data de Entrega" title="Data de Entrega" value="${ pedido.ped_entrega_data }">
</div>

<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <input type="text" name="ped_entrega_hora" class="form-control" placeholder="Hora de Entrega" title="Hora de Entrega" value="${ pedido.ped_entrega_hora }">
</div>



<!--	Select com
		Relacionamento		-->
<div class="col-md-12 col-sm-12 col-xs-12 form-group">
  <select type="hidden" name="fornecedor.id_fornecedor" class="form-control">
	<option value="0">Fornecedor</option>
	<c:forEach var="fornecedor" items="${fornecedores}">
	  <option value="${ fornecedor.id_fornecedor }">${ fornecedor.for_nome }</option>
	</c:forEach>
  </select>
  <!-- exemplo para facilitar pro usuário -->
  <p>Não encontrou o Fornecedor certo? <a href="<c:url value="/fornecedor"/>" title="Editar Fornecedores">Clique aqui</a></p>
</div>

<!--	Botão de envio	-->
<div class="btn-group pull-right">
  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
	<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
  </button>
</div>
<!--							Padrões do Sistema									-->

	<input type="hidden" name="id_pedido"	value="${ pedido.id_pedido }"/>

<!--							Propriedades de Tempo								-->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ ped.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty ped.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ ped.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ ped.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ ped.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ ped.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ ped.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

</form>

