<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-user"></i> Funcionário</h3>
              </div>
            </div>

            <div class="clearfix"></div>
            
			<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-pencil-square-o"></i> Relatório </h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<div id="ajax-content-table">
                 		<table  id="datatable-buttons" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
	                      <thead>
	                        <tr>
	                          <th>Data e Hora</th>
	                          <th>o(a) funcionário(a)</th>
	                          <th>executou a ação de</th>
	                          <th>sobre um</th>
	                        </tr>
	                      </thead>
	                      <tbody>
					  		<c:forEach var="rel" items="${relatorios}">
	                        <tr>
					  		  <td><fmt:formatDate value="${ rel.created_at }" pattern="dd/MM/yyyy HH:mm"/></td>
					  		  <td>${ rel.funcionario.nome_fun }</td>
					  		  <td>${ rel.metodo }</td>
					  		  <td>${ rel.entidade }</td>
					  		</tr>
                      		</c:forEach>
	                      </tbody>
	                    </table>
	              	</div>
                  </div>
                </div>
              </div>
            </div>

<c:import url="../Footer.jsp" />

    <!-- Datatables -->
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.print.min.js"/>"></script>
    <!-- <script src="<c:url value="/resources/vendors/jszip/dist/jszip.min.js"/>"></script> -->
    <script src="<c:url value="/resources/vendors/pdfmake/build/pdfmake.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/pdfmake/build/vfs_fonts.js"/>"></script>
    
<script>
$("#datatable-buttons").DataTable({
	  dom: "Bfrtip",
	  buttons: [
		{
		  extend: "copy",
		  className: "btn-sm"
		},
		{
		  extend: "csv",
		  className: "btn-sm"
		},
		{
		  extend: "excel",
		  className: "btn-sm"
		},
		{
		  extend: "pdfHtml5",
		  className: "btn-sm"
		},
		{
		  extend: "print",
		  className: "btn-sm"
		},
	  ],
	  responsive: true
});
</script>