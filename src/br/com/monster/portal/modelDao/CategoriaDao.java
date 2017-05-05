package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Categoria;

public interface CategoriaDao extends MetodosBasicos {
	void create(Categoria categoria);
	void update(Categoria categoria);
}