<div id="select">
  <select class="selectpicker form-control" data-info="0">
	<option value="0">Selecione um xxxxxx</option>
	  <c:forEach var="obj" items="${objs}" varStatus="loop">
		<option value="${obj.id_objeto}">${ obj.nome_obj }</option>
	  </c:forEach>
  </select>
  <p>Selecione um xxxxxx</p>
</div>