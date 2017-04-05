<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<div class="panel-body panel-body-banner">
			  <div class="row">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox">
				  
				  	<c:set var="count" value="0" scope="page" />
					<c:forEach var="banner" items="${banners}">
				
					  <div class="item <c:if test="${count == 1}">active</c:if>">
						<div class="row" align="center">
						  <div class="banner">
							<a href="Produtos/${ banner.produto.nome_produto }" title="${ banner.produto.nome_produto }">
								<img src="<c:url value="/resources/imagens/banners/${ banner.arquivo_banner }"/>" class="banner_img">
							</a>
						  </div>
						</div>
					  </div>
					  
					  <c:set var="count" value="${count + 1}" scope="page"/>
					  
					</c:forEach>
				  </div>
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				  <span class="sr-only">Anterior</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				  <span class="sr-only">Próximo</span>
				</a>
			  </div>
			</div>