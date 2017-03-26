<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-clone"></i> Banners </h3>
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
                    <h2><i class="fa fa-image"></i> Galeria de imagens</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					<c:forEach var="banner" items="${banners}">
                      <div class="col-md-6">
                        <div class="thumbnail">
                          <div class="image view view-first">
                            <img style="width: 100%; display: block;" src="<c:url value="/resources/imagens/banners/${ banner.arquivo_banner }"/>" alt="image" />
                            <div class="mask">
                              <p>${ banner.produto.nome_produto }</p>
                              <div class="tools tools-bottom">
                                <a href="#"><i class="fa fa-link"></i></a>
                                <a href="#"><i class="fa fa-pencil"></i></a>
                                <a href="#"><i class="fa fa-times"></i></a>
                              </div>
                            </div>
                          </div>
                          <div class="caption">
                            <p> <c:if test="${ banner.ativo_banner }"> Ativo </c:if>
                            	<c:if test="${ not banner.ativo_banner }"> Bloqueado </c:if>
                            - ${ banner.nome_banner }</p>
                          </div>
                        </div>
                      </div>
					</c:forEach>

                  </div>
                </div>
              </div>
              
              <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Adicionar Banner</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
				    <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
					  <input type="text" name="nome_banner" class="form-control has-feedback-left" placeholder="Nome do Banner" title="Nome do Banner">
				      <span class="fa fa-clone form-control-feedback left" aria-hidden="true"></span>
				    </div>
				    <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                          <select class="form-control" id="produto" multiple="multiple" name="produto.nome_produto">
			        		<c:forEach var="produto" items="${produtos}">
                            	<option value="${ produto.id_produto }">${ produto.nome_produto }</option>
							</c:forEach>
                          </select>
				    </div>
				    <div class="col-md-12 col-sm-12 col-xs-12 form-group">
				    	<input type="file">
				    </div>
				    <div class="col-md-12 col-sm-12 col-xs-12 form-group">
				    	<button class="btn btn-success pull-right"><i class="fa fa-success"></i> Salvar</button>
				    </div>
                  </div>
                </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />

    <!-- Select2 -->
    <script>
      $(document).ready(function() {
        $("#produto").select2({
          maximumSelectionLength: 1,
          placeholder: "Nome do Produto",
          allowClear: true
        });
      });
    </script>
    <!-- /Select2 -->