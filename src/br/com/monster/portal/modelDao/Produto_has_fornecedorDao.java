package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Produto_has_fornecedor;

public interface Produto_has_fornecedorDao {
	
	Produto_has_fornecedor recarrega(Long id_prod, Long id_forn); // Seleciona o Produto do Fornecedor, o Produto e a Imagem
	Produto_has_fornecedor findOnePublic(Long id);
	
}