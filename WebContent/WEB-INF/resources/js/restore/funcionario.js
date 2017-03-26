	$(".restore-button").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
     	
	    $.post("RestoreFuncionario", {'id' : id}, function(resposta) {
		      $("#restore_"+id).fadeOut();
		});
	});