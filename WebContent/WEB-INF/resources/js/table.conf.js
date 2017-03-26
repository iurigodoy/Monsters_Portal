

	$('#datatable-pt_br-responsivo').DataTable({
		
    	dom:
	        "<'row'<'col-sm-6'l><'col-sm-3'f><'col-sm-3 text-right'C>>" +
	        "<'row'<'col-sm-12'tr>>" +
	        "<'row'<'col-sm-5'i><'col-sm-7'p>>",
	        
    		language: {
    	        decimal: ",",
    	        
		        "sEmptyTable": "Nenhum registro encontrado",
		        "sInfo": "Mostrando de _START_ at&eacute _END_ de _TOTAL_ registros",
		        "sInfoEmpty": "Mostrando 0 at&eacute 0 de 0 registros",
		        "sInfoFiltered": "(Filtrados de _MAX_ registros)",
		        "sInfoPostFix": "",
		        "sInfoThousands": ".",
		        "sLengthMenu": "_MENU_ resultados por p&aacutegina",
		        "sLoadingRecords": "Carregando...",
		        "sProcessing": "Processando...",
		        "sZeroRecords": "Nenhum registro encontrado",
		        "sSearch": "Pesquisar",
		        "oPaginate": {
		            "sNext": "Pr&oacuteximo",
		            "sPrevious": "Anterior",
		            "sFirst": "Primeiro",
		            "sLast": "&Uacuteltimo"
		        },
		        "oAria": {
		            "sSortAscending": ": Ordenar colunas de forma ascendente",
		            "sSortDescending": ": Ordenar colunas de forma descendente"
		        }
		    }
    
    });