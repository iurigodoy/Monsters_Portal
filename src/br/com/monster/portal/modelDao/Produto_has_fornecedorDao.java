package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Produto_has_fornecedor;

public interface Produto_has_fornecedorDao {
	Produto_has_fornecedor recarrega(Long id_prod, Long id_forn);
	Produto_has_fornecedor findOnePublic(Long id);
	
}