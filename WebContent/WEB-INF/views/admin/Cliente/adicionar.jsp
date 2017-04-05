<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="../Header.jsp" />

            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-group"></i> Clientes </h3>
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
            
            <form action="CreateCliente" class="form-horizontal form-label-left input_mask">
            
              <div class="col-md-8 col-sm-12 col-xs-12">
              
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-user"></i> Pessoa Física</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="nome_cli" class="form-control has-feedback-left" placeholder="Nome" title="Nome">
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="cpf_cli" class="form-control has-feedback-left" placeholder="CPF" title="CPF">
                        <span class="fa fa-align-center form-control-feedback left" aria-hidden="true"></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                          <div class="radio">
                            <label>Sexo:</label>
                            <label>
                              <input type="radio" name="sexo_cli" class="flat" value="1"> Masculino
                            </label>
                            <label>
                              <input type="radio" name="sexo_cli" class="flat" value="0"> Feminino
                            </label>
                          </div>
                      </div>
                  </div>
                </div>
              
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-university"></i> Pessoa Jurídica <small>Empresa</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="razao_cli" class="form-control has-feedback-left" placeholder="Razão" title="Razão">
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="objetivo_cli" class="form-control has-feedback-left" placeholder="Objetivo" title="Objetivo">
                        <span class="fa fa-align-center form-control-feedback left" aria-hidden="true"></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="cnpj_cli" class="form-control has-feedback-left" placeholder="CNPJ" title="CNPJ">
                        <span class="fa fa-align-center form-control-feedback left" aria-hidden="true"></span>
                      </div>
                  </div>
                </div>
                
                
              </div>
              <div class="col-md-4 col-sm-12 col-xs-12">
              
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-phone"></i> Contato</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="email_cli" class="form-control has-feedback-left" placeholder="Email" title="Email">
                        <span class="fa fa-envelope-o form-control-feedback left" aria-hidden="true"></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="residencial_cli" class="form-control has-feedback-left" placeholder="Telefone" title="Telefone">
                        <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="celular_cli" class="form-control has-feedback-left" placeholder="Celular" title="Celular">
                        <span class="fa fa-mobile form-control-feedback left" aria-hidden="true"></span>
                      </div>
                  </div>
                </div>
              
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-globe"></i> Localização</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="col-md-6 col-sm-12 col-xs-12 form-group">
						<input id="cep" type="text" class="form-control cep" name="cep_cli" placeholder="CEP" title="CEP">
                      </div>
                      <div class="col-md-6 col-sm-12 col-xs-12 form-group">
						<select id="uf" class="form-control" name="estado_cli">
							<option value="">Estado
							<option value="AC">AC
							<option value="AL">AL
							<option value="AP">AP
							<option value="AM">AM
							<option value="BA">BA
							<option value="CE">CE
							<option value="DF">DF
							<option value="ES">ES
							<option value="GO">GO
							<option value="MA">MA
							<option value="MT">MT
							<option value="MS">MS
							<option value="MG">MG
							<option value="PA">PA
							<option value="PB">PB
							<option value="PR">PR
							<option value="PE">PE
							<option value="PI">PI
							<option value="RJ">RJ
							<option value="RN">RN
							<option value="RO">RO
							<option value="RS">RS
							<option value="RR">RR
							<option value="SC">SC
							<option value="SP">SP
							<option value="SE">SE
							<option value="TO">TO
						</select>
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
						<input name="cidade_cli" type="text" class="form-control" placeholder="Município" title="Município">
                      </div>
                      <div class="col-md-9 col-sm-12 col-xs-12 form-group">
						<input name="endereco_cli" type="text" class="form-control" placeholder="Endereço" title="Endereço">
                      </div>
                      <div class="col-md-3 col-sm-12 col-xs-12 form-group">
						<input name="numero_cli" type="text" class="form-control" placeholder="Nº" title="Nº">
                      </div>
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group">
						<input name="complemento_cli" type="text" class="form-control" placeholder="Complemento" title="Complemento">
                      </div>
                  </div>
                </div>
              
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-globe"></i> Newsletter</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="">
                      <label>
                    	<input type="checkbox" name="newsletter_cliente" class="js-switch" checked /> Receber NewsLetter
                      </label>
                  	</div>
                  </div>
                </div>
                
                
            </div>
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
							<div class="btn-group pull-right">
								<!--/****************************** EDITAR ******************************/-->
								<button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
									<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
								</button>
							</div>
				</div>
			  </div>
            
            </form>
            

<c:import url="../Footer.jsp" />