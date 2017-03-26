<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-road"></i> Pedidos </h3>
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

		<form action="CreatePedido" method="POST" class="form-horizontal">
            
			<div class="row">
              <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-cube"></i> Produtos</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="form-group">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                          <select class="select2_multiple form-control" multiple="multiple">
			        		<c:forEach var="produto" items="${produtos}">
                            	<option value="${ produto.id_produto }">${ produto.nome_produto }</option>
							</c:forEach>
                          </select>
                        </div>
                      </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Clientes</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                     <input type="text" id="cliente" name="nome_cliente" class="form-control has-feedback-left" placeholder="Nome Completo" title="Nome Completo">
                     <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                  </div>
                </div>
              </div>
            </div>
            
            
              
			<div class="row">
              <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-truck"></i> Calculo do Frete</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-money"></i> Preço Total</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                  </div>
                </div>
              </div>
            </div>
		</form>
    
		
<c:import url="../Footer.jsp" />
    
    <!-- jQuery autocomplete -->
    <script>
      $(document).ready(function() {
        var countries = {
        		<c:forEach var="cliente" items="${clientes}" varStatus="ContadorAutoComplete">
			 			nome_${ContadorAutoComplete.index}:"${cliente.nome_cliente}",
				</c:forEach>
		};
        var countriesArray = $.map(countries, function(value, key) {
          return {
            value: value,
            data: key
          };
        });

        // initialize autocomplete with custom appendTo
        $('#cliente').autocomplete({
          lookup: countriesArray
        });
      });
    </script>
    <!-- /jQuery autocomplete -->
    
    

    <!-- Select2 -->
    <script>
      $(document).ready(function() {
        $(".select2_multiple").select2({
          maximumSelectionLength: 1000,
          placeholder: "Nome do Produto",
          allowClear: true
        });
      });
    </script>
    <!-- /Select2 -->