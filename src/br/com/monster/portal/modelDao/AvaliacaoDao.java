package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Avaliacao;

public interface AvaliacaoDao {

	void create(Avaliacao avaliacao);
	void update(Avaliacao avaliacao);
	void delete(long id);
	
}