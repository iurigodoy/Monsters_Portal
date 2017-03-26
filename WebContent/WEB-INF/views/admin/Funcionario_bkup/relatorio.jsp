<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3>Relatório de Funcionários</h3>
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
                    <h2>Relatório <small>das tarefas dos funcionários</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      - - - 
                    </p>
                    <table id="datatable-descricao" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
	                      <td></td>
	                      <td></td>
	                      <td></td>
	                      <td></td>
	                      <td>#</td>
                        </tr>
                      </thead>
                      <tbody>
						<c:forEach var=" - - - " items="${ - - - s}">
	                        <tr>
	                          <td></td>
	                          <td></td>
	                          <td></td>
	                          <td></td>
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