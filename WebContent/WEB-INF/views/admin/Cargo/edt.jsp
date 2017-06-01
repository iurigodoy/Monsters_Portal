<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			
					<!--	Formulário de Edição Aqui !!!	-->
					<!--		Formulário		-->
					<form action="<c:url value="UpdateCargo"/>" method="POST" class="form-horizontal form-label-left input_mask">

					<!--	Input sem Ã­cone 	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <input type="text" name="nome_car" class="form-control" placeholder="Nome" title="Nome" value="${ cargo.nome_car }">
					</div>

					<!--	Booleano	-->
					<div class="col-md-12 col-sm-12 col-xs-12 form-group">
					  <label>
						<input type="checkbox" name="padrao_car" class="js-switch" title="Cargo Padrao" value="${ cargo.padrao_car }"> Cargo Padrao
					  </label>
					</div>
					
					<!--	Booleano	-->
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-clone"></i> Banner</h4>
					  <label>
						<input type="checkbox" name="lerBanner" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarBanner" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarBanner" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirBanner" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarBanner" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-sitemap"></i> Cargo</h4>
					  <label>
						<input type="checkbox" name="lerCargo" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarCargo" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarCargo" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirCargo" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarCargo" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-clone"></i> Categoria</h4>
					  <label>
						<input type="checkbox" name="lerCategoria" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarCategoria" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarCategoria" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirCategoria" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarCategoria" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-users"></i> Cliente</h4>
					  <label>
						<input type="checkbox" name="lerCliente" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarCliente" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarCliente" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirCliente" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarCliente" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-truck"></i> Fornecedor</h4>
					  <label>
						<input type="checkbox" name="lerFornecedor" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarFornecedor" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarFornecedor" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirFornecedor" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarFornecedor" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-users"></i> Funcionário</h4>
					  <label>
						<input type="checkbox" name="lerFuncionario" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarFuncionario" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarFuncionario" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirFuncionario" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarFuncionario" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-road"></i> Pedido</h4>
					  <label>
						<input type="checkbox" name="lerPedido" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarPedido" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarPedido" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirPedido" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarPedido" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12 form-group">
					  <h4><i class="fa fa-cubes"></i> Produto</h4>
					  <label>
						<input type="checkbox" name="lerProduto" class="js-switch">
						<i class="fa fa-eye"></i> Ler
					  </label><br>
					  <label>
						<input type="checkbox" name="criarProduto" class="js-switch">
						<i class="fa fa-plus"></i> Criar
					  </label><br>
					  <label>
						<input type="checkbox" name="atualizarProduto" class="js-switch">
						<i class="fa fa-pencil"></i> Atualizar
					  </label><br>
					  <label>
						<input type="checkbox" name="excluirProduto" class="js-switch">
						<i class="fa fa-trash-o"></i> Excluir
					  </label><br>
					  <label>
						<input type="checkbox" name="restaurarProduto" class="js-switch">
						<i class="fa fa-history"></i> Restaurar
					  </label>
					</div>
					
					<!-- PadrÃµes do Sistema	-->

					<input type="hidden" name="id_cargo"	value="${ cargo.id_cargo }"/>

					<!-- Propriedades de Tempo	-->

					<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ cargo.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
					<c:if test="${not empty cargo.deleted_at}">
					<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ cargo.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
					</c:if>
					<input type="hidden" name="deleted"		value="${ cargo.deleted }"/>



						<p>
						Criado em:		<strong><fmt:formatDate value="${ cargo.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
						Atualizado em:	<strong><fmt:formatDate value="${ cargo.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
						Apagado em:		<strong><fmt:formatDate value="${ cargo.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
						</p>
						
					</form>
					
				


