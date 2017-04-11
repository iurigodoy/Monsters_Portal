package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Categoria;

public interface CategoriaDao {
	
	List<Categoria> Read();
	Categoria Find_One(Long id);
	Object Find_publico(String nome_categoria, Categoria categoria);
	List<Categoria> Find_produto_cat(String nome_categoria, Categoria categoria);
	
	void create(Categoria categoria);
	void update(Categoria categoria);
	void delete(Long id);
	void restore(Long id);
}