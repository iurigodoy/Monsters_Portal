	$(".delete-button").click(function() {
    	// Pega variável
     	var id			= $(this).data('id');
    	
    	// Jquery confirm
     	$.confirm({
     		title: 'Você tem certeza?',
     	    content: 'quer mesmo deletar esta tarefa?',
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
		     	       	$.post("DeleteTarefa", {'id' : id}, function(resposta) {
		     	 		      // Apagar
		     	 		      $("#delete_row_"+id).fadeOut();
		     	 		});
     	            }
     	        },
     	    }
    	});
     	
	});