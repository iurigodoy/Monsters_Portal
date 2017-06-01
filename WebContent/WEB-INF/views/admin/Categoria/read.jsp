<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-th"></i> Categoria</h3>
              </div>
            </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="cat.id_categoria"/></strong>
					<strong><form:errors path="cat.nome_cat"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>


              <div class="col-md-8 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a class="toolbox-history"><i class="fa fa-history"></i> Exibir Histórico</a>
                          </li>
                          <li><a class="toolbox-history-return"><i class="fa fa-history"></i> Voltar</a>
                          </li>
                          <li><a href="<c:url value="/Admin/produto"/>"><i class="fa fa-users"></i> Produtos</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<div id="ajax-content-table">
                 		<table id="datatable-pt_br-responsivo" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
	                      <thead>
	                        <tr>
	                          <th style="width: 45%">Nome</th>
	                          <th style="width: 20%">#Editar</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="cat" items="${categorias}">
					  		<c:if test="${ not cat.deleted }">
	                      	  <tr id="tr_${ cat.id_categoria }" data-history="1">
	                      	  	<td>${ cat.nome_cat }</td>
	                      	  	<td>
	                      	  	  <div class="edition-buttons" id="edition-buttons_${ cat.id_categoria }">
					                  <button type="button" data-id="${ cat.id_categoria }" class="btn btn-primary btn-xs Modal"
					                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
						              <button type="button" data-id="${ cat.id_categoria }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
									  <!--							(2) ^^^^^^^^^^^^^^^^^^^ 	-->
						          </div>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
					  		<c:if test="${ cat.deleted }">
	                      	  <tr id="tr_${ cat.id_categoria }" data-history="0">
	                      	  	<td>${ cat.nome_cat }</td>
	                      	  	<td>
					              	<button type="button"							 data-id="${ cat.id_categoria }"
					              	class="btn btn-success btn-xs restore-button" id="restore_${ cat.id_categoria }">
									<!--													 (2) ^^^^^^^^^^^^^^^^^^^	-->
					              	<i class="fa fa-refresh"></i> Restaurar</button>
	                      	  	</td>
	                      	  </tr>
	                      	</c:if>
	                      	  
                      		</c:forEach>
	                      </tbody>
	                    </table>
	              	</div>
                  </div>
                </div>
              </div>
              
		<div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Adicionar <small>Categorias</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					
					  <form action="CreateCategoria" method="POST">
					  	<input type="hidden" name="cat_conf_pro" value="1">
					  	<input type="hidden" name="conf_quantidade_cat" value="1">
						<div class="modal-body">
						
						  <div class="row">
							  <div class="form-group">
								<input type="text" name="nome_cat" class="form-control" placeholder="Coloque uma categoria  Ex. Samsung">
							  </div>
						  </div><!-- Fim Row -->
						  
						  <div class="row">
							  <div class="form-group">
								<button class="btn btn-new btn-success form-control">Adicionar Categoria</button>
							  </div>
						  </div>
						</div>
					  </form>
					  
				  </div>
                </div>
              </div>
			  
		<script type="text/javascript">

			edition_param	= "FindCategoria";						// Find Controller Function
			delete_message	= 'quer mesmo deletar esta categoria?';	// Delete Message
			delete_param	= "DeleteCategoria";						// Delete Controller Function
			restore_param	= "RestoreCategoria";						// Restore Controller Function

		</script>

		<c:import url="../Footer.jsp" />
		<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateCategoria"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">X</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Categoria</h4>
		  <!--																						^^^^^^^^^^^	-->
	    </div>
	    <div class="modal-body"> 
	                          
	    	<div id="modal_content"></div>
	                          
	    </div>
	    <div class="modal-footer">
	    	<button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
	        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Salvar</button>
	    </div>

	  </form>
	</div>
  </div>
</div>
            