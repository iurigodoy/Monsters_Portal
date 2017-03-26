$(document).ready(function() {
	// Pega variável
	$(".ModalFuncionario").click(function() {
	 	var id			= $(this).data('id');
	  	// Função
	  	$.post("Find_Funcionario", {'id' : id}, function(resposta) {
			// Onde é escrito
			$("#conteudo_funcionario").html(resposta);
	  	});
	});
});