<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-th"></i> Categorias</h3>
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
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-edit"></i> Editar <small>Categorias</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					<c:forEach var="categoria" items="${categorias}">
						<div class="col-md-8 col-sm-8 col-xs-8"><h2>${categoria.nome_categoria}</h2></div>
						<div class="col-md-4 col-sm-4 col-xs-4">
						  <form>
							<input type="hidden" name="id_categoria" value="${ categoria.id_categoria }">
							<button type="submit" class="btn btn-sm btn-danger pull-right" title="Salvar">
								<i class="glyphicon glyphicon-remove" style="font-size:12px;"></i> Excluir
							</button>
						  </form>
						</div>
                    </c:forEach>
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
					  	<input type="hidden" name="conf_quantidade_categoria" value="1">
						<div class="modal-body">
						
						  <div class="row">
							  <div class="form-group">
								<input type="text" name="nome_categoria" class="form-control" placeholder="Coloque uma categoria  Ex. Samsung">
							  </div>
						  </div><!-- Fim Row -->
						  
						  <div class="row">
						  	<p>Declare uma dependencia</p>
							  <div class="form-group">
									<select name="hierarquia_categoria" class="form-control col-xs-8">
									<option value="">Nenhuma dependência
									<c:forEach var="categoria" items="${categorias}">
										<c:if test="${empty categoria.hierarquia_categoria}">
											<option value="${categoria.id_categoria}"> ${categoria.nome_categoria}
										</c:if>
									</c:forEach>
									</select>
							  </div>
							  <div class="form-group">
								<button class="btn btn-new btn-success form-control">Adicionar Categoria</button>
							  </div>
						  </div>
						</div>
					  </form>
					  
				  </div>
                </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />