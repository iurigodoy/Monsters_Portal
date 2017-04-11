package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Campanha;

public interface CampanhaDao {
	
	List< Campanha> Read();
	 Campanha Find_One(Long id);
	
	void create( Campanha campanha);
	void update( Campanha campanha);
	void delete(Long id);
	void restore(Long id);
	
}