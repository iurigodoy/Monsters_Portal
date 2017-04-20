package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Fornecedor;

public interface FornecedorDao extends MetodosBasicos {
	
	List<Fornecedor> Read();
	
	void create(Fornecedor fornecedor);
	void update(Fornecedor fornecedor);
	
}