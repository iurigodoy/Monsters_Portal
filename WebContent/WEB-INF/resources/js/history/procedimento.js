$(document).ready(function() {
	$(".toolbox-history-return").css("display", "none");

	// Pega variável
	$(".toolbox-history").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
		// Função
		$.post("History_Procedimento", {'id' : id}, function(resposta) {
			// Onde é escrito
			$("#ajax-content-table").html(resposta);
		});

		$(".toolbox-history").css("display", "none");
		$(".toolbox-history-return").css("display", "block");
	});


	// Pega variável
	$(".toolbox-history-return").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
		// Função
		$.post("History_Return_Procedimento", {'id' : id}, function(resposta) {
			// Onde é escrito
			$("#ajax-content-table").html(resposta);
		});

		$(".toolbox-history-return").css("display", "none");
		$(".toolbox-history").css("display", "block");
	});
});