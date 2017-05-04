<!-- tabela normal -->
<c:if test="${ not obj.deleted }">
  <tr id="tr_${ obj.id_objeto }" data-history="1">
	<td>${ obj.atributo }</td>
	<td>${ obj.atributo }</td>
	<td>${ obj.atributo }</td>
	<td>${ obj.atributo }</td>
	<!-- Botões editar e excluir da tabela normal -->
	<td>
	  <div class="edition-buttons" id="edition-buttons_${ obj.id_objeto }">
		<button type="button" data-id="${ obj.id_objeto }" class="btn btn-primary btn-xs Modal"
			data-toggle="modal" data-target=".bs-modal" title="Editar"><i class="fa fa-pencil"></i> Editar</button>
		<button type="button" data-id="${ obj.id_objeto }" class="btn btn-danger btn-xs delete-button"><i class="fa fa-trash-o"></i> Excluir</button>
		<!--						(2) ^^^^^^^^^^^^^^^^^^^ 	-->
	  </div>
	</td>
  </tr>
</c:if>

<!-- tabela histórico -->
<c:if test="${ obj.deleted }">
  <tr id="tr_${ obj.id_objeto }" data-history="0">
  <!-- 			^^^^^^^^^^^^^ -->
	<td>${ obj.atributo }</td>
	<td>${ obj.atributo }</td>
	<td>${ obj.atributo }</td>
	<td>${ obj.atributo }</td>
	<!-- Botão restaurar da tabela histórico, para objetos excuidos -->
	<td>
	  <button type="button"							 	data-id="${ obj.id_objeto }"
		class="btn btn-success btn-xs restore-button" id="restore_${ obj.id_objeto }">
		<!--													 (2) ^^^^^^^^^^^^^^^^^^^	-->
	  <i class="fa fa-refresh"></i> Restaurar</button>
	</td>
  </tr>
</c:if>

<!-- Ambas tabelas devem estar dentro do mesmo ForEach -->

<!-- formulário de adição -->

<!-- insira ANTES do footer -->

<script type="text/javascript">

	edition_param	= "Find_Funcionario";						// Find Controller Function
	delete_message	= 'quer mesmo deletar este funcionário?';	// Delete Message
	delete_param	= "DeleteFuncionario";						// Delete Controller Function
	restore_param	= "RestoreFuncionario";						// Restore Controller Function

</script>
<!-- import footer -->
<!-- script crud -->
<!-- ... modal de edição ... -->