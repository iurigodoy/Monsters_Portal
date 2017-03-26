$(document).ready(function(){

	var table = $('#datatable-pt_br-responsivo').DataTable();
	
	
	/*
	 * -------------------------
	 *			HISTORY			
	 * -------------------------
	 */
	
	$(".toolbox-history-return, .restore-button").css("display", "none");
	
	$.fn.dataTable.ext.search.push(
      function(settings, data, dataIndex) {
          return $(table.row(dataIndex).node()).attr('data-history') == 1;
        }
    );
    table.draw();

	// Pega variável
	$(".toolbox-history").click(function() {
		
	    $.fn.dataTable.ext.search.pop();
	    table.draw();
		
		$(".toolbox-history, .edition-buttons").css("display", "none");
		$(".toolbox-history-return, .restore-button").css("display", "block");
	});


	// Pega variável
	$(".toolbox-history-return").click(function() {
		
		$.fn.dataTable.ext.search.push(
	      function(settings, data, dataIndex) {
	          return $(table.row(dataIndex).node()).attr('data-history') == 1;
	        }
	    );
	    table.draw();

		$(".toolbox-history, .edition-buttons").css("display", "block");
		$(".toolbox-history-return, .restore-button").css("display", "none");
	});
	
	/*
	 * ---------------------
	 *			EDIT		
	 * ---------------------
	 */
	
	// Pega variável
	$(".Modal").click(function() {
		// Load
		$(".spin-load").css("visibility", "visible");
		
	 	var id			= $(this).data('id');
	  	// Função
	  	$.post(edition_param, {'id' : id}, function(resposta) {
			// Onde é escrito
			$("#modal_content").html(resposta);
			$(".spin-load").css("visibility", "hidden");
	  	});
	});
});
/*
 * -------------------------
 *			DELETE			
 * -------------------------
 */

$(".delete-button").click(function() {
	// Pega variável
 	var id			= $(this).data('id');
	
	// Jquery confirm
 	$.confirm({
 		title: 'Você tem certeza?',
 	    content: delete_message,
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
     			    $.post(delete_param, {'id' : id}, function(resposta) {
   				      // Editar	  ^^^^^^^^^^^
   				      //$("#tr_"+id).fadeOut();
     			    	$("#tr_"+id).css('background-color','#f2dede');
     			    	$("#edition-buttons_"+id).remove();
     			    	//$("#edition-buttons_"+id).html(function(){ return'<button type="button" data-id="'+id+'" class="btn btn-success btn-xs restore-button" id="restore_'+id+'"> <i class="fa fa-refresh"></i> Restaurar</button>'});
   					});
 	            }
 	        },
 	    }
	});
});

/*
 * -------------------------
 *			RESTORE			
 * -------------------------
 */

$(".restore-button").click(function() {
	// Pega variável
 	var id			= $(this).data('id');
 	
    $.post(restore_param, {'id' : id}, function(resposta) {
	    //$("#restore_"+id).fadeOut();
	    $("#restore_"+id).remove();
	    $(".restore-info").fadeIn();
	});
 	
 	$("#tr_"+id).data('history') === 1;
});
