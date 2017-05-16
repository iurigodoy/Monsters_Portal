<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
						<div class="col-md-8 col-sm-8 col-xs-8"><h2>${cat.cat_nome}</h2></div>
						<div class="col-md-4 col-sm-4 col-xs-4">
						  <form>
							<input type="hidden" name="id_categoria" value="${ cat.id_categoria }">
							<button type="submit" class="btn btn-sm btn-danger pull-right" title="Salvar">
								<i class="glyphicon glyphicon-remove" style="font-size:12px;"></i> Excluir
							</button>
						  </form>
						</div>
                    </c:forEach>
				  </div>
                </div>
              </div>
			  
			  <!--	Padrões do Sistema	-->

	<input type="hidden" name="id_categoria"	value="${ categoria.id_categoria }"/>

			<!-- Propriedades de Tempo -->

	<input type="hidden" name="created_at"	value="<fmt:formatDate value="${ cat.created_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	<c:if test="${not empty cat.deleted_at}">
		<input type="hidden" name="deleted_at"	value="<fmt:formatDate value="${ cat.deleted_at }" pattern="yyyy/MM/dd HH:mm"/>"/>
	</c:if>
	<input type="hidden" name="deleted"		value="${ cat.deleted }"/>



	<p>
	Criado em:		<strong><fmt:formatDate value="${ cat.created_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Atualizado em:	<strong><fmt:formatDate value="${ cat.updated_at }" pattern="dd/MM/yyyy HH:mm"/></strong><br>
    Apagado em:		<strong><fmt:formatDate value="${ cat.deleted_at }" pattern="dd/MM/yyyy HH:mm"/></strong>
    </p>

			  
