package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Fornecedor;

public interface FornecedorDao extends MetodosBasicos {
	
	void create(Fornecedor fornecedor);
	void update(Fornecedor fornecedor);
	
}