		$(".delete-button-setor").click(function() {
	    	// Pega variável
	     	var id			= $(this).data('id');
	    	
	    	// Jquery confirm
	     	$.confirm({
	     		title: 'Você tem certeza?',
	     	    content: '<i class="fa fa-exclamation-triangle"></i> Atenção: Apagar um Setor é apagar os Ramais que estão nele, fazendo com que os funcionários fiquem sem ramais para abrirem chamados.',
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
		     	   		    $.post("DeleteSetor", {'id' : id}, function(resposta) {
		     				      // Apagar
		     				      $("#setor_"+id).html(resposta);
		     				});
	     	            }
	     	        },
	     	    }
	    	});
		});

    	$(".delete-button-ramal").click(function() {
        	// Pega variável
         	var id			= $(this).data('id');
        	
        	// Jquery confirm
         	$.confirm({
         		title: 'Você tem certeza?',
         	    content: '<i class="fa fa-exclamation-triangle"></i> Atenção: Apagar um ramal fará com que um funcionário fique sem ramal para abrir chamados.',
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
	         	       	    $.post("DeleteRamal", {'id' : id}, function(resposta) {
	         	    		      // Apagar
	         	    		      $("#ramal_"+id).html(resposta);
	         	    		});
         	            }
         	        },
         	    }
        	});
         	
    	});