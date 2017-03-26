<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-cubes"></i> Produtos</h3>
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
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Descrição prática <small>Default</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir produtos Excluidos</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Nome, preço e descrição dos produtos disponíveis no sistema.
                    </p>
                    <table id="datatable-descricao" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Imagem</td>
	                      <td>Nome</td>
	                      <td>Descrição</td>
	                      <td>Preço</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="produto" items="${produtos}">
	                        <tr>
	                          <td>
								<c:forEach var="imagem" items="${ produto.imagem }">
							  		<img src="<c:url value="/resources/imagens/produtos/${ imagem.arquivo_imagem }"/>" class="avatar" alt="Avatar" >
								</c:forEach>
                              </td>
	                          <td>${ produto.nome_produto }</td>
	                          <td><textarea rows="1" disabled>${ produto.descricao_produto }</textarea></td>
	                          <td>${ produto.preco_produto }</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Promoções e Destaques</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir produtos Excluidos</a>
                          </li>
                          <li><a href="#">Tornar Default</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Promoções, destaques e descontos dos produtos disponíveis no sistema.
                    </p>
                    <table id="datatable-promocional" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Nome</td>
	                      <td>Preço</td>
	                      <td>Publicado</td>
	                      <td>Destaque</td>
	                      <td>Desconto</td>
	                      <td>Promoção</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="produto" items="${produtos}">
	                        <tr>
	                          <td>${ produto.nome_produto }</td>
	                          <td>${ produto.preco_produto }</td>
	                          <td>${ produto.desconto_produto }%</td>
	                          <td>${ produto.publicado_produto }</td>
	                          <td>${ produto.destaque_produto }</td>
	                          <td>${ produto.promocao_produto }</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Descrição Técnica <smal>do produto</smal></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir produtos Excluidos</a>
                          </li>
                          <li><a href="#">Tornar Default</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Descrição detalhada dos produtos disponíveis no sistema.
                    </p>
                    <table id="datatable-descTec" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Nome</td>
	                      <td>Peso</td>
	                      <td>Altura</td>
	                      <td>Largura</td>
	                      <td>Comprimento</td>
	                      <td>Garantia</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="produto" items="${produtos}">
	                        <tr>
	                          <td>${ produto.nome_produto }</td>
	                          <td>${ produto.peso_produto }</td>
	                          <td>${ produto.altura_produto }</td>
	                          <td>${ produto.largura_produto }</td>
	                          <td>${ produto.comprimento_produto }</td>
	                          <td>${ produto.garantia_produto }</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Outras Informações <smal>Adicionais</smal></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Exibir produtos Excluidos</a>
                          </li>
                          <li><a href="#">Tornar Default</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Informações adicionais de fornecedores e categorias dos produtos disponíveis no sistema.
                    </p>
                    <table id="datatable-otherInfo" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Nome</td>
	                      <td>Fornecedor</td>
	                      <td>Categoria</td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="produto" items="${produtos}">
	                        <tr>
	                          <td>${ produto.nome_produto }</td>
	                          <td>${ produto.fornecedor.nome_fornecedor }</td>
	                          <td>${ produto.categoria.nome_categoria }</td>
	                          <td>
	                            <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> Editar </a>
	                            <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Deletar </a>
                              </td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
                </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />