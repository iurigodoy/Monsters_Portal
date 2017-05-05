package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Cargo;

public interface CargoDao extends MetodosBasicos {
	
	void create(Cargo cargo);
	void update(Cargo cargo);
	
}