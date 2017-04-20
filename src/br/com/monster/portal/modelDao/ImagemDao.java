package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Imagem;

public interface ImagemDao {
	
	void create(Imagem imagem);
	void update(Imagem imagem);
	Object findOne(Long id);
	void delete(Long id);
	// Imagem não pode ser restaurada
}