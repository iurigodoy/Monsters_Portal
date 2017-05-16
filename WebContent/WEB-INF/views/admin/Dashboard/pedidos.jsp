<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="../Header.jsp" />

          <!-- top tiles -->
          <div class="row tile_count">
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Total Usu�rios</span>
              <div class="count green">
			<c:forEach var="cliente" items="${clientes}">${cliente}</c:forEach>
			</div>
              <span class="count_bottom"><i class="green">0% </i> Na �ltima semana</span>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-external-link-square"></i> Visitantes</span>
              <div class="count green">0</div>
              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>0% </i> Na �ltima semana</span>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-eye"></i> Visualiza��es</span>
              <div class="count green">0</div>
              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>0% </i> Na �ltima semana</span>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top blue"><i class="fa fa-male"></i> Homens</span>
              <div class="count"><c:forEach var="cliente_h" items="${clientes_h}">${cliente_h}</c:forEach></div>
              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>0% </i> Na �ltima semana</span>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top red"><i class="fa fa-female"></i> Mulheres</span>
              <div class="count"><c:forEach var="cliente_m" items="${clientes_m}">${cliente_m}</c:forEach></div>
              <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>0% </i> Na �ltima semana</span>
            </div>
            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top green"><i class="fa fa-money"></i> Compras</span>
              <div class="count">0</div>
              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>0% </i> Na �ltima semana</span>
            </div>
          </div>
          <!-- /top tiles -->

            <div class="clearfix"></div>

          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="dashboard_graph">

                <div class="row x_title">
                  <div class="col-md-6">
                    <h3>Pedidos Efetuados <small>Esta Semana</small></h3>
                  </div>
                  <div class="col-md-6">
                    <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                      <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                      <span>01 de Janeiro, 2017 - 31 de Dezembro, 2017</span> <b class="caret"></b>
                    </div>
                  </div>
                </div>

                <div class="col-md-9 col-sm-9 col-xs-12">
                  <div id="placeholder33" style="height: 260px; display: none" class="demo-placeholder"></div>
                  <div style="width: 100%;">
                    <div id="canvas_dahs" class="demo-placeholder" style="width: 100%; height:270px;"></div>
                  </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-12 bg-white">
                  <div class="x_title">
                    <h2><i class="fa fa-envelope"></i> Campanhas</h2>
                    <div class="clearfix"></div>
                  </div>

                  <div class="col-md-12 col-sm-12 col-xs-6">
                    <div>
                      <p>Campanha 1</p>
                      <div class="">
                        <div class="progress progress_sm" style="width: 76%;">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="80"></div>
                        </div>
                      </div>
                    </div>
                    <div>
                      <p>Campanha 2</p>
                      <div class="">
                        <div class="progress progress_sm" style="width: 76%;">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="60"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-12 col-sm-12 col-xs-6">
                    <div>
                      <p>Campanha 3</p>
                      <div class="">
                        <div class="progress progress_sm" style="width: 76%;">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="40"></div>
                        </div>
                      </div>
                    </div>
                    <div>
                      <p>Campanha 4</p>
                      <div class="">
                        <div class="progress progress_sm" style="width: 76%;">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="50"></div>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>

                <div class="clearfix"></div>
              </div>
            </div>

          </div>
          <br />

		  <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="x_panel tile fixed_height_320 overflow_hidden">
                <div class="x_title">
                  <h2><i class="fa fa-gear"></i> Status dos Pedidos</h2>
                  <ul class="nav navbar-right panel_toolbox">
                  	<li><a></a></li>
                  	<li><a></a></li>
                  	<li><a></a></li>
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <table class="" style="width:100%">
                    <tr>
                      <th style="width:37%;">
                        <p>Principais</p>
                      </th>
                      <th>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                          <p class="">Status</p>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                          <p class="">Porcentagem</p>
                        </div>
                      </th>
                    </tr>
                    <tr>
                      <td>
                        <canvas id="canvas1" height="140" width="140" style="margin: 15px 10px 10px 0"></canvas>
                      </td>
                      <td>
                        <table class="tile_info">
                          <tr>
                            <td>
                              <p><i class="fa fa-square blue"></i>Entregue </p>
                            </td>
                            <td>50%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square aero"></i>Pendente </p>
                            </td>
                            <td>25%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square green"></i>Pago </p>
                            </td>
                            <td>10%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square purple"></i>Cancelado </p>
                            </td>
                            <td>10%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square red"></i>Devolvido </p>
                            </td>
                            <td>5%</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
            
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="x_panel tile fixed_height_320 overflow_hidden">
                <div class="x_title">
                  <h2><i class="fa fa-th"></i> Categorias <small>dos produtos</small></h2>
                  <ul class="nav navbar-right panel_toolbox">
                  	<li><a></a></li>
                  	<li><a></a></li>
                  	<li><a></a></li>
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <table class="" style="width:100%">
                    <tr>
                      <th style="width:37%;">
                        <p>Top 5</p>
                      </th>
                      <th>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                          <p class="">Categoria</p>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                          <p class="">Progresso</p>
                        </div>
                      </th>
                    </tr>
                    <tr>
                      <td>
                        <canvas id="canvas2" height="140" width="140" style="margin: 15px 10px 10px 0"></canvas>
                      </td>
                      <td>
                        <table class="tile_info">
                          <tr>
                            <td>
                              <p><i class="fa fa-square green"></i>Cat 1 </p>
                            </td>
                            <td>30%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square blue"></i>Cat 2 </p>
                            </td>
                            <td>25%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square aero"></i>Cat 3 </p>
                            </td>
                            <td>20%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square purple"></i>Cat 4 </p>
                            </td>
                            <td>15%</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square red"></i>Cat 5 </p>
                            </td>
                            <td>10%</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </div>
          
          <div class="row">

              <div class="col-md-4">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-cube"></i> Top Produtos</h2>
                    <ul class="nav navbar-right panel_toolbox">
	                  	<li><a></a></li>
	                  	<li><a></a></li>
	                  	<li><a></a></li>
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <article class="media event">
                      <a class="pull-left">
               			<span class="avatar"><img src="../resources/imagens/funcionarios/foto6.jpg" /></span>
                      </a>
                      <div class="media-body">
                        <a class="title">
                        	<i class="fa fa-star gold"></i><i class="fa fa-star gold"></i><i class="fa fa-star gold"></i><i class="fa fa-star gold"></i><i class="fa fa-star gold"></i>
	                        Item 1
                        </a>
                        <p> R$ 1000,00</p>
                      </div>
                    </article>
                  </div>
                </div>
              </div>

              <div class="col-md-4">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Top Clientes</h2>
                    <ul class="nav navbar-right panel_toolbox">
                  	  <li><a></a></li>
                  	  <li><a></a></li>
                  	  <li><a></a></li>
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <article class="media event">
                      <a class="pull-left">
               			<span class="avatar"><img src="../resources/imagens/funcionarios/foto6.jpg" /></span>
                      </a>
                      <div class="media-body">
                        <a class="title">Cliente 1 T�tulo</a>
                        <p> email: xxxxxxxxxx@hotmail.com </p>
                      </div>
                    </article>
                  </div>
                </div>
              </div>

              <div class="col-md-4">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-truck"></i> Top Fornecedores </h2>
                    <ul class="nav navbar-right panel_toolbox">
                  	  <li><a></a></li>
                  	  <li><a></a></li>
                  	  <li><a></a></li>
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <article class="media event">
                      <a class="pull-left">
               			<span class="avatar"><img src="../resources/imagens/funcionarios/foto6.jpg" /></span>
                      </a>
                      <div class="media-body">
                        <a class="title">Fornecedor 1 T�tulo</a>
                        <p> email: xxxxxxxxxx@gmail.com </p>
                      </div>
                    </article>
                  </div>
                </div>
              </div>
              
              
              
            </div>

<c:import url="../Footer.jsp" />

    <!-- Flot -->
    <script>
      $(document).ready(function() {
        var data1 = [
			<c:forEach var="pedido" items="${pedidos}">
			  <c:set var="DataPed" value="${fn:split(pedido[1], '-')}" />
		      [gd(${DataPed[0]}, ${DataPed[1]}, ${DataPed[2]}), ${pedido[0]}]<c:if test="${!loop.last}">,</c:if>
            </c:forEach>
        ];
        
        $("#canvas_dahs").length && $.plot($("#canvas_dahs"), [
          data1
        ], {
          series: {
            lines: {
              show: false,
              fill: true
            },
            splines: {
              show: true,
              tension: 0.4,
              lineWidth: 1,
              fill: 0.4
            },
            points: {
              radius: 0,
              show: true
            },
            shadowSize: 2
          },
          grid: {
            verticalLines: true,
            hoverable: true,
            clickable: true,
            tickColor: "#d5d5d5",
            borderWidth: 1,
            color: '#fff'
          },
          colors: ["rgba(38, 185, 154, 0.38)", "rgba(3, 88, 106, 0.38)"],
          xaxis: {
            tickColor: "rgba(51, 51, 51, 0.06)",
            mode: "time",
            tickSize: [1, "day"],
            //tickLength: 10,
            axisLabel: "Date",
            axisLabelUseCanvas: true,
            axisLabelFontSizePixels: 12,
            axisLabelFontFamily: 'Verdana, Arial',
            axisLabelPadding: 10
          },
          yaxis: {
            ticks: 8,
            tickColor: "rgba(51, 51, 51, 0.06)",
          },
          tooltip: false
        });

        function gd(year, month, day) {
          return new Date(year, month - 1, day).getTime();
        }
      });
    </script>
    <!-- /Flot -->
    
    

    <!-- Doughnut Chart Pedidos -->
    <script>
      $(document).ready(function(){
        var options = {
          legend: false,
          responsive: false
        };

        new Chart(document.getElementById("canvas1"), {
          type: 'doughnut',
          tooltipFillColor: "rgba(51, 51, 51, 0.55)",
          data: {
            labels: [
              "Entregue",
              "Pendente",
              "Pago",
              "Cancelado",
              "Devolvido"
            ],
            datasets: [{
              data: [50, 25, 10, 10, 5],
              backgroundColor: [
                "#3498DB",
                "#BDC3C7",
                "#26B99A",
                "#9B59B6",
                "#E74C3C"
              ],
              hoverBackgroundColor: [
                "#49A9EA",
                "#CFD4D8",
                "#36CAAB",
                "#B370CF",
                "#E95E4F"
              ]
            }]
          },
          options: options
        });
      });
    </script>
    <!-- /Doughnut Chart Pedidos -->
    
    

    <!-- Doughnut Chart Categorias -->
    <script>
      $(document).ready(function(){
        var options = {
          legend: false,
          responsive: false
        };

        new Chart(document.getElementById("canvas2"), {
          type: 'doughnut',
          tooltipFillColor: "rgba(51, 51, 51, 0.55)",
          data: {
            labels: [
              "Cat 1",
              "Cat 2",
              "Cat 3",
              "Cat 4",
              "Cat 5"
            ],
            datasets: [{
              data: [30, 25, 20, 15, 10],
              backgroundColor: [
                "#26B99A",
                "#3498DB",
                "#BDC3C7",
                "#9B59B6",
                "#E74C3C"
              ],
              hoverBackgroundColor: [
                "#36CAAB",
                "#49A9EA",
                "#CFD4D8",
                "#B370CF",
                "#E95E4F"
              ]
            }]
          },
          options: options
        });
      });
    </script>
    <!-- /Doughnut Chart Categorias -->
    
    
    
    <!-- bootstrap-daterangepicker -->
    <script>
      $(document).ready(function() {

        var cb = function(start, end, label) {
          console.log(start.toISOString(), end.toISOString(), label);
          $('#reportrange span').html(start.format('DD MMMM, YYYY') + ' - ' + end.format('DD MMMM, YYYY'));
        };

        var optionSet1 = {
          startDate: moment().subtract(29, 'days'),
          endDate: moment(),
          minDate: '01/01/2016',
          maxDate: '12/31/2030',
          dateLimit: {
            days: 60
          },
          showDropdowns: true,
          showWeekNumbers: true,
          timePicker: false,
          timePickerIncrement: 1,
          timePicker12Hour: true,
          ranges: {
            'Agora': [moment(), moment()],
            'Ontem': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Ultimos 7 Dias': [moment().subtract(6, 'days'), moment()],
            'Ultimos 30 Dias': [moment().subtract(29, 'days'), moment()],
            'No M�s': [moment().startOf('month'), moment().endOf('month')],
            'No M�s Passado': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          opens: 'left',
          buttonClasses: ['btn btn-default'],
          applyClass: 'btn-small btn-primary',
          cancelClass: 'btn-small',
          format: 'MM/DD/YYYY',
          separator: ' to ',
          locale: {
            applyLabel: 'Enviar',
            cancelLabel: 'Limpar',
            fromLabel: 'De',
            toLabel: 'Para',
            customRangeLabel: 'Custom',
            daysOfWeek: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sa'],
            monthNames: ['Janeiro', 'Fevereiro', 'Mar�o', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            firstDay: 1
          }
        };
        $('#reportrange span').html(moment().subtract(29, 'days').format('DD MMMM, YYYY') + ' - ' + moment().format('DD MMMM, YYYY'));
        $('#reportrange').daterangepicker(optionSet1, cb);
        $('#reportrange').on('show.daterangepicker', function() {
          console.log("show event fired");
        });
        $('#reportrange').on('hide.daterangepicker', function() {
          console.log("hide event fired");
        });
        $('#reportrange').on('apply.daterangepicker', function(ev, picker) {
          console.log("apply event fired, start/end dates are " + picker.startDate.format('DD MMMM, YYYY') + " to " + picker.endDate.format('DD MMMM, YYYY'));
        });
        $('#reportrange').on('cancel.daterangepicker', function(ev, picker) {
          console.log("cancel event fired");
        });
        $('#options1').click(function() {
          $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
        });
        $('#options2').click(function() {
          $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
        });
        $('#destroy').click(function() {
          $('#reportrange').data('daterangepicker').remove();
        });
      });
    </script>
    <!-- /bootstrap-daterangepicker -->