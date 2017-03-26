	$(".delete-button").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
    	
    	// Jquery confirm
     	$.confirm({
     		title: 'Você tem certeza?',
     	    content: 'quer mesmo deletar esta equipe? todos os chamados que estão sendo atendidos nesse momento serão cancelados!',
     	    //		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     	    type: 'red',
     	    typeAnimated: true,
     	    
     	    closeIcon: true,
     	    closeIconClass: 'fa fa-close',
     	    
     	    backgroundDismiss: true, // this will just close the modal
     	    
     	    buttons: {
     	        cancelar: {
     	            text: 'Não',
     	            keys: ['esc', 'n']
     	        },
     	        deletar: {
     	            text: 'Sim',
     	            keys: ['enter', 's'],
     	            btnClass: 'btn-red',

     	            action: function(){
	     	       	    $.post("DeleteGrupoAtendimento", {'id' : id}, function(resposta) {
	     	       	    	// Apagar
	     	       			$("#delete_row_"+id).html(resposta);
	     	       		});
     	            }
     	        },
     	    }
    	});
     	
	});