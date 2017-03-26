	$(".restore-button").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
     	
	    $.post("RestoreGrupoAtendimento", {'id' : id}, function(resposta) {
		      $("#restore_"+id).html(resposta);
		});
	});