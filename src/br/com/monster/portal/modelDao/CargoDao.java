package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Cargo;

public interface CargoDao extends MetodosBasicos {
	
	List<Cargo> Read();
	
	void create(Cargo cargo);
	void update(Cargo cargo);
	
}