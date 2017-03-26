	$(".restore-button").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
     	
	    $.post("RestoreTarefa", {'id' : id}, function(resposta) {
		      $("#restore_"+id).fadeOut();
		});
	});