<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-clone"></i> Banner</h3>
              </div>
            </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
                  <span class="help-block">
					<!--	

						Mensagens de Erro Aqui !!! -->
					<strong><form:errors path="ban.arquvo_ban"/></strong>
					<strong><form:errors path="ban.ativo_ban"/></strong>

				<!--	-->
                  </span>
                </div>
              </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-pencil-square-o"></i> Banners</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="<c:url value="/Admin/produto"/>"><i class="fa fa-cube"></i> Produtos</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<c:forEach var="ban" items="${banners}">
                      <div class="col-md-6">
                        <div class="thumbnail">
                          <div class="image view view-first">
                            <img style="width: 100%; display: block;" src="<c:url value="/resources/imagens/banners/${ ban.arquivo_ban }"/>" alt="image" />
                            <div class="mask">
                              <p>${ ban.produto.nome_pro }</p>
                              <div class="tools tools-bottom">
	                      	  	<c:if test="${ permissao.atualizarBanner }">
	                                <a href="#" data-id="${ ban.id_banner }" class="Modal"
						                  		data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i></a>
						        </c:if>
	                      	  	<c:if test="${ permissao.excluirBanner }">
	                                <a href="#" data-id="${ ban.id_banner }" class="delete-button" title="Excluir"><i class="fa fa-times"></i></a>
	                            </c:if>
                              </div>
                            </div>
                          </div>
                          <div class="caption">
                            <p>${ ban.produto.nome_pro }</p>
                          </div>
                        </div>
                      </div>
                  	</c:forEach>
                  </div>
                </div>
			  </div>

	        <c:if test="${ permissao.criarBanner }">
              <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Adicionar <small>Banner</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					<!--	
					
							Formul�rio Create Aqui !!! -->
				<!--		Formul�rio		-->
				<form action="<c:url value="CreateBanner"/>" method="POST" class="form-horizontal form-label-left input_mask">

				<!--	Input sem �cone 	-->
				<div class="col-md-12 col-sm-12 col-xs-12 form-group">
				  <input type="hidden" name="arquivo_ban" class="form-control" placeholder="Arquivo Banner" title="Arquivo Banner" value="3.jpg">
				</div>

				<div class="col-md-12 col-sm-12 col-xs-12 form-group">
				  <select name="produto.id_produto" class="form-control">
					<c:forEach var="prod" items="${produtos}">
					  <option value="${ prod.id_produto }">${ prod.nome_pro }</option>
					</c:forEach>
				  </select>
				  <p>N�o encontrou o produto certo? <a href="<c:url value="/Admin/produto"/>">Clique Aqui!</a></p>
				</div>
				
				<!--	Booleano	-->
				<div class="col-md-12 col-sm-12 col-xs-12 form-group">
				  <label>
					<input type="checkbox" name="ativo_ban" class="js-switch"  title="Banner Ativo" value="${ ban.ativo_ban }"><i class="fa fa-eye"></i> Publicar
				  </label>
				</div>


				<!--	Bot�o de envio	-->
				<div class="btn-group pull-right">
				  <button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
					<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
				  </button>
				</div>
				
				</form>
				
				<!--	-->
                  </div>
                </div>
              </div>
              </c:if>
            </div>

<script type="text/javascript">

	edition_param	= "FindBanner";							// Find Controller Function
	delete_message	= 'quer mesmo deletar este banner?';	// Delete Message
	delete_param	= "DeleteBanner";						// Delete Controller Function
	restore_param	= "RestoreBanner";						// Restore Controller Function

</script>

<c:import url="../Footer.jsp" />
<script type="text/javascript" charset="utf-8" src="<c:url value="/resources/js/crud.js"/>"></script>

<div class="modal fade bs-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-md">
	<div class="modal-content">
	  <form action="<c:url value="UpdateBanner"/>" method="POST" class="form-horizontal form-label-left input_mask">
	  <!--								^^^^^^^^^^^	-->

		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">�</span>
	      </button>
	      <h4 class="modal-title" id="myModalLabel"><i class="fa fa-spinner fa-spin spin-load"></i> Banner</h4>
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