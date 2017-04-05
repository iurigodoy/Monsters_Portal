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
                      <button class="btn btn-default" type="button">V�!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>
            
            <form class="form-horizontal form-label-left input_mask">
            
			<div class="row">
              <div class="col-md-8 col-sm-12 col-xs-12">
              
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-plus"></i> Adicionar <small>Produtos</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                        <input type="text" name="nome_pro" class="form-control has-feedback-left" id="inputSuccess2" placeholder="Nome do produto" title="Nome do produto">
                        <span class="fa fa-cube form-control-feedback left" aria-hidden="true"></span>
                      </div>
                  </div>
                </div>
                
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-align-left"></i> Descri��o</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      
	                  <div id="alerts"></div>
	                  <div class="btn-toolbar editor" data-role="editor-toolbar" data-target="#editor">
	                    <div class="btn-group">
	                      <a class="btn dropdown-toggle" data-toggle="dropdown" title="Fonte"><i class="fa fa-font"></i><b class="caret"></b></a>
	                      <ul class="dropdown-menu">
	                      </ul>
	                    </div>
	
	                    <div class="btn-group">
	                      <a class="btn dropdown-toggle" data-toggle="dropdown" title="Tamanho da fonte"><i class="fa fa-text-height"></i>&nbsp;<b class="caret"></b></a>
	                      <ul class="dropdown-menu">
	                        <li>
	                          <a data-edit="fontSize 5">
	                            <p style="font-size:17px">Grande</p>
	                          </a>
	                        </li>
	                        <li>
	                          <a data-edit="fontSize 3">
	                            <p style="font-size:14px">Normal</p>
	                          </a>
	                        </li>
	                        <li>
	                          <a data-edit="fontSize 1">
	                            <p style="font-size:11px">Pequeno</p>
	                          </a>
	                        </li>
	                      </ul>
	                    </div>
	
	                    <div class="btn-group">
	                      <a class="btn" data-edit="bold" title="Negrito (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>
	                      <a class="btn" data-edit="italic" title="It�lico (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
	                      <a class="btn" data-edit="strikethrough" title="Tachado"><i class="fa fa-strikethrough"></i></a>
	                      <a class="btn" data-edit="underline" title="Sublinhado (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>
	                    </div>
	
	                    <div class="btn-group">
	                      <a class="btn" data-edit="insertunorderedlist" title="Lista de Marcadores"><i class="fa fa-list-ul"></i></a>
	                      <a class="btn" data-edit="insertorderedlist" title="Lista de N�meros"><i class="fa fa-list-ol"></i></a>
	                      <a class="btn" data-edit="outdent" title="Reduzir Recuo (Shift+Tab)"><i class="fa fa-dedent"></i></a>
	                      <a class="btn" data-edit="indent" title="Recuo (Tab)"><i class="fa fa-indent"></i></a>
	                    </div>
	
	                    <div class="btn-group">
	                      <a class="btn" data-edit="justifyleft" title="Alinhado a esquerda (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
	                      <a class="btn" data-edit="justifycenter" title="Centralizado (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>
	                      <a class="btn" data-edit="justifyright" title="Alinhado a direita (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>
	                      <a class="btn" data-edit="justifyfull" title="Justificado (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>
	                    </div>
	
	                    <div class="btn-group">
	                      <a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="fa fa-link"></i></a>
	                      <div class="dropdown-menu input-append">
	                        <input class="span2" placeholder="URL" type="text" data-edit="createLink" />
	                        <button class="btn" type="button">Add</button>
	                      </div>
	                      <a class="btn" data-edit="unlink" title="Remover Hyperlink"><i class="fa fa-cut"></i></a>
	                    </div>
	
	                    <!-- <div class="btn-group">
	                      <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="fa fa-picture-o"></i></a>
	                      <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
	                    </div> -->
	
	                    <div class="btn-group">
	                      <a class="btn" data-edit="undo" title="Voltar (Ctrl/Cmd+Z)"><i class="fa fa-undo"></i></a>
	                      <a class="btn" data-edit="redo" title="Refazer (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
	                    </div>
	                  </div>
	
	                  <div id="editor" class="editor-wrapper"></div>
	
	                  <textarea name="descricao_pro" id="descr" style="display:none;"></textarea>
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-clone"></i> Imagem<small> dos Produtos</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-truck"></i> Log�stica<small> Limites de dimen��o peso e garantia</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
								<div class="form-group">
									<!-- Garantia -->
				                    <div class="col-md-6 col-sm-12 col-xs-12 form-group has-feedback">
				                      <input type="text" name="garantia_pro" class="form-control has-feedback-left" placeholder="Garantia (em dias, meses ou anos)" title="Garantia">
				                      <span class="fa fa-calendar form-control-feedback left" aria-hidden="true"></span>
				                    </div>
				                    
									<!-- Peso -->
				                    <div class="col-md-6 col-sm-12 col-xs-12 form-group has-feedback">
				                      <input type="text" name="peso_pro" class="form-control has-feedback-left" placeholder="Peso" title="Peso (kg)">
				                      <span class="fa fa-cube form-control-feedback left" aria-hidden="true"></span>
				                      <span class="form-control-feedback right" aria-hidden="true">(kg)</span>
				                    </div>
								</div>
								
								<!-- Dimens�o -->
								<div class="row">
									<div class="col-xs-12">
										<label class="col-md-12 col-sm-12 col-xs-12 col-form-label">Dimens�es: </label>
									</div>
									
				                    <div class="col-md-4 col-sm-12 col-xs-12 form-group has-feedback">
				                      <input type="text" name="altura_pro" class="form-control has-feedback-left" placeholder="Altura" title="Altura (Cm)">
				                      <span class="fa fa-arrows-v form-control-feedback left" aria-hidden="true"></span>
				                      <span class="form-control-feedback right" aria-hidden="true">(Cm)</span>
				                    </div>
									
				                    <div class="col-md-4 col-sm-12 col-xs-12 form-group has-feedback">
				                      <input type="text" name="largura_pro" class="form-control has-feedback-left" placeholder="Largura" title="Largura (Cm)">
				                      <span class="fa fa-arrows-h form-control-feedback left" aria-hidden="true"></span>
				                      <span class="form-control-feedback right" aria-hidden="true">(Cm)</span>
				                    </div>
				                    
				                    <div class="col-md-4 col-sm-12 col-xs-12 form-group has-feedback">
				                      <input type="text" name="comprimento_pro" class="form-control has-feedback-left" placeholder="Comprimento" title="Comprimento (Cm)">
				                      <span class="form-control-feedback right" aria-hidden="true">(Cm)</span>
				                    </div>
								</div>
                  </div>
                </div>
              </div>
              
              
              <div class="col-md-4 col-sm-12 col-xs-12">
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-eye"></i> Publicar</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<p>Deseja exibir o produto para os clientes da loja?</p>
					<div class="btn-group pull-right" data-toggle="buttons">
						<label class="btn btn-primary btn-sm">
							<input type="radio"	name="publicado_pro" value="1">SIM
						</label>
						<label class="btn btn-primary btn-sm active">
							<input type="radio"	name="publicado_pro" value="0" checked>N�O
						</label>
					</div>
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-money"></i> Pre�o</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                  		<input type="text" name="preco_pro" value="${ pro.preco_pro }" class="form-control has-feedback-left preco_toolspin" placeholder="Pre�o" title="Pre�o">
				        <span class="form-control-feedback left" aria-hidden="true">R$</span>
                    </div>
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-laptop"></i> Destaque</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<p>Deseja destacar o produto, colocando-o na p�gina inicial do site?</p>
					<div class="btn-group pull-right" data-toggle="buttons">
						<label class="btn btn-primary btn-sm">
							<input type="radio"	name="destaque_pro" value="1">SIM
						</label>
						<label class="btn btn-primary btn-sm active">
							<input type="radio"	name="destaque_pro" value="0" checked>N�O
						</label>
					</div>
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-sort-amount-desc"></i> Desconto</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<p>Quanto deseja descontar do pre�o total?</p>
					<!-- Desconto -->
					<div class="form-group">
                        <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                            <input type="text" name="desconto_pro" value="${ pro.desconto_pro }" class="form-control has-feedback" placeholder="Desconto" title="Desconto">
				            <span class="form-control-feedback right" aria-hidden="true">(%)</span>
                        </div>
					</div>
                  	<p>Deseja aplicar o desconto?</p>
					<div class="btn-group pull-right" data-toggle="buttons">
						<label class="btn btn-primary btn-sm">
							<input type="radio"	name="promocao_pro" value="1">SIM
						</label>
						<label class="btn btn-primary btn-sm active">
							<input type="radio"	name="promocao_pro" value="0" checked>N�O
						</label>
					</div>
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-th"></i> Categoria</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<p>A qual categoria esse produto pertence?</p>
										  <!-- Marca -->
										  <select class="form-control" name="cat.id_categoria">
											<!-- mostra categorias, se a categoria for diferente da categoria j� existente no produto ele exibir� -->
												<c:forEach var="categoria" items="${categorias}">
												
												  <c:if test="${ cat.id_categoria == pro.cat.id_categoria}">
													<option value="${ cat.id_categoria }" selected>${cat.nome_cat }
												  </c:if>
												  
												  <c:if test="${ cat.id_categoria ne produto.cat.id_categoria}">
													<option value="${ cat.id_categoria }">${cat.nome_cat }
												  </c:if>
												  
												</c:forEach>
										  </select>
                  </div>
                </div>
                
                <div class="x_panel">
                  <div class="x_title">
                    <h2><i class="fa fa-truck"></i> Fornecedor</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<p>A quem o produto pertence?</p>
										  <!-- Marca -->
										  <select class="form-control" name="for.id_fornecedor">
											<!-- mostra categorias, se a categoria for diferente da categoria j� existente no produto ele exibir� -->
												<c:forEach var="fornecedor" items="${fornecedores}">
												
												  <c:if test="${ for.id_fornecedor == pro.for.id_fornecedor}">
													<option value="${ for.id_fornecedor }" selected>${for.nome_for }
												  </c:if>
												  
												  <c:if test="${ for.id_fornecedor ne produto.for.id_fornecedor}">
													<option value="${ for.id_fornecedor }">${for.nome_for }
												  </c:if>
												  
												</c:forEach>
										  </select>
                  </div>
                </div>
              </div>
			</div>
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
							<div class="btn-group pull-right">
								<!--/****************************** EDITAR PRODUTOS ******************************/-->
								<button type="submit" class="btn btn-sm btn-success pull-right" title="Salvar">
									<i class="glyphicon glyphicon-ok" style="font-size:12px;"></i> Salvar
								</button>
							</div>
				</div>
			  </div>
			
			</form>

<c:import url="../Footer.jsp" />


    <!-- bootstrap-wysiwyg -->
    <script>
      $(document).ready(function() {
        function initToolbarBootstrapBindings() {
          var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
              'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
              'Times New Roman', 'Verdana'
            ],
            fontTarget = $('[title=Fonte]').siblings('.dropdown-menu');
          $.each(fonts, function(idx, fontName) {
            fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
          });
          $('a[title]').tooltip({
            container: 'body'
          });
          $('.dropdown-menu input').click(function() {
              return false;
            })
            .change(function() {
              $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
            })
            .keydown('esc', function() {
              this.value = '';
              $(this).change();
            });

          $('[data-role=magic-overlay]').each(function() {
            var overlay = $(this),
              target = $(overlay.data('target'));
            overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
          });

          if ("onwebkitspeechchange" in document.createElement("input")) {
            var editorOffset = $('#editor').offset();

            $('.voiceBtn').css('position', 'absolute').offset({
              top: editorOffset.top,
              left: editorOffset.left + $('#editor').innerWidth() - 35
            });
          } else {
            $('.voiceBtn').hide();
          }
        }

        function showErrorAlert(reason, detail) {
          var msg = '';
          if (reason === 'unsupported-file-type') {
            msg = "Unsupported format " + detail;
          } else {
            console.log("error uploading file", reason, detail);
          }
          $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
        }

        initToolbarBootstrapBindings();

        $('#editor').wysiwyg({
          fileUploadError: showErrorAlert
        });

        window.prettyPrint;
        prettyPrint();
      });
    </script>
    <!-- /bootstrap-wysiwyg -->