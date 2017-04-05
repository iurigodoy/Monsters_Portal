<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />
<style>
</style>
            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-cubes"></i> Produtos <button class="btn btn-default btn-sm blue"><span class="fa fa-plus"></span> Adicionar produto</button></h3>
              </div>
            </div>
            
            <ul><li class="red"> Deixar link claro </li><li class="red"> melhorar a letra </li></ul>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                  <div class="x_content">
                    <table id="datatable-descricao" class="table table-striped dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td>Imagem</td>
	                      <td>Nome</td>
	                      <td>Pre�o</td>
	                      <td>Status</td>
	                      <td></td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var="produto" items="${produtos}">
	                        <tr>
	                          <td>
								<c:forEach var="ima" items="${ pro.ima }">
							  		<img src="<c:url value="/resources/imagens/produtos/${ ima.arquivo_ima }"/>" class="avatar" alt="Avatar" >
								</c:forEach>
                              </td>
	                          <td>
	                         	<h4><a href="#" class="table-content-name link-blue">${ pro.nome_pro }</a></h4>
	                         	<h5 class="table-content-edit">
	                          	<a href="#" class="link-blue"><span class="fa fa-pencil"></span> Editar</a> |
	                          	<a href="#" class="link-red"><span class="fa fa-trash"></span> Excluir</a>	|
	                          	<a href="#" class="link-blue"><span class="fa fa-eye"></span> Visualizar</a>
	                          	</h5>
	                          </td>
	                          <td>R$ ${ pro.preco_pro }</td>
	                          <td>
	                          	<h3>
	                          	  <c:if test="${pro.publicado_pro}">
	                         		<i class="fa fa-eye green"		title="Publicado"				data-toggle="tooltip" data-placement="bottom"></i>	|	<!-- Green OR red -->
	                         	  </c:if>
	                          	  <c:if test="${not pro.publicado_pro}">
	                         		<i class="fa fa-eye"			title="N�o publicado"		data-toggle="tooltip" data-placement="bottom"></i>	|	<!-- Green OR red -->
	                         	  </c:if>
	                          	  <c:if test="${pro.destaque_pro}">
	                          		<i class="fa fa-desktop	green"	title="Em Destaque"				data-toggle="tooltip" data-placement="bottom"></i>	|	<!-- Green OR red -->
	                         	  </c:if>
	                          	  <c:if test="${not pro.destaque_pro}">
	                          		<i class="fa fa-desktop"		title="N�o destacado"	data-toggle="tooltip" data-placement="bottom"></i>	|	<!-- Green OR red -->
	                         	  </c:if>
	                          	  <c:if test="${pro.promocao_pro}">
	                          		<i class="fa fa-tag green"		title="Desconto de ${pro.desconto_pro}" data-toggle="tooltip" data-placement="bottom"></i>		<!-- Green OR red -->
	                         	  </c:if>
	                          	  <c:if test="${not pro.promocao_pro}">
	                          		<i class="fa fa-tag"			title="N�o est� em promo��o"	data-toggle="tooltip" data-placement="bottom"></i>		<!-- Green OR red -->
	                         	  </c:if>
	                          	</h3>
	                          </td>
	                          <td><small>criado em: xx/xx/xxxx<br>atualizado em: xx/xx/xxxx<br>deletado em: xx/xx/xxxx</small></td>
	                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>

                  </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />