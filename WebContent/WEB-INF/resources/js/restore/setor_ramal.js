
	$(".restore-button-setor").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
     	
	    $.post("RestoreSetor", {'id' : id}, function(resposta) {
		      // Apagar
		      $("#setor_"+id+"_restore").fadeOut();
		});
	});
	
	$(".restore-button-ramal").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
     	
	    $.post("RestoreRamal", {'id' : id}, function(resposta) {
		      // Apagar
		      $("#ramal_"+id+"_restore").fadeOut();
		});
	});