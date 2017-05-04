package br.com.monster.portal.modelDao;

import br.com.monster.portal.model.Categoria;

public interface CategoriaDao extends MetodosBasicos {
<<<<<<< HEAD
=======
	
	List<Categoria> Read();
	Object Find_publico(String nome_categoria, Categoria categoria);
	List<Categoria> Find_produto_cat(String nome_categoria, Categoria categoria);
	
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
	void create(Categoria categoria);
	void update(Categoria categoria);
}