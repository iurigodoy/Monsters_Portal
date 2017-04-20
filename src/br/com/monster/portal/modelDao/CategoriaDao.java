package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Categoria;

public interface CategoriaDao extends MetodosBasicos {
	
	List<Categoria> Read();
	Object Find_publico(String nome_categoria, Categoria categoria);
	List<Categoria> Find_produto_cat(String nome_categoria, Categoria categoria);
	
	void create(Categoria categoria);
	void update(Categoria categoria);
}