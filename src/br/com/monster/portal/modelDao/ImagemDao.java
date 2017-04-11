package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Imagem;

public interface ImagemDao {
	
	Imagem Find_One(Long id);
	
	void create(Imagem imagem);
	void update(Imagem imagem);
	void delete(Long id);
	
}