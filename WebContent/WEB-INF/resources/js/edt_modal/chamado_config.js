                  $(document).ready(function() {
						// Pega variável
						$(".ModalRamoAtividade").click(function() {
	               	     	var id			= $(this).data('id');
							// Função
						    $.post("Find_RamoAtividade", {'id' : id}, function(resposta) {
						      // Onde é escrito
						      $("#conteudo_ramoatividade").html(resposta);
							});
						});
						// Pega variável
						$(".ModalCategoriaChamado").click(function() {
	               	     	var id			= $(this).data('id');
							// Função
						    $.post("Find_CategoriaChamado", {'id' : id}, function(resposta) {
						      // Onde é escrito
						      $("#conteudo_categoriachamado").html(resposta);
							});
						});
						// Pega variável
						$(".ModalProcedimento").click(function() {
	               	     	var id			= $(this).data('id');
							// Função
						    $.post("Find_Procedimento", {'id' : id}, function(resposta) {
						      // Onde é escrito
						      $("#conteudo_procedimento").html(resposta);
							});
						});
						// Pega variável
						$(".ModalTarefa").click(function() {
	               	     	var id			= $(this).data('id');
							// Função
						    $.post("Find_Tarefa", {'id' : id}, function(resposta) {
						      // Onde é escrito
						      $("#conteudo_tarefa").html(resposta);
							});
						});
                	});