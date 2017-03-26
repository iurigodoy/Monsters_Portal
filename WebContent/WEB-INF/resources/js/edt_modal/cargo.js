$(document).ready(function() {
	// Pega variável
	$(".ModalCargo").click(function() {
	 	var id			= $(this).data('id');
	  	// Função
	  	$.post("Find_Cargo", {'id' : id}, function(resposta) {
			// Onde é escrito
			$("#conteudo_cargo").html(resposta);
	  	});
	});
});