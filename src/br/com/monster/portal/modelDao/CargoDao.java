package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.model.Permissao;

public interface CargoDao extends MetodosBasicos {
	
	void create(Cargo cargo, Permissao permissao);
	void update(Cargo cargo, Permissao permissao);
	
}