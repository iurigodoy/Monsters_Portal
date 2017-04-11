package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Cargo;

public interface CargoDao {
	
	List<Cargo> Read();
	Cargo Find_One(Long id);
	
	void create(Cargo cargo);
	void update(Cargo cargo);
	void delete(Long id);
	void restore(Long id);
	
}