package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.ImagemMultiple;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;

public interface ProdutoDao extends MetodosBasicos {
	
	List<Produto> Read();
	List<Produto> Read_publico();
	List<Produto> Read_destacado();
	List<Produto> Find_By_Name(String nome_prod);
<<<<<<< HEAD
	List<Produto> FindManyPublic(String nome_prod);
	List<Produto> FindProdutoPorCategoria(Long id);
	Produto_has_fornecedor findOnePublic(Long id);
=======
	List<Produto> Find_publico(String nome_prod);
	List<Produto> Find_Many_publico(String nome_prod);
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
	
	void create(Produto produto, ImagemMultiple imagens);
	void update(Produto produto);
}