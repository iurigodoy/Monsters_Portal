$(document).ready(function() {
	// Pega variável
	$(".ModalSetor").click(function() {
	     	var id			= $(this).data('id');
		// Função
	    $.post("Find_Setor", {'id' : id}, function(resposta) {
	      // Onde é escrito
	      $("#conteudo_setor").html(resposta);
		});
	});
	// Pega variável
	$(".ModalRamal").click(function() {
	     	var id			= $(this).data('id');
		// Função
	    $.post("Find_Ramal", {'id' : id}, function(resposta) {
	      // Onde é escrito
	      $("#conteudo_ramal").html(resposta);
		});
	});
});